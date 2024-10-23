/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TP.DS.Pantallas;

import Tp.DS.Pantallas.VentanaDeCreacionEdicionVendedor;
import javax.swing.*;
import javax.swing.table.*;

public class MenuVendedor extends javax.swing.JFrame {
    private MenuPrincipal menuPrincipal;
    private MenuVendedor menuVendedor;
    private MenuCliente menuCliente;
    private MenuItemsMenu menuItemsMenu;
    private MenuPedidos menuPedidos;
    
    //prueba tabla
    private Object[][] vendedores;
    DefaultTableModel model;
    
    public void setListaTablaVendedores() {
        model = (DefaultTableModel) tablaVendedor.getModel();
        vendedores = new Object[][] {
            {1, "Restaurante AA", "Calle 123", "-34.6037, -58.3816"},
            {2, "Restaurante AB", "Calle 456", "-34.6158, -58.4333"},
            {3, "Restaurante AC", "Calle 789", "-34.6179, -58.3686"},
            {4, "Restaurante AD", "Calle 101", "-34.6059, -58.3831"},
            {5, "Restaurante BE", "Calle 202", "-34.6180, -58.4350"},
            {6, "Restaurante BF", "Calle 303", "-34.6201, -58.3701"},
            {7, "Restaurante BG", "Calle 404", "-34.6081, -58.3846"},
            {8, "Restaurante BH", "Calle 505", "-34.6202, -58.4367"},
            {9, "Restaurante CI", "Calle 606", "-34.6223, -58.3716"},
            {10, "Restaurante CJ", "Calle 707", "-34.6103, -58.3861"},
            {11, "Restaurante CK", "Calle 808", "-34.6224, -58.4384"},
            {12, "Restaurante CL", "Calle 909", "-34.6245, -58.3731"},
            {13, "Restaurante CM", "Calle 1010", "-34.6125, -58.3876"}
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
    public void recibirDatosDeCreacion(String nombre, String direccion, String latitud, String longitud, String itemsMenu) {
        String coordenada = latitud + ", " + longitud;
        Object[] vendedor = new Object[] {model.getRowCount() + 1, nombre, direccion, coordenada, itemsMenu};
        model.addRow(vendedor);
    }
    public void recibirDatosDeEdicion(int filaSeleccionada, String nombre, String direccion, String latitud, String longitud, String itemsMenu) {
        String coordenada = latitud + ", " + longitud;
        model.setValueAt(nombre, filaSeleccionada, 1);
        model.setValueAt(direccion, filaSeleccionada, 2);
        model.setValueAt(coordenada, filaSeleccionada, 3);
        model.setValueAt(itemsMenu, filaSeleccionada, 4);
    }
    
    public MenuVendedor() {
        initComponents();
        setListaTablaVendedores(); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        botonVendedor = new javax.swing.JButton();
        botonCliente = new javax.swing.JButton();
        botonPedidos = new javax.swing.JButton();
        botonItemsMenu = new javax.swing.JButton();
        texto1 = new javax.swing.JLabel();
        botonVolver = new javax.swing.JButton();
        botonBuscarVendedor = new javax.swing.JButton();
        botonEditarVendedor = new javax.swing.JButton();
        botonEliminarVendedor = new javax.swing.JButton();
        botonCrearVendedor = new javax.swing.JButton();
        campoNombreVendedor = new javax.swing.JTextField();
        texto2 = new javax.swing.JLabel();
        campoDireccionVendedor = new javax.swing.JTextField();
        texto3 = new javax.swing.JLabel();
        campoCoordenadaVendedor = new javax.swing.JTextField();
        texto4 = new javax.swing.JLabel();
        scrollTablaVendedores = new javax.swing.JScrollPane();
        tablaVendedor = new javax.swing.JTable();
        campoItemsMenu = new javax.swing.JTextField();
        texto5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel.setBackground(new java.awt.Color(69, 69, 69));
        Panel.setMaximumSize(new java.awt.Dimension(900, 600));
        Panel.setMinimumSize(new java.awt.Dimension(900, 600));
        Panel.setPreferredSize(new java.awt.Dimension(900, 600));

        botonVendedor.setBackground(new java.awt.Color(123, 36, 28));
        botonVendedor.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        botonVendedor.setForeground(new java.awt.Color(255, 255, 255));
        botonVendedor.setText("VENDEDORES");
        botonVendedor.setEnabled(false);
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

        botonBuscarVendedor.setBackground(new java.awt.Color(123, 36, 28));
        botonBuscarVendedor.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonBuscarVendedor.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscarVendedor.setText("BUSCAR VENDEDOR");
        botonBuscarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarVendedorActionPerformed(evt);
            }
        });

