package isi.deso.tpds.MetodoPago;

import java.util.List;

public interface DAOMetodoPago {

    Pago buscarPagoPorId(int id);
    List<Pago> buscarPagoPorMetodo(String metodoPago);
    void guardarPago(Pago pago);
    void eliminarPago(int id);
}
