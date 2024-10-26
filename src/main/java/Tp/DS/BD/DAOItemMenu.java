/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Tp.DS.BD;

import Tp.DS.ItemMenu;
import java.util.List;

/**
 *
 * @author franco
 */
public interface DAOItemMenu {
    public List<ItemMenu> listarItemsMenu();
    public void crearItemMenu(ItemMenu item);
    public void actualizarItemMenu(ItemMenu item);
    public void eliminarItemMenu(int id);
    public ItemMenu buscarItemMenuPorId(int id);
}
