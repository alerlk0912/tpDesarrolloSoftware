package Tp.DS.Pedido;

import Tp.DS.MetodoPago.Pago;

public interface PedidoObserver {
    void actualizarEstado(Pedido pedido, Pago metodoPago);
}
