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
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemMenuJDBC implements DAOItemMenu {
    private Connection connection;

    public ItemMenuJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<ItemMenu> listarItemsMenu() {
        List<ItemMenu> items = new ArrayList<>();
        String sql = "SELECT * FROM item_menu";
        try (Statement stmt = connection.createStatement(); ResultSet result = stmt.executeQuery(sql)) {
            while (result.next()) {
                ItemMenu item = new ItemMenu(
                    result.getString("nombre"),
                    result.getString("descripcion"),
                    result.getDouble("precio"),
                    result.getInt("categoria_id"),
                    result.getInt("vendedor_id")
                );
                items.add(item);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return items;
    }

    @Override
    public void crearItemMenu(ItemMenu item) {
        String sql = "INSERT INTO item_menu (nombre, descripcion, precio, vendedor_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, item.getNombre());
            pstmt.setString(2, item.getDescripcion());
            pstmt.setDouble(3, item.getPrecio());
            pstmt.setInt(4, item.getVendedor().getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void actualizarItemMenu(ItemMenu item) {
        String sql = "UPDATE item_menu SET nombre = ?, descripcion = ?, precio = ?, vendedor_id = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, item.getNombre());
            pstmt.setString(2, item.getDescripcion());
            pstmt.setDouble(3, item.getPrecio());
            pstmt.setInt(4, item.getVendedor().getId());
            pstmt.setInt(5, item.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void eliminarItemMenu(int id) {
        String sql = "DELETE FROM item_menu WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public ItemMenu buscarItemMenuPorId(int id) {
        String sql = "SELECT * FROM item_menu WHERE id = ?";
        ItemMenu item = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                item = new ItemMenu(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio"),
                    rs.getInt("vendedor_id")
                );
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return item;
    }
}
