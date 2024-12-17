package isi.deso.tpds.ItemMenu;

import isi.deso.tpds.BD.DatabaseConnection;
import isi.deso.tpds.Plato;
import isi.deso.tpds.Bebida;
import isi.deso.tpds.Categoria.Categoria;
import isi.deso.tpds.Categoria.DAOCategoria;
import isi.deso.tpds.Coordenada.Coordenada;
import isi.deso.tpds.Exceptions.DAOException;
import isi.deso.tpds.Vendedor.DAOVendedor;
import isi.deso.tpds.Vendedor.Vendedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemMenuJDBC implements DAOItemMenu {
    private Connection connection;
    private DAOCategoria categoriaDAO;
    private DAOVendedor vendedorDAO;

    public ItemMenuJDBC(DAOVendedor vendedorDAO) {
        try {
            this.connection = DatabaseConnection.getInstance();
        } catch (SQLException e) {
            System.err.println("Error al conectar la base de datos: " + e.getMessage());
        }
    }
    
    public ItemMenuJDBC(DAOCategoria categoriaDAO, DAOVendedor vendedorDAO) {
        try {
            this.connection = DatabaseConnection.getInstance();
        } catch (SQLException e) {
            System.err.println("Error al conectar la base de datos: " + e.getMessage());
        }
        this.categoriaDAO = categoriaDAO;
        this.vendedorDAO = vendedorDAO;
    }

    @Override
    public List<ItemMenu> listarItemsMenu() {
        List<ItemMenu> items = new ArrayList<>();
        String sql = "SELECT * FROM itemmenu "
                + "JOIN categoria ON itemmenu.CategoriaID = categoria.ID_Categoria "
                + "JOIN itemmenu_vendedor ON itemmenu.ID_ItemMenu = itemmenu_vendedor.ID_ItemMenu "
                + "JOIN vendedor ON itemmenu_vendedor.ID_Vendedor = vendedor.ID_Vendedor "
                + "JOIN bebida ON itemmenu.ID_ItemMenu = bebida.ItemMenuID "
                + "JOIN coordenada ON vendedor.CoordenadaID = coordenada.ID_Coordenada";

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int idItem = rs.getInt("ID_ItemMenu");
                String nombre = rs.getString("Nombre");
                String descripcion = rs.getString("Descripcion");
                double precio = rs.getDouble("Precio");

                // Categoría
                int idCategoria = rs.getInt("ID_Categoria");
                String descCategoria = rs.getString("Descripcion");
                String tipoItem = rs.getString("Tipo_Item");
                Categoria categoria = new Categoria(idCategoria, descCategoria, tipoItem);

                // Vendedor
                int idVendedor = rs.getInt("ID_Vendedor");
                String nombreVendedor = rs.getString("Nombre");
                String direccionVendedor = rs.getString("Direccion");

                //Coordenada
                int coordenadaVendedor = rs.getInt("CoordenadaID");
                double latCoorVendedor = rs.getDouble("Lat");
                double lngCoorVendedor = rs.getDouble("Lng");

                Coordenada coordenada = new Coordenada(coordenadaVendedor,latCoorVendedor, lngCoorVendedor);
                Vendedor vendedor = new Vendedor(idVendedor, nombreVendedor, direccionVendedor, coordenada);

                // Atributos bebida
                Double tamanio = rs.getObject("Tamanio") != null ? rs.getDouble("Tamanio") : null;
                Boolean graduacionAlcoholica = rs.getObject("GraduacionAlcoholica") != null ? rs.getBoolean("GraduacionAlcoholica") : null;

                ItemMenu itemMenu = new Bebida(idItem, nombre, descripcion, precio, categoria, tamanio, graduacionAlcoholica, vendedor);
                items.add(itemMenu);
            }

        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }

        String sql2 = "SELECT * FROM itemmenu "
                + "JOIN categoria ON itemmenu.CategoriaID = categoria.ID_Categoria "
                + "JOIN itemmenu_vendedor ON itemmenu.ID_ItemMenu = itemmenu_vendedor.ID_ItemMenu "
                + "JOIN vendedor ON itemmenu_vendedor.ID_Vendedor = vendedor.ID_Vendedor "
                + "JOIN plato ON itemmenu.ID_ItemMenu = plato.ItemMenuID "
                + "JOIN coordenada ON vendedor.CoordenadaID = coordenada.ID_Coordenada";

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql2)) {

            while (rs.next()) {
                int idItem = rs.getInt("ID_ItemMenu");
                String nombre = rs.getString("Nombre");
                String descripcion = rs.getString("Descripcion");
                double precio = rs.getDouble("Precio");

                // Categoría
                int idCategoria = rs.getInt("ID_Categoria");
                String descCategoria = rs.getString("Descripcion");
                String tipoItem = rs.getString("Tipo_Item");
                Categoria categoria = new Categoria(idCategoria, descCategoria, tipoItem);

                // Vendedor
                int idVendedor = rs.getInt("ID_Vendedor");
                String nombreVendedor = rs.getString("Nombre");
                String direccionVendedor = rs.getString("Direccion");

                //Coordenada
                int coordenadaVendedor = rs.getInt("CoordenadaID");
                double latCoorVendedor = rs.getDouble("Lat");
                double lngCoorVendedor = rs.getDouble("Lng");

                Coordenada coordenada = new Coordenada(coordenadaVendedor,latCoorVendedor, lngCoorVendedor);
                Vendedor vendedor = new Vendedor(idVendedor, nombreVendedor, direccionVendedor, coordenada);

                // Atributos plato
                Double peso = rs.getObject("Peso") != null ? rs.getDouble("Peso") : null;
                Double calorias = rs.getObject("Calorias") != null ? rs.getDouble("Calorias") : null;
                Boolean aptoVegano = rs.getObject("AptoVegano") != null ? rs.getBoolean("AptoVegano") : null;

                ItemMenu itemMenu = new Plato(idItem, nombre, descripcion, precio, categoria, peso, calorias, aptoVegano, vendedor);
                items.add(itemMenu);
            }

        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }

        return items;
    }

    @Override
    public void crearItemMenu(ItemMenu item) {
        String sqlItemMenu = "INSERT INTO itemmenu (Nombre, Descripcion, Precio, CategoriaID) VALUES (?, ?, ?, ?)";
        String sqlItemVendedor = "INSERT INTO itemmenu_vendedor (ID_ItemMenu, ID_Vendedor) VALUES (?, ?)";
        String sqlBebida = "INSERT INTO bebida (Tamanio, GraduacionAlcoholica, ItemMenuID) VALUES (?, ?, ?)";
        String sqlPlato = "INSERT INTO plato (Peso, Calorias, AptoVegano, ItemMenuID) VALUES (?, ?, ?, ?)";
        String sqlRecuperarIdCategoria = "SELECT * FROM categoria WHERE Tipo_Item = ?";

        try (PreparedStatement stmtItemMenu = connection.prepareStatement(sqlItemMenu, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement stmtItemVendedor = connection.prepareStatement(sqlItemVendedor);
             PreparedStatement stmtBebida = connection.prepareStatement(sqlBebida);
             PreparedStatement stmtPlato = connection.prepareStatement(sqlPlato);
             PreparedStatement stmtRecuperarIdCategoria = connection.prepareStatement(sqlRecuperarIdCategoria)) {

            // Asignar datos de ItemMenu
            stmtItemMenu.setString(1, item.getNombre());
            stmtItemMenu.setString(2, item.getDescripcion());
            stmtItemMenu.setDouble(3, item.getPrecio());

            stmtRecuperarIdCategoria.setString(1, item.getCategoria().getTipo_item());
            ResultSet rsRecuperarIdCategoria = stmtRecuperarIdCategoria.executeQuery();
            int idCategoria;
            if (rsRecuperarIdCategoria.next()) {
                idCategoria = rsRecuperarIdCategoria.getInt("ID_Categoria");
            } else {
                throw new SQLException("No se encontró una categoría con el tipo proporcionado.");
            }
            stmtItemMenu.setInt(4, idCategoria);
            stmtItemMenu.executeUpdate();

            ResultSet generatedKeys = stmtItemMenu.getGeneratedKeys();
            if (generatedKeys.next()) {
                int itemMenuID = generatedKeys.getInt(1);

                // Asignar vendedor
                stmtItemVendedor.setInt(1, itemMenuID);
                stmtItemVendedor.setInt(2, item.getVendedor().getId());
                stmtItemVendedor.executeUpdate();

                // Insertar en Bebida o Plato
                if (item instanceof Bebida) {
                    Bebida bebida = (Bebida) item;
                    stmtBebida.setDouble(1, bebida.getTamanio());
                    stmtBebida.setBoolean(2, bebida.isBebidaAlcoholica());
                    stmtBebida.setInt(3, itemMenuID);
                    stmtBebida.executeUpdate();
                } else if (item instanceof Plato) {
                    Plato plato = (Plato) item;
                    stmtPlato.setDouble(1, plato.getPeso());
                    stmtPlato.setDouble(2, plato.getCalorias());
                    stmtPlato.setBoolean(3, plato.isAptoVegano());
                    stmtPlato.setInt(4, itemMenuID);
                    stmtPlato.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al crear ItemMenu: " + ex.getMessage());
        }
    }

    @Override
    public void actualizarItemMenu(ItemMenu item, double tamanio, boolean alcholica, double peso, double calorias, boolean aptoVegano) throws DAOException {
        String sqlRecuperarIdCategoria = "SELECT ID_Categoria FROM categoria WHERE Tipo_Item = ?";
        String sqlActualizarItemMenu = "UPDATE itemmenu SET Nombre = ?, Descripcion = ?, Precio = ?, CategoriaID = ? WHERE ID_ItemMenu = ?";
        String sqlActualizarRelacionVendedor = "DELETE FROM itemmenu_vendedor WHERE ID_ItemMenu = ?";
        String sqlInsertarRelacionVendedor = "INSERT INTO itemmenu_vendedor (ID_ItemMenu, ID_Vendedor) VALUES (?, ?)";

        int idCategoria;

        try {
            // Recuperar ID de la categoría
            try (PreparedStatement stmtRecuperarIdCategoria = connection.prepareStatement(sqlRecuperarIdCategoria)) {
                stmtRecuperarIdCategoria.setString(1, item.getCategoria().getTipo_item());
                try (ResultSet rs = stmtRecuperarIdCategoria.executeQuery()) {
                    if (rs.next()) {
                        idCategoria = rs.getInt("ID_Categoria");
                    } else {
                        throw new SQLException("No se encontró una categoría con el tipo proporcionado.");
                    }
                }
            }

            connection.setAutoCommit(false); // Iniciar transacción

            // Actualizar los datos básicos del ItemMenu
            try (PreparedStatement stmtActualizarItemMenu = connection.prepareStatement(sqlActualizarItemMenu)) {
                stmtActualizarItemMenu.setString(1, item.getNombre());
                stmtActualizarItemMenu.setString(2, item.getDescripcion());
                stmtActualizarItemMenu.setDouble(3, item.getPrecio());
                stmtActualizarItemMenu.setInt(4, idCategoria);
                stmtActualizarItemMenu.setInt(5, item.getId());
                stmtActualizarItemMenu.executeUpdate();
            }

            // Eliminar y luego insertar la relación con el vendedor
            try (PreparedStatement stmtEliminarRelacion = connection.prepareStatement(sqlActualizarRelacionVendedor)) {
                stmtEliminarRelacion.setInt(1, item.getId());
                stmtEliminarRelacion.executeUpdate();
            }

            try (PreparedStatement stmtInsertarRelacion = connection.prepareStatement(sqlInsertarRelacionVendedor)) {
                stmtInsertarRelacion.setInt(1, item.getId());
                stmtInsertarRelacion.setInt(2, item.getVendedor().getId());
                stmtInsertarRelacion.executeUpdate();
            }

            // Actualizar datos específicos de Bebida o Plato
            if (item instanceof Bebida) {
                String sqlActualizarBebida = "UPDATE bebida SET Tamanio = ?, GraduacionAlcoholica = ? WHERE ItemMenuID = ?";
                try (PreparedStatement stmtActualizarBebida = connection.prepareStatement(sqlActualizarBebida)) {
                    stmtActualizarBebida.setDouble(1, tamanio);
                    stmtActualizarBebida.setBoolean(2, alcholica);
                    stmtActualizarBebida.setInt(3, item.getId());
                    stmtActualizarBebida.executeUpdate();
                }
            } else if (item instanceof Plato) {
                String sqlActualizarPlato = "UPDATE plato SET Peso = ?, Calorias = ?, AptoVegano = ? WHERE ItemMenuID = ?";
                try (PreparedStatement stmtActualizarPlato = connection.prepareStatement(sqlActualizarPlato)) {
                    stmtActualizarPlato.setDouble(1, peso);
                    stmtActualizarPlato.setDouble(2, calorias);
                    stmtActualizarPlato.setBoolean(3, aptoVegano);
                    stmtActualizarPlato.setInt(4, item.getId());
                    stmtActualizarPlato.executeUpdate();
                }
            }

            connection.commit(); // Confirmar transacción
        } catch (SQLException e) {
            try {
                connection.rollback(); // Revertir en caso de error
                System.err.println("Transacción revertida.");
            } catch (SQLException rollbackEx) {
                System.err.println("Error al hacer rollback: " + rollbackEx.getMessage());
            }
        } finally {
            try {
                connection.setAutoCommit(true); // Restaurar modo auto-commit
            } catch (SQLException e) {
                System.err.println("Error al restaurar auto-commit: " + e.getMessage());
            }
        }
    }

    @Override
    public void actualizarVendedorDeItemMenu(int itemMenuID, int nuevoVendedorID) {
        String sqlEliminarRelacion = "DELETE FROM itemmenu_vendedor WHERE ID_ItemMenu = ?";
        String sqlInsertarRelacion = "INSERT INTO itemmenu_vendedor (ID_ItemMenu, ID_Vendedor) VALUES (?, ?)";

        try {
            connection.setAutoCommit(false); // Iniciar transacción

            // Eliminar relación existente
            try (PreparedStatement stmtEliminar = connection.prepareStatement(sqlEliminarRelacion)) {
                stmtEliminar.setInt(1, itemMenuID);
                int rowsDeleted = stmtEliminar.executeUpdate();
                System.out.println("Relaciones eliminadas: " + rowsDeleted);
            }

            // Insertar nueva relación
            try (PreparedStatement stmtInsertar = connection.prepareStatement(sqlInsertarRelacion)) {
                stmtInsertar.setInt(1, itemMenuID);
                stmtInsertar.setInt(2, nuevoVendedorID);
                int rowsInserted = stmtInsertar.executeUpdate();
                System.out.println("Relaciones insertadas: " + rowsInserted);
            }

            connection.commit(); // Confirmar transacción
        } catch (SQLException e) {
            try {
                connection.rollback(); // Revertir en caso de error
                System.err.println("Transacción revertida.");
            } catch (SQLException rollbackEx) {
                System.err.println("Error al hacer rollback: " + rollbackEx.getMessage());
            }
        } finally {
            try {
                connection.setAutoCommit(true); // Restaurar modo auto-commit
            } catch (SQLException e) {
                System.err.println("Error al restaurar auto-commit: " + e.getMessage());
            }
        }
    }

    @Override
    public void eliminarItemMenu(int id) {
        String sqlEliminarBebida = "DELETE FROM bebida WHERE ItemMenuID = ?";
        String sqlEliminarPlato = "DELETE FROM plato WHERE ItemMenuID = ?";
        String sqlEliminarItemVendedor = "DELETE FROM itemmenu_vendedor WHERE ID_ItemMenu = ?";
        String sqlEliminarItemMenu = "DELETE FROM itemmenu WHERE ID_ItemMenu = ?";

        try {
            connection.setAutoCommit(false); // Iniciar transacción

            // Eliminar de bebida y plato según corresponda
            // Primero, verificar si es bebida o plato
            String sqlTipo = "SELECT c.Tipo_Item FROM itemmenu im JOIN categoria c ON im.CategoriaID = c.ID_Categoria WHERE im.ID_ItemMenu = ?";
            String tipoItem = null;

            try (PreparedStatement stmtTipo = connection.prepareStatement(sqlTipo)) {
                stmtTipo.setInt(1, id);
                try (ResultSet rs = stmtTipo.executeQuery()) {
                    if (rs.next()) {
                        tipoItem = rs.getString("Tipo_Item");
                    } else {
                        throw new DAOException("No se encontró el itemmenu con ID " + id);
                    }
                }
            }

            if ("BEBIDA".equalsIgnoreCase(tipoItem)) {
                try (PreparedStatement stmtBebida = connection.prepareStatement(sqlEliminarBebida)) {
                    stmtBebida.setInt(1, id);
                    stmtBebida.executeUpdate();
                }
            } else if ("PLATO".equalsIgnoreCase(tipoItem)) {
                try (PreparedStatement stmtPlato = connection.prepareStatement(sqlEliminarPlato)) {
                    stmtPlato.setInt(1, id);
                    stmtPlato.executeUpdate();
                }
            }

            // Eliminar de itemmenu_vendedor
            try (PreparedStatement stmtItemVendedor = connection.prepareStatement(sqlEliminarItemVendedor)) {
                stmtItemVendedor.setInt(1, id);
                stmtItemVendedor.executeUpdate();
            }

            // Eliminar de itemmenu
            try (PreparedStatement stmtItemMenu = connection.prepareStatement(sqlEliminarItemMenu)) {
                stmtItemMenu.setInt(1, id);
                stmtItemMenu.executeUpdate();
            }

            connection.commit(); // Confirmar transacción
        } catch (SQLException e) {
            try {
                connection.rollback(); // Revertir en caso de error
            } catch (SQLException ex) {
                System.out.println("Error: "+ex.getMessage());
            }
        } finally {
            try {
                connection.setAutoCommit(true); // Restaurar modo auto-commit
            } catch (SQLException e) {
                System.out.println("Error: "+e.getMessage());
            }
        }
    }

    @Override
    public ItemMenu buscarItemMenuPorId(int id) {
        ItemMenu itemMenu = null;
        String sql = "SELECT " +
                "    im.ID_ItemMenu, im.Nombre, im.Descripcion, im.Precio, " +
                "    c.ID_Categoria, c.Descripcion AS CategoriaDescripcion, c.Tipo_Item, " +
                "    v.ID_Vendedor, v.Nombre AS VendedorNombre, v.Direccion AS VendedorDireccion, " +
                "    co.ID_Coordenada, co.Lat AS CoordenadaLat, co.Lng AS CoordenadaLng, " +
                "    b.Tamanio, b.GraduacionAlcoholica, " +
                "    p.Peso, p.Calorias, p.AptoVegano " +
                "FROM " +
                "    itemmenu im " +
                "LEFT JOIN categoria c ON im.CategoriaID = c.ID_Categoria " +
                "LEFT JOIN itemmenu_vendedor iv ON im.ID_ItemMenu = iv.ID_ItemMenu " +
                "LEFT JOIN vendedor v ON iv.ID_Vendedor = v.ID_Vendedor " +
                "LEFT JOIN coordenada co ON v.CoordenadaID = co.ID_Coordenada " +
                "LEFT JOIN bebida b ON im.ID_ItemMenu = b.ItemMenuID " +
                "LEFT JOIN plato p ON im.ID_ItemMenu = p.ItemMenuID " +
                "WHERE im.ID_ItemMenu = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Datos básicos de ItemMenu
                    int idItemMenu = rs.getInt("ID_ItemMenu");
                    String nombre = rs.getString("Nombre");
                    String descripcion = rs.getString("Descripcion");
                    double precio = rs.getDouble("Precio");

                    // Datos de Categoría
                    int idCategoria = rs.getInt("ID_Categoria");
                    String descCategoria = rs.getString("CategoriaDescripcion");
                    String tipoItem = rs.getString("Tipo_Item");
                    Categoria categoria = new Categoria(idCategoria, descCategoria, tipoItem);

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

                    // Determinar si es Bebida o Plato
                    if (rs.getObject("Tamanio") != null) { // Es una Bebida
                        double tamanio = rs.getDouble("Tamanio");
                        boolean graduacionAlcoholica = rs.getBoolean("GraduacionAlcoholica");
                        itemMenu = new Bebida(idItemMenu, nombre, descripcion, precio, categoria, tamanio, graduacionAlcoholica, vendedor);
                    } else if (rs.getObject("Peso") != null) { // Es un Plato
                        double peso = rs.getDouble("Peso");
                        double calorias = rs.getDouble("Calorias");
                        boolean aptoVegano = rs.getBoolean("AptoVegano");
                        itemMenu = new Plato(idItemMenu, nombre, descripcion, precio, categoria, peso, calorias, aptoVegano, vendedor);
                    }
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al buscar ItemMenu: " + ex.getMessage());
        }

        return itemMenu;
    }

    @Override
    public List<ItemMenu> buscarItemsPorCriterios(int id, String nombre, double precio, String categoria, Vendedor vendedor) {
        return null;
        //No implementado
    }

    private List<Categoria> obtenerCategorias() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT ID_Categoria, Nombre, Tipo_Item FROM categoria";

        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Categoria categoria = new Categoria(rs.getString("Descripcion"),
                        rs.getString("Tipo_Item"));
                categoria.setId(rs.getInt("ID_Categoria"));

                categorias.add(categoria);
            }

        } catch (SQLException e) {
            throw new DAOException("Error al obtener categorías: " + e.getMessage());
        }
        return categorias;
    }
        public Categoria obtenerCategoriaPorTipo(String tipo) throws SQLException {
            List<Categoria> categorias = obtenerCategorias();
            return categorias.stream()
                .filter(c -> c.getTipo_item().equals(tipo))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void actualizarItemMenu(ItemMenu item) {
        //
    }

    @Override
    public Plato obtenerDatosPlato(int id) {
        Plato plato = null;
        String sql = "SELECT * FROM plato WHERE plato.ItemMenuID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    double peso = rs.getDouble("Peso");
                    double calorias = rs.getDouble("Calorias");
                    boolean aptoVegano = rs.getBoolean("AptoVegano");
                    plato = new Plato(null, null, 0, null, peso, calorias, aptoVegano, null);
                } else {
                    //System.out.println("No se encontraron datos para Plato con ID: " + id);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener datos de Plato: " + ex.getMessage());
        }
        return plato;
    }

    @Override
    public Bebida obtenerDatosBebida(int id) {
        Bebida bebida = null;
        String sql = "SELECT * FROM bebida WHERE bebida.ItemMenuID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    double tamanio = rs.getDouble("Tamanio");
                    boolean alcoholica = rs.getBoolean("GraduacionAlcoholica");
                    bebida = new Bebida(null, null, 0, null, tamanio, alcoholica, null);
                } else {
                    System.out.println("No se encontraron datos para Bebida con ID: " + id);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener datos de Bebida: " + ex.getMessage());
        }
        return bebida;
    }
}
