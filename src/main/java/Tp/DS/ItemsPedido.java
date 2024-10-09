package Tp.DS;

public class ItemsPedido {
    private int id;
    private ItemMenu itemMenu;
    private int cantidad;

    public ItemsPedido(int id, ItemMenu itemMenu, int cantidad) {
        this.id = id;
        this.itemMenu = itemMenu;
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
