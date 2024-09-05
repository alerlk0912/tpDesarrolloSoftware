package Tp.DS;

class Plato extends ItemMenu {
    private final double peso; // peso en gramos
    private final double calorias; // calorias en kcal
    private final boolean aptoVegano;

    public Plato(int id, String nombre, String descripcion, double precio, Categoria categoria, double peso, double calorias, boolean aptoVegano) {
        super(id, nombre, descripcion, precio, categoria);
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
   
    public double getPeso() {
        return peso;
    }

    public double getCalorias() {
        return calorias;
    }

    
    @Override
    public double peso() {
        return peso * 1.10; // Aumentar un 10% por el peso del envase
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
