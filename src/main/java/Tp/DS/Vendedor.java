package Tp.DS;

class Vendedor {
    private int id;
    private String nombre;
    private String direccion;
    private Coordenada coordenadas;

    public Vendedor(int id, String nombre, String direccion, Coordenada coordenadas) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.coordenadas = coordenadas;
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
        return null; // Si no se encuentra el vendedor, se devuelve null
    }

    // Método para buscar un vendedor por ID
    public static Vendedor buscarVendedorPorId(Vendedor[] vendedores, int id) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getId() == id) {
                return vendedor;
            }
        }
        return null; // Si no se encuentra el vendedor, se devuelve null
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

}
