/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpdesarrollosoftware.tpdesarrollosoftware;

public class Vendedor {
    private String nombre;
    private int id;
    private Coordenada ubicacion;

    public Vendedor(String nombre, int id, Coordenada ubicacion) {
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

    public double distancia(Cliente cliente) {
        Coordenada ubicacionCliente = cliente.getUbicacion();
        // Fórmula de Haversine
        double R = 6371; // Radio de la Tierra en kilómetros
        double dLat = Math.toRadians(ubicacionCliente.getLatitud() - this.ubicacion.getLatitud());
        double dLon = Math.toRadians(ubicacionCliente.getLongitud() - this.ubicacion.getLongitud());
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(this.ubicacion.getLatitud())) * Math.cos(Math.toRadians(ubicacionCliente.getLatitud())) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return R * c;
    }
}
