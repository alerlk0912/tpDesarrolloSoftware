package Tp.DS.Cliente;

import Tp.DS.BD.DatabaseConnection;
import Tp.DS.Coordenada.Coordenada;
import Tp.DS.Coordenada.CoordenadaJDBC;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteJDBC implements DAOCliente {
    private Connection connection;
    
    public ClienteJDBC() {
        try {
            DatabaseConnection.setCredentials("root","AmD6Kk3ASlaLdQsa1");
            connection = DatabaseConnection.getInstance();
        } catch (SQLException e) {
            System.err.println("Error al conectar la base de datos: " + e.getMessage());
        }
    }

    @Override
    public void actualizarCliente(Cliente cliente){
        CoordenadaJDBC coordenadaJDBC = new CoordenadaJDBC();
        coordenadaJDBC.actualizarCoordenada(cliente.getCoordenadas());
        String sql = "UPDATE cliente SET CUIT  = ?, Nombre = ?, Email = ?, Direccion = ? WHERE ID_Cliente  = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getCuit());
            pstmt.setString(2, cliente.getNombre());
            pstmt.setString(3, cliente.getEmail());
            pstmt.setString(4, cliente.getDireccion());
            pstmt.setInt(5, cliente.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar cliente por ID: " + e.getMessage());
        } 
    }

    @Override
    public Cliente buscarClientePorId(int id){
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente INNER JOIN coordenada ON cliente.CoordenadaID = coordenada.ID_Coordenada WHERE ID_Cliente = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet result = pstmt.executeQuery()) {
                if (result.next()) {
                    int coordenadaId = result.getInt("CoordenadaID");
                    double lat = result.getDouble("Lat");
                    double lng = result.getDouble("Lng");
                    Coordenada coordenadas = new Coordenada(coordenadaId, lat, lng);
                    cliente = new Cliente(
                        result.getString("CUIT"),
                        result.getString("Nombre"),
                        result.getString("Email"),
                        result.getString("Direccion"),
                        coordenadas
                    );
                    cliente.setId(id);
                }
            }
        } 
        catch (SQLException e) {
            System.err.println("Error al buscar cliente por ID: " + e.getMessage());
        } 
        return cliente;
    }

    @Override
    public void agregarCliente(Cliente cliente){
        String sqlCoordenada = "INSERT INTO coordenada (Lat, Lng) VALUES (?, ?)";
        String sqlCliente = "INSERT INTO cliente (CUIT, Nombre, Email, Direccion, CoordenadaID) VALUES (?, ?, ?, ?, ?)";
        
        try ( PreparedStatement pstmtCoordenada = connection.prepareStatement(sqlCoordenada, Statement.RETURN_GENERATED_KEYS);
                PreparedStatement pstmtCliente = connection.prepareStatement(sqlCliente);){
            
            pstmtCoordenada.setDouble(1, cliente.getCoordenadas().getLat());
            pstmtCoordenada.setDouble(2, cliente.getCoordenadas().getLng());
            
            int affectedRowsCoordenada = pstmtCoordenada.executeUpdate();
            if (affectedRowsCoordenada == 0) {
                throw new SQLException("No fue posible crear las coordenadas");
            }
            try (ResultSet generatedKeys = pstmtCoordenada.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int coordenadaID = generatedKeys.getInt(1);
                    
                    pstmtCliente.setString(1, cliente.getCuit());
                    pstmtCliente.setString(2, cliente.getNombre());
                    pstmtCliente.setString(3, cliente.getEmail());
                    pstmtCliente.setString(4, cliente.getDireccion());
                    pstmtCliente.setObject(5, coordenadaID);
                    
                    int affectedRows = pstmtCliente.executeUpdate();
                    if (affectedRows == 0) {
                        throw new SQLException("No fue posible crear el cliente");
                    }
                } else {
                    throw new SQLException("crearCliente falla, no obtiene ID.");
                }
            }
        }
        catch (SQLException e) {
            System.err.println("Error al crear cliente: " + e.getMessage());
        } 
    }
    
    @Override
    public void eliminarCliente(int id){
        String sql = "DELETE FROM cliente WHERE ID_Cliente = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar cliente por ID: " + e.getMessage()); 
        }
    }

    @Override
    public List<Cliente> listarClientes(){
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente INNER JOIN coordenada ON cliente.CoordenadaID = coordenada.ID_Coordenada";
        try (Statement stmt = connection.createStatement(); ResultSet result = stmt.executeQuery(sql)) {
            while (result.next()) {
                Cliente cliente;
                int id = result.getInt("ID_Cliente");
                int coordenadaId = result.getInt("CoordenadaID");
                double lat = result.getDouble("Lat");
                double lng = result.getDouble("Lng");
                Coordenada coordenadas = new Coordenada(coordenadaId, lat, lng);
                cliente = new Cliente(
                    result.getString("cuit"),
                    result.getString("nombre"),
                    result.getString("email"),
                    result.getString("direccion"),
                    coordenadas
                );
                cliente.setId(id);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar clientes: " + e.getMessage());  
        }
        return clientes;
    }
}