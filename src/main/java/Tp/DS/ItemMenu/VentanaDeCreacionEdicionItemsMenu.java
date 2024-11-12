package Tp.DS.ItemMenu;

import Tp.DS.ItemMenu.MenuItemsMenu;
import Tp.DS.Categoria.Categoria;
import Tp.DS.ItemMenu.ItemMenuController;
import Tp.DS.Vendedor.VendedorController;
import Tp.DS.Exceptions.DAOException;
import Tp.DS.ItemMenu.DAOItemMenu;
import Tp.DS.Vendedor.DAOVendedor;
import Tp.DS.ItemMenu.ItemMenuMemory;
import Tp.DS.Vendedor.VendedorMemory;
import Tp.DS.Vendedor.Vendedor;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentanaDeCreacionEdicionItemsMenu extends javax.swing.JFrame {
    private MenuItemsMenu menuItemsMenu;
    private int filaSeleccionada=100;
    private ItemMenuController itemMenuController;
    private ItemMenu itemActual;
    private VendedorController vendedorController;
    private Vendedor vendedorSeleccionado;
    private DAOVendedor vendedorDAO;
    private VentanaDeCreacionEdicionItemsMenu ventanaCreacion;

    public VentanaDeCreacionEdicionItemsMenu(ItemMenuController itemMenuController, VendedorController vendedorController) {
        this.itemMenuController = itemMenuController;
        this.vendedorController = vendedorController;
        this.vendedorDAO = vendedorController.getVendedorDAO();
        initComponents();
    }
    public void setTitulo() {
        tituloPrincipal.setText("Editar Items Menú");
    }
    public void setItemsMenu(MenuItemsMenu menuItemsMenu) {
        this.menuItemsMenu = menuItemsMenu;
    }
    public void recibirDatosEdicion(int filaSeleccionada, ItemMenu item) {
        this.filaSeleccionada = filaSeleccionada;
        this.itemActual = item;
        campoNombre.setText(item.getNombre());
        campoDescripcion.setText(item.getDescripcion());
        campoPrecio.setText(Double.toString(item.getPrecio()));
        comboBoxCategoria.setSelectedItem(item.getCategoria().getClass().getName());
        
        //estos campos deberían completarse, no se si habría q crear la instancia en la pantalla anterior para que se muestre estos datos
        if(comboBoxCategoria.getSelectedItem().equals("BEBIDA")) {
            campoTamanio.setText(""); //falta llenar
            comboBoxAlcohol.setSelectedItem("SI"); //falta llenar
        } else {
            campoPeso.setText(""); //falta llenar
            campoCalorias.setText(""); //falta llenar
            comboBoxAptoVegano.setSelectedItem("SI"); //falta llenar
        }      
    }
    

    public void setVendedorSeleccionado(Vendedor vendedor) {
        this.vendedorSeleccionado = vendedor;
        if (vendedor != null) {
            campoVendedorSeleccionado.setText(vendedor.getNombre()); 
        }
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
        comboBoxCategoria = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        campoTamanio = new javax.swing.JTextField();
        tit4 = new javax.swing.JLabel();
        tit6 = new javax.swing.JLabel();
        comboBoxAlcohol = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        tit7 = new javax.swing.JLabel();
        campoPeso = new javax.swing.JTextField();
        tit8 = new javax.swing.JLabel();
        comboBoxAptoVegano = new javax.swing.JComboBox<>();
        campoCalorias = new javax.swing.JTextField();
        tit9 = new javax.swing.JLabel();
        botonAgregarDesagregarVendedor = new javax.swing.JButton();
        campoVendedorSeleccionado = new javax.swing.JTextField();
		campoVendedorSeleccionado.setEditable(false);

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

        comboBoxCategoria.setBackground(new java.awt.Color(123, 36, 28));
        comboBoxCategoria.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        comboBoxCategoria.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PLATO", "BEBIDA" }));
        comboBoxCategoria.setSelectedIndex(1);
        comboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCategoriaActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(69, 69, 69));

        campoTamanio.setBackground(new java.awt.Color(123, 36, 28));
        campoTamanio.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoTamanio.setForeground(new java.awt.Color(255, 255, 255));
        campoTamanio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTamanioActionPerformed(evt);
            }
        });

        tit4.setBackground(new java.awt.Color(123, 35, 27));
        tit4.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tit4.setForeground(new java.awt.Color(255, 255, 255));
        tit4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit4.setText("Tamaño");
        tit4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tit4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit4.setInheritsPopupMenu(false);

        tit6.setBackground(new java.awt.Color(123, 35, 27));
        tit6.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tit6.setForeground(new java.awt.Color(255, 255, 255));
        tit6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit6.setText("Alcohólica");
        tit6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tit6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit6.setInheritsPopupMenu(false);

        comboBoxAlcohol.setBackground(new java.awt.Color(123, 36, 28));
        comboBoxAlcohol.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        comboBoxAlcohol.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxAlcohol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(campoTamanio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tit4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxAlcohol, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tit6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tit6)
                            .addComponent(tit4))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoTamanio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxAlcohol, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(69, 69, 69));

        tit7.setBackground(new java.awt.Color(123, 35, 27));
        tit7.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tit7.setForeground(new java.awt.Color(255, 255, 255));
        tit7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit7.setText("Peso");
        tit7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tit7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit7.setInheritsPopupMenu(false);

        campoPeso.setBackground(new java.awt.Color(123, 36, 28));
        campoPeso.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoPeso.setForeground(new java.awt.Color(255, 255, 255));

        tit8.setBackground(new java.awt.Color(123, 35, 27));
        tit8.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tit8.setForeground(new java.awt.Color(255, 255, 255));
        tit8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit8.setText("Apto Vegano");
        tit8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tit8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit8.setInheritsPopupMenu(false);

        comboBoxAptoVegano.setBackground(new java.awt.Color(123, 36, 28));
        comboBoxAptoVegano.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        comboBoxAptoVegano.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxAptoVegano.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));

        campoCalorias.setBackground(new java.awt.Color(123, 36, 28));
        campoCalorias.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoCalorias.setForeground(new java.awt.Color(255, 255, 255));

        tit9.setBackground(new java.awt.Color(123, 35, 27));
        tit9.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        tit9.setForeground(new java.awt.Color(255, 255, 255));
        tit9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tit9.setText("Calorías");
        tit9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tit9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tit9.setInheritsPopupMenu(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tit7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tit9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCalorias, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tit8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxAptoVegano, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tit9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCalorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(tit8)
                            .addGap(36, 36, 36))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(tit7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(campoPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBoxAptoVegano, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        botonAgregarDesagregarVendedor.setBackground(new java.awt.Color(123, 36, 28));
        botonAgregarDesagregarVendedor.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        botonAgregarDesagregarVendedor.setForeground(new java.awt.Color(255, 255, 255));
        botonAgregarDesagregarVendedor.setText("Agregar/Eliminar Vendedor");
        botonAgregarDesagregarVendedor.setAlignmentY(0.0F);
        botonAgregarDesagregarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarDesagregarVendedorActionPerformed(evt);
            }
        });

        campoVendedorSeleccionado.setBackground(new java.awt.Color(123, 36, 28));
        campoVendedorSeleccionado.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        campoVendedorSeleccionado.setForeground(new java.awt.Color(255, 255, 255));
        campoVendedorSeleccionado.setAction(botonAgregarDesagregarVendedor.getAction());
        campoVendedorSeleccionado.setActionCommand(getName());

        javax.swing.GroupLayout panelEditableLayout = new javax.swing.GroupLayout(panelEditable);
        panelEditable.setLayout(panelEditableLayout);
        panelEditableLayout.setHorizontalGroup(
            panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEditableLayout.createSequentialGroup()
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditableLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tituloPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditableLayout.createSequentialGroup()
                                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelEditableLayout.createSequentialGroup()
                                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tit1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(campoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tit2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelEditableLayout.createSequentialGroup()
                                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(titFechaDePago, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panelEditableLayout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(tit3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(18, 18, 18)
                                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(botonAgregarDesagregarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tit5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditableLayout.createSequentialGroup()
                                                .addComponent(campoVendedorSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(59, 59, 59)))))
                                .addGap(12, 12, 12))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelEditableLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelEditableLayout.setVerticalGroup(
            panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEditableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tit1)
                        .addComponent(tit2))
                    .addGroup(panelEditableLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titFechaDePago)
                    .addComponent(tit5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoVendedorSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tit3)
                    .addComponent(botonAgregarDesagregarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(panelEditableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        getContentPane().add(panelEditable, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
//        String regex = "^\\d*(\\.\\d+)?$";
//        if (campoPrecio.getText().matches(regex) && !campoNombre.getText().isEmpty() && !campoDescripcion.getText().isEmpty() 
//                && !campoPrecio.getText().isEmpty() && !campoVendedor.getText().isEmpty()) {
//            if(filaSeleccionada==100) {
//                menuItemsMenu.recibirDatosDeCreacion(campoNombre.getText(), campoDescripcion.getText(), campoPrecio.getText(),
//                        (String) comboBoxCategoria.getSelectedItem(), campoVendedor.getText());
//                JOptionPane.showMessageDialog(null, "Creado con Éxito", null, JOptionPane.INFORMATION_MESSAGE);
//            } else {
//                menuItemsMenu.recibirDatosDeEdicion(filaSeleccionada, campoNombre.getText(), campoDescripcion.getText(), 
//                        campoPrecio.getText(), (String) comboBoxCategoria.getSelectedItem(), campoVendedor.getText());
//                JOptionPane.showMessageDialog(null, "Editado con Éxito", null, JOptionPane.INFORMATION_MESSAGE);
//            }
//            dispose();
//        } else {
//            JOptionPane.showMessageDialog(null, "Formato Inválido", "Advertencia", JOptionPane.WARNING_MESSAGE);
//        } 
        String regex = "^\\d*(\\.\\d+)?$"; // validación de precio
        System.out.println(filaSeleccionada);
        if (vendedorSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un vendedor antes de continuar");
            return;
        }
        // Validación de campos obligatorios y formato de datos
        if (campoPrecio.getText().matches(regex) && 
            !campoNombre.getText().isEmpty() && 
            !campoDescripcion.getText().isEmpty() && 
            !campoPrecio.getText().isEmpty() &&
            (comboBoxCategoria.getSelectedItem().equals("BEBIDA") || 
             (!campoPeso.getText().isEmpty() && !campoCalorias.getText().isEmpty() && comboBoxAptoVegano.getSelectedItem() != null))) {

            double precio = Double.parseDouble(campoPrecio.getText());
            Categoria categoriaItem = new Categoria(campoDescripcion.getText(),(String) comboBoxCategoria.getSelectedItem());

            // Validación de existencia de vendedor seleccionado para creación
            if (filaSeleccionada == 100 && vendedorSeleccionado == null) {
                JOptionPane.showMessageDialog(this, "Seleccione un vendedor antes de confirmar.");
                return;
            }

            try {
                if (filaSeleccionada == 100) { // Creación de nuevo ItemMenu
                    if (comboBoxCategoria.getSelectedItem().equals("BEBIDA")) {
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
                    } else { // Creación de un plato
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
                } else { // Edición de un ItemMenu existente
                    itemActual.setNombre(campoNombre.getText());
                    itemActual.setDescripcion(campoDescripcion.getText());
                    itemActual.setPrecio(precio);
                    itemActual.setCategoria(categoriaItem);

                    itemMenuController.modificarItemMenu(filaSeleccionada, itemActual);
                    JOptionPane.showMessageDialog(this, "ItemMenu actualizado con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
                dispose(); // Cierra la ventana después de la creación o edición
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error en el formato de los datos. Verifique los campos de entrada.");
            } catch (DAOException e) {
                JOptionPane.showMessageDialog(this, "Error al crear o actualizar el ítem del menú: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Formato Inválido", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        System.out.println("Vendedor asignado en setVendedorSeleccionado: " + vendedorSeleccionado);
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonAgregarDesagregarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarDesagregarVendedorActionPerformed
        
        VentanaAsignarEliminarVendedorDeItemMenu nuevaVentana = new VentanaAsignarEliminarVendedorDeItemMenu(itemActual, this, vendedorController);
        nuevaVentana.setPantallaAgregarDesagregarVendedor(this);
        nuevaVentana.setVisible(true);
        nuevaVentana.setLocationRelativeTo(null);
        nuevaVentana.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                Vendedor vendedorSeleccionado = nuevaVentana.getVendedorSeleccionado();
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
            // mostrar campos para BEBIDA
            tit4.setVisible(true);
            tit6.setVisible(true);
            campoTamanio.setVisible(true);
            comboBoxAlcohol.setVisible(true);
        } else if ("PLATO".equals(categoriaSeleccionada)) {
            // mostrar campos para PLATO
            tit7.setVisible(true);
            tit8.setVisible(true);
            tit9.setVisible(true);
            campoPeso.setVisible(true);
            campoCalorias.setVisible(true);
            comboBoxAptoVegano.setVisible(true);
        }

        // refrescar la ventana para aplicar los cambios de visibilidad
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_comboBoxCategoriaActionPerformed

    private void campoTamanioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTamanioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTamanioActionPerformed

    public static void main(String args[]) {
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
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonAgregarDesagregarVendedor;
    private javax.swing.JButton botonCancelar;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel panelEditable;
    private javax.swing.JLabel tit1;
    private javax.swing.JLabel tit2;
    private javax.swing.JLabel tit3;
    private javax.swing.JLabel tit4;
    private javax.swing.JLabel tit5;
    private javax.swing.JLabel tit6;
    private javax.swing.JLabel tit7;
    private javax.swing.JLabel tit8;
    private javax.swing.JLabel tit9;
    private javax.swing.JLabel titFechaDePago;
    private javax.swing.JLabel tituloPrincipal;
    // End of variables declaration//GEN-END:variables
}
