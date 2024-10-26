/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp.DS;

import Tp.DS.BD.DAOCliente;
import java.util.List;

/**
 *
 * @author franco
 */
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
        clienteDAO.crearCliente(nuevoCliente);
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

    public Cliente buscarCliente(int id) {
        return clienteDAO.buscarClientePorId(id);
    }
}
