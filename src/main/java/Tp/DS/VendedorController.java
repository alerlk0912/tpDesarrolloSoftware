/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp.DS;

import Tp.DS.BD.DAOVendedor;
import java.util.List;

/**
 *
 * @author franco
 */
public class VendedorController {
    private DAOVendedor vendedorDAO;

    public VendedorController(DAOVendedor vendedorDAO) {
        this.vendedorDAO = vendedorDAO;
    }

    public List<Vendedor> mostrarListaVendedor() {
        return vendedorDAO.listarVendedores();
    }

    public void crearNuevoVendedor(String nombre, String direccion, Coordenada coordenadas) {
        Vendedor nuevoVendedor = new Vendedor(nombre, direccion, coordenadas);
        vendedorDAO.crearVendedor(nuevoVendedor);
    }

    public void modificarVendedor(int id, String nombre, String direccion, Coordenada coordenadas) {
        Vendedor vendedor = vendedorDAO.buscarVendedorPorId(id);
        if (vendedor != null) {
            vendedor.setNombre(nombre);
            vendedor.setDireccion(direccion);
            vendedor.setCoordenadas(coordenadas);
            vendedorDAO.actualizarVendedor(vendedor);
        }
    }

    public void eliminarVendedor(int id) {
        vendedorDAO.eliminarVendedor(id);
    }

    public Vendedor buscarVendedor(int id) {
        return vendedorDAO.buscarVendedorPorId(id);
    }
}
