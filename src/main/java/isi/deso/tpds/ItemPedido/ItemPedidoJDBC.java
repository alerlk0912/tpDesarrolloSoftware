package isi.deso.tpds.ItemPedido;

import isi.deso.tpds.BD.DatabaseConnection;
import isi.deso.tpds.ItemMenu.ItemMenu;
import isi.deso.tpds.Pedido.Pedido;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemPedidoJDBC implements DAOItemsPedido {
    private static Connection connection;
    private ItemsPedidoController itemPedidoController;

    public ItemPedidoJDBC(ItemsPedidoController itemPedidoController) {
        try {
            connection = DatabaseConnection.getInstance();
            this.itemPedidoController = itemPedidoController;
        } catch (SQLException e) {
            System.err.println("Error al conectar la base de datos: " + e.getMessage());
        }
    }

    @Override
    public List<ItemsPedido> buscarPorCliente(String nombreCliente) {
        List<ItemsPedido> itemsPedido = new ArrayList<>();
        String sql = "SELECT ip.* FROM itemsPedido ip " +
                     "JOIN pedido p ON ip.id_pedido = p.id " +
                     "JOIN cliente c ON p.ClienteID = c.id " +
                     "WHERE c.nombre = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nombreCliente);
            try (ResultSet result = pstmt.executeQuery()) {
                while (result.next()) {
                    ItemMenu itemMenu = itemPedidoController.buscarItemMenu(result.getInt("id_item_menu"));
                    Pedido pedido = itemPedidoController.buscarPedido(result.getInt("id_pedido"));
                    
                    ItemsPedido itemPedido = new ItemsPedido(
                        itemMenu,
                        result.getInt("cantidad")
                    );
                    itemPedido.setId(result.getInt("id"));
                    itemsPedido.add(itemPedido);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar items de pedido por cliente: " + e.getMessage());
        }
        return itemsPedido;
    }

    @Override
    public List<ItemsPedido> buscarPorVendedor(String nombreVendedor) {
        List<ItemsPedido> itemsPedido = new ArrayList<>();
        String sql = "SELECT DISTINCT ip.* FROM itemsPedido ip " +
                     "JOIN itemMenu im ON ip.id_item_menu = im.id " +
                     "JOIN vendedor v ON im.id_vendedor = v.id " +
                     "WHERE v.nombre = ?";
                    
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nombreVendedor);
            try (ResultSet result = pstmt.executeQuery()) {
                while (result.next()) {
                    ItemMenu itemMenu = itemPedidoController.buscarItemMenu(result.getInt("id_item_menu"));
                    Pedido pedido = itemPedidoController.buscarPedido(result.getInt("id_pedido"));
                    
                    ItemsPedido itemPedido = new ItemsPedido(
                        itemMenu,
                        result.getInt("cantidad")
                    );
                    itemPedido.setId(result.getInt("id"));
                    itemsPedido.add(itemPedido);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar items de pedido por vendedor: " + e.getMessage());
        }
        return itemsPedido;
    }

    @Override
    public List<ItemsPedido> buscarPorRangoDePrecios(double precioMin, double precioMax) {
        List<ItemsPedido> itemsPedido = new ArrayList<>();
        String sql = "SELECT ip.* FROM itemsPedido ip " +
                     "JOIN itemMenu im ON ip.id_item_menu = im.id " +
                     "WHERE im.precio BETWEEN ? AND ?";
                    
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, precioMin);
            pstmt.setDouble(2, precioMax);
            try (ResultSet result = pstmt.executeQuery()) {
                while (result.next()) {
                    ItemMenu itemMenu = itemPedidoController.buscarItemMenu(result.getInt("id_item_menu"));
                    Pedido pedido = itemPedidoController.buscarPedido(result.getInt("id_pedido"));
                    
                    ItemsPedido itemPedido = new ItemsPedido(
                        itemMenu,
                        result.getInt("cantidad")
                    );
                    itemPedido.setId(result.getInt("id"));
                    itemsPedido.add(itemPedido);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar items de pedido por rango de precios: " + e.getMessage());
        }
        return itemsPedido;
    }

    @Override
    public List<ItemsPedido> buscarPorRestaurante(String nombreRestaurante) {
        List<ItemsPedido> itemsPedido = new ArrayList<>();
        String sql = "SELECT ip.* FROM itemsPedido ip " +
                     "JOIN itemMenu im ON ip.id_itemMenu = im.id " +
                     "JOIN vendedor v ON im.id_restaurante = v.id " +
                     "WHERE v.nombre = ?";
                    
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nombreRestaurante);
            try (ResultSet result = pstmt.executeQuery()) {
                while (result.next()) {
                    ItemMenu itemMenu = itemPedidoController.buscarItemMenu(result.getInt("id_item_menu"));
                    Pedido pedido = itemPedidoController.buscarPedido(result.getInt("id_pedido"));
                    
                    ItemsPedido itemPedido = new ItemsPedido(
                        itemMenu,
                        result.getInt("cantidad")
                    );
                    itemPedido.setId(result.getInt("id"));
                    itemsPedido.add(itemPedido);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar items de pedido por restaurante: " + e.getMessage());
        }
        return itemsPedido;
    }

    @Override
    public List<ItemsPedido> ordenarPorCriterio(String criterio, boolean ascendente) {
        List<ItemsPedido> itemsPedido = new ArrayList<>();
        String sql = "SELECT ip.* FROM itemsPedido ip ORDER BY " + criterio + " " + 
                    (ascendente ? "ASC" : "DESC");
                    
        try (Statement stmt = connection.createStatement();
             ResultSet result = stmt.executeQuery(sql)) {
            while (result.next()) {
                ItemMenu itemMenu = itemPedidoController.buscarItemMenu(result.getInt("id_item_menu"));
                Pedido pedido = itemPedidoController.buscarPedido(result.getInt("id_pedido"));
                
                ItemsPedido itemPedido = new ItemsPedido(
                    itemMenu,
                    result.getInt("cantidad")
                );
                itemPedido.setId(result.getInt("id"));
                itemsPedido.add(itemPedido);
            }
        } catch (SQLException e) {
            System.err.println("Error al ordenar items de pedido: " + e.getMessage());
        }
        return itemsPedido;
    }

    @Override
    public List<ItemsPedido> listarItemsPedido() {
        List<ItemsPedido> itemsPedido = new ArrayList<>();
        String sql = "SELECT * FROM itemsPedido";
        
        try (Statement stmt = connection.createStatement();
             ResultSet result = stmt.executeQuery(sql)) {
            while (result.next()) {
                ItemMenu itemMenu = itemPedidoController.buscarItemMenu(result.getInt("id_item_menu"));
                Pedido pedido = itemPedidoController.buscarPedido(result.getInt("id_pedido"));
                
                ItemsPedido itemPedido = new ItemsPedido(
                    itemMenu,
                    result.getInt("cantidad")
                );
                itemPedido.setId(result.getInt("id"));
                itemsPedido.add(itemPedido);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar items de pedido: " + e.getMessage());
        }
        return itemsPedido;
    }

    @Override
    public void crearItemPedido(ItemsPedido itemPedido) {
        String sql = "INSERT INTO itemsPedido (id_item_menu, id_pedido, cantidad) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, itemPedido.getItemMenu().getId());
            pstmt.setInt(2, itemPedido.getPedido().getId());
            pstmt.setInt(3, itemPedido.getCantidad());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("crearItemPedido falla, no hay filas afectadas");
            }
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    itemPedido.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("crearItemPedido falla, no obtiene ID.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al crear item de pedido: " + e.getMessage());
        }
    }

    @Override
    public void actualizarItemPedido(ItemsPedido itemPedido) {
        String sql = "UPDATE itemsPedido SET id_item_menu = ?, id_pedido = ?, cantidad = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, itemPedido.getItemMenu().getId());
            pstmt.setInt(2, itemPedido.getPedido().getId());
            pstmt.setInt(3, itemPedido.getCantidad());
            pstmt.setInt(4, itemPedido.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar item de pedido: " + e.getMessage());
        }
    }

    @Override
    public void eliminarItemPedido(int id) {
        String sql = "DELETE FROM items_pedido WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar item de pedido: " + e.getMessage());
        }
    }
    
    @Override
    public ItemsPedido buscarItemPedidoPorId(int id) {
        String sql = "SELECT * FROM items_pedido WHERE id = ?";
        ItemsPedido itemPedido = null;

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet result = pstmt.executeQuery()) {
                if (result.next()) {
                    ItemMenu itemMenu = itemPedidoController.buscarItemMenu(result.getInt("id_item_menu"));
                    if (itemMenu == null) {
                        throw new SQLException("No se encontró el ItemMenu asociado");
                    }

                    Pedido pedido = itemPedidoController.buscarPedido(result.getInt("id_pedido"));
                    if (pedido == null) {
                        throw new SQLException("No se encontró el Pedido asociado");
                    }

                    itemPedido = new ItemsPedido(
                        itemMenu,
                        result.getInt("cantidad")
                    );
                    itemPedido.setId(result.getInt("id"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar item de pedido por ID: " + e.getMessage());
        }
        return itemPedido;
    }
}
