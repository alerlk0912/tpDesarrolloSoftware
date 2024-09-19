package Tp.DS;

public class Pedido {
    private int id;
    private Cliente cliente; // Relacionado con la clase Cliente

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "Pedido{" +
               "id=" + id +
               ", cliente=" + cliente +
               '}';
    }
}
