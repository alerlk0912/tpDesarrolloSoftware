package Tp.DS.Pedido;

import Tp.DS.Cliente.Cliente;
import Tp.DS.ItemPedido.ItemsPedido;
import Tp.DS.MetodoPago.Pago;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoController {
    private static PedidoController instance;
    private DAOPedido pedidoDAO;

    private PedidoController(DAOPedido pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }
    
    public static PedidoController getInstance(DAOPedido pedidoDAO) {
        if (instance == null) {
            instance = new PedidoController(pedidoDAO);
        }
        return instance;
    }

    public List<Pedido> mostrarListaPedidos() {
        return pedidoDAO.listarPedidos();
    }

    public void crearNuevoPedido(Cliente cliente, Pago metodoPago) {
        Pedido nuevoPedido = new Pedido(cliente, metodoPago);
        pedidoDAO.crearPedido(nuevoPedido);
    }
    public Pedido crearRetornarPedido(Cliente cliente, Pago metodoPago) {
        Pedido nuevoPedido = new Pedido(cliente, metodoPago);
        pedidoDAO.crearPedido(nuevoPedido);
        return nuevoPedido;
    }

    public void modificarPedido(int id, Cliente cliente, Pago metodoPago) {
        Pedido pedido = pedidoDAO.buscarPedidoPorId(id);
        if (pedido != null) {
            pedido.setCliente(cliente);
            pedido.setMetodoPago(metodoPago);
            pedidoDAO.actualizarPedido(pedido);
        }
    }
    
    public void eliminarPedido(int id) {
        pedidoDAO.eliminarPedido(id);
    }
    
    public Pedido buscarPedido(int id) {
        return pedidoDAO.buscarPedidoPorId(id);
    }
    public String obtenerNombresItems(Pedido pedido){
        List<ItemsPedido> itemsPedido = pedido.getItemsPedido();
        return itemsPedido.stream()
                .map(item -> item.getItemMenu().getNombre())
                .collect(Collectors.joining(", "));
    }
    public Double calcularTotalPedido(List<ItemsPedido> itemsPedido) {
        double subtotal = itemsPedido.stream()
                .mapToDouble(item -> item.getItemMenu().getPrecio() * item.getCantidad())
                .sum();
        return subtotal;
    }
    public Double calcularMontoTotal(Double montoBase, Pago metodoPago){
        return metodoPago.calcularRecargo(montoBase);
    }
}
