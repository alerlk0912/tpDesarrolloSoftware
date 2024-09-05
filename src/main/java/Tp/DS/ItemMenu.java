package Tp.DS;

public abstract class ItemMenu {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private Categoria categoria;
    
    public ItemMenu(int id, String nombre, String descripcion,double precio, Categoria categoria) {
        this.id = id; 
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
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
    // metodos abstractos para las subclases Comida y Bebida
    public abstract double peso();
    public abstract boolean esComida();
    public abstract boolean esBebida();
    public abstract boolean isAptoVegano();
}
