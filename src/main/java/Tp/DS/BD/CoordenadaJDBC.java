/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp.DS.BD;

import Tp.DS.Coordenada;
import Tp.DS.DAO.DAOCoordenada;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franco
 */
public class CoordenadaJDBC implements DAOCoordenada {
private static Connection connection;

    private CoordenadaJDBC() {
        try {
            connection = DatabaseConnection.getInstance();
        } catch (SQLException e) {
            System.err.println("Error al conectar la base de datos: " + e.getMessage());
        }
    }

    @Override
    public List<Coordenada> listarCoordenadas() {
        List<Coordenada> coordenadas = new ArrayList<>();
        String sql = "SELECT * FROM coordenadas";
        try (Statement stmt = connection.createStatement();
             ResultSet result = stmt.executeQuery(sql)) {
            while (result.next()) {
                Coordenada coordenada = new Coordenada(
                    result.getDouble("latitud"),
                    result.getDouble("longitud")
                );
                coordenada.setId(result.getInt("id"));
                coordenadas.add(coordenada);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar coordenadas: " + e.getMessage());
        }
        return coordenadas;
    }

    @Override
    public void crearCoordenada(Coordenada coordenada) {
        String sql = "INSERT INTO coordenadas (latitud, longitud) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setDouble(1, coordenada.getLat());
            pstmt.setDouble(2, coordenada.getLng());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("crearCoordenada falla, no hay filas afectadas");
            }
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    coordenada.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("crearCoordenada falla, no obtiene ID.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al crear coordenada: " + e.getMessage());
        }
    }

    @Override
    public void actualizarCoordenada(Coordenada coordenada) {
        String sql = "UPDATE coordenadas SET latitud = ?, longitud = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, coordenada.getLat());
            pstmt.setDouble(2, coordenada.getLng());
            pstmt.setInt(3, coordenada.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar coordenada: " + e.getMessage());
        }
    }

    @Override
    public void eliminarCoordenada(int id) {
        String sql = "DELETE FROM coordenadas WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar coordenada: " + e.getMessage());
        }
    }

    @Override
    public Coordenada buscarCoordenadasPorId(int id) {
        String sql = "SELECT * FROM coordenadas WHERE id = ?";
        Coordenada coordenada = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet result = pstmt.executeQuery()) {
                if (result.next()) {
                    coordenada = new Coordenada(
                        result.getDouble("latitud"),
                        result.getDouble("longitud")
                    );
                    coordenada.setId(result.getInt("id"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar coordenada por ID: " + e.getMessage());
        }
        return coordenada;
    }
}
