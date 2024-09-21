package Tp.DS;

public abstract class ItemMenu {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private Categoria categoria;
    private Vendedor vendedor;

    public ItemMenu(int id, String nombre, String descripcion, double precio, Categoria categoria, Vendedor vendedor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.vendedor = vendedor;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }
    
    public Vendedor getVendedor() {
        return vendedor;
    }
    
    public abstract double peso();
    public abstract boolean esComida();
    public abstract boolean esBebida();
    public abstract boolean isAptoVegano();
}
