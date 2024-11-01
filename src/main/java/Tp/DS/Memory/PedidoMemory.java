package Tp.DS.Memory;

import Tp.DS.DAO.DAOPedido;
import Tp.DS.Pedido;
import java.util.ArrayList;
import java.util.List;

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
            p.setMetodoPago(pedido.getMetodoPago());
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
