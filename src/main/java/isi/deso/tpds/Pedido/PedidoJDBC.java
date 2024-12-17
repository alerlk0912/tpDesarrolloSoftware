package isi.deso.tpds.Pedido;

import isi.deso.tpds.Categoria.Categoria;
import isi.deso.tpds.Coordenada.Coordenada;
import isi.deso.tpds.ItemMenu.ItemMenu;
import isi.deso.tpds.MetodoPago.*;
import isi.deso.tpds.BD.DatabaseConnection;
import isi.deso.tpds.Cliente.Cliente;
import isi.deso.tpds.Cliente.DAOCliente;
import isi.deso.tpds.ItemPedido.ItemsPedido;
import isi.deso.tpds.Vendedor.Vendedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class PedidoJDBC implements DAOPedido {
    private Connection connection;
    private final DAOCliente clienteDAO;
    private final DAOMetodoPago daoPago;

    public PedidoJDBC(DAOCliente daoCliente, DAOMetodoPago daoPago) {
        try {
            this.connection = DatabaseConnection.getInstance();
        } catch (SQLException e) {
            System.err.println("Error al conectar la base de datos: " + e.getMessage());
        }
        this.clienteDAO = daoCliente;
        this.daoPago = daoPago;
    }

    @Override
    public List<Pedido> listarPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT DISTINCT p.ID_Pedido, p.Estado, p.MontoBase, p.MontoTotal, p.FechaPago, p.ClienteID, p.PagoID " +
                "FROM pedido p " +
                "LEFT JOIN itemsPedido ip ON p.ID_Pedido = ip.PedidoID";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("ID_Pedido");
                String estado = rs.getString("Estado");
                double montoBase = rs.getDouble("MontoBase");
                double montoTotal = rs.getDouble("MontoTotal");
                Date fechaPago = rs.getDate("FechaPago");
                int clienteId = rs.getInt("ClienteID");
                int pagoId = rs.getInt("PagoID");

                Cliente cliente = clienteDAO.buscarClientePorId(clienteId);
                Pago metodoPago = daoPago.buscarPagoPorId(pagoId);

                Pedido pedido = new Pedido(cliente, metodoPago);
                pedido.setId(id);
                pedido.setEstado(EstadoPedido.valueOf(estado));
                pedido.setMontoBase(montoBase);
                pedido.setMontoTotal(montoTotal);
                pedido.setFechaPago(new java.util.Date(fechaPago.getTime()));
                pedido.setMetodoPago(metodoPago);

                // Cargar los ItemPedido para este pedido
                pedido.setItemsPedido(cargarItemsPedido(id));

                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar pedidos: " + e.getMessage());
        }
        return pedidos;
    }

    @Override
    public void crearPedido(Pedido pedido) throws SQLException {
        String sqlPago = "INSERT INTO pago (Metodo, cbu, cuit, alias) VALUES (?, ?, ?, ?)";
        String sqlPedido = "INSERT INTO pedido (Estado, MontoBase, MontoTotal, FechaPago, ClienteID, PagoID) VALUES (?, ?, ?, ?, ?, ?)";
        String sqlItemPedido = "INSERT INTO itemsPedido (cantidad, ItemMenuID, PedidoID) VALUES (?, ?, ?)";
        connection.setAutoCommit(false);

        // Inserción del pago
        int pagoId;
        try (PreparedStatement pstmtPago = connection.prepareStatement(sqlPago, Statement.RETURN_GENERATED_KEYS)) {
            String metodo = null;
            String cbu = null;
            String cuit = null;
            String alias = null;

            // Verificar el tipo de instancia del método de pago
            if (pedido.getMetodoPago() instanceof Efectivo) {
                metodo = "Efectivo";
                System.out.println("Método de pago: Efectivo");
            } else if (pedido.getMetodoPago() instanceof Transferencia) {
                metodo = "Transferencia";
                Transferencia transferencia = (Transferencia) pedido.getMetodoPago();
                cbu = transferencia.getCbu();  // Obtener el CBU de Transferencia
                cuit = transferencia.getCuit();  // Obtener el CUIT de Transferencia
                System.out.println("Método de pago: Transferencia, CBU: " + cbu);
            } else if (pedido.getMetodoPago() instanceof MercadoPago) {
                metodo = "MercadoPago";
                MercadoPago mercadoPago = (MercadoPago) pedido.getMetodoPago();
                alias = mercadoPago.getAlias();  // Obtener el alias de MercadoPago
                System.out.println("Método de pago: MercadoPago, CUIT: " + cuit + ", Alias: " + alias);
            }

            // Asegúrate de que el valor de 'metodo' esté correctamente asignado
            System.out.println("Método a insertar: " + metodo);

            // Establecer los parámetros de la consulta
            pstmtPago.setString(1, metodo);
            pstmtPago.setString(2, cbu);
            pstmtPago.setString(3, cuit);
            pstmtPago.setString(4, alias);

            pstmtPago.executeUpdate();

            // Obtener el ID del pago generado
            try (ResultSet rs = pstmtPago.getGeneratedKeys()) {
                if (rs.next()) {
                    pagoId = rs.getInt(1);
                } else {
                    throw new SQLException("Error al obtener el ID del pago.");
                }
            }

            // Inserción del pedido
            int pedidoId;
            try (PreparedStatement pstmtPedido = connection.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS)) {
                pstmtPedido.setString(1, pedido.getEstado().toString());
                pstmtPedido.setDouble(2, pedido.getMontoBase());
                pstmtPedido.setDouble(3, pedido.getMontoTotal());
                pstmtPedido.setDate(4, new java.sql.Date(System.currentTimeMillis()));
                pstmtPedido.setInt(5, pedido.getCliente().getId());
                pstmtPedido.setInt(6, pagoId);
                pstmtPedido.executeUpdate();
                try (ResultSet rs = pstmtPedido.getGeneratedKeys()) {
                    if (rs.next()) {
                        pedidoId = rs.getInt(1);
                    } else {
                        throw new SQLException("Error al obtener el ID del pedido.");
                    }
                }
            }

            // Inserción de los items del pedido
            try (PreparedStatement pstmtItem = connection.prepareStatement(sqlItemPedido)) {
                for (ItemsPedido item : pedido.getItemsPedido()) {
                    pstmtItem.setInt(1, item.getCantidad());
                    pstmtItem.setInt(2, item.getItemMenu().getId());
                    pstmtItem.setInt(3, pedidoId);
                    pstmtItem.addBatch();
                }
                pstmtItem.executeBatch();
            }

            connection.commit(); // Confirmar transacción
            System.out.println("Pedido creado con éxito: " + pedidoId);
        } catch (SQLException e) {
            try {
                connection.rollback(); // Revertir transacción en caso de error
            } catch (SQLException rollbackEx) {
                System.err.println("Error al hacer rollback: " + rollbackEx.getMessage());
            }
            System.err.println("Error al crear pedido: " + e.getMessage());
        }
    }

    @Override
    public void actualizarPedido(Pedido pedido) throws SQLException {
        String sqlInsertPago = "INSERT INTO pago (Metodo, cbu, cuit, alias) VALUES (?, ?, ?, ?)";
        String sqlCheckPago = "SELECT COUNT(*) FROM pago WHERE ID_Pago = ?";
        String sqlUpdatePedido = "UPDATE pedido SET Estado = ?, MontoBase = ?, MontoTotal = ?, FechaPago = ?, ClienteID = ?, PagoID = ? WHERE ID_Pedido = ?";
        String sqlDeleteItems = "DELETE FROM itemsPedido WHERE PedidoID = ?";
        String sqlInsertItems = "INSERT INTO itemsPedido (cantidad, ItemMenuID, PedidoID) VALUES (?, ?, ?)";

        connection.setAutoCommit(false);

        try {
            int pagoId = -1;

            // 1. Insertar el método de pago si no existe
            if (pedido.getMetodoPago() instanceof Efectivo) {
                pagoId = insertarPago(pedido, sqlInsertPago, "Efectivo", null, null, null);
            } else if (pedido.getMetodoPago() instanceof Transferencia transferencia) {
                pagoId = insertarPago(pedido, sqlInsertPago, "Transferencia", transferencia.getCbu(), transferencia.getCuit(), null);
            } else if (pedido.getMetodoPago() instanceof MercadoPago mercadoPago) {
                pagoId = insertarPago(pedido, sqlInsertPago, "MercadoPago", null, null, mercadoPago.getAlias());
            } else {
                throw new SQLException("Tipo de método de pago desconocido.");
            }

            // 2. Actualizar la tabla 'pedido'
            try (PreparedStatement pstmtPedido = connection.prepareStatement(sqlUpdatePedido)) {
                pstmtPedido.setString(1, pedido.getEstado().toString());
                pstmtPedido.setDouble(2, pedido.getMontoBase());
                pstmtPedido.setDouble(3, pedido.getMontoTotal());
                pstmtPedido.setDate(4, new java.sql.Date(pedido.getFechaPago().getTime()));
                pstmtPedido.setInt(5, pedido.getCliente().getId());
                pstmtPedido.setInt(6, pagoId);
                pstmtPedido.setInt(7, pedido.getId());
                pstmtPedido.executeUpdate();
            }

            // 3. Actualizar los ítems del pedido
            try (PreparedStatement pstmtDelete = connection.prepareStatement(sqlDeleteItems)) {
                pstmtDelete.setInt(1, pedido.getId());
                pstmtDelete.executeUpdate();
            }

            try (PreparedStatement pstmtInsert = connection.prepareStatement(sqlInsertItems)) {
                for (ItemsPedido item : pedido.getItemsPedido()) {
                    pstmtInsert.setInt(1, item.getCantidad());
                    pstmtInsert.setInt(2, item.getItemMenu().getId());
                    pstmtInsert.setInt(3, pedido.getId());
                    pstmtInsert.addBatch();
                }
                pstmtInsert.executeBatch();
            }

            // Confirmar la transacción
            connection.commit();
            System.out.println("Pedido actualizado correctamente con ID: " + pedido.getId());

        } catch (SQLException e) {
            connection.rollback();
            System.err.println("Error al actualizar el pedido: " + e.getMessage());
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    /**
     * Método auxiliar para insertar un pago en la base de datos y obtener su ID.
     */
    private int insertarPago(Pedido pedido, String sqlInsertPago, String metodo, String cbu, String cuit, String alias) throws SQLException {
        int pagoId;

        // Intentar insertar el pago
        try (PreparedStatement insertStmt = connection.prepareStatement(sqlInsertPago, Statement.RETURN_GENERATED_KEYS)) {
            insertStmt.setString(1, metodo);
            insertStmt.setString(2, cbu);
            insertStmt.setString(3, cuit);
            insertStmt.setString(4, alias);

            insertStmt.executeUpdate();

            // Obtener el ID del pago generado automáticamente
            try (ResultSet generatedKeys = insertStmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    pagoId = generatedKeys.getInt(1);
                    System.out.println("Nuevo PagoID generado: " + pagoId);

                    // Asignar el ID al método de pago correspondiente
                    if (pedido.getMetodoPago() instanceof Efectivo) {
                        ((Efectivo) pedido.getMetodoPago()).setId(pagoId);
                    } else if (pedido.getMetodoPago() instanceof Transferencia) {
                        ((Transferencia) pedido.getMetodoPago()).setId(pagoId);
                    } else if (pedido.getMetodoPago() instanceof MercadoPago) {
                        ((MercadoPago) pedido.getMetodoPago()).setId(pagoId);
                    }
                } else {
                    throw new SQLException("Error: No se pudo generar el ID para el pago.");
                }
            }
        }

        return pagoId;
    }


    @Override
    public void eliminarPedido(int id) {
        String sqlItemPedido = "DELETE FROM itemspedido WHERE PedidoID = ?";
        String sqlPedido = "DELETE FROM pedido WHERE ID_Pedido = ?";
        String sqlObtenerPago = "SELECT PagoID FROM pedido WHERE ID_Pedido = ?";
        String sqlEliminarPago = "DELETE FROM pago WHERE ID_Pago = ?";
        try (PreparedStatement stmtObtenerPago = connection.prepareStatement(sqlObtenerPago);
            PreparedStatement stmtEliminarPago = connection.prepareStatement(sqlEliminarPago);
            PreparedStatement stmtItemPedido = connection.prepareStatement(sqlItemPedido);
            PreparedStatement stmtPedido = connection.prepareStatement(sqlPedido)) {
            // Recuperar ID del pago asociado al pedido
            stmtObtenerPago.setInt(1, id);
            int idPago;
            try (ResultSet rs = stmtObtenerPago.executeQuery()) {
                idPago = -1;
                if (rs.next()) {
                    idPago = rs.getInt("PagoID");
                }
            }
            
            stmtItemPedido.setInt(1, id);
            stmtItemPedido.executeUpdate();
            
            stmtPedido.setInt(1, id);
            stmtPedido.executeUpdate();
            
            if (idPago != -1) {
                stmtEliminarPago.setInt(1, idPago);
                stmtEliminarPago.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar pedido: " + e.getMessage());
        }
    }

    @Override
    public Pedido buscarPedidoPorId(int id){
        String sql = "SELECT * FROM pedido WHERE ID_Pedido = ?";
        Pedido pedido = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {
                int clienteId = result.getInt("ClienteID");
                int metodoPagoId = result.getInt("PagoID");

                Cliente cliente = clienteDAO.buscarClientePorId(clienteId);
                Pago metodoPago = daoPago.buscarPagoPorId(metodoPagoId);

                pedido = new Pedido(cliente, metodoPago);
                pedido.setId(result.getInt("ID_Pedido"));
                pedido.setFechaPago(result.getDate("FechaPago"));
                pedido.setMontoTotal(result.getDouble("MontoTotal"));
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar pedido por ID: " + e.getMessage());
        }  
        return pedido;
    }

    private List<ItemsPedido> cargarItemsPedido(int pedidoId) {
        List<ItemsPedido> itemsPedido = new ArrayList<>();
        String sql = "SELECT ip.ID_ItemPedido, ip.cantidad, ip.ItemMenuID, " +
                "im.Nombre AS ItemNombre, im.Descripcion AS ItemDescripcion, im.Precio AS ItemPrecio, " +
                "c.ID_Categoria, c.Descripcion AS CategoriaDescripcion, c.Tipo_item AS TipoItem," +
                "v.ID_Vendedor, v.Nombre AS VendedorNombre, v.Direccion AS VendedorDireccion, " +
                "co.ID_Coordenada, co.Lat AS CoordenadaLat, co.Lng AS CoordenadaLng " +
                "FROM itemsPedido ip " +
                "JOIN itemmenu im ON ip.ItemMenuID = im.ID_ItemMenu " +
                "JOIN categoria c ON im.CategoriaID = c.ID_Categoria " +
                "JOIN itemmenu_vendedor iv ON ip.ItemMenuID = iv.ID_ItemMenu " +
                "JOIN vendedor v ON iv.ID_Vendedor = v.ID_Vendedor " +
                "JOIN coordenada co ON v.CoordenadaID = co.ID_Coordenada " +
                "WHERE ip.PedidoID = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, pedidoId);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    // Crear la categoría del ItemMenu
                    Categoria categoria = new Categoria(
                            rs.getInt("ID_Categoria"),
                            rs.getString("CategoriaDescripcion"),
                            rs.getString("TipoItem")
                    );
                    //itemMenu.setCategoria(categoria);

                    // Datos de Vendedor
                    int idVendedor = rs.getInt("ID_Vendedor");
                    String nombreVendedor = rs.getString("VendedorNombre");
                    String direccionVendedor = rs.getString("VendedorDireccion");

                    // Datos de Coordenada del Vendedor
                    Integer idCoordenada = rs.getObject("ID_Coordenada") != null ? rs.getInt("ID_Coordenada") : null;
                    Double latCoordenada = rs.getObject("CoordenadaLat") != null ? rs.getDouble("CoordenadaLat") : null;
                    Double lngCoordenada = rs.getObject("CoordenadaLng") != null ? rs.getDouble("CoordenadaLng") : null;
                    Coordenada coordenada = (idCoordenada != null && latCoordenada != null && lngCoordenada != null)
                            ? new Coordenada(idCoordenada, latCoordenada, lngCoordenada)
                            : null;


                    Vendedor vendedor = new Vendedor(idVendedor, nombreVendedor, direccionVendedor, coordenada);

                    // Crear un ItemMenu
                    ItemMenu itemMenu = new ItemMenu(
                            rs.getInt("ItemMenuID"),
                            rs.getString("ItemNombre"),
                            rs.getString("ItemDescripcion"),
                            rs.getDouble("ItemPrecio"),
                            categoria,
                            vendedor
                    ) {
                        @Override
                        public double peso() {
                            return 0;
                        }

                        @Override
                        public boolean esComida() {
                            return false;
                        }

                        @Override
                        public boolean esBebida() {
                            return false;
                        }

                        @Override
                        public boolean isAptoVegano() {
                            return false;
                        }
                    };

                    // Crear ItemsPedido
                    ItemsPedido itemPedido = new ItemsPedido(
                            rs.getInt("ID_ItemPedido"),
                            itemMenu,
                            rs.getInt("cantidad")
                    );

                    itemsPedido.add(itemPedido);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al cargar items de pedido: " + e.getMessage());
        }

        return itemsPedido;
    }
}

