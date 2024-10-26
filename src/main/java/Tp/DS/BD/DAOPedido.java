/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Tp.DS.BD;

import Tp.DS.Pedido;
import java.util.List;

/**
 *
 * @author franco
 */
public interface DAOPedido {
    public List<Pedido> listarPedidos();
    public void crearPedido(Pedido pedido);
    public void actualizarPedido(Pedido pedido);
    public void eliminarPedido(int id);
    public Pedido buscarPedidoPorId(int id);
}
