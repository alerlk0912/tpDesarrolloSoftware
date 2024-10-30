/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Tp.DS.BD;

import Tp.DS.Pedido;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author franco
 */
public interface DAOPedido {
    public List<Pedido> listarPedidos() throws SQLException;
    public void crearPedido(Pedido pedido) throws SQLException;
    public void actualizarPedido(Pedido pedido) throws SQLException;
    public void eliminarPedido(int id) throws SQLException;
    public Pedido buscarPedidoPorId(int id) throws SQLException;
}
