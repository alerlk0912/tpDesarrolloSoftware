package Tp.DS;

class Plato extends ItemMenu {
    private final double peso; 
    private final double calorias;
    private final boolean aptoVegano;

    public Plato(int id, String nombre, String descripcion, double precio, Categoria categoria, Vendedor vendedor, double peso, double calorias, boolean aptoVegano) {
        super(id, nombre, descripcion, precio, categoria, vendedor);
        this.peso = peso;
        this.calorias = calorias;
        this.aptoVegano = aptoVegano;
    }

    @Override
    public String toString() {
        return "Plato{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", descripcion='" + getDescripcion() + '\'' +
                ", precio=" + getPrecio() +
                ", categoria='" + getCategoria() + '\'' +
                ", peso=" + peso +
                ", calorias=" + calorias +
                ", aptoVegano=" + aptoVegano +
                '}';
    }

    @Override
    public double peso() {
        return peso * 1.10; 
    }

    @Override
    public boolean esComida() {
        return true;
    }

    @Override
    public boolean esBebida() {
        return false;
    }

    @Override
    public boolean isAptoVegano() {
        return aptoVegano;
    }
}
