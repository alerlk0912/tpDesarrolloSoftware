package Tp.DS.ItemPedido;

import Tp.DS.Exceptions.DAOException;
import java.util.List;

public interface DAOItemsPedido {
    List<ItemsPedido> buscarPorCliente(String nombreCliente);
    List<ItemsPedido> buscarPorVendedor(String nombreVendedor);
    List<ItemsPedido> buscarPorRangoDePrecios(double precioMin, double precioMax);
    List<ItemsPedido> buscarPorRestaurante(String nombreRestaurante);
    List<ItemsPedido> ordenarPorCriterio(String criterio, boolean ascendente);
    public List<ItemsPedido> listarItemsPedido() throws DAOException;
    public void crearItemPedido(ItemsPedido itemPedido) throws DAOException;
    public void actualizarItemPedido(ItemsPedido itemPedido) throws DAOException;
    public void eliminarItemPedido(int id) throws DAOException;
    public ItemsPedido buscarItemPedidoPorId(int id) throws DAOException;

}
