package Tp.DS.Pedido;

import Tp.DS.Cliente.*;
import Tp.DS.ItemMenu.*;
import Tp.DS.ItemPedido.*;
import Tp.DS.MetodoPago.*;
import Tp.DS.Vendedor.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentanaDeCreacionEdicionPedido extends javax.swing.JFrame {
    private Pedido pedidoActual;
    private int filaSeleccionada=100;
    
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
    private Cliente clienteSeleccionado;
    private List<ItemsPedido> itemsAsignados;
    
    public VentanaDeCreacionEdicionPedido(PedidoController pedidoController) {
        this.pedidoController = pedidoController;
        initComponents();
        textMetodoPago1.setVisible(false);
        textMetodoPago2.setVisible(false);
        campoMetodoPago1.setVisible(false);
        campoMetodoPago2.setVisible(false);
        cargarClientesAsociadosEnTabla();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        panelEditable = new javax.swing.JPanel();
        tituloPrincipal = new javax.swing.JLabel();
        BotonBuscarItems = new javax.swing.JButton();
        campoVendedorSeleccionado = new javax.swing.JTextField();
        campoItems = new javax.swing.JTextField();
        tituloItems = new javax.swing.JLabel();
        PanelClientes = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaClientes = new javax.swing.JTable();
        BotonAgregarCliente = new javax.swing.JButton();
        campoClienteSeleccionado = new javax.swing.JTextField();
        PanelPago = new javax.swing.JPanel();
        titMetodoDePago = new javax.swing.JLabel();
        comboBoxMetodoDePago = new javax.swing.JComboBox<>();
        titMontoBase = new javax.swing.JLabel();
        campoMontoBase = new javax.swing.JTextField();
        textMetodoPago1 = new javax.swing.JLabel();
        campoMetodoPago1 = new javax.swing.JTextField();
        textMetodoPago2 = new javax.swing.JLabel();
        campoMetodoPago2 = new javax.swing.JTextField();
        PanelFinal = new javax.swing.JPanel();
        titMontoTotal = new javax.swing.JLabel();
        campoMontoTotal = new javax.swing.JTextField();
        botonCancelar = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();

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

        campoItems.setBackground(new java.awt.Color(123, 36, 28));
        campoItems.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoItems.setForeground(new java.awt.Color(255, 255, 255));

        tituloItems.setBackground(new java.awt.Color(123, 35, 27));
        tituloItems.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tituloItems.setForeground(new java.awt.Color(255, 255, 255));
        tituloItems.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloItems.setText("Items:");
        tituloItems.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tituloItems.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tituloItems.setInheritsPopupMenu(false);

        PanelClientes.setBackground(new java.awt.Color(69, 69, 69));

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
        TablaClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TablaClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TablaClientes);
        TablaClientes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (TablaClientes.getColumnModel().getColumnCount() > 0) {
            TablaClientes.getColumnModel().getColumn(0).setResizable(false);
            TablaClientes.getColumnModel().getColumn(1).setResizable(false);
            TablaClientes.getColumnModel().getColumn(2).setResizable(false);
            TablaClientes.getColumnModel().getColumn(3).setResizable(false);
        }
        TablaClientes.getAccessibleContext().setAccessibleParent(PanelClientes);

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

        campoClienteSeleccionado.setBackground(new java.awt.Color(123, 36, 28));
        campoClienteSeleccionado.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoClienteSeleccionado.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelClientesLayout = new javax.swing.GroupLayout(PanelClientes);
        PanelClientes.setLayout(PanelClientesLayout);
        PanelClientesLayout.setHorizontalGroup(
            PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClientesLayout.createSequentialGroup()
                .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(PanelClientesLayout.createSequentialGroup()
                        .addComponent(BotonAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoClienteSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelClientesLayout.setVerticalGroup(
            PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClientesLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonAgregarCliente)
                    .addComponent(campoClienteSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        PanelPago.setBackground(new java.awt.Color(69, 69, 69));

        titMetodoDePago.setBackground(new java.awt.Color(123, 35, 27));
        titMetodoDePago.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        titMetodoDePago.setForeground(new java.awt.Color(255, 255, 255));
        titMetodoDePago.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titMetodoDePago.setText("Método de Pago");
        titMetodoDePago.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        titMetodoDePago.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titMetodoDePago.setInheritsPopupMenu(false);

        comboBoxMetodoDePago.setBackground(new java.awt.Color(123, 36, 28));
        comboBoxMetodoDePago.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        comboBoxMetodoDePago.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxMetodoDePago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EFECTIVO", "MERCADO PAGO", "TRANSFERENCIA" }));
        comboBoxMetodoDePago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxMetodoDePagoActionPerformed(evt);
            }
        });

        titMontoBase.setBackground(new java.awt.Color(123, 35, 27));
        titMontoBase.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        titMontoBase.setForeground(new java.awt.Color(255, 255, 255));
        titMontoBase.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titMontoBase.setText("Monto Base");
        titMontoBase.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        titMontoBase.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titMontoBase.setInheritsPopupMenu(false);

        campoMontoBase.setBackground(new java.awt.Color(123, 36, 28));
        campoMontoBase.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoMontoBase.setForeground(new java.awt.Color(255, 255, 255));

        textMetodoPago1.setBackground(new java.awt.Color(123, 35, 27));
        textMetodoPago1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        textMetodoPago1.setForeground(new java.awt.Color(255, 255, 255));
        textMetodoPago1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textMetodoPago1.setText("CUIT");
        textMetodoPago1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textMetodoPago1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        textMetodoPago1.setInheritsPopupMenu(false);

        campoMetodoPago1.setBackground(new java.awt.Color(123, 36, 28));
        campoMetodoPago1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoMetodoPago1.setForeground(new java.awt.Color(255, 255, 255));
        campoMetodoPago1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        textMetodoPago2.setBackground(new java.awt.Color(123, 35, 27));
        textMetodoPago2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        textMetodoPago2.setForeground(new java.awt.Color(255, 255, 255));
        textMetodoPago2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textMetodoPago2.setText("ALIAS/CBU");
        textMetodoPago2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textMetodoPago2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        textMetodoPago2.setInheritsPopupMenu(false);

        campoMetodoPago2.setBackground(new java.awt.Color(123, 36, 28));
        campoMetodoPago2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoMetodoPago2.setForeground(new java.awt.Color(255, 255, 255));
        campoMetodoPago2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout PanelPagoLayout = new javax.swing.GroupLayout(PanelPago);
        PanelPago.setLayout(PanelPagoLayout);
        PanelPagoLayout.setHorizontalGroup(
            PanelPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPagoLayout.createSequentialGroup()
                .addGroup(PanelPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(campoMetodoPago1)
                        .addComponent(textMetodoPago1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                    .addGroup(PanelPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(titMetodoDePago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboBoxMetodoDePago, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(PanelPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPagoLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(PanelPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titMontoBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoMontoBase, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPagoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textMetodoPago2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoMetodoPago2, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))))
                .addContainerGap())
        );
        PanelPagoLayout.setVerticalGroup(
            PanelPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPagoLayout.createSequentialGroup()
                .addGroup(PanelPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPagoLayout.createSequentialGroup()
                        .addComponent(titMetodoDePago)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxMetodoDePago, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPagoLayout.createSequentialGroup()
                        .addComponent(titMontoBase)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoMontoBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPagoLayout.createSequentialGroup()
                        .addComponent(textMetodoPago1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoMetodoPago1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPagoLayout.createSequentialGroup()
                        .addComponent(textMetodoPago2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoMetodoPago2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        PanelFinal.setBackground(new java.awt.Color(69, 69, 69));

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

        javax.swing.GroupLayout PanelFinalLayout = new javax.swing.GroupLayout(PanelFinal);
        PanelFinal.setLayout(PanelFinalLayout);
        PanelFinalLayout.setHorizontalGroup(
            PanelFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFinalLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelFinalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95))
        );
        PanelFinalLayout.setVerticalGroup(
            PanelFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFinalLayout.createSequentialGroup()
                .addComponent(titMontoTotal)
                .addGap(1, 1, 1)
                .addComponent(campoMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelFinalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelEditableLayout = new javax.swing.GroupLayout(panelEditable);
        panelEditable.setLayout(panelEditableLayout);
        panelEditableLayout.setHorizontalGroup(
            panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditableLayout.createSequentialGroup()
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tituloPrincipal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEditableLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEditableLayout.createSequentialGroup()
                                .addComponent(BotonBuscarItems, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoVendedorSeleccionado))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEditableLayout.createSequentialGroup()
                                .addComponent(tituloItems)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoItems, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(431, 431, 431))
            .addGroup(panelEditableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(tituloItems)
                    .addComponent(campoItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(panelEditable, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 520));

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
                    campoMontoTotal.setText(nuevaVentana.getMontoBaseItemsSeleccionados().toString());
                }
            }
        });
    }//GEN-LAST:event_BotonBuscarItemsActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        String regexNumero = "^\\d*(\\.\\d+)?$";

        if (!campoMontoBase.getText().matches(regexNumero) || campoMontoBase.getText().isEmpty() 
                || !campoMontoTotal.getText().matches(regexNumero) || campoMontoTotal.getText().isEmpty()  
                || itemsAsignados == null || itemsAsignados.isEmpty() || clienteSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Campos Incompletos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (clienteSeleccionado == null) {
            clienteSeleccionado = pedidoActual.getCliente();
        }

        if (itemsAsignados == null || itemsAsignados.isEmpty()) {
            itemsAsignados = pedidoActual.getItemsPedido();
        }

        if (clienteSeleccionado == null || itemsAsignados == null || itemsAsignados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cliente o items no seleccionados.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String metodoPagoSeleccionado = comboBoxMetodoDePago.getSelectedItem().toString().toLowerCase();
        Pago pagoPedido = FactoryPago.crearPago(metodoPagoSeleccionado, campoMetodoPago1.getText(), campoMetodoPago2.getText());

        if (filaSeleccionada == 100) {
            Pedido pedidoActual = pedidoController.crearRetornarPedido(clienteSeleccionado, pagoPedido);
            pedidoActual.setItemsPedido(itemsAsignados);
            pedidoActual.setFechaPago(new Date());
            pedidoActual.setMontoBase(Double.parseDouble(campoMontoBase.getText()));
            pedidoActual.setMontoTotal(Double.parseDouble(campoMontoTotal.getText()));
            pedidoController.modificarPedido(pedidoActual.getId(), clienteSeleccionado, pagoPedido);
            JOptionPane.showMessageDialog(null, "Pedido creado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            pedidoActual.setItemsPedido(itemsAsignados);
            pedidoActual.setFechaPago(new Date());
            pedidoActual.setMontoBase(Double.parseDouble(campoMontoBase.getText()));
            pedidoActual.setMontoTotal(Double.parseDouble(campoMontoTotal.getText()));
            pedidoController.modificarPedido(pedidoActual.getId(), clienteSeleccionado, pagoPedido);
            JOptionPane.showMessageDialog(null, "Pedido editado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
        dispose();
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
        if (campoMontoBase.getText() == null || campoMontoBase.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe agregar items al pedido antes de seleccionar un método de pago.", "Error", JOptionPane.ERROR_MESSAGE);
            return; 
        }
        String pagoSeleccionado = "EFECTIVO";
        pagoSeleccionado = (String) comboBoxMetodoDePago.getSelectedItem();
        Double montoTotal;
        Pago pagoPedido;
        textMetodoPago1.setVisible(false);
        textMetodoPago2.setVisible(false);
        campoMetodoPago1.setVisible(false);
        campoMetodoPago2.setVisible(false);
		
        if ("TRANSFERENCIA".equals(pagoSeleccionado)) {
            textMetodoPago1.setVisible(true);
            textMetodoPago2.setVisible(true);
            campoMetodoPago1.setVisible(true);
            campoMetodoPago2.setVisible(true);
            pagoPedido = FactoryPago.crearPago("Transferencia",campoMetodoPago1.getText(),campoMetodoPago2.getText());
            montoTotal = pedidoController.calcularMontoTotal(Double.valueOf(campoMontoBase.getText()), pagoPedido);
            campoMontoTotal.setText(montoTotal.toString());
        } else if ("MERCADO PAGO".equals(pagoSeleccionado)) {
            textMetodoPago2.setVisible(true);
            campoMetodoPago2.setVisible(true);
            pagoPedido = FactoryPago.crearPago("Mercado Pago", campoMetodoPago1.getText(), "");
            montoTotal = pedidoController.calcularMontoTotal(Double.valueOf(campoMontoBase.getText()), pagoPedido);
            campoMontoTotal.setText(montoTotal.toString());
        } else if ("EFECTIVO".equals(pagoSeleccionado)) {
            pagoPedido = FactoryPago.crearPago("Efectivo", "", "");
            campoMontoTotal.setText(campoMontoBase.getText());
            montoTotal = pedidoController.calcularMontoTotal(Double.valueOf(campoMontoBase.getText()), pagoPedido);
            campoMontoTotal.setText(montoTotal.toString());
        }

        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_comboBoxMetodoDePagoActionPerformed
    
    public void setMenuPedido(MenuPedidos menuPedido) {
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
    
    public void recibirDatosEdicion(int filaSeleccionada, Pedido pedido) {
        this.filaSeleccionada = filaSeleccionada;
        this.pedidoActual = pedido;
        if (!pedidoActual.getItemsPedido().isEmpty()) {
            Vendedor vendedorItem = pedidoActual.getItemsPedido().get(0).getItemMenu().getVendedor();
            campoVendedorSeleccionado.setText(vendedorItem.getNombre());
        }
        itemsAsignados = pedidoActual.getItemsPedido();
        clienteSeleccionado = pedidoActual.getCliente();
        String items = pedidoController.obtenerNombresItems(pedidoActual);
        campoItems.setText(items);
        campoClienteSeleccionado.setText(pedidoActual.getCliente().getNombre());
        comboBoxMetodoDePago.setSelectedItem(pedidoActual.getMetodoPago().getClass().getName());
        campoMontoBase.setText(Double.toString(pedidoActual.getMontoBase()));
        campoMontoTotal.setText(Double.toString(pedidoActual.getMontoBase()));
    }
    
    private void cargarClientesAsociadosEnTabla(){
        DefaultTableModel model = (DefaultTableModel) TablaClientes.getModel();
        model.setRowCount(0);
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
        if (vendedor != null) {
            campoVendedorSeleccionado.setText(vendedor.getNombre()); 
        }
    }
    public static void main(String args[]) {
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAgregarCliente;
    private javax.swing.JButton BotonBuscarItems;
    private javax.swing.JPanel PanelClientes;
    private javax.swing.JPanel PanelFinal;
    private javax.swing.JPanel PanelPago;
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
    private javax.swing.JLabel titMetodoDePago;
    private javax.swing.JLabel titMontoBase;
    private javax.swing.JLabel titMontoTotal;
    private javax.swing.JLabel tituloItems;
    private javax.swing.JLabel tituloPrincipal;
    // End of variables declaration//GEN-END:variables
}
