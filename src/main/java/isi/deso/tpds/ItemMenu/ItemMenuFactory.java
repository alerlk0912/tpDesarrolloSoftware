package isi.deso.tpds.ItemMenu;

import isi.deso.tpds.Bebida;
import isi.deso.tpds.Categoria.Categoria;
import isi.deso.tpds.Plato;
import isi.deso.tpds.Vendedor.Vendedor;

public class ItemMenuFactory {
    public static ItemMenu createItemMenu(String tipoItem, String nombre, String descripcion, double precio,
                                          Categoria categoria, Vendedor vendedor,
                                          Double tamanio, Boolean graduacionAlcoholica,
                                          Double peso, Double calorias, Boolean aptoVegano) {
        if ("PLATO".equalsIgnoreCase(tipoItem)) {
            return createPlato(nombre, descripcion, precio, categoria, vendedor, peso, calorias, aptoVegano);
        } else if ("BEBIDA".equalsIgnoreCase(tipoItem)) {
            return createBebida(nombre, descripcion, precio, categoria, vendedor, tamanio, graduacionAlcoholica);
        } else {
            throw new IllegalArgumentException("Tipo de ItemMenu no válido: " + tipoItem);
        }
    }

    private static Plato createPlato(String nombre, String descripcion, double precio,
                                     Categoria categoria, Vendedor vendedor,
                                     Double peso, Double calorias, Boolean aptoVegano) {
        if (peso == null || calorias == null || aptoVegano == null) {
            throw new IllegalArgumentException("Faltan datos para crear un Plato");
        }
        return new Plato(nombre, descripcion, precio, categoria, peso, calorias, aptoVegano, vendedor);
    }

    private static Bebida createBebida(String nombre, String descripcion, double precio,
                                       Categoria categoria, Vendedor vendedor,
                                       Double tamanio, Boolean graduacionAlcoholica) {
        if (tamanio == null || graduacionAlcoholica == null) {
            throw new IllegalArgumentException("Faltan datos para crear una Bebida");
        }
        return new Bebida(nombre, descripcion, precio, categoria, tamanio, graduacionAlcoholica, vendedor);
    }
}
