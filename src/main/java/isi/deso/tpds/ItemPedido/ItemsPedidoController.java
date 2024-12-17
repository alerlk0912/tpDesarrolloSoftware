package isi.deso.tpds.ItemPedido;

import isi.deso.tpds.Exceptions.DAOException;
import isi.deso.tpds.ItemMenu.ItemMenu;
import isi.deso.tpds.ItemMenu.ItemMenuController;
import isi.deso.tpds.Pedido.Pedido;
import isi.deso.tpds.Pedido.PedidoController;
import java.util.List;

public class ItemsPedidoController {
    private static ItemsPedidoController instance;
    private DAOItemsPedido itemPedidoDAO;
    private PedidoController pedidoController;
    private ItemMenuController itemMenuController;

    private ItemsPedidoController(DAOItemsPedido itemPedidoDAO, PedidoController pedidoController, ItemMenuController itemMenuController) {
        this.itemPedidoDAO = itemPedidoDAO;
        this.pedidoController = pedidoController;
        this.itemMenuController = itemMenuController;
    }

    public static ItemsPedidoController getInstance(DAOItemsPedido itemPedidoDAO, PedidoController pedidoController, ItemMenuController itemMenuController) {
        if (instance == null) {
            instance = new ItemsPedidoController(itemPedidoDAO, pedidoController, itemMenuController);
        }
        return instance;
    }
    
    public static void resetInstance() {
        instance = null;
    }

    public List<ItemsPedido> mostrarListaItemsPedido() throws DAOException {
        return itemPedidoDAO.listarItemsPedido();
    }

    public void crearNuevoItemPedido(int itemMenuId, int cantidad) throws DAOException {
        ItemMenu itemMenu = itemMenuController.buscarItemMenu(itemMenuId);
        
        if (itemMenu != null && cantidad != 0) {
            ItemsPedido nuevoItemPedido = new ItemsPedido(itemMenu, cantidad);
            itemPedidoDAO.crearItemPedido(nuevoItemPedido);
        } else {
            throw new DAOException("Pedido o ItemMenu no encontrado");
        }
    }

    public void modificarItemPedido(int id, int itemMenuId, int cantidad) throws DAOException {
        ItemsPedido itemPedidoExistente = itemPedidoDAO.buscarItemPedidoPorId(id);
        
        if (itemPedidoExistente != null) {
            ItemMenu itemMenu = itemMenuController.buscarItemMenu(itemMenuId);

            if (itemMenu != null && cantidad != 0) {
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
    public ItemsPedido crearNuevoyRetornarItemPedido(int idItemMenu, int cantidad) throws DAOException{
        ItemMenu itemSeleccionado = itemMenuController.buscarItemMenu(idItemMenu);
        if (itemSeleccionado != null && cantidad != 0) {
            ItemsPedido nuevoItemPedido = new ItemsPedido(itemSeleccionado, cantidad);
            itemPedidoDAO.crearItemPedido(nuevoItemPedido);
            return nuevoItemPedido;
        } else {
            throw new DAOException("Pedido o ItemMenu no encontrado");
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
