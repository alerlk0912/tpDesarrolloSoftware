package Tp.DS.Categoria;

import java.util.List;

public interface DAOCategoria {
    public List<Categoria> listarCategorias();
    public void crearCategoria(Categoria categoria);
    public void actualizarCategoria(Categoria categoria);
    public void eliminarCategoria(int id);
    public Categoria buscarCategoriaPorId(int id);
}
