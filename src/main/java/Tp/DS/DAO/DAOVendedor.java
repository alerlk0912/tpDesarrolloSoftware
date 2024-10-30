package Tp.DS.DAO;

import Tp.DS.Vendedor;
import java.sql.SQLException;
import java.util.List;

public interface DAOVendedor {
    public List<Vendedor> listarVendedores() throws SQLException;
    public void crearVendedor(Vendedor vendedor) throws SQLException;
    public void actualizarVendedor(Vendedor vendedor) throws SQLException;
    public void eliminarVendedor(int id) throws SQLException;
    public Vendedor buscarVendedorPorId(int id) throws SQLException;
}
