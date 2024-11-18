package Tp.DS.MetodoPago;

import Tp.DS.BD.DatabaseConnection;
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
                        case "TRANSFERENCIA" -> { pago = new Transferencia(cbu, cuit, id);
                        }
                        case "MERCADO_PAGO" -> { pago = new MercadoPago(alias, id);
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
