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
        if (items == null || items.isEmpty()) {
        throw new IllegalArgumentException("La lista de ítems no puede estar vacía");
        }
        if (metodoPago == null) {
            throw new IllegalArgumentException("El método de pago no puede ser nulo");
        }
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

    public double calcularMontoTotal() {
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
                "cliente=" + cliente.getNombre() +
                ", vendedor=" + vendedor.getNombre() +
                ", items=" + items +
                ", metodoPago=" + metodoPago.getClass().getSimpleName() +
                ", estado=" + estado +
                '}';
    }
    
    // Método estático para crear y mostrar un pedido
    public static Pedido crearYMostrarPedido(Cliente cliente, Vendedor vendedor, List<ItemMenu> items, Pago metodoPago, String etiqueta) {
        // Verificar que todos los ítems pertenezcan al vendedor especificado
        for (ItemMenu item : items) {
            if (item.getVendedor().getId() != vendedor.getId()) {
                throw new IllegalArgumentException("Todos los ítems deben pertenecer al mismo vendedor.");
            }
        }

        // Crear el pedido
        Pedido pedido = new Pedido(cliente, vendedor, items, metodoPago);
        
        // Mostrar información del pedido
        System.out.println("Pedido " + etiqueta + " creado: " + pedido);
        System.out.println("Monto total con recargo (" + metodoPago.getClass().getSimpleName() + "): " + pedido.calcularMontoTotal());
        
        return pedido;
    }
}
