package Tp.DS.DAO;

import Tp.DS.Cliente;
import java.sql.SQLException;
import java.util.List;

public interface DAOCliente {

    void actualizarCliente(Cliente cliente) throws SQLException;

    Cliente buscarClientePorId(int id) throws SQLException;

    void crearCliente(Cliente cliente) throws SQLException;

    void eliminarCliente(int id) throws SQLException;

    List<Cliente> listarClientes() throws SQLException;
    
}
