package Tp.DS.Cliente;

import Tp.DS.Coordenada.Coordenada;
import java.util.List;

public class ClienteController {
    private static ClienteController instance;
    private DAOCliente clienteDAO;

    private ClienteController(DAOCliente clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public static ClienteController getInstance(DAOCliente clienteDAO) {
        if (instance == null) {
            instance = new ClienteController(clienteDAO);
        }
        return instance;
    }

    public List<Cliente> mostrarClientes() {
        List<Cliente> clientes = clienteDAO.listarClientes();
        return clientes;
    }

    public void crearNuevoCliente(String cuit, String nombre, String email, String direccion, Coordenada coordenadas) {
        Cliente nuevoCliente = new Cliente(cuit, nombre, email, direccion, coordenadas);
        clienteDAO.agregarCliente(nuevoCliente);
    }

    public void modificarCliente(int id, String cuit, String nombre, String email, String direccion, Coordenada coordenadas) {
        Cliente cliente = clienteDAO.buscarClientePorId(id);
        Coordenada cr = new Coordenada(cliente.getCoordenadas().getId(), coordenadas.getLat(), coordenadas.getLng());
        if (cliente != null) {
            cliente.setCuit(cuit);
            cliente.setNombre(nombre);
            cliente.setEmail(email);
            cliente.setDireccion(direccion);
            cliente.setCoordenadas(cr);           
            clienteDAO.actualizarCliente(cliente);
        }
    }

    public void eliminarCliente(int id) {
        clienteDAO.eliminarCliente(id);
    }

    public Cliente buscarCliente(int id) {
        return clienteDAO.buscarClientePorId(id);
    }
    
    public void cargarClientes() {
         // Crear clientes
        crearNuevoCliente("20-12345678-9", "Cliente 1", "cliente1@mail.com", "Avenida 123", new Coordenada(-34.6083, -58.3712));
	crearNuevoCliente("20-87654321-9", "Cliente 2", "cliente2@mail.com", "Avenida 456", new Coordenada(-34.6092, -58.3772));
	crearNuevoCliente("20-11112222-9", "Cliente 3", "cliente3@mail.com", "Avenida 789", new Coordenada(-34.6109, -58.3761));
        crearNuevoCliente("20-33334444-9", "Cliente 4", "cliente4@mail.com", "Avenida 1011", new Coordenada(-34.6126, -58.3750));
        crearNuevoCliente("20-55556666-9", "Cliente 5", "cliente5@mail.com", "Avenida 1213", new Coordenada(-34.6143, -58.3739));
        crearNuevoCliente("20-77778888-9", "Cliente 6", "cliente6@mail.com", "Avenida 1415", new Coordenada(-34.6160, -58.3728));
        crearNuevoCliente("20-99990000-9", "Cliente 7", "cliente7@mail.com", "Avenida 1617", new Coordenada(-34.6177, -58.3717));
        crearNuevoCliente("20-12121212-9", "Cliente 8", "cliente8@mail.com", "Avenida 1819", new Coordenada(-34.6194, -58.3706));
    }
}
