/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp.DS.BD;

import Tp.DS.Pedido;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franco
 */
public class PedidoMemory implements DAOPedido {
    private List<Pedido> pedidos = new ArrayList<>();
    private int nextId = 1;

    @Override
    public List<Pedido> listarPedidos() {
        return pedidos;
    }

    @Override
    public void crearPedido(Pedido pedido) {
        pedido.setId(nextId++);
        pedidos.add(pedido);
    }

    @Override
    public void actualizarPedido(Pedido pedido) {
        Pedido p = buscarPedidoPorId(pedido.getId());
        if (p != null) {
            p.setItemsPedido(pedido.getItemsPedido());
        }
    }

    @Override
    public void eliminarPedido(int id) {
        pedidos.removeIf(p -> p.getId() == id);
    }

    @Override
    public Pedido buscarPedidoPorId(int id) {
        return pedidos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}
