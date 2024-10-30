package Tp.DS.DAO;

import Tp.DS.Vendedor;
import java.sql.SQLException;
import java.util.List;

public interface DAOVendedor {
    public List<Vendedor> listarVendedores();
    public void crearVendedor(Vendedor vendedor);
    public void actualizarVendedor(Vendedor vendedor);
    public void eliminarVendedor(int id);
    public Vendedor buscarVendedorPorId(int id);
}
