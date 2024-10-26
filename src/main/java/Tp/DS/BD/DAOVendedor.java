/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Tp.DS.BD;

import Tp.DS.Vendedor;
import java.util.List;

/**
 *
 * @author franco
 */
public interface DAOVendedor {
    public List<Vendedor> listarVendedores() ;
    public void crearVendedor(Vendedor vendedor);
    public void actualizarVendedor(Vendedor vendedor);
    public void eliminarVendedor(int id);
    public Vendedor buscarVendedorPorId(int id);
}