        botonEditarVendedor.setBackground(new java.awt.Color(123, 36, 28));
        botonEditarVendedor.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonEditarVendedor.setForeground(new java.awt.Color(255, 255, 255));
        botonEditarVendedor.setText("EDITAR VENDEDOR");
        botonEditarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarVendedorActionPerformed(evt);
            }
        });

        botonEliminarVendedor.setBackground(new java.awt.Color(123, 36, 28));
        botonEliminarVendedor.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonEliminarVendedor.setForeground(new java.awt.Color(255, 255, 255));
        botonEliminarVendedor.setText("ELIMINAR VENDEDOR");
        botonEliminarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarVendedorActionPerformed(evt);
            }
        });

        botonCrearVendedor.setBackground(new java.awt.Color(123, 36, 28));
        botonCrearVendedor.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonCrearVendedor.setForeground(new java.awt.Color(255, 255, 255));
        botonCrearVendedor.setText("CREAR VENDEDOR");
        botonCrearVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearVendedorActionPerformed(evt);
            }
        });

        campoNombreVendedor.setBackground(new java.awt.Color(123, 36, 28));
        campoNombreVendedor.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoNombreVendedor.setForeground(new java.awt.Color(255, 255, 255));

        texto2.setBackground(new java.awt.Color(123, 35, 27));
        texto2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        texto2.setForeground(new java.awt.Color(255, 255, 255));
        texto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        texto2.setText("Nombre");
        texto2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        texto2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        texto2.setInheritsPopupMenu(false);

        campoDireccionVendedor.setBackground(new java.awt.Color(123, 36, 28));
        campoDireccionVendedor.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoDireccionVendedor.setForeground(new java.awt.Color(255, 255, 255));

        texto3.setBackground(new java.awt.Color(123, 35, 27));
        texto3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        texto3.setForeground(new java.awt.Color(255, 255, 255));
        texto3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        texto3.setText("Dirección");
        texto3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        texto3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        texto3.setInheritsPopupMenu(false);

        campoCoordenadaVendedor.setBackground(new java.awt.Color(123, 36, 28));
        campoCoordenadaVendedor.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoCoordenadaVendedor.setForeground(new java.awt.Color(255, 255, 255));

        texto4.setBackground(new java.awt.Color(123, 35, 27));
        texto4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        texto4.setForeground(new java.awt.Color(255, 255, 255));
        texto4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        texto4.setText("Coordenada");
        texto4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        texto4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        texto4.setInheritsPopupMenu(false);

        tablaVendedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Nombre", "Dirección", "Coordenada", "Items Menú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaVendedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaVendedor.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tablaVendedor.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaVendedor.setShowGrid(true);
        scrollTablaVendedores.setViewportView(tablaVendedor);
        if (tablaVendedor.getColumnModel().getColumnCount() > 0) {
            tablaVendedor.getColumnModel().getColumn(0).setMinWidth(30);
            tablaVendedor.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablaVendedor.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        campoItemsMenu.setBackground(new java.awt.Color(123, 36, 28));
        campoItemsMenu.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoItemsMenu.setForeground(new java.awt.Color(255, 255, 255));

        texto5.setBackground(new java.awt.Color(123, 35, 27));
        texto5.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        texto5.setForeground(new java.awt.Color(255, 255, 255));
        texto5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        texto5.setText("Items Menú");
        texto5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        texto5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        texto5.setInheritsPopupMenu(false);

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelLayout.createSequentialGroup()
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoNombreVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(texto2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(texto3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoDireccionVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(texto4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoCoordenadaVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(texto5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoItemsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelLayout.createSequentialGroup()
                                .addComponent(botonVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonItemsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrollTablaVendedores, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(texto1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addGap(0, 162, Short.MAX_VALUE)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                        .addComponent(botonEditarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonCrearVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonEliminarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                        .addComponent(botonBuscarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(363, 363, 363))))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(texto1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonItemsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(texto2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texto3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texto4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoCoordenadaVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoDireccionVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNombreVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(texto5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoItemsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(botonBuscarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(scrollTablaVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEditarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCrearVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        campoNombreVendedor.getAccessibleContext().setAccessibleName("");

        getContentPane().add(Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearVendedorActionPerformed
        VentanaDeCreacionEdicionVendedor nuevaVentana = new VentanaDeCreacionEdicionVendedor();
        nuevaVentana.setMenuVendedor(this);
        nuevaVentana.setVisible(true);
        nuevaVentana.setLocationRelativeTo(null);
    }//GEN-LAST:event_botonCrearVendedorActionPerformed

    private void botonEliminarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarVendedorActionPerformed
        int filaSeleccionada = tablaVendedor.getSelectedRow();
        if (filaSeleccionada != -1) {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este Vendedor?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                model.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(null, "Vendedor borrado con Éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Por favor selecciona una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botonEliminarVendedorActionPerformed

    private void botonEditarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarVendedorActionPerformed
        int filaSeleccionada = tablaVendedor.getSelectedRow();
        if (filaSeleccionada != -1) {
            String nombre = (String) model.getValueAt(filaSeleccionada, 1);
            String direccion = (String) model.getValueAt(filaSeleccionada, 2);
            String coordenada = (String) model.getValueAt(filaSeleccionada, 3);
            String itemsMenu = (String) model.getValueAt(filaSeleccionada, 4);
            VentanaDeCreacionEdicionVendedor nuevaVentana = new VentanaDeCreacionEdicionVendedor();
            nuevaVentana.setMenuVendedor(this);
            nuevaVentana.setVisible(true);
            nuevaVentana.setLocationRelativeTo(null);
            nuevaVentana.recibirDatosEdicion(filaSeleccionada, nombre, direccion, coordenada, itemsMenu);
            nuevaVentana.setTitulo();
        }
        else {
            JOptionPane.showMessageDialog(null, "Por favor selecciona una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botonEditarVendedorActionPerformed

    private void botonBuscarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarVendedorActionPerformed
        String nombreBuscado = campoNombreVendedor.getText().trim();
        String direccionBuscada = campoDireccionVendedor.getText().trim();
        String coordenadaBuscada = campoCoordenadaVendedor.getText().trim();
        String itemsMenuBuscado = campoItemsMenu.getText().trim();
        model.setRowCount(0);
        boolean encontrado = false;
        if (nombreBuscado.isEmpty() && direccionBuscada.isEmpty() && coordenadaBuscada.isEmpty() && itemsMenuBuscado.isEmpty()) {
            for (Object[] vendedor : vendedores) {
                model.addRow(vendedor);
            }
            encontrado = true;
        }
        else {
            for (Object[] vendedor : vendedores) {
                String nombre = ((String) vendedor[1]).toLowerCase();
                String direccion = ((String) vendedor[2]).toLowerCase();
                String coordenada = ((String) vendedor[3]).toLowerCase();
                String itemsMenu = ((String) vendedor[4]).toLowerCase();
                
                if (nombre.contains(nombreBuscado) /*|| direccion.contains(direccionBuscada) || 
                        coordenada.contains(coordenadaBuscada) || itemMenu.contains(itemMenuBuscado)*/) {
                    model.addRow(vendedor);
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún vendedor con esos parámetros.", "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_botonBuscarVendedorActionPerformed

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        menuPrincipal.setVisible(true);
        menuPrincipal.setLocationRelativeTo(null);
        setVisible(false);
    }//GEN-LAST:event_botonVolverActionPerformed

    private void botonItemsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonItemsMenuActionPerformed
        menuItemsMenu.setMenuVendedor(this);
        menuItemsMenu.setVisible(true);
        menuItemsMenu.setLocationRelativeTo(null);
        setVisible(false);
    }//GEN-LAST:event_botonItemsMenuActionPerformed

    private void botonPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPedidosActionPerformed
        menuPedidos.setMenuVendedor(this);
        menuPedidos.setVisible(true);
        menuPedidos.setLocationRelativeTo(null);
        setVisible(false);
    }//GEN-LAST:event_botonPedidosActionPerformed

    private void botonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonClienteActionPerformed
        menuCliente.setMenuVendedor(this);
        menuCliente.setVisible(true);
        menuCliente.setLocationRelativeTo(null);
        setVisible(false);
    }//GEN-LAST:event_botonClienteActionPerformed

    private void botonVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonVendedorActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new MenuVendedor().setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JButton botonBuscarVendedor;
    private javax.swing.JButton botonCliente;
    private javax.swing.JButton botonCrearVendedor;
    private javax.swing.JButton botonEditarVendedor;
    private javax.swing.JButton botonEliminarVendedor;
    private javax.swing.JButton botonItemsMenu;
    private javax.swing.JButton botonPedidos;
    private javax.swing.JButton botonVendedor;
    private javax.swing.JButton botonVolver;
    private javax.swing.JTextField campoCoordenadaVendedor;
    private javax.swing.JTextField campoDireccionVendedor;
    private javax.swing.JTextField campoItemsMenu;
    private javax.swing.JTextField campoNombreVendedor;
    private javax.swing.JScrollPane scrollTablaVendedores;
    private javax.swing.JTable tablaVendedor;
    private javax.swing.JLabel texto1;
    private javax.swing.JLabel texto2;
    private javax.swing.JLabel texto3;
    private javax.swing.JLabel texto4;
    private javax.swing.JLabel texto5;
    // End of variables declaration//GEN-END:variables
}
