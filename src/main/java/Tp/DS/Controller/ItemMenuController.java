package Tp.DS.Controller;

import Tp.DS.DAO.DAOItemMenu;
import Tp.DS.Bebida;
import Tp.DS.Categoria;
import Tp.DS.ItemMenu;
import Tp.DS.Plato;
import Tp.DS.Vendedor;
import java.sql.SQLException;
import java.util.List;

public class ItemMenuController {
    private DAOItemMenu itemMenuDAO;

    public ItemMenuController(DAOItemMenu itemMenuDAO) {
        this.itemMenuDAO = itemMenuDAO;
    }

    public List<ItemMenu> mostrarListaItemsMenu() {
        return itemMenuDAO.listarItemsMenu();
    }

    public void crearNuevoPlato(String nombre, String descripcion, double precio, Categoria categoria, Vendedor vendedor, double peso, double calorias, boolean aptoVegano) {
        Plato nuevoPlato = new Plato(nombre, descripcion, precio, categoria, vendedor, peso, calorias, aptoVegano);
        itemMenuDAO.crearItemMenu(nuevoPlato);
    }

    public void crearNuevaBebida(String nombre, String descripcion, double precio, Categoria categoria, Vendedor vendedor, double tamanio, boolean alcoholica)  {
        Bebida nuevaBebida = new Bebida(nombre, descripcion, precio, categoria, vendedor, tamanio, alcoholica);
        itemMenuDAO.crearItemMenu(nuevaBebida);
    }

    public void modificarItemMenu(int id, ItemMenu itemActualizado) {
        ItemMenu item = itemMenuDAO.buscarItemMenuPorId(id);
        if (item != null) {
            itemMenuDAO.actualizarItemMenu(itemActualizado);
        }
    }

    public void eliminarItemMenu(int id) {
        itemMenuDAO.eliminarItemMenu(id);
    }

    public ItemMenu buscarItemMenu(int id) throws SQLException {
        return itemMenuDAO.buscarItemMenuPorId(id);
    }
}
