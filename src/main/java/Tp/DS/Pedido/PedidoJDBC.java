package Tp.DS.Pedido;

import Tp.DS.BD.DatabaseConnection;
import Tp.DS.MetodoPago.DAOMetodoPago;
import Tp.DS.Cliente.Cliente;
import Tp.DS.Cliente.DAOCliente;
import Tp.DS.MetodoPago.Pago;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoJDBC implements DAOPedido {
    private Connection connection;
    private DAOCliente clienteDAO;
    private DAOMetodoPago daoPago;

    public PedidoJDBC(Connection connection, DAOCliente daoCliente, DAOMetodoPago daoPago) {
        try {
            this.connection = DatabaseConnection.getInstance();
        } catch (SQLException e) {
            System.err.println("Error al conectar la base de datos: " + e.getMessage());
        }
        this.clienteDAO = daoCliente;
        this.daoPago = daoPago;
    }

    @Override
    public List<Pedido> listarPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        String query = "SELECT * FROM pedidos";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Pedido pedido = mapearPedido(rs);
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    @Override
    public void crearPedido(Pedido pedido) {
        String query = "INSERT INTO pedidos (cliente_id, metodo_pago, estado, monto_base, fecha_pago, monto_total) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, pedido.getCliente().getId());
            //pstmt.setString(2, pedido.getMetodoPago());
            pstmt.setString(3, pedido.getEstado().name());
            pstmt.setDouble(4, pedido.getMontoBase());
            pstmt.setDate(5, pedido.getFechaPago() != null ? new Date(pedido.getFechaPago().getTime()) : null);
            pstmt.setDouble(6, pedido.getMontoTotal());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

    @Override
    public void actualizarPedido(Pedido pedido) {
        String query = "UPDATE pedidos SET cliente_id = ?, metodo_pago = ?, estado = ?, monto_base = ?, fecha_pago = ?, monto_total = ? WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, pedido.getCliente().getId());
            //pstmt.setString(2, pedido.getMetodoPago().name());
            pstmt.setString(3, pedido.getEstado().name());
            pstmt.setDouble(4, pedido.getMontoBase());
            pstmt.setDate(5, pedido.getFechaPago() != null ? new Date(pedido.getFechaPago().getTime()) : null);
            pstmt.setDouble(6, pedido.getMontoTotal());
            pstmt.setInt(7, pedido.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarPedido(int id) {
        String query = "DELETE FROM pedidos WHERE id = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pedido buscarPedidoPorId(int id) {
        String query = "SELECT * FROM pedidos WHERE id = ?";
        Pedido pedido = null;

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    pedido = mapearPedido(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedido;
    }

    private Pedido mapearPedido(ResultSet rs) throws SQLException {
        Pedido pedido = new Pedido();
        pedido.setId(rs.getInt("id"));
        // Asumimos que los objetos relacionados se cargan mediante otros DAOs
        Cliente cliente = clienteDAO.buscarClientePorId(rs.getInt("cliente_id")); // Usa DAOCliente
        pedido.setCliente(cliente);
        pedido.setMetodoPago(Pago.valueOf(rs.getString("metodo_pago")));
        pedido.setEstado(EstadoPedido.valueOf(rs.getString("estado")));
        pedido.setMontoBase(rs.getDouble("monto_base"));
        pedido.setFechaPago(rs.getDate("fecha_pago"));
        pedido.setMontoTotal(rs.getDouble("monto_total"));
        return pedido;
    }
}

