/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp.DS;

import Tp.DS.BD.DAOItemMenu;
import java.util.List;

/**
 *
 * @author franco
 */
public class ItemMenuController {
    private DAOItemMenu itemMenuDAO;

    public ItemMenuController(DAOItemMenu itemMenuDAO) {
        this.itemMenuDAO = itemMenuDAO;
    }

    public List<ItemMenu> mostrarListaItems() {
        return itemMenuDAO.listarItemsMenu();
    }

    public void crearNuevoItem(String nombre, String descripcion, double precio, Categoria categoria, Vendedor vendedor) {
        ItemMenu nuevoItem = new ItemMenu(nombre, descripcion, precio, categoria, vendedor);
        itemMenuDAO.crearItemMenu(nuevoItem);
    }

    public void modificarItem(int id, String nombre, String descripcion, double precio, Categoria categoria, Vendedor vendedor) {
        ItemMenu item = itemMenuDAO.buscarItemMenuPorId(id);
        if (item != null) {
            item.setNombre(nombre);
            item.setDescripcion(descripcion);
            item.setPrecio(precio);
            item.setCategoria(categoria);
            item.setVendedor(vendedor);
            itemMenuDAO.actualizarItemMenu(item);
        }
    }

    public void eliminarItem(int id) {
        itemMenuDAO.eliminarItemMenu(id);
    }

    public ItemMenu buscarItem(int id) {
        return itemMenuDAO.buscarItemMenuPorId(id);
    }
}
