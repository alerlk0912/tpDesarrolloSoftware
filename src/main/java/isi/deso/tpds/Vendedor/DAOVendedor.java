package isi.deso.tpds.Vendedor;

import java.util.List;

public interface DAOVendedor {
    public List<Vendedor> listarVendedores();
    public void crearVendedor(Vendedor vendedor);
    public void actualizarVendedor(Vendedor vendedor);
    public void eliminarVendedor(int id);
    public Vendedor buscarVendedorPorId(int id);
}
