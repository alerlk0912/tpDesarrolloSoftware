package Tp.DS.Vendedor;

import Tp.DS.Coordenada.*;
import java.util.List;

public class VendedorController {
    private static VendedorController instance;
    private DAOVendedor vendedorDAO;

    private VendedorController(DAOVendedor vendedorDAO) {
        this.vendedorDAO = vendedorDAO;
    }

    public static VendedorController getInstance(DAOVendedor vendedorDAO) {
        
            
        return instance = new VendedorController(vendedorDAO);
        
    }

    public DAOVendedor getVendedorDAO() {
        return vendedorDAO;
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
        
        if (vendedor == null) {
            throw new IllegalArgumentException("El vendedor con ID " + id + " no existe.");
        }
            vendedor.setNombre(nombre);
            vendedor.setDireccion(direccion);
            vendedor.setCoordenadas(coordenadas);
            vendedorDAO.actualizarVendedor(vendedor);
        }
    

    public void eliminarVendedor(int id) {
        Vendedor vendedor = vendedorDAO.buscarVendedorPorId(id);
        if (vendedor == null) {
            throw new IllegalArgumentException("El vendedor con ID " + id + " no existe.");
        }
        vendedorDAO.eliminarVendedor(id);
    }

    public Vendedor buscarVendedor(int id) {
        return vendedorDAO.buscarVendedorPorId(id);
    }
    public void cargarVendedores() {
        crearNuevoVendedor("Restaurante A", "Calle 123", new Coordenada(-34.6037, -58.3816));
        crearNuevoVendedor("Restaurante B", "Calle 456", new Coordenada(-34.6158, -58.4333));
        crearNuevoVendedor("Restaurante C", "Calle 789", new Coordenada(-34.6179, -58.3686));
	crearNuevoVendedor("Restaurante D", "Calle 101", new Coordenada(-34.6059, -58.3831));
        crearNuevoVendedor("Restaurante E", "Calle 202", new Coordenada(-34.6180, -58.4350));
        crearNuevoVendedor("Restaurante F", "Calle 303", new Coordenada(-34.6201, -58.3701));
        crearNuevoVendedor("Restaurante G", "Calle 404", new Coordenada(-34.6081, -58.3846));
    }
}
