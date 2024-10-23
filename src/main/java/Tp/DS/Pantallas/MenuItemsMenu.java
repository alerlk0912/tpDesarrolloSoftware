/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TP.DS.Pantallas;
import javax.swing.*;
import javax.swing.table.*;
import Tp.DS.Pantallas.VentanaDeCreacionEdicionItemsMenu;

public class MenuItemsMenu extends javax.swing.JFrame {
    private MenuPrincipal menuPrincipal;
    private MenuVendedor menuVendedor;
    private MenuCliente menuCliente;
    private MenuItemsMenu menuItemsMenu;
    private MenuPedidos menuPedidos;
    //para tabla
    private Object[][] itemsMenu;
    DefaultTableModel model;
    
    public void setListaTablaItemsMenu() {
        model = (DefaultTableModel) tablaItemsMenu.getModel();
        itemsMenu = new Object[][] {
            {1, "Gaseosa", "Refresco de cola", "2500", "BEBIDA", "Restaurante A"},
            {2, "Bife", "Bife de chorizo", "5000", "PLATO", "Restaurante B"},
            {3, "Agua", "Agua mineral", "1500", "BEBIDA", "Restaurante C"},
            {4, "Ensalada", "Ensalada César", "3000", "PLATO", "Restaurante D"},
            {5, "Cerveza", "Cerveza artesanal", "3500", "BEBIDA", "Restaurante E"},
            {6, "Pizza", "Pizza de jamón y queso", "4500", "PLATO", "Restaurante F"},
            {7, "Jugo", "Jugo de naranja", "2000", "BEBIDA", "Restaurante G"},
            {8, "Pasta", "Spaghetti a la bolognesa", "5500", "PLATO", "Restaurante H"},
            {9, "Vino", "Vino tinto", "6000", "BEBIDA", "Restaurante I"},
            {10, "Hamburguesa", "Hamburguesa con queso", "4000", "PLATO", "Restaurante J"}
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
    public void recibirDatosDeCreacion(String nombre, String descripcion, String precio, String categoria, String vendedor) {
        Object[] itemsMenuArr = new Object[] {model.getRowCount() + 1, nombre, descripcion, precio, categoria, vendedor};
        model.addRow(itemsMenuArr);
    }
    public void recibirDatosDeEdicion(int filaSeleccionada, String nombre, String descripcion, String precio, String categoria, String vendedor) {
        model.setValueAt(nombre, filaSeleccionada, 1);
        model.setValueAt(descripcion, filaSeleccionada, 2);
        model.setValueAt(precio, filaSeleccionada, 3);
        model.setValueAt(categoria, filaSeleccionada, 4);
        model.setValueAt(vendedor, filaSeleccionada, 5);
    }
    
    public MenuItemsMenu() {
        initComponents();
        setListaTablaItemsMenu();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        texto1 = new javax.swing.JLabel();
        buscarItemsMenu = new javax.swing.JButton();
        botonEditarItemsMenu = new javax.swing.JButton();
        botonEliminarItemsMenu = new javax.swing.JButton();
        botonCrearItemsMenu = new javax.swing.JButton();
        campoNombre = new javax.swing.JTextField();
        tit1 = new javax.swing.JLabel();
        campoDireccion = new javax.swing.JTextField();
        tit2 = new javax.swing.JLabel();
        tit3 = new javax.swing.JLabel();
        scrollTablaItemsMenu = new javax.swing.JScrollPane();
        tablaItemsMenu = new javax.swing.JTable();
        campoPrecio = new javax.swing.JTextField();
        tit5 = new javax.swing.JLabel();
        tit4 = new javax.swing.JLabel();
        comboBoxCategoria = new javax.swing.JComboBox<>();
        campoVendedor = new javax.swing.JTextField();
        botonCliente = new javax.swing.JButton();
        botonVendedor = new javax.swing.JButton();
        botonVolver = new javax.swing.JButton();
        botonItemsMenu = new javax.swing.JButton();
        botonPedidos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 1000));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel.setBackground(new java.awt.Color(69, 69, 69));
        Panel.setAlignmentX(0.0F);
        Panel.setAlignmentY(0.0F);
        Panel.setMaximumSize(new java.awt.Dimension(1000, 1000));
        Panel.setMinimumSize(new java.awt.Dimension(900, 600));
        Panel.setPreferredSize(new java.awt.Dimension(900, 600));

        texto1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        texto1.setDisabledIcon(new javax.swing.ImageIcon("C:\\Users\\Ale\\Desktop\\UTN 2024\\2do Cuatri\\3ro - Desarrollo Software\\TP\\tpDesarrolloSoftware\\logo.jpg")); // NOI18N
        texto1.setEnabled(false);
        texto1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        buscarItemsMenu.setBackground(new java.awt.Color(123, 36, 28));
        buscarItemsMenu.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        buscarItemsMenu.setForeground(new java.awt.Color(255, 255, 255));
        buscarItemsMenu.setText("BUSCAR ITEMS MENÚ");
        buscarItemsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarItemsMenuActionPerformed(evt);
            }
        });

        botonEditarItemsMenu.setBackground(new java.awt.Color(123, 36, 28));
        botonEditarItemsMenu.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonEditarItemsMenu.setForeground(new java.awt.Color(255, 255, 255));
        botonEditarItemsMenu.setText("EDITAR ITEMS MENÚ");
        botonEditarItemsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarItemsMenuActionPerformed(evt);
            }
        });

        botonEliminarItemsMenu.setBackground(new java.awt.Color(123, 36, 28));
        botonEliminarItemsMenu.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonEliminarItemsMenu.setForeground(new java.awt.Color(255, 255, 255));
        botonEliminarItemsMenu.setText("ELIMINAR ITEMS MENÚ");
        botonEliminarItemsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarItemsMenuActionPerformed(evt);
            }
        });

        botonCrearItemsMenu.setBackground(new java.awt.Color(123, 36, 28));
        botonCrearItemsMenu.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonCrearItemsMenu.setForeground(new java.awt.Color(255, 255, 255));
        botonCrearItemsMenu.setText("CREAR ITEMS MENÚ");
        botonCrearItemsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearItemsMenuActionPerformed(evt);
            }
        });

        campoNombre.setBackground(new java.awt.Color(123, 36, 28));
        campoNombre.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoNombre.setForeground(new java.awt.Color(255, 255, 255));

        tit1.setBackground(new java.awt.Color(123, 35, 27));
        tit1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tit1.setForeground(new java.awt.Color(255, 255, 255));
        tit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit1.setText("Nombre");
        tit1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tit1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit1.setInheritsPopupMenu(false);

        campoDireccion.setBackground(new java.awt.Color(123, 36, 28));
        campoDireccion.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoDireccion.setForeground(new java.awt.Color(255, 255, 255));

        tit2.setBackground(new java.awt.Color(123, 35, 27));
        tit2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tit2.setForeground(new java.awt.Color(255, 255, 255));
        tit2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit2.setText("Descripción");
        tit2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tit2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit2.setInheritsPopupMenu(false);

        tit3.setBackground(new java.awt.Color(123, 35, 27));
        tit3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tit3.setForeground(new java.awt.Color(255, 255, 255));
        tit3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit3.setText("Precio");
        tit3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tit3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit3.setInheritsPopupMenu(false);

        tablaItemsMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Nombre", "Descripción", "Precio", "Categoría", "Vendedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaItemsMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaItemsMenu.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tablaItemsMenu.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaItemsMenu.setShowGrid(true);
        scrollTablaItemsMenu.setViewportView(tablaItemsMenu);
        if (tablaItemsMenu.getColumnModel().getColumnCount() > 0) {
            tablaItemsMenu.getColumnModel().getColumn(0).setMinWidth(30);
            tablaItemsMenu.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablaItemsMenu.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        campoPrecio.setBackground(new java.awt.Color(123, 36, 28));
        campoPrecio.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoPrecio.setForeground(new java.awt.Color(255, 255, 255));
        campoPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPrecioActionPerformed(evt);
            }
        });

        tit5.setBackground(new java.awt.Color(123, 35, 27));
        tit5.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tit5.setForeground(new java.awt.Color(255, 255, 255));
        tit5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit5.setText("Vendedor");
        tit5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tit5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit5.setInheritsPopupMenu(false);

        tit4.setBackground(new java.awt.Color(123, 35, 27));
        tit4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tit4.setForeground(new java.awt.Color(255, 255, 255));
        tit4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit4.setText("Categoría");
        tit4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tit4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit4.setInheritsPopupMenu(false);

        comboBoxCategoria.setBackground(new java.awt.Color(123, 36, 28));
        comboBoxCategoria.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        comboBoxCategoria.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PLATO", "BEBIDA" }));

        campoVendedor.setBackground(new java.awt.Color(123, 36, 28));
        campoVendedor.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoVendedor.setForeground(new java.awt.Color(255, 255, 255));

        botonCliente.setBackground(new java.awt.Color(123, 36, 28));
        botonCliente.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        botonCliente.setForeground(new java.awt.Color(255, 255, 255));
        botonCliente.setText("CLIENTES");
        botonCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonClienteActionPerformed(evt);
            }
        });

        botonVendedor.setBackground(new java.awt.Color(123, 36, 28));
        botonVendedor.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        botonVendedor.setForeground(new java.awt.Color(255, 255, 255));
        botonVendedor.setText("VENDEDORES");
        botonVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVendedorActionPerformed(evt);
            }
        });

        botonVolver.setBackground(new java.awt.Color(123, 36, 28));
        botonVolver.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        botonVolver.setForeground(new java.awt.Color(255, 255, 255));
        botonVolver.setText("VOLVER");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        botonItemsMenu.setBackground(new java.awt.Color(123, 36, 28));
        botonItemsMenu.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        botonItemsMenu.setForeground(new java.awt.Color(255, 255, 255));
        botonItemsMenu.setText("ITEMS MENÚ");
        botonItemsMenu.setEnabled(false);
        botonItemsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonItemsMenuActionPerformed(evt);
            }
        });

        botonPedidos.setBackground(new java.awt.Color(123, 36, 28));
        botonPedidos.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        botonPedidos.setForeground(new java.awt.Color(255, 255, 255));
        botonPedidos.setText("PEDIDOS");
        botonPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPedidosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(texto1, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(botonEditarItemsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonCrearItemsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(botonEliminarItemsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(349, 349, 349)
                                .addComponent(buscarItemsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(121, 121, 121)))
                .addContainerGap(7, Short.MAX_VALUE))
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTablaItemsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tit1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(campoNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tit2, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(campoDireccion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoPrecio)
                            .addComponent(tit3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboBoxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tit4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tit5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoVendedor)))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(botonVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonItemsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(tit1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tit2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tit3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tit4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tit5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(campoDireccion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(buscarItemsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollTablaItemsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEditarItemsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCrearItemsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminarItemsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        getContentPane().add(Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPedidosActionPerformed
        menuPedidos.setMenuItemsMenu(this);
        menuPedidos.setVisible(true);
        menuPedidos.setLocationRelativeTo(null);
        setVisible(false);
    }//GEN-LAST:event_botonPedidosActionPerformed

    private void botonItemsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonItemsMenuActionPerformed
        //
    }//GEN-LAST:event_botonItemsMenuActionPerformed

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        menuPrincipal.setVisible(true);
        menuPrincipal.setLocationRelativeTo(null);
        setVisible(false);
    }//GEN-LAST:event_botonVolverActionPerformed

    private void botonVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVendedorActionPerformed
        menuVendedor.setMenuItemsMenu(this);
        menuVendedor.setVisible(true);
        menuVendedor.setLocationRelativeTo(null);
        setVisible(false);
    }//GEN-LAST:event_botonVendedorActionPerformed

    private void botonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonClienteActionPerformed
        menuCliente.setMenuItemsMenu(this);
        menuCliente.setVisible(true);
        menuCliente.setLocationRelativeTo(null);
        setVisible(false);
    }//GEN-LAST:event_botonClienteActionPerformed

    private void campoPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPrecioActionPerformed

    private void botonCrearItemsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearItemsMenuActionPerformed
        VentanaDeCreacionEdicionItemsMenu nuevaVentana = new VentanaDeCreacionEdicionItemsMenu();
        nuevaVentana.setItemsMenu(this);
        nuevaVentana.setVisible(true);
        nuevaVentana.setLocationRelativeTo(null);
    }//GEN-LAST:event_botonCrearItemsMenuActionPerformed

    private void botonEliminarItemsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarItemsMenuActionPerformed
        int filaSeleccionada = tablaItemsMenu.getSelectedRow();
        if (filaSeleccionada != -1) {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este Item Menú?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                model.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(null, "Item Menú borrado con Éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Por favor selecciona una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botonEliminarItemsMenuActionPerformed

    private void botonEditarItemsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarItemsMenuActionPerformed
        int filaSeleccionada = tablaItemsMenu.getSelectedRow();
        if (filaSeleccionada != -1) {
            String nombre = (String) model.getValueAt(filaSeleccionada, 1);
            String descripcion = (String) model.getValueAt(filaSeleccionada, 2);
            String precio = (String) model.getValueAt(filaSeleccionada, 3);
            String categoria = (String) model.getValueAt(filaSeleccionada, 4);
            String vendedor = (String) model.getValueAt(filaSeleccionada, 5);
            VentanaDeCreacionEdicionItemsMenu nuevaVentana = new VentanaDeCreacionEdicionItemsMenu();
            nuevaVentana.setItemsMenu(this);
            nuevaVentana.setVisible(true);
            nuevaVentana.setLocationRelativeTo(null);
            nuevaVentana.recibirDatosEdicion(filaSeleccionada, nombre, descripcion, precio, categoria, vendedor);
            nuevaVentana.setTitulo();
        }
        else {
            JOptionPane.showMessageDialog(null, "Por favor selecciona una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botonEditarItemsMenuActionPerformed

    private void buscarItemsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarItemsMenuActionPerformed
        String nombreBuscado = campoNombre.getText().trim();
        String descripcionBuscado = campoDireccion.getText().trim();
        String precioBuscado = campoPrecio.getText().trim();
        String categoriaBuscado = comboBoxCategoria.toString();
        String vendedorBuscado = campoVendedor.getText().trim();
        model.setRowCount(0);
        boolean encontrado = false;
        if (nombreBuscado.isEmpty() && descripcionBuscado.isEmpty() && precioBuscado.isEmpty() && vendedorBuscado.isEmpty() && categoriaBuscado.isEmpty()) {
            System.out.println("LLegue el array pero no ejecute el for");
            for (Object[] itemMenuArr : itemsMenu) {
                model.addRow(itemMenuArr);
            }
            encontrado = true;
        }
        else {
            for (Object[] itemMenuArr : itemsMenu) {
                String nombre = ((String) itemMenuArr[1]).toLowerCase();
                String descripcion = ((String) itemMenuArr[2]).toLowerCase();
                String precio = ((String) itemMenuArr[3]).toLowerCase();
                String categoria = ((String) itemMenuArr[4]).toLowerCase();
                String vendedor = ((String) itemMenuArr[5]).toLowerCase();

                if (nombre.contains(nombreBuscado)) {
                    model.addRow(itemMenuArr);
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún Item Menú con esos parámetros.", "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_buscarItemsMenuActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new MenuItemsMenu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JButton botonCliente;
    private javax.swing.JButton botonCrearItemsMenu;
    private javax.swing.JButton botonEditarItemsMenu;
    private javax.swing.JButton botonEliminarItemsMenu;
    private javax.swing.JButton botonItemsMenu;
    private javax.swing.JButton botonPedidos;
    private javax.swing.JButton botonVendedor;
    private javax.swing.JButton botonVolver;
    private javax.swing.JButton buscarItemsMenu;
    private javax.swing.JTextField campoDireccion;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoPrecio;
    private javax.swing.JTextField campoVendedor;
    private javax.swing.JComboBox<String> comboBoxCategoria;
    private javax.swing.JScrollPane scrollTablaItemsMenu;
    private javax.swing.JTable tablaItemsMenu;
    private javax.swing.JLabel texto1;
    private javax.swing.JLabel tit1;
    private javax.swing.JLabel tit2;
    private javax.swing.JLabel tit3;
    private javax.swing.JLabel tit4;
    private javax.swing.JLabel tit5;
    // End of variables declaration//GEN-END:variables
}
