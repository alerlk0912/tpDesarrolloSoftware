package Tp.DS.Vendedor;

import Tp.DS.BD.DatabaseConnection;
import Tp.DS.Coordenada.Coordenada;
import Tp.DS.Coordenada.CoordenadaJDBC;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendedorJDBC implements DAOVendedor {
    private Connection connection;
    
    public VendedorJDBC() {
        try {
            DatabaseConnection.setCredentials("root","AmD6Kk3ASlaLdQsa1");
            this.connection = DatabaseConnection.getInstance();
        } catch (SQLException e) {
            System.err.println("Error al conectar la base de datos: " + e.getMessage());
        }
    }
    
    @Override
     public List<Vendedor> listarVendedores() {
        List<Vendedor> vendedores = new ArrayList<>();
        String sql = "SELECT * FROM vendedor INNER JOIN coordenada ON vendedor.CoordenadaID = coordenada.ID_Coordenada";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("ID_Vendedor");
                String nombre = rs.getString("Nombre");
                String direccion = rs.getString("Direccion");
                int coordenadaId = rs.getInt("CoordenadaID");
                double lat = rs.getDouble("Lat");
                double lng = rs.getDouble("Lng");
                Coordenada coordenadas = new Coordenada(coordenadaId, lat, lng);
                Vendedor vendedor = new Vendedor(id, nombre, direccion, coordenadas);
                vendedores.add(vendedor);
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        return vendedores;
    }
            

    @Override
    public void crearVendedor(Vendedor vendedor) {
        String sqlCoordenada = "INSERT INTO coordenada (Lat, Lng) VALUES (?, ?)";
        String sqlVendedor = "INSERT INTO vendedor (Nombre, Direccion, CoordenadaID) VALUES (?, ?, ?)";
        
        try (PreparedStatement stmtCoordenada = connection.prepareStatement(sqlCoordenada, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement stmtVendedor = connection.prepareStatement(sqlVendedor)) {
            
            stmtCoordenada.setDouble(1, vendedor.getCoordenadas().getLat());
            stmtCoordenada.setDouble(2, vendedor.getCoordenadas().getLng());
            stmtCoordenada.executeUpdate();
            
            ResultSet generatedKeys = stmtCoordenada.getGeneratedKeys();
            if (generatedKeys.next()) {
                int coordenadaID = generatedKeys.getInt(1);

                stmtVendedor.setString(1, vendedor.getNombre());
                stmtVendedor.setString(2, vendedor.getDireccion());
                stmtVendedor.setInt(3, coordenadaID);
                stmtVendedor.executeUpdate();
            }   
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
    }

    @Override
    public void actualizarVendedor(Vendedor vendedor) {
        CoordenadaJDBC coordenadaJDBC = new CoordenadaJDBC();
        coordenadaJDBC.actualizarCoordenada(vendedor.getCoordenadas());
        String sqlVendedor = "UPDATE vendedor SET Nombre = ?, Direccion = ? WHERE ID_Vendedor = ?";
        try (PreparedStatement stmtVendedor = connection.prepareStatement(sqlVendedor)) {
            stmtVendedor.setString(1, vendedor.getNombre());
            stmtVendedor.setString(2, vendedor.getDireccion());
            stmtVendedor.setInt(3, vendedor.getId());
            stmtVendedor.executeUpdate();   
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
    }

    @Override
    public void eliminarVendedor(int id) {
        String sql= "SELECT * FROM vendedor WHERE ID_Vendedor = ?";
        CoordenadaJDBC coordenadaJDBC = new CoordenadaJDBC();
        int idCoordenada = 0;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    idCoordenada = rs.getInt("CoordenadaID");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
    
        String sqlDesasociarItems = "DELETE FROM itemmenu_vendedor WHERE ID_Vendedor = ?";   
        String sqlVendedor = "DELETE FROM vendedor WHERE ID_Vendedor = ?";
        try (PreparedStatement stmtDesasociarItems = connection.prepareStatement(sqlDesasociarItems);
            PreparedStatement stmtVendedor = connection.prepareStatement(sqlVendedor);) {
            //items
            stmtDesasociarItems.setInt(1, id);
            stmtDesasociarItems.executeUpdate();
            //vendedor
            stmtVendedor.setInt(1, id);
            stmtVendedor.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        coordenadaJDBC.eliminarCoordenada(idCoordenada);
}


    @Override
    public Vendedor buscarVendedorPorId(int id) {
        Vendedor vendedor = null;
        String sql = "SELECT * FROM vendedor INNER JOIN coordenada ON vendedor.CoordenadaID = coordenada.ID_Coordenada WHERE ID_Vendedor = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("Nombre");
                    String direccion = rs.getString("Direccion");
                    int coordenadaId = rs.getInt("CoordenadaID");
                    double lat = rs.getDouble("Lat");
                    double lng = rs.getDouble("Lng");
                    Coordenada coordenadas = new Coordenada(coordenadaId, lat, lng);
                    vendedor = new Vendedor(id, nombre, direccion, coordenadas);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        return vendedor;
    }
}
