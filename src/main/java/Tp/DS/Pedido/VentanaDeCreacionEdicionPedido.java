package Tp.DS.Pedido;

import Tp.DS.Cliente.*;
import Tp.DS.ItemMenu.*;
import Tp.DS.ItemPedido.*;
import Tp.DS.MetodoPago.*;
import Tp.DS.Vendedor.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentanaDeCreacionEdicionPedido extends javax.swing.JFrame {
    private MenuPedidos menuPedido;
    private Pedido pedidoActual;
    private int filaSeleccionada=100;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    private DAOVendedor vendedorDAO = VendedorMemory.getInstance();
    private VendedorController vendedorController = VendedorController.getInstance(vendedorDAO);
    private DAOCliente clienteDAO = ClienteMemory.getInstance();
    private ClienteController clienteController = ClienteController.getInstance(clienteDAO);
    private DAOItemMenu itemMenuDAO = ItemMenuMemory.getInstance();
    private ItemMenuController itemMenuController = ItemMenuController.getInstance(itemMenuDAO);
    private DAOPedido pedidoDAO = PedidoMemory.getInstance();
    private PedidoController pedidoController = PedidoController.getInstance(pedidoDAO);
    private DAOItemsPedido itemPedidoDAO = ItemPedidoMemory.getInstance();
    private ItemsPedidoController itemPedidoController = ItemsPedidoController.getInstance(itemPedidoDAO, pedidoController,itemMenuController);
    private Vendedor vendedorSeleccionado;
    private Cliente clienteSeleccionado;
    private List<ItemsPedido> itemsAsignados;
    
    public void setMenuPedido(MenuPedidos menuPedido) {
        this.menuPedido = menuPedido;
    }
    public void setTitulo() {
        tituloPrincipal.setText("Editar Pedido");
    }
    public void setItemsAsignadosAlPedido(List<ItemsPedido> ip) {
        this.itemsAsignados = ip;

        if (ip.isEmpty()) {
            campoItems.setText("No hay ítems asignados.");
        } else { 
            StringBuilder items = new StringBuilder();
            for (ItemsPedido item : ip) {
                items.append(item.getItemMenu().getNombre()).append(", ");
            }
            campoItems.setText(items.toString());
        }
    }
    
    public VentanaDeCreacionEdicionPedido(PedidoController pedidoController) {
        this.pedidoController = pedidoController;
        initComponents();
        cargarClientesAsociadosEnTabla();
    }
    public void recibirDatosEdicion(int filaSeleccionada, Pedido pedido) {
        this.filaSeleccionada = filaSeleccionada;
        this.pedidoActual = pedido;
        if (!pedidoActual.getItemsPedido().isEmpty()) {
            Vendedor vendedorItem = pedidoActual.getItemsPedido().getFirst().getItemMenu().getVendedor();
            campoVendedorSeleccionado.setText(vendedorItem.getNombre());
        }
        String items = pedidoController.obtenerNombresItems(pedidoActual);
        campoItems.setText(items);
        comboBoxMetodoDePago.setSelectedItem(pedidoActual.getMetodoPago().getClass().getName());
        campoMontoBase.setText(Double.toString(pedidoActual.getMontoBase()));
        campoMontoTotal.setText(Double.toString(pedidoActual.getMontoBase()));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        panelEditable = new javax.swing.JPanel();
        botonCancelar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        campoMontoBase = new javax.swing.JTextField();
        titMontoBase = new javax.swing.JLabel();
        titMetodoDePago = new javax.swing.JLabel();
        tituloPrincipal = new javax.swing.JLabel();
        titMontoTotal = new javax.swing.JLabel();
        campoMontoTotal = new javax.swing.JTextField();
        comboBoxMetodoDePago = new javax.swing.JComboBox<>();
        BotonBuscarItems = new javax.swing.JButton();
        campoVendedorSeleccionado = new javax.swing.JTextField();
        campoMetodoPago1 = new javax.swing.JTextField();
        campoMetodoPago2 = new javax.swing.JTextField();
        textMetodoPago1 = new javax.swing.JLabel();
        textMetodoPago2 = new javax.swing.JLabel();
        campoItems = new javax.swing.JTextField();
        textMetodoPago3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaClientes = new javax.swing.JTable();
        campoClienteSeleccionado = new javax.swing.JTextField();
        BotonAgregarCliente = new javax.swing.JButton();

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

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

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
        botonCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
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
        botonAceptar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
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

        comboBoxMetodoDePago.setBackground(new java.awt.Color(123, 36, 28));
        comboBoxMetodoDePago.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        comboBoxMetodoDePago.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxMetodoDePago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EFECTIVO", "MERCADO PAGO", "TRANSFERENCIA" }));
        comboBoxMetodoDePago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxMetodoDePagoActionPerformed(evt);
            }
        });

        BotonBuscarItems.setBackground(new java.awt.Color(123, 36, 28));
        BotonBuscarItems.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        BotonBuscarItems.setForeground(new java.awt.Color(255, 255, 255));
        BotonBuscarItems.setText("Buscar Items");
        BotonBuscarItems.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        BotonBuscarItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarItemsActionPerformed(evt);
            }
        });

        campoVendedorSeleccionado.setBackground(new java.awt.Color(123, 36, 28));
        campoVendedorSeleccionado.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoVendedorSeleccionado.setForeground(new java.awt.Color(255, 255, 255));

        campoMetodoPago1.setBackground(new java.awt.Color(123, 36, 28));
        campoMetodoPago1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoMetodoPago1.setForeground(new java.awt.Color(255, 255, 255));

        campoMetodoPago2.setBackground(new java.awt.Color(123, 36, 28));
        campoMetodoPago2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoMetodoPago2.setForeground(new java.awt.Color(255, 255, 255));

        textMetodoPago1.setBackground(new java.awt.Color(123, 35, 27));
        textMetodoPago1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        textMetodoPago1.setForeground(new java.awt.Color(255, 255, 255));
        textMetodoPago1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textMetodoPago1.setText("CUIT");
        textMetodoPago1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textMetodoPago1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        textMetodoPago1.setInheritsPopupMenu(false);

        textMetodoPago2.setBackground(new java.awt.Color(123, 35, 27));
        textMetodoPago2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        textMetodoPago2.setForeground(new java.awt.Color(255, 255, 255));
        textMetodoPago2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textMetodoPago2.setText("ALIAS/CBU");
        textMetodoPago2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textMetodoPago2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        textMetodoPago2.setInheritsPopupMenu(false);

        campoItems.setBackground(new java.awt.Color(123, 36, 28));
        campoItems.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoItems.setForeground(new java.awt.Color(255, 255, 255));

        textMetodoPago3.setBackground(new java.awt.Color(123, 35, 27));
        textMetodoPago3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        textMetodoPago3.setForeground(new java.awt.Color(255, 255, 255));
        textMetodoPago3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textMetodoPago3.setText("Items:");
        textMetodoPago3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textMetodoPago3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        textMetodoPago3.setInheritsPopupMenu(false);

        TablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Cuit", "Nombre", "Direccion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaClientes.setColumnSelectionAllowed(true);
        TablaClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TablaClientes);
        TablaClientes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (TablaClientes.getColumnModel().getColumnCount() > 0) {
            TablaClientes.getColumnModel().getColumn(0).setResizable(false);
            TablaClientes.getColumnModel().getColumn(1).setResizable(false);
            TablaClientes.getColumnModel().getColumn(2).setResizable(false);
            TablaClientes.getColumnModel().getColumn(3).setResizable(false);
        }

        campoClienteSeleccionado.setBackground(new java.awt.Color(123, 36, 28));
        campoClienteSeleccionado.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoClienteSeleccionado.setForeground(new java.awt.Color(255, 255, 255));

        BotonAgregarCliente.setBackground(new java.awt.Color(123, 36, 28));
        BotonAgregarCliente.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        BotonAgregarCliente.setForeground(new java.awt.Color(255, 255, 255));
        BotonAgregarCliente.setText("Agregar Cliente:");
        BotonAgregarCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        BotonAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEditableLayout = new javax.swing.GroupLayout(panelEditable);
        panelEditable.setLayout(panelEditableLayout);
        panelEditableLayout.setHorizontalGroup(
            panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditableLayout.createSequentialGroup()
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tituloPrincipal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEditableLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelEditableLayout.createSequentialGroup()
                                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(titMetodoDePago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboBoxMetodoDePago, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(titMontoBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoMontoBase, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelEditableLayout.createSequentialGroup()
                                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelEditableLayout.createSequentialGroup()
                                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(campoMetodoPago1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                            .addComponent(textMetodoPago1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(28, 28, 28)
                                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textMetodoPago2, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                            .addComponent(campoMetodoPago2)))
                                    .addGroup(panelEditableLayout.createSequentialGroup()
                                        .addGap(83, 83, 83)
                                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(titMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelEditableLayout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEditableLayout.createSequentialGroup()
                                            .addComponent(BotonBuscarItems, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(campoVendedorSeleccionado))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEditableLayout.createSequentialGroup()
                                            .addComponent(textMetodoPago3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(campoItems, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panelEditableLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BotonAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoClienteSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(431, 431, 431))
        );
        panelEditableLayout.setVerticalGroup(
            panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoVendedorSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonBuscarItems))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textMetodoPago3)
                    .addComponent(campoItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoClienteSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonAgregarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titMetodoDePago)
                    .addComponent(titMontoBase))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxMetodoDePago, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoMontoBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textMetodoPago1)
                    .addComponent(textMetodoPago2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoMetodoPago1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoMetodoPago2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titMontoTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        getContentPane().add(panelEditable, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonBuscarItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarItemsActionPerformed

        VentanaCrearItemPedido nuevaVentana = new VentanaCrearItemPedido(this, vendedorController, pedidoController, itemMenuController, itemPedidoController);
        nuevaVentana.setVisible(true);
        nuevaVentana.setLocationRelativeTo(null);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                Vendedor vendedorSeleccionado = nuevaVentana.getVendedorSeleccionado();
                List<ItemsPedido> itemsVentana = nuevaVentana.getItemsPedidoSeleccionados();
                if (vendedorSeleccionado != null && !itemsVentana.isEmpty()) {
                    setVendedorSeleccionado(vendedorSeleccionado);
                    setItemsAsignadosAlPedido(itemsVentana);
                    campoMontoBase.setText(nuevaVentana.getMontoBaseItemsSeleccionados().toString());
                }
            }
        });
    }//GEN-LAST:event_BotonBuscarItemsActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        String regexNumero = "^\\d*(\\.\\d+)?$";

        // Verificación de campos y condiciones necesarias para crear o modificar el pedido
        if (campoMontoBase.getText().matches(regexNumero) && !campoMontoBase.getText().isEmpty()
                && campoMontoTotal.getText().matches(regexNumero) && !campoMontoTotal.getText().isEmpty()
                && itemsAsignados != null && !itemsAsignados.isEmpty() && clienteSeleccionado != null) {

            // Obtención del método de pago seleccionado y creación del pago correspondiente
            String metodoPagoSeleccionado = comboBoxMetodoDePago.getSelectedItem().toString().toLowerCase();
            Pago pagoPedido = FactoryPago.crearPago(metodoPagoSeleccionado, campoMetodoPago1.getText(), campoMetodoPago2.getText());

            // Verifica si es una creación de nuevo pedido o edición de uno existente
            if (filaSeleccionada == 100) { // Condición de creación de pedido (hardcodeo por falta de DAO en esta etapa)
                Pedido pedidoActual = pedidoController.crearRetornarPedido(clienteSeleccionado, pagoPedido);
                pedidoActual.setItemsPedido(itemsAsignados);

                // Configuración de fecha de pago y otros atributos del pedido
                pedidoActual.setFechaPago(new Date());
                pedidoActual.setMontoBase(Double.parseDouble(campoMontoBase.getText()));
                pedidoActual.setMontoTotal(Double.parseDouble(campoMontoTotal.getText()));
                pedidoController.modificarPedido(pedidoActual.getId(), clienteSeleccionado, pagoPedido);
                JOptionPane.showMessageDialog(null, "Pedido creado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            } else { // Condición de edición de pedido existente
                pedidoActual.setItemsPedido(itemsAsignados);
                pedidoActual.setFechaPago(new Date());
                pedidoActual.setMontoBase(Double.parseDouble(campoMontoBase.getText()));
                pedidoActual.setMontoTotal(Double.parseDouble(campoMontoTotal.getText()));

                pedidoController.modificarPedido(pedidoActual.getId(), clienteSeleccionado, pagoPedido);
                JOptionPane.showMessageDialog(null, "Pedido editado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }

            // Cierra la ventana después de la acción
            dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Formato inválido o campos incompletos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void BotonAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarClienteActionPerformed
        int filaVendedorSeleccionada = TablaClientes.getSelectedRow();

        if (filaVendedorSeleccionada != -1) { 
            int idCliente = (int) TablaClientes.getValueAt(filaVendedorSeleccionada, 0);
            clienteSeleccionado = clienteController.buscarCliente(idCliente);
            campoClienteSeleccionado.setText(clienteSeleccionado.getNombre());
        }else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un Cliente.");
        }
    }//GEN-LAST:event_BotonAgregarClienteActionPerformed

    private void comboBoxMetodoDePagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxMetodoDePagoActionPerformed
        String pagoSeleccionado = (String) comboBoxMetodoDePago.getSelectedItem();
        Double montoTotal;
        Pago pagoPedido;
        textMetodoPago1.setVisible(false);
        textMetodoPago2.setVisible(false);
        textMetodoPago3.setVisible(false);
        campoMetodoPago1.setVisible(false);
        campoMetodoPago2.setVisible(false);
		
        if ("TRANSFERENCIA".equals(pagoSeleccionado)) {
            textMetodoPago1.setVisible(true);
            textMetodoPago2.setVisible(true);
            textMetodoPago3.setVisible(true);
            campoMetodoPago1.setVisible(true);
            campoMetodoPago2.setVisible(true);
            pagoPedido = FactoryPago.crearPago("Transferencia",campoMetodoPago1.getText(),campoMetodoPago2.getText());
            montoTotal = pedidoController.calcularMontoTotal(Double.valueOf(campoMontoBase.getText()), pagoPedido);
            campoMontoTotal.setText(montoTotal.toString());
        } else if ("MERCADOPAGO".equals(pagoSeleccionado)) {
            textMetodoPago1.setVisible(true);
            campoMetodoPago1.setVisible(true);
            pagoPedido = FactoryPago.crearPago("MercadoPago", campoMetodoPago1.getText(), "");
            montoTotal = pedidoController.calcularMontoTotal(Double.valueOf(campoMontoBase.getText()), pagoPedido);
            campoMontoTotal.setText(montoTotal.toString());
        } else if ("EFECTIVO".equals(pagoSeleccionado)) {
            pagoPedido = FactoryPago.crearPago("Efectivo", "", "");
            campoMontoTotal.setText(campoMontoBase.getText());
        }

        // refrescar la ventana para aplicar los cambios de visibilidad
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_comboBoxMetodoDePagoActionPerformed

    private void cargarClientesAsociadosEnTabla(){
        DefaultTableModel model = (DefaultTableModel) TablaClientes.getModel();
        model.setRowCount(0); // Limpiar tabla
        List<Cliente> listaClientes = clienteController.mostrarClientes();
        if (listaClientes != null) {
            for (Cliente cliente : listaClientes) {
                model.addRow(new Object[]{
                    cliente.getId(),
                    cliente.getCuit(),
                    cliente.getNombre(),
                    cliente.getDireccion()});
            }
        }else {
            JOptionPane.showMessageDialog(this, "No hay ningún Cliente cargado");
        }
    }
    
    public void setVendedorSeleccionado(Vendedor vendedor) {
        this.vendedorSeleccionado = vendedor;
        if (vendedor != null) {
            campoVendedorSeleccionado.setText(vendedor.getNombre()); 
        }
    }
    public static void main(String args[]) {
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAgregarCliente;
    private javax.swing.JButton BotonBuscarItems;
    private javax.swing.JTable TablaClientes;
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JTextField campoClienteSeleccionado;
    private javax.swing.JTextField campoItems;
    private javax.swing.JTextField campoMetodoPago1;
    private javax.swing.JTextField campoMetodoPago2;
    private javax.swing.JTextField campoMontoBase;
    private javax.swing.JTextField campoMontoTotal;
    private javax.swing.JTextField campoVendedorSeleccionado;
    private javax.swing.JComboBox<String> comboBoxMetodoDePago;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JPanel panelEditable;
    private javax.swing.JLabel textMetodoPago1;
    private javax.swing.JLabel textMetodoPago2;
    private javax.swing.JLabel textMetodoPago3;
    private javax.swing.JLabel titMetodoDePago;
    private javax.swing.JLabel titMontoBase;
    private javax.swing.JLabel titMontoTotal;
    private javax.swing.JLabel tituloPrincipal;
    // End of variables declaration//GEN-END:variables
}
