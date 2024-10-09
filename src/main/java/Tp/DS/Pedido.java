package Tp.DS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<ItemsPedido> itemsPedido;
    private Pago metodoPago;
    private EstadoPedido estado;
    private double montoTotal;

    public Pedido(int id, Cliente cliente, Pago metodoPago) {
        if (metodoPago == null) {
            throw new IllegalArgumentException("El método de pago no puede ser nulo");
        }
        this.id = id;
        this.cliente = cliente;
        this.metodoPago = metodoPago;
        this.itemsPedido = new ArrayList<>();
        this.estado = EstadoPedido.RECIBIDO;
    }

    // metodo para agregar ítems al pedido
    public void agregarItem(ItemsPedido item) throws VendedorNoCoincideException {
        if (itemsPedido.isEmpty()) {
            this.itemsPedido.add(item);
        } else {
            // verificar que todos los items sean del mismo vendedor
            Vendedor vendedorActual = itemsPedido.get(0).getItemMenu().getVendedor();
            if (!item.getItemMenu().getVendedor().equals(vendedorActual)) {
                throw new VendedorNoCoincideException("Todos los items del pedido deben ser del mismo vendedor");
            }
            this.itemsPedido.add(item);
        }
    }
   
    // metodo para calcular el total del pedido con recargo
    public void calcularTotalPedido() {
        double subtotal = itemsPedido.stream()
                .mapToDouble(item -> item.getItemMenu().getPrecio() * item.getCantidad())
                .sum();
        this.montoTotal = metodoPago.calcularRecargo(subtotal);
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
    
    public List<ItemsPedido> getItemsPedido() {
        return itemsPedido;
    }

    public Pago getMetodoPago() {
        return metodoPago;
    }
    
    public double getMontoTotal() {
        return montoTotal;
    }
    
    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Pedido{")
          .append("id=").append(id)
          .append(", cliente=").append(cliente.getNombre()) // Puedes personalizar cómo mostrar al cliente
          .append(", estado=").append(estado)
          .append(", montoTotal=").append(montoTotal)
          .append(", metodoPago=").append(metodoPago.getClass().getSimpleName())
          .append(", itemsPedido=[");

        // muestra los items del pedido
        for (ItemsPedido item : itemsPedido) {
            sb.append("{")
              .append("item=").append(item.getItemMenu().getNombre())
              .append(", cantidad=").append(item.getCantidad())
              .append(", precio=").append(item.getItemMenu().getPrecio())
              .append("}, ");
        }
        if (!itemsPedido.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }

        sb.append("]}");

        return sb.toString();
    }
    
    public static Pedido crearYMostrarPedido(int id, Cliente cliente, List<ItemsPedido> items, Pago metodoPago) throws VendedorNoCoincideException, PedidoInvalidoException {
        if (cliente == null) {
            throw new PedidoInvalidoException("El cliente no puede ser nulo.");
        }

        if (items == null || items.isEmpty()) {
            throw new PedidoInvalidoException("La lista de ítems seleccionados no puede estar vacía.");
        }

        Pedido pedido = new Pedido(id, cliente, metodoPago); // crear el pedido
        Vendedor vendedorPrincipal = items.get(0).getItemMenu().getVendedor();

        try {
            for (ItemsPedido item : items) {
                pedido.agregarItem(item);
            }
        } catch (VendedorNoCoincideException e) {
            System.err.println("Error al agregar ítem al pedido: " + e.getMessage());
            throw e; 
        }

        // mostrar la información del pedido
        try {
            System.out.println("Pedido creado para el cliente: " + cliente.getNombre());
            System.out.println("Vendedor: " + vendedorPrincipal.getNombre());
            System.out.println("Metodo de pago: " + pedido.metodoPago.getClass().getSimpleName());
            System.out.println("Items seleccionados:");
            for (ItemsPedido item : pedido.getItemsPedido()) {
                System.out.println(item.getItemMenu().getNombre() + " - Cantidad: " + item.getCantidad());
            }
            pedido.calcularTotalPedido();  // Asegúrate de calcular el total del pedido
            System.out.println("Monto total: " + pedido.getMontoTotal());
        } catch (Exception e) {
            System.err.println("Error al mostrar el pedido: " + e.getMessage());
            throw new PedidoInvalidoException("Error al mostrar el pedido.");
        }

        return pedido;
    }
}
