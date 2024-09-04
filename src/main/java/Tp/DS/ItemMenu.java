/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp.DS;

/**
 *
 * @author franco
 */
public abstract class ItemMenu {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private String categoria;
    
    public ItemMenu(int id, String nombre, String descripcion,double precio, String categoria) {
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

    public String getCategoria() {
        return categoria;
    }
    // metodos abstractos para las subclases Comida y Bebida
    public abstract double peso();
    public abstract boolean esComida();
    public abstract boolean esBebida();
    public abstract boolean isAptoVegano();
}
