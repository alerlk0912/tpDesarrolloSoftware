/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp.DS;

import Tp.DS.BD.DAOPedido;
import java.util.List;

/**
 *
 * @author franco
 */

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

    public void modificarPedido(int id, Cliente cliente, Pago metodoPago, List<ItemsPedido> items) {
        Pedido pedido = pedidoDAO.buscarPedidoPorId(id);
        if (pedido != null) {
            pedido.setMetodoPago(metodoPago);
            pedido.setItemsPedido(items);
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
