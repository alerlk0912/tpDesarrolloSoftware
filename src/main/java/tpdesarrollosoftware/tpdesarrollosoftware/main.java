/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package tpdesarrollosoftware.tpdesarrollosoftware;

/**
 *
 * @author Ale
 */
public class main {
    public static void main(String[] args) {
        // Crear vendedores
        Vendedor v1 = new Vendedor("Restaurante A", 1, new Coordenada(-34.6037, -58.3816));
        Vendedor v2 = new Vendedor("Restaurante B", 2, new Coordenada(-34.6158, -58.4333));
        Vendedor v3 = new Vendedor("Restaurante C", 3, new Coordenada(-34.6179, -58.3686));
        Vendedor[] vendedores = {v1, v2, v3};
        //132
        // Buscar y eliminar un vendedor
        for (Vendedor v : vendedores) {
            if (v.getNombre().equals("Restaurante B")) {
                System.out.println("Vendedor encontrado: " + v.getNombre());
                // Código para eliminarlo del arreglo
            }
        }

        // Crear clientes
        Cliente c1 = new Cliente("Cliente X", 1, new Coordenada(-34.6083, -58.3712));
        Cliente c2 = new Cliente("Cliente Y", 2, new Coordenada(-34.6092, -58.3772));
        Cliente c3 = new Cliente("Cliente Z", 3, new Coordenada(-34.6109, -58.3761));
        Cliente[] clientes = {c1, c2, c3};

        // Buscar y eliminar un cliente
        for (Cliente c : clientes) {
            if (c.getNombre().equals("Cliente Y")) {
                System.out.println("Cliente encontrado: " + c.getNombre());
                // Código para eliminarlo del arreglo
            }
        }

        // Calcular la distancia entre un vendedor y un cliente
        double distancia = v1.distancia(c1);
        System.out.println("Distancia entre " + v1.getNombre() + " y " + c1.getNombre() + ": " + distancia + " km");
    }
}
