package isi.deso.tpds;

import isi.deso.tpds.Categoria.Categoria;
import isi.deso.tpds.ItemMenu.ItemMenu;
import isi.deso.tpds.Vendedor.Vendedor;

public class Bebida extends ItemMenu {
    private double tamanio; // Volumen en ml
    private boolean graduacionAlcoholica;

    public Bebida(int id, String nombre, String descripcion, double precio, Categoria categoria, double tamanio, boolean alcoholica, Vendedor vendedor) {
        super(id, nombre, descripcion, precio, categoria, vendedor);
        this.tamanio = tamanio;
        this.graduacionAlcoholica = alcoholica;
    }
    
    public Bebida(String nombre, String descripcion, double precio, Categoria categoria, double tamanio, boolean alcoholica, Vendedor vendedor) {
        super(nombre, descripcion, precio, categoria, vendedor);
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
    public void setTamanio(double tamanio) {
        this.tamanio=tamanio;
    }

    public boolean isBebidaAlcoholica() {
        return graduacionAlcoholica;
    }
    public void setBebidaAlcoholica(boolean alcoholica) {
        this.graduacionAlcoholica=alcoholica;
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

