package Tp.DS.ItemMenu;

import Tp.DS.Exceptions.DAOException;

import java.util.List;


public interface DAOItemMenu {
    public List<ItemMenu> listarItemsMenu() throws DAOException;
    public void crearItemMenu(ItemMenu item) throws DAOException;
    public void actualizarItemMenu(ItemMenu item) throws DAOException;
    public void eliminarItemMenu(int id) throws DAOException;
    public ItemMenu buscarItemMenuPorId(int id) throws DAOException;
}
