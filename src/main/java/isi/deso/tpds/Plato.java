package isi.deso.tpds;

import isi.deso.tpds.Categoria.Categoria;
import isi.deso.tpds.ItemMenu.ItemMenu;
import isi.deso.tpds.Vendedor.Vendedor;

public class Plato extends ItemMenu {
    private double peso; // Peso en gramos
    private double calorias; // Calorias en kcal
    private boolean aptoVegano;

    public Plato(int id, String nombre, String descripcion, double precio, Categoria categoria, double peso, double calorias, boolean aptoVegano, Vendedor vendedor) {
        super(id, nombre, descripcion, precio, categoria, vendedor);
        this.peso = peso;
        this.calorias = calorias;
        this.aptoVegano = aptoVegano;
    }
    
    public Plato(String nombre, String descripcion, double precio, Categoria categoria, double peso, double calorias, boolean aptoVegano, Vendedor vendedor) {
        super(nombre, descripcion, precio, categoria, vendedor);
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
    public void setPeso(double peso) {
        this.peso=peso;
    }

    public double getCalorias() {
        return calorias;
    }
    public void setCalorias(double calorias) {
        this.calorias=calorias;
    }

    public void setAptoVegano(boolean aptoVegano) {
        this.aptoVegano=aptoVegano;
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
