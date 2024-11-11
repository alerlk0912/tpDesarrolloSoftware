package Tp.DS.Vendedor;

import Tp.DS.Coordenada.Coordenada;
import Tp.DS.Vendedor.DAOVendedor;

import java.util.ArrayList;
import java.util.List;

public class VendedorMemory implements DAOVendedor {
    private List<Vendedor> vendedores = new ArrayList<>();
    private int nextId = 1;
    private static VendedorMemory instance;
    
    private VendedorMemory(){
    }
    
    public static VendedorMemory getInstance() {
        if (instance == null) {
            instance = new VendedorMemory();
        }
        return instance;
    }
    
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

