package Tp.DS.Memory;

import Tp.DS.DAO.DAOCliente;
import Tp.DS.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteMemory implements DAOCliente{
    private List<Cliente> clientes = new ArrayList<>();
    private int nextId = 1;
    
    public List<Cliente> listarClientes() {
        return clientes;
    }

    @Override
    public void agregarCliente(Cliente cliente) {
        cliente.setId(nextId++);
        clientes.add(cliente);
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        Cliente c = buscarClientePorId(cliente.getId());
        if (c != null) {
            c.setNombre(cliente.getNombre());
            c.setEmail(cliente.getEmail());
        }
    }

    @Override
    public void eliminarCliente(int id) {
        clientes.removeIf(c -> c.getId() == id);
    }

    @Override
    public Cliente buscarClientePorId(int id) {
        return clientes.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }
}
