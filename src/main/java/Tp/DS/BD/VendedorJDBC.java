/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp.DS.BD;
import Tp.DS.Coordenada;
import Tp.DS.DAO.DAOVendedor;
import Tp.DS.Vendedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author franco
 */
    

public class VendedorJDBC implements DAOVendedor {
    private Connection connection;

    public VendedorJDBC() {
        try {
            this.connection = DatabaseConnection.getInstance();
        } catch (SQLException e) {
            System.err.println("Error al conectar la base de datos: " + e.getMessage());
        }
    }
    
    @Override
    public List<Vendedor> listarVendedores(){
        List<Vendedor> vendedores = new ArrayList<>();
        String sql = "SELECT * FROM vendedores"; 
        try (Statement stmt = connection.createStatement(); 
            ResultSet result = stmt.executeQuery(sql)) { 
            while (result.next()) {
                Vendedor vendedor = new Vendedor(
                    result.getString("nombre"),           
                    result.getString("direccion"),
                    (Coordenada) result.getObject("coordenadas")     
                );
                 vendedores.add(vendedor);
            }
            
        } catch (SQLException e) {
            System.err.println("Error al listar vendedores: " + e.getMessage());
        } 
        return vendedores;
    }

    @Override
    public void crearVendedor(Vendedor vendedor){
        String sql = "INSERT INTO vendedores (nombre, direccion, coordenadas) VALUES (?, ?, ?)";
        try ( PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
            pstmt.setString(1, vendedor.getNombre());
            pstmt.setString(2, vendedor.getDireccion());
            pstmt.setObject(3, vendedor.getCoordenadas()); 
            
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("crearVendedor falla, no hay filas afectadas");
            }
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    vendedor.setId(generatedKeys.getInt(1)); 
                } else {
                    throw new SQLException("crearVendedor falla, no obtiene ID.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al crear vendedor: " + e.getMessage());
        } 
    }

    @Override
    public void actualizarVendedor(Vendedor vendedor){
        String sql = "UPDATE vendedores SET nombre = ?, direccion = ?, coordenadas = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, vendedor.getNombre());
            pstmt.setString(2, vendedor.getDireccion());
            pstmt.setObject(3, vendedor.getCoordenadas());
            pstmt.setInt(4, vendedor.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar vendedor: " + e.getMessage());
        } 
    }

    @Override
    public void eliminarVendedor(int id){
        String sql = "DELETE FROM vendedores WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar vendedor: " + e.getMessage());
        } 
    }

    @Override
    public Vendedor buscarVendedorPorId(int id) {
        String sql = "SELECT * FROM vendedores WHERE id = ?";
        Vendedor vendedor = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet result = pstmt.executeQuery()) {
            pstmt.setInt(1, id);
            if (result.next()) {
                vendedor = new Vendedor(
                    result.getString("nombre"),           
                    result.getString("direccion"),        
                    (Coordenada) result.getObject("coordenadas")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar vendedor por ID: " + e.getMessage());
        }
        return vendedor;
    }
}
