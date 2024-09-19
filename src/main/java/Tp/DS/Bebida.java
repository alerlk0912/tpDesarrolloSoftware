package Tp.DS;

public class Bebida extends ItemMenu {
    private final double tamanio; // Volumen en ml
    private final boolean graduacionAlcoholica;

    public Bebida(int id, String nombre, String descripcion, double precio, Categoria categoria, Vendedor vendedor, double tamanio, boolean alcoholica) {
        super(id, nombre, descripcion, precio, categoria, vendedor);
        this.tamanio = tamanio;
        this.graduacionAlcoholica = alcoholica;
    }

    @Override
    public String toString() {
        return "Bebida{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", descripcion='" + getDescripcion() + '\'' +
                ", precio=" + getPrecio() +
                ", categoria='" + getCategoria() + '\'' +
                ", tamanio=" + tamanio +
                ", alcoholica=" + graduacionAlcoholica +
                '}';
    }
    
    public double getTamanio() {
        return tamanio;
    }

    public boolean isBebidaAlcoholica() {
        return graduacionAlcoholica;
    }

    @Override
    public double peso() {
        double pesoBase = (graduacionAlcoholica ? tamanio * 0.99 : tamanio * 1.04); // 0.99 para alcohol, 1.04 para no alcohol
        return pesoBase * 1.20; // Aumentar 20% por el envase
    }

    @Override
    public boolean esComida() {
        return false;
    }

    @Override
    public boolean esBebida() {
        return true;
    }

    @Override
    public boolean isAptoVegano() {
        throw new UnsupportedOperationException("No aplica a bebida.");
    }
}
