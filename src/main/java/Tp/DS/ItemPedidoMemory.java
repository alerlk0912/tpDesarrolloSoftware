package Tp.DS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ItemPedidoMemory implements ItemsPedidoDao {
    private List<ItemsPedido> itemsPedidos;

    public ItemPedidoMemory() {
        this.itemsPedidos = new ArrayList<>();
    }

    public void agregarItemPedido(ItemsPedido item) {
        itemsPedidos.add(item);
    }

    @Override
    public List<ItemsPedido> buscarPorCliente(String nombreCliente) {
        return itemsPedidos.stream()
            .filter(item -> item.getItemMenu().getVendedor().getNombre().equals(nombreCliente))
            .collect(Collectors.toList());
    }

    @Override
    public List<ItemsPedido> buscarPorVendedor(String nombreVendedor) {
        return itemsPedidos.stream()
            .filter(item -> item.getItemMenu().getVendedor().getNombre().equals(nombreVendedor))
            .collect(Collectors.toList());
    }

    @Override
    public List<ItemsPedido> buscarPorRangoDePrecios(double precioMin, double precioMax) {
        return itemsPedidos.stream()
            .filter(item -> {
                double precio = item.getItemMenu().getPrecio();
                return precio >= precioMin && precio <= precioMax;
            })
            .collect(Collectors.toList());
    }

    @Override
    public List<ItemsPedido> buscarPorRestaurante(String nombreRestaurante) {
        return itemsPedidos.stream()
            .filter(item -> item.getItemMenu().getVendedor().getNombre().equals(nombreRestaurante))
            .collect(Collectors.toList());
    }

    @Override
    public List<ItemsPedido> ordenarPorCriterio(String criterio, boolean ascendente) {
        Comparator<ItemsPedido> comparator;
        switch (criterio.toLowerCase()) {
            case "precio":
                comparator = Comparator.comparing(item -> item.getItemMenu().getPrecio());
                break;
            case "cantidad":
                comparator = Comparator.comparing(ItemsPedido::getCantidad);
                break;
            case "nombre":
                comparator = Comparator.comparing(item -> item.getItemMenu().getNombre());
                break;
            default:
                throw new IllegalArgumentException("Criterio de ordenamiento no válido");
        }

        if (!ascendente) {
            comparator = comparator.reversed();
        }

        return itemsPedidos.stream()
            .sorted(comparator)
            .collect(Collectors.toList());
    }
}
