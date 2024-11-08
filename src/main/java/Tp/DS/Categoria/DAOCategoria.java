/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp.DS.Categoria;

import java.util.List;

/**
 *
 * @author franco
 */
public interface DAOCategoria {
    public List<Categoria> listarCategorias();
    public void crearCategoria(Categoria categoria);
    public void actualizarCategoria(Categoria categoria);
    public void eliminarCategoria(int id);
    public Categoria buscarCategoriaPorId(int id);
}
