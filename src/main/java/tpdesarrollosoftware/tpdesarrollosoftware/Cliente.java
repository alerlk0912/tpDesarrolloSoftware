/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpdesarrollosoftware.tpdesarrollosoftware;

public class Cliente {
    private String nombre;
    private int id;
    private Coordenada ubicacion;

    public Cliente(String nombre, int id, Coordenada ubicacion) {
        this.nombre = nombre;
        this.id = id;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public Coordenada getUbicacion() {
        return ubicacion;
    }
}
