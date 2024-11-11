package Tp.DS.ItemMenu;

import Tp.DS.Exceptions.DAOException;
import Tp.DS.ItemMenu.DAOItemMenu;

import java.util.ArrayList;
import java.util.List;

public class ItemMenuMemory implements DAOItemMenu {
    private List<ItemMenu> itemsMenu = new ArrayList<>();
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
    public void eliminarItemMenu(int id) {
        itemsMenu.removeIf(i -> i.getId() == id);
    }

    @Override
    public ItemMenu buscarItemMenuPorId(int id) throws DAOException {
        return itemsMenu.stream()
            .filter(i -> i.getId() == id)
            .findFirst().orElse(null);
    }
}
