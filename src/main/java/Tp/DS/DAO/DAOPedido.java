package Tp.DS.DAO;

import Tp.DS.Pedido;
import java.sql.SQLException;
import java.util.List;

public interface DAOPedido {
    public List<Pedido> listarPedidos() throws SQLException;
    public void crearPedido(Pedido pedido) throws SQLException;
    public void actualizarPedido(Pedido pedido) throws SQLException;
    public void eliminarPedido(int id) throws SQLException;
    public Pedido buscarPedidoPorId(int id) throws SQLException;
}
