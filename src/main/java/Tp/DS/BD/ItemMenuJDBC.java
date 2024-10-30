/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp.DS.BD;

/**
 *
 * @author franco
 */
import Tp.DS.ItemMenu;
import Tp.DS.Plato;
import Tp.DS.Bebida;
import Tp.DS.Categoria;
import Tp.DS.Vendedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemMenuJDBC implements DAOItemMenu {
    private Connection connection;

    public ItemMenuJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<ItemMenu> listarItemsMenu() throws SQLException{
        List<ItemMenu> items = new ArrayList<>();
        String sql = "SELECT im.*, c.tipo_item FROM items_menu im JOIN categoria c ON im.categoria = c.id";

        try (Statement stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery(sql)) {
        while (result.next()) {
            String tipoItem = result.getString("tipo_item");  // Obtener tipo de la categoria
            ItemMenu item;
            int categoriaId = result.getInt("categoria");
            int vendedorId = result.getInt("vendedor");
            Categoria categoria = categoriaDAO.buscarCategoriaPorId(categoriaId); 
            Vendedor vendedor = vendedorDAO.buscarVendedorPorId(vendedorId);

            if (tipoItem.equals("Plato")) {
                item = new Plato(
                        result.getString("nombre"),
                        result.getString("descripcion"),
                        result.getDouble("precio"),
                        categoria,
                        vendedor,
                        result.getDouble("peso"),
                        result.getDouble("calorias"),
                        result.getBoolean("apto_vegano")
                );
            } else if (tipoItem.equals("Bebida")) {
                item = new Bebida(
                        result.getString("nombre"),
                        result.getString("descripcion"),
                        result.getDouble("precio"),
                        (Categoria) result.getObject("categoria"),
                        (Vendedor) result.getObject("vendedor"),
                        result.getDouble("tamanio"),
                        result.getBoolean("graduacion_alcoholica")
                );
            } else {
                System.err.println("Tipo de item no válido: " + tipoItem);
                continue; 
            }
            result.close();
            items.add(item);
        }
        return items;
        } catch (SQLException e) {
                System.err.println("Error al buscar items menu: " + e.getMessage());
                throw e; 
        } finally {
            connection.close();
        }
    }

    @Override
    public void crearItemMenu(ItemMenu item) throws SQLException{
        String sql = "INSERT INTO items_menu (nombre, descripcion, precio, categoria, vendedor, peso, calorias, apto_vegano, tamanio, graduacion_alcoholica) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, item.getNombre());
            pstmt.setString(2, item.getDescripcion());
            pstmt.setDouble(3, item.getPrecio());
            pstmt.setObject(4, item.getCategoria());
            pstmt.setObject(5, item.getVendedor());

            if (item instanceof Plato) {
                Plato plato = (Plato) item;
                pstmt.setDouble(7, plato.getPeso());
                pstmt.setDouble(8, plato.getCalorias());
                pstmt.setBoolean(9, plato.isAptoVegano());
                pstmt.setNull(10, Types.DOUBLE);
                pstmt.setNull(11, Types.BOOLEAN);
            } else if (item instanceof Bebida) {
                Bebida bebida = (Bebida) item;
                pstmt.setNull(7, Types.DOUBLE);
                pstmt.setNull(8, Types.DOUBLE);
                pstmt.setNull(9, Types.BOOLEAN);
                pstmt.setDouble(10, bebida.getTamanio());
                pstmt.setBoolean(11, bebida.isBebidaAlcoholica());
            }

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("crearItemMenu falla, no hay filas afectadas");
            }
            // Obtiene el ID generado automáticamente
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1)); 
                } else {
                    throw new SQLException("crearItemMenu falla, no obtiene ID.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al crear item menu por ID: " + e.getMessage());
            throw e; 
        } finally {
            connection.close();
        }
    }

    @Override
    public void actualizarItemMenu(ItemMenu item) throws SQLException{
        String sql;
        if (item instanceof Plato) {
            sql = "UPDATE items_menu SET nombre = ?, descripcion = ?, precio = ?, categoria_id = ?, vendedor_id = ?, peso = ?, calorias = ?, apto_vegano = ? WHERE id = ?";
        } else if (item instanceof Bebida) {
            sql = "UPDATE items_menu SET nombre = ?, descripcion = ?, precio = ?, categoria_id = ?, vendedor_id = ?, tamanio = ?, graduacion_alcoholica = ? WHERE id = ?";
        } else {
            throw new IllegalArgumentException("El tipo de item no es válido.");
        }

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
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
                pstmt.setInt(9, item.getId());
            } else if (item instanceof Bebida) {
                Bebida bebida = (Bebida) item;
                pstmt.setDouble(6, bebida.getTamanio());
                pstmt.setBoolean(7, bebida.isBebidaAlcoholica());
                pstmt.setInt(8, item.getId());
            }
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("actualizarItemMenu falla, no hay filas afectadas");
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar item menu: " + e.getMessage());
            throw e; 
        } finally {
            connection.close();
        }
    }

    @Override
    public void eliminarItemMenu(int id) throws SQLException{
        String sql = "DELETE FROM item_menu WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al borrar item menu por ID: " + e.getMessage());
            throw e; 
        } finally {
            connection.close();
        }
    }

    @Override
    public ItemMenu buscarItemMenuPorId(int id) throws SQLException {
    String sql = "SELECT im.*, c.tipo_item FROM items_menu im JOIN categoria c ON im.categoria = c.id WHERE im.id = ?";

    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setInt(1, id);
        ResultSet result = pstmt.executeQuery();

        if (result.next()) {
            String tipoItem = result.getString("tipo_item");
            String nombre = result.getString("nombre");
            String descripcion = result.getString("descripcion");
            double precio = result.getDouble("precio");
            int categoriaId = result.getInt("categoria_id");
            int vendedorId = result.getInt("vendedor_id");

            Vendedor vendedor = vendedorDAO.buscarVendedorPorId(vendedorId);
            Categoria categoria = categoriaDAO.buscarCategoriaPorId(categoriaId);

            if (vendedor == null || categoria == null) {
                throw new SQLException("Vendedor o Categoria no encontrados en la base de datos.");
            }

            ItemMenu item;
            switch (tipoItem) { // se cambia luego aplicando factory
                case "Plato":
                    double peso = result.getDouble("peso");
                    double calorias = result.getDouble("calorias");
                    boolean aptoVegano = result.getBoolean("apto_vegano");
                    item = new Plato(nombre, descripcion, precio, categoria, vendedor, peso, calorias, aptoVegano);
                    break;
                case "Bebida":
                    double tamanio = result.getDouble("tamanio");
                    boolean graduacionAlcoholica = result.getBoolean("graduacion_alcoholica");
                    item = new Bebida(nombre, descripcion, precio, categoria, vendedor, tamanio, graduacionAlcoholica);
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de item no válido: " + tipoItem);
            }
            return item;
        }
        return null;
        } catch (SQLException e) {
            System.err.println("Error al buscar item menu por ID: " + e.getMessage());
            throw e; 
        } finally {
            connection.close();
        }
    }
}
