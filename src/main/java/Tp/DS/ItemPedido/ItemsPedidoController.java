package Tp.DS.ItemPedido;

import Tp.DS.Exceptions.DAOException;
import Tp.DS.ItemMenu.ItemMenu;
import Tp.DS.ItemMenu.ItemMenuController;
import Tp.DS.Pedido.Pedido;
import Tp.DS.Pedido.PedidoController;
import java.util.List;

public class ItemsPedidoController {
    private DAOItemsPedido itemPedidoDAO;
    private PedidoController pedidoController;
    private ItemMenuController itemMenuController;

    public ItemsPedidoController(DAOItemsPedido itemPedidoDAO, PedidoController pedidoController, ItemMenuController itemMenuController) {
        this.itemPedidoDAO = itemPedidoDAO;
        this.pedidoController = pedidoController;
        this.itemMenuController = itemMenuController;
    }

    public List<ItemsPedido> mostrarListaItemsPedido() throws DAOException {
        return itemPedidoDAO.listarItemsPedido();
    }

    public void crearNuevoItemPedido(int itemMenuId, int pedidoId, int cantidad) throws DAOException {
        Pedido pedido = pedidoController.buscarPedido(pedidoId);
        ItemMenu itemMenu = itemMenuController.buscarItemMenu(itemMenuId);
        
        if (pedido != null && itemMenu != null) {
            ItemsPedido nuevoItemPedido = new ItemsPedido(itemMenu, pedido, cantidad);
            itemPedidoDAO.crearItemPedido(nuevoItemPedido);
        } else {
            throw new DAOException("Pedido o ItemMenu no encontrado");
        }
    }

    public void modificarItemPedido(int id, int pedidoId, int itemMenuId, int cantidad) throws DAOException {
        ItemsPedido itemPedidoExistente = itemPedidoDAO.buscarItemPedidoPorId(id);
        
        if (itemPedidoExistente != null) {
            Pedido pedido = pedidoController.buscarPedido(pedidoId);
            ItemMenu itemMenu = itemMenuController.buscarItemMenu(itemMenuId);

            if (pedido != null && itemMenu != null) {
                itemPedidoExistente.setPedido(pedido);
                itemPedidoExistente.setItemMenu(itemMenu);
                itemPedidoExistente.setCantidad(cantidad);
                
                itemPedidoDAO.actualizarItemPedido(itemPedidoExistente);
            } else {
                throw new DAOException("Pedido o ItemMenu no encontrado para actualizar");
            }
        } else {
            throw new DAOException("ItemPedido no encontrado");
        }
    }

    public void eliminarItemPedido(int id) throws DAOException {
        itemPedidoDAO.eliminarItemPedido(id);
    }

    public ItemsPedido buscarItemPedido(int id) throws DAOException {
        return itemPedidoDAO.buscarItemPedidoPorId(id);
    }

    public List<ItemsPedido> buscarItemsPedidoPorCliente(String nombreCliente) throws DAOException {
        return itemPedidoDAO.buscarPorCliente(nombreCliente);
    }

    public List<ItemsPedido> buscarItemsPedidoPorVendedor(String nombreVendedor) throws DAOException {
        return itemPedidoDAO.buscarPorVendedor(nombreVendedor);
    }

    public List<ItemsPedido> buscarItemsPedidoPorRangoDePrecios(double precioMin, double precioMax) throws DAOException {
        return itemPedidoDAO.buscarPorRangoDePrecios(precioMin, precioMax);
    }

    public List<ItemsPedido> buscarItemsPedidoPorRestaurante(String nombreRestaurante) throws DAOException {
        return itemPedidoDAO.buscarPorRestaurante(nombreRestaurante);
    }

    public List<ItemsPedido> ordenarItemsPedidoPorCriterio(String criterio, boolean ascendente) throws DAOException {
        return itemPedidoDAO.ordenarPorCriterio(criterio, ascendente);
    }
    public ItemMenu buscarItemMenu(int idItemMenu) {
        try {
            return itemMenuController.buscarItemMenu(idItemMenu);
        } catch (Exception e) {
            System.err.println("Error al buscar ItemMenu con ID " + idItemMenu + ": " + e.getMessage());
            return null;
        }
    }

    
    public Pedido buscarPedido(int idPedido) {
        try {
            return pedidoController.buscarPedido(idPedido);
        } catch (Exception e) {
            System.err.println("Error al buscar Pedido con ID " + idPedido + ": " + e.getMessage());
            return null;
        }
    }
}
