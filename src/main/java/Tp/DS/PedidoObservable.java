/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Tp.DS;


public interface PedidoObservable {
    public void agregarObservador(PedidoObserver observer);
    public void eliminarObservador(PedidoObserver observer);
    public void notificarObservadores();
    public void cambiarEstado(EstadoPedido nuevoEstado);
}
