package isi.deso.tpds.Pedido;

import isi.deso.tpds.MenuPrincipal.MenuPrincipal;
import isi.deso.tpds.Cliente.MenuCliente;
import isi.deso.tpds.ItemMenu.MenuItemsMenu;
import javax.swing.*;
import javax.swing.table.*;

import isi.deso.tpds.MetodoPago.Efectivo;
import isi.deso.tpds.MetodoPago.MercadoPago;
import isi.deso.tpds.MetodoPago.Transferencia;
import isi.deso.tpds.Vendedor.MenuVendedor;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class MenuPedidos extends JFrame {
    private MenuPrincipal menuPrincipal;
    private MenuVendedor menuVendedor;
    private MenuCliente menuCliente;
    private MenuItemsMenu menuItemsMenu;
    private PedidoController pedidoController;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    DefaultTableModel model;
    
    public MenuPedidos(PedidoController pedidoController) {
        this.pedidoController = pedidoController;
        initComponents();
        cargarTablaPedidos();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel jPanel1 = new JPanel();
        JPanel panel = new JPanel();
        JButton botonVendedor = new JButton();
        JButton botonCliente = new JButton();
        JButton botonPedidos = new JButton();
        JButton botonItemsMenu = new JButton();
        JButton botonVolver = new JButton();
        JButton buscarPedido = new JButton();
        JButton botonEditarPedido = new JButton();
        JButton botonEliminarPedido = new JButton();
        JButton botonCrearPedido = new JButton();
        campoCliente = new JTextField();
        JLabel textoCliente = new JLabel();
        campoItemsPedido = new JTextField();
        JLabel textoItemsPedido = new JLabel();
        JLabel textoMetodoDePago = new JLabel();
        JScrollPane scrollTablaPedido = new JScrollPane();
        tablaPedido = new JTable();
        campoMontoBase = new JTextField();
        JLabel textoMontoBase = new JLabel();
        JLabel textoEstadoPedido = new JLabel();
        campoFechaDePago = new JTextField();
        JLabel textoFechaDePago = new JLabel();
        JLabel textoMontoTotal = new JLabel();
        campoMontoTotal = new JTextField();
        comboBoxMetodoDePago = new JComboBox<>();
        comboBoxEstadoPedido = new JComboBox<>();
        // Variables declaration - do not modify//GEN-BEGIN:variables
        JLabel logo = new JLabel();

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new AbsoluteLayout());

        panel.setBackground(new Color(69, 69, 69));
        panel.setAlignmentX(0.0F);
        panel.setAlignmentY(0.0F);
        panel.setMaximumSize(new Dimension(1000, 1000));
        panel.setMinimumSize(new Dimension(900, 600));
        panel.setPreferredSize(new Dimension(900, 600));

        botonVendedor.setBackground(new Color(123, 36, 28));
        botonVendedor.setFont(new Font("Times New Roman", Font.PLAIN, 14)); // NOI18N
        botonVendedor.setForeground(new Color(255, 255, 255));
        botonVendedor.setText("VENDEDORES");
        botonVendedor.addActionListener(this::botonVendedorActionPerformed);

        botonCliente.setBackground(new Color(123, 36, 28));
        botonCliente.setFont(new Font("Times New Roman", Font.PLAIN, 14)); // NOI18N
        botonCliente.setForeground(new Color(255, 255, 255));
        botonCliente.setText("CLIENTES");
        botonCliente.addActionListener(this::botonClienteActionPerformed);

        botonPedidos.setBackground(new Color(123, 36, 28));
        botonPedidos.setFont(new Font("Times New Roman", Font.PLAIN, 14)); // NOI18N
        botonPedidos.setForeground(new Color(255, 255, 255));
        botonPedidos.setText("PEDIDOS");
        botonPedidos.setEnabled(false);
        botonPedidos.addActionListener(this::botonPedidosActionPerformed);

        botonItemsMenu.setBackground(new Color(123, 36, 28));
        botonItemsMenu.setFont(new Font("Times New Roman", Font.PLAIN, 14)); // NOI18N
        botonItemsMenu.setForeground(new Color(255, 255, 255));
        botonItemsMenu.setText("ITEMS MENÚ");
        botonItemsMenu.addActionListener(this::botonItemsMenuActionPerformed);

        botonVolver.setBackground(new Color(123, 36, 28));
        botonVolver.setFont(new Font("Times New Roman", Font.PLAIN, 14)); // NOI18N
        botonVolver.setForeground(new Color(255, 255, 255));
        botonVolver.setText("VOLVER");
        botonVolver.addActionListener(this::botonVolverActionPerformed);

        buscarPedido.setBackground(new Color(123, 36, 28));
        buscarPedido.setFont(new Font("Times New Roman", Font.PLAIN, 12)); // NOI18N
        buscarPedido.setForeground(new Color(255, 255, 255));
        buscarPedido.setText("BUSCAR PEDIDO");
        buscarPedido.addActionListener(this::buscarPedidoActionPerformed);

        botonEditarPedido.setBackground(new Color(123, 36, 28));
        botonEditarPedido.setFont(new Font("Times New Roman", Font.PLAIN, 12)); // NOI18N
        botonEditarPedido.setForeground(new Color(255, 255, 255));
        botonEditarPedido.setText("EDITAR PEDIDO");
        botonEditarPedido.addActionListener(this::botonEditarPedidoActionPerformed);

        botonEliminarPedido.setBackground(new Color(123, 36, 28));
        botonEliminarPedido.setFont(new Font("Times New Roman", Font.PLAIN, 12)); // NOI18N
        botonEliminarPedido.setForeground(new Color(255, 255, 255));
        botonEliminarPedido.setText("ELIMINAR PEDIDO");
        botonEliminarPedido.addActionListener(this::botonEliminarPedidoActionPerformed);

        botonCrearPedido.setBackground(new Color(123, 36, 28));
        botonCrearPedido.setFont(new Font("Times New Roman", Font.PLAIN, 12)); // NOI18N
        botonCrearPedido.setForeground(new Color(255, 255, 255));
        botonCrearPedido.setText("CREAR PEDIDO");
        botonCrearPedido.addActionListener(this::botonCrearPedidoActionPerformed);

        campoCliente.setBackground(new Color(123, 36, 28));
        campoCliente.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        campoCliente.setForeground(new Color(255, 255, 255));

        textoCliente.setBackground(new Color(123, 35, 27));
        textoCliente.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        textoCliente.setForeground(new Color(255, 255, 255));
        textoCliente.setHorizontalAlignment(SwingConstants.CENTER);
        textoCliente.setText("Cliente");
        textoCliente.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        textoCliente.setHorizontalTextPosition(SwingConstants.CENTER);
        textoCliente.setInheritsPopupMenu(false);

        campoItemsPedido.setBackground(new Color(123, 36, 28));
        campoItemsPedido.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        campoItemsPedido.setForeground(new Color(255, 255, 255));

        textoItemsPedido.setBackground(new Color(123, 35, 27));
        textoItemsPedido.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        textoItemsPedido.setForeground(new Color(255, 255, 255));
        textoItemsPedido.setHorizontalAlignment(SwingConstants.CENTER);
        textoItemsPedido.setText("Items Pedido");
        textoItemsPedido.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        textoItemsPedido.setHorizontalTextPosition(SwingConstants.CENTER);
        textoItemsPedido.setInheritsPopupMenu(false);

        textoMetodoDePago.setBackground(new Color(123, 35, 27));
        textoMetodoDePago.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        textoMetodoDePago.setForeground(new Color(255, 255, 255));
        textoMetodoDePago.setHorizontalAlignment(SwingConstants.CENTER);
        textoMetodoDePago.setText("Método de Pago");
        textoMetodoDePago.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        textoMetodoDePago.setHorizontalTextPosition(SwingConstants.CENTER);
        textoMetodoDePago.setInheritsPopupMenu(false);

        tablaPedido.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente", "Items Pedido", "Método de Pago", "Estado Pedido", "Monto Base", "Fecha de Pago", "Monto Total"
            }
        ) {
            final boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPedido.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        tablaPedido.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tablaPedido.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaPedido.setShowGrid(true);
        scrollTablaPedido.setViewportView(tablaPedido);
        if (tablaPedido.getColumnModel().getColumnCount() > 0) {
            tablaPedido.getColumnModel().getColumn(0).setMinWidth(30);
            tablaPedido.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablaPedido.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        campoMontoBase.setBackground(new Color(123, 36, 28));
        campoMontoBase.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        campoMontoBase.setForeground(new Color(255, 255, 255));

        textoMontoBase.setBackground(new Color(123, 35, 27));
        textoMontoBase.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        textoMontoBase.setForeground(new Color(255, 255, 255));
        textoMontoBase.setHorizontalAlignment(SwingConstants.CENTER);
        textoMontoBase.setText("Monto Base");
        textoMontoBase.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        textoMontoBase.setHorizontalTextPosition(SwingConstants.CENTER);
        textoMontoBase.setInheritsPopupMenu(false);

        textoEstadoPedido.setBackground(new Color(123, 35, 27));
        textoEstadoPedido.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        textoEstadoPedido.setForeground(new Color(255, 255, 255));
        textoEstadoPedido.setHorizontalAlignment(SwingConstants.CENTER);
        textoEstadoPedido.setText("Estado Pedido");
        textoEstadoPedido.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        textoEstadoPedido.setHorizontalTextPosition(SwingConstants.CENTER);
        textoEstadoPedido.setInheritsPopupMenu(false);

        campoFechaDePago.setBackground(new Color(123, 36, 28));
        campoFechaDePago.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        campoFechaDePago.setForeground(new Color(255, 255, 255));

        textoFechaDePago.setBackground(new Color(123, 35, 27));
        textoFechaDePago.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        textoFechaDePago.setForeground(new Color(255, 255, 255));
        textoFechaDePago.setHorizontalAlignment(SwingConstants.CENTER);
        textoFechaDePago.setText("Fecha de Pago");
        textoFechaDePago.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        textoFechaDePago.setHorizontalTextPosition(SwingConstants.CENTER);
        textoFechaDePago.setInheritsPopupMenu(false);

        textoMontoTotal.setBackground(new Color(123, 35, 27));
        textoMontoTotal.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        textoMontoTotal.setForeground(new Color(255, 255, 255));
        textoMontoTotal.setHorizontalAlignment(SwingConstants.CENTER);
        textoMontoTotal.setText("Monto Total");
        textoMontoTotal.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        textoMontoTotal.setHorizontalTextPosition(SwingConstants.CENTER);
        textoMontoTotal.setInheritsPopupMenu(false);

        campoMontoTotal.setBackground(new Color(123, 36, 28));
        campoMontoTotal.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        campoMontoTotal.setForeground(new Color(255, 255, 255));

        comboBoxMetodoDePago.setBackground(new Color(123, 36, 28));
        comboBoxMetodoDePago.setFont(new Font("Times New Roman", Font.PLAIN, 18)); // NOI18N
        comboBoxMetodoDePago.setForeground(new Color(255, 255, 255));
        comboBoxMetodoDePago.setModel(new DefaultComboBoxModel<>(new String[] { "EFECTIVO", "MERCADOPAGO", "TRANSFERENCIA" }));

        comboBoxEstadoPedido.setBackground(new Color(123, 36, 28));
        comboBoxEstadoPedido.setFont(new Font("Times New Roman", Font.PLAIN, 18)); // NOI18N
        comboBoxEstadoPedido.setForeground(new Color(255, 255, 255));
        comboBoxEstadoPedido.setModel(new DefaultComboBoxModel<>(new String[] { "RECIBIDO", "EN PREPARACIÓN", "EN ENVIO", "ENTREGADO" }));

        logo.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/logo.jpg")))); // NOI18N
        logo.setText("jLabel");

        GroupLayout PanelLayout = new GroupLayout(panel);
        panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(GroupLayout.Alignment.LEADING, PanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(textoEstadoPedido, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                                .addGroup(GroupLayout.Alignment.LEADING, PanelLayout.createSequentialGroup()
                                    .addComponent(botonVendedor, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(botonCliente, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                                    .addGap(4, 4, 4)
                                    .addComponent(botonItemsMenu, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(botonPedidos, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(botonVolver, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(GroupLayout.Alignment.LEADING, PanelLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(scrollTablaPedido, GroupLayout.PREFERRED_SIZE, 845, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PanelLayout.createSequentialGroup()
                                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(textoMontoBase, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoMontoBase, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textoFechaDePago, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoFechaDePago, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(campoMontoTotal, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textoMontoTotal, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
                                        .addGap(33, 33, 33)
                                        .addComponent(buscarPedido, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelLayout.createSequentialGroup()
                                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(campoCliente, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textoCliente, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(campoItemsPedido, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textoItemsPedido, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(comboBoxMetodoDePago, 0, 210, Short.MAX_VALUE)
                                            .addComponent(textoMetodoDePago, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboBoxEstadoPedido, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(botonEditarPedido, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonCrearPedido, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonEliminarPedido, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(logo, GroupLayout.PREFERRED_SIZE, 639, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(botonVendedor, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCliente, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonItemsMenu, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonPedidos, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonVolver, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(textoCliente, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoItemsPedido, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoMetodoDePago, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoEstadoPedido, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(campoItemsPedido, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoCliente, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBoxMetodoDePago, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBoxEstadoPedido, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(textoFechaDePago, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textoMontoTotal, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoFechaDePago, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                            .addComponent(campoMontoTotal, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addGroup(GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                .addComponent(textoMontoBase, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoMontoBase, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(buscarPedido, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addComponent(scrollTablaPedido, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEditarPedido, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCrearPedido, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminarPedido, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        getContentPane().add(panel, new AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonVendedorActionPerformed(ActionEvent evt) {//GEN-FIRST:event_botonVendedorActionPerformed
        menuVendedor.setMenuPedidos(this);
        menuVendedor.setVisible(true);
        menuVendedor.setLocationRelativeTo(null);
        setVisible(false);
    }//GEN-LAST:event_botonVendedorActionPerformed

    private void botonClienteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_botonClienteActionPerformed
        menuCliente.setMenuPedidos(this);
        menuCliente.setVisible(true);
        menuCliente.setLocationRelativeTo(null);
        setVisible(false);
    }//GEN-LAST:event_botonClienteActionPerformed

    private void botonPedidosActionPerformed(ActionEvent evt) {//GEN-FIRST:event_botonPedidosActionPerformed
        //
    }//GEN-LAST:event_botonPedidosActionPerformed

    private void botonItemsMenuActionPerformed(ActionEvent evt) {//GEN-FIRST:event_botonItemsMenuActionPerformed
        menuItemsMenu.setMenuPedidos(this);
        menuItemsMenu.setVisible(true);
        menuItemsMenu.setLocationRelativeTo(null);
        setVisible(false);
    }//GEN-LAST:event_botonItemsMenuActionPerformed

    private void botonVolverActionPerformed(ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        menuPrincipal.setVisible(true);
        menuPrincipal.setLocationRelativeTo(null);
        setVisible(false);
    }//GEN-LAST:event_botonVolverActionPerformed

    private void buscarPedidoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buscarPedidoActionPerformed
        String clienteBuscado = campoCliente.getText().trim().toLowerCase();
        String itemsPedidoBuscado = campoItemsPedido.getText().trim().toLowerCase();
        String metodoDePagoBuscado = comboBoxMetodoDePago.getSelectedItem() != null ?
                comboBoxMetodoDePago.getSelectedItem().toString().toLowerCase() : "";
        String estadoPedidoBuscado = comboBoxEstadoPedido.getSelectedItem() != null ?
                comboBoxEstadoPedido.getSelectedItem().toString().toLowerCase() : "";
        String montoBaseBuscado = campoMontoBase.getText().trim();
        String fechaDePagoBuscado = campoFechaDePago.getText().trim();
        String montoTotalBuscado = campoMontoTotal.getText().trim();

        model.setRowCount(0); // Limpiar la tabla
        boolean encontrado = false;

        // Obtener todos los pedidos
        List<Pedido> listaPedidos = pedidoController.mostrarListaPedidos();

        for (Pedido pedido : listaPedidos) {
            // Obtener datos del pedido

            String nombresItems = pedidoController.obtenerNombresItems(pedido);
            String nombresItemsComparacion = nombresItems.toLowerCase();
            String fechaPagoFormateada = "";
            Object fechaPago = pedido.getFechaPago();
            if (fechaPago instanceof Date) {
                fechaPagoFormateada = dateFormat.format(fechaPago);
            } else if (fechaPago != null) {
                // Si es de otro tipo (como LocalDate), conviértelo a Date
                if (fechaPago instanceof LocalDate) {
                    fechaPagoFormateada = dateFormat.format(java.sql.Date.valueOf((LocalDate) fechaPago));
                } else {
                    // Maneja otros casos si es necesario
                    System.err.println("Tipo de fecha inesperado: " + fechaPago.getClass());
                }
            }

            String metodoPago = pedido.getMetodoPago().getClass().getSimpleName();
            String metodoPagoComparacion = metodoPago.toLowerCase();
            String estadoPedido = pedido.getEstado().toString();
            String estadoPedidoComparacion = estadoPedido.toLowerCase();
            double montoBase = pedido.getMontoBase();
            double montoTotal = pedido.getMontoTotal();

            // Condiciones de filtrado
            boolean coincideCliente = clienteBuscado.isEmpty() ||
                    pedido.getCliente().getNombre().toLowerCase().contains(clienteBuscado);
            boolean coincideItems = itemsPedidoBuscado.isEmpty() ||
                    nombresItemsComparacion.contains(itemsPedidoBuscado);
            boolean coincideMetodoPago = metodoDePagoBuscado.isEmpty() ||
                    metodoPagoComparacion.equals(metodoDePagoBuscado);
            boolean coincideEstado = estadoPedidoBuscado.isEmpty() ||
                    estadoPedidoComparacion.equals(estadoPedidoBuscado);
            boolean coincideMontoBase = true;
            if (!montoBaseBuscado.isEmpty()) {
                try {
                    coincideMontoBase = Double.parseDouble(montoBaseBuscado) == montoBase;
                } catch (NumberFormatException e) {
                    coincideMontoBase = false;
                }
            }
            boolean coincideFechaPago = fechaDePagoBuscado.isEmpty() ||
                    fechaPagoFormateada.equals(fechaDePagoBuscado);
            boolean coincideMontoTotal = true;
            if (!montoTotalBuscado.isEmpty()) {
                try {
                    coincideMontoTotal = Double.parseDouble(montoTotalBuscado) == montoTotal;
                } catch (NumberFormatException e) {
                    coincideMontoTotal = false;
                }
            }

            // Agregar fila si cumple con todos los filtros
            if (coincideCliente && coincideItems && coincideMetodoPago &&
                    coincideEstado && coincideMontoBase && coincideFechaPago && coincideMontoTotal) {
                encontrado = true;
                model.addRow(new Object[]{
                        pedido.getId(),
                        pedido.getCliente().getNombre(),
                        nombresItems,
                        metodoPago,
                        estadoPedido,
                        pedido.getMontoBase(),
                        fechaPagoFormateada,
                        pedido.getMontoTotal()
                });
            }
        }

        // Mostrar mensaje si no se encuentra ningún pedido
        if (!encontrado) {
            JOptionPane.showMessageDialog(this, "No se encontró ningún pedido con esos parámetros.",
                    "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_buscarPedidoActionPerformed

    private void botonEditarPedidoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_botonEditarPedidoActionPerformed
        int filaSeleccionada = tablaPedido.getSelectedRow();
        if (filaSeleccionada != -1) {
            int pedidoId = (int) model.getValueAt(filaSeleccionada, 0);
            Pedido pedido = pedidoController.buscarPedido(pedidoId);
            if (pedido != null) {
                VentanaDeCreacionEdicionPedido nuevaVentana = new VentanaDeCreacionEdicionPedido(pedidoController);
                nuevaVentana.recibirDatosEdicion(filaSeleccionada, pedido);
                nuevaVentana.setVisible(true);
                nuevaVentana.setLocationRelativeTo(null);
                nuevaVentana.setTitulo();
                nuevaVentana.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent windowEvent) {
                        cargarTablaPedidos();
                    }
                });
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el pedido para editar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Por favor selecciona una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botonEditarPedidoActionPerformed

    private void botonEliminarPedidoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_botonEliminarPedidoActionPerformed
        int filaSeleccionada = tablaPedido.getSelectedRow();
        if (filaSeleccionada != -1) {
            int pedidoId = (int) model.getValueAt(filaSeleccionada, 0);
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este Pedido?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                pedidoController.eliminarPedido(pedidoId);
                cargarTablaPedidos();
                
                JOptionPane.showMessageDialog(null, "Pedido borrado con Éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Por favor selecciona una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botonEliminarPedidoActionPerformed

    private void botonCrearPedidoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_botonCrearPedidoActionPerformed
        VentanaDeCreacionEdicionPedido nuevaVentana = new VentanaDeCreacionEdicionPedido(pedidoController);
        nuevaVentana.setMenuPedido(this);
        nuevaVentana.setVisible(true);
        nuevaVentana.setLocationRelativeTo(null);
        nuevaVentana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent windowEvent) {
                cargarTablaPedidos(); // actualizar tabla tras creación
            }
        });
    }//GEN-LAST:event_botonCrearPedidoActionPerformed

    private void cargarTablaPedidos() {
        model = (DefaultTableModel) tablaPedido.getModel();
        model.setRowCount(0);
        List<Pedido> listaPedidos = pedidoController.mostrarListaPedidos();
        for (Pedido pedido : listaPedidos) {
            String nombresItems = pedidoController.obtenerNombresItems(pedido);
            String fechaPagoFormateada = pedido.getFechaPago() != null ? dateFormat.format(pedido.getFechaPago()) : "";
            String metodo = "";
            if (pedido.getMetodoPago() instanceof Efectivo) {
                metodo = "Efectivo";
            } else if (pedido.getMetodoPago() instanceof Transferencia) {
                metodo = "Transferencia";
            } else if (pedido.getMetodoPago() instanceof MercadoPago) {
                metodo = "Mercado Pago";
            }
            model.addRow(new Object[]{
                    pedido.getId(),
                    pedido.getCliente().getNombre(),
                    nombresItems,
                    metodo,
                    pedido.getEstado(),
                    pedido.getMontoBase(),
                    fechaPagoFormateada,
                    pedido.getMontoTotal()
            });
        }
    }

    public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
    }
    public void setMenuVendedor(MenuVendedor menuVendedor) {
        this.menuVendedor = menuVendedor;
    }
    public void setMenuCliente(MenuCliente menuCliente) {
        this.menuCliente = menuCliente;
    }
    public void setMenuItemsMenu(MenuItemsMenu menuItemsMenu) {
        this.menuItemsMenu = menuItemsMenu;
    }
    public void setMenuPedidos() {
    }

    public static void main(String[] args) {
        DAOPedido pedidoDAO = PedidoMemory.getInstance();
        PedidoController pedidoController = PedidoController.getInstance(pedidoDAO);
        EventQueue.invokeLater(() -> new MenuPedidos(pedidoController).setVisible(true));
    }

    private JTextField campoCliente;
    private JTextField campoFechaDePago;
    private JTextField campoItemsPedido;
    private JTextField campoMontoBase;
    private JTextField campoMontoTotal;
    private JComboBox<String> comboBoxEstadoPedido;
    private JComboBox<String> comboBoxMetodoDePago;
    private JTable tablaPedido;
    // End of variables declaration//GEN-END:variables
}
