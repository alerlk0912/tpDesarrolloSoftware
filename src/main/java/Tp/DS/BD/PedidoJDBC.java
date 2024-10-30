/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp.DS.BD;

/**
 *
 * @author franco
 */
import Tp.DS.Cliente;
import Tp.DS.Pago;
import Tp.DS.Pedido;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoJDBC implements DAOPedido {
    private Connection connection;

    public PedidoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Pedido> listarPedidos() throws SQLException{
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedidos";
        try (Statement stmt = connection.createStatement(); ResultSet result = stmt.executeQuery(sql)) {
            while (result.next()) {
                Pedido pedido = new Pedido(
                    (Cliente) result.getObject("cliente_id"),
                    (Pago) result.getObject("metodoPago")
                );
                result.close();
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener los pedidos: " + e.getMessage());
        }
        connection.close();
        return pedidos;
    }

    @Override
    public void crearPedido(Pedido pedido) throws SQLException{
        String sql = "INSERT INTO pedidos (cliente_id) VALUES (?, ?, ?)";
        try ( PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
            pstmt.setInt(1, pedido.getCliente().getId());
            pstmt.setDate(2, (Date) pedido.getFechaPago());
            pstmt.setDouble(3, pedido.getMontoTotal());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("crearPedido falla, no hay filas afectadas");
            }
            // Obtiene el ID generado automáticamente
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    pedido.setId(generatedKeys.getInt(1)); 
                } else {
                    throw new SQLException("crearPedido falla, no obtiene ID.");
                }
                generatedKeys.close();
            }
        }
        catch (SQLException e) {
            System.err.println("Error al crear Pedido: " + e.getMessage());
        }
        connection.close();
    }
    

    @Override
    public void actualizarPedido(Pedido pedido) throws SQLException{
        String sql = "UPDATE pedidos SET cliente_id = ?, fecha = ?, total = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, pedido.getCliente().getId());
            pstmt.setDate(2, (Date) pedido.getFechaPago());
            pstmt.setDouble(3, pedido.getMontoTotal());
            pstmt.setInt(4, pedido.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar Pedido: " + e.getMessage());
        }
        connection.close();
    }

    @Override
    public void eliminarPedido(int id) throws SQLException{
        String sql = "DELETE FROM pedidos WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar Pedido: " + e.getMessage());
        }
        connection.close();
    }

    @Override
    public Pedido buscarPedidoPorId(int id) throws SQLException{
        String sql = "SELECT * FROM pedidos WHERE id = ?";
        Pedido pedido = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {
                pedido = new Pedido(
                    (Cliente) result.getObject("cliente"),
                    (Pago) result.getObject("pago")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar Pedido por ID: " + e.getMessage());
        }
        connection.close();
        return pedido;
    }
}
