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
        String sql = "SELECT * FROM items_menu";
        try (Statement stmt = connection.createStatement();
             ResultSet result = stmt.executeQuery(sql)) {
            while (result.next()) {
                String tipo = result.getString("tipo");
                ItemMenu item;
                if (tipo.equals("Plato")) {
                    item = new Plato(
                        result.getString("nombre"),
                        result.getString("descripcion"),
                        result.getDouble("precio"),
                        (Categoria) result.getObject("categoria"),
                        (Vendedor) result.getObject("vendedor"),
                        result.getDouble("peso"),
                        result.getDouble("calorias"),
                        result.getBoolean("apto_vegano")
                    );
                } else if (tipo.equals("Bebida")) {
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
                    continue; // Ignora cualquier otro tipo inesperado
                }
                result.close();
                items.add(item);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar items menu: " + e.getMessage());
        }
        
        connection.close();
        return items;
    }

    @Override
    public void crearItemMenu(ItemMenu item) throws SQLException{
        String sql = "INSERT INTO items_menu (tipo, nombre, descripcion, precio, categoria, vendedor, peso, calorias, apto_vegano, tamanio, graduacion_alcoholica) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(2, item.getNombre());
            pstmt.setString(3, item.getDescripcion());
            pstmt.setDouble(4, item.getPrecio());
            pstmt.setObject(5, item.getCategoria());
            pstmt.setObject(6, item.getVendedor());

            if (item instanceof Plato) {
                Plato plato = (Plato) item;
                pstmt.setString(1, "Plato");
                pstmt.setDouble(7, plato.getPeso());
                pstmt.setDouble(8, plato.getCalorias());
                pstmt.setBoolean(9, plato.isAptoVegano());
                pstmt.setNull(10, Types.DOUBLE);
                pstmt.setNull(11, Types.BOOLEAN);
            } else if (item instanceof Bebida) {
                Bebida bebida = (Bebida) item;
                pstmt.setString(1, "Bebida");
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
            System.err.println("Error al crear item menu: " + e.getMessage());
        }
        connection.close();
    }

    @Override
    public void actualizarItemMenu(ItemMenu item) throws SQLException{
        String sql;
        if (item instanceof Plato) {
            sql = "UPDATE items_menu SET tipo = ?, nombre = ?, descripcion = ?, precio = ?, categoria_id = ?, vendedor_id = ?, peso = ?, calorias = ?, apto_vegano = ? WHERE id = ?";
        } else if (item instanceof Bebida) {
            sql = "UPDATE items_menu SET tipo = ?, nombre = ?, descripcion = ?, precio = ?, categoria_id = ?, vendedor_id = ?, tamanio = ?, graduacion_alcoholica = ? WHERE id = ?";
        } else {
            throw new IllegalArgumentException("El tipo de item no es válido.");
        }

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, item.getTipo());
            pstmt.setString(2, item.getNombre());
            pstmt.setString(3, item.getDescripcion());
            pstmt.setDouble(4, item.getPrecio());
            pstmt.setInt(5, item.getCategoria().getId());
            pstmt.setInt(6, item.getVendedor().getId());
            

            if (item instanceof Plato) {
                Plato plato = (Plato) item;
                pstmt.setDouble(7, plato.getPeso());
                pstmt.setDouble(8, plato.getCalorias());
                pstmt.setBoolean(9, plato.isAptoVegano());
                pstmt.setInt(10, item.getId());
            } else if (item instanceof Bebida) {
                Bebida bebida = (Bebida) item;
                pstmt.setDouble(7, bebida.getTamanio());
                pstmt.setBoolean(8, bebida.isBebidaAlcoholica());
                pstmt.setInt(9, item.getId());
            }
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("crearItemMenu falla, no hay filas afectadas");
            }
        } catch (SQLException e) {
            System.err.println("Error al crear item menu: " + e.getMessage());
        }
        
        connection.close();
    }

    @Override
    public void eliminarItemMenu(int id) throws SQLException{
        String sql = "DELETE FROM item_menu WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al borrar item menu: " + e.getMessage());
        }
        connection.close();
    }

    @Override
    public ItemMenu buscarItemMenuPorId(int id) throws SQLException{
        String sql = "SELECT * FROM items_menu WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {
                String tipo = result.getString("tipo");
                String nombre = result.getString("nombre");
                String descripcion = result.getString("descripcion");
                double precio = result.getDouble("precio");
                int categoriaId = result.getInt("categoria_id");
                int vendedorId = result.getInt("vendedor_id");

                // Obtener instancias completas de Vendedor y Categoria usando sus DAOs
                VendedorJDBC vendedorDAO = new VendedorJDBC(connection);
                CategoriaJDBC categoriaDAO = new CategoriaJDBC(connection);
                Vendedor vendedor = vendedorDAO.buscarVendedorPorId(vendedorId);
                Categoria categoria = categoriaDAO.buscarCategoriaPorId(categoriaId);

                if (vendedor == null || categoria == null) {
                    throw new SQLException("Vendedor o Categoria no encontrados en la base de datos.");
                }
               
                if ("Plato".equalsIgnoreCase(tipo)) {
                    double peso = result.getDouble("peso");
                    double calorias = result.getDouble("calorias");
                    boolean aptoVegano = result.getBoolean("apto_vegano");
                    return new Plato(nombre, descripcion, precio, categoria, vendedor, peso, calorias, aptoVegano);
                } else if ("Bebida".equalsIgnoreCase(tipo)) {
                    double tamanio = result.getDouble("tamanio");
                    boolean graduacionAlcoholica = result.getBoolean("graduacion_alcoholica");
                    return new Bebida(nombre, descripcion, precio, categoria, vendedor, tamanio, graduacionAlcoholica);
                }
            }
            result.close();
            connection.close();
        }
        catch (SQLException e) {
            System.err.println("Error al buscar item menu por ID: " + e.getMessage());
        }
        
        return null;
    }
}
