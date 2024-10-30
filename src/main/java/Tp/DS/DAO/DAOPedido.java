package Tp.DS.DAO;

import Tp.DS.Pedido;
import java.sql.SQLException;
import java.util.List;

public interface DAOPedido {
    public List<Pedido> listarPedidos();
    public void crearPedido(Pedido pedido);
    public void actualizarPedido(Pedido pedido);
    public void eliminarPedido(int id);
    public Pedido buscarPedidoPorId(int id);
}
