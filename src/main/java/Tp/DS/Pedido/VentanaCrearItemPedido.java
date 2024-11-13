/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Tp.DS.Pedido;

import Tp.DS.Exceptions.DAOException;
import Tp.DS.ItemMenu.*;
import Tp.DS.Vendedor.*;
import Tp.DS.ItemPedido.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class VentanaCrearItemPedido extends javax.swing.JFrame {
    VendedorController vendedorController;
    PedidoController pedidoController;
    ItemMenuController itemMenuController; 
    ItemsPedidoController itemPedidoController;
    private Vendedor vendedorSeleccionado;
    private ItemMenu itemSeleccionado;
    private List<ItemsPedido> itemsPorPedido;
    private Double montoBasePedido;
    private VentanaDeCreacionEdicionPedido ventanaCrearPedido;
    
    public VentanaCrearItemPedido(VentanaDeCreacionEdicionPedido ventanaCrearPedido,VendedorController vendedorController, PedidoController pedidoController,
            ItemMenuController itemMenuController, ItemsPedidoController itemPedidoController) {
        this.itemPedidoController = itemPedidoController;
        this.pedidoController = pedidoController;
        this.vendedorController = vendedorController;
        this.itemMenuController = itemMenuController;
        this.ventanaCrearPedido = ventanaCrearPedido;
        this.itemsPorPedido = new ArrayList<>(); 
        this.montoBasePedido = 0.0; 
        this.vendedorSeleccionado = null;
        
        initComponents();
        cargarVendedorAsociadosEnTabla();
    }

    public void setPantallaAgregarDesagregarVendedor(VentanaDeCreacionEdicionPedido ventanaCrearPedido) {
        this.ventanaCrearPedido = ventanaCrearPedido;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        BotonCancelar = new javax.swing.JButton();
        BotonAceptar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaItemsAgregados = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaItemsPorVendedor = new javax.swing.JTable();
        botonAgregarItem = new javax.swing.JButton();
        titCantidad = new javax.swing.JLabel();
        campoCantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        campoPrecio = new javax.swing.JTextField();
        campoNombre = new javax.swing.JTextField();
        campoID = new javax.swing.JTextField();
        comboBoxCategoria = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaVendedor1 = new javax.swing.JTable();
        tituloTablaVendedores = new javax.swing.JLabel();
        botonVendedor = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Crear Item Pedido");

        BotonCancelar.setBackground(new java.awt.Color(123, 36, 28));
        BotonCancelar.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        BotonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        BotonCancelar.setText("Cancelar");
        BotonCancelar.setMaximumSize(new java.awt.Dimension(124, 30));
        BotonCancelar.setMinimumSize(new java.awt.Dimension(124, 30));
        BotonCancelar.setPreferredSize(new java.awt.Dimension(124, 30));
        BotonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCancelarActionPerformed(evt);
            }
        });

        BotonAceptar.setBackground(new java.awt.Color(123, 36, 28));
        BotonAceptar.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        BotonAceptar.setForeground(new java.awt.Color(255, 255, 255));
        BotonAceptar.setText("Aceptar");
        BotonAceptar.setMaximumSize(new java.awt.Dimension(124, 30));
        BotonAceptar.setMinimumSize(new java.awt.Dimension(124, 30));
        BotonAceptar.setPreferredSize(new java.awt.Dimension(124, 30));
        BotonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAceptarActionPerformed(evt);
            }
        });

        TablaItemsAgregados.setBackground(new java.awt.Color(255, 255, 255));
        TablaItemsAgregados.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        TablaItemsAgregados.setForeground(new java.awt.Color(0, 0, 0));
        TablaItemsAgregados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaItemsAgregados.setColumnSelectionAllowed(true);
        TablaItemsAgregados.setGridColor(new java.awt.Color(255, 255, 255));
        TablaItemsAgregados.setMaximumSize(new java.awt.Dimension(500, 200));
        TablaItemsAgregados.setMinimumSize(new java.awt.Dimension(500, 200));
        TablaItemsAgregados.setPreferredSize(new java.awt.Dimension(500, 200));
        TablaItemsAgregados.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TablaItemsAgregados);
        TablaItemsAgregados.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (TablaItemsAgregados.getColumnModel().getColumnCount() > 0) {
            TablaItemsAgregados.getColumnModel().getColumn(0).setResizable(false);
            TablaItemsAgregados.getColumnModel().getColumn(1).setResizable(false);
            TablaItemsAgregados.getColumnModel().getColumn(2).setResizable(false);
        }

        TablaItemsPorVendedor.setBackground(new java.awt.Color(255, 255, 255));
        TablaItemsPorVendedor.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        TablaItemsPorVendedor.setForeground(new java.awt.Color(0, 0, 0));
        TablaItemsPorVendedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Precio", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaItemsPorVendedor.setColumnSelectionAllowed(true);
        TablaItemsPorVendedor.setGridColor(new java.awt.Color(255, 255, 255));
        TablaItemsPorVendedor.setMaximumSize(new java.awt.Dimension(500, 200));
        TablaItemsPorVendedor.setMinimumSize(new java.awt.Dimension(500, 200));
        TablaItemsPorVendedor.setPreferredSize(new java.awt.Dimension(500, 200));
        TablaItemsPorVendedor.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(TablaItemsPorVendedor);
        TablaItemsPorVendedor.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (TablaItemsPorVendedor.getColumnModel().getColumnCount() > 0) {
            TablaItemsPorVendedor.getColumnModel().getColumn(0).setResizable(false);
            TablaItemsPorVendedor.getColumnModel().getColumn(1).setResizable(false);
            TablaItemsPorVendedor.getColumnModel().getColumn(2).setResizable(false);
            TablaItemsPorVendedor.getColumnModel().getColumn(3).setResizable(false);
        }

        botonAgregarItem.setBackground(new java.awt.Color(123, 36, 28));
        botonAgregarItem.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        botonAgregarItem.setForeground(new java.awt.Color(255, 255, 255));
        botonAgregarItem.setText("Agregar Item");
        botonAgregarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarItemActionPerformed(evt);
            }
        });

        titCantidad.setBackground(new java.awt.Color(123, 36, 28));
        titCantidad.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        titCantidad.setForeground(new java.awt.Color(255, 255, 255));
        titCantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titCantidad.setText("Cantidad");
        titCantidad.setMaximumSize(new java.awt.Dimension(129, 24));
        titCantidad.setMinimumSize(new java.awt.Dimension(129, 24));
        titCantidad.setPreferredSize(new java.awt.Dimension(100, 24));

        campoCantidad.setBackground(new java.awt.Color(123, 36, 28));
        campoCantidad.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoCantidad.setForeground(new java.awt.Color(255, 255, 255));
        campoCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoCantidad.setMaximumSize(new java.awt.Dimension(130, 24));
        campoCantidad.setMinimumSize(new java.awt.Dimension(130, 24));
        campoCantidad.setPreferredSize(new java.awt.Dimension(64, 24));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(titCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonAgregarItem))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(127, 127, 127)
                            .addComponent(BotonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(BotonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAgregarItem)
                    .addComponent(titCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel4.setBackground(new java.awt.Color(123, 36, 28));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Nombre");
        jLabel4.setMaximumSize(new java.awt.Dimension(129, 24));
        jLabel4.setMinimumSize(new java.awt.Dimension(129, 24));
        jLabel4.setPreferredSize(new java.awt.Dimension(129, 24));

        jLabel5.setBackground(new java.awt.Color(123, 36, 28));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Precio");
        jLabel5.setMaximumSize(new java.awt.Dimension(129, 24));
        jLabel5.setMinimumSize(new java.awt.Dimension(129, 24));
        jLabel5.setPreferredSize(new java.awt.Dimension(100, 24));

        campoPrecio.setBackground(new java.awt.Color(123, 36, 28));
        campoPrecio.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoPrecio.setForeground(new java.awt.Color(255, 255, 255));
        campoPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoPrecio.setMaximumSize(new java.awt.Dimension(130, 24));
        campoPrecio.setMinimumSize(new java.awt.Dimension(130, 24));
        campoPrecio.setPreferredSize(new java.awt.Dimension(64, 24));

        campoNombre.setBackground(new java.awt.Color(123, 36, 28));
        campoNombre.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoNombre.setActionCommand("<Not Set>");
        campoNombre.setMaximumSize(new java.awt.Dimension(130, 24));
        campoNombre.setMinimumSize(new java.awt.Dimension(130, 24));
        campoNombre.setPreferredSize(new java.awt.Dimension(130, 24));

        campoID.setBackground(new java.awt.Color(123, 36, 28));
        campoID.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoID.setForeground(new java.awt.Color(255, 255, 255));
        campoID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoID.setMaximumSize(new java.awt.Dimension(100, 24));
        campoID.setMinimumSize(new java.awt.Dimension(100, 24));
        campoID.setPreferredSize(new java.awt.Dimension(100, 24));

        comboBoxCategoria.setBackground(new java.awt.Color(123, 36, 28));
        comboBoxCategoria.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        comboBoxCategoria.setMaximumRowCount(2);
        comboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BEBIDA", "PLATO" }));
        comboBoxCategoria.setMaximumSize(new java.awt.Dimension(130, 24));
        comboBoxCategoria.setMinimumSize(new java.awt.Dimension(130, 24));
        comboBoxCategoria.setPreferredSize(new java.awt.Dimension(130, 24));

        jLabel2.setBackground(new java.awt.Color(123, 36, 28));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Categoria");
        jLabel2.setMaximumSize(new java.awt.Dimension(129, 24));
        jLabel2.setMinimumSize(new java.awt.Dimension(129, 24));
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 24));

        jLabel3.setBackground(new java.awt.Color(123, 36, 28));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ID");
        jLabel3.setMaximumSize(new java.awt.Dimension(100, 24));
        jLabel3.setMinimumSize(new java.awt.Dimension(100, 24));
        jLabel3.setPreferredSize(new java.awt.Dimension(100, 24));

        TablaVendedor1.setBackground(new java.awt.Color(255, 255, 255));
        TablaVendedor1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        TablaVendedor1.setForeground(new java.awt.Color(0, 0, 0));
        TablaVendedor1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaVendedor1.setGridColor(new java.awt.Color(255, 255, 255));
        TablaVendedor1.setMaximumSize(new java.awt.Dimension(500, 200));
        TablaVendedor1.setMinimumSize(new java.awt.Dimension(500, 200));
        TablaVendedor1.setPreferredSize(new java.awt.Dimension(500, 200));
        TablaVendedor1.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TablaVendedor1);
        TablaVendedor1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (TablaVendedor1.getColumnModel().getColumnCount() > 0) {
            TablaVendedor1.getColumnModel().getColumn(0).setResizable(false);
            TablaVendedor1.getColumnModel().getColumn(1).setResizable(false);
        }

        tituloTablaVendedores.setBackground(new java.awt.Color(123, 36, 28));
        tituloTablaVendedores.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tituloTablaVendedores.setForeground(new java.awt.Color(255, 255, 255));
        tituloTablaVendedores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloTablaVendedores.setText("Vendedores ");
        tituloTablaVendedores.setMaximumSize(new java.awt.Dimension(129, 24));
        tituloTablaVendedores.setMinimumSize(new java.awt.Dimension(129, 24));
        tituloTablaVendedores.setPreferredSize(new java.awt.Dimension(129, 24));

        botonVendedor.setBackground(new java.awt.Color(123, 36, 28));
        botonVendedor.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        botonVendedor.setForeground(new java.awt.Color(255, 255, 255));
        botonVendedor.setText("Seleccionar Vendedor");
        botonVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVendedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tituloTablaVendedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboBoxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(botonVendedor)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tituloTablaVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonVendedor)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        campoPrecio.getAccessibleContext().setAccessibleName("");
        campoNombre.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCancelarActionPerformed
            dispose();
    }//GEN-LAST:event_BotonCancelarActionPerformed

    private void botonAgregarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarItemActionPerformed
        int filaVendedorSeleccionada = TablaItemsPorVendedor.getSelectedRow();

        if (filaVendedorSeleccionada != -1) { 
            int idItem = (int) TablaItemsPorVendedor.getValueAt(filaVendedorSeleccionada, 0);
            try {
                int cantidad = Integer.parseInt(campoCantidad.getText());
                if (cantidad <= 0) {
                    JOptionPane.showMessageDialog(this, "La cantidad debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                itemSeleccionado = itemMenuController.buscarItemMenu(idItem);
                ItemsPedido nuevoItem = itemPedidoController.crearNuevoyRetornarItemPedido(idItem, cantidad);
                agregarItemNuevoATabla(nuevoItem);
                itemsPorPedido.add(nuevoItem);
            } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (DAOException ex) {
            Logger.getLogger(VentanaCrearItemPedido.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al agregar el ítem al pedido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un Item.");
        }
    }//GEN-LAST:event_botonAgregarItemActionPerformed

    private void agregarItemNuevoATabla(ItemsPedido item){
        DefaultTableModel model = (DefaultTableModel) TablaItemsAgregados.getModel();
        if(item != null){
            model.addRow(new Object[]{
                    item.getItemMenu().getNombre(),
                    item.getItemMenu().getPrecio(),
                    item.getCantidad()});
        }
        else {
            JOptionPane.showMessageDialog(this, "Por favor, agregue un Item al Pedido.");
        }
    }
        
    private void botonVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVendedorActionPerformed
        int filaVendedorSeleccionada = TablaVendedor1.getSelectedRow();

        if (filaVendedorSeleccionada != -1) { 
            int idvendedor = (int) TablaVendedor1.getValueAt(filaVendedorSeleccionada, 0);
            vendedorSeleccionado = vendedorController.buscarVendedor(idvendedor);
            cargarTablaItemsPorVendedor(vendedorSeleccionado);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un vendedor.");
        }
    }//GEN-LAST:event_botonVendedorActionPerformed

    private void BotonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAceptarActionPerformed
        if (vendedorSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un vendedor antes de continuar.");
            return;
        } else if (itemsPorPedido.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Agregue al menos un ítem al pedido antes de aceptar.");
            return;
        } else{
            montoBasePedido = pedidoController.calcularTotalPedido(itemsPorPedido);
            JOptionPane.showMessageDialog(this, "Items agregados con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_BotonAceptarActionPerformed

    private void cargarVendedorAsociadosEnTabla(){
        DefaultTableModel model = (DefaultTableModel) TablaVendedor1.getModel();
        model.setRowCount(0); // Limpiar tabla
        List<Vendedor> listaVendedores = vendedorController.mostrarListaVendedor();
        if (listaVendedores != null) {
            for (Vendedor vendedor : listaVendedores) {
                model.addRow(new Object[]{
                    vendedor.getId(),
                    vendedor.getNombre()});
            }
        }else {
            JOptionPane.showMessageDialog(this, "No hay ningún Vendedor cargado");
        }
    }
    
    private void cargarTablaItemsPorVendedor(Vendedor vendedor){
        DefaultTableModel model = (DefaultTableModel) TablaItemsPorVendedor.getModel();
        model.setRowCount(0); // Limpiar tabla
        List<ItemMenu> listaItems;
        try {
            listaItems = itemMenuController.obtenerItemsMenuPorVendedor(vendedor);
            if (listaItems != null) {
                for (ItemMenu item : listaItems) {
                    model.addRow(new Object[]{
                        item.getId(),
                        item.getNombre(),
                        item.getPrecio(),
                        item.getCategoria().getTipo_item()
                    }
                    );
                }   
            }else {
                    JOptionPane.showMessageDialog(this, "No hay ningún item para el Vendedor cargado");
            }
        } catch (DAOException ex) {
            Logger.getLogger(VentanaCrearItemPedido.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al cargar los items del vendedor.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public List<ItemsPedido> getItemsPedidoSeleccionados() {
        return  itemsPorPedido;
    }
    
    public Double getMontoBaseItemsSeleccionados() {
        return  montoBasePedido;
    }
    
    public Vendedor getVendedorSeleccionado() {
        return vendedorSeleccionado;
    }
    
    
    public static void main(String args[]) {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAceptar;
    private javax.swing.JButton BotonCancelar;
    private javax.swing.JTable TablaItemsAgregados;
    private javax.swing.JTable TablaItemsPorVendedor;
    private javax.swing.JTable TablaVendedor1;
    private javax.swing.JButton botonAgregarItem;
    private javax.swing.JButton botonVendedor;
    private javax.swing.JTextField campoCantidad;
    private javax.swing.JTextField campoID;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoPrecio;
    private javax.swing.JComboBox<String> comboBoxCategoria;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel titCantidad;
    private javax.swing.JLabel tituloTablaVendedores;
    // End of variables declaration//GEN-END:variables

    
}
