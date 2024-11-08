package Tp.DS.Vendedor;

import Tp.DS.Coordenada.Coordenada;
import Tp.DS.Vendedor.DAOVendedor;
import java.util.List;

public class VendedorController {
    private DAOVendedor vendedorDAO;

    public VendedorController(DAOVendedor vendedorDAO) {
        this.vendedorDAO = vendedorDAO;
    }

    public List<Vendedor> mostrarListaVendedor() {
        List<Vendedor> vendedores = vendedorDAO.listarVendedores(); // Método en DAO
        return vendedores;
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
