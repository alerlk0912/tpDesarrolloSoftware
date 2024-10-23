/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Tp.DS.Pantallas;

import TP.DS.Pantallas.MenuPedidos;
import javax.swing.JOptionPane;

public class VentanaDeCreacionEdicionPedido extends javax.swing.JFrame {
    private MenuPedidos menuPedido;
    private int filaSeleccionada=100;
    
    public void setMenuPedido(MenuPedidos menuPedido) {
        this.menuPedido = menuPedido;
    }
    public void setTitulo() {
        tituloPrincipal.setText("Editar Pedido");
    }
    public void recibirDatosEdicion(int filaSeleccionada, String cliente, String itemsPedido, String metodoDePago, String estadoPedido, 
            String montoBase, String fechaDePago, String montoTotal) {
        this.filaSeleccionada = filaSeleccionada;
        campoCliente.setText(cliente);
        campoItemsPedido.setText(itemsPedido);
        comboBoxMetodoDePago.setSelectedItem(metodoDePago);
        comboBoxEstadoPedido.setSelectedItem(estadoPedido);
        campoMontoBase.setText(montoBase);
        campoFechaDePago.setText(fechaDePago.trim());
        campoMontoTotal.setText(montoTotal.trim());
    }
    
    public VentanaDeCreacionEdicionPedido() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEditable = new javax.swing.JPanel();
        botonCancelar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        campoMontoBase = new javax.swing.JTextField();
        titMontoBase = new javax.swing.JLabel();
        titMetodoDePago = new javax.swing.JLabel();
        campoCliente = new javax.swing.JTextField();
        tituloPrincipal = new javax.swing.JLabel();
        titCliente = new javax.swing.JLabel();
        titFechaDePago = new javax.swing.JLabel();
        campoFechaDePago = new javax.swing.JTextField();
        titItemsPedido = new javax.swing.JLabel();
        campoItemsPedido = new javax.swing.JTextField();
        titEstadoPedido = new javax.swing.JLabel();
        titMontoTotal = new javax.swing.JLabel();
        campoMontoTotal = new javax.swing.JTextField();
        comboBoxEstadoPedido = new javax.swing.JComboBox<>();
        comboBoxMetodoDePago = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 400));
        setMinimumSize(new java.awt.Dimension(400, 400));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelEditable.setBackground(new java.awt.Color(69, 69, 69));
        panelEditable.setAlignmentX(0.0F);
        panelEditable.setAlignmentY(0.0F);
        panelEditable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelEditable.setMaximumSize(new java.awt.Dimension(400, 400));
        panelEditable.setMinimumSize(new java.awt.Dimension(400, 400));
        panelEditable.setPreferredSize(new java.awt.Dimension(400, 400));

        botonCancelar.setBackground(new java.awt.Color(123, 36, 28));
        botonCancelar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        botonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        botonCancelar.setText("CANCELAR");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonAceptar.setBackground(new java.awt.Color(123, 36, 28));
        botonAceptar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        botonAceptar.setForeground(new java.awt.Color(255, 255, 255));
        botonAceptar.setText("ACEPTAR");
        botonAceptar.setAlignmentY(0.0F);
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        campoMontoBase.setBackground(new java.awt.Color(123, 36, 28));
        campoMontoBase.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoMontoBase.setForeground(new java.awt.Color(255, 255, 255));

        titMontoBase.setBackground(new java.awt.Color(123, 35, 27));
        titMontoBase.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        titMontoBase.setForeground(new java.awt.Color(255, 255, 255));
        titMontoBase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titMontoBase.setText("Monto Base");
        titMontoBase.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        titMontoBase.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titMontoBase.setInheritsPopupMenu(false);

        titMetodoDePago.setBackground(new java.awt.Color(123, 35, 27));
        titMetodoDePago.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        titMetodoDePago.setForeground(new java.awt.Color(255, 255, 255));
        titMetodoDePago.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titMetodoDePago.setText("Método de Pago");
        titMetodoDePago.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        titMetodoDePago.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titMetodoDePago.setInheritsPopupMenu(false);

        campoCliente.setBackground(new java.awt.Color(123, 36, 28));
        campoCliente.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoCliente.setForeground(new java.awt.Color(255, 255, 255));

        tituloPrincipal.setBackground(new java.awt.Color(123, 35, 27));
        tituloPrincipal.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tituloPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        tituloPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloPrincipal.setText("Crear Pedido");
        tituloPrincipal.setAlignmentY(0.0F);
        tituloPrincipal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 255)));
        tituloPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tituloPrincipal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tituloPrincipal.setInheritsPopupMenu(false);
        tituloPrincipal.setMaximumSize(new java.awt.Dimension(200, 25));
        tituloPrincipal.setMinimumSize(new java.awt.Dimension(200, 25));
        tituloPrincipal.setPreferredSize(new java.awt.Dimension(200, 25));

        titCliente.setBackground(new java.awt.Color(123, 35, 27));
        titCliente.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        titCliente.setForeground(new java.awt.Color(255, 255, 255));
        titCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titCliente.setText("Cliente");
        titCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        titCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titCliente.setInheritsPopupMenu(false);

        titFechaDePago.setBackground(new java.awt.Color(123, 35, 27));
        titFechaDePago.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        titFechaDePago.setForeground(new java.awt.Color(255, 255, 255));
        titFechaDePago.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titFechaDePago.setText("Fecha de Pago");
        titFechaDePago.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        titFechaDePago.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titFechaDePago.setInheritsPopupMenu(false);

        campoFechaDePago.setBackground(new java.awt.Color(123, 36, 28));
        campoFechaDePago.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoFechaDePago.setForeground(new java.awt.Color(255, 255, 255));

        titItemsPedido.setBackground(new java.awt.Color(123, 35, 27));
        titItemsPedido.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        titItemsPedido.setForeground(new java.awt.Color(255, 255, 255));
        titItemsPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titItemsPedido.setText("Items Pedido");
        titItemsPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        titItemsPedido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titItemsPedido.setInheritsPopupMenu(false);

        campoItemsPedido.setBackground(new java.awt.Color(123, 36, 28));
        campoItemsPedido.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoItemsPedido.setForeground(new java.awt.Color(255, 255, 255));

        titEstadoPedido.setBackground(new java.awt.Color(123, 35, 27));
        titEstadoPedido.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        titEstadoPedido.setForeground(new java.awt.Color(255, 255, 255));
        titEstadoPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titEstadoPedido.setText("Estado Pedido");
        titEstadoPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        titEstadoPedido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titEstadoPedido.setInheritsPopupMenu(false);

        titMontoTotal.setBackground(new java.awt.Color(123, 35, 27));
        titMontoTotal.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        titMontoTotal.setForeground(new java.awt.Color(255, 255, 255));
        titMontoTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titMontoTotal.setText("Monto Total");
        titMontoTotal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        titMontoTotal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titMontoTotal.setInheritsPopupMenu(false);

        campoMontoTotal.setBackground(new java.awt.Color(123, 36, 28));
        campoMontoTotal.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoMontoTotal.setForeground(new java.awt.Color(255, 255, 255));

        comboBoxEstadoPedido.setBackground(new java.awt.Color(123, 36, 28));
        comboBoxEstadoPedido.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        comboBoxEstadoPedido.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxEstadoPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RECIBIDO", "EN PREPARACIÓN", "EN ENVIO", "ENTREGADO" }));

        comboBoxMetodoDePago.setBackground(new java.awt.Color(123, 36, 28));
        comboBoxMetodoDePago.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        comboBoxMetodoDePago.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxMetodoDePago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EFECTIVO", "MERCADO PAGO" }));

        javax.swing.GroupLayout panelEditableLayout = new javax.swing.GroupLayout(panelEditable);
        panelEditable.setLayout(panelEditableLayout);
        panelEditableLayout.setHorizontalGroup(
            panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditableLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditableLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelEditableLayout.createSequentialGroup()
                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelEditableLayout.createSequentialGroup()
                                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoCliente)
                                    .addComponent(titCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoItemsPedido)
                                    .addComponent(titItemsPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditableLayout.createSequentialGroup()
                                .addComponent(titMontoBase, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(titFechaDePago, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditableLayout.createSequentialGroup()
                                .addComponent(campoMontoBase)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoFechaDePago, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditableLayout.createSequentialGroup()
                                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(titMetodoDePago, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(comboBoxMetodoDePago, 0, 1, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(titEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboBoxEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelEditableLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(titMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tituloPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 19, Short.MAX_VALUE))))
        );
        panelEditableLayout.setVerticalGroup(
            panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(titCliente)
                        .addComponent(titItemsPedido))
                    .addGroup(panelEditableLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoItemsPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titMetodoDePago)
                    .addComponent(titEstadoPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxMetodoDePago, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titMontoBase)
                    .addComponent(titFechaDePago))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoMontoBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoFechaDePago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titMontoTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        getContentPane().add(panelEditable, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        String regex = "^\\d{2}/\\d{2}/\\d{4}$";
        String regex1 = "^\\d*(\\.\\d+)?$";
        if (campoMontoBase.getText().matches(regex1) && campoMontoTotal.getText().matches(regex1) && campoFechaDePago.getText().matches(regex)
                && !campoCliente.getText().isEmpty() && !campoItemsPedido.getText().isEmpty() && !campoMontoBase.getText().isEmpty() 
                && !campoFechaDePago.getText().isEmpty() && !campoMontoTotal.getText().isEmpty()) {
            if(filaSeleccionada==100) {
                menuPedido.recibirDatosDeCreacion(campoCliente.getText(), campoItemsPedido.getText(), 
                        (String) comboBoxMetodoDePago.getSelectedItem(), (String) comboBoxEstadoPedido.getSelectedItem(),
                        campoMontoBase.getText(), campoFechaDePago.getText(), campoMontoTotal.getText());
                JOptionPane.showMessageDialog(null, "Creado con Éxito", null, JOptionPane.INFORMATION_MESSAGE);
            } else {
                menuPedido.recibirDatosDeEdicion(filaSeleccionada, campoCliente.getText(), campoItemsPedido.getText(), 
                        (String) comboBoxMetodoDePago.getSelectedItem(), (String) comboBoxEstadoPedido.getSelectedItem(),
                        campoMontoBase.getText(), campoFechaDePago.getText(), campoMontoTotal.getText());
                JOptionPane.showMessageDialog(null, "Editado con Éxito", null, JOptionPane.INFORMATION_MESSAGE);
            }
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Formato Inválido", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } 
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new VentanaDeCreacionEdicionPedido().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JTextField campoCliente;
    private javax.swing.JTextField campoFechaDePago;
    private javax.swing.JTextField campoItemsPedido;
    private javax.swing.JTextField campoMontoBase;
    private javax.swing.JTextField campoMontoTotal;
    private javax.swing.JComboBox<String> comboBoxEstadoPedido;
    private javax.swing.JComboBox<String> comboBoxMetodoDePago;
    private javax.swing.JPanel panelEditable;
    private javax.swing.JLabel titCliente;
    private javax.swing.JLabel titEstadoPedido;
    private javax.swing.JLabel titFechaDePago;
    private javax.swing.JLabel titItemsPedido;
    private javax.swing.JLabel titMetodoDePago;
    private javax.swing.JLabel titMontoBase;
    private javax.swing.JLabel titMontoTotal;
    private javax.swing.JLabel tituloPrincipal;
    // End of variables declaration//GEN-END:variables
}
