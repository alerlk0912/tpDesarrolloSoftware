/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp.DS.BD;
import Tp.DS.Coordenada;
import Tp.DS.DAOException;
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

    public VendedorJDBC(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public List<Vendedor> listarVendedores() {
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
            e.getMessage();
        }
        return vendedores;
    }

    @Override
    public void crearVendedor(Vendedor vendedor) {
        String sql = "INSERT INTO vendedores (nombre, direccion, coordenadas) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, vendedor.getNombre());
            pstmt.setString(2, vendedor.getDireccion());
            pstmt.setObject(3, vendedor.getCoordenadas());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void actualizarVendedor(Vendedor vendedor) {
        String sql = "UPDATE vendedores SET nombre = ?, direccion = ?, coordenadas = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, vendedor.getNombre());
            pstmt.setString(2, vendedor.getDireccion());
            pstmt.setObject(3, vendedor.getCoordenadas());
            pstmt.setInt(4, vendedor.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void eliminarVendedor(int id) {
        String sql = "DELETE FROM vendedores WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public Vendedor buscarVendedorPorId(int id) {
        String sql = "SELECT * FROM vendedores WHERE id = ?";
        Vendedor vendedor = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {
                vendedor = new Vendedor(
                    result.getString("nombre"),           
                    result.getString("direccion"),        
                    (Coordenada)result.getObject("coordenadas") 
                );
                
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return vendedor;
    }
}
