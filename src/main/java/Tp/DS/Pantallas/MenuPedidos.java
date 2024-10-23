/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TP.DS.Pantallas;
import javax.swing.*;
import javax.swing.table.*;
import Tp.DS.Pantallas.VentanaDeCreacionEdicionPedido;

public class MenuPedidos extends javax.swing.JFrame {
    private MenuPrincipal menuPrincipal;
    private MenuVendedor menuVendedor;
    private MenuCliente menuCliente;
    private MenuItemsMenu menuItemsMenu;
    private MenuPedidos menuPedidos;
    //para tabla
    private Object[][] pedidos;
    DefaultTableModel model;
    
    public void setListaTablaPedidos() {
        model = (DefaultTableModel) tablaPedido.getModel();
        pedidos = new Object[][] {
            {1, "Cliente 1", "Items Pedido 1", "EFECTIVO", "RECIBIDO", "1000", "15/08/2024", "5000"},
            {2, "Cliente 2", "Items Pedido 2", "MERCADO PAGO", "EN PREPARACION", "1500", "16/08/2024", "7500"},
            {3, "Cliente 3", "Items Pedido 3", "EFECTIVO", "EN ENVIO", "2000", "17/08/2024", "10000"},
            {4, "Cliente 4", "Items Pedido 4", "MERCADO PAGO", "ENTREGADO", "2500", "18/08/2024", "12500"},
            {5, "Cliente 5", "Items Pedido 5", "EFECTIVO", "RECIBIDO", "3000", "19/08/2024", "15000"},
            {6, "Cliente 6", "Items Pedido 6", "MERCADO PAGO", "EN PREPARACION", "3500", "20/08/2024", "17500"},
            {7, "Cliente 7", "Items Pedido 7", "EFECTIVO", "EN ENVIO", "4000", "21/08/2024", "20000"},
            {8, "Cliente 8", "Items Pedido 8", "MERCADO PAGO", "ENTREGADO", "4500", "22/08/2024", "22500"},
            {9, "Cliente 9", "Items Pedido 9", "EFECTIVO", "RECIBIDO", "5000", "23/08/2024", "25000"},
            {10, "Cliente 10", "Items Pedido 10", "MERCADO PAGO", "EN PREPARACION", "5500", "24/08/2024", "27500"}
        };
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
    public void setMenuPedidos(MenuPedidos menuPedidos) {
        this.menuPedidos = menuPedidos;
    }
    public void recibirDatosDeCreacion(String cliente, String itemsPedido, String metodoDePago, String estadoPedido, String montoBase, String fechaDePago, String montoTotal) {
        Object[] vendedor = new Object[] {model.getRowCount() + 1, cliente, itemsPedido, metodoDePago, estadoPedido, montoBase, fechaDePago, montoTotal};
        model.addRow(vendedor);
    }
    public void recibirDatosDeEdicion(int filaSeleccionada, String cliente, String itemsPedido, String metodoDePago, String estadoPedido, String montoBase, String fechaDePago, String montoTotal) {
        model.setValueAt(cliente, filaSeleccionada, 1);
        model.setValueAt(itemsPedido, filaSeleccionada, 2);
        model.setValueAt(metodoDePago, filaSeleccionada, 3);
        model.setValueAt(estadoPedido, filaSeleccionada, 4);
        model.setValueAt(montoBase, filaSeleccionada, 5);
        model.setValueAt(fechaDePago, filaSeleccionada, 6); 
        model.setValueAt(montoTotal, filaSeleccionada, 7); 
    }
    
    public MenuPedidos() {
        initComponents();
        setListaTablaPedidos();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Panel = new javax.swing.JPanel();
        botonVendedor = new javax.swing.JButton();
        botonCliente = new javax.swing.JButton();
        botonPedidos = new javax.swing.JButton();
        botonItemsMenu = new javax.swing.JButton();
        texto1 = new javax.swing.JLabel();
        botonVolver = new javax.swing.JButton();
        buscarPedido = new javax.swing.JButton();
        botonEditarPedido = new javax.swing.JButton();
        botonEliminarPedido = new javax.swing.JButton();
        botonCrearPedido = new javax.swing.JButton();
        campoCliente = new javax.swing.JTextField();
        textoCliente = new javax.swing.JLabel();
        campoItemsPedido = new javax.swing.JTextField();
        textoItemsPedido = new javax.swing.JLabel();
        textoMetodoDePago = new javax.swing.JLabel();
        scrollTablaPedido = new javax.swing.JScrollPane();
        tablaPedido = new javax.swing.JTable();
        campoMontoBase = new javax.swing.JTextField();
        textoMontoBase = new javax.swing.JLabel();
        textoEstadoPedido = new javax.swing.JLabel();
        campoFechaDePago = new javax.swing.JTextField();
        textoFechaDePago = new javax.swing.JLabel();
        textoMontoTotal = new javax.swing.JLabel();
        campoMontoTotal = new javax.swing.JTextField();
        comboBoxMetodoDePago = new javax.swing.JComboBox<>();
        comboBoxEstadoPedido = new javax.swing.JComboBox<>();

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

        Panel.setBackground(new java.awt.Color(69, 69, 69));
        Panel.setAlignmentX(0.0F);
        Panel.setAlignmentY(0.0F);
        Panel.setMaximumSize(new java.awt.Dimension(1000, 1000));
        Panel.setMinimumSize(new java.awt.Dimension(900, 600));
        Panel.setPreferredSize(new java.awt.Dimension(900, 600));

        botonVendedor.setBackground(new java.awt.Color(123, 36, 28));
        botonVendedor.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        botonVendedor.setForeground(new java.awt.Color(255, 255, 255));
        botonVendedor.setText("VENDEDORES");
        botonVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVendedorActionPerformed(evt);
            }
        });

        botonCliente.setBackground(new java.awt.Color(123, 36, 28));
        botonCliente.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        botonCliente.setForeground(new java.awt.Color(255, 255, 255));
        botonCliente.setText("CLIENTES");
        botonCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonClienteActionPerformed(evt);
            }
        });

        botonPedidos.setBackground(new java.awt.Color(123, 36, 28));
        botonPedidos.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        botonPedidos.setForeground(new java.awt.Color(255, 255, 255));
        botonPedidos.setText("PEDIDOS");
        botonPedidos.setEnabled(false);
        botonPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPedidosActionPerformed(evt);
            }
        });

        botonItemsMenu.setBackground(new java.awt.Color(123, 36, 28));
        botonItemsMenu.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        botonItemsMenu.setForeground(new java.awt.Color(255, 255, 255));
        botonItemsMenu.setText("ITEMS MENÚ");
        botonItemsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonItemsMenuActionPerformed(evt);
            }
        });

        texto1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        texto1.setDisabledIcon(new javax.swing.ImageIcon("C:\\Users\\Ale\\Desktop\\UTN 2024\\2do Cuatri\\3ro - Desarrollo Software\\TP\\tpDesarrolloSoftware\\logo.jpg")); // NOI18N
        texto1.setEnabled(false);
        texto1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        botonVolver.setBackground(new java.awt.Color(123, 36, 28));
        botonVolver.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        botonVolver.setForeground(new java.awt.Color(255, 255, 255));
        botonVolver.setText("VOLVER");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        buscarPedido.setBackground(new java.awt.Color(123, 36, 28));
        buscarPedido.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        buscarPedido.setForeground(new java.awt.Color(255, 255, 255));
        buscarPedido.setText("BUSCAR PEDIDO");
        buscarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPedidoActionPerformed(evt);
            }
        });

        botonEditarPedido.setBackground(new java.awt.Color(123, 36, 28));
        botonEditarPedido.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonEditarPedido.setForeground(new java.awt.Color(255, 255, 255));
        botonEditarPedido.setText("EDITAR PEDIDO");
        botonEditarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarPedidoActionPerformed(evt);
            }
        });

        botonEliminarPedido.setBackground(new java.awt.Color(123, 36, 28));
        botonEliminarPedido.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonEliminarPedido.setForeground(new java.awt.Color(255, 255, 255));
        botonEliminarPedido.setText("ELIMINAR PEDIDO");
        botonEliminarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarPedidoActionPerformed(evt);
            }
        });

        botonCrearPedido.setBackground(new java.awt.Color(123, 36, 28));
        botonCrearPedido.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonCrearPedido.setForeground(new java.awt.Color(255, 255, 255));
        botonCrearPedido.setText("CREAR PEDIDO");
        botonCrearPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearPedidoActionPerformed(evt);
            }
        });

        campoCliente.setBackground(new java.awt.Color(123, 36, 28));
        campoCliente.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoCliente.setForeground(new java.awt.Color(255, 255, 255));

        textoCliente.setBackground(new java.awt.Color(123, 35, 27));
        textoCliente.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        textoCliente.setForeground(new java.awt.Color(255, 255, 255));
        textoCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoCliente.setText("Cliente");
        textoCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textoCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        textoCliente.setInheritsPopupMenu(false);

        campoItemsPedido.setBackground(new java.awt.Color(123, 36, 28));
        campoItemsPedido.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoItemsPedido.setForeground(new java.awt.Color(255, 255, 255));

        textoItemsPedido.setBackground(new java.awt.Color(123, 35, 27));
        textoItemsPedido.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        textoItemsPedido.setForeground(new java.awt.Color(255, 255, 255));
        textoItemsPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoItemsPedido.setText("Items Pedido");
        textoItemsPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textoItemsPedido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        textoItemsPedido.setInheritsPopupMenu(false);

        textoMetodoDePago.setBackground(new java.awt.Color(123, 35, 27));
        textoMetodoDePago.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        textoMetodoDePago.setForeground(new java.awt.Color(255, 255, 255));
        textoMetodoDePago.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoMetodoDePago.setText("Método de Pago");
        textoMetodoDePago.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textoMetodoDePago.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        textoMetodoDePago.setInheritsPopupMenu(false);

        tablaPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Cliente", "Items Pedido", "Método de Pago", "Estado Pedido", "Monto Base", "Fecha de Pago", "Monto Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaPedido.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tablaPedido.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaPedido.setShowGrid(true);
        scrollTablaPedido.setViewportView(tablaPedido);
        if (tablaPedido.getColumnModel().getColumnCount() > 0) {
            tablaPedido.getColumnModel().getColumn(0).setMinWidth(30);
            tablaPedido.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablaPedido.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        campoMontoBase.setBackground(new java.awt.Color(123, 36, 28));
        campoMontoBase.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoMontoBase.setForeground(new java.awt.Color(255, 255, 255));

        textoMontoBase.setBackground(new java.awt.Color(123, 35, 27));
        textoMontoBase.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        textoMontoBase.setForeground(new java.awt.Color(255, 255, 255));
        textoMontoBase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoMontoBase.setText("Monto Base");
        textoMontoBase.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textoMontoBase.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        textoMontoBase.setInheritsPopupMenu(false);

        textoEstadoPedido.setBackground(new java.awt.Color(123, 35, 27));
        textoEstadoPedido.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        textoEstadoPedido.setForeground(new java.awt.Color(255, 255, 255));
        textoEstadoPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoEstadoPedido.setText("Estado Pedido");
        textoEstadoPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textoEstadoPedido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        textoEstadoPedido.setInheritsPopupMenu(false);

        campoFechaDePago.setBackground(new java.awt.Color(123, 36, 28));
        campoFechaDePago.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoFechaDePago.setForeground(new java.awt.Color(255, 255, 255));

        textoFechaDePago.setBackground(new java.awt.Color(123, 35, 27));
        textoFechaDePago.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        textoFechaDePago.setForeground(new java.awt.Color(255, 255, 255));
        textoFechaDePago.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoFechaDePago.setText("Fecha de Pago");
        textoFechaDePago.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textoFechaDePago.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        textoFechaDePago.setInheritsPopupMenu(false);

        textoMontoTotal.setBackground(new java.awt.Color(123, 35, 27));
        textoMontoTotal.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        textoMontoTotal.setForeground(new java.awt.Color(255, 255, 255));
        textoMontoTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoMontoTotal.setText("Monto Total");
        textoMontoTotal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textoMontoTotal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        textoMontoTotal.setInheritsPopupMenu(false);

        campoMontoTotal.setBackground(new java.awt.Color(123, 36, 28));
        campoMontoTotal.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoMontoTotal.setForeground(new java.awt.Color(255, 255, 255));

        comboBoxMetodoDePago.setBackground(new java.awt.Color(123, 36, 28));
        comboBoxMetodoDePago.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        comboBoxMetodoDePago.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxMetodoDePago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EFECTIVO", "MERCADO PAGO" }));

        comboBoxEstadoPedido.setBackground(new java.awt.Color(123, 36, 28));
        comboBoxEstadoPedido.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        comboBoxEstadoPedido.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxEstadoPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RECIBIDO", "EN PREPARACIÓN", "EN ENVIO", "ENTREGADO" }));

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(textoEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelLayout.createSequentialGroup()
                                    .addComponent(botonVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(botonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(4, 4, 4)
                                    .addComponent(botonItemsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(botonPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(scrollTablaPedido)
                                    .addGroup(PanelLayout.createSequentialGroup()
                                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textoMontoBase, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoMontoBase, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textoFechaDePago, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoFechaDePago, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(campoMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textoMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(33, 33, 33)
                                        .addComponent(buscarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelLayout.createSequentialGroup()
                                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(campoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(campoItemsPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textoItemsPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(comboBoxMetodoDePago, 0, 210, Short.MAX_VALUE)
                                            .addComponent(textoMetodoDePago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(comboBoxEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(texto1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(botonEditarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonCrearPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonEliminarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(texto1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonItemsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoItemsPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoMetodoDePago, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoItemsPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBoxMetodoDePago, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBoxEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textoFechaDePago, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textoMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoFechaDePago, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(campoMontoTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                .addComponent(textoMontoBase, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoMontoBase, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(buscarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addComponent(scrollTablaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEditarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCrearPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        getContentPane().add(Panel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVendedorActionPerformed
        menuVendedor.setMenuPedidos(this);
        menuVendedor.setVisible(true);
        menuVendedor.setLocationRelativeTo(null);
        setVisible(false);
    }//GEN-LAST:event_botonVendedorActionPerformed

    private void botonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonClienteActionPerformed
        menuCliente.setMenuPedidos(this);
        menuCliente.setVisible(true);
        menuCliente.setLocationRelativeTo(null);
        setVisible(false);
    }//GEN-LAST:event_botonClienteActionPerformed

    private void botonPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPedidosActionPerformed
        //fdg
    }//GEN-LAST:event_botonPedidosActionPerformed

    private void botonItemsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonItemsMenuActionPerformed
        menuItemsMenu.setMenuPedidos(this);
        menuItemsMenu.setVisible(true);
        menuItemsMenu.setLocationRelativeTo(null);
        setVisible(false);
    }//GEN-LAST:event_botonItemsMenuActionPerformed

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        menuPrincipal.setVisible(true);
        menuPrincipal.setLocationRelativeTo(null);
        setVisible(false);
    }//GEN-LAST:event_botonVolverActionPerformed

    private void buscarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPedidoActionPerformed
        String clienteBuscado = campoCliente.getText().trim();
        String itemsPedidoBuscado = campoItemsPedido.getText().trim();
        String metodoDePagoBuscado = comboBoxMetodoDePago.toString();
        String estadoPedidoBuscado = comboBoxEstadoPedido.toString();
        String montoBaseBuscado = campoMontoBase.getText().trim();
        String fechaDePagoBuscado = campoFechaDePago.getText().trim();
        String montoTotalBuscado = campoMontoTotal.getText().trim();
        model.setRowCount(0);
        boolean encontrado = false;
        if (clienteBuscado.isEmpty() && itemsPedidoBuscado.isEmpty() && metodoDePagoBuscado.isEmpty() && estadoPedidoBuscado.isEmpty() 
                && montoBaseBuscado.isEmpty() && fechaDePagoBuscado.isEmpty() && montoTotalBuscado.isEmpty()) {
            for (Object[] pedido : pedidos) {
                model.addRow(pedido);
            }
            encontrado = true;
        }
        else {
            for (Object[] pedido : pedidos) {
                String cliente = ((String) pedido[1]).toLowerCase();
                String itemPedido = ((String) pedido[2]).toLowerCase();
                String metodoDePago = ((String) pedido[3]).toLowerCase();
                String estadoPedido = ((String) pedido[4]).toLowerCase();
                String montoBase = ((String) pedido[5]).toLowerCase();
                String fechaDePago = ((String) pedido[6]).toLowerCase();
                String montoTotal = ((String) pedido[7]).toLowerCase();

                if (cliente.contains(clienteBuscado)) {
                    model.addRow(pedido);
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún pedido con esos parámetros.", "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_buscarPedidoActionPerformed

    private void botonEditarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarPedidoActionPerformed
        int filaSeleccionada = tablaPedido.getSelectedRow();
        if (filaSeleccionada != -1) {
            String cliente = (String) model.getValueAt(filaSeleccionada, 1);
            String itemPedido = (String) model.getValueAt(filaSeleccionada, 2);
            String metodoDePago = (String) model.getValueAt(filaSeleccionada, 3);
            String estadoPedido = (String) model.getValueAt(filaSeleccionada, 4);
            String montoBase = (String) model.getValueAt(filaSeleccionada, 5);
            String fechaDePago = (String) model.getValueAt(filaSeleccionada, 6);
            String montoTotal = (String) model.getValueAt(filaSeleccionada, 7);
            VentanaDeCreacionEdicionPedido nuevaVentana = new VentanaDeCreacionEdicionPedido();
            nuevaVentana.setMenuPedido(this);
            nuevaVentana.setVisible(true);
            nuevaVentana.setLocationRelativeTo(null);
            nuevaVentana.recibirDatosEdicion(filaSeleccionada, cliente, itemPedido, metodoDePago, estadoPedido, montoBase, fechaDePago, montoTotal);
            nuevaVentana.setTitulo();
        }
        else {
            JOptionPane.showMessageDialog(null, "Por favor selecciona una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botonEditarPedidoActionPerformed

    private void botonEliminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarPedidoActionPerformed
        int filaSeleccionada = tablaPedido.getSelectedRow();
        if (filaSeleccionada != -1) {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este Pedido?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                model.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(null, "Pedido borrado con Éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Por favor selecciona una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botonEliminarPedidoActionPerformed

    private void botonCrearPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearPedidoActionPerformed
        VentanaDeCreacionEdicionPedido nuevaVentana = new VentanaDeCreacionEdicionPedido();
        nuevaVentana.setMenuPedido(this);
        nuevaVentana.setVisible(true);
        nuevaVentana.setLocationRelativeTo(null);
    }//GEN-LAST:event_botonCrearPedidoActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new MenuPedidos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JButton botonCliente;
    private javax.swing.JButton botonCrearPedido;
    private javax.swing.JButton botonEditarPedido;
    private javax.swing.JButton botonEliminarPedido;
    private javax.swing.JButton botonItemsMenu;
    private javax.swing.JButton botonPedidos;
    private javax.swing.JButton botonVendedor;
    private javax.swing.JButton botonVolver;
    private javax.swing.JButton buscarPedido;
    private javax.swing.JTextField campoCliente;
    private javax.swing.JTextField campoFechaDePago;
    private javax.swing.JTextField campoItemsPedido;
    private javax.swing.JTextField campoMontoBase;
    private javax.swing.JTextField campoMontoTotal;
    private javax.swing.JComboBox<String> comboBoxEstadoPedido;
    private javax.swing.JComboBox<String> comboBoxMetodoDePago;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrollTablaPedido;
    private javax.swing.JTable tablaPedido;
    private javax.swing.JLabel texto1;
    private javax.swing.JLabel textoCliente;
    private javax.swing.JLabel textoEstadoPedido;
    private javax.swing.JLabel textoFechaDePago;
    private javax.swing.JLabel textoItemsPedido;
    private javax.swing.JLabel textoMetodoDePago;
    private javax.swing.JLabel textoMontoBase;
    private javax.swing.JLabel textoMontoTotal;
    // End of variables declaration//GEN-END:variables
}
