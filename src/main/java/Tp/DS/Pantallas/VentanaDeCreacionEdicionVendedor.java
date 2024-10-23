/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Tp.DS.Pantallas;

import TP.DS.Pantallas.MenuVendedor;
import javax.swing.JOptionPane;

public class VentanaDeCreacionEdicionVendedor extends javax.swing.JFrame {
    private MenuVendedor menuVendedor;
    private int filaSeleccionada=100;
    
    public void setMenuVendedor(MenuVendedor menuVendedor) {
        this.menuVendedor = menuVendedor;
    }
    public void setTitulo() {
        tituloPrincipal.setText("Editar Vendedor");
    }
    public void recibirDatosEdicion(int filaSeleccionada, String nombre, String direccion, String coordenada, String itemsMenu) {
        this.filaSeleccionada = filaSeleccionada;
        campoNombre.setText(nombre);
        campoDireccion.setText(direccion);
        String[] partes = coordenada.split(",");
        String latitud = partes[0];
        String longitud = partes[1];
        campoLatitud.setText(latitud.trim());
        campoLongitud.setText(longitud.trim());
        campoItemsMenu.setText(itemsMenu.trim());
    }
    
    public VentanaDeCreacionEdicionVendedor() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEditable = new javax.swing.JPanel();
        botonCancelar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        campoLatitud = new javax.swing.JTextField();
        titLatitud = new javax.swing.JLabel();
        campoDireccion = new javax.swing.JTextField();
        titDireccion = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        tituloPrincipal = new javax.swing.JLabel();
        titNombre = new javax.swing.JLabel();
        titLongitud = new javax.swing.JLabel();
        campoLongitud = new javax.swing.JTextField();
        campoItemsMenu = new javax.swing.JTextField();
        titNombre1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(500, 500));
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

        campoLatitud.setBackground(new java.awt.Color(123, 36, 28));
        campoLatitud.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoLatitud.setForeground(new java.awt.Color(255, 255, 255));

        titLatitud.setBackground(new java.awt.Color(123, 35, 27));
        titLatitud.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        titLatitud.setForeground(new java.awt.Color(255, 255, 255));
        titLatitud.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titLatitud.setText("Latitud");
        titLatitud.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        titLatitud.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titLatitud.setInheritsPopupMenu(false);

        campoDireccion.setBackground(new java.awt.Color(123, 36, 28));
        campoDireccion.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoDireccion.setForeground(new java.awt.Color(255, 255, 255));

        titDireccion.setBackground(new java.awt.Color(123, 35, 27));
        titDireccion.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        titDireccion.setForeground(new java.awt.Color(255, 255, 255));
        titDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titDireccion.setText("Dirección");
        titDireccion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        titDireccion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titDireccion.setInheritsPopupMenu(false);

        campoNombre.setBackground(new java.awt.Color(123, 36, 28));
        campoNombre.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoNombre.setForeground(new java.awt.Color(255, 255, 255));

        tituloPrincipal.setBackground(new java.awt.Color(123, 35, 27));
        tituloPrincipal.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tituloPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        tituloPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloPrincipal.setText("Crear Vendedor");
        tituloPrincipal.setAlignmentY(0.0F);
        tituloPrincipal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 255)));
        tituloPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tituloPrincipal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tituloPrincipal.setInheritsPopupMenu(false);
        tituloPrincipal.setMaximumSize(new java.awt.Dimension(200, 25));
        tituloPrincipal.setMinimumSize(new java.awt.Dimension(200, 25));
        tituloPrincipal.setPreferredSize(new java.awt.Dimension(200, 25));

        titNombre.setBackground(new java.awt.Color(123, 35, 27));
        titNombre.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        titNombre.setForeground(new java.awt.Color(255, 255, 255));
        titNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titNombre.setText("Nombre");
        titNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        titNombre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titNombre.setInheritsPopupMenu(false);

        titLongitud.setBackground(new java.awt.Color(123, 35, 27));
        titLongitud.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        titLongitud.setForeground(new java.awt.Color(255, 255, 255));
        titLongitud.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titLongitud.setText("Longitud");
        titLongitud.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        titLongitud.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titLongitud.setInheritsPopupMenu(false);

        campoLongitud.setBackground(new java.awt.Color(123, 36, 28));
        campoLongitud.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoLongitud.setForeground(new java.awt.Color(255, 255, 255));

        campoItemsMenu.setBackground(new java.awt.Color(123, 36, 28));
        campoItemsMenu.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoItemsMenu.setForeground(new java.awt.Color(255, 255, 255));

        titNombre1.setBackground(new java.awt.Color(123, 35, 27));
        titNombre1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        titNombre1.setForeground(new java.awt.Color(255, 255, 255));
        titNombre1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titNombre1.setText("Items Menú");
        titNombre1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        titNombre1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titNombre1.setInheritsPopupMenu(false);

        javax.swing.GroupLayout panelEditableLayout = new javax.swing.GroupLayout(panelEditable);
        panelEditable.setLayout(panelEditableLayout);
        panelEditableLayout.setHorizontalGroup(
            panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditableLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditableLayout.createSequentialGroup()
                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonAceptar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75))
                    .addGroup(panelEditableLayout.createSequentialGroup()
                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelEditableLayout.createSequentialGroup()
                                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(titNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(titDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelEditableLayout.createSequentialGroup()
                                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(titLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(titLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditableLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditableLayout.createSequentialGroup()
                        .addComponent(tituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditableLayout.createSequentialGroup()
                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(titNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoItemsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100))))
        );
        panelEditableLayout.setVerticalGroup(
            panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelEditableLayout.createSequentialGroup()
                        .addComponent(titNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEditableLayout.createSequentialGroup()
                        .addComponent(titDireccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titLatitud)
                    .addComponent(titLongitud))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(titNombre1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoItemsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        getContentPane().add(panelEditable, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        String regex = "^[-+]?\\d*(\\.\\d+)?$";
        if (campoLatitud.getText().matches(regex) && campoLongitud.getText().matches(regex)
                && !campoNombre.getText().isEmpty() && !campoDireccion.getText().isEmpty()
                && !campoLatitud.getText().isEmpty() && !campoLongitud.getText().isEmpty()) {
            if(filaSeleccionada==100) {
                menuVendedor.recibirDatosDeCreacion(campoNombre.getText(), campoDireccion.getText(), campoLatitud.getText(), 
                        campoLongitud.getText(), campoItemsMenu.getText());
                JOptionPane.showMessageDialog(null, "Creado con Éxito", null, JOptionPane.INFORMATION_MESSAGE);
            } else {
                menuVendedor.recibirDatosDeEdicion(filaSeleccionada, campoNombre.getText(), campoDireccion.getText(), 
                        campoLatitud.getText(), campoLongitud.getText(), campoItemsMenu.getText());
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
            new VentanaDeCreacionEdicionVendedor().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JTextField campoDireccion;
    private javax.swing.JTextField campoItemsMenu;
    private javax.swing.JTextField campoLatitud;
    private javax.swing.JTextField campoLongitud;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JPanel panelEditable;
    private javax.swing.JLabel titDireccion;
    private javax.swing.JLabel titLatitud;
    private javax.swing.JLabel titLongitud;
    private javax.swing.JLabel titNombre;
    private javax.swing.JLabel titNombre1;
    private javax.swing.JLabel tituloPrincipal;
    // End of variables declaration//GEN-END:variables
}
