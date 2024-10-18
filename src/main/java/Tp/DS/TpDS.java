package Tp.DS;

import TP.DS.Pantallas.MenuPrincipal;
import java.util.*;

public class TpDS {
    
    public static void main(String[] args) throws VendedorNoCoincideException, PedidoInvalidoException {
        pantallas();
        //casoPruebaParte5();
    }
    
    public static void pantallas() {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setVisible(true);
        menuPrincipal.setLocationRelativeTo(null);
    }
    
    public static void casoPruebaParte5() throws VendedorNoCoincideException, PedidoInvalidoException {
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
        Categoria catBebidas = new Categoria(1, "Bebidas", "bebida");
        Categoria catComidas = new Categoria(2, "Comidas", "plato");


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
        
        System.out.println("Pedido 1:");
	// Pedido p1 para Cliente 1 en Restaurante A con MercadoPago
        // crear ItemsPedido con los itemMenu
        ItemsPedido itemsP1a = new ItemsPedido(1, gaseosa, 2);
        ItemsPedido itemsP1b = new ItemsPedido(2, bife, 1);
        ItemsPedido itemsP1c = new ItemsPedido(4, pizza, 1);
        
        List<ItemsPedido> itemsP1 = List.of(itemsP1a, itemsP1b, itemsP1c); // Todos los ítems pertenecen a v1
        Pedido p1 = Pedido.crearYMostrarPedido(11, c1, itemsP1, pago1);
        p1.agregarObservador(c1);
        p1.cambiarEstado(EstadoPedido.EN_ENVIO);
        
        System.out.println("Pedido 2:");
        // Pedido p2 para Cliente 2 en Restaurante B con Transferencia
        // crear ItemsPedido con los itemMenu
        ItemsPedido itemsP2a = new ItemsPedido(5, vino, 1);
        ItemsPedido itemsP2b = new ItemsPedido(6, postre, 2); 
        ItemsPedido itemsP2c = new ItemsPedido(7, cerveza, 2);
        
        List<ItemsPedido> itemsP2 = List.of(itemsP2a, itemsP2b, itemsP2c); // Todos los ítems pertenecen a v2
        Pedido p2 = Pedido.crearYMostrarPedido(22, c2, itemsP2, pago2);
        p2.agregarObservador(c2);
        p2.cambiarEstado(EstadoPedido.EN_ENVIO);
        
        System.out.println("Pedido 3:");
        // Pedido p3 para Cliente 3 en Restaurante C con MercadoPago
        // crear ItemsPedido con los itemMenu
        ItemsPedido itemsP3a = new ItemsPedido(8, ensalada, 1);
        ItemsPedido itemsP3b = new ItemsPedido(9, aguaMineral, 2);
        List<ItemsPedido> itemsP3 = List.of(itemsP3a, itemsP3b); // Todos los ítems pertenecen a v3
        Pedido p3 = Pedido.crearYMostrarPedido(33, c3, itemsP3, pago3);
        p3.agregarObservador(c3);
        p3.cambiarEstado(EstadoPedido.EN_ENVIO);
        
        /*
        // Asociar ítems al pedido p1
        for(ItemsPedido i: itemsP1){
            itemPedidoMemory.agregarItemPedido(i);
        }
        
        // Pedido p2 para Cliente 2 en Restaurante B con Transferencia
        // crear ItemsPedido con los itemMenu
        ItemsPedido itemsP2a = new ItemsPedido(5, vino, 1);
        ItemsPedido itemsP2b = new ItemsPedido(6, postre, 2); 
        ItemsPedido itemsP2c = new ItemsPedido(7, cerveza, 2);
        List<ItemsPedido> itemsP2 = List.of(itemsP2a, itemsP2b, itemsP2c); // Todos los ítems pertenecen a v2
        Pedido p2 = Pedido.crearYMostrarPedido(22, c2, itemsP2, pago2);
        // Asociar ítems al pedido p2
        for(ItemsPedido i: itemsP2){
            itemPedidoMemory.agregarItemPedido(i);
        }
        // Pedido p3 para Cliente 3 en Restaurante C con MercadoPago
        // crear ItemsPedido con los itemMenu
        ItemsPedido itemsP3a = new ItemsPedido(8, ensalada, 1);
        ItemsPedido itemsP3b = new ItemsPedido(9, aguaMineral, 2);
        List<ItemsPedido> itemsP3 = List.of(itemsP3a, itemsP3b); // Todos los ítems pertenecen a v3
        Pedido p3 = Pedido.crearYMostrarPedido(33, c3, itemsP3, pago3);
        // Asociar ítems al pedido p3
        for(ItemsPedido i: itemsP3){
            itemPedidoMemory.agregarItemPedido(i);
        }
        // Pedido p4 para Cliente 1 en Restaurante A con Transferencia
        // Originalmente, p4 tenía ítems de v1 y v2, por lo que se dividió en p4a y p4b
        ItemsPedido itemsP41a = new ItemsPedido(10, gaseosa, 1);
        ItemsPedido itemsP41b = new ItemsPedido(11, pizza, 1);
        List<ItemsPedido> itemsP4a = List.of(itemsP41a, itemsP41b); // Ítems de v1
        Pedido p41 = Pedido.crearYMostrarPedido(411, c1, itemsP4a, pago4);
        // Asociar ítems al pedido p4a
        for(ItemsPedido i: itemsP4a){
            itemPedidoMemory.agregarItemPedido(i);
        }
        ItemsPedido itemsP42a = new ItemsPedido(12, cerveza, 1);
        List<ItemsPedido> itemsP42 = List.of(itemsP42a); // Ítems de v2
        Pedido p42 = Pedido.crearYMostrarPedido(422, c1, itemsP42, pago4);
        // Asociar ítems al pedido p4b
        itemPedidoMemory.agregarItemPedido(itemsP42a);
        /*
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
        
        
        Pedido p7 = Pedido.crearYMostrarPedido(77,c6, items7, pago7);
        // Asociar ítems al pedido p7
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(17, vino, p7, 2));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(17, ensalada, p7, 2));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(18, postre, p7, 4));
        

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

        
         // Crear pedidos para Cliente 1 y Restaurante A usando diferentes métodos de pago
        Map<ItemMenu, Integer> itemsPago1 = new HashMap<>();
        itemsPago1.put(gaseosa, 3);
        itemsPago1.put(pizza, 1);
        Pedido pedidoMercadoPagoA1 = Pedido.crearYMostrarPedido(1111, c1, itemsPago1, pago1);
        // Asociar ítems al pedidoMercadoPagoA1
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(21, gaseosa, pedidoMercadoPagoA1, 3));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(22, pizza, pedidoMercadoPagoA1, 1));

        Pedido pedidoTransferenciaA1 = Pedido.crearYMostrarPedido(2222, c1, itemsPago1, pago2);
        // Asociar ítems al pedidoTransferenciaA1
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(23, gaseosa, pedidoTransferenciaA1, 3));
        itemPedidoMemory.agregarItemPedido(new ItemsPedido(24, pizza, pedidoTransferenciaA1, 1));
        
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
        
        */
    }
   
}