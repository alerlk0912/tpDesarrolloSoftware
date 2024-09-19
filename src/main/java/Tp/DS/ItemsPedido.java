package Tp.DS;

public class ItemsPedido {
    private int id;
    private ItemMenu itemMenu; // Relacionado con ItemMenu
    private Pedido pedido; // Relacionado con Pedido
    private int cantidad;

    public ItemsPedido(int id, ItemMenu itemMenu, Pedido pedido, int cantidad) {
        this.id = id;
        this.itemMenu = itemMenu;
        this.pedido = pedido;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public ItemMenu getItemMenu() {
        return itemMenu;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return "ItemsPedido{" +
                "id=" + id +
                ", itemMenu=" + itemMenu +
                ", pedido=" + pedido +
                ", cantidad=" + cantidad +
                '}';
    }
}
