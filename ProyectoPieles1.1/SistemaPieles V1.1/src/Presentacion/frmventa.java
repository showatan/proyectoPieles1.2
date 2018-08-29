/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.vdetalleventa;
import Datos.vventa;
import Logica.Iconos;
import Logica.conexion;
import Logica.fdetalleventa;
import Logica.fventa;
import static Presentacion.frmvistaproducto.claveproducto;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import java.awt.Checkbox;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Alan Itzep
 */
public class frmventa extends javax.swing.JInternalFrame {

    public frmventa() {
        initComponents();
        //btnbuscarproducto.setMnemonic(KeyEvent.);
        mostrar(idventa);
        this.setTitle("Venta");
        inhabilitar();
        inhabilitar2();

    }

    private String accion = "guardar";
    public static int idusuario;
    public static String idventa = "";
    private Connection connection = new conexion().conectar();
    Iconos icon = new Iconos();

    void ocultar_columnas() {
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(1).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(2).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(2).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(2).setPreferredWidth(0);
        //0,1,3,4,5
        //tablaclientes.getColumnModel().getColumn(0).setMaxWidth(0);
        //tablaclientes.getColumnModel().getColumn(0).setMinWidth(0);
        //tablaclientes.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablaclientes.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaclientes.getColumnModel().getColumn(1).setMinWidth(0);
        tablaclientes.getColumnModel().getColumn(1).setPreferredWidth(0);

        tablaclientes.getColumnModel().getColumn(3).setMaxWidth(0);
        tablaclientes.getColumnModel().getColumn(3).setMinWidth(0);
        tablaclientes.getColumnModel().getColumn(3).setPreferredWidth(0);

        tablaclientes.getColumnModel().getColumn(4).setMaxWidth(0);
        tablaclientes.getColumnModel().getColumn(4).setMinWidth(0);
        tablaclientes.getColumnModel().getColumn(4).setPreferredWidth(0);

        tablaclientes.getColumnModel().getColumn(6).setMaxWidth(0);
        tablaclientes.getColumnModel().getColumn(6).setMinWidth(0);
        tablaclientes.getColumnModel().getColumn(6).setPreferredWidth(0);

        tablaclientes.getColumnModel().getColumn(7).setMaxWidth(0);
        tablaclientes.getColumnModel().getColumn(7).setMinWidth(0);
        tablaclientes.getColumnModel().getColumn(7).setPreferredWidth(0);

        tablaclientes.getColumnModel().getColumn(8).setMaxWidth(0);
        tablaclientes.getColumnModel().getColumn(8).setMinWidth(0);
        tablaclientes.getColumnModel().getColumn(8).setPreferredWidth(0);
    }

    void inhabilitar() {
        txtidventa.setVisible(false);
        txtidcliente.setVisible(false);
        txtidempleado.setVisible(false);

        //Registro venta
        txtnombrecliente.setEnabled(false);
        txtnombreempleado.setEnabled(false);
        dcfechaventa.setEnabled(false);
        txttotalmedida.setEnabled(false);
        txttotalventa.setEnabled(false);
        cbotipopago.setEnabled(false);

        btnbuscarcliente.setEnabled(false);

        btnguardar.setEnabled(false);
        btncancelar.setEnabled(false);
        btneliminar.setEnabled(false);

        lblinstruccion.setVisible(true);
        jScrollPane1.setVisible(false);

        //Ingreso productos
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);

        txtiddetalleventa.setVisible(false);
        txtidventa2.setVisible(false);
        txtidproducto.setVisible(false);

        txtnombreproducto.setEnabled(false);
        txtmedida.setEnabled(false);
        txtprecioventa.setEnabled(false);
        txtsubtotal.setEnabled(false);

        btnguardarproducto.setEnabled(false);
        btnbuscarproducto.setEnabled(false);
        btnreputi.setVisible(false);
        btnrepreci.setVisible(false);
        
