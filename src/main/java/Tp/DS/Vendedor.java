package Tp.DS;

import java.util.ArrayList;
import java.util.List;

class Vendedor {
    private int id;
    private String nombre;
    private String direccion;
    private Coordenada coordenadas;
    private List<ItemMenu> menu;

    public Vendedor(int id, String nombre, String direccion, Coordenada coordenadas) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.coordenadas = coordenadas;
        this.menu = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public Coordenada getCoordenadas() {
        return coordenadas;
    }

    // Método para calcular la distancia entre el vendedor y un cliente
    public double distancia(Cliente cliente) {
        return this.coordenadas.calcularDistancia(cliente.getCoordenadas());
    }
    // Método para buscar un vendedor por nombre
    public static Vendedor buscarVendedorPorNombre(Vendedor[] vendedores, String nombre) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getNombre().equals(nombre)) {
                return vendedor;
            }
        }
        return null;
    }

    // Método para buscar un vendedor por ID
    public static Vendedor buscarVendedorPorId(Vendedor[] vendedores, int id) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getId() == id) {
                return vendedor;
            }
        }
        return null;
    }
    // Método para eliminar un vendedor del arreglo
    public static Vendedor[] eliminarVendedor(Vendedor[] vendedores, String nombre) {
        int index = -1;
        for (int i = 0; i < vendedores.length; i++) {
            if (vendedores[i].getNombre().equals(nombre)) {
                index = i;
                System.out.println("Vendedor encontrado: " + vendedores[i].getNombre() + ". Eliminando...");
                break;
            }
        }
        if (index != -1) {
            Vendedor[] nuevoArray = new Vendedor[vendedores.length - 1];
            for (int i = 0, k = 0; i < vendedores.length; i++) {
                if (i == index) {
                    continue;
                }
                nuevoArray[k++] = vendedores[i];
            }
            return nuevoArray;
        } else {
            System.out.println("Vendedor no encontrado.");
            return vendedores;
        }
    }
    
    // metodos para manejar el menu de platos
    public void agregarItemMenu(ItemMenu item) {
        menu.add(item);
    }
    
    public List<ItemMenu> getMenu() {
        return menu;
    }

    public List<Bebida> getItemBebidas() {
        List<Bebida> bebidas = new ArrayList<>();
        for (ItemMenu item : menu) {
            if (item.esBebida()) {
                bebidas.add((Bebida) item);
            }
        }
        return bebidas;
    }

    public List<Plato> getItemComidas() {
        List<Plato> comidas = new ArrayList<>();
        for (ItemMenu item : menu) {
            if (item.esComida()) {
                comidas.add((Plato) item);
            }
        }
        return comidas;
    }

    public List<Plato> getItemComidasVeganas() {
        List<Plato> comidasVeganas = new ArrayList<>();
        for (ItemMenu item : menu) {
            if (item.esComida() && item.isAptoVegano()) {
                comidasVeganas.add((Plato) item);
            }
        }
        return comidasVeganas;
    }

    public List<Bebida> getItemBebidasSinAlcohol() {
        List<Bebida> bebidasSinAlcohol = new ArrayList<>();
        for (ItemMenu item : menu) {
            if (item.esBebida() && !((Bebida) item).isBebidaAlcoholica()) {
                bebidasSinAlcohol.add((Bebida) item);
            }
        }
        return bebidasSinAlcohol;
    }

}
