package Tp.DS.Vendedor;

import Tp.DS.MenuPrincipal.MenuPrincipal;
import Tp.DS.Cliente.MenuCliente;
import Tp.DS.ItemMenu.MenuItemsMenu;
import Tp.DS.Pedido.MenuPedidos;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

public class MenuVendedor extends javax.swing.JFrame {
    private MenuPrincipal menuPrincipal;
    private MenuCliente menuCliente;
    private MenuItemsMenu menuItemsMenu;
    private MenuPedidos menuPedidos;
    private VendedorController vendedorController;
    private final DefaultTableModel model;
    private Object[][] vendedores;
        
    public MenuVendedor(VendedorController vendedorController) {
        initComponents();
        this.model = (DefaultTableModel) tablaVendedor.getModel();
        this.vendedorController = vendedorController;
        cargarTablaVendedores();
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
    private javax.swing.JTextField campoNombreVendedor;
    private javax.swing.JScrollPane scrollTablaVendedores;
    private javax.swing.JTable tablaVendedor;
    private javax.swing.JLabel texto1;
    private javax.swing.JLabel texto2;
    private javax.swing.JLabel texto3;
    private javax.swing.JLabel texto4;
    // End of variables declaration//GEN-END:variables
	
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
        tablaVendedor.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollTablaVendedores, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelLayout.createSequentialGroup()
                                    .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(campoNombreVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(texto2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(campoDireccionVendedor)
                                        .addComponent(texto3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(texto4, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(campoCoordenadaVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelLayout.createSequentialGroup()
                                    .addComponent(botonVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(botonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(botonItemsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(botonPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(texto1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
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
                    .addComponent(campoNombreVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
	
    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {
        menuPrincipal.setVisible(true);
        menuPrincipal.setLocationRelativeTo(null);
        setVisible(false);
    }

    private void botonItemsMenuActionPerformed(java.awt.event.ActionEvent evt) {                                              
        menuItemsMenu.setMenuVendedor(this);
        menuItemsMenu.setVisible(true);
        menuItemsMenu.setLocationRelativeTo(null);
        setVisible(false);
    }                                             

    private void botonPedidosActionPerformed(java.awt.event.ActionEvent evt) {                                              
        menuPedidos.setMenuVendedor(this);
        menuPedidos.setVisible(true);
        menuPedidos.setLocationRelativeTo(null);
        setVisible(false);
    }                                             

    private void botonClienteActionPerformed(java.awt.event.ActionEvent evt) {                                              
        menuCliente.setMenuVendedor(this);
        menuCliente.setVisible(true);
        menuCliente.setLocationRelativeTo(null);
        setVisible(false);
    }                                             

    private void botonVendedorActionPerformed(java.awt.event.ActionEvent evt) {                                              
    }                                             
    
    private void botonBuscarVendedorActionPerformed(java.awt.event.ActionEvent evt) {                                              
        String nombre = campoNombreVendedor.getText().trim().toLowerCase();
        String direccion = campoDireccionVendedor.getText().trim().toLowerCase();
        String coordenada = campoCoordenadaVendedor.getText().trim().toLowerCase();
        Double latitud = null;
        Double longitud = null;
        model.setRowCount(0);

        List<Vendedor> vendedores = vendedorController.mostrarListaVendedor();
        boolean encontrado = false;
        
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

        for (Vendedor vendedor : vendedores) {
            boolean coincide = (nombre.isEmpty() || vendedor.getNombre().toLowerCase().contains(nombre)) &&
                           (direccion.isEmpty() || vendedor.getDireccion().toLowerCase().contains(direccion)) &&
                           (latitud == null || vendedor.getCoordenadas().getLat() == latitud) &&
                           (longitud == null || vendedor.getCoordenadas().getLng() == longitud);

            if (coincide) {
                String coord = vendedor.getCoordenadas().getLat() + ", " + vendedor.getCoordenadas().getLng();
                model.addRow(new Object[]{vendedor.getId(), vendedor.getNombre(), vendedor.getDireccion(), coord});
                encontrado = true;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(this, "No se encontró ningún vendedor con esos parámetros.", "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
        }
    }                                             

    private void botonCrearVendedorActionPerformed(java.awt.event.ActionEvent evt) {                                              
        VentanaDeCreacionEdicionVendedor nuevaVentana = new VentanaDeCreacionEdicionVendedor(vendedorController);
        nuevaVentana.setMenuVendedor(this);
        nuevaVentana.setVisible(true);
        nuevaVentana.setLocationRelativeTo(null);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                cargarTablaVendedores();
            }
        });
    }                                             

    private void botonEliminarVendedorActionPerformed(java.awt.event.ActionEvent evt) {                                              
        int filaSeleccionada = tablaVendedor.getSelectedRow();
        if (filaSeleccionada != -1) {
            int id = (int) model.getValueAt(filaSeleccionada, 0);
            int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar este Vendedor?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                vendedorController.eliminarVendedor(id);
                cargarTablaVendedores();
                JOptionPane.showMessageDialog(this, "Vendedor borrado con Éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Por favor selecciona una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }                                             

    private void botonEditarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCancelarActionPerformed
        int filaSeleccionada = tablaVendedor.getSelectedRow();
        if (filaSeleccionada != -1) {
            int id = (int) model.getValueAt(filaSeleccionada, 0);
            Vendedor vendedor = vendedorController.buscarVendedor(id);
            if (vendedor != null){
                VentanaDeCreacionEdicionVendedor nuevaVentana = new VentanaDeCreacionEdicionVendedor(vendedorController);
                nuevaVentana.recibirDatosEdicion(filaSeleccionada, vendedor);
                nuevaVentana.setMenuVendedor(this);
                nuevaVentana.setVisible(true);
                nuevaVentana.setLocationRelativeTo(null);
                nuevaVentana.setTitulo();
                nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                        cargarTablaVendedores();
                    }
                });
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Por favor selecciona una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_BotonCancelarActionPerformed
    
    public void cargarTablaVendedores() {
        model.setRowCount(0);
        List<Vendedor> listaVendedores = vendedorController.mostrarListaVendedor();
        if (listaVendedores != null) {
            vendedores = new Object[listaVendedores.size()][4];
            int index = 0;
            for (Vendedor vendedor : listaVendedores) {
                vendedores[index][0] = vendedor.getId();
                vendedores[index][1] = vendedor.getNombre();
                vendedores[index][2] = vendedor.getDireccion();
                vendedores[index][3] = vendedor.getCoordenadas().getLat() + ", " + vendedor.getCoordenadas().getLng();
                model.addRow(vendedores[index]);
                index++;
            }
        }
    }

    public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
    }
    public void setMenuVendedor(MenuVendedor menuVendedor) {
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
    
    public static void main(String args[]) {
        DAOVendedor vendedorDAO = VendedorMemory.getInstance();
        VendedorController vendedorController = VendedorController.getInstance(vendedorDAO);
        java.awt.EventQueue.invokeLater(() -> {
            new MenuVendedor(vendedorController).setVisible(true);
        });
    }

}

