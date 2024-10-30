/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Tp.DS.BD;

import Tp.DS.Vendedor;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author franco
 */
public interface DAOVendedor {
    public List<Vendedor> listarVendedores() throws SQLException;
    public void crearVendedor(Vendedor vendedor) throws SQLException;
    public void actualizarVendedor(Vendedor vendedor) throws SQLException;
    public void eliminarVendedor(int id) throws SQLException;
    public Vendedor buscarVendedorPorId(int id) throws SQLException;
}
