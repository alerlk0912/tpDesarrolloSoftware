package isi.deso.tpds.ItemMenu;

import isi.deso.tpds.Plato;
import isi.deso.tpds.Bebida;
import isi.deso.tpds.Exceptions.DAOException;
import isi.deso.tpds.Vendedor.Vendedor;
import java.util.List;

public interface DAOItemMenu {
    List<ItemMenu> listarItemsMenu() throws DAOException;
    void crearItemMenu(ItemMenu item) throws DAOException;
    void actualizarItemMenu(ItemMenu item, double tamanio, boolean alcholica, double peso, double calorias, boolean aptoVegano) throws DAOException;
    void actualizarItemMenu(ItemMenu item) throws DAOException;
    void actualizarVendedorDeItemMenu(int itemMenuID, int nuevoVendedorID);
    void eliminarItemMenu(int id) throws DAOException;
    ItemMenu buscarItemMenuPorId(int id) throws DAOException;
    List<ItemMenu> buscarItemsPorCriterios(int id, String nombre, double precio, String categoria, Vendedor vendedor) throws DAOException;
    Plato obtenerDatosPlato(int item);
    Bebida obtenerDatosBebida(int item);
}
