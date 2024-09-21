package Tp.DS;

public class Pedido {
    private int id;
    private Cliente cliente;
    private EstadoPedido estado; // Referencia al enum EstadoPedido

    public Pedido(int id, Cliente cliente, EstadoPedido estado) {
        this.id = id;
        this.cliente = cliente;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido{" +
               "id=" + id +
               ", cliente=" + cliente +
               ", estado=" + estado +
               '}';
    }
}
