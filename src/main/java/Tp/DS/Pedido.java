package Tp.DS;

import java.util.List;

public class Pedido {
    private int id;
    private Cliente cliente;
    private Vendedor vendedor;
    private List<ItemMenu> items;
    private Pago metodoPago;
    private EstadoPedido estado;
    private double montoTotal;

    public Pedido(Cliente cliente, Vendedor vendedor, List<ItemMenu> items, Pago metodoPago) {
        if (!items.stream().allMatch(item -> item.getVendedor().equals(vendedor))) {
            throw new IllegalArgumentException("Todos los ítems deben pertenecer al mismo vendedor");
        }
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.items = items;
        this.metodoPago = metodoPago;
        this.estado = EstadoPedido.RECIBIDO;
        this.montoTotal = calcularMontoTotal();
    }

    private double calcularMontoTotal() {
        double montoBase = items.stream().mapToDouble(ItemMenu::getPrecio).sum();
        return metodoPago.calcularRecargo(montoBase);
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
