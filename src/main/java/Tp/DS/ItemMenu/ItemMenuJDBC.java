package Tp.DS.ItemMenu;

import Tp.DS.BD.DatabaseConnection;
import Tp.DS.Plato;
import Tp.DS.Bebida;
import Tp.DS.Categoria.Categoria;
import Tp.DS.Categoria.DAOCategoria;
import Tp.DS.Exceptions.DAOException;
import Tp.DS.ItemMenu.DAOItemMenu;
import Tp.DS.Vendedor.DAOVendedor;
import Tp.DS.Vendedor.Vendedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemMenuJDBC implements DAOItemMenu {
    private Connection connection;
    private DAOCategoria categoriaDAO;
    private DAOVendedor vendedorDAO;

    public ItemMenuJDBC(Connection connection, DAOCategoria categoriaDAO, DAOVendedor vendedorDAO) {
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
        String sql = "SELECT im.*, c.tipo_item FROM items_menu im JOIN categoria c ON im.categoria = c.id";

        try (Statement stmt = connection.createStatement();
             ResultSet result = stmt.executeQuery(sql)) {
            while (result.next()) {
                String tipoItem = result.getString("tipo_item");
                int categoriaId = result.getInt("categoria_id");
                int vendedorId = result.getInt("vendedor_id");

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
            throw new DAOException("Error al buscar items de menú", e);
        }
        return items;
    }

    @Override
    public void crearItemMenu(ItemMenu item) throws DAOException{
        String sql = "INSERT INTO items_menu (nombre, descripcion, precio, categoria_id, vendedor_id, peso, calorias, apto_vegano, tamanio, graduacion_alcoholica) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            setItemMenuParams(pstmt, item);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("crearItemMenu falló, no hay filas afectadas");
            }
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                } else {
                    throw new DAOException("crearItemMenu falló, no se obtuvo el ID");
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Error al crear item de menú", e);
        }
    }

    @Override
    public void actualizarItemMenu(ItemMenu item) throws DAOException{
        String sql = item instanceof Plato
                ? "UPDATE items_menu SET nombre = ?, descripcion = ?, precio = ?, categoria_id = ?, vendedor_id = ?, peso = ?, calorias = ?, apto_vegano = ? WHERE id = ?"
                : "UPDATE items_menu SET nombre = ?, descripcion = ?, precio = ?, categoria_id = ?, vendedor_id = ?, tamanio = ?, graduacion_alcoholica = ? WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            setItemMenuParams(pstmt, item);
            pstmt.setInt(item instanceof Plato ? 9 : 8, item.getId());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new DAOException("actualizarItemMenu falló, no hay filas afectadas");
            }
        } catch (SQLException e) {
            throw new DAOException("Error al actualizar item de menú", e);
        }
    }

    @Override
    public void eliminarItemMenu(int id) throws DAOException{
        String sql = "DELETE FROM items_menu WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error al eliminar item de menú por ID", e);
        }
    }

    @Override
    public ItemMenu buscarItemMenuPorId(int id) throws DAOException{
        String sql = "SELECT im.*, c.tipo_item "
                + "FROM items_menu im "
                + "JOIN categoria c ON im.categoria_id = c.id "
                + "WHERE im.id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {
                String tipoItem = result.getString("tipo_item");
                Categoria categoria = categoriaDAO.buscarCategoriaPorId(result.getInt("categoria_id"));
                Vendedor vendedor = vendedorDAO.buscarVendedorPorId(result.getInt("vendedor_id"));
                if ("Plato".equals(tipoItem)) {
                    return crearPlato(result, categoria, vendedor);
                } else if ("Bebida".equals(tipoItem)) {
                    return crearBebida(result, categoria, vendedor);
                } else {
                    throw new IllegalArgumentException("Tipo de item no válido: " + tipoItem);
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Error al buscar item de menú por ID", e);
        }
        return null;
    }

    private Plato crearPlato(ResultSet result, Categoria categoria, Vendedor vendedor) throws SQLException {
        String nombre = result.getString("nombre");
        String descripcion = result.getString("descripcion");
        double precio = result.getDouble("precio");
        double peso = result.getDouble("peso");
        double calorias = result.getDouble("calorias");
        boolean aptoVegano = result.getBoolean("apto_vegano");
        return new Plato(nombre, descripcion, precio, categoria, vendedor, peso, calorias, aptoVegano);
    }

    private Bebida crearBebida(ResultSet result, Categoria categoria, Vendedor vendedor) throws SQLException {
        String nombre = result.getString("nombre");
        String descripcion = result.getString("descripcion");
        double precio = result.getDouble("precio");
        double tamanio = result.getDouble("tamanio");
        boolean graduacionAlcoholica = result.getBoolean("graduacion_alcoholica");
        return new Bebida(nombre, descripcion, precio, categoria, vendedor, tamanio, graduacionAlcoholica);
    }

    private void setItemMenuParams(PreparedStatement pstmt, ItemMenu item) throws SQLException {
        pstmt.setString(1, item.getNombre());
        pstmt.setString(2, item.getDescripcion());
        pstmt.setDouble(3, item.getPrecio());
        pstmt.setInt(4, item.getCategoria().getId());
        pstmt.setInt(5, item.getVendedor().getId());

        if (item instanceof Plato) {
            Plato plato = (Plato) item;
            pstmt.setDouble(6, plato.getPeso());
            pstmt.setDouble(7, plato.getCalorias());
            pstmt.setBoolean(8, plato.isAptoVegano());
            pstmt.setNull(9, Types.DOUBLE);
            pstmt.setNull(10, Types.BOOLEAN);
        } else if (item instanceof Bebida) {
            Bebida bebida = (Bebida) item;
            pstmt.setNull(6, Types.DOUBLE);
            pstmt.setNull(7, Types.DOUBLE);
            pstmt.setNull(8, Types.BOOLEAN);
            pstmt.setDouble(9, bebida.getTamanio());
            pstmt.setBoolean(10, bebida.isBebidaAlcoholica());
        }
    }
}
