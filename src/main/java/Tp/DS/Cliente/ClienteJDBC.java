package Tp.DS.Cliente;

import Tp.DS.BD.DatabaseConnection;
import Tp.DS.Coordenada.Coordenada;
import Tp.DS.Cliente.DAOCliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteJDBC implements DAOCliente {
    private Connection connection;
    
    private ClienteJDBC() {
        try {
            connection = DatabaseConnection.getInstance();
        } catch (SQLException e) {
            System.err.println("Error al conectar la base de datos: " + e.getMessage());
        }
    }

    @Override
    public void actualizarCliente(Cliente cliente){
        String sql = "UPDATE clientes SET cuit = ?, nombre = ?, email = ?, direccion = ?, coordenadas = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getCuit());
            pstmt.setString(2, cliente.getNombre());
            pstmt.setString(3, cliente.getEmail());
            pstmt.setString(4, cliente.getDireccion());
            pstmt.setObject(5, cliente.getCoordenadas());
            pstmt.setInt(6, cliente.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar cliente por ID: " + e.getMessage());
        } 
    }

    @Override
    public Cliente buscarClientePorId(int id){
        String sql = "SELECT * FROM clientes WHERE id = ?";
        Cliente cliente = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet result = pstmt.executeQuery()) {
                if (result.next()) {
                    cliente = new Cliente(
                        result.getString("cuit"),
                        result.getString("nombre"),
                        result.getString("email"),
                        result.getString("direccion"),
                        (Coordenada) result.getObject("coordenadas")
                    );
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
        String sql = "INSERT INTO clientes (cuit, nombre, email, direccion, coordenadas) VALUES (?, ?, ?, ?, ?)";
        try ( PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
            pstmt.setString(1, cliente.getCuit());
            pstmt.setString(2, cliente.getNombre());
            pstmt.setString(3, cliente.getEmail());
            pstmt.setString(4, cliente.getDireccion());
            pstmt.setObject(5, cliente.getCoordenadas());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("crearCliente falla, no hay filas afectadas");
            }
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    cliente.setId(generatedKeys.getInt(1)); 
                } else {
                    throw new SQLException("crearCliente falla, no obtiene ID.");
                }
            }
        }
        catch (SQLException e) {
            System.err.println("Error al crear cliente por ID: " + e.getMessage());
        } 
    }
    
    @Override
    public void eliminarCliente(int id){
        String sql = "DELETE FROM clientes WHERE id = ?";
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
        String sql = "SELECT * FROM clientes";
        try (Statement stmt = connection.createStatement(); ResultSet result = stmt.executeQuery(sql)) {
            while (result.next()) {
                Cliente cliente;
                cliente = new Cliente(
                    result.getString("cuit"),
                    result.getString("nombre"),
                    result.getString("email"),
                    result.getString("direccion"),
                    (Coordenada) result.getObject("coordenadas")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar clientes: " + e.getMessage());  
        }
        return clientes;
    }
}
