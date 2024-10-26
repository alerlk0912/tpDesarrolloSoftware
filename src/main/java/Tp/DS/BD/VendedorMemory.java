/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp.DS.BD;

import Tp.DS.Vendedor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franco
 */
public class VendedorMemory implements DAOVendedor {
    private List<Vendedor> vendedores = new ArrayList<>();
    private int nextId = 1;
    
    public List<Vendedor> listarVendedores() {
        return vendedores;
    }

    @Override
    public void crearVendedor(Vendedor vendedor) {
        vendedor.setId(nextId++);
        vendedores.add(vendedor);
    }

    @Override
    public void actualizarVendedor(Vendedor vendedor) {
        Vendedor v = buscarVendedorPorId(vendedor.getId());
        if (v != null) {
            v.setNombre(vendedor.getNombre());
            v.setDireccion(vendedor.getDireccion());
            v.setCoordenadas(vendedor.getCoordenadas());
        }
    }

    @Override
    public void eliminarVendedor(int id) {
        vendedores.removeIf(v -> v.getId() == id);
    }

    @Override
    public Vendedor buscarVendedorPorId(int id) {
        return vendedores.stream().filter(v -> v.getId() == id).findFirst().orElse(null);
    }
}

