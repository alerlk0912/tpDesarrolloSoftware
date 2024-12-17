package isi.deso.tpds.Cliente;

import java.util.List;

public interface DAOCliente {
    List<Cliente> listarClientes();
    Cliente buscarClientePorId(int id);
    void agregarCliente(Cliente cliente);
    void actualizarCliente(Cliente cliente);
    void eliminarCliente(int id);
    
}
