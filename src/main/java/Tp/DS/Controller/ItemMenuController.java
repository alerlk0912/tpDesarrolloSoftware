package Tp.DS.Controller;

import Tp.DS.DAO.DAOItemMenu;
import Tp.DS.Bebida;
import Tp.DS.Categoria;
import Tp.DS.DAO.DAOException;
import Tp.DS.ItemMenu;
import Tp.DS.ItemMenuFactory;
import Tp.DS.Plato;
import Tp.DS.Vendedor;
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
}