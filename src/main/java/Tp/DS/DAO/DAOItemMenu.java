package Tp.DS.DAO;

import Tp.DS.ItemMenu;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public interface DAOItemMenu {
    public List<ItemMenu> listarItemsMenu() throws DAOException;
    public void crearItemMenu(ItemMenu item) throws DAOException;
    public void actualizarItemMenu(ItemMenu item) throws DAOException;
    public void eliminarItemMenu(int id) throws DAOException;
    public ItemMenu buscarItemMenuPorId(int id) throws DAOException;
}
