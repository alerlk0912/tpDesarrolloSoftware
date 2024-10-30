/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Tp.DS.BD;

import Tp.DS.ItemMenu;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author franco
 */
public interface DAOItemMenu {
    public List<ItemMenu> listarItemsMenu() throws SQLException;
    public void crearItemMenu(ItemMenu item) throws SQLException;
    public void actualizarItemMenu(ItemMenu item) throws SQLException;
    public void eliminarItemMenu(int id) throws SQLException;
    public ItemMenu buscarItemMenuPorId(int id) throws SQLException;
}
