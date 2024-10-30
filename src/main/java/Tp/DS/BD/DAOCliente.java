/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Tp.DS.BD;

import Tp.DS.Cliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author franco
 */
public interface DAOCliente {

    void actualizarCliente(Cliente cliente) throws SQLException;

    Cliente buscarClientePorId(int id) throws SQLException;

    void crearCliente(Cliente cliente) throws SQLException;

    void eliminarCliente(int id) throws SQLException;

    List<Cliente> listarClientes() throws SQLException;
    
}
