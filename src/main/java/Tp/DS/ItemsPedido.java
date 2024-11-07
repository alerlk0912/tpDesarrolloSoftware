package Tp.DS;

public class ItemsPedido {
    private int id;
    private ItemMenu itemMenu;
    private Pedido pedido;
    private int cantidad;

    public ItemsPedido( ItemMenu itemMenu, Pedido pedido, int cantidad) {
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


    public int getCantidad() {
        return cantidad;
    }

    public Pedido getPedido() {
        return pedido;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    public void setItemMenu(ItemMenu itemMenu) {
        this.itemMenu = itemMenu;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ItemsPedido{" +
                "id=" + id +
                ", vendedor=" + itemMenu.getVendedor().getNombre() +
                ", itemMenu=" + itemMenu +
                ", cantidad=" + cantidad +
                '}';
    }

    

}
