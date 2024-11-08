package Tp.DS.Pedido;

import Tp.DS.Pedido.DAOPedido;
import Tp.DS.Cliente.Cliente;
import Tp.DS.MetodoPago.Pago;

import java.util.List;


public class PedidoController {
    private DAOPedido pedidoDAO;

    public PedidoController(DAOPedido pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
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
}
