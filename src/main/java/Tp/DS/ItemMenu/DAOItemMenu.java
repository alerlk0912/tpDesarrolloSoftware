package Tp.DS.ItemMenu;

import Tp.DS.Exceptions.DAOException;
import Tp.DS.*;
import Tp.DS.Vendedor.Vendedor;
import java.util.List;

public interface DAOItemMenu {
    public List<ItemMenu> listarItemsMenu() throws DAOException;
    public void crearItemMenu(ItemMenu item) throws DAOException;
    public void actualizarItemMenu(ItemMenu item, double tamanio, boolean alcholica, double peso, double calorias, boolean aptoVegano) throws DAOException;
    public void actualizarItemMenu(ItemMenu item) throws DAOException;
    public void eliminarItemMenu(int id) throws DAOException;
    public ItemMenu buscarItemMenuPorId(int id) throws DAOException;
    public List<ItemMenu> buscarItemsPorCriterios(int id, String nombre, double precio, String categoria, Vendedor vendedor) throws DAOException;

    public Plato obtenerDatosPlato(int item);
    public Bebida obtenerDatosBebida(int item);
}
