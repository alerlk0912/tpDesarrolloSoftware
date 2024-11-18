package Tp.DS.Pedido;

import Tp.DS.BD.DatabaseConnection;
import Tp.DS.Cliente.Cliente;
import Tp.DS.Cliente.DAOCliente;
import Tp.DS.ItemPedido.ItemsPedido;
import Tp.DS.MetodoPago.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoJDBC implements DAOPedido {
    private Connection connection;
    private DAOCliente clienteDAO;
    private DAOMetodoPago daoPago;

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
        String sql = "SELECT * FROM pedido "
                + "JOIN itemsPedido ON pedido.ID_Pedido = itemsPedido.PedidoID "
                + "JOIN pago ON pedido.PagoID = pago.ID_Pago "
                + "JOIN itemmenu ON itemsPedido.ItemMenuID = itemmenu.ID_ItemMenu";

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
                //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                //      HAY QUE SETEAR LOS ITEMS PEDIDOS, PARA ESO SE DEBE LLAMAR AL ITEM PEDIDO JDBC 
                //Y HACER UNA BANDA DE COSAS MÁS PARA QUE EL ITEM MENU SE VEA REFLEJADO EN LA TABLA DE PEDIDOS
                //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar pedidos: " + e.getMessage());
        }
        return pedidos;
    }

    @Override
    public void crearPedido(Pedido pedido) {
        String sqlPago = "INSERT INTO pago (Metodo, cbu, cuit, alias) VALUES (?, ?, ?, ?)";
        String sqlPedido = "INSERT INTO pedido (Estado, MontoBase, MontoTotal, FechaPago, ClienteID, PagoID) VALUES (?, ?, ?, ?, ?, ?)";
        String sqlItemPedido = "INSERT INTO itemsPedido (cantidad, ItemMenuID, PedidoID) VALUES (?, ?, ?)";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sqlPago, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, pedido.getCliente().getId());
            pstmt.setDate(2, new java.sql.Date(pedido.getFechaPago().getTime()));
            pstmt.setDouble(3, pedido.getMontoTotal());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Error en crearPedido: No se afectaron filas.");
            }

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    pedido.setId(generatedKeys.getInt(1)); 
                } else {
                    throw new SQLException("Error en crearPedido: No se generó ID.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al crear pedido: " + e.getMessage());
        }
    }

    

    @Override
    public void actualizarPedido(Pedido pedido){
        String sql = "UPDATE pedidos SET cliente_id = ?, fecha = ?, total = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, pedido.getCliente().getId());
            pstmt.setDate(2, new java.sql.Date(pedido.getFechaPago().getTime()));
            pstmt.setDouble(3, pedido.getMontoTotal());
            pstmt.setInt(4, pedido.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar pedido por ID: " + e.getMessage());
        } 
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
            PreparedStatement stmtPedido = connection.prepareStatement(sqlPedido);) {
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
        String sql = "SELECT * FROM pedidos WHERE id = ?";
        Pedido pedido = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {
                int clienteId = result.getInt("cliente_id");
                int metodoPagoId = result.getInt("pago_id");

                Cliente cliente = clienteDAO.buscarClientePorId(clienteId);
                Pago metodoPago = daoPago.buscarPagoPorId(metodoPagoId);

                pedido = new Pedido(cliente, metodoPago);
                pedido.setId(result.getInt("id"));
                pedido.setFechaPago(result.getDate("fecha"));
                pedido.setMontoTotal(result.getDouble("total"));
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar pedido por ID: " + e.getMessage());
        }  
        return pedido;
    }
}

