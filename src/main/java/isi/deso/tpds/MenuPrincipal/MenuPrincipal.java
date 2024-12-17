package isi.deso.tpds.MenuPrincipal;

import isi.deso.tpds.Vendedor.DAOVendedor;
import isi.deso.tpds.Vendedor.VendedorMemory;
import isi.deso.tpds.Vendedor.MenuVendedor;
import isi.deso.tpds.Vendedor.VendedorController;
import isi.deso.tpds.Pedido.DAOPedido;
import isi.deso.tpds.Pedido.PedidoController;
import isi.deso.tpds.Pedido.PedidoMemory;
import isi.deso.tpds.Pedido.MenuPedidos;
import isi.deso.tpds.ItemMenu.ItemMenuController;
import isi.deso.tpds.ItemMenu.DAOItemMenu;
import isi.deso.tpds.ItemMenu.MenuItemsMenu;
import isi.deso.tpds.ItemMenu.ItemMenuMemory;
import isi.deso.tpds.Cliente.DAOCliente;
import isi.deso.tpds.Cliente.ClienteController;
import isi.deso.tpds.Cliente.MenuCliente;
import isi.deso.tpds.Cliente.ClienteMemory;

import java.awt.*;
import java.util.Objects;

public class MenuPrincipal extends javax.swing.JFrame {
    DAOPedido pedidoDAO = PedidoMemory.getInstance();
    DAOItemMenu itemMenuDAO = ItemMenuMemory.getInstance();
    DAOVendedor vendedorDAO = VendedorMemory.getInstance();
    DAOCliente clienteDAO = ClienteMemory.getInstance();

    PedidoController pedidoController = PedidoController.getInstance(pedidoDAO);
    ItemMenuController itemMenuController = ItemMenuController.getInstance(itemMenuDAO);
    VendedorController vendedorController = VendedorController.getInstance(vendedorDAO);
    ClienteController clienteController = ClienteController.getInstance(clienteDAO);

    MenuVendedor menuVendedor = new MenuVendedor(vendedorController);
    
    MenuItemsMenu menuItemsMenu = new MenuItemsMenu(itemMenuController, vendedorController);
    
    MenuPedidos menuPedidos = new MenuPedidos(pedidoController);
    
    MenuCliente menuCliente = new MenuCliente(clienteController); 
    
    public MenuPrincipal() {
        initComponents();   
        
        menuVendedor.setMenuPrincipal(this);
        menuVendedor.setMenuVendedor(menuVendedor);
        menuVendedor.setMenuCliente(menuCliente);
        menuVendedor.setMenuItemsMenu(menuItemsMenu);
        menuVendedor.setMenuPedidos(menuPedidos);
        
        menuCliente.setMenuPrincipal(this);
        menuCliente.setMenuVendedor(menuVendedor);
        menuCliente.setMenuCliente();
        menuCliente.setMenuItemsMenu(menuItemsMenu);
        menuCliente.setMenuPedidos(menuPedidos);
        
        menuPedidos.setMenuPrincipal(this);
        menuPedidos.setMenuVendedor(menuVendedor);
        menuPedidos.setMenuCliente(menuCliente);
        menuPedidos.setMenuItemsMenu(menuItemsMenu);
        menuPedidos.setMenuPedidos();
        
        menuItemsMenu.setMenuPrincipal(this);
        menuItemsMenu.setMenuVendedor(menuVendedor);
        menuItemsMenu.setMenuCliente(menuCliente);
        menuItemsMenu.setMenuItemsMenu(menuItemsMenu);
        menuItemsMenu.setMenuPedidos(menuPedidos);
        
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JPanel jPanel3 = new javax.swing.JPanel();
        javax.swing.JButton botonVendedor = new javax.swing.JButton();
        javax.swing.JButton botonCliente = new javax.swing.JButton();
        javax.swing.JButton botonPedidos = new javax.swing.JButton();
        javax.swing.JButton botonItemsMenu = new javax.swing.JButton();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        // Variables declaration - do not modify                     
        javax.swing.JLabel logo = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(69, 69, 69));
        jPanel3.setAlignmentX(0.0F);
        jPanel3.setAlignmentY(0.0F);
        jPanel3.setMaximumSize(new java.awt.Dimension(900, 600));
        jPanel3.setMinimumSize(new java.awt.Dimension(900, 600));
        jPanel3.setPreferredSize(new java.awt.Dimension(900, 600));

        botonVendedor.setBackground(new java.awt.Color(123, 36, 28));
        botonVendedor.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 24)); // NOI18N
        botonVendedor.setForeground(new java.awt.Color(255, 255, 255));
        botonVendedor.setText("VENDEDORES");
        botonVendedor.addActionListener(this::botonVendedorActionPerformed);

        botonCliente.setBackground(new java.awt.Color(123, 36, 28));
        botonCliente.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 24)); // NOI18N
        botonCliente.setForeground(new java.awt.Color(255, 255, 255));
        botonCliente.setText("CLIENTES");
        botonCliente.addActionListener(this::botonClienteActionPerformed);

        botonPedidos.setBackground(new java.awt.Color(123, 36, 28));
        botonPedidos.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 24)); // NOI18N
        botonPedidos.setForeground(new java.awt.Color(255, 255, 255));
        botonPedidos.setText("PEDIDOS");
        botonPedidos.addActionListener(this::botonPedidosActionPerformed);

        botonItemsMenu.setBackground(new java.awt.Color(123, 36, 28));
        botonItemsMenu.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 24)); // NOI18N
        botonItemsMenu.setForeground(new java.awt.Color(255, 255, 255));
        botonItemsMenu.setText("ITEMS MENÚ");
        botonItemsMenu.addActionListener(this::botonItemsMenuActionPerformed);

        jLabel1.setBackground(new java.awt.Color(123, 36, 28));
        jLabel1.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Desde este panel puede buscar, editar, crear o eliminar los siguientes componentes");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);

        logo.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/logo.jpg")))); // NOI18N
        logo.setText("jLabel");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonItemsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(150, 150, 150))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonItemsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>                        

    private void botonVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVendedorActionPerformed
        menuVendedor.setVisible(true);
        menuVendedor.setLocationRelativeTo(null);
        setVisible(false);
    }//GEN-LAST:event_botonVendedorActionPerformed

    private void botonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonClienteActionPerformed
        menuCliente.setVisible(true);
        menuCliente.setLocationRelativeTo(null);
        setVisible(false);
    }//GEN-LAST:event_botonClienteActionPerformed

    private void botonPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPedidosActionPerformed
        menuPedidos.setVisible(true);
        menuPedidos.setLocationRelativeTo(null);
        setVisible(false);
    }//GEN-LAST:event_botonPedidosActionPerformed

    private void botonItemsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonItemsMenuActionPerformed
        menuItemsMenu.setVisible(true);
        menuItemsMenu.setLocationRelativeTo(null);
        setVisible(false);
    }//GEN-LAST:event_botonItemsMenuActionPerformed

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new MenuPrincipal().setVisible(true));
    }

    // End of variables declaration                   
}
