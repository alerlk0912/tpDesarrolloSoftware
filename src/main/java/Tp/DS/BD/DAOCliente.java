/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Tp.DS.BD;

import Tp.DS.Cliente;
import java.util.List;

/**
 *
 * @author franco
 */
public interface DAOCliente {

    void actualizarCliente(Cliente cliente);

    Cliente buscarClientePorId(int id);

    void crearCliente(Cliente cliente);

    void eliminarCliente(int id);

    List<Cliente> listarClientes();
    
}
