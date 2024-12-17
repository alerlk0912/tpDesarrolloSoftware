package isi.deso.tpds.Vendedor;

import isi.deso.tpds.Plato;
import isi.deso.tpds.Bebida;
import isi.deso.tpds.Cliente.Cliente;
import isi.deso.tpds.Coordenada.Coordenada;
import isi.deso.tpds.ItemMenu.ItemMenu;
import isi.deso.tpds.Pedido.EstadoPedido;
import isi.deso.tpds.Pedido.Pedido;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Vendedor {
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
    
    public Vendedor(String nombre, String direccion, Coordenada coordenadas) {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCoordenadas(Coordenada coordenadas) {
        this.coordenadas = coordenadas;
    }
    
    public double distancia(Cliente cliente) {
        return this.coordenadas.calcularDistancia(cliente.getCoordenadas());
    }

    public static Vendedor buscarVendedorPorNombre(Vendedor[] vendedores, String nombre) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getNombre().equals(nombre)) {
                return vendedor;
            }
        }
        return null;
    }

    public static Vendedor buscarVendedorPorId(Vendedor[] vendedores, int id) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getId() == id) {
                return vendedor;
            }
        }
        return null;
    }

    public static Vendedor[] eliminarVendedor(Vendedor[] vendedores, String nombre) {
        int index = -1;
        for (int i = 0; i < vendedores.length; i++) {
            if (vendedores[i].getNombre().equals(nombre)) {
                index = i;
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
            return vendedores;
        }
    }
    
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
    
    public void actualizarEstadoPedido(Pedido pedido, EstadoPedido nuevoEstado) {
        pedido.cambiarEstado(nuevoEstado);
    }

    public String getNombresMenu() {
        return menu.stream()
                   .map(ItemMenu::getNombre)
                   .collect(Collectors.joining(", "));
    }
}
