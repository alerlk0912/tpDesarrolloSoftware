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

    public void agregarItemPedido(ItemsPedido itemPedido) {
        itemsPedidos.add(itemPedido);
    }

    @Override
	public List<ItemsPedido> buscarPorCliente(String nombreCliente) {
		List<ItemsPedido> resultado = itemsPedidos.stream()
				.filter(item -> item.getPedido().getCliente().getCuit().equalsIgnoreCase(nombreCliente) ||
								item.getPedido().getCliente().getNombre().equalsIgnoreCase(nombreCliente))
				.collect(Collectors.toList());

		if (resultado.isEmpty()) {
			throw new ItemNoEncontradoException("No se encontraron pedidos para el cliente: " + nombreCliente);
		}

		return resultado;
	}

    @Override
    public List<ItemsPedido> buscarPorVendedor(String nombreVendedor) {
        List<ItemsPedido> resultado = itemsPedidos.stream()
                .filter(item -> item.getItemMenu().getVendedor().getNombre().equalsIgnoreCase(nombreVendedor))
                .collect(Collectors.toList());

        if (resultado.isEmpty()) {
            throw new ItemNoEncontradoException("No se encontraron pedidos para el vendedor: " + nombreVendedor);
        }

        return resultado;
    }

    @Override
    public List<ItemsPedido> buscarPorRangoDePrecios(double precioMin, double precioMax) {
        List<ItemsPedido> resultado = itemsPedidos.stream()
                .filter(item -> item.getItemMenu().getPrecio() >= precioMin && item.getItemMenu().getPrecio() <= precioMax)
                .collect(Collectors.toList());

        if (resultado.isEmpty()) {
            throw new ItemNoEncontradoException("No se encontraron pedidos en el rango de precios: " + precioMin + " - " + precioMax);
        }

        return resultado;
    }

    @Override
    public List<ItemsPedido> buscarPorRestaurante(String nombreRestaurante) {
        List<ItemsPedido> resultado = itemsPedidos.stream()
                .filter(item -> item.getItemMenu().getVendedor().getNombre().equalsIgnoreCase(nombreRestaurante))
                .collect(Collectors.toList());

        if (resultado.isEmpty()) {
            throw new ItemNoEncontradoException("No se encontraron pedidos para el restaurante: " + nombreRestaurante);
        }

        return resultado;
    }

     @Override
    public List<ItemsPedido> ordenarPorCriterio(String criterio, boolean ascendente) {
        Comparator<ItemsPedido> comparador;

        switch (criterio.toLowerCase()) {
            case "cliente":
                comparador = Comparator.comparing(item -> item.getPedido().getCliente().getNombre());
                break;
            case "vendedor":
                comparador = Comparator.comparing(item -> item.getItemMenu().getVendedor().getNombre());
                break;
            case "precio":
                comparador = Comparator.comparing(item -> item.getItemMenu().getPrecio());
                break;
            default:
                throw new IllegalArgumentException("Criterio de ordenación no válido");
        }

        if (!ascendente) {
            comparador = comparador.reversed();
        }

        return itemsPedidos.stream()
                .sorted(comparador)
                .collect(Collectors.toList());
    }
}