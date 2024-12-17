package isi.deso.tpds.ItemMenu;

import isi.deso.tpds.Plato;
import isi.deso.tpds.Bebida;
import isi.deso.tpds.Categoria.Categoria;
import isi.deso.tpds.Vendedor.VendedorController;
import isi.deso.tpds.Exceptions.DAOException;
import isi.deso.tpds.Vendedor.DAOVendedor;
import isi.deso.tpds.Vendedor.VendedorMemory;
import isi.deso.tpds.Vendedor.Vendedor;

import javax.swing.JOptionPane;
import java.awt.*;
import java.util.Objects;

public class VentanaDeCreacionEdicionItemsMenu extends javax.swing.JFrame {
    private int filaSeleccionada=100;
    private final ItemMenuController itemMenuController;
    private ItemMenu itemActual;
    private final VendedorController vendedorController;
    private Vendedor vendedorSeleccionado;

    public VentanaDeCreacionEdicionItemsMenu(ItemMenuController itemMenuController, VendedorController vendedorController) {
        this.itemMenuController = itemMenuController;
        this.vendedorController = vendedorController;
        vendedorController.getVendedorDAO();
        initComponents();
        comboBoxCategoriaItemStateChanged(null);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel panelEditable = new javax.swing.JPanel();
        javax.swing.JLabel tit3 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        tituloPrincipal = new javax.swing.JLabel();
        javax.swing.JLabel tit1 = new javax.swing.JLabel();
        javax.swing.JLabel titFechaDePago = new javax.swing.JLabel();
        campoPrecio = new javax.swing.JTextField();
        javax.swing.JLabel tit2 = new javax.swing.JLabel();
        campoDescripcion = new javax.swing.JTextField();
        javax.swing.JLabel tit5 = new javax.swing.JLabel();
        comboBoxCategoria = new javax.swing.JComboBox<>();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        campoTamanio = new javax.swing.JTextField();
        tit4 = new javax.swing.JLabel();
        tit6 = new javax.swing.JLabel();
        comboBoxAlcohol = new javax.swing.JComboBox<>();
        javax.swing.JPanel jPanel3 = new javax.swing.JPanel();
        tit7 = new javax.swing.JLabel();
        campoPeso = new javax.swing.JTextField();
        tit8 = new javax.swing.JLabel();
        comboBoxAptoVegano = new javax.swing.JComboBox<>();
        campoCalorias = new javax.swing.JTextField();
        tit9 = new javax.swing.JLabel();

        javax.swing.JButton botonAceptar = new javax.swing.JButton();
        javax.swing.JButton botonCancelar = new javax.swing.JButton();
        javax.swing.JButton botonAgregarDesagregarVendedor = new javax.swing.JButton();
        campoVendedorSeleccionado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 400));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelEditable.setBackground(new java.awt.Color(69, 69, 69));
        panelEditable.setAlignmentX(0.0F);
        panelEditable.setAlignmentY(0.0F);
        panelEditable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelEditable.setMaximumSize(new java.awt.Dimension(1000, 1000));
        panelEditable.setMinimumSize(new java.awt.Dimension(500, 500));
        panelEditable.setPreferredSize(new java.awt.Dimension(500, 500));

        tit3.setBackground(new java.awt.Color(123, 35, 27));
        tit3.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        tit3.setForeground(new java.awt.Color(255, 255, 255));
        tit3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit3.setText("Categoría");
        tit3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tit3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit3.setInheritsPopupMenu(false);

        campoNombre.setBackground(new java.awt.Color(123, 36, 28));
        campoNombre.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        campoNombre.setForeground(new java.awt.Color(255, 255, 255));

        tituloPrincipal.setBackground(new java.awt.Color(123, 35, 27));
        tituloPrincipal.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
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
        tit1.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        tit1.setForeground(new java.awt.Color(255, 255, 255));
        tit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit1.setText("Nombre");
        tit1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tit1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit1.setInheritsPopupMenu(false);

        titFechaDePago.setBackground(new java.awt.Color(123, 35, 27));
        titFechaDePago.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        titFechaDePago.setForeground(new java.awt.Color(255, 255, 255));
        titFechaDePago.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titFechaDePago.setText("Precio");
        titFechaDePago.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        titFechaDePago.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titFechaDePago.setInheritsPopupMenu(false);

        campoPrecio.setBackground(new java.awt.Color(123, 36, 28));
        campoPrecio.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        campoPrecio.setForeground(new java.awt.Color(255, 255, 255));

        tit2.setBackground(new java.awt.Color(123, 35, 27));
        tit2.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        tit2.setForeground(new java.awt.Color(255, 255, 255));
        tit2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit2.setText("Descripción");
        tit2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tit2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit2.setInheritsPopupMenu(false);

        campoDescripcion.setBackground(new java.awt.Color(123, 36, 28));
        campoDescripcion.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        campoDescripcion.setForeground(new java.awt.Color(255, 255, 255));

        tit5.setBackground(new java.awt.Color(123, 35, 27));
        tit5.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        tit5.setForeground(new java.awt.Color(255, 255, 255));
        tit5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit5.setText("Vendedor");
        tit5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tit5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit5.setInheritsPopupMenu(false);

        comboBoxCategoria.setBackground(new java.awt.Color(123, 36, 28));
        comboBoxCategoria.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 18)); // NOI18N
        comboBoxCategoria.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PLATO", "BEBIDA" }));
        comboBoxCategoria.setSelectedIndex(1);
        comboBoxCategoria.addItemListener(this::comboBoxCategoriaItemStateChanged);
        comboBoxCategoria.addActionListener(this::comboBoxCategoriaActionPerformed);

        jPanel1.setBackground(new java.awt.Color(69, 69, 69));

        campoTamanio.setBackground(new java.awt.Color(123, 36, 28));
        campoTamanio.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        campoTamanio.setForeground(new java.awt.Color(255, 255, 255));

        tit4.setBackground(new java.awt.Color(123, 35, 27));
        tit4.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        tit4.setForeground(new java.awt.Color(255, 255, 255));
        tit4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit4.setText("Tamaño");
        tit4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tit4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit4.setInheritsPopupMenu(false);

        tit6.setBackground(new java.awt.Color(123, 35, 27));
        tit6.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        tit6.setForeground(new java.awt.Color(255, 255, 255));
        tit6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit6.setText("Alcohólica");
        tit6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tit6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit6.setInheritsPopupMenu(false);

        comboBoxAlcohol.setBackground(new java.awt.Color(123, 36, 28));
        comboBoxAlcohol.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 18)); // NOI18N
        comboBoxAlcohol.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxAlcohol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoTamanio)
                    .addComponent(tit4, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxAlcohol, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tit6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoTamanio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tit6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(comboBoxAlcohol, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(tit4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(69, 69, 69));

        tit7.setBackground(new java.awt.Color(123, 35, 27));
        tit7.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        tit7.setForeground(new java.awt.Color(255, 255, 255));
        tit7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit7.setText("Peso");
        tit7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tit7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit7.setInheritsPopupMenu(false);

        campoPeso.setBackground(new java.awt.Color(123, 36, 28));
        campoPeso.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        campoPeso.setForeground(new java.awt.Color(255, 255, 255));

        tit8.setBackground(new java.awt.Color(123, 35, 27));
        tit8.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        tit8.setForeground(new java.awt.Color(255, 255, 255));
        tit8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit8.setText("Apto Vegano");
        tit8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tit8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit8.setInheritsPopupMenu(false);

        comboBoxAptoVegano.setBackground(new java.awt.Color(123, 36, 28));
        comboBoxAptoVegano.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 18)); // NOI18N
        comboBoxAptoVegano.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxAptoVegano.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));

        campoCalorias.setBackground(new java.awt.Color(123, 36, 28));
        campoCalorias.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        campoCalorias.setForeground(new java.awt.Color(255, 255, 255));

        tit9.setBackground(new java.awt.Color(123, 35, 27));
        tit9.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        tit9.setForeground(new java.awt.Color(255, 255, 255));
        tit9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit9.setText("Calorías");
        tit9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tit9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit9.setInheritsPopupMenu(false);

        botonAceptar.setBackground(new java.awt.Color(123, 36, 28));
        botonAceptar.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 14)); // NOI18N
        botonAceptar.setForeground(new java.awt.Color(255, 255, 255));
        botonAceptar.setText("ACEPTAR");
        botonAceptar.setAlignmentY(0.0F);
        botonAceptar.addActionListener(this::botonAceptarActionPerformed);

        botonCancelar.setBackground(new java.awt.Color(123, 36, 28));
        botonCancelar.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 14)); // NOI18N
        botonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        botonCancelar.setText("CANCELAR");
        botonCancelar.addActionListener(this::botonCancelarActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tit7, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(campoPeso))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tit9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoCalorias, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tit8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxAptoVegano, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tit9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCalorias, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(tit8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(tit7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(campoPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBoxAptoVegano, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botonAgregarDesagregarVendedor.setBackground(new java.awt.Color(123, 36, 28));
        botonAgregarDesagregarVendedor.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 14)); // NOI18N
        botonAgregarDesagregarVendedor.setForeground(new java.awt.Color(255, 255, 255));
        botonAgregarDesagregarVendedor.setText("Agregar/Eliminar Vendedor");
        botonAgregarDesagregarVendedor.setAlignmentY(0.0F);
        botonAgregarDesagregarVendedor.addActionListener(this::botonAgregarDesagregarVendedorActionPerformed);

        campoVendedorSeleccionado.setBackground(new java.awt.Color(123, 36, 28));
        campoVendedorSeleccionado.setFont(new java.awt.Font("Times New Roman", Font.PLAIN, 20)); // NOI18N
        campoVendedorSeleccionado.setForeground(new java.awt.Color(255, 255, 255));
        campoVendedorSeleccionado.setAction(botonAgregarDesagregarVendedor.getAction());
        campoVendedorSeleccionado.setActionCommand(getName());

        javax.swing.GroupLayout panelEditableLayout = new javax.swing.GroupLayout(panelEditable);
        panelEditable.setLayout(panelEditableLayout);
        panelEditableLayout.setHorizontalGroup(
            panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditableLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditableLayout.createSequentialGroup()
                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(titFechaDePago, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tit3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tit5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoVendedorSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelEditableLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(botonAgregarDesagregarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelEditableLayout.createSequentialGroup()
                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tit1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tit2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(campoDescripcion)))
                    .addComponent(tituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelEditableLayout.setVerticalGroup(
            panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tit1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tit2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEditableLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titFechaDePago, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tit5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoVendedorSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tit3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAgregarDesagregarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        getContentPane().add(panelEditable, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        String regex = "^\\d*(\\.\\d+)?$";
        if (campoVendedorSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un vendedor antes de continuar");
            return;
        }
        if (campoPrecio.getText().matches(regex) && 
            !campoNombre.getText().isEmpty() && 
            !campoDescripcion.getText().isEmpty() && 
            !campoPrecio.getText().isEmpty() &&
            (Objects.equals(comboBoxCategoria.getSelectedItem(), "BEBIDA") ||
             (!campoPeso.getText().isEmpty() && !campoCalorias.getText().isEmpty() && comboBoxAptoVegano.getSelectedItem() != null))) {
            
            double precio = Double.parseDouble(campoPrecio.getText());
            double tamanio = campoTamanio.getText().isEmpty() ? 0 : Double.parseDouble(campoTamanio.getText());
            double peso = campoPeso.getText().isEmpty() ? 0 : Double.parseDouble(campoPeso.getText());
            double calorias = campoCalorias.getText().isEmpty() ? 0 : Double.parseDouble(campoCalorias.getText());
            
            Categoria categoriaItem = new Categoria((String) comboBoxCategoria.getSelectedItem(),(String) comboBoxCategoria.getSelectedItem());

            if (filaSeleccionada == 100 && vendedorSeleccionado == null) {
                JOptionPane.showMessageDialog(this, "Seleccione un vendedor antes de confirmar.");
                return;
            }

            try {
                if (filaSeleccionada == 100) { 
                    if (comboBoxCategoria.getSelectedItem().equals("BEBIDA")) { // Creación de nuevo Bebida
                        itemMenuController.crearNuevoItemMenu((String)comboBoxCategoria.getSelectedItem(),
                                campoNombre.getText(),
                                campoDescripcion.getText(),
                                precio,
                                categoriaItem,
                                vendedorSeleccionado,
                                Double.valueOf(campoTamanio.getText()),
                                comboBoxAlcohol.getSelectedItem().equals("SI"),
                                null,
                                null,
                                null
                        );
                    } else {
                        itemMenuController.crearNuevoItemMenu((String)comboBoxCategoria.getSelectedItem(),
                                campoNombre.getText(),
                                campoDescripcion.getText(),
                                precio,
                                categoriaItem,
                                vendedorSeleccionado,
                                null,
                                null,
                                Double.valueOf(campoPeso.getText()),                                
                                Double.valueOf(campoCalorias.getText()),
                                comboBoxAptoVegano.getSelectedItem().equals("SI")
                        );
                    }
                    JOptionPane.showMessageDialog(this, "ItemMenu creado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    itemActual.setNombre(campoNombre.getText());
                    itemActual.setDescripcion(campoDescripcion.getText());
                    itemActual.setPrecio(precio);
                    itemActual.setCategoria(categoriaItem);
                    itemMenuController.modificarItemMenu(filaSeleccionada, itemActual, 
                            tamanio, comboBoxAlcohol.getSelectedItem().equals("SI"),
                            peso, calorias, comboBoxAptoVegano.getSelectedItem().equals("SI"));
                    
                    JOptionPane.showMessageDialog(this, "ItemMenu actualizado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
                dispose();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error en el formato de los datos. Verifique los campos de entrada.");
            } catch (DAOException e) {
                JOptionPane.showMessageDialog(this, "Error al crear o actualizar el ítem del menú: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Formato Inválido", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonAgregarDesagregarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarDesagregarVendedorActionPerformed
        VentanaAsignarEliminarVendedorDeItemMenu nuevaVentana = new VentanaAsignarEliminarVendedorDeItemMenu(itemActual, this, vendedorController, vendedorSeleccionado);
        nuevaVentana.setPantallaAgregarDesagregarVendedor(this);
        nuevaVentana.setVisible(true);
        nuevaVentana.setLocationRelativeTo(null);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                vendedorSeleccionado = nuevaVentana.getVendedorSeleccionado();
                if (vendedorSeleccionado != null) {
                    setVendedorSeleccionado(vendedorSeleccionado);
                }
            }
        });
    }//GEN-LAST:event_botonAgregarDesagregarVendedorActionPerformed



    private void comboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCategoriaActionPerformed
        String categoriaSeleccionada = (String) comboBoxCategoria.getSelectedItem();
        tit4.setVisible(false);
        tit6.setVisible(false);
        tit7.setVisible(false);
        tit8.setVisible(false);
        tit9.setVisible(false);
        campoTamanio.setVisible(false);
        comboBoxAlcohol.setVisible(false);
        campoPeso.setVisible(false);
        campoCalorias.setVisible(false);
        comboBoxAptoVegano.setVisible(false);

        if ("BEBIDA".equals(categoriaSeleccionada)) {
            tit4.setVisible(true);
            tit6.setVisible(true);
            campoTamanio.setVisible(true);
            comboBoxAlcohol.setVisible(true);
        } else if ("PLATO".equals(categoriaSeleccionada)) {
            tit7.setVisible(true);
            tit8.setVisible(true);
            tit9.setVisible(true);
            campoPeso.setVisible(true);
            campoCalorias.setVisible(true);
            comboBoxAptoVegano.setVisible(true);
        }

        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_comboBoxCategoriaActionPerformed

    private void comboBoxCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxCategoriaItemStateChanged
        String categoriaSeleccionada = (String) comboBoxCategoria.getSelectedItem();
        tit4.setVisible(false);
        tit6.setVisible(false);
        tit7.setVisible(false);
        tit8.setVisible(false);
        tit9.setVisible(false);
        campoTamanio.setVisible(false);
        comboBoxAlcohol.setVisible(false);
        campoPeso.setVisible(false);
        campoCalorias.setVisible(false);
        comboBoxAptoVegano.setVisible(false);

        if ("BEBIDA".equals(categoriaSeleccionada)) {
            tit4.setVisible(true);
            tit6.setVisible(true);
            campoTamanio.setVisible(true);
            comboBoxAlcohol.setVisible(true);
        } else if ("PLATO".equals(categoriaSeleccionada)) {
            tit7.setVisible(true);
            tit8.setVisible(true);
            tit9.setVisible(true);
            campoPeso.setVisible(true);
            campoCalorias.setVisible(true);
            comboBoxAptoVegano.setVisible(true);
        }

        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_comboBoxCategoriaItemStateChanged
	
	public void setTitulo() {
        tituloPrincipal.setText("Editar Items Menú");
    }
    
    public void recibirDatosEdicion(int filaSeleccionada, ItemMenu item) {
        this.filaSeleccionada = filaSeleccionada;
        this.itemActual = item;
        campoNombre.setText(item.getNombre());
        campoDescripcion.setText(item.getDescripcion());
        campoPrecio.setText(Double.toString(item.getPrecio()));
        campoVendedorSeleccionado.setText(item.getVendedor().getNombre());
        
        if(item.getCategoria().getTipo_item().equals("Plato")) {
            comboBoxCategoria.setSelectedItem("PLATO");
        } else {
            comboBoxCategoria.setSelectedItem("BEBIDA");
        }
        
        //obtenerDatosBebidaPlato
        if(itemMenuController.getItemMenuDAO() instanceof ItemMenuJDBC) {
            Plato plato = itemMenuController.obtenerDatosPlato(item.getId());
            Bebida bebida = itemMenuController.obtenerDatosBebida(item.getId());
            if(comboBoxCategoria.getSelectedItem().equals("BEBIDA")) {
                campoTamanio.setText(Double.toString(bebida.getTamanio()));
                if(bebida.isBebidaAlcoholica()) {
                    comboBoxAlcohol.setSelectedItem("SI");
                } else {
                    comboBoxAlcohol.setSelectedItem("NO");
                }
            } else {
                campoPeso.setText(Double.toString(plato.getPeso()));
                campoCalorias.setText(Double.toString(plato.getCalorias()));
                if(plato.isAptoVegano()) {
                    comboBoxAptoVegano.setSelectedItem("SI");
                } else {
                    comboBoxAptoVegano.setSelectedItem("NO");
                }
            }
        }
    }

    public void setVendedorSeleccionado(Vendedor vendedor) {
        this.vendedorSeleccionado = vendedor;
        if (vendedor != null) {
            campoVendedorSeleccionado.setText(vendedor.getNombre());
        }
    }

    public static void main(String[] args) {
        DAOItemMenu itemMenuDAO = ItemMenuMemory.getInstance();
        DAOVendedor vendedorDAO = VendedorMemory.getInstance();
        ItemMenuController itemMenuController = ItemMenuController.getInstance(itemMenuDAO);
        VendedorController vendedorController = VendedorController.getInstance(vendedorDAO);
        
        java.awt.EventQueue.invokeLater(() -> {
            VentanaDeCreacionEdicionItemsMenu ventanaPrincipal = new VentanaDeCreacionEdicionItemsMenu(itemMenuController, vendedorController);
            ventanaPrincipal.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoCalorias;
    private javax.swing.JTextField campoDescripcion;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoPeso;
    private javax.swing.JTextField campoPrecio;
    private javax.swing.JTextField campoTamanio;
    private javax.swing.JTextField campoVendedorSeleccionado;
    private javax.swing.JComboBox<String> comboBoxAlcohol;
    private javax.swing.JComboBox<String> comboBoxAptoVegano;
    private javax.swing.JComboBox<String> comboBoxCategoria;
    private javax.swing.JLabel tit4;
    private javax.swing.JLabel tit6;
    private javax.swing.JLabel tit7;
    private javax.swing.JLabel tit8;
    private javax.swing.JLabel tit9;
    private javax.swing.JLabel tituloPrincipal;
    // End of variables declaration//GEN-END:variables
}
