package Tp.DS;

public class TpDS {
    public static void main(String[] args) {
        // Crear vendedores
        Vendedor v1 = new Vendedor(1, "Restaurante A", "Calle 123", new Coordenada(-34.6037, -58.3816));
        Vendedor v2 = new Vendedor(2, "Restaurante B", "Calle 456", new Coordenada(-34.6158, -58.4333));
        Vendedor v3 = new Vendedor(3, "Restaurante C", "Calle 789", new Coordenada(-34.6179, -58.3686));
        Vendedor[] vendedores = {v1, v2, v3};

        // Buscar un vendedor por nombre e imprimirlo
        Vendedor vendedorEncontrado = Vendedor.buscarVendedorPorNombre(vendedores, "Restaurante A");
        if (vendedorEncontrado != null) {
            System.out.println("Vendedor encontrado: " + vendedorEncontrado.getNombre());
        } else {
            System.out.println("Vendedor no encontrado.");
        }

        // Buscar un vendedor por ID e imprimirlo
        vendedorEncontrado = Vendedor.buscarVendedorPorId(vendedores, 3);
        if (vendedorEncontrado != null) {
            System.out.println("Vendedor encontrado: " + vendedorEncontrado.getNombre());
        } else {
            System.out.println("Vendedor no encontrado.");
        }

        // Crear clientes
        Cliente c1 = new Cliente(1, "20-12345678-9", "cliente1@mail.com", "Avenida 123", new Coordenada(-34.6083, -58.3712));
        Cliente c2 = new Cliente(2, "20-87654321-9", "cliente2@mail.com", "Avenida 456", new Coordenada(-34.6092, -58.3772));
        Cliente c3 = new Cliente(3, "20-11112222-9", "cliente3@mail.com", "Avenida 789", new Coordenada(-34.6109, -58.3761));
        Cliente[] clientes = {c1, c2, c3};


        // Buscar un cliente por ID e imprimirlo
        Cliente clienteEncontrado = Cliente.buscarClientePorId(clientes, 1);
        if (clienteEncontrado != null) {
            System.out.println("Cliente encontrado: " + clienteEncontrado.getCuit());
        } else {
            System.out.println("Cliente no encontrado.");
        }

        // Calcular la distancia entre un vendedor y un cliente
        double distancia = v1.distancia(c1);
        System.out.println("Distancia entre " + v1.getNombre() + " y " + c1.getDireccion() + ": " + distancia + " km");
    }
}
