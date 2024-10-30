/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp.DS;

import Tp.DS.BD.DAOItemMenu;
import java.sql.SQLException;
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

    public List<ItemMenu> mostrarListaItemsMenu() throws SQLException {
        return itemMenuDAO.listarItemsMenu();
    }

    public void crearNuevoPlato(String nombre, String descripcion, double precio, Categoria categoria, Vendedor vendedor, double peso, double calorias, boolean aptoVegano) throws SQLException {
        Plato nuevoPlato = new Plato(nombre, descripcion, precio, categoria, vendedor, peso, calorias, aptoVegano);
        itemMenuDAO.crearItemMenu(nuevoPlato);
    }

    public void crearNuevaBebida(String nombre, String descripcion, double precio, Categoria categoria, Vendedor vendedor, double tamanio, boolean alcoholica) throws SQLException {
        Bebida nuevaBebida = new Bebida(nombre, descripcion, precio, categoria, vendedor, tamanio, alcoholica);
        itemMenuDAO.crearItemMenu(nuevaBebida);
    }

    public void modificarItemMenu(int id, ItemMenu itemActualizado) throws SQLException {
        ItemMenu item = itemMenuDAO.buscarItemMenuPorId(id);
        if (item != null) {
            itemMenuDAO.actualizarItemMenu(itemActualizado);
        }
    }

    public void eliminarItemMenu(int id) throws SQLException {
        itemMenuDAO.eliminarItemMenu(id);
    }

    public ItemMenu buscarItemMenu(int id) throws SQLException {
        return itemMenuDAO.buscarItemMenuPorId(id);
    }
}
