package isi.deso.tpds.Pedido;

import java.sql.SQLException;
import java.util.List;

public interface DAOPedido {
    public List<Pedido> listarPedidos();
    public void crearPedido(Pedido pedido) throws SQLException;
    public void actualizarPedido(Pedido pedido) throws SQLException;
    public void eliminarPedido(int id);
    public Pedido buscarPedidoPorId(int id);
}
