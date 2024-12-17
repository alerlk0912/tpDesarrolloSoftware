package isi.deso.tpds.MetodoPago;

import isi.deso.tpds.BD.DatabaseConnection;
import isi.deso.tpds.Pedido.Pedido;

import java.sql.*;
import java.util.List;

public class PagoJDBC implements DAOMetodoPago {
    private Connection connection;

    public PagoJDBC() {
        try {
            this.connection = DatabaseConnection.getInstance();
        } catch (SQLException e) {
            System.err.println("Error al conectar la base de datos: " + e.getMessage());
        }
    }

    @Override
    public Pago buscarPagoPorId(int id) {
        Pago pago = null;
        String sql = "SELECT * FROM pago WHERE ID_Pago = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String metodo = rs.getString("Metodo");
                    String cbu = rs.getString("cbu");
                    String cuit = rs.getString("cuit");
                    String alias = rs.getString("alias");
                    switch (metodo) {
                        case "Transferencia" -> { pago = new Transferencia(cbu, cuit, id);
                        }
                        case "MercadoPago" -> { pago = new MercadoPago(alias, id);
                        }
                        default -> { pago = new Efectivo(id);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el pago por ID: " + e.getMessage());
        }
        return pago;
    }

    public void actualizar(Pedido pedido) throws SQLException {
        String sql = "UPDATE pedidos SET cliente_id = ?, metodo_pago = ?, monto_base = ?, monto_total = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, pedido.getCliente().getId());
            stmt.setString(2, pedido.getMetodoPago().getClass().getSimpleName());
            stmt.setDouble(3, pedido.getMontoBase());
            stmt.setDouble(4, pedido.getMontoTotal());
            stmt.setInt(5, pedido.getId());
            stmt.executeUpdate();
        }
    }


    @Override
    public List<Pago> buscarPagoPorMetodo(String metodoPago) {
        //
        return null;
        //
    }

    @Override
    public void guardarPago(Pago pago) {
        //
    }

    @Override
    public void eliminarPago(int id) {
        //
    }
    
}
