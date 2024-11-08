package Tp.DS.Pedido;

import Tp.DS.BD.DatabaseConnection;
import Tp.DS.MetodoPago.DAOMetodoPago;
import Tp.DS.Cliente.Cliente;
import Tp.DS.Cliente.DAOCliente;
import Tp.DS.Pedido.DAOPedido;
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
    public List<Pedido> listarPedidos(){
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedidos";
        try (Statement stmt = connection.createStatement(); ResultSet result = stmt.executeQuery(sql)) {
            while (result.next()) {
                int clienteId = result.getInt("cliente_id");
                String metodoPagoId = result.getString("metodoPago");

                Cliente cliente = clienteDAO.buscarClientePorId(clienteId);
                
                Pago metodoPago = daoPago.buscarPagoPorId(metodoPagoId);

                Pedido pedido = new Pedido(cliente, metodoPago);
                pedido.setId(result.getInt("id"));  
                pedido.setFechaPago(result.getDate("fecha"));  
                pedido.setMontoTotal(result.getDouble("total"));
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar pedidos: " + e.getMessage());
        }
        return pedidos;
    }

    @Override
    public void crearPedido(Pedido pedido) {
        String sql = "INSERT INTO pedidos (cliente_id, fecha, total) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, pedido.getCliente().getId());
            pstmt.setDate(2, new java.sql.Date(pedido.getFechaPago().getTime()));
            pstmt.setDouble(3, pedido.getMontoTotal());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Error en crearPedido: No se afectaron filas.");
            }

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    pedido.setId(generatedKeys.getInt(1)); 
                } else {
                    throw new SQLException("Error en crearPedido: No se generó ID.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al crear pedido: " + e.getMessage());
        }
    }

    

    @Override
    public void actualizarPedido(Pedido pedido){
        String sql = "UPDATE pedidos SET cliente_id = ?, fecha = ?, total = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, pedido.getCliente().getId());
            pstmt.setDate(2, new java.sql.Date(pedido.getFechaPago().getTime()));
            pstmt.setDouble(3, pedido.getMontoTotal());
            pstmt.setInt(4, pedido.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar pedido por ID: " + e.getMessage());
        } 
    }

    @Override
    public void eliminarPedido(int id){
        String sql = "DELETE FROM pedidos WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar pedido por ID: " + e.getMessage());
        } 
    }

    @Override
    public Pedido buscarPedidoPorId(int id){
        String sql = "SELECT * FROM pedidos WHERE id = ?";
        Pedido pedido = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {
                int clienteId = result.getInt("cliente_id");
                String metodoPagoId = result.getString("metodoPago");

                Cliente cliente = clienteDAO.buscarClientePorId(clienteId);
                Pago metodoPago = daoPago.buscarPagoPorId(metodoPagoId);

                pedido = new Pedido(cliente, metodoPago);
                pedido.setId(result.getInt("id"));
                pedido.setFechaPago(result.getDate("fecha"));
                pedido.setMontoTotal(result.getDouble("total"));
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar pedido por ID: " + e.getMessage());
        }  
        return pedido;
    }
}

