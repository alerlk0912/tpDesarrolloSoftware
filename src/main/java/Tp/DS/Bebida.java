/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp.DS;

/**
 *
 * @author franco
 */
public class Bebida extends ItemMenu {
    private final double tamanio; // volumen en ml
    private final boolean alcoholica;

    public Bebida(int id, String nombre, String descripcion, double precio, String categoria, double tamanio, boolean alcoholica) {
        super(id, nombre, descripcion, precio, categoria);
        this.tamanio = tamanio;
        this.alcoholica = alcoholica;
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
                ", alcoholica=" + alcoholica +
                '}';
    }
    
    public double getTamanio() {
        return tamanio;
    }

    public boolean isBebidaAlcoholica() {
        return alcoholica;
    }
    
    @Override
    public double peso() {
        double pesoBase = (alcoholica ? tamanio * 0.99 : tamanio * 1.04); // 0.99 para bebidas alcoholicas, 1.04 para noAlcoholicas
        return pesoBase * 1.20; // aumentar un 20% por el peso del envase
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
