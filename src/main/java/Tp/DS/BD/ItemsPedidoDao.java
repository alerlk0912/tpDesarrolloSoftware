package Tp.DS.BD;

import Tp.DS.ItemsPedido;
import java.util.List;

public interface ItemsPedidoDao {
    List<ItemsPedido> buscarPorCliente(String nombreCliente);
    List<ItemsPedido> buscarPorVendedor(String nombreVendedor);
    List<ItemsPedido> buscarPorRangoDePrecios(double precioMin, double precioMax);
    List<ItemsPedido> buscarPorRestaurante(String nombreRestaurante);
    List<ItemsPedido> ordenarPorCriterio(String criterio, boolean ascendente);
}
