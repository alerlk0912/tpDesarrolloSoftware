package Tp.DS;

import Tp.DS.BD.DatabaseConnection;
import Tp.DS.Cliente.*;
import Tp.DS.Exceptions.DAOException;
import Tp.DS.Exceptions.PedidoInvalidoException;
import Tp.DS.Exceptions.VendedorNoCoincideException;
import Tp.DS.ItemMenu.*;
import Tp.DS.MenuPrincipal.MenuPrincipal;
import Tp.DS.MetodoPago.*;
import Tp.DS.Vendedor.*;

public class TpDS {
    private static boolean useJDBC = false;

    public static void main(String[] args) throws VendedorNoCoincideException, PedidoInvalidoException, DAOException {
        new PantallaIntro().setOnModeSelected(modeSelection -> inicializar(modeSelection));
    }

    private static void inicializar(ModeSelection modeSelection)  {
        useJDBC = modeSelection.useJDBC;
        
        try {
            if (useJDBC) {
                DatabaseConnection.setCredentials(modeSelection.username, modeSelection.password);
                testJDBC();
            } else {
                testMemory();
            }

            pantallas();

        } catch (DAOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    private static void testJDBC() throws DAOException {
        DAOItemMenu itemMenuDAO = ItemMenuMemory.getInstance();
        DAOVendedor vendedorDAO = VendedorMemory.getInstance();
        DAOCliente clienteDAO = ClienteMemory.getInstance();

        ItemMenuController itemMenuController = ItemMenuController.getInstance(itemMenuDAO);
        VendedorController vendedorController = VendedorController.getInstance(vendedorDAO);
        ClienteController clienteController = ClienteController.getInstance(clienteDAO);

        vendedorController.cargarVendedores();
        clienteController.cargarClientes();
        itemMenuController.cargarItemsMenu();
    }

    private static void testMemory() throws DAOException {
        DAOItemMenu itemMenuDAO = ItemMenuMemory.getInstance();
        DAOVendedor vendedorDAO = VendedorMemory.getInstance();
        DAOCliente clienteDAO = ClienteMemory.getInstance();

        ItemMenuController itemMenuController = ItemMenuController.getInstance(itemMenuDAO);
        VendedorController vendedorController = VendedorController.getInstance(vendedorDAO);
        ClienteController clienteController = ClienteController.getInstance(clienteDAO);

        vendedorController.cargarVendedores();
        clienteController.cargarClientes();
        itemMenuController.cargarItemsMenu();
    }

    public static void pantallas() {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setVisible(true);
        menuPrincipal.setLocationRelativeTo(null);
    }

//    private static void testJDBC() throws DAOException {
//        ItemMenuJDBC itemMenuDAO = new DAOItemMenu(jdbcUsername, jdbcPassword);
//        VendedorJDBC vendedorDAO = new DAOVendedor(jdbcUsername, jdbcPassword);
//        ClienteJDBC clienteDAO = new DAOCliente(jdbcUsername, jdbcPassword);
//        
//        ItemMenuController itemMenuController = ItemMenuController.getInstance(itemMenuDAO);
//        VendedorController vendedorController = VendedorController.getInstance(vendedorDAO);
//        ClienteController clienteController = ClienteController.getInstance(clienteDAO);
//        
//        vendedorController.cargarVendedores();
//        clienteController.cargarClientes();
//        itemMenuController.cargarItemsMenu();
//    }
//
//    private static void testMemory() throws DAOException {
//        DAOItemMenu itemMenuDAO = ItemMenuMemory.getInstance();
//        DAOVendedor vendedorDAO = VendedorMemory.getInstance();
//        DAOCliente clienteDAO = ClienteMemory.getInstance();
//        DAOItemsPedido itemPedidoDAO = ItemPedidoMemory.getInstance();
//        DAOPedido pedidoDAO = PedidoMemory.getInstance();
//        
//        ItemMenuController itemMenuController = ItemMenuController.getInstance(itemMenuDAO);
//        VendedorController vendedorController = VendedorController.getInstance(vendedorDAO);
//        ClienteController clienteController = ClienteController.getInstance(clienteDAO);
//        ItemsPedidoController itemPedidoController = ItemsPedidoController.getInstance(itemPedidoDAO);
//        PedidoController pedidoController = PedidoController.getInstance(pedidoDAO);
//        
//        
//        vendedorController.cargarVendedores();
//        clienteController.cargarClientes();
//        itemMenuController.cargarItemsMenu();
//    }
    
    
    
    
    public static void casoPruebaParte5() throws VendedorNoCoincideException, PedidoInvalidoException {
        // Crear métodos de pago
        Pago pago1 = new MercadoPago("cliente1.alias.mercado");
        Pago pago2 = new Transferencia("12345678901234567890", "20-12345678-9");
        Pago pago3 = new MercadoPago("cliente3.alias.mercado");
        Pago pago4 = new Transferencia("09876543210987654321", "20-12345678-9");
        Pago pago5 = new MercadoPago("cliente4.alias.mercado");
        Pago pago6 = new Transferencia("11223344556677889900", "20-55556666-9");
        Pago pago7 = new MercadoPago("cliente6.alias.mercado");
        Pago pago8 = new Transferencia("22334455667788990011", "20-99990000-9");
        
        
        //ItemPedidoMemory itemPedidoMemory = new ItemPedidoMemory();
        
        System.out.println("Pedido 1:");
	// Pedido p1 para Cliente 1 en Restaurante A con MercadoPago
        // crear ItemsPedido con los itemMenu
//        ItemsPedido itemsP1a = new ItemsPedido(1, gaseosa, 2);
//        ItemsPedido itemsP1b = new ItemsPedido(2, bife, 1);
//        ItemsPedido itemsP1c = new ItemsPedido(4, pizza, 1);
//        
//        List<ItemsPedido> itemsP1 = List.of(itemsP1a, itemsP1b, itemsP1c); // Todos los ítems pertenecen a v1
//        Pedido p1 = Pedido.crearYMostrarPedido(11, c1, itemsP1, pago1);
//        p1.agregarObservador(c1);
//        p1.cambiarEstado(EstadoPedido.EN_ENVIO);
//        
//        System.out.println("Pedido 2:");
//        // Pedido p2 para Cliente 2 en Restaurante B con Transferencia
//        // crear ItemsPedido con los itemMenu
//        ItemsPedido itemsP2a = new ItemsPedido(5, vino, 1);
//        ItemsPedido itemsP2b = new ItemsPedido(6, postre, 2); 
//        ItemsPedido itemsP2c = new ItemsPedido(7, cerveza, 2);
//        
//        List<ItemsPedido> itemsP2 = List.of(itemsP2a, itemsP2b, itemsP2c); // Todos los ítems pertenecen a v2
//        Pedido p2 = Pedido.crearYMostrarPedido(22, c2, itemsP2, pago2);
//        p2.agregarObservador(c2);
//        p2.cambiarEstado(EstadoPedido.EN_ENVIO);
//        
//        System.out.println("Pedido 3:");
//        // Pedido p3 para Cliente 3 en Restaurante C con MercadoPago
//        // crear ItemsPedido con los itemMenu
//        ItemsPedido itemsP3a = new ItemsPedido(8, ensalada, 1);
//        ItemsPedido itemsP3b = new ItemsPedido(9, aguaMineral, 2);
//        List<ItemsPedido> itemsP3 = List.of(itemsP3a, itemsP3b); // Todos los ítems pertenecen a v3
//        Pedido p3 = Pedido.crearYMostrarPedido(33, c3, itemsP3, pago3);
//        p3.agregarObservador(c3);
//        p3.cambiarEstado(EstadoPedido.EN_ENVIO);
//        
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