package isi.deso.tpds;

import isi.deso.tpds.MetodoPago.Pago;
import isi.deso.tpds.MetodoPago.MercadoPago;
import isi.deso.tpds.MetodoPago.Transferencia;
import isi.deso.tpds.BD.DatabaseConnection;
import isi.deso.tpds.Exceptions.DAOException;
import isi.deso.tpds.Exceptions.PedidoInvalidoException;
import isi.deso.tpds.Exceptions.VendedorNoCoincideException;
import isi.deso.tpds.MenuPrincipal.MenuPrincipal;
import isi.deso.tpds.MetodoPago.DAOMetodoPago;
import isi.deso.tpds.ItemMenu.ItemMenuController;
import isi.deso.tpds.ItemMenu.DAOItemMenu;
import isi.deso.tpds.ItemMenu.ItemMenuJDBC;
import isi.deso.tpds.ItemMenu.ItemMenuMemory;
import isi.deso.tpds.Cliente.DAOCliente;
import isi.deso.tpds.Cliente.ClienteJDBC;
import isi.deso.tpds.Cliente.ClienteController;
import isi.deso.tpds.Cliente.ClienteMemory;
import isi.deso.tpds.Categoria.CategoriaJDBC;
import isi.deso.tpds.Categoria.DAOCategoria;
import isi.deso.tpds.ItemPedido.DAOItemsPedido;
import isi.deso.tpds.ItemPedido.ItemPedidoMemory;
import isi.deso.tpds.ItemPedido.ItemsPedidoController;
import isi.deso.tpds.Vendedor.DAOVendedor;
import isi.deso.tpds.Vendedor.VendedorMemory;
import isi.deso.tpds.Vendedor.VendedorJDBC;
import isi.deso.tpds.Vendedor.VendedorController;
import isi.deso.tpds.MetodoPago.PagoJDBC;
import isi.deso.tpds.Pedido.DAOPedido;
import isi.deso.tpds.Pedido.PedidoController;
import isi.deso.tpds.Pedido.PedidoJDBC;

public class TpDS {
    private static boolean useJDBC = false;

    public static void main(String[] args) throws VendedorNoCoincideException, PedidoInvalidoException, DAOException {
        new PantallaIntro().setOnModeSelected(modeSelection -> inicializar(modeSelection));
    }

    private static void inicializar(ModeSelection modeSelection)  {
        useJDBC = modeSelection.useJDBC;
        
        DatabaseConnection.setCredentials(modeSelection.username, modeSelection.password);
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

    public static void pantallas() {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setVisible(true);
        menuPrincipal.setLocationRelativeTo(null);
    }

    private static void testJDBC() throws DAOException {
        DAOVendedor vendedorDAO = new VendedorJDBC();
        VendedorController vendedorController = VendedorController.getInstance(vendedorDAO);

        DAOCliente clienteDAO = new ClienteJDBC();
        ClienteController clienteController = ClienteController.getInstance(clienteDAO);

        DAOCategoria categoriaDAO = new CategoriaJDBC();
        DAOItemMenu itemMenuDAO = new ItemMenuJDBC(categoriaDAO, vendedorDAO);
        ItemMenuController itemMenuController = ItemMenuController.getInstance(itemMenuDAO);
        
        DAOCliente daoCliente = new ClienteJDBC();
        DAOMetodoPago daoMetodoPago = new PagoJDBC();
        DAOPedido daoPedido = new PedidoJDBC(daoCliente, daoMetodoPago);
        PedidoController pedidoController = PedidoController.getInstance(daoPedido);
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


    }
   
}