package Tp.DS.Cliente;

import Tp.DS.Cliente.ClienteMemory;

import java.util.List;

public interface DAOCliente {
    public List<Cliente> listarClientes();
    public Cliente buscarClientePorId(int id);
    public void agregarCliente(Cliente cliente);
    public void actualizarCliente(Cliente cliente);
    public void eliminarCliente(int id);
    
}
