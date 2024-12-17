package isi.deso.tpds.ItemPedido;

import isi.deso.tpds.Exceptions.DAOException;
import java.util.List;

public interface DAOItemsPedido {
    List<ItemsPedido> buscarPorCliente(String nombreCliente);
    List<ItemsPedido> buscarPorVendedor(String nombreVendedor);
    List<ItemsPedido> buscarPorRangoDePrecios(double precioMin, double precioMax);
    List<ItemsPedido> buscarPorRestaurante(String nombreRestaurante);
    List<ItemsPedido> ordenarPorCriterio(String criterio, boolean ascendente);
    List<ItemsPedido> listarItemsPedido() throws DAOException;
    void crearItemPedido(ItemsPedido itemPedido) throws DAOException;
    void actualizarItemPedido(ItemsPedido itemPedido) throws DAOException;
    void eliminarItemPedido(int id) throws DAOException;
    ItemsPedido buscarItemPedidoPorId(int id) throws DAOException;

}
