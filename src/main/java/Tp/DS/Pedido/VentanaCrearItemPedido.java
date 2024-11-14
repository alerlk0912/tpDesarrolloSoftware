/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Tp.DS.Pedido;

import Tp.DS.Exceptions.DAOException;
import Tp.DS.ItemMenu.*;
import Tp.DS.Vendedor.*;
import Tp.DS.ItemPedido.*;
import java.awt.HeadlessException;
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
        configurarTablas();
        cargarVendedorAsociadosEnTabla();
    }

    private void configurarTablas() {
        // Configurar tabla de vendedores
        DefaultTableModel modelVendedores = (DefaultTableModel) TablaVendedor1.getModel();
        modelVendedores.setColumnIdentifiers(new Object[]{"ID", "Nombre"});

        // Configurar tabla de items por vendedor
        DefaultTableModel modelItems = (DefaultTableModel) TablaItemsPorVendedor.getModel();
        modelItems.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Precio", "Categoría"});
        modelItems.setRowCount(0);

        // Configurar tabla de items agregados
        DefaultTableModel modelAgregados = (DefaultTableModel) TablaItemsAgregados.getModel();
        modelAgregados.setColumnIdentifiers(new Object[]{"Nombre", "Precio", "Cantidad"});
        modelAgregados.setRowCount(0);
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
        TituloPantalla = new javax.swing.JLabel();
        PanelAgregarItems = new javax.swing.JPanel();
        BotonCancelar = new javax.swing.JButton();
        BotonAceptar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaItemsAgregados = new javax.swing.JTable();
        botonAgregarItem = new javax.swing.JButton();
        titCantidad = new javax.swing.JLabel();
        campoCantidad = new javax.swing.JTextField();
        PanelVendedores = new javax.swing.JPanel();
        tituloTablaVendedores = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaVendedor1 = new javax.swing.JTable();
        botonVendedor = new javax.swing.JButton();
        PanelItemsPorVendedor = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        campoID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoPrecio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboBoxCategoria = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaItemsPorVendedor = new javax.swing.JTable();
        botonBuscar = new javax.swing.JButton();

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

        jPanel1.setBackground(new java.awt.Color(69, 69, 69));

        TituloPantalla.setBackground(new java.awt.Color(69, 69, 69));
        TituloPantalla.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        TituloPantalla.setForeground(new java.awt.Color(255, 255, 255));
        TituloPantalla.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloPantalla.setText("Crear Item Pedido");

        PanelAgregarItems.setBackground(new java.awt.Color(69, 69, 69));

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

        TablaItemsAgregados.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        TablaItemsAgregados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        TablaItemsAgregados.setMaximumSize(new java.awt.Dimension(500, 200));
        TablaItemsAgregados.setMinimumSize(new java.awt.Dimension(500, 200));
        TablaItemsAgregados.setPreferredSize(new java.awt.Dimension(500, 200));
        TablaItemsAgregados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TablaItemsAgregados.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TablaItemsAgregados);
        TablaItemsAgregados.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (TablaItemsAgregados.getColumnModel().getColumnCount() > 0) {
            TablaItemsAgregados.getColumnModel().getColumn(0).setResizable(false);
            TablaItemsAgregados.getColumnModel().getColumn(1).setResizable(false);
            TablaItemsAgregados.getColumnModel().getColumn(2).setResizable(false);
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
        titCantidad.setText("Cantidad:");
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

        javax.swing.GroupLayout PanelAgregarItemsLayout = new javax.swing.GroupLayout(PanelAgregarItems);
        PanelAgregarItems.setLayout(PanelAgregarItemsLayout);
        PanelAgregarItemsLayout.setHorizontalGroup(
            PanelAgregarItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAgregarItemsLayout.createSequentialGroup()
                .addGroup(PanelAgregarItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelAgregarItemsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelAgregarItemsLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(BotonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelAgregarItemsLayout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(titCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonAgregarItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(28, 28, 28))
        );
        PanelAgregarItemsLayout.setVerticalGroup(
            PanelAgregarItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAgregarItemsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelAgregarItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAgregarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelAgregarItemsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        PanelVendedores.setBackground(new java.awt.Color(69, 69, 69));
        PanelVendedores.setToolTipText("");

        tituloTablaVendedores.setBackground(new java.awt.Color(123, 36, 28));
        tituloTablaVendedores.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tituloTablaVendedores.setForeground(new java.awt.Color(255, 255, 255));
        tituloTablaVendedores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloTablaVendedores.setText("Vendedores ");
        tituloTablaVendedores.setMaximumSize(new java.awt.Dimension(129, 24));
        tituloTablaVendedores.setMinimumSize(new java.awt.Dimension(129, 24));
        tituloTablaVendedores.setPreferredSize(new java.awt.Dimension(129, 24));

        TablaVendedor1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
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
        TablaVendedor1.setMaximumSize(new java.awt.Dimension(500, 200));
        TablaVendedor1.setMinimumSize(new java.awt.Dimension(500, 200));
        TablaVendedor1.setPreferredSize(new java.awt.Dimension(500, 200));
        TablaVendedor1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TablaVendedor1.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(TablaVendedor1);
        TablaVendedor1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (TablaVendedor1.getColumnModel().getColumnCount() > 0) {
            TablaVendedor1.getColumnModel().getColumn(0).setResizable(false);
            TablaVendedor1.getColumnModel().getColumn(1).setResizable(false);
        }

        botonVendedor.setBackground(new java.awt.Color(123, 36, 28));
        botonVendedor.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        botonVendedor.setForeground(new java.awt.Color(255, 255, 255));
        botonVendedor.setText("Seleccionar Vendedor");
        botonVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVendedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelVendedoresLayout = new javax.swing.GroupLayout(PanelVendedores);
        PanelVendedores.setLayout(PanelVendedoresLayout);
        PanelVendedoresLayout.setHorizontalGroup(
            PanelVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVendedoresLayout.createSequentialGroup()
                .addComponent(tituloTablaVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PanelVendedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelVendedoresLayout.createSequentialGroup()
                    .addContainerGap(328, Short.MAX_VALUE)
                    .addComponent(botonVendedor)
                    .addGap(16, 16, 16)))
        );
        PanelVendedoresLayout.setVerticalGroup(
            PanelVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVendedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloTablaVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(PanelVendedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelVendedoresLayout.createSequentialGroup()
                    .addContainerGap(141, Short.MAX_VALUE)
                    .addComponent(botonVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5, 5, 5)))
        );

        PanelItemsPorVendedor.setBackground(new java.awt.Color(69, 69, 69));

        jLabel3.setBackground(new java.awt.Color(123, 36, 28));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ID");
        jLabel3.setMaximumSize(new java.awt.Dimension(100, 24));
        jLabel3.setMinimumSize(new java.awt.Dimension(100, 24));
        jLabel3.setPreferredSize(new java.awt.Dimension(100, 24));

        campoID.setBackground(new java.awt.Color(123, 36, 28));
        campoID.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoID.setForeground(new java.awt.Color(255, 255, 255));
        campoID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoID.setMaximumSize(new java.awt.Dimension(100, 24));
        campoID.setMinimumSize(new java.awt.Dimension(100, 24));
        campoID.setPreferredSize(new java.awt.Dimension(100, 24));

        jLabel4.setBackground(new java.awt.Color(123, 36, 28));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Nombre");
        jLabel4.setMaximumSize(new java.awt.Dimension(129, 24));
        jLabel4.setMinimumSize(new java.awt.Dimension(129, 24));
        jLabel4.setPreferredSize(new java.awt.Dimension(129, 24));

        campoNombre.setBackground(new java.awt.Color(123, 36, 28));
        campoNombre.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoNombre.setActionCommand("<Not Set>");
        campoNombre.setMaximumSize(new java.awt.Dimension(130, 24));
        campoNombre.setMinimumSize(new java.awt.Dimension(130, 24));
        campoNombre.setPreferredSize(new java.awt.Dimension(130, 24));

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

        jLabel2.setBackground(new java.awt.Color(123, 36, 28));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Categoria");
        jLabel2.setMaximumSize(new java.awt.Dimension(129, 24));
        jLabel2.setMinimumSize(new java.awt.Dimension(129, 24));
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 24));

        comboBoxCategoria.setBackground(new java.awt.Color(123, 36, 28));
        comboBoxCategoria.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        comboBoxCategoria.setMaximumRowCount(2);
        comboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BEBIDA", "PLATO" }));
        comboBoxCategoria.setMaximumSize(new java.awt.Dimension(130, 24));
        comboBoxCategoria.setMinimumSize(new java.awt.Dimension(130, 24));
        comboBoxCategoria.setPreferredSize(new java.awt.Dimension(130, 24));

        TablaItemsPorVendedor.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        TablaItemsPorVendedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        TablaItemsPorVendedor.setMaximumSize(new java.awt.Dimension(500, 200));
        TablaItemsPorVendedor.setMinimumSize(new java.awt.Dimension(500, 200));
        TablaItemsPorVendedor.setPreferredSize(new java.awt.Dimension(500, 200));
        TablaItemsPorVendedor.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TablaItemsPorVendedor.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(TablaItemsPorVendedor);
        TablaItemsPorVendedor.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (TablaItemsPorVendedor.getColumnModel().getColumnCount() > 0) {
            TablaItemsPorVendedor.getColumnModel().getColumn(0).setResizable(false);
            TablaItemsPorVendedor.getColumnModel().getColumn(1).setResizable(false);
            TablaItemsPorVendedor.getColumnModel().getColumn(2).setResizable(false);
            TablaItemsPorVendedor.getColumnModel().getColumn(3).setResizable(false);
        }

        botonBuscar.setBackground(new java.awt.Color(123, 36, 28));
        botonBuscar.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        botonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelItemsPorVendedorLayout = new javax.swing.GroupLayout(PanelItemsPorVendedor);
        PanelItemsPorVendedor.setLayout(PanelItemsPorVendedorLayout);
        PanelItemsPorVendedorLayout.setHorizontalGroup(
            PanelItemsPorVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelItemsPorVendedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelItemsPorVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelItemsPorVendedorLayout.createSequentialGroup()
                        .addGroup(PanelItemsPorVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(campoID, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelItemsPorVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelItemsPorVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelItemsPorVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelItemsPorVendedorLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelItemsPorVendedorLayout.setVerticalGroup(
            PanelItemsPorVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelItemsPorVendedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelItemsPorVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelItemsPorVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelItemsPorVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        campoNombre.getAccessibleContext().setAccessibleName("");
        campoPrecio.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(PanelItemsPorVendedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PanelAgregarItems, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanelVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(TituloPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(TituloPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelItemsPorVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelAgregarItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(640, 640, 640))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCancelarActionPerformed
            dispose();
    }//GEN-LAST:event_BotonCancelarActionPerformed

    private void botonAgregarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarItemActionPerformed
        int filaVendedorSeleccionada = TablaItemsPorVendedor.getSelectedRow();

        if (filaVendedorSeleccionada != -1) { 
            
            try {
                int cantidad = Integer.parseInt(campoCantidad.getText());
                if (cantidad <= 0) {
                    JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                int idItem = (int) TablaItemsPorVendedor.getValueAt(filaVendedorSeleccionada, 0);
                itemSeleccionado = itemMenuController.buscarItemMenu(idItem);
                ItemsPedido nuevoItem = itemPedidoController.crearNuevoyRetornarItemPedido(idItem, cantidad);
                agregarItemNuevoATabla(nuevoItem);
                itemsPorPedido.add(nuevoItem);
                // limpiar campo cantidad
                campoCantidad.setText("");
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
    
	private void botonVendedorActionPerformed(java.awt.event.ActionEvent evt) {                                              
        int filaVendedorSeleccionada = TablaVendedor1.getSelectedRow();

        if (filaVendedorSeleccionada != -1) { 
            int idvendedor = (int) TablaVendedor1.getValueAt(filaVendedorSeleccionada, 0);
            vendedorSeleccionado = vendedorController.buscarVendedor(idvendedor);
            cargarTablaItemsPorVendedor(vendedorSeleccionado);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un vendedor.");
        }
    }
	
    private void BotonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAceptarActionPerformed
        if (vendedorSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un vendedor antes de continuar.");
            return;
        } 

        if (itemsPorPedido == null || itemsPorPedido.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Agregue al menos un ítem al pedido antes de aceptar.");
            return;
        }

        try {
            montoBasePedido = pedidoController.calcularTotalPedido(itemsPorPedido);
            JOptionPane.showMessageDialog(this, 
                String.format("Items agregados con éxito. Monto total: $%.2f", montoBasePedido), 
                "Información", 
                JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, 
                "Error al procesar el pedido: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BotonAceptarActionPerformed

	private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			int id = campoID.getText().isEmpty() ? 0 : Integer.parseInt(campoID.getText());
			String nombre = campoNombre.getText();
			double precio = campoPrecio.getText().isEmpty() ? 0.0 : Double.parseDouble(campoPrecio.getText());
			String categoria = comboBoxCategoria.getSelectedItem().toString();
			Vendedor vendedor = vendedorSeleccionado;

			List<ItemMenu> itemsFiltrados = itemMenuController.buscarItemsPorCriterios(id, nombre, precio, categoria, vendedor);
			actualizarTablaItems(itemsFiltrados);

		} catch (DAOException e) {
			JOptionPane.showMessageDialog(this, "Error al buscar ítems: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "ID y precio deben ser numéricos", "Error de Formato", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actualizarTablaItems(List<ItemMenu> items) {
		DefaultTableModel model = (DefaultTableModel) TablaItemsPorVendedor.getModel();
		model.setRowCount(0); // Limpiar la tabla

		for (ItemMenu item : items) {
			model.addRow(new Object[]{item.getId(), item.getNombre(), item.getPrecio(), item.getCategoria().getTipo_item()});
		}
	}

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
        if (itemsPorPedido == null || itemsPorPedido.isEmpty()) {
            throw new IllegalStateException("No se han seleccionado items para el pedido.");
        }
        return itemsPorPedido;
    }

    public Double getMontoBaseItemsSeleccionados() {
        if (montoBasePedido == null || montoBasePedido <= 0) {
            throw new IllegalStateException("El monto base del pedido no ha sido calculado.");
        }
        return montoBasePedido;
    }

    public Vendedor getVendedorSeleccionado() {
        if (vendedorSeleccionado == null) {
            throw new IllegalStateException("No se ha seleccionado un vendedor.");
        }
        return vendedorSeleccionado;
    }
    
    
    public static void main(String args[]) {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAceptar;
    private javax.swing.JButton BotonCancelar;
    private javax.swing.JPanel PanelAgregarItems;
    private javax.swing.JPanel PanelItemsPorVendedor;
    private javax.swing.JPanel PanelVendedores;
    private javax.swing.JTable TablaItemsAgregados;
    private javax.swing.JTable TablaItemsPorVendedor;
    private javax.swing.JTable TablaVendedor1;
    private javax.swing.JLabel TituloPantalla;
    private javax.swing.JButton botonAgregarItem;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonVendedor;
    private javax.swing.JTextField campoCantidad;
    private javax.swing.JTextField campoID;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoPrecio;
    private javax.swing.JComboBox<String> comboBoxCategoria;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel titCantidad;
    private javax.swing.JLabel tituloTablaVendedores;
    // End of variables declaration//GEN-END:variables

    
}
