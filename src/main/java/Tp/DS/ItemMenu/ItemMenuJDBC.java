package Tp.DS.ItemMenu;

import Tp.DS.BD.DatabaseConnection;
import Tp.DS.Plato;
import Tp.DS.Bebida;
import Tp.DS.Categoria.Categoria;
import Tp.DS.Categoria.DAOCategoria;
import Tp.DS.Exceptions.DAOException;
import Tp.DS.Vendedor.DAOVendedor;
import Tp.DS.Vendedor.Vendedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemMenuJDBC implements DAOItemMenu {
    private Connection connection;
    private DAOCategoria categoriaDAO;
    private DAOVendedor vendedorDAO;

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
    public List<ItemMenu> listarItemsMenu() throws DAOException {
        List<ItemMenu> items = new ArrayList<>();
        String sql = "SELECT itemmenu.ID_ItemMenu, itemmenu.Nombre, itemmenu.Descripcion, itemmenu.Precio, "
                + "categoria.ID_Categoria, categoria.Descripcion, categoria.Tipo_Item, "
                + "vendedor.ID_Vendedor, vendedor.Nombre, vendedor.Direccion, "
                + "bebida.Tamanio, bebida.GraduacionAlcoholica "
                + "FROM itemmenu "
                + "JOIN categoria ON itemmenu.CategoriaID = categoria.ID_Categoria "
                + "JOIN itemmenu_vendedor ON itemmenu.ID_ItemMenu = itemmenu_vendedor.ID_ItemMenu "
                + "JOIN vendedor ON itemmenu_vendedor.ID_Vendedor = vendedor.ID_Vendedor "
                + "JOIN bebida ON itemmenu.ID_ItemMenu = bebida.ItemMenuID";

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql);) {

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
                Vendedor vendedor = new Vendedor(idVendedor, nombreVendedor, direccionVendedor, null); // Coordenada omitida aquí

                // Atributos bebida
                Double tamanio = rs.getObject("Tamanio") != null ? rs.getDouble("Tamanio") : null;
                Boolean graduacionAlcoholica = rs.getObject("GraduacionAlcoholica") != null ? rs.getBoolean("GraduacionAlcoholica") : null;

                ItemMenu itemMenu = new Bebida(idItem, nombre, descripcion, precio, categoria, vendedor, tamanio, graduacionAlcoholica);
                items.add(itemMenu);
            }

        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        String sql2 = "SELECT itemmenu.ID_ItemMenu, itemmenu.Nombre, itemmenu.Descripcion, itemmenu.Precio, "
                + "categoria.ID_Categoria, categoria.Descripcion, categoria.Tipo_Item, "
                + "vendedor.ID_Vendedor, vendedor.Nombre, vendedor.Direccion, "
                + "plato.Peso, plato.Calorias, plato.AptoVegano "
                + "FROM itemmenu "
                + "JOIN categoria ON itemmenu.CategoriaID = categoria.ID_Categoria "
                + "JOIN itemmenu_vendedor ON itemmenu.ID_ItemMenu = itemmenu_vendedor.ID_ItemMenu "
                + "JOIN vendedor ON itemmenu_vendedor.ID_Vendedor = vendedor.ID_Vendedor "
                + "JOIN plato ON itemmenu.ID_ItemMenu = plato.ItemMenuID";

        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql2);) {

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
                Vendedor vendedor = new Vendedor(idVendedor, nombreVendedor, direccionVendedor, null); // Coordenada omitida aquí

                // Atributos plato
                Double peso = rs.getObject("Peso") != null ? rs.getDouble("Peso") : null;
                Double calorias = rs.getObject("Calorias") != null ? rs.getDouble("Calorias") : null;
                Boolean aptoVegano = rs.getObject("AptoVegano") != null ? rs.getBoolean("AptoVegano") : null;

                ItemMenu itemMenu = new Plato(idItem, nombre, descripcion, precio, categoria, vendedor, peso, calorias, aptoVegano);
                items.add(itemMenu);
            }

        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }

        return items;
    }
    
    @Override
    public void crearItemMenu(ItemMenu item) throws DAOException {
        String sqlItemMenu = "INSERT INTO itemmenu (Nombre, Descripcion, Precio, CategoriaID) VALUES (?, ?, ?, ?)";
        String sqlItemVendedor = "INSERT INTO itemmenu_vendedor (ID_ItemMenu, ID_Vendedor) VALUES (?, ?)";
        String sqlBebida = "INSERT INTO bebida (Tamanio, GraduacionAlcoholica, ItemMenuID) VALUES (?, ?, ?)";
        String sqlPlato = "INSERT INTO plato (Peso, Calorias, AptoVegano, ItemMenuID) VALUES (?, ?, ?, ?)";
        String sqlRecuperarIdCategoria = "SELECT * FROM categoria WHERE Tipo_Item = ?";
        // Insertar en itemmenu
        try (PreparedStatement stmtItemMenu = connection.prepareStatement(sqlItemMenu, Statement.RETURN_GENERATED_KEYS);
                PreparedStatement stmtItemVendedor = connection.prepareStatement(sqlItemVendedor);
                PreparedStatement stmtBebida = connection.prepareStatement(sqlBebida, Statement.RETURN_GENERATED_KEYS);
                PreparedStatement stmtPlato = connection.prepareStatement(sqlPlato, Statement.RETURN_GENERATED_KEYS);
                PreparedStatement stmtRecuperarIdCategoria = connection.prepareStatement(sqlRecuperarIdCategoria);) {
            stmtItemMenu.setString(1, item.getNombre());
            stmtItemMenu.setString(2, item.getDescripcion());
            stmtItemMenu.setDouble(3, item.getPrecio());
            
            stmtRecuperarIdCategoria.setString(1, item.getCategoria().getTipo_item());
            ResultSet rsRecuperarIdCategoria = stmtRecuperarIdCategoria.executeQuery();
            int idCategoria;
            if (rsRecuperarIdCategoria.next()) { // Verifica si hay resultados
                idCategoria = rsRecuperarIdCategoria.getInt("ID_Categoria");
            } else {
                throw new SQLException("No se encontró una categoría con el tipo proporcionado.");
            }
            stmtItemMenu.setInt(4, idCategoria);
            stmtItemMenu.executeUpdate();
            
            ResultSet generatedKeys = stmtItemMenu.getGeneratedKeys();
            // Insertar en itemmenu_vendedor
            if (generatedKeys.next()) {
                int itemMenuID = generatedKeys.getInt(1);
                stmtItemVendedor.setInt(1, itemMenuID);
                stmtItemVendedor.setInt(2, item.getVendedor().getId());
                stmtItemVendedor.executeUpdate();
                // Insertar en bebida o plato
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
            System.out.println("Error: "+ex.getMessage());
        }
    }
    
    @Override
    public void actualizarItemMenu(ItemMenu item, double tamanio, boolean alcholica, double peso, double calorias, boolean aptoVegano) throws DAOException {
        String sqlItemMenu = "UPDATE itemmenu SET Nombre = ?, Descripcion = ?, Precio = ?, CategoriaID = ? WHERE ID_ItemMenu = ?";
        String sqlBebida = "UPDATE bebida SET Tamanio = ?, GraduacionAlcoholica = ? WHERE ItemMenuID = ?";
        String sqlPlato = "UPDATE plato SET Peso = ?, Calorias = ?, AptoVegano = ? WHERE ItemMenuID = ?";
        String sqlRecuperarIdCategoria = "SELECT * FROM categoria WHERE Tipo_Item = ?";
        int idItemMenu = 0;
        // Actualizar en itemmenu
        try (PreparedStatement stmtItemMenu = connection.prepareStatement(sqlItemMenu);
            PreparedStatement stmtRecuperarIdCategoria = connection.prepareStatement(sqlRecuperarIdCategoria);) {
            stmtItemMenu.setString(1, item.getNombre());
            stmtItemMenu.setString(2, item.getDescripcion());
            stmtItemMenu.setDouble(3, item.getPrecio());
            
            stmtRecuperarIdCategoria.setString(1, item.getCategoria().getTipo_item());
            ResultSet rsRecuperarIdCategoria = stmtRecuperarIdCategoria.executeQuery();
            int idCategoria;
            if (rsRecuperarIdCategoria.next()) { // Verifica si hay resultados
                idCategoria = rsRecuperarIdCategoria.getInt("ID_Categoria");
            } else {
                throw new SQLException("No se encontró una categoría con el tipo proporcionado.");
            }
            stmtItemMenu.setInt(4, idCategoria);
            idItemMenu = item.getId();
            stmtItemMenu.setInt(5, item.getId());
            stmtItemMenu.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        // Actualizar en bebida o plato
        if (item instanceof Bebida) {
            try (PreparedStatement stmtBebida = connection.prepareStatement(sqlBebida)) {
                stmtBebida.setDouble(1, tamanio);
                stmtBebida.setBoolean(2, alcholica);
                stmtBebida.setInt(3, idItemMenu);
                stmtBebida.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Error: "+ex.getMessage());
            }
        } else if (item instanceof Plato) {
            try (PreparedStatement stmtPlato = connection.prepareStatement(sqlPlato)) {
                stmtPlato.setDouble(1, peso);
                stmtPlato.setDouble(2, calorias);
                stmtPlato.setBoolean(3, aptoVegano);
                stmtPlato.setInt(4, idItemMenu);
                stmtPlato.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Error: "+ex.getMessage());
            }
        }
    }
    
    @Override
    public void eliminarItemMenu(int id) throws DAOException {
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
    public ItemMenu buscarItemMenuPorId(int id) throws DAOException {
        ItemMenu itemMenu = null;
        String sql = "SELECT * FROM itemmenu "
                + "JOIN categoria ON itemmenu.CategoriaID = categoria.ID_Categoria "
                + "JOIN itemmenu_vendedor ON itemmenu.ID_ItemMenu = itemmenu_vendedor.ID_ItemMenu "
                + "JOIN vendedor ON itemmenu_vendedor.ID_Vendedor = vendedor.ID_Vendedor "
                + "JOIN bebida ON itemmenu.ID_ItemMenu = bebida.ItemMenuID "
                + "WHERE itemmenu.ID_ItemMenu = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
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
                    Vendedor vendedor = new Vendedor(idVendedor, nombreVendedor, direccionVendedor, null);
                    
                    // Atributos bebida
                    Double tamanio = rs.getObject("Tamanio") != null ? rs.getDouble("Tamanio") : null;
                    Boolean graduacionAlcoholica = rs.getObject("GraduacionAlcoholica") != null ? rs.getBoolean("GraduacionAlcoholica") : null;
                    itemMenu = new Bebida(id, nombre, descripcion, precio, categoria, vendedor, tamanio, graduacionAlcoholica);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
        String sql2 = "SELECT * FROM itemmenu "
                + "JOIN categoria ON itemmenu.CategoriaID = categoria.ID_Categoria "
                + "JOIN itemmenu_vendedor ON itemmenu.ID_ItemMenu = itemmenu_vendedor.ID_ItemMenu "
                + "JOIN vendedor ON itemmenu_vendedor.ID_Vendedor = vendedor.ID_Vendedor "
                + "JOIN plato ON itemmenu.ID_ItemMenu = plato.ItemMenuID "
                + "WHERE itemmenu.ID_ItemMenu = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql2)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
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
                    Vendedor vendedor = new Vendedor(idVendedor, nombreVendedor, direccionVendedor, null);
                    
                    // Atributos plato
                    Double peso = rs.getObject("Peso") != null ? rs.getDouble("Peso") : null;
                    Double calorias = rs.getObject("Calorias") != null ? rs.getDouble("Calorias") : null;
                    Boolean aptoVegano = rs.getObject("AptoVegano") != null ? rs.getBoolean("AptoVegano") : null;

                    itemMenu = new Plato(id, nombre, descripcion, precio, categoria, vendedor, peso, calorias, aptoVegano);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        return itemMenu;
    }

    @Override
    public List<ItemMenu> buscarItemsPorCriterios(int id, String nombre, double precio, String categoria, Vendedor vendedor) throws DAOException {
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
    public void actualizarItemMenu(ItemMenu item) throws DAOException {
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
                    // Datos específicos de plato
                    double peso = rs.getDouble("Peso");
                    double calorias = rs.getDouble("Calorias");
                    boolean aptoVegano = rs.getBoolean("AptoVegano");
                    plato = new Plato(0, null, null, 0, null, null, peso, calorias, aptoVegano);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
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
                    // Datos específicos de bebida
                    double tamanio = rs.getDouble("Tamanio");
                    boolean alcoholica = rs.getBoolean("GraduacionAlcoholica");
                    bebida = new Bebida(0, null, null, 0, null, null, tamanio, alcoholica);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }        
        return bebida;
    }
}
