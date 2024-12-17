package isi.deso.tpds.ItemPedido;

import isi.deso.tpds.Exceptions.DAOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ItemPedidoMemory implements DAOItemsPedido {
    private List<ItemsPedido> itemsPedidos = new ArrayList<>();
    private int nextId = 1;
    private static ItemPedidoMemory instance;
    
    private ItemPedidoMemory(){
    }
    
    public static ItemPedidoMemory getInstance() {
        if (instance == null) {
            instance = new ItemPedidoMemory();
        }
        return instance;
    }

    public void agregarItemPedido(ItemsPedido item) throws DAOException{
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

    @Override
    public List<ItemsPedido> listarItemsPedido() {
        return itemsPedidos;
    }

    @Override
    public void crearItemPedido(ItemsPedido itemPedido) {
        itemPedido.setId(nextId++); 
        itemsPedidos.add(itemPedido);
    }

    @Override
    public void actualizarItemPedido(ItemsPedido itemPedido) throws DAOException{
        ItemsPedido actualizadoItem = buscarItemPedidoPorId(itemPedido.getId());
        
        if (actualizadoItem != null) {
            actualizadoItem.setCantidad(itemPedido.getCantidad());
            actualizadoItem.setItemMenu(itemPedido.getItemMenu());
        } else {
            throw new DAOException("ItemPedido no encontrado con el ID: " + itemPedido.getId());
        }
    }

    @Override
    public void eliminarItemPedido(int id) {
        itemsPedidos.removeIf(i -> i.getId() == id); 
    }

    @Override
    public ItemsPedido buscarItemPedidoPorId(int id){
        return itemsPedidos.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
