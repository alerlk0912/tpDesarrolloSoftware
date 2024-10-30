package Tp.DS.DAO;

import Tp.DS.ItemMenu;
import java.sql.SQLException;
import java.util.List;


public interface DAOItemMenu {
    public List<ItemMenu> listarItemsMenu() throws SQLException;
    public void crearItemMenu(ItemMenu item) throws SQLException;
    public void actualizarItemMenu(ItemMenu item) throws SQLException;
    public void eliminarItemMenu(int id) throws SQLException;
    public ItemMenu buscarItemMenuPorId(int id) throws SQLException;
}
