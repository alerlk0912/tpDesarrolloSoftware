package Tp.DS;

import java.util.List;

public class TpDS {
    
    public static void main(String[] args) {
	// Crear vendedores (restaurantes)
        Vendedor v1 = new Vendedor(1, "Restaurante A", "Calle 123", new Coordenada(-34.6037, -58.3816));
        Vendedor v2 = new Vendedor(2, "Restaurante B", "Calle 456", new Coordenada(-34.6158, -58.4333));
        Vendedor v3 = new Vendedor(3, "Restaurante C", "Calle 789", new Coordenada(-34.6179, -58.3686));
	Vendedor v4 = new Vendedor(4, "Restaurante D", "Calle 101", new Coordenada(-34.6059, -58.3831));
        Vendedor v5 = new Vendedor(5, "Restaurante E", "Calle 202", new Coordenada(-34.6180, -58.4350));
        Vendedor v6 = new Vendedor(6, "Restaurante F", "Calle 303", new Coordenada(-34.6201, -58.3701));
        Vendedor v7 = new Vendedor(7, "Restaurante G", "Calle 404", new Coordenada(-34.6081, -58.3846));
        Vendedor v8 = new Vendedor(8, "Restaurante H", "Calle 505", new Coordenada(-34.6202, -58.4367));
        Vendedor v9 = new Vendedor(9, "Restaurante I", "Calle 606", new Coordenada(-34.6223, -58.3716));
        Vendedor v10 = new Vendedor(10, "Restaurante J", "Calle 707", new Coordenada(-34.6103, -58.3861));
        Vendedor v11 = new Vendedor(11, "Restaurante K", "Calle 808", new Coordenada(-34.6224, -58.4384));
        Vendedor v12 = new Vendedor(12, "Restaurante L", "Calle 909", new Coordenada(-34.6245, -58.3731));
        Vendedor v13 = new Vendedor(13, "Restaurante M", "Calle 1010", new Coordenada(-34.6125, -58.3876));

        // Crear clientes
        Cliente c1 = new Cliente(1, "20-12345678-9", "Cliente 1", "cliente1@mail.com", "Avenida 123", new Coordenada(-34.6083, -58.3712));
	Cliente c2 = new Cliente(2, "20-87654321-9", "Cliente 2", "cliente2@mail.com", "Avenida 456", new Coordenada(-34.6092, -58.3772));
	Cliente c3 = new Cliente(3, "20-11112222-9", "Cliente 3", "cliente3@mail.com", "Avenida 789", new Coordenada(-34.6109, -58.3761));
        Cliente c4 = new Cliente(4, "20-33334444-9", "Cliente 4", "cliente4@mail.com", "Avenida 1011", new Coordenada(-34.6126, -58.3750));
        Cliente c5 = new Cliente(5, "20-55556666-9", "Cliente 5", "cliente5@mail.com", "Avenida 1213", new Coordenada(-34.6143, -58.3739));
        Cliente c6 = new Cliente(6, "20-77778888-9", "Cliente 6", "cliente6@mail.com", "Avenida 1415", new Coordenada(-34.6160, -58.3728));
        Cliente c7 = new Cliente(7, "20-99990000-9", "Cliente 7", "cliente7@mail.com", "Avenida 1617", new Coordenada(-34.6177, -58.3717));
        Cliente c8 = new Cliente(8, "20-12121212-9", "Cliente 8", "cliente8@mail.com", "Avenida 1819", new Coordenada(-34.6194, -58.3706));
        Cliente c9 = new Cliente(9, "20-23232323-9", "Cliente 9", "cliente9@mail.com", "Avenida 2021", new Coordenada(-34.6211, -58.3695));
        Cliente c10 = new Cliente(10, "20-34343434-9", "Cliente 10", "cliente10@mail.com", "Avenida 2223", new Coordenada(-34.6228, -58.3684));
        Cliente c11 = new Cliente(11, "20-45454545-9", "Cliente 11", "cliente11@mail.com", "Avenida 2425", new Coordenada(-34.6245, -58.3673));
        Cliente c12 = new Cliente(12, "20-56565656-9", "Cliente 12", "cliente12@mail.com", "Avenida 2627", new Coordenada(-34.6262, -58.3662));
        Cliente c13 = new Cliente(13, "20-67676767-9", "Cliente 13", "cliente13@mail.com", "Avenida 2829", new Coordenada(-34.6279, -58.3651));

        // Crear categorías
        Categoria catBebidas = new Categoria();
        catBebidas.setId(1);
        catBebidas.setDescripcion("Bebidas");
        catBebidas.setTipo_item("bebida");

        Categoria catComidas = new Categoria();
        catComidas.setId(2);
        catComidas.setDescripcion("Comidas");
        catComidas.setTipo_item("plato");

        // Crear ítems de menú
        Bebida gaseosa = new Bebida(1, "Gaseosa", "Refresco de cola", 2500, catBebidas, v1, 500, false);
        Plato bife = new Plato(2, "Bife", "Bife de chorizo", 10000, catComidas, v1, 300, 800, false);
        Bebida vino = new Bebida(3, "Vino", "Vino tinto Malbec", 7000, catBebidas, v2, 750, true);
        Plato postre = new Plato(4, "Postre", "Flan con dulce de leche", 2500, catComidas, v2, 200, 400, true);
        Plato ensalada = new Plato(5, "Ensalada", "Ensalada mixta", 3000, catComidas, v3, 250, 150, true);
        Bebida aguaMineral = new Bebida(6, "Agua Mineral", "Agua sin gas", 1500, catBebidas, v3, 500, false);
        Plato pizza = new Plato(7, "Pizza", "Pizza Margherita", 8000, catComidas, v1, 800, 1200, false);
        Bebida cerveza = new Bebida(8, "Cerveza", "Cerveza rubia", 3500, catBebidas, v2, 330, true);
	Plato hamburguesa = new Plato(9, "Hamburguesa", "Hamburguesa completa", 6000, catComidas, v4, 350, 700, false);
        Bebida jugo = new Bebida(10, "Jugo", "Jugo de naranja", 2000, catBebidas, v5, 400, false);
        Plato pasta = new Plato(11, "Pasta", "Spaghetti a la bolognesa", 5500, catComidas, v6, 400, 600, false);
        Bebida te = new Bebida(12, "Te", "Te verde", 1800, catBebidas, v7, 300, false);
        
        // Crear métodos de pago
        Pago pago1 = new MercadoPago("cliente1.alias.mercado");
        Pago pago2 = new Transferencia("12345678901234567890", "20-12345678-9");
        Pago pago3 = new MercadoPago("cliente3.alias.mercado");
        Pago pago4 = new Transferencia("09876543210987654321", "20-12345678-9");
        Pago pago5 = new MercadoPago("cliente4.alias.mercado");
        Pago pago6 = new Transferencia("11223344556677889900", "20-55556666-9");
        Pago pago7 = new MercadoPago("cliente6.alias.mercado");
        Pago pago8 = new Transferencia("22334455667788990011", "20-99990000-9");
        
        ItemPedidoMemory itemPedidoMemory = new ItemPedidoMemory();
        
	// Pedido p1 para Cliente 1 en Restaurante A con MercadoPago
        List<ItemMenu> itemsP1 = List.of(gaseosa, bife); // Todos los ítems pertenecen a v1
        Pedido p1 = Pedido.crearYMostrarPedido(c1, v1, itemsP1, pago1, "p1");
        // Asociar ítems al pedido p1
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(1, gaseosa, p1, 2));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(2, bife, p1, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(3, postre, p1, 2));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(4, pizza, p1, 1));

        // Pedido p2 para Cliente 2 en Restaurante B con Transferencia
        List<ItemMenu> itemsP2 = List.of(vino, postre, cerveza); // Todos los ítems pertenecen a v2
        Pedido p2 = Pedido.crearYMostrarPedido(c2, v2, itemsP2, pago2, "p2");
        // Asociar ítems al pedido p2
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(5, vino, p2, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(6, postre, p2, 2));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(7, cerveza, p2, 2));

        // Pedido p3 para Cliente 3 en Restaurante C con MercadoPago
        List<ItemMenu> itemsP3 = List.of(ensalada, aguaMineral); // Todos los ítems pertenecen a v3
        Pedido p3 = Pedido.crearYMostrarPedido(c3, v3, itemsP3, pago3, "p3");
        // Asociar ítems al pedido p3
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(8, ensalada, p3, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(9, aguaMineral, p3, 2));

        // Pedido p4 para Cliente 1 en Restaurante A con Transferencia
        // Originalmente, p4 tenía ítems de v1 y v2, por lo que se dividió en p4a y p4b
        List<ItemMenu> itemsP4a = List.of(gaseosa, pizza); // Ítems de v1
        Pedido p4a = Pedido.crearYMostrarPedido(c1, v1, itemsP4a, pago4, "p4a");
        // Asociar ítems al pedido p4a
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(10, gaseosa, p4a, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(11, pizza, p4a, 1));

        List<ItemMenu> itemsP4b = List.of(cerveza); // Ítems de v2
        Pedido p4b = Pedido.crearYMostrarPedido(c1, v2, itemsP4b, pago4, "p4b");
        // Asociar ítems al pedido p4b
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(12, cerveza, p4b, 1));

        // Pedido p5 para Cliente 4 en Restaurante D con MercadoPago
        // Originalmente, p5 tenía ítems de v4 y v5, por lo que se dividió en p5a y p5b
        List<ItemMenu> itemsP5a = List.of(hamburguesa); // Ítems de v4
        Pedido p5a = Pedido.crearYMostrarPedido(c4, v4, itemsP5a, pago5, "p5a");
        // Asociar ítems al pedido p5a
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(13, hamburguesa, p5a, 2));

        List<ItemMenu> itemsP5b = List.of(jugo); // Ítems de v5
        Pedido p5b = Pedido.crearYMostrarPedido(c4, v5, itemsP5b, pago5, "p5b");
        // Asociar ítems al pedido p5b
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(14, jugo, p5b, 2));

        // Pedido p6 para Cliente 5 en Restaurante F con Transferencia
        // Originalmente, p6 tenía ítems de v6 y v2, por lo que se dividió en p6a y p6b
        List<ItemMenu> itemsP6a = List.of(pasta); // Ítems de v6
        Pedido p6a = Pedido.crearYMostrarPedido(c5, v6, itemsP6a, pago6, "p6a");
        // Asociar ítems al pedido p6a
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(15, pasta, p6a, 1));

        List<ItemMenu> itemsP6b = List.of(vino); // Ítems de v2
        Pedido p6b = Pedido.crearYMostrarPedido(c5, v2, itemsP6b, pago6, "p6b");
        // Asociar ítems al pedido p6b
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(16, vino, p6b, 1));

        // Pedido p7 para Cliente 6 en Restaurante G con MercadoPago
        // Asegurarse de que todos los ítems pertenecen a v3
        List<ItemMenu> itemsP7 = List.of(ensalada, aguaMineral); // Ítems de v3
        Pedido p7 = Pedido.crearYMostrarPedido(c6, v3, itemsP7, pago7, "p7");
        // Asociar ítems al pedido p7
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(17, ensalada, p7, 2));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(18, aguaMineral, p7, 2));

        // Pedido p8 para Cliente 7 en Restaurante A con Transferencia
        // Originalmente, p8 tenía ítems de v1 y v2, por lo que se dividió en p8a y p8b
        List<ItemMenu> itemsP8a = List.of(pizza); // Ítems de v1
        Pedido p8a = Pedido.crearYMostrarPedido(c7, v1, itemsP8a, pago8, "p8a");
        // Asociar ítems al pedido p8a
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(19, pizza, p8a, 1));

        List<ItemMenu> itemsP8b = List.of(cerveza); // Ítems de v2
        Pedido p8b = Pedido.crearYMostrarPedido(c7, v2, itemsP8b, pago8, "p8b");
        // Asociar ítems al pedido p8b
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(20, cerveza, p8b, 2));

        // Crear ItemsPedido
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(1, gaseosa, p1, 2));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(2, bife, p1, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(3, vino, p1, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(4, postre, p1, 2));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(5, ensalada, p2, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(6, gaseosa, p2, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(7, pizza, p2, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(8, cerveza, p2, 2));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(9, aguaMineral, p3, 2));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(10, bife, p3, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(11, postre, p3, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(12, gaseosa, p4a, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(13, pizza, p4a, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(27, hamburguesa, p4a, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(28, gaseosa, p4a, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(14, cerveza, p4b, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(29, pasta, p4b, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(30, jugo, p4b, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(31, ensalada, p4b, 1));
	itemPedidoMemory.agregarItemPedido(new ItemsPedido(15, hamburguesa, p5a, 2));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(32, aguaMineral, p5a, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(33, pizza, p5b, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(34, cerveza, p5b, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(16, jugo, p5b, 2));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(17, pasta, p6a, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(18, vino, p6a, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(17, pasta, p6b, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(18, vino, p6b, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(19, ensalada, p7, 2));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(20, aguaMineral, p7, 2));;
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(23, bife, p5b, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(24, vino, p6a, 1));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(25, postre, p6b, 2));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(26, te, p6b, 2));      

        // Casos de prueba
        try {
            // 1. Filtrar por rango de precio entre 1000 y 5000
            System.out.println("1. Items entre 1000 y 5000:");
            itemPedidoMemory.buscarPorRangoDePrecios(1000, 5000).forEach(System.out::println);

            // 2. Buscar por restaurante (nombre del vendedor)
            System.out.println("\n2. Pedidos del Restaurante B:");
            itemPedidoMemory.buscarPorRestaurante("Restaurante B").forEach(System.out::println);

            // 3. Buscar pedidos de un cliente específico
            System.out.println("\n3. Pedidos del Cliente 1:");
            itemPedidoMemory.buscarPorCliente("Cliente 1").forEach(System.out::println);

            // 4. Ordenar pedidos por precio ascendente
            System.out.println("\n4. Pedidos ordenados por precio (ascendente):");
            itemPedidoMemory.ordenarPorCriterio("precio", true).forEach(System.out::println);

            // 5. Ordenar pedidos por nombre de cliente descendente
            System.out.println("\n5. Pedidos ordenados por nombre de cliente (descendente):");
            itemPedidoMemory.ordenarPorCriterio("cliente", false).forEach(System.out::println);

        } catch (ItemNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
         // Crear pedidos para Cliente 1 y Restaurante A usando diferentes métodos de pago
        List<ItemMenu> itemsPedido1a = List.of(gaseosa, pizza);
        Pedido pedidoMercadoPagoA1 = Pedido.crearYMostrarPedido(c1, v1, itemsPedido1a, pago1, "pedidoMercadoPagoA1");
        // Asociar ítems al pedidoMercadoPagoA1
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(21, gaseosa, pedidoMercadoPagoA1, 2));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(22, pizza, pedidoMercadoPagoA1, 1));

        Pedido pedidoTransferenciaA1 = Pedido.crearYMostrarPedido(c1, v1, itemsPedido1a, pago2, "pedidoTransferenciaA1");
        // Asociar ítems al pedidoTransferenciaA1
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(23, gaseosa, pedidoTransferenciaA1, 2));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(24, pizza, pedidoTransferenciaA1, 1));

        // Crear otro pedido para Cliente 2 y Restaurante B
        List<ItemMenu> itemsPedido2a = List.of(cerveza);
        Pedido pedidoCliente2 = Pedido.crearYMostrarPedido(c2, v2, itemsPedido2a, pago3, "pedidoCliente2");
        // Asociar ítems al pedidoCliente2
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(25, cerveza, pedidoCliente2, 1));

    }
}