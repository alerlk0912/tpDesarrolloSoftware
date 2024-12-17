package isi.deso.tpds.Cliente;

import isi.deso.tpds.MenuPrincipal.MenuPrincipal;
import isi.deso.tpds.ItemMenu.MenuItemsMenu;
import isi.deso.tpds.Pedido.MenuPedidos;
import isi.deso.tpds.Vendedor.MenuVendedor;

import java.awt.*;
import java.util.List;
import java.util.Objects;
import javax.swing.*;
import javax.swing.table.*;

public class MenuCliente extends javax.swing.JFrame {
    private MenuPrincipal menuPrincipal;
    private MenuVendedor menuVendedor;
    private MenuItemsMenu menuItemsMenu;
    private MenuPedidos menuPedidos;
    private final ClienteController clienteController;
    private final DefaultTableModel model;

    public MenuCliente(ClienteController clienteController) {
       initComponents();
       this.model = (DefaultTableModel) tablaClientes.getModel();
       this.clienteController = clienteController;
       cargarClientesEnTabla();
    }

    private javax.swing.JTextField coordenadasCliente;
    private javax.swing.JTextField cuitCliente;
    private javax.swing.JTextField direccionCliente;
    private javax.swing.JTextField emailCliente;
    private javax.swing.JTextField nombreCliente;
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables
	
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel jPanel1 = new JPanel();
        JPanel panel = new JPanel();
        JButton botonVendedor = new JButton();
        JButton botonCliente = new JButton();
        JButton botonPedidos = new JButton();
        JButton botonItemsMenu = new JButton();
        JLabel texto1 = new JLabel();
        JButton botonVolver = new JButton();
        JButton buscarCliente = new JButton();
        JButton botonEditarCliente = new JButton();
        JButton botonEliminarCliente = new JButton();
        JButton botonCrearCliente = new JButton();
        cuitCliente = new javax.swing.JTextField();
        JLabel textoCUIT = new JLabel();
        nombreCliente = new javax.swing.JTextField();
        JLabel textoNombre = new JLabel();
        emailCliente = new javax.swing.JTextField();
        JLabel textoEmail = new JLabel();
        JScrollPane scrollTablaClientes = new JScrollPane();
        tablaClientes = new javax.swing.JTable();
        coordenadasCliente = new javax.swing.JTextField();
        JLabel textoCoordenadas = new JLabel();
        JLabel textoDireccion = new JLabel();
        direccionCliente = new javax.swing.JTextField();
        // Variables declaration - do not modify//GEN-BEGIN:variables
        JLabel logo = new JLabel();

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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setBackground(new java.awt.Color(69, 69, 69));
        panel.setAlignmentX(0.0F);
        panel.setAlignmentY(0.0F);
        panel.setMaximumSize(new java.awt.Dimension(900, 600));
        panel.setMinimumSize(new java.awt.Dimension(900, 600));

        botonVendedor.setBackground(new java.awt.Color(123, 36, 28));
        botonVendedor.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 14)); // NOI18N
        botonVendedor.setForeground(new java.awt.Color(255, 255, 255));
        botonVendedor.setText("VENDEDORES");
        botonVendedor.addActionListener(this::botonVendedorActionPerformed);

        botonCliente.setBackground(new java.awt.Color(123, 36, 28));
        botonCliente.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 14)); // NOI18N
        botonCliente.setForeground(new java.awt.Color(255, 255, 255));
        botonCliente.setText("CLIENTES");
        botonCliente.setEnabled(false);
        botonCliente.addActionListener(this::botonClienteActionPerformed);

        botonPedidos.setBackground(new java.awt.Color(123, 36, 28));
        botonPedidos.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 14)); // NOI18N
        botonPedidos.setForeground(new java.awt.Color(255, 255, 255));
        botonPedidos.setText("PEDIDOS");
        botonPedidos.addActionListener(this::botonPedidosActionPerformed);

        botonItemsMenu.setBackground(new java.awt.Color(123, 36, 28));
        botonItemsMenu.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 14)); // NOI18N
        botonItemsMenu.setForeground(new java.awt.Color(255, 255, 255));
        botonItemsMenu.setText("ITEMS MENÚ");
        botonItemsMenu.addActionListener(this::botonItemsMenuActionPerformed);

        texto1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        texto1.setEnabled(false);
        texto1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        botonVolver.setBackground(new java.awt.Color(123, 36, 28));
        botonVolver.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 14)); // NOI18N
        botonVolver.setForeground(new java.awt.Color(255, 255, 255));
        botonVolver.setText("VOLVER");
        botonVolver.addActionListener(this::botonVolverActionPerformed);

        buscarCliente.setBackground(new java.awt.Color(123, 36, 28));
        buscarCliente.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 12)); // NOI18N
        buscarCliente.setForeground(new java.awt.Color(255, 255, 255));
        buscarCliente.setText("BUSCAR CLIENTE");
        buscarCliente.addActionListener(this::buscarClienteActionPerformed);

        botonEditarCliente.setBackground(new java.awt.Color(123, 36, 28));
        botonEditarCliente.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 12)); // NOI18N
        botonEditarCliente.setForeground(new java.awt.Color(255, 255, 255));
        botonEditarCliente.setText("EDITAR CLIENTE");
        botonEditarCliente.addActionListener(this::botonEditarClienteActionPerformed);

        botonEliminarCliente.setBackground(new java.awt.Color(123, 36, 28));
        botonEliminarCliente.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 12)); // NOI18N
        botonEliminarCliente.setForeground(new java.awt.Color(255, 255, 255));
        botonEliminarCliente.setText("ELIMINAR CLIENTE");
        botonEliminarCliente.addActionListener(this::botonEliminarClienteActionPerformed);

        botonCrearCliente.setBackground(new java.awt.Color(123, 36, 28));
        botonCrearCliente.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 12)); // NOI18N
        botonCrearCliente.setForeground(new java.awt.Color(255, 255, 255));
        botonCrearCliente.setText("CREAR CLIENTE");
        botonCrearCliente.addActionListener(this::botonCrearClienteActionPerformed);

        cuitCliente.setBackground(new java.awt.Color(123, 36, 28));
        cuitCliente.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        cuitCliente.setForeground(new java.awt.Color(255, 255, 255));

        textoCUIT.setBackground(new java.awt.Color(123, 35, 27));
        textoCUIT.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        textoCUIT.setForeground(new java.awt.Color(255, 255, 255));
        textoCUIT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoCUIT.setText("CUIT");
        textoCUIT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textoCUIT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        textoCUIT.setInheritsPopupMenu(false);

        nombreCliente.setBackground(new java.awt.Color(123, 36, 28));
        nombreCliente.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        nombreCliente.setForeground(new java.awt.Color(255, 255, 255));

        textoNombre.setBackground(new java.awt.Color(123, 35, 27));
        textoNombre.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        textoNombre.setForeground(new java.awt.Color(255, 255, 255));
        textoNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoNombre.setText("Nombre");
        textoNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textoNombre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        textoNombre.setInheritsPopupMenu(false);

        emailCliente.setBackground(new java.awt.Color(123, 36, 28));
        emailCliente.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        emailCliente.setForeground(new java.awt.Color(255, 255, 255));

        textoEmail.setBackground(new java.awt.Color(123, 35, 27));
        textoEmail.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        textoEmail.setForeground(new java.awt.Color(255, 255, 255));
        textoEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoEmail.setText("Email");
        textoEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textoEmail.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        textoEmail.setInheritsPopupMenu(false);

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CUIT", "Nombre", "Email", "Dirección", "Coordenadas"
            }
        ) {
            final boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tablaClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaClientes.setShowGrid(true);
        scrollTablaClientes.setViewportView(tablaClientes);
        if (tablaClientes.getColumnModel().getColumnCount() > 0) {
            tablaClientes.getColumnModel().getColumn(0).setMinWidth(30);
            tablaClientes.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablaClientes.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        coordenadasCliente.setBackground(new java.awt.Color(123, 36, 28));
        coordenadasCliente.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        coordenadasCliente.setForeground(new java.awt.Color(255, 255, 255));

        textoCoordenadas.setBackground(new java.awt.Color(123, 35, 27));
        textoCoordenadas.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        textoCoordenadas.setForeground(new java.awt.Color(255, 255, 255));
        textoCoordenadas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoCoordenadas.setText("Coordenadas");
        textoCoordenadas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textoCoordenadas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        textoCoordenadas.setInheritsPopupMenu(false);

        textoDireccion.setBackground(new java.awt.Color(123, 35, 27));
        textoDireccion.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        textoDireccion.setForeground(new java.awt.Color(255, 255, 255));
        textoDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoDireccion.setText("Dirección");
        textoDireccion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textoDireccion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        textoDireccion.setInheritsPopupMenu(false);

        direccionCliente.setBackground(new java.awt.Color(123, 36, 28));
        direccionCliente.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        direccionCliente.setForeground(new java.awt.Color(255, 255, 255));

        logo.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/logo.jpg")))); // NOI18N
        logo.setText("jLabel");

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelLayout.createSequentialGroup()
                                .addComponent(botonVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(botonItemsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                            .addComponent(scrollTablaClientes, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelLayout.createSequentialGroup()
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cuitCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textoCUIT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nombreCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                    .addComponent(textoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(buscarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                    .addComponent(emailCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                    .addComponent(textoEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(direccionCliente)
                                    .addComponent(textoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(coordenadasCliente)
                                    .addComponent(textoCoordenadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(663, 663, 663)
                        .addComponent(texto1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(botonEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(botonCrearCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(botonEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonItemsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoCUIT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cuitCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textoCoordenadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(coordenadasCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(direccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(buscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(scrollTablaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCrearCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonVendedorActionPerformed(java.awt.event.ActionEvent evt) {                                                                                                                                                                                                                   
        menuVendedor.setMenuCliente(this);
        menuVendedor.setVisible(true);
        menuVendedor.setLocationRelativeTo(null);
        setVisible(false);
    }                                                                                                                                                                          

    private void buscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarClienteActionPerformed
    String cuit = cuitCliente.getText().trim();
    String nombre = nombreCliente.getText().trim().toLowerCase();
    String email = emailCliente.getText().trim().toLowerCase();
    String direccion = direccionCliente.getText().trim().toLowerCase();
    String coordenada = coordenadasCliente.getText().trim().toLowerCase();
    Double latitud = null;
    Double longitud = null;
    model.setRowCount(0);

    if (cuit.isEmpty() && nombre.isEmpty() && email.isEmpty() && direccion.isEmpty() && coordenada.isEmpty()) {
        cargarClientesEnTabla();
        return;
    }

    if (!coordenada.isEmpty()) {
        String[] partes = coordenada.split(",");
        if (partes.length == 2) {
            try {
                latitud = Double.parseDouble(partes[0].trim());
                longitud = Double.parseDouble(partes[1].trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Formato de coordenadas incorrecto. Use el formato: 'Latitud, Longitud'.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Formato de coordenadas incorrecto. Use el formato: 'Latitud, Longitud'.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    List<Cliente> clientes = clienteController.mostrarClientes();
    boolean encontrado = false;

		for (Cliente cliente : clientes) {
			boolean coincide = (cuit.isEmpty() || cliente.getCuit().contains(cuit)) &&
					(nombre.isEmpty() || cliente.getNombre().toLowerCase().contains(nombre)) &&
					(direccion.isEmpty() || cliente.getDireccion().toLowerCase().contains(direccion)) &&
					(email.isEmpty() || cliente.getEmail().toLowerCase().contains(email)) &&
					(latitud == null || cliente.getCoordenadas().getLat() == latitud) &&
					(longitud == null || cliente.getCoordenadas().getLng() == longitud);

			if (coincide) {
				String coord = cliente.getCoordenadas().getLat() + ", " + cliente.getCoordenadas().getLng();
				model.addRow(new Object[]{cliente.getId(), cliente.getCuit(), cliente.getNombre(), cliente.getEmail(), cliente.getDireccion(), coord});
				encontrado = true;
			}
		}

		if (!encontrado) {
			JOptionPane.showMessageDialog(this, "No se encontró ningún cliente con esos parámetros.", "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
		}
	}//GEN-LAST:event_buscarClienteActionPerformed
    
    private void botonPedidosActionPerformed(java.awt.event.ActionEvent evt) {                                                                                                                       
        menuPedidos.setMenuCliente(this);
        menuPedidos.setVisible(true);
        menuPedidos.setLocationRelativeTo(null);
        setVisible(false);
    }                                                                            

    private void botonItemsMenuActionPerformed(java.awt.event.ActionEvent evt) {                                                                                                                   
        menuItemsMenu.setMenuCliente(this);
        menuItemsMenu.setVisible(true);
        menuItemsMenu.setLocationRelativeTo(null);
        setVisible(false);
    }                                              

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {                                            
        menuPrincipal.setVisible(true);
        menuPrincipal.setLocationRelativeTo(null);
        setVisible(false);
    }                                                                                 

    private void botonEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarClienteActionPerformed
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (filaSeleccionada != -1) {
            int id = (int) model.getValueAt(filaSeleccionada, 0);
            Cliente cliente = clienteController.buscarCliente(id);
            if(cliente != null){
                VentanaDeCreacionEdicionCliente ventanaEdicion = new VentanaDeCreacionEdicionCliente(clienteController);
                ventanaEdicion.setMenuCliente(this);
                ventanaEdicion.recibirDatosEdicion(filaSeleccionada, cliente);
                ventanaEdicion.setVisible(true);
                ventanaEdicion.setLocationRelativeTo(null);
                ventanaEdicion.setTitulo();
                ventanaEdicion.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                            cargarClientesEnTabla();
                        }
                    });
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecciona una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botonEditarClienteActionPerformed

    private void botonEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {                                                                                                                
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (filaSeleccionada != -1) {
            int id = (int) model.getValueAt(filaSeleccionada, 0);
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este Cliente?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                clienteController.eliminarCliente(id);
                model.removeRow(filaSeleccionada);
                cargarClientesEnTabla();
                JOptionPane.showMessageDialog(null, "Cliente borrado con Éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        }          

        else {
            JOptionPane.showMessageDialog(null, "Por favor selecciona una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }                                                    

    private void botonCrearClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearClienteActionPerformed
        VentanaDeCreacionEdicionCliente nuevaVentana = new VentanaDeCreacionEdicionCliente(clienteController);
        nuevaVentana.setMenuCliente(this);
        nuevaVentana.setVisible(true);
        nuevaVentana.setLocationRelativeTo(null);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                cargarClientesEnTabla();
            }
        });
    }//GEN-LAST:event_botonCrearClienteActionPerformed

    private void botonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonClienteActionPerformed
    
    private void cargarClientesEnTabla() {
        model.setRowCount(0);
        List<Cliente> listaClientes = clienteController.mostrarClientes();
        if (listaClientes != null) {
            Object[][] clientes = new Object[listaClientes.size()][6];
            int index =0;
                for (Cliente cliente : listaClientes) {
                clientes[index][0] = cliente.getId();
                clientes[index][1] = cliente.getCuit();
                clientes[index][2] = cliente.getNombre();
                clientes[index][3] = cliente.getEmail();
                clientes[index][4] = cliente.getDireccion();
                clientes[index][5] = cliente.getCoordenadas().getLat() + ", " + cliente.getCoordenadas().getLng();
                model.addRow(clientes[index]);
                index++;
            }
        }
    }
    
    public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
    }
    public void setMenuVendedor(MenuVendedor menuVendedor) {
        this.menuVendedor = menuVendedor;
    }
    public void setMenuCliente() {
        cargarClientesEnTabla();
    }
    public void setMenuItemsMenu(MenuItemsMenu menuItemsMenu) {
        this.menuItemsMenu = menuItemsMenu;
    }
    public void setMenuPedidos(MenuPedidos menuPedidos) {
        this.menuPedidos = menuPedidos;
    }

    public static void main(String[] args) {
        DAOCliente clienteDAO = ClienteMemory.getInstance();
        ClienteController clienteController = ClienteController.getInstance(clienteDAO);
        java.awt.EventQueue.invokeLater(() -> new MenuCliente(clienteController).setVisible(true));
    }
	
}