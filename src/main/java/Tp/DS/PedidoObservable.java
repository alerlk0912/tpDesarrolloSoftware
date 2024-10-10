package Tp.DS;


public interface PedidoObservable {
    public void agregarObservador(PedidoObserver observer);
    public void eliminarObservador(PedidoObserver observer);
    public void notificarObservadores();
    public void cambiarEstado(EstadoPedido nuevoEstado);
}
