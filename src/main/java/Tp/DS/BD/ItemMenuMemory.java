/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp.DS.BD;

import Tp.DS.ItemMenu;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franco
 */
public class ItemMenuMemory implements DAOItemMenu {
    private List<ItemMenu> itemsMenu = new ArrayList<>();
    private int nextId = 1;

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
    public void actualizarItemMenu(ItemMenu item) {
        ItemMenu i = buscarItemMenuPorId(item.getId());
        if (i != null) {
            i.setNombre(item.getNombre());
            i.setPrecio(item.getPrecio());
        }
    }

    @Override
    public void eliminarItemMenu(int id) {
        itemsMenu.removeIf(i -> i.getId() == id);
    }

    @Override
    public ItemMenu buscarItemMenuPorId(int id) {
        return itemsMenu.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }
}
