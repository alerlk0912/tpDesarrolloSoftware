package Tp.DS.DAO;

import Tp.DS.Cliente;
import Tp.DS.Memory.ClienteMemory;
import java.sql.SQLException;
import java.util.List;

public interface DAOCliente {
    void actualizarCliente(Cliente cliente);

    Cliente buscarClientePorId(int id);

    void crearCliente(Cliente cliente);

    void eliminarCliente(int id);

    List<Cliente> listarClientes();
    
}
