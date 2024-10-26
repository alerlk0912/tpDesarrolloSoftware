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
    public List<Pedido> listarPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedidos";
        try (Statement stmt = connection.createStatement(); ResultSet result = stmt.executeQuery(sql)) {
            while (result.next()) {
                Pedido pedido = new Pedido(
                    (Cliente) result.getObject("cliente_id"),
                    (Pago) result.getObject("metodoPago")
                );
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return pedidos;
    }

    @Override
    public void crearPedido(Pedido pedido) {
        String sql = "INSERT INTO pedidos (cliente_id) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, pedido.getCliente().getId());
            pstmt.setDate(2, (Date) pedido.getFechaPago());
            pstmt.setDouble(3, pedido.getMontoTotal());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void actualizarPedido(Pedido pedido) {
        String sql = "UPDATE pedidos SET cliente_id = ?, fecha = ?, total = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, pedido.getCliente().getId());
            pstmt.setDate(2, (Date) pedido.getFechaPago());
            pstmt.setDouble(3, pedido.getMontoTotal());
            pstmt.setInt(4, pedido.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void eliminarPedido(int id) {
        String sql = "DELETE FROM pedidos WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public Pedido buscarPedidoPorId(int id) {
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
            e.getMessage();
        }
        return pedido;
    }
}
