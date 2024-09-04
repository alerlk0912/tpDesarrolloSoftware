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
    
    
        // crear instancias de Platos
        Plato plato1 = new Plato(1, "Ensalada Vegana", "Ensalada fresca de vegetales", 200.0, "Ensaladas", 250.0, 150.0, true);
        Plato plato2 = new Plato(2, "Milanesa con Papas", "Milanesa de ternera con papas fritas", 300.0, "Platos Principales", 350.0, 850.0, false);
        Plato plato3 = new Plato(3, "Risotto de Setas", "Risotto cremoso con setas", 250.0, "Platos Principales", 300.0, 600.0, true);

        // crear instancias de Bebidas
        Bebida bebida1 = new Bebida(1, "Cerveza", "Cerveza rubia artesanal", 150.0, "Bebidas Alcoholicas", 500.0, true);
        Bebida bebida2 = new Bebida(2, "Agua Mineral", "Agua mineral sin gas", 50.0, "Bebidas sin Alcohol", 500.0, false);
        Bebida bebida3 = new Bebida(3, "Refresco", "Refresco de cola", 70.0, "Bebidas Gaseosas", 330.0, false);

        // agregar platos y bebidas al menú del vendedor
        v1.agregarItemMenu(plato1);
        v1.agregarItemMenu(plato2);
        v1.agregarItemMenu(bebida1);
        v2.agregarItemMenu(plato3);
        v2.agregarItemMenu(bebida2);
        v3.agregarItemMenu(bebida3);
        
        System.out.println("Menu Restaurante 1." + v1.getMenu());
    }
}