/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TP.DS.Pantallas;

import javax.swing.*;
import javax.swing.table.*;
import Tp.DS.Pantallas.VentanaDeCreacionEdicionCliente;

public class MenuCliente extends javax.swing.JFrame {
    private MenuPrincipal menuPrincipal;
    private MenuVendedor menuVendedor;
    private MenuCliente menuCliente;
    private MenuItemsMenu menuItemsMenu;
    private MenuPedidos menuPedidos;
    
    //para tabla
    private Object[][] clientes;
    DefaultTableModel model;
    
    public void setListaTablaClientes() {
        model = (DefaultTableModel) tablaClientes.getModel();
        clientes = new Object[][] {
            {1, "20-12345678-9", "Cliente 1", "cliente1@mail.com", "Avenida 123", "-34.6083, -58.371"},
            {2, "20-87654321-9", "Cliente 2", "cliente2@mail.com", "Avenida 456", "-34.6092, -58.3772"},
            {3, "20-11112222-9", "Cliente 3", "cliente3@mail.com", "Avenida 789", "-34.6109, -58.3761"},
            {4, "20-33334444-9", "Cliente 4", "cliente4@mail.com", "Avenida 1011", "-34.6126, -58.3750"},
            {5, "20-55556666-9", "Cliente 5", "cliente5@mail.com", "Avenida 1213", "-34.6143, -58.3739"},
            {6, "20-77778888-9", "Cliente 6", "cliente6@mail.com", "Avenida 1415", "-34.6160, -58.3728"},
            {7, "20-99990000-9", "Cliente 7", "cliente7@mail.com", "Avenida 1617", "-34.6177, -58.3717"},
            {8, "20-12121212-9", "Cliente 8", "cliente8@mail.com", "Avenida 1819", "-34.6194, -58.3706"},
            {9, "20-23232323-9", "Cliente 9", "cliente9@mail.com", "Avenida 2021", "-34.6211, -58.3695"},
            {10, "20-34343434-9", "Cliente 10", "cliente10@mail.com", "Avenida 2223", "-34.6228, -58.3684"},
            {11, "20-45454545-9", "Cliente 11", "cliente11@mail.com", "Avenida 2425", "-34.6245, -58.3673"},
            {12, "20-56565656-9", "Cliente 12", "cliente12@mail.com", "Avenida 2627", "-34.6262, -58.3662"},
            {13, "20-67676767-9", "Cliente 13", "cliente13@mail.com", "Avenida 2829", "-34.6279, -58.3651"}
        };
    }
    
    public void setMenuPrincipal(MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
    }
    public void setMenuVendedor(MenuVendedor menuVendedor) {
        this.menuVendedor = menuVendedor;
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
    public void recibirDatosDeCreacion(String cuit, String nombre, String email, String direccion, String latitud, String longitud) {
        String coordenada = latitud + ", " + longitud;
        Object[] vendedor = new Object[] {model.getRowCount() + 1, cuit, nombre, email, direccion, coordenada};
        model.addRow(vendedor);
    }
    public void recibirDatosDeEdicion(int filaSeleccionada, String cuit, String nombre, String email, String direccion, String latitud, String longitud) {
        String coordenada = latitud + ", " + longitud;
        model.setValueAt(cuit, filaSeleccionada, 1);
        model.setValueAt(nombre, filaSeleccionada, 2);
        model.setValueAt(email, filaSeleccionada, 3);
        model.setValueAt(direccion, filaSeleccionada, 4);
        model.setValueAt(coordenada, filaSeleccionada, 5); 
    }
    
    
    public MenuCliente() {
        initComponents();
        setListaTablaClientes();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Panel = new javax.swing.JPanel();
        botonVendedor = new javax.swing.JButton();
        botonCliente = new javax.swing.JButton();
        botonPedidos = new javax.swing.JButton();
        botonItemsMenu = new javax.swing.JButton();
        texto1 = new javax.swing.JLabel();
        botonVolver = new javax.swing.JButton();
        buscarCliente = new javax.swing.JButton();
        botonEditarCliente = new javax.swing.JButton();
        botonEliminarCliente = new javax.swing.JButton();
        botonCrearCliente = new javax.swing.JButton();
        cuitCliente = new javax.swing.JTextField();
        textoCUIT = new javax.swing.JLabel();
        nombreCliente = new javax.swing.JTextField();
        textoNombre = new javax.swing.JLabel();
        emailCliente = new javax.swing.JTextField();
        textoEmail = new javax.swing.JLabel();
        scrollTablaClientes = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        coordenadasCliente = new javax.swing.JTextField();
        textoCoordenadas = new javax.swing.JLabel();
        textoDireccion = new javax.swing.JLabel();
        direccionCliente = new javax.swing.JTextField();

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

        Panel.setBackground(new java.awt.Color(69, 69, 69));
        Panel.setMaximumSize(new java.awt.Dimension(900, 600));
        Panel.setMinimumSize(new java.awt.Dimension(900, 600));

        botonVendedor.setBackground(new java.awt.Color(123, 36, 28));
        botonVendedor.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        botonVendedor.setForeground(new java.awt.Color(255, 255, 255));
        botonVendedor.setText("VENDEDORES");
        botonVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVendedorActionPerformed(evt);
            }
        });

        botonCliente.setBackground(new java.awt.Color(123, 36, 28));
        botonCliente.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        botonCliente.setForeground(new java.awt.Color(255, 255, 255));
        botonCliente.setText("CLIENTES");
        botonCliente.setEnabled(false);
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
        texto1.setDisabledIcon(new javax.swing.ImageIcon("C:\\Users\\Ale\\Desktop\\UTN 2024\\2do Cuatri\\3ro - Desarrollo Software\\TP\\tpDesarrolloSoftware\\logo.jpg")); // NOI18N
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

        buscarCliente.setBackground(new java.awt.Color(123, 36, 28));
        buscarCliente.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        buscarCliente.setForeground(new java.awt.Color(255, 255, 255));
        buscarCliente.setText("BUSCAR CLIENTE");
        buscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarClienteActionPerformed(evt);
            }
        });

        botonEditarCliente.setBackground(new java.awt.Color(123, 36, 28));
        botonEditarCliente.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonEditarCliente.setForeground(new java.awt.Color(255, 255, 255));
        botonEditarCliente.setText("EDITAR CLIENTE");
        botonEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarClienteActionPerformed(evt);
            }
        });

        botonEliminarCliente.setBackground(new java.awt.Color(123, 36, 28));
        botonEliminarCliente.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonEliminarCliente.setForeground(new java.awt.Color(255, 255, 255));
        botonEliminarCliente.setText("ELIMINAR CLIENTE");
        botonEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarClienteActionPerformed(evt);
            }
        });

        botonCrearCliente.setBackground(new java.awt.Color(123, 36, 28));
        botonCrearCliente.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        botonCrearCliente.setForeground(new java.awt.Color(255, 255, 255));
        botonCrearCliente.setText("CREAR CLIENTE");
        botonCrearCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearClienteActionPerformed(evt);
            }
        });

        cuitCliente.setBackground(new java.awt.Color(123, 36, 28));
        cuitCliente.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        cuitCliente.setForeground(new java.awt.Color(255, 255, 255));

        textoCUIT.setBackground(new java.awt.Color(123, 35, 27));
        textoCUIT.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        textoCUIT.setForeground(new java.awt.Color(255, 255, 255));
        textoCUIT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoCUIT.setText("CUIT");
        textoCUIT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textoCUIT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        textoCUIT.setInheritsPopupMenu(false);

        nombreCliente.setBackground(new java.awt.Color(123, 36, 28));
        nombreCliente.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        nombreCliente.setForeground(new java.awt.Color(255, 255, 255));

        textoNombre.setBackground(new java.awt.Color(123, 35, 27));
        textoNombre.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        textoNombre.setForeground(new java.awt.Color(255, 255, 255));
        textoNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoNombre.setText("Nombre");
        textoNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textoNombre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        textoNombre.setInheritsPopupMenu(false);

        emailCliente.setBackground(new java.awt.Color(123, 36, 28));
        emailCliente.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        emailCliente.setForeground(new java.awt.Color(255, 255, 255));

        textoEmail.setBackground(new java.awt.Color(123, 35, 27));
        textoEmail.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
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
                "", "CUIT", "Nombre", "Email", "Dirección", "Coordenadas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        coordenadasCliente.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        coordenadasCliente.setForeground(new java.awt.Color(255, 255, 255));

        textoCoordenadas.setBackground(new java.awt.Color(123, 35, 27));
        textoCoordenadas.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        textoCoordenadas.setForeground(new java.awt.Color(255, 255, 255));
        textoCoordenadas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoCoordenadas.setText("Coordenadas");
        textoCoordenadas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textoCoordenadas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        textoCoordenadas.setInheritsPopupMenu(false);

        textoDireccion.setBackground(new java.awt.Color(123, 35, 27));
        textoDireccion.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        textoDireccion.setForeground(new java.awt.Color(255, 255, 255));
        textoDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoDireccion.setText("Dirección");
        textoDireccion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textoDireccion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        textoDireccion.setInheritsPopupMenu(false);

        direccionCliente.setBackground(new java.awt.Color(123, 36, 28));
        direccionCliente.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        direccionCliente.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botonEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonCrearCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
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
                                    .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(emailCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                        .addComponent(textoEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(direccionCliente)
                                    .addComponent(textoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(coordenadasCliente)
                                    .addComponent(textoCoordenadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(texto1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(texto1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
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
                .addComponent(scrollTablaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCrearCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );

        getContentPane().add(Panel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVendedorActionPerformed
        menuVendedor.setMenuCliente(this);
        menuVendedor.setVisible(true);
        menuVendedor.setLocationRelativeTo(null);
        setVisible(false);
    }//GEN-LAST:event_botonVendedorActionPerformed

    private void botonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonClienteActionPerformed
        //
    }//GEN-LAST:event_botonClienteActionPerformed

    private void botonPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPedidosActionPerformed
        menuPedidos.setMenuCliente(this);
        menuPedidos.setVisible(true);
        menuPedidos.setLocationRelativeTo(null);
        setVisible(false);
    }//GEN-LAST:event_botonPedidosActionPerformed

    private void botonItemsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonItemsMenuActionPerformed
        menuItemsMenu.setMenuCliente(this);
        menuItemsMenu.setVisible(true);
        menuItemsMenu.setLocationRelativeTo(null);
        setVisible(false);
    }//GEN-LAST:event_botonItemsMenuActionPerformed

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        menuPrincipal.setVisible(true);
        menuPrincipal.setLocationRelativeTo(null);
        setVisible(false);
    }//GEN-LAST:event_botonVolverActionPerformed

    private void buscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarClienteActionPerformed
        String cuitBuscado = cuitCliente.getText().trim();
        String nombreBuscado = nombreCliente.getText().trim();
        String emailBuscado = emailCliente.getText().trim();
        String direccionBuscado = direccionCliente.getText().trim();
        String coordenadasBuscado = coordenadasCliente.getText().trim();
        model.setRowCount(0);
        boolean encontrado = false;
        if (cuitBuscado.isEmpty() && nombreBuscado.isEmpty() && emailBuscado.isEmpty() && direccionBuscado.isEmpty() && coordenadasBuscado.isEmpty()) {
            for (Object[] cliente : clientes) {
                model.addRow(cliente);
            }
            encontrado = true;
        }
        else {
            for (Object[] cliente : clientes) {
                String cuit = ((String) cliente[1]).toLowerCase();
                String nombre = ((String) cliente[2]).toLowerCase();
                String email = ((String) cliente[3]).toLowerCase();
                String dir = ((String) cliente[4]).toLowerCase();
                String coordenada = ((String) cliente[5]).toLowerCase();

                if (nombre.contains(nombreBuscado)) {
                    model.addRow(cliente);
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con esos parámetros.", "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_buscarClienteActionPerformed

    private void botonEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarClienteActionPerformed
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (filaSeleccionada != -1) {
            String cuit = (String) model.getValueAt(filaSeleccionada, 1);
            String nombre = (String) model.getValueAt(filaSeleccionada, 2);
            String email = (String) model.getValueAt(filaSeleccionada, 3);
            String direccion = (String) model.getValueAt(filaSeleccionada, 4);
            String coordenada = (String) model.getValueAt(filaSeleccionada, 5);
            VentanaDeCreacionEdicionCliente nuevaVentana = new VentanaDeCreacionEdicionCliente();
            nuevaVentana.setMenuCliente(this);
            nuevaVentana.setVisible(true);
            nuevaVentana.setLocationRelativeTo(null);
            nuevaVentana.recibirDatosEdicion(filaSeleccionada, cuit, nombre, email, direccion, coordenada);
            nuevaVentana.setTitulo();
        }
        else {
            JOptionPane.showMessageDialog(null, "Por favor selecciona una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botonEditarClienteActionPerformed

    private void botonEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarClienteActionPerformed
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (filaSeleccionada != -1) {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este Cliente?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                model.removeRow(filaSeleccionada);
                JOptionPane.showMessageDialog(null, "Cliente borrado con Éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Por favor selecciona una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botonEliminarClienteActionPerformed

    private void botonCrearClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearClienteActionPerformed
        VentanaDeCreacionEdicionCliente nuevaVentana = new VentanaDeCreacionEdicionCliente();
        nuevaVentana.setMenuCliente(this);
        nuevaVentana.setVisible(true);
        nuevaVentana.setLocationRelativeTo(null);
    }//GEN-LAST:event_botonCrearClienteActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new MenuCliente().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JButton botonCliente;
    private javax.swing.JButton botonCrearCliente;
    private javax.swing.JButton botonEditarCliente;
    private javax.swing.JButton botonEliminarCliente;
    private javax.swing.JButton botonItemsMenu;
    private javax.swing.JButton botonPedidos;
    private javax.swing.JButton botonVendedor;
    private javax.swing.JButton botonVolver;
    private javax.swing.JButton buscarCliente;
    private javax.swing.JTextField coordenadasCliente;
    private javax.swing.JTextField cuitCliente;
    private javax.swing.JTextField direccionCliente;
    private javax.swing.JTextField emailCliente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombreCliente;
    private javax.swing.JScrollPane scrollTablaClientes;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JLabel texto1;
    private javax.swing.JLabel textoCUIT;
    private javax.swing.JLabel textoCoordenadas;
    private javax.swing.JLabel textoDireccion;
    private javax.swing.JLabel textoEmail;
    private javax.swing.JLabel textoNombre;
    // End of variables declaration//GEN-END:variables
}
