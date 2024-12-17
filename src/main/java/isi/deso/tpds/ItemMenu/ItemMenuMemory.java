package isi.deso.tpds.ItemMenu;

import isi.deso.tpds.Bebida;
import isi.deso.tpds.Exceptions.DAOException;
import isi.deso.tpds.Plato;
import isi.deso.tpds.Vendedor.Vendedor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemMenuMemory implements DAOItemMenu {
    private final List<ItemMenu> itemsMenu = new ArrayList<>();
    private int nextId = 1;
    private static ItemMenuMemory instance;
    
    private ItemMenuMemory(){
    }
    
    public static ItemMenuMemory getInstance() {
        if (instance == null) {
            instance = new ItemMenuMemory();
        }
        return instance;
    }

    @Override
    public List<ItemMenu> listarItemsMenu() {
        return itemsMenu;
    }

    
    @Override
    public void crearItemMenu(ItemMenu item) {
        item.setId(nextId++);
        itemsMenu.add(item);
    }

    @Override
    public void actualizarItemMenu(ItemMenu item) throws DAOException {
        ItemMenu itemActualizar = buscarItemMenuPorId(item.getId());
        if (itemActualizar != null) {
            itemActualizar.setNombre(item.getNombre());
            itemActualizar.setDescripcion(item.getDescripcion());
            itemActualizar.setPrecio(item.getPrecio());
        } else {
            throw new DAOException("ItemMenu no encontrado con el ID: " + item.getId());
        }
    }

    @Override
    public void actualizarVendedorDeItemMenu(int itemMenuID, int nuevoVendedorID) {
        //No se implementa
    }

    @Override
    public void eliminarItemMenu(int id) {
        itemsMenu.removeIf(i -> i.getId() == id);
    }

    @Override
    public ItemMenu buscarItemMenuPorId(int id) throws DAOException {
        return itemsMenu.stream()
            .filter(i -> i.getId() == id)
            .findFirst().orElse(null);
    }
    @Override
    public List<ItemMenu> buscarItemsPorCriterios(int id, String nombre, double precio, String categoria, Vendedor vendedor) throws DAOException {
        return itemsMenu.stream()
            .filter(item -> (id == 0 || item.getId() == id))
            .filter(item -> (nombre == null || nombre.isEmpty() || item.getNombre().toLowerCase().contains(nombre.toLowerCase())))
            .filter(item -> (precio == 0.0 || item.getPrecio() == precio))
            .filter(item -> (categoria == null || categoria.isEmpty() || item.getCategoria().getTipo_item().equalsIgnoreCase(categoria)))
            .filter(item -> (vendedor == null || item.getVendedor().equals(vendedor)))
            .collect(Collectors.toList());
    }

    @Override
    public void actualizarItemMenu(ItemMenu item, double tamanio, boolean alcholica, double peso, double calorias, boolean aptoVegano) throws DAOException {
        //
    }

    @Override
    public Plato obtenerDatosPlato(int item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Bebida obtenerDatosBebida(int item) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
