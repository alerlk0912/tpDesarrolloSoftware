package Tp.DS.Controller;

import Tp.DS.DAO.DAOCliente;
import Tp.DS.Cliente;
import Tp.DS.Coordenada;
import java.util.List;

public class ClienteController {
    private DAOCliente clienteDAO;

    public ClienteController(DAOCliente clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public List<Cliente> mostrarClientes() {
        return clienteDAO.listarClientes();
    }

    public void crearNuevoCliente(String cuit, String nombre, String email, String direccion, Coordenada coordenadas) {
        Cliente nuevoCliente = new Cliente(cuit, nombre, email, direccion, coordenadas);
        clienteDAO.agregarCliente(nuevoCliente);
    }

    public void modificarCliente(int id, String cuit, String nombre, String email, String direccion, Coordenada coordenadas) {
        Cliente cliente = clienteDAO.buscarClientePorId(id);
        if (cliente != null) {
            cliente.setCuit(cuit);
            cliente.setNombre(nombre);
            cliente.setEmail(email);
            cliente.setDireccion(direccion);
            cliente.setCoordenadas(coordenadas);           
            clienteDAO.actualizarCliente(cliente);
        }
    }

    public void eliminarCliente(int id) {
        clienteDAO.eliminarCliente(id);
    }

    public Cliente buscarCliente(double id) {
        return clienteDAO.buscarClientePorId(id);
    }
}
