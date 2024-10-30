package Tp.DS.Controller;

import Tp.DS.Coordenada;
import Tp.DS.Coordenada;
import Tp.DS.Vendedor;
import Tp.DS.Vendedor;
import Tp.DS.DAO.DAOVendedor;
import java.util.List;

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
