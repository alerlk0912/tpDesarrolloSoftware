package isi.deso.tpds.ItemMenu;

import isi.deso.tpds.Vendedor.VendedorMemory;
import isi.deso.tpds.Vendedor.VendedorController;
import isi.deso.tpds.Vendedor.Vendedor;
import isi.deso.tpds.Bebida;
import isi.deso.tpds.Categoria.Categoria;
import isi.deso.tpds.Exceptions.DAOException;
import isi.deso.tpds.Plato;
import java.util.ArrayList;
import java.util.List;

public class ItemMenuController {
    private final DAOItemMenu itemMenuDAO;
    private final VendedorController vendedorController = VendedorController.getInstance(VendedorMemory.getInstance());
    private static ItemMenuController instance;

    public DAOItemMenu getItemMenuDAO() {
        return itemMenuDAO;
    }

    private ItemMenuController(DAOItemMenu itemMenuDAO) {
        this.itemMenuDAO = itemMenuDAO;
    }
    
    public static void resetInstance() {
        instance = null;
    }
    
    public static ItemMenuController getInstance(DAOItemMenu itemMenuDAO) {
        if (instance == null) {
            instance = new ItemMenuController(itemMenuDAO);
        }
        return instance;
    }

    public List<ItemMenu> mostrarListaItemsMenu() throws DAOException {
        return itemMenuDAO.listarItemsMenu();
    }

    public void crearNuevoItemMenu(String tipoItem, String nombre, String descripcion, double precio,
                                  Categoria categoria, Vendedor vendedor,
                                  Double tamanio, Boolean graduacionAlcoholica,
                                  Double peso, Double calorias, Boolean aptoVegano) throws DAOException {

        ItemMenu nuevoItem = ItemMenuFactory.createItemMenu(tipoItem, nombre, descripcion, precio,
                                                            categoria, vendedor,
                                                            tamanio, graduacionAlcoholica,
                                                            peso, calorias, aptoVegano);
        
        itemMenuDAO.crearItemMenu(nuevoItem);
    }

    public void modificarItemMenu(int id, ItemMenu itemMenu,
            double tamanio, boolean alcholica, 
            double peso, double calorias, boolean aptoVegano) throws DAOException {
        ItemMenu item = itemMenuDAO.buscarItemMenuPorId(id);
        if (item != null) {
            itemMenuDAO.actualizarItemMenu(itemMenu, tamanio, alcholica, peso, calorias, aptoVegano);
        }
    }
    
    public Plato obtenerDatosPlato(int id) {
        return itemMenuDAO.obtenerDatosPlato(id);
    }
    public Bebida obtenerDatosBebida(int id) {
        return itemMenuDAO.obtenerDatosBebida(id);
    }

    public void eliminarItemMenu(int id) throws DAOException {
        itemMenuDAO.eliminarItemMenu(id);
    }

    public ItemMenu buscarItemMenu(int id) throws DAOException {
        return itemMenuDAO.buscarItemMenuPorId(id);
    }

    public List<ItemMenu> obtenerItemsMenuPorVendedor(Vendedor vendedor) throws DAOException{
        if (vendedor == null) {
            throw new IllegalArgumentException("El vendedor no puede ser nulo");
        }

        List<ItemMenu> items = itemMenuDAO.listarItemsMenu();
        List<ItemMenu> itemsPorVendedor = new ArrayList<>();

        for (ItemMenu item : items) {
            int idvendedor=vendedor.getId();
            if (idvendedor==item.getVendedor().getId()) {
                itemsPorVendedor.add(item);
            }
        }
        if (itemsPorVendedor.isEmpty()) {
            System.out.println("No se encontraron items para el vendedor: " + vendedor.getNombre());
        }

        return itemsPorVendedor;
    }
    
    public List<ItemMenu> buscarItemsPorCriterios(int id, String nombre, double precio, String categoria, Vendedor vendedor) throws DAOException {
        return itemMenuDAO.buscarItemsPorCriterios(id, nombre, precio, categoria, vendedor);
    }
    
     public void cargarItemsMenu() throws DAOException{
        Vendedor v1 = vendedorController.buscarVendedor(1);
        Vendedor v2 = vendedorController.buscarVendedor(2);
        Vendedor v3 = vendedorController.buscarVendedor(3);
        Vendedor v4 = vendedorController.buscarVendedor(4);
        Vendedor v5 = vendedorController.buscarVendedor(5);
        Vendedor v6 = vendedorController.buscarVendedor(6);
        Vendedor v7 = vendedorController.buscarVendedor(7);
        
        Categoria catBebidas = new Categoria("Descripcion","BEBIDA");
        Categoria catComidas = new Categoria("Descripcion", "PLATO");

        crearNuevoItemMenu(catBebidas.getTipo_item(), "Gaseosa", "Refresco de cola", 2500, catBebidas, v1, 0.5, false, null, null, null);
        crearNuevoItemMenu(catComidas.getTipo_item(), "Bife", "Bife de chorizo", 10000, catComidas, v1, null, null, 0.4, 0.8, false);
        crearNuevoItemMenu(catBebidas.getTipo_item(), "Vino", "Vino tinto Malbec", 7000, catBebidas, v2, 0.75, true, null, null, null);
        crearNuevoItemMenu(catComidas.getTipo_item(), "Postre", "Flan con dulce de leche", 2500, catComidas, v2, null, null, 0.2, 0.4, true);
        crearNuevoItemMenu(catComidas.getTipo_item(), "Ensalada", "Ensalada mixta", 3000, catComidas, v3, null, null, 0.25, 0.15, true);
        crearNuevoItemMenu(catBebidas.getTipo_item(), "Agua Mineral", "Agua sin gas", 1500, catBebidas, v3, 1.00, false, null, null, null);
        crearNuevoItemMenu(catComidas.getTipo_item(), "Pizza", "Pizza Margherita", 8000, catComidas, v4, null, null, 0.8, 1.2, false);
        crearNuevoItemMenu(catBebidas.getTipo_item(), "Cerveza", "Cerveza rubia", 3500, catBebidas, v5, 0.33, true, null, null, null);
	crearNuevoItemMenu(catComidas.getTipo_item(), "Hamburguesa", "Hamburguesa completa", 6000, catComidas, v6, null, null, 0.35, 0.7, false);
        crearNuevoItemMenu(catBebidas.getTipo_item(), "Jugo", "Jugo de naranja", 2000, catBebidas, v5, 0.5, false, null, null, null);
        crearNuevoItemMenu(catComidas.getTipo_item(), "Pasta", "Spaghetti a la bolognesa", 5500, catComidas, v7, null, null, 0.4, 0.6, false);
        crearNuevoItemMenu(catBebidas.getTipo_item(),"Te", "Te verde", 1800, catBebidas, v7, 0.3, false, null, null, null);
    }
}