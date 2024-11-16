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
    public List<ItemMenu> listarItemsMenu() throws DAOException{
        List<ItemMenu> items = new ArrayList<>();
        String sql = "SELECT im.*, c.Tipo_Item FROM itemmenu im " +
                     "JOIN categoria c ON im.CategoriaID = c.ID_Categoria";

        try (Statement stmt = connection.createStatement();
             ResultSet result = stmt.executeQuery(sql)) {

            while (result.next()) {
                String tipoItem = result.getString("Tipo_Item");
                int categoriaId = result.getInt("CategoriaID");
                int vendedorId = result.getInt("VendedorID");

                Categoria categoria = categoriaDAO.buscarCategoriaPorId(categoriaId);
                Vendedor vendedor = vendedorDAO.buscarVendedorPorId(vendedorId);

                if ("Plato".equals(tipoItem)) {
                    items.add(crearPlato(result, categoria, vendedor));
                } else if ("Bebida".equals(tipoItem)) {
                    items.add(crearBebida(result, categoria, vendedor));
                } else {
                    throw new IllegalArgumentException("Tipo de item no válido: " + tipoItem);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar items de menú: " + e.getMessage());
        }
        return items;
    }

    @Override
    public void crearItemMenu(ItemMenu item) throws DAOException{
        validarTipoItemMenu(item);
        // SQL específico según el tipo
        String sqlPlato = "INSERT INTO itemmenu (Nombre, Descripcion, Precio, CategoriaID, VendedorID, Tipo, Peso, Calorias, AptoVegano) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlBebida = "INSERT INTO itemmenu (Nombre, Descripcion, Precio, CategoriaID, VendedorID, Tipo, Tamanio, GraduacionAlcoholica) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            String sql;
            if (item instanceof Plato) {
                sql = sqlPlato;
            } else if (item instanceof Bebida) {
                sql = sqlBebida;
            } else {
                throw new DAOException("Tipo de ítem no reconocido");
            }

            try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                
                pstmt.setString(1, item.getNombre());
                pstmt.setString(2, item.getDescripcion());
                pstmt.setDouble(3, item.getPrecio());
                pstmt.setInt(4, item.getCategoria().getId());
                pstmt.setInt(5, item.getVendedor().getId());
                pstmt.setString(6, item instanceof Plato ? "PLATO" : "BEBIDA");

                // Setear campos específicos según el tipo
                if (item instanceof Plato) {
                    Plato plato = (Plato) item;
                    pstmt.setDouble(7, plato.getPeso());
                    pstmt.setDouble(8, plato.getCalorias());
                    pstmt.setBoolean(9, plato.isAptoVegano());
                } else if (item instanceof Bebida) {
                    Bebida bebida = (Bebida) item;
                    pstmt.setDouble(7, bebida.getTamanio());
                    pstmt.setBoolean(8, bebida.isBebidaAlcoholica());
                }

                int affectedRows = pstmt.executeUpdate();
                if (affectedRows == 0) {
                    throw new DAOException("La creación del ítem de menú falló, no se insertaron filas.");
                }

                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        item.setId(generatedKeys.getInt(1));
                    } else {
                        throw new DAOException("La creación del ítem de menú falló, no se obtuvo ID.");
                    }
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Error al crear ítem de menú: " + e.getMessage());
        }
    }

    @Override
    public void actualizarItemMenu(ItemMenu item) throws DAOException{
        validarTipoItemMenu(item);
        String sqlPlato = "INSERT INTO itemmenu (Nombre, Descripcion, Precio, CategoriaID, VendedorID, Tipo, Peso, Calorias, AptoVegano) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlBebida = "INSERT INTO itemmenu (Nombre, Descripcion, Precio, CategoriaID, VendedorID, Tipo, Tamanio, GraduacionAlcoholica) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            String sql;
            if (item instanceof Plato) {
                sql = sqlPlato;
            } else if (item instanceof Bebida) {
                sql = sqlBebida;
            } else {
                throw new DAOException("Tipo de ítem no reconocido");
            }

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, item.getNombre());
            pstmt.setString(2, item.getDescripcion());
            pstmt.setDouble(3, item.getPrecio());
            pstmt.setInt(4, item.getCategoria().getId());
            pstmt.setInt(5, item.getVendedor().getId());
            pstmt.setString(6, item instanceof Plato ? "PLATO" : "BEBIDA");
            
            // Setear campos específicos según el tipo
            if (item instanceof Plato) {
                Plato plato = (Plato) item;
                pstmt.setDouble(7, plato.getPeso());
                pstmt.setDouble(8, plato.getCalorias());
                pstmt.setBoolean(9, plato.isAptoVegano());
            } else if (item instanceof Bebida) {
                Bebida bebida = (Bebida) item;
                pstmt.setDouble(7, bebida.getTamanio());
                pstmt.setBoolean(8, bebida.isBebidaAlcoholica());
            }
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("actualizarItemMenu falló, no hay filas afectadas");
            }
        }
        } catch (SQLException e) {
            System.err.println("Error al actualizar item de menú: " + e.getMessage());
        }
    }

    @Override
    public void eliminarItemMenu(int id) throws DAOException{
        String sql = "DELETE FROM itemmenu WHERE ID_ItemMenu = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar item de menú por ID: " + e.getMessage());
        }
    }

    @Override
    public ItemMenu buscarItemMenuPorId(int id) throws DAOException{
        String sql = "SELECT im.*, c.Tipo_Item " +
                     "FROM itemmenu im " +
                     "JOIN categoria c ON im.CategoriaID = c.ID_Categoria " +
                     "WHERE im.ID_ItemMenu = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {
                String tipoItem = result.getString("Tipo_Item");
                Categoria categoria = categoriaDAO.buscarCategoriaPorId(result.getInt("CategoriaID"));
                Vendedor vendedor = vendedorDAO.buscarVendedorPorId(result.getInt("VendedorID"));

                if ("Plato".equals(tipoItem)) {
                    return crearPlato(result, categoria, vendedor);
                } else if ("Bebida".equals(tipoItem)) {
                    return crearBebida(result, categoria, vendedor);
                } else {
                    throw new IllegalArgumentException("Tipo de item no válido: " + tipoItem);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar item de menú por ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<ItemMenu> buscarItemsPorCriterios(int id, String nombre, double precio, String categoria, Vendedor vendedor) throws DAOException {
        return null;
        //No implementado
    }
    
    private Plato crearPlato(ResultSet result, Categoria categoria, Vendedor vendedor) throws SQLException {
        String nombre = result.getString("Nombre");
        String descripcion = result.getString("Descripcion");
        double precio = result.getDouble("Precio");
        double peso = result.getDouble("peso");
        double calorias = result.getDouble("Calorias");
        boolean aptoVegano = result.getBoolean("AptoVegano");
        return new Plato(nombre, descripcion, precio, categoria, vendedor, peso, calorias, aptoVegano);
    }

    private Bebida crearBebida(ResultSet result, Categoria categoria, Vendedor vendedor) throws SQLException {
        String nombre = result.getString("Nombre");
        String descripcion = result.getString("Descripcion");
        double precio = result.getDouble("Precio");
        double tamanio = result.getDouble("Tamanio");
        boolean graduacionAlcoholica = result.getBoolean("GraduacionAlcoholica");
        return new Bebida(nombre, descripcion, precio, categoria, vendedor, tamanio, graduacionAlcoholica);
    }
    
    private void validarTipoItemMenu(ItemMenu item) {
        if ((item instanceof Plato && !"Plato".equalsIgnoreCase(item.getCategoria().getTipo_item())) ||
            (item instanceof Bebida && !"Bebida".equalsIgnoreCase(item.getCategoria().getTipo_item()))) {
            throw new IllegalArgumentException("La categoría seleccionada no es compatible con el tipo de ítem.");
        }
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
}
