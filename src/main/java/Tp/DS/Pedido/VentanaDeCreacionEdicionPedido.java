package Tp.DS.Pedido;

import Tp.DS.Pedido.MenuPedidos;
import Tp.DS.Cliente.Cliente;
import Tp.DS.Pedido.PedidoController;
import Tp.DS.Pedido.DAOPedido;
import Tp.DS.MetodoPago.Efectivo;
import Tp.DS.Pedido.PedidoMemory;
import Tp.DS.MetodoPago.MercadoPago;
import Tp.DS.MetodoPago.Pago;
import Tp.DS.Vendedor.Vendedor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VentanaDeCreacionEdicionPedido extends javax.swing.JFrame {
    private MenuPedidos menuPedido;
    private PedidoController pedidoController;
    private Pedido pedidoActual;
    private int filaSeleccionada=100;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private Cliente clienteSeleccionado;
    
    public void setMenuPedido(MenuPedidos menuPedido) {
        this.menuPedido = menuPedido;
    }
    public void setTitulo() {
        tituloPrincipal.setText("Editar Pedido");
    }
    
    
    public VentanaDeCreacionEdicionPedido(PedidoController pedidoController) {
        this.pedidoController = pedidoController;
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
        tituloPrincipal = new javax.swing.JLabel();
        titFechaDePago = new javax.swing.JLabel();
        campoFechaDePago = new javax.swing.JTextField();
        titEstadoPedido = new javax.swing.JLabel();
        titMontoTotal = new javax.swing.JLabel();
        campoMontoTotal = new javax.swing.JTextField();
        comboBoxEstadoPedido = new javax.swing.JComboBox<>();
        comboBoxMetodoDePago = new javax.swing.JComboBox<>();
        BotonSeleccionarVendedor = new javax.swing.JButton();
        BotonCrearItemPedido = new javax.swing.JButton();
        campoVendedorSeleccionado = new javax.swing.JTextField();
        campoMetodoPago1 = new javax.swing.JTextField();
        campoMetodoPago2 = new javax.swing.JTextField();
        textMetodoPago1 = new javax.swing.JLabel();
        textMetodoPago2 = new javax.swing.JLabel();

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
        comboBoxMetodoDePago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EFECTIVO", "MERCADO PAGO", "TRANSFERENCIA" }));

        BotonSeleccionarVendedor.setBackground(new java.awt.Color(123, 36, 28));
        BotonSeleccionarVendedor.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        BotonSeleccionarVendedor.setForeground(new java.awt.Color(255, 255, 255));
        BotonSeleccionarVendedor.setText("Seleccionar Vendedor");
        BotonSeleccionarVendedor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        BotonSeleccionarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSeleccionarVendedorActionPerformed(evt);
            }
        });

        BotonCrearItemPedido.setBackground(new java.awt.Color(123, 36, 28));
        BotonCrearItemPedido.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        BotonCrearItemPedido.setForeground(new java.awt.Color(255, 255, 255));
        BotonCrearItemPedido.setText("Cargar Items");
        BotonCrearItemPedido.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        BotonCrearItemPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCrearItemPedidoActionPerformed(evt);
            }
        });

        campoVendedorSeleccionado.setBackground(new java.awt.Color(123, 36, 28));
        campoVendedorSeleccionado.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoVendedorSeleccionado.setForeground(new java.awt.Color(255, 255, 255));
        campoVendedorSeleccionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoVendedorSeleccionadoActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout panelEditableLayout = new javax.swing.GroupLayout(panelEditable);
        panelEditable.setLayout(panelEditableLayout);
        panelEditableLayout.setHorizontalGroup(
            panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditableLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelEditableLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelEditableLayout.createSequentialGroup()
                                .addComponent(BotonSeleccionarVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotonCrearItemPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelEditableLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(titMetodoDePago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboBoxMetodoDePago, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(titMontoBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoMontoBase, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEditableLayout.createSequentialGroup()
                                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(titEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboBoxEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoMetodoPago1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textMetodoPago1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(28, 28, 28)
                                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(campoMetodoPago2, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(titFechaDePago, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campoFechaDePago, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(textMetodoPago2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(campoVendedorSeleccionado, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEditableLayout.createSequentialGroup()
                                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEditableLayout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelEditableLayout.createSequentialGroup()
                                        .addGap(80, 80, 80)
                                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(titMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(13, 13, 13))))
        );
        panelEditableLayout.setVerticalGroup(
            panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoVendedorSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonSeleccionarVendedor)
                    .addComponent(BotonCrearItemPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titMetodoDePago)
                    .addComponent(titMontoBase))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxMetodoDePago, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoMontoBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textMetodoPago1)
                    .addComponent(textMetodoPago2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoMetodoPago1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoMetodoPago2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titFechaDePago)
                    .addComponent(titEstadoPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoFechaDePago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titMontoTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panelEditable, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        String regexFecha = "^\\d{2}/\\d{2}/\\d{4}$"; // Formato de fecha: dd/MM/yyyy
        String regexNumero = "^\\d*(\\.\\d+)?$"; // Formato para números decimales positivos
        
        if (campoMontoBase.getText().matches(regexNumero)  && !campoMontoBase.getText().isEmpty()
            && campoMontoTotal.getText().matches(regexNumero)  && !campoMontoTotal.getText().isEmpty()
            && campoFechaDePago.getText().matches(regexFecha) && !campoFechaDePago.getText().isEmpty()
            && !campoCliente.getText().isEmpty()  
            && !campoItemsPedido.getText().isEmpty()) {
            Cliente clientePedido = new Cliente(campoCliente.getText());
            Pago pagoPedido = null;
            switch (comboBoxMetodoDePago.getSelectedItem().toString()){
                case "EFECTIVO":
                    pagoPedido = new Efectivo();
                    break;
                case "MERCADO PAGO":
                    pagoPedido = new MercadoPago("alias");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Método de pago no reconocido", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
            if(filaSeleccionada==100) {
                // harcodeo porque no puedo obtener los datos ya que los DAO no van a estar creados hasta la proxima etapa
                
                
                Pedido pedidoActual = pedidoController.crearRetornarPedido(clientePedido, pagoPedido);
                /* hacer la logica para setear todo lo de la interfaz en el pedido
                pedidoActual.setItemsPedido(campoItemsPedido.getText());
                pedidoActual.setEstado(comboBoxEstadoPedido.getSelectedItem().toString());
                
*/
                try {
                    Date fechaPago = dateFormat.parse(campoFechaDePago.getText());
                    pedidoActual.setFechaPago(fechaPago);
                } catch (ParseException ex) {
                    Logger.getLogger(VentanaDeCreacionEdicionPedido.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                pedidoActual.setMontoBase(Double.parseDouble(campoMontoBase.getText()));
                pedidoActual.setMontoTotal(Double.parseDouble(campoMontoTotal.getText()));
                JOptionPane.showMessageDialog(null, "Creado con Éxito", null, JOptionPane.INFORMATION_MESSAGE);
            } else {
                
                try {
                    Date fechaPago = dateFormat.parse(campoFechaDePago.getText());
                    pedidoActual.setFechaPago(fechaPago);
                } catch (ParseException ex) {
                    Logger.getLogger(VentanaDeCreacionEdicionPedido.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                pedidoActual.setMontoBase(Double.parseDouble(campoMontoBase.getText()));
                pedidoActual.setMontoTotal(Double.parseDouble(campoMontoTotal.getText()));
                pedidoController.modificarPedido(pedidoActual.getId(), clientePedido, pagoPedido);
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

    private void BotonSeleccionarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSeleccionarVendedorActionPerformed

        VentanaAsignarClienteDePedido nuevaVentana = new VentanaAsignarClienteDePedido(this, clienteController);
        nuevaVentana.setPantallaAgregarCliente(this);
        nuevaVentana.setVisible(true);
        nuevaVentana.setLocationRelativeTo(null);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                Cliente clienteSeleccionado = nuevaVentana.getClienteSeleccionado();
                if (clienteSeleccionado != null) {
                    setClienteSeleccionado(clienteSeleccionado);
                }
            }
        });
    }//GEN-LAST:event_BotonSeleccionarVendedorActionPerformed

    public void setClienteSeleccionado(Cliente cliente) {
        this.clienteSeleccionado = cliente;
        if (cliente != null) {
            campoVendedorSeleccionado.setText(cliente.getNombre()); 
        }
    }
    private void BotonCrearItemPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCrearItemPedidoActionPerformed
        
    }//GEN-LAST:event_BotonCrearItemPedidoActionPerformed

    private void campoVendedorSeleccionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoVendedorSeleccionadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoVendedorSeleccionadoActionPerformed

    public static void main(String args[]) {
        DAOPedido pedidoDAO = PedidoMemory.getInstance();
        PedidoController pedidoController = PedidoController.getInstance(pedidoDAO);
        java.awt.EventQueue.invokeLater(() -> {
            new VentanaDeCreacionEdicionPedido(pedidoController).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCrearItemPedido;
    private javax.swing.JButton BotonSeleccionarVendedor;
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JTextField campoFechaDePago;
    private javax.swing.JTextField campoMetodoPago1;
    private javax.swing.JTextField campoMetodoPago2;
    private javax.swing.JTextField campoMontoBase;
    private javax.swing.JTextField campoMontoTotal;
    private javax.swing.JTextField campoVendedorSeleccionado;
    private javax.swing.JComboBox<String> comboBoxEstadoPedido;
    private javax.swing.JComboBox<String> comboBoxMetodoDePago;
    private javax.swing.JPanel panelEditable;
    private javax.swing.JLabel textMetodoPago1;
    private javax.swing.JLabel textMetodoPago2;
    private javax.swing.JLabel titEstadoPedido;
    private javax.swing.JLabel titFechaDePago;
    private javax.swing.JLabel titMetodoDePago;
    private javax.swing.JLabel titMontoBase;
    private javax.swing.JLabel titMontoTotal;
    private javax.swing.JLabel tituloPrincipal;
    // End of variables declaration//GEN-END:variables
}
