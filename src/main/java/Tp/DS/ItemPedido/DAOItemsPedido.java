package Tp.DS.ItemPedido;

import java.util.List;

public interface DAOItemsPedido {
    List<ItemsPedido> buscarPorCliente(String nombreCliente);
    List<ItemsPedido> buscarPorVendedor(String nombreVendedor);
    List<ItemsPedido> buscarPorRangoDePrecios(double precioMin, double precioMax);
    List<ItemsPedido> buscarPorRestaurante(String nombreRestaurante);
    List<ItemsPedido> ordenarPorCriterio(String criterio, boolean ascendente);
    public List<ItemsPedido> listarItemsPedido();
    public void crearItemPedido(ItemsPedido itemPedido);
    public void actualizarItemPedido(ItemsPedido itemPedido);
    public void eliminarItemPedido(int id);
    public ItemsPedido buscarItemPedidoPorId(int id);

}
