package Tp.DS.DAO;

import Tp.DS.ItemMenu;
import java.sql.SQLException;
import java.util.List;


public interface DAOItemMenu {
    public List<ItemMenu> listarItemsMenu();
    public void crearItemMenu(ItemMenu item);
    public void actualizarItemMenu(ItemMenu item);
    public void eliminarItemMenu(int id);
    public ItemMenu buscarItemMenuPorId(int id);
}
