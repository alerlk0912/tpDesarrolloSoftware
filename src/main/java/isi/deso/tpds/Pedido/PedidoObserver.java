package isi.deso.tpds.Pedido;

import isi.deso.tpds.MetodoPago.Pago;

public interface PedidoObserver {
    void actualizarEstado(Pedido pedido, Pago metodoPago);
}
