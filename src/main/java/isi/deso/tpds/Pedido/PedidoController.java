package isi.deso.tpds.Pedido;

import isi.deso.tpds.MetodoPago.Pago;
import isi.deso.tpds.Cliente.Cliente;
import isi.deso.tpds.ItemPedido.ItemsPedido;

import java.sql.SQLException;
import java.util.Date;
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

    public void crearNuevoPedido(Cliente cliente, Pago metodoPago) throws SQLException {
        Pedido nuevoPedido = new Pedido(cliente, metodoPago);
        pedidoDAO.crearPedido(nuevoPedido);
    }
    public Pedido crearRetornarPedido(Cliente cliente, Pago metodoPago, List<ItemsPedido> itemsAsignados, double base, double total) throws SQLException {
        Pedido nuevoPedido = new Pedido(cliente, metodoPago);
        nuevoPedido.setCliente(cliente);
        nuevoPedido.setFechaPago(new Date());
        nuevoPedido.setItemsPedido(itemsAsignados);
        nuevoPedido.setMontoBase(base);
        nuevoPedido.setMontoTotal(total);
        pedidoDAO.crearPedido(nuevoPedido);
        return nuevoPedido;
    }

    public void modificarPedido(int id, Cliente cliente, Pago pago, List<ItemsPedido> items, double montoBase, double montoTotal) throws SQLException {
        Pedido pedido = buscarPedido(id);
        pedido.setCliente(cliente);
        pedido.setMetodoPago(pago);
        pedido.setItemsPedido(items);
        pedido.setMontoBase(montoBase);
        pedido.setMontoTotal(montoTotal);
        pedido.setFechaPago(new Date());

        pedidoDAO.actualizarPedido(pedido);
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
