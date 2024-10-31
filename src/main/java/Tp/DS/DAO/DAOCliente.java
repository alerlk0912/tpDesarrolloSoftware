package Tp.DS.DAO;

import Tp.DS.Cliente;
import Tp.DS.Memory.ClienteMemory;
import java.sql.SQLException;
import java.util.List;

public interface DAOCliente {
    List<Cliente> listarClientes();
    Cliente buscarClientePorId(int id);
    void agregarCliente(Cliente cliente);
    void actualizarCliente(Cliente cliente);
    void eliminarCliente(int id);
    
}
