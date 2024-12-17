package isi.deso.tpds.Categoria;

import java.util.List;

public interface DAOCategoria {
    List<Categoria> listarCategorias();
    void crearCategoria(Categoria categoria);
    void actualizarCategoria(Categoria categoria);
    void eliminarCategoria(int id);
    Categoria buscarCategoriaPorId(int id);
}
