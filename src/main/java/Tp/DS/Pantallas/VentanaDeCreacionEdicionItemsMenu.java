/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Tp.DS.Pantallas;

import TP.DS.Pantallas.MenuItemsMenu;
import javax.swing.JOptionPane;

public class VentanaDeCreacionEdicionItemsMenu extends javax.swing.JFrame {
    private MenuItemsMenu menuItemsMenu;
    private int filaSeleccionada=100;
    
    public void setItemsMenu(MenuItemsMenu menuItemsMenu) {
        this.menuItemsMenu = menuItemsMenu;
    }
    public void setTitulo() {
        tituloPrincipal.setText("Editar Items Menú");
    }
    public void recibirDatosEdicion(int filaSeleccionada, String nombre, String descripcion, String precio, String categoria, String vendedor) {
        this.filaSeleccionada = filaSeleccionada;
        campoNombre.setText(nombre);
        campoDescripcion.setText(descripcion);
        campoPrecio.setText(precio.trim());
        comboBoxCategoria.setSelectedItem(categoria);     
        campoVendedor.setText(vendedor.trim());
    }
    
    public VentanaDeCreacionEdicionItemsMenu() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEditable = new javax.swing.JPanel();
        botonCancelar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        tit3 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        tituloPrincipal = new javax.swing.JLabel();
        tit1 = new javax.swing.JLabel();
        titFechaDePago = new javax.swing.JLabel();
        campoPrecio = new javax.swing.JTextField();
        tit2 = new javax.swing.JLabel();
        campoDescripcion = new javax.swing.JTextField();
        tit5 = new javax.swing.JLabel();
        campoVendedor = new javax.swing.JTextField();
        comboBoxCategoria = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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

        tit3.setBackground(new java.awt.Color(123, 35, 27));
        tit3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tit3.setForeground(new java.awt.Color(255, 255, 255));
        tit3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit3.setText("Categoría");
        tit3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tit3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit3.setInheritsPopupMenu(false);

        campoNombre.setBackground(new java.awt.Color(123, 36, 28));
        campoNombre.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoNombre.setForeground(new java.awt.Color(255, 255, 255));

        tituloPrincipal.setBackground(new java.awt.Color(123, 35, 27));
        tituloPrincipal.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tituloPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        tituloPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloPrincipal.setText("Crear Items Menú");
        tituloPrincipal.setAlignmentY(0.0F);
        tituloPrincipal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 255)));
        tituloPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tituloPrincipal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tituloPrincipal.setInheritsPopupMenu(false);
        tituloPrincipal.setMaximumSize(new java.awt.Dimension(200, 25));
        tituloPrincipal.setMinimumSize(new java.awt.Dimension(200, 25));
        tituloPrincipal.setPreferredSize(new java.awt.Dimension(200, 25));

        tit1.setBackground(new java.awt.Color(123, 35, 27));
        tit1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tit1.setForeground(new java.awt.Color(255, 255, 255));
        tit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit1.setText("Nombre");
        tit1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tit1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit1.setInheritsPopupMenu(false);

        titFechaDePago.setBackground(new java.awt.Color(123, 35, 27));
        titFechaDePago.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        titFechaDePago.setForeground(new java.awt.Color(255, 255, 255));
        titFechaDePago.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titFechaDePago.setText("Precio");
        titFechaDePago.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        titFechaDePago.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titFechaDePago.setInheritsPopupMenu(false);

        campoPrecio.setBackground(new java.awt.Color(123, 36, 28));
        campoPrecio.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoPrecio.setForeground(new java.awt.Color(255, 255, 255));

        tit2.setBackground(new java.awt.Color(123, 35, 27));
        tit2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tit2.setForeground(new java.awt.Color(255, 255, 255));
        tit2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit2.setText("Descripción");
        tit2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tit2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit2.setInheritsPopupMenu(false);

        campoDescripcion.setBackground(new java.awt.Color(123, 36, 28));
        campoDescripcion.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoDescripcion.setForeground(new java.awt.Color(255, 255, 255));

        tit5.setBackground(new java.awt.Color(123, 35, 27));
        tit5.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tit5.setForeground(new java.awt.Color(255, 255, 255));
        tit5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit5.setText("Vendedor");
        tit5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tit5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit5.setInheritsPopupMenu(false);

        campoVendedor.setBackground(new java.awt.Color(123, 36, 28));
        campoVendedor.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoVendedor.setForeground(new java.awt.Color(255, 255, 255));

        comboBoxCategoria.setBackground(new java.awt.Color(123, 36, 28));
        comboBoxCategoria.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        comboBoxCategoria.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PLATO", "BEBIDA" }));

        javax.swing.GroupLayout panelEditableLayout = new javax.swing.GroupLayout(panelEditable);
        panelEditable.setLayout(panelEditableLayout);
        panelEditableLayout.setHorizontalGroup(
            panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditableLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelEditableLayout.createSequentialGroup()
                            .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tit3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboBoxCategoria, 0, 170, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(campoPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                .addComponent(titFechaDePago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditableLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tit5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(campoVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(81, 81, 81)))
                    .addGroup(panelEditableLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEditableLayout.createSequentialGroup()
                            .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tit1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                .addComponent(campoNombre))
                            .addGap(18, 18, 18)
                            .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campoDescripcion)
                                .addComponent(tit2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(tituloPrincipal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelEditableLayout.setVerticalGroup(
            panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tit1)
                        .addComponent(tit2))
                    .addGroup(panelEditableLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditableLayout.createSequentialGroup()
                        .addComponent(tit3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEditableLayout.createSequentialGroup()
                        .addComponent(titFechaDePago)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(tit5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(panelEditable, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        String regex = "^\\d*(\\.\\d+)?$";
        if (campoPrecio.getText().matches(regex) && !campoNombre.getText().isEmpty() && !campoDescripcion.getText().isEmpty() 
                && !campoPrecio.getText().isEmpty() && !campoVendedor.getText().isEmpty()) {
            if(filaSeleccionada==100) {
                menuItemsMenu.recibirDatosDeCreacion(campoNombre.getText(), campoDescripcion.getText(), campoPrecio.getText(),
                        (String) comboBoxCategoria.getSelectedItem(), campoVendedor.getText());
                JOptionPane.showMessageDialog(null, "Creado con Éxito", null, JOptionPane.INFORMATION_MESSAGE);
            } else {
                menuItemsMenu.recibirDatosDeEdicion(filaSeleccionada, campoNombre.getText(), campoDescripcion.getText(), 
                        campoPrecio.getText(), (String) comboBoxCategoria.getSelectedItem(), campoVendedor.getText());
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
            new VentanaDeCreacionEdicionItemsMenu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JTextField campoDescripcion;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoPrecio;
    private javax.swing.JTextField campoVendedor;
    private javax.swing.JComboBox<String> comboBoxCategoria;
    private javax.swing.JPanel panelEditable;
    private javax.swing.JLabel tit1;
    private javax.swing.JLabel tit2;
    private javax.swing.JLabel tit3;
    private javax.swing.JLabel tit5;
    private javax.swing.JLabel titFechaDePago;
    private javax.swing.JLabel tituloPrincipal;
    // End of variables declaration//GEN-END:variables
}