        jScrollPane1.setVisible(true);
        btnreputi.setVisible(true);
        btnrepreci.setVisible(true);
        /*
        txtidventa.setText("");
        txtidcliente.setText("");
        txtidproducto.setText("");
        
        txtnombrecliente.setText("");
        txttotalmedida.setText("");
        txttotalventa.setText("");
        
        txtnombreproducto.setText("");
        txtprecioventa.setText("");
        txtmedida.setText("");
        txtsubtotal.setText("");*/
    }

    void habilitar() {//registroventa
        txtidventa.setVisible(false);
        txtidcliente.setVisible(false);
        txtidempleado.setVisible(false);

        //Registro venta
        txtnombrecliente.setEnabled(false);
        txtnombreempleado.setEnabled(false);
        dcfechaventa.setEnabled(true);
        txttotalmedida.setEnabled(false);
        txttotalventa.setEnabled(false);
        cbotipopago.setEnabled(true);

        btnbuscarcliente.setEnabled(true);

        btnguardar.setEnabled(true);
        btncancelar.setEnabled(true);
        btneliminar.setEnabled(false);

        //jScrollPane1.setVisible(false);
        txtidventa.setText("");
        txtidcliente.setText("");
        txtidproducto.setText("");

        txttotalmedida.setText("0.00");
        txttotalventa.setText("0.00");

        txtnombrecliente.setText("");

        jScrollPane1.setVisible(true);
        btnreputi.setVisible(true);
        btnrepreci.setVisible(true);
    }

    void habilitarproducto() {
        //Ingreso productos
        txtiddetalleventa.setVisible(false);
        txtidventa2.setVisible(false);
        txtidproducto.setVisible(false);

        txtnombreproducto.setEnabled(false);
        txtmedida.setEnabled(true);
        txtprecioventa.setEnabled(false);
        txtsubtotal.setEnabled(false);

        btnguardarproducto.setEnabled(true);
        btnbuscarproducto.setEnabled(true);

        txtmedida.setText("");
        txtsubtotal.setText("");
    }

    void inhabilitar2() {
        txtidventa.setText("");
        txtidcliente.setText("");

        txtnombrecliente.setText("");
        dcfechaventa.cleanup();
        txttotalmedida.setText("0.00");
        txttotalventa.setText("0.00");
        cbotipopago.setSelectedIndex(0);
    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            fventa func = new fventa();
            modelo = func.mostrar(buscar);

            tablaclientes.setModel(modelo);

            //Mostrar consumos en ventas
            fdetalleventa func2 = new fdetalleventa();
            modelo = func2.mostrar(buscar);

            tablalistado.setModel(modelo);

            ocultar_columnas();

            lbltotalregistros.setText("Total Registros:  " + Integer.toString(func2.totalregistros));
            lblconsumo.setText("Consumo Total Q. " + String.format("%.2f", func2.totalconsumo));
            lbltotalmedida.setText("Medida Total " + String.format("%.2f", func2.totalmedida));

            txttotalmedida.setText(String.format("%.2f", func2.totalmedida));
            txttotalventa.setText(String.format("%.2f", func2.totalconsumo));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    void actionClick() {

        if (txtnombreproducto.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes seleccionar un producto");
            btnbuscarproducto.requestFocus();
            return;
        }

        if (txtmedida.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar una medida");
            txtmedida.requestFocus();
            return;
        }

        vdetalleventa dts = new vdetalleventa();
        fdetalleventa func = new fdetalleventa();

        dts.setIdventa(Integer.parseInt(txtidventa2.getText()));
        dts.setIdproducto(Integer.parseInt(txtidproducto.getText()));
        dts.setMedida(Double.parseDouble(txtmedida.getText()));
        dts.setSubtotal(Double.parseDouble(txtsubtotal.getText()));

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                mostrar(idventa);
                habilitarproducto();
            }
        } else if (accion.equals("editar")) {
            dts.setIddetalleventa(Integer.parseInt(txtiddetalleventa.getText()));

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "Editado!");
                mostrar(idventa);
                habilitarproducto();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtidventa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        txtnombrecliente = new javax.swing.JTextField();
        txtidcliente = new javax.swing.JTextField();
        btnbuscarcliente = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtidempleado = new javax.swing.JTextField();
        txtnombreempleado = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        dcfechaventa = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        txttotalmedida = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txttotalventa = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cbotipopago = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaclientes = new javax.swing.JTable();
        lblinstruccion = new javax.swing.JLabel();
        btnreputi = new javax.swing.JButton();
        btnrepreci = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        btneliminar = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        lblconsumo = new javax.swing.JLabel();
        lbltotalmedida = new javax.swing.JLabel();
        btnactualizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lblpies = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtsubtotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtidproducto = new javax.swing.JTextField();
        txtnombreproducto = new javax.swing.JTextField();
        btnbuscarproducto = new javax.swing.JButton();
        txtprecioventa = new javax.swing.JTextField();
        txtmedida = new javax.swing.JTextField();
        txtiddetalleventa = new javax.swing.JTextField();
        txtidventa2 = new javax.swing.JTextField();
        btnguardarproducto = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/devices_78336.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1010, 560));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 73, 94));
        jLabel1.setText("Venta");

        jPanel1.setBackground(new java.awt.Color(44, 62, 80));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 15), new java.awt.Color(236, 240, 241))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(236, 240, 241));
        jLabel2.setText("Cliente");

        btnnuevo.setBackground(new java.awt.Color(52, 73, 94));
        btnnuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/New1.png"))); // NOI18N
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setBackground(new java.awt.Color(52, 73, 94));
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/save1.png"))); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setBackground(new java.awt.Color(52, 73, 94));
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/cancel1.png"))); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnbuscarcliente.setBackground(new java.awt.Color(255, 255, 255));
        btnbuscarcliente.setForeground(new java.awt.Color(52, 73, 94));
        btnbuscarcliente.setText("...");
        btnbuscarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarclienteActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(236, 240, 241));
        jLabel8.setText("Empleado");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(236, 240, 241));
        jLabel9.setText("Fecha venta");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(236, 240, 241));
        jLabel10.setText("Total medida");

        txttotalmedida.setText("0.00");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(236, 240, 241));
        jLabel11.setText("Total venta");

        txttotalventa.setText("0.00");
        txttotalventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalventaActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(236, 240, 241));
        jLabel12.setText("Tipo pago");

        cbotipopago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Cheque" }));

        tablaclientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaclientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaclientesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaclientes);

        lblinstruccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblinstruccion.setForeground(new java.awt.Color(236, 240, 241));
        lblinstruccion.setText("Editar una venta existente:");

        btnreputi.setBackground(new java.awt.Color(52, 73, 94));
        btnreputi.setForeground(new java.awt.Color(255, 255, 255));
        btnreputi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/loupe_78347.png"))); // NOI18N
        btnreputi.setText("Utilidades por venta");
        btnreputi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreputiActionPerformed(evt);
            }
        });

        btnrepreci.setBackground(new java.awt.Color(52, 73, 94));
        btnrepreci.setForeground(new java.awt.Color(255, 255, 255));
        btnrepreci.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/printer_78349.png"))); // NOI18N
        btnrepreci.setText("Generar Recibo");
        btnrepreci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrepreciActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtidventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(65, 65, 65)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtnombrecliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnbuscarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(dcfechaventa, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                            .addComponent(cbotipopago, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtnombreempleado)
                                            .addComponent(txttotalmedida)
                                            .addComponent(txttotalventa))
                                        .addGap(43, 43, 43))))
                            .addComponent(btnnuevo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(btnguardar)
                                .addGap(18, 18, 18)
                                .addComponent(btncancelar))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblinstruccion)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnreputi)
                                .addGap(18, 18, 18)
                                .addComponent(btnrepreci)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtnombrecliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnbuscarcliente)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtnombreempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dcfechaventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttotalmedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txttotalventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cbotipopago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnuevo)
                    .addComponent(btnguardar)
                    .addComponent(btncancelar))
                .addGap(19, 19, 19)
                .addComponent(lblinstruccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnreputi)
                    .addComponent(btnrepreci))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(52, 73, 94));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 15), new java.awt.Color(236, 240, 241))); // NOI18N

        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
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
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablalistadoMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tablalistado);

        btneliminar.setBackground(new java.awt.Color(52, 73, 94));
        btneliminar.setForeground(new java.awt.Color(255, 255, 255));
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/delete1.png"))); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        lbltotalregistros.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbltotalregistros.setForeground(new java.awt.Color(236, 240, 241));
        lbltotalregistros.setText("jLabel7");

        lblconsumo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblconsumo.setForeground(new java.awt.Color(236, 240, 241));
        lblconsumo.setText("jLabel7");

        lbltotalmedida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbltotalmedida.setForeground(new java.awt.Color(236, 240, 241));
        lbltotalmedida.setText("jLabel9");

        btnactualizar.setBackground(new java.awt.Color(52, 73, 94));
        btnactualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/save1.png"))); // NOI18N
        btnactualizar.setText("Guardar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(52, 73, 94));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/minimize_78340.png"))); // NOI18N
        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblpies.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblpies.setForeground(new java.awt.Color(236, 240, 241));
        lblpies.setText("(pies)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btneliminar)
                .addGap(54, 54, 54)
                .addComponent(btnactualizar))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltotalregistros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbltotalmedida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblpies)
                .addGap(34, 34, 34)
                .addComponent(lblconsumo)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltotalregistros)
                    .addComponent(lblconsumo)
                    .addComponent(lbltotalmedida)
                    .addComponent(lblpies))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btneliminar)
                    .addComponent(btnactualizar)
                    .addComponent(jButton1))
                .addGap(28, 28, 28))
        );

        jPanel3.setBackground(new java.awt.Color(44, 62, 80));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingreso productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 15), new java.awt.Color(236, 240, 241))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(236, 240, 241));
        jLabel4.setText("Sub total");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(236, 240, 241));
        jLabel7.setText("Medida");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(236, 240, 241));
        jLabel5.setText("Precio venta");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(236, 240, 241));
        jLabel3.setText("Producto");

        btnbuscarproducto.setBackground(new java.awt.Color(255, 255, 255));
        btnbuscarproducto.setForeground(new java.awt.Color(52, 73, 94));
        btnbuscarproducto.setText("...");
        btnbuscarproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarproductoActionPerformed(evt);
            }
        });

        txtmedida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtmedidaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmedidaKeyTyped(evt);
            }
        });

        btnguardarproducto.setBackground(new java.awt.Color(52, 73, 94));
        btnguardarproducto.setForeground(new java.awt.Color(255, 255, 255));
        btnguardarproducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/New1.png"))); // NOI18N
        btnguardarproducto.setText("Nuevo");
        btnguardarproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarproductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(txtiddetalleventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtidventa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtnombreproducto, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnbuscarproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtprecioventa, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtmedida)))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(txtsubtotal)))
                        .addGap(186, 186, 186))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtidproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnguardarproducto))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtiddetalleventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidventa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombreproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscarproducto)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtprecioventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(btnguardarproducto))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        btnguardar.setText("Guardar");
        accion = "guardar";
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        //validadion de ingreso de datos

        if (txtnombrecliente.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes seleccionar un cliente");
            btnbuscarproducto.requestFocus();
            return;
        }

        if ((dcfechaventa.getDate().toString()).length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes Ingresar una medida");
            dcfechaventa.requestFocus();
            return;
        }

        vventa dts = new vventa();
        fventa func = new fventa();

        dts.setIdcliente(Integer.parseInt(txtidcliente.getText()));
        dts.setIdempleado(Integer.parseInt(txtidempleado.getText()));

        Calendar cal;
        int d, m, a;
        cal = dcfechaventa.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;

        dts.setFechaventa(new Date(a, m, d));

        dts.setTotalmedida(Double.parseDouble(txttotalmedida.getText()));
        dts.setTotalventa(Double.parseDouble(txttotalventa.getText()));

        int seleccionado = cbotipopago.getSelectedIndex();
        dts.setTipopago((String) cbotipopago.getItemAt(seleccionado));

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "La venta " + txtnombreproducto.getText() + " del cliente "
                        + txtnombrecliente.getText() + " fue registrado satisfactoriamente");
                mostrar(idventa);
                inhabilitar();
                btnguardarproducto.setEnabled(true);
                txtidventa.setText(tablaclientes.getValueAt(0, 0).toString());
                txtidventa2.setText(tablaclientes.getValueAt(0, 0).toString());
            }
        }
        jPanel1.setVisible(false);
        jPanel2.setVisible(true);
        jPanel3.setVisible(true);
        tablalistado.setVisible(false);
        lbltotalregistros.setVisible(false);
        lbltotalmedida.setVisible(false);
        lblconsumo.setVisible(false);
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if (!txtiddetalleventa.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de elimiar este producto?", "Confirmar", 2);
            if (confirmacion == 0) {
                fdetalleventa func = new fdetalleventa();
                vdetalleventa dts = new vdetalleventa();

                dts.setIddetalleventa(Integer.parseInt(txtiddetalleventa.getText()));
                func.eliminar(dts);
                mostrar(idventa);
                txtnombreproducto.setText("");
                txtprecioventa.setText("");
                txtmedida.setText("");
                btnbuscarproducto.setEnabled(false);
                txtmedida.setEnabled(false);
            }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnbuscarproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarproductoActionPerformed
        // TODO add your handling code here:
        frmvistaproducto.claveproducto = "venta";
        frmvistaproducto form = new frmvistaproducto();
        form.toFront();
        form.setVisible(true);

    }//GEN-LAST:event_btnbuscarproductoActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:

        JOptionPane.showMessageDialog(rootPane, "El registro del fue cancelado");
        inhabilitar();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnbuscarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarclienteActionPerformed
        // TODO add your handling code here:
        frmvistacliente.clavecliente = "venta";
        frmvistacliente form = new frmvistacliente();
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_btnbuscarclienteActionPerformed

    private void txttotalventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalventaActionPerformed
        // TODO add your handling code here:
        txttotalventa.transferFocus();


    }//GEN-LAST:event_txttotalventaActionPerformed

    private void tablaclientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaclientesMousePressed
        // TODO add your handling code here:
        btnguardar.setText("Actualizar");
        inhabilitar();
        btnguardar.setEnabled(true);
        btnguardarproducto.setEnabled(true);
        accion = "editar";

        int fila = tablaclientes.rowAtPoint(evt.getPoint());

        txtidventa.setText(tablaclientes.getValueAt(fila, 0).toString());
        txtidcliente.setText(tablaclientes.getValueAt(fila, 1).toString());
        txtidempleado.setText(tablaclientes.getValueAt(fila, 3).toString());

        txtnombrecliente.setText(tablaclientes.getValueAt(fila, 2).toString());
        txtnombreempleado.setText(tablaclientes.getValueAt(fila, 4).toString());
        dcfechaventa.setDate(Date.valueOf(tablaclientes.getValueAt(fila, 5).toString()));
        txttotalmedida.setText(tablaclientes.getValueAt(fila, 6).toString());
        txttotalventa.setText(tablaclientes.getValueAt(fila, 7).toString());
        cbotipopago.setSelectedItem(tablaclientes.getValueAt(fila, 8).toString());

        txtidventa2.setText(tablaclientes.getValueAt(fila, 0).toString());

        idventa = txtidventa2.getText();
        mostrar(idventa);

        jPanel1.setVisible(false);
        jPanel2.setVisible(true);
        jPanel3.setVisible(true);
    }//GEN-LAST:event_tablaclientesMousePressed

    private void btnguardarproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarproductoActionPerformed
        // TODO add your handling code here:
        accion = "guardar";
        idventa = txtidventa2.getText();
        tablalistado.setVisible(true);
        lbltotalregistros.setVisible(true);
        lbltotalmedida.setVisible(true);
        lblconsumo.setVisible(true);
        mostrar(idventa);
        habilitarproducto();

        //abrir la ventana para escoger productos
        frmvistaproducto.claveproducto = "venta";
        frmvistaproducto form = new frmvistaproducto();
        form.toFront();
        form.setVisible(true);

    }//GEN-LAST:event_btnguardarproductoActionPerformed

    private void tablalistadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMousePressed
        // TODO add your handling code here:
        habilitarproducto();
        btneliminar.setEnabled(true);
        accion = "editar";

        int fila = tablalistado.rowAtPoint(evt.getPoint());

        txtiddetalleventa.setText(tablalistado.getValueAt(fila, 0).toString());
        txtidventa2.setText(tablalistado.getValueAt(fila, 1).toString());
        txtidproducto.setText(tablalistado.getValueAt(fila, 2).toString());
        txtnombreproducto.setText(tablalistado.getValueAt(fila, 3).toString());
        txtprecioventa.setText(tablalistado.getValueAt(fila, 4).toString());
        txtmedida.setText(tablalistado.getValueAt(fila, 5).toString());
        txtsubtotal.setText(tablalistado.getValueAt(fila, 6).toString());

    }//GEN-LAST:event_tablalistadoMousePressed

    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private void txtmedidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmedidaKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Double resultado;
            resultado = Double.parseDouble(txtmedida.getText()) * Double.parseDouble(txtprecioventa.getText());
            txtsubtotal.setText(resultado.toString());
            actionClick();
        }
        if (evt.getKeyCode() == KeyEvent.VK_DIVIDE) {
            frmvistaproducto.claveproducto = "venta";
            frmvistaproducto form = new frmvistaproducto();
            form.toFront();
            form.setVisible(true);
        }
        if (evt.getKeyCode() == KeyEvent.VK_MULTIPLY) {
            accion = "editar";

            idventa = txtidventa2.getText();
            mostrar(idventa);

            vventa dts = new vventa();
            fventa func = new fventa();

            dts.setIdcliente(Integer.parseInt(txtidcliente.getText()));
            dts.setIdempleado(Integer.parseInt(txtidempleado.getText()));

            Calendar cal;
            int d, m, a;
            cal = dcfechaventa.getCalendar();
            d = cal.get(Calendar.DAY_OF_MONTH);
            m = cal.get(Calendar.MONTH);
            a = cal.get(Calendar.YEAR) - 1900;

            dts.setFechaventa(new Date(a, m, d));

            dts.setTotalmedida(Double.parseDouble(txttotalmedida.getText()));
            dts.setTotalventa(Double.parseDouble(txttotalventa.getText()));

            int seleccionado = cbotipopago.getSelectedIndex();
            dts.setTipopago((String) cbotipopago.getItemAt(seleccionado));

            if (accion.equals("editar")) {
                dts.setIdventa(Integer.parseInt(txtidventa.getText()));

                if (func.editar(dts)) {
                    int resp = JOptionPane.showConfirmDialog(rootPane, "Venta de " + txtnombrecliente.getText()
                            + " fue realizada satisfactoriamente. \n¿Desea imprimir recibo? ",
                            "CONFIRMACION DE VENTA",
                            JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, icon);//showMessageDialog
                    if (resp != 1) {

                        Map p = new HashMap();
                        p.put("idventa", txtidventa.getText());
                        JasperReport report;
                        JasperPrint print;

                        try {
                            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                                    + "/src/Reportes/recibo.jrxml");
                            print = JasperFillManager.fillReport(report, p, connection);
//Aqui esta para que no haya vista previa e imprima de una vez 
                            //JasperViewer view = new JasperViewer(print, false);//borrar esto
                            //view.setTitle("RECIBO");//borar esto
                            //view.setVisible(true);//borrar esto tambien
                            JasperPrintManager.printReport(print, true);
                            //JasperPrint.printReport(print, true); //Des comentar esto

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        //aqui pones lo que quieras hacer si la respuesta es SI
                    } else {
                        //y aqui va lo contrario si esque la respuesta seria NO
                    }
                    mostrar(idventa);
                    habilitarproducto();
                }
            }
            inhabilitar2();
            jPanel1.setVisible(true);
            jPanel2.setVisible(false);
            jPanel3.setVisible(false);
        }
    }//GEN-LAST:event_txtmedidaKeyReleased


    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        // TODO add your handling code here:
        accion = "editar";

        idventa = txtidventa2.getText();
        mostrar(idventa);

        vventa dts = new vventa();
        fventa func = new fventa();

        dts.setIdcliente(Integer.parseInt(txtidcliente.getText()));
        dts.setIdempleado(Integer.parseInt(txtidempleado.getText()));

        Calendar cal;
        int d, m, a;
        cal = dcfechaventa.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;

        dts.setFechaventa(new Date(a, m, d));

        dts.setTotalmedida(Double.parseDouble(txttotalmedida.getText()));
        dts.setTotalventa(Double.parseDouble(txttotalventa.getText()));

        int seleccionado = cbotipopago.getSelectedIndex();
        dts.setTipopago((String) cbotipopago.getItemAt(seleccionado));

        if (accion.equals("editar")) {
            dts.setIdventa(Integer.parseInt(txtidventa.getText()));

            if (func.editar(dts)) {
                int resp = JOptionPane.showConfirmDialog(rootPane, "Venta de " + txtnombrecliente.getText()
                        + " fue realizada satisfactoriamente. \n¿Desea imprimir recibo? ",
                        "CONFIRMACION DE VENTA",
                        JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, icon);//showMessageDialog
                if (resp != 1) {

                    Map p = new HashMap();
                    p.put("idventa", txtidventa.getText());
                    JasperReport report;
                    JasperPrint print;

                    try {
                        report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                                + "/src/Reportes/recibo.jrxml");
                        print = JasperFillManager.fillReport(report, p, connection);
//Aqui esta para que no haya vista previa e imprima de una vez 
                        //JasperViewer view = new JasperViewer(print, false);//borrar esto
                        //view.setTitle("RECIBO");//borar esto
                        //view.setVisible(true);//borrar esto tambien
                        JasperPrintManager.printReport(print, true);
                        //JasperPrint.printReport(print, true); //Des comentar esto

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //aqui pones lo que quieras hacer si la respuesta es SI
                } else {
                    //y aqui va lo contrario si esque la respuesta seria NO
                }
                mostrar(idventa);
                habilitarproducto();
            }
        }
        inhabilitar2();
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnreputiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreputiActionPerformed
        // TODO add your handling code here:
        if (txtidventa.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione una venta en la tabla por favor.");
            return;
        }
        Map p = new HashMap();
        p.put("idventa", txtidventa.getText());
        JasperReport report;
        JasperPrint print;

        try {
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/Reportes/Utilidad.jrxml");
            print = JasperFillManager.fillReport(report, p, connection);

            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("Reporte de utilidad de venta");
            view.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnreputiActionPerformed

    private void btnrepreciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrepreciActionPerformed
        // TODO add your handling code here:
        if (txtidventa.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione una venta en la tabla por favor.");
            return;
        }
        Map p = new HashMap();
        p.put("idventa", txtidventa.getText());
        JasperReport report;
        JasperPrint print;

        try {
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/Reportes/recibo.jrxml");
            print = JasperFillManager.fillReport(report, p, connection);

            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("RECIBO");
            view.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnrepreciActionPerformed

    private void txtmedidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmedidaKeyTyped
        // TODO add your handling code here:
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();

        }
        if (evt.getKeyChar() == '.' && txtmedida.getText().contains(".")) {
            evt.consume();
        }

    }//GEN-LAST:event_txtmedidaKeyTyped

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmventa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnbuscarcliente;
    private javax.swing.JButton btnbuscarproducto;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnguardarproducto;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnrepreci;
    private javax.swing.JButton btnreputi;
    private javax.swing.JComboBox<String> cbotipopago;
    private com.toedter.calendar.JDateChooser dcfechaventa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblconsumo;
    private javax.swing.JLabel lblinstruccion;
    private javax.swing.JLabel lblpies;
    private javax.swing.JLabel lbltotalmedida;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JTable tablaclientes;
    private javax.swing.JTable tablalistado;
    public static javax.swing.JTextField txtidcliente;
    private javax.swing.JTextField txtiddetalleventa;
    public static javax.swing.JTextField txtidempleado;
    public static javax.swing.JTextField txtidproducto;
    private javax.swing.JTextField txtidventa;
    private javax.swing.JTextField txtidventa2;
    public static javax.swing.JTextField txtmedida;
    public static javax.swing.JTextField txtnombrecliente;
    public static javax.swing.JTextField txtnombreempleado;
    public static javax.swing.JTextField txtnombreproducto;
    public static javax.swing.JTextField txtprecioventa;
    private javax.swing.JTextField txtsubtotal;
    private javax.swing.JTextField txttotalmedida;
    private javax.swing.JTextField txttotalventa;
    // End of variables declaration//GEN-END:variables
}
