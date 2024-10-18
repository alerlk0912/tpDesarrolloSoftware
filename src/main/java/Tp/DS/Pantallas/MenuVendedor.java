/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TP.DS.Pantallas;

import javax.swing.JOptionPane;
import javax.swing.table.*;

public class MenuVendedor extends javax.swing.JFrame {
    private MenuPrincipal menuPrincipal;
    private MenuVendedor menuVendedor;
    private MenuCliente menuCliente;
    private MenuItemsMenu menuItemsMenu;
    private MenuPedidos menuPedidos;
    private Object[][] vendedores;
    private DefaultTableModel model;
    
    public void setListaTablaVendedores() {
        model = (DefaultTableModel) tablaVendedor.getModel();
        vendedores = new Object[][] {
            {1, "Restaurante AA", "Calle 123", "-34.6037, -58.3816", "Items Menú A"},
            {2, "Restaurante AB", "Calle 456", "-34.6158, -58.4333", "Items Menú B"},
            {3, "Restaurante AC", "Calle 789", "-34.6179, -58.3686", "Items Menú C"},
            {4, "Restaurante AD", "Calle 101", "-34.6059, -58.3831", "Items Menú D"},
            {5, "Restaurante BE", "Calle 202", "-34.6180, -58.4350", "Items Menú E"},
            {6, "Restaurante BF", "Calle 303", "-34.6201, -58.3701", "Items Menú F"},
            {7, "Restaurante BG", "Calle 404", "-34.6081, -58.3846", "Items Menú G"},
            {8, "Restaurante BH", "Calle 505", "-34.6202, -58.4367", "Items Menú H"},
            {9, "Restaurante CI", "Calle 606", "-34.6223, -58.3716", "Items Menú I"},
            {10, "Restaurante CJ", "Calle 707", "-34.6103, -58.3861", "Items Menú J"},
            {11, "Restaurante CK", "Calle 808", "-34.6224, -58.4384", "Items Menú K"},
            {12, "Restaurante CL", "Calle 909", "-34.6245, -58.3731", "Items Menú L"},
            {13, "Restaurante CM", "Calle 1010", "-34.6125, -58.3876", "Items Menú M"}
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
        campoItemsMenuVendedor = new javax.swing.JTextField();
        texto5 = new javax.swing.JLabel();
        scrollTablaVendedores = new javax.swing.JScrollPane();
        tablaVendedor = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(900, 600));
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

        campoItemsMenuVendedor.setBackground(new java.awt.Color(123, 36, 28));
        campoItemsMenuVendedor.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoItemsMenuVendedor.setForeground(new java.awt.Color(255, 255, 255));

        texto5.setBackground(new java.awt.Color(123, 35, 27));
        texto5.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        texto5.setForeground(new java.awt.Color(255, 255, 255));
        texto5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        texto5.setText("Items Menú");
        texto5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        texto5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        texto5.setInheritsPopupMenu(false);

        tablaVendedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Nombre", "Dirección", "Coordenada", "Items Menú"
            }
        ));
        tablaVendedor.setEditingColumn(1);
        tablaVendedor.setEditingRow(1);
        tablaVendedor.setShowGrid(true);
        scrollTablaVendedores.setViewportView(tablaVendedor);
        if (tablaVendedor.getColumnModel().getColumnCount() > 0) {
            tablaVendedor.getColumnModel().getColumn(0).setMinWidth(30);
            tablaVendedor.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablaVendedor.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(PanelLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(campoNombreVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(texto2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(campoDireccionVendedor)
                                .addComponent(texto3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(campoCoordenadaVendedor)
                                .addComponent(texto4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(campoItemsMenuVendedor)
                                .addComponent(texto5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(PanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(botonVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(botonItemsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botonPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(botonBuscarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollTablaVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, 872, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(texto1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botonEditarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonCrearVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonEliminarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
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
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoCoordenadaVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDireccionVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNombreVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoItemsMenuVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonBuscarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollTablaVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEditarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCrearVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );

        campoNombreVendedor.getAccessibleContext().setAccessibleName("");

        getContentPane().add(Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCrearVendedorActionPerformed

    private void botonEliminarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEliminarVendedorActionPerformed

    private void botonEditarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEditarVendedorActionPerformed

    private void botonBuscarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarVendedorActionPerformed
        String nombreBuscado = campoNombreVendedor.getText().trim();
        String direccionBuscada = campoDireccionVendedor.getText().trim();
        String coordenadaBuscada = campoCoordenadaVendedor.getText().trim();
        String itemMenuBuscado = campoItemsMenuVendedor.getText().trim();
        model.setRowCount(0);
        boolean encontrado = false;
        if (nombreBuscado.isEmpty() && direccionBuscada.isEmpty() && coordenadaBuscada.isEmpty() && itemMenuBuscado.isEmpty()) {
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
                String itemMenu = ((String) vendedor[4]).toLowerCase();

                
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuVendedor().setVisible(true);
            }
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
    private javax.swing.JTextField campoItemsMenuVendedor;
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
