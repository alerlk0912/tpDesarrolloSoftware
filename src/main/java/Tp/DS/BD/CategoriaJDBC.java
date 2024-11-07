/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp.DS.BD;

import Tp.DS.Categoria;
import Tp.DS.DAO.DAOCategoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franco
 */
public class CategoriaJDBC implements DAOCategoria {
    private Connection connection;

    public CategoriaJDBC() {
        try {
            this.connection = DatabaseConnection.getInstance();
        } catch (SQLException e) {
            System.err.println("Error al conectar la base de datos: " + e.getMessage());
        }
    }

    @Override
    public List<Categoria> listarCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categorias";
        try (Statement stmt = connection.createStatement();
             ResultSet result = stmt.executeQuery(sql)) {
            while (result.next()) {
                Categoria categoria = new Categoria(
                    result.getString("descripcion"),
                    result.getString("tipo_item")
                );
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar categorías: " + e.getMessage());
        }
        return categorias;
    }

    @Override
    public void crearCategoria(Categoria categoria) {
        String sql = "INSERT INTO categorias (descripcion, tipo_item) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, categoria.getDescripcion());
            pstmt.setString(2, categoria.getTipo_item());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("crearCategoria falla, no hay filas afectadas");
            }
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    categoria.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("crearCategoria falla, no obtiene ID.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al crear categoría: " + e.getMessage());
        }
    }

    @Override
    public void actualizarCategoria(Categoria categoria) {
        String sql = "UPDATE categorias SET descripcion = ?, tipo_item = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, categoria.getDescripcion());
            pstmt.setString(2, categoria.getTipo_item());
            pstmt.setInt(3, categoria.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar categoría: " + e.getMessage());
        }
    }

    @Override
    public void eliminarCategoria(int id) {
        String sql = "DELETE FROM categorias WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar categoría: " + e.getMessage());
        }
    }

    @Override
    public Categoria buscarCategoriaPorId(int id) {
        String sql = "SELECT * FROM categorias WHERE id = ?";
        Categoria categoria = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet result = pstmt.executeQuery()) {
                if (result.next()) {
                    categoria = new Categoria(
                        result.getString("descripcion"),
                        result.getString("tipo_item")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar categoría por ID: " + e.getMessage());
        }
        return categoria;
    }
}