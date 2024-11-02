/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Tp.DS.Pantallas;

import TP.DS.Pantallas.MenuItemsMenu;
import Tp.DS.Controller.VendedorController;
import Tp.DS.DAO.DAOVendedor;
import Tp.DS.Memory.VendedorMemory;
import Tp.DS.Pantallas.VentanaDeCreacionEdicionVendedor;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

public class VentanaAsignarEliminarVendedorDeItemMenu extends javax.swing.JFrame {
    private VentanaDeCreacionEdicionItemsMenu ventana;
    private Object[][] vendedores;
    DefaultTableModel model;
    
    public void setPantallaAgregarDesagregarVendedor(VentanaDeCreacionEdicionItemsMenu ventana) {
        this.ventana = ventana;
    }
    
    /*private void cargarTablaVendedores() {
        model = (DefaultTableModel) tablaVendedoresAsociadas.getModel();
        model.setRowCount(0); // Limpiar tabla
        List<Vendedor> listaVendedores = vendedorController.mostrarListaVendedor();
        for (Vendedor vendedor : listaVendedores) {
            String coordenadas = vendedor.getCoordenadas().getLat() + "," + vendedor.getCoordenadas().getLng();
            model.addRow(new Object[]{vendedor.getId(), vendedor.getNombre(), vendedor.getDireccion(), coordenadas});
        }
    }*/
        
    public VentanaAsignarEliminarVendedorDeItemMenu(/*VendedorController vendedorController*/) {
        //this.vendedorController = vendedorController;
        initComponents();
        //cargarTablaVendedores();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        botonBuscarVendedor = new javax.swing.JButton();
        botonAsignarVendedor = new javax.swing.JButton();
        botonVolver = new javax.swing.JButton();
        botonDesasignarVendedor = new javax.swing.JButton();
        campoNombreVendedor = new javax.swing.JTextField();
        texto2 = new javax.swing.JLabel();
        campoDireccionVendedor = new javax.swing.JTextField();
        texto3 = new javax.swing.JLabel();
        campoCoordenadaVendedor = new javax.swing.JTextField();
        texto4 = new javax.swing.JLabel();
        scrollTablaVendedoresAsociada = new javax.swing.JScrollPane();
        tablaVendedoresAsociadas = new javax.swing.JTable();
        scrollTablaVendedores = new javax.swing.JScrollPane();
        tablaVendedor = new javax.swing.JTable();
        texto5 = new javax.swing.JLabel();
        texto6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel.setBackground(new java.awt.Color(69, 69, 69));
        Panel.setMaximumSize(new java.awt.Dimension(900, 400));
        Panel.setMinimumSize(new java.awt.Dimension(900, 400));
        Panel.setPreferredSize(new java.awt.Dimension(900, 400));

        botonBuscarVendedor.setBackground(new java.awt.Color(123, 36, 28));
        botonBuscarVendedor.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonBuscarVendedor.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscarVendedor.setText("BUSCAR VENDEDOR");
        botonBuscarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarVendedorActionPerformed(evt);
            }
        });

        botonAsignarVendedor.setBackground(new java.awt.Color(123, 36, 28));
        botonAsignarVendedor.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonAsignarVendedor.setForeground(new java.awt.Color(255, 255, 255));
        botonAsignarVendedor.setText("ASIGNAR VENDEDOR");
        botonAsignarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAsignarVendedorActionPerformed(evt);
            }
        });

        botonVolver.setBackground(new java.awt.Color(123, 36, 28));
        botonVolver.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonVolver.setForeground(new java.awt.Color(255, 255, 255));
        botonVolver.setText("VOLVER");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        botonDesasignarVendedor.setBackground(new java.awt.Color(123, 36, 28));
        botonDesasignarVendedor.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonDesasignarVendedor.setForeground(new java.awt.Color(255, 255, 255));
        botonDesasignarVendedor.setText("DESASIGNAR VENDEDOR");
        botonDesasignarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDesasignarVendedorActionPerformed(evt);
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

        tablaVendedoresAsociadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Dirección", "Coordenada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaVendedoresAsociadas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaVendedoresAsociadas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tablaVendedoresAsociadas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaVendedoresAsociadas.setShowGrid(true);
        scrollTablaVendedoresAsociada.setViewportView(tablaVendedoresAsociadas);
        if (tablaVendedoresAsociadas.getColumnModel().getColumnCount() > 0) {
            tablaVendedoresAsociadas.getColumnModel().getColumn(0).setMinWidth(30);
            tablaVendedoresAsociadas.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablaVendedoresAsociadas.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        tablaVendedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Dirección", "Coordenada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaVendedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaVendedor.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tablaVendedor.setShowGrid(true);
        scrollTablaVendedores.setViewportView(tablaVendedor);
        if (tablaVendedor.getColumnModel().getColumnCount() > 0) {
            tablaVendedor.getColumnModel().getColumn(0).setMinWidth(30);
            tablaVendedor.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablaVendedor.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        texto5.setBackground(new java.awt.Color(123, 35, 27));
        texto5.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        texto5.setForeground(new java.awt.Color(255, 255, 255));
        texto5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        texto5.setText("Lista de Vendedores Asosciadas al Item Menú");
        texto5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 204)));
        texto5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        texto5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        texto5.setInheritsPopupMenu(false);

        texto6.setBackground(new java.awt.Color(123, 35, 27));
        texto6.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        texto6.setForeground(new java.awt.Color(255, 255, 255));
        texto6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        texto6.setText("Lista de Vendedores");
        texto6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 204)));
        texto6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        texto6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        texto6.setInheritsPopupMenu(false);

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(botonDesasignarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(botonAsignarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoNombreVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(texto2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoDireccionVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(texto3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(scrollTablaVendedoresAsociada, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(texto4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoCoordenadaVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonBuscarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(scrollTablaVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(texto5, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(texto6, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(texto2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texto3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoDireccionVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNombreVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(texto4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCoordenadaVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonBuscarVendedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTablaVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollTablaVendedoresAsociada, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonAsignarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonDesasignarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(42, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );

        campoNombreVendedor.getAccessibleContext().setAccessibleName("");

        getContentPane().add(Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonDesasignarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDesasignarVendedorActionPerformed
        //todo
    }//GEN-LAST:event_botonDesasignarVendedorActionPerformed

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        dispose();
    }//GEN-LAST:event_botonVolverActionPerformed

    private void botonAsignarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAsignarVendedorActionPerformed
        //todo
    }//GEN-LAST:event_botonAsignarVendedorActionPerformed

    private void botonBuscarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarVendedorActionPerformed
        /*String nombreBuscado = campoNombreVendedor.getText().trim();
        String direccionBuscada = campoDireccionVendedor.getText().trim();
        String coordenadaBuscada = campoCoordenadaVendedor.getText().trim();
        model.setRowCount(0); //limpiar tabla*/
//        boolean encontrado = false;
//        if (nombreBuscado.isEmpty() && direccionBuscada.isEmpty() && coordenadaBuscada.isEmpty() && itemsMenuBuscado.isEmpty()) {
//            for (Object[] vendedor : vendedores) {
//                model.addRow(vendedor);
//            }
//            encontrado = true;
//        }
//        else {
//            for (Object[] vendedor : vendedores) {
//                String nombre = ((String) vendedor[1]).toLowerCase();
//                String direccion = ((String) vendedor[2]).toLowerCase();
//                String coordenada = ((String) vendedor[3]).toLowerCase();
//                String itemsMenu = ((String) vendedor[4]).toLowerCase();
//                
//                if (nombre.contains(nombreBuscado) /*|| direccion.contains(direccionBuscada) || 
//                        coordenada.contains(coordenadaBuscada) || itemMenu.contains(itemMenuBuscado)*/) {
//                    model.addRow(vendedor);
//                    encontrado = true;
//                }
//            }
//        }
        /*List<Vendedor> vendedores = vendedorController.mostrarListaVendedor();
        boolean coincide = false;
        for (Vendedor vendedor : vendedores) {
            if ((nombreBuscado.isEmpty() || vendedor.getNombre().toLowerCase().contains(nombreBuscado))
                    && (direccionBuscada.isEmpty() || vendedor.getDireccion().toLowerCase().contains(direccionBuscada))
                    && (coordenadaBuscada.isEmpty() || vendedor.getCoordenadas().toString().toLowerCase().contains(coordenadaBuscada))) {
                coincide = true;
                String coordenadas = vendedor.getCoordenadas().getLat() + ", " + vendedor.getCoordenadas().getLng();
                model.addRow(new Object[]{vendedor.getId(), vendedor.getNombre(), vendedor.getDireccion(), coordenadas});
            }
        }
        if (!coincide) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún vendedor con esos parámetros.", "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
        }*/
    }//GEN-LAST:event_botonBuscarVendedorActionPerformed

    public static void main(String args[]) {
        DAOVendedor vendedorDAO = new VendedorMemory();
        VendedorController vendedorController = new VendedorController(vendedorDAO);
        java.awt.EventQueue.invokeLater(() -> {
            new VentanaAsignarEliminarVendedorDeItemMenu(/*vendedorController*/).setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JButton botonAsignarVendedor;
    private javax.swing.JButton botonBuscarVendedor;
    private javax.swing.JButton botonDesasignarVendedor;
    private javax.swing.JButton botonVolver;
    private javax.swing.JTextField campoCoordenadaVendedor;
    private javax.swing.JTextField campoDireccionVendedor;
    private javax.swing.JTextField campoNombreVendedor;
    private javax.swing.JScrollPane scrollTablaVendedores;
    private javax.swing.JScrollPane scrollTablaVendedoresAsociada;
    private javax.swing.JTable tablaVendedor;
    private javax.swing.JTable tablaVendedoresAsociadas;
    private javax.swing.JLabel texto2;
    private javax.swing.JLabel texto3;
    private javax.swing.JLabel texto4;
    private javax.swing.JLabel texto5;
    private javax.swing.JLabel texto6;
    // End of variables declaration//GEN-END:variables

}
