package Tp.DS.ItemMenu;

import Tp.DS.ItemMenu.DAOItemMenu;
import Tp.DS.Categoria.Categoria;
import Tp.DS.Exceptions.DAOException;
import Tp.DS.Vendedor.Vendedor;
import java.util.List;

public class ItemMenuController {
    private DAOItemMenu itemMenuDAO;

    public ItemMenuController(DAOItemMenu itemMenuDAO) {
        this.itemMenuDAO = itemMenuDAO;
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

    public void modificarItemMenu(int id, ItemMenu itemActualizado) throws DAOException {
        ItemMenu item = itemMenuDAO.buscarItemMenuPorId(id);
        if (item != null) {
            itemMenuDAO.actualizarItemMenu(itemActualizado);
        }
    }

    public void eliminarItemMenu(int id) throws DAOException {
        itemMenuDAO.eliminarItemMenu(id);
    }

    public ItemMenu buscarItemMenu(int id) throws DAOException {
        return itemMenuDAO.buscarItemMenuPorId(id);
    }

    public void crearNuevaBebida(String text, String text0, double precio, Categoria categoriaItem, double parseDouble, boolean equals) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void crearNuevoPlato(String text, String text0, double precio, Categoria categoriaItem, double parseDouble, double parseDouble0, boolean equals) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}