/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Presentacion;

import Logica.conexion;
import Logica.fcliente;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author SONY
 */
public class frmreportes extends javax.swing.JInternalFrame {

    /** Creates new form frmreportes */
    public frmreportes() {
        initComponents();
        inhabilitar();
        mostrar("");
        this.setTitle("Reportes de ventas por fecha");
    }
    
    public static int idcliente;
    
    public void mostrar(String buscar){
        try{
            fcliente func = new fcliente();
            func.mostrar(buscar);
        }catch(Exception e){
            JOptionPane.showConfirmDialog(rootPane,e);
        }
    }
    
    
    void inhabilitar(){
        txtidcliente.setVisible(false);
        jLabel2.setVisible(false);
        txtnombrecliente.setVisible(false);
        btnbuscarcliente.setVisible(false);
        btnfiltrar.setVisible(false);
    }
    
    void cliente(){
        jLabel2.setVisible(true);
    }
    
    void ocultarfechas(){
        dcfecha1.setVisible(false);
        dcfecha2.setVisible(false);
        btngenerarreporte.setVisible(false);
    }
    void eleccion1(){
        dcfecha1.setVisible(true);
        dcfecha2.setVisible(false);
        btngenerarreporte.setVisible(true);
    }
    void eleccion2(){
        dcfecha1.setVisible(true);
        dcfecha2.setVisible(true);
        btngenerarreporte.setVisible(true);
    }
    public Integer ping;
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reportefecha = new javax.swing.JPanel();
        dcfecha1 = new com.toedter.calendar.JDateChooser();
        btngenerarreporte = new javax.swing.JButton();
        dcfecha2 = new com.toedter.calendar.JDateChooser();
        cboeleccion = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtidcliente = new javax.swing.JTextField();
        txtnombrecliente = new javax.swing.JTextField();
        btnbuscarcliente = new javax.swing.JButton();
        btnfiltrar = new javax.swing.JButton();

        setBackground(new java.awt.Color(127, 140, 141));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/printer_78349.png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(454, 260));

        reportefecha.setBackground(new java.awt.Color(44, 62, 80));
        reportefecha.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Por fechas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(236, 240, 241))); // NOI18N

        btngenerarreporte.setBackground(new java.awt.Color(52, 73, 94));
        btngenerarreporte.setForeground(new java.awt.Color(255, 255, 255));
        btngenerarreporte.setText("Generar Reporte");
        btngenerarreporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngenerarreporteActionPerformed(evt);
            }
        });

        cboeleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Una fecha", "Dos fechas" }));
        cboeleccion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboeleccionItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout reportefechaLayout = new javax.swing.GroupLayout(reportefecha);
        reportefecha.setLayout(reportefechaLayout);
        reportefechaLayout.setHorizontalGroup(
            reportefechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportefechaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reportefechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btngenerarreporte, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(dcfecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dcfecha2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboeleccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        reportefechaLayout.setVerticalGroup(
            reportefechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportefechaLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(cboeleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dcfecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dcfecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btngenerarreporte)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(52, 73, 94));
        jLabel2.setText("Cliente:");

        txtidcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidclienteActionPerformed(evt);
            }
        });

        btnbuscarcliente.setBackground(new java.awt.Color(52, 73, 94));
        btnbuscarcliente.setForeground(new java.awt.Color(255, 255, 255));
        btnbuscarcliente.setText("...");
        btnbuscarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarclienteActionPerformed(evt);
            }
        });

        btnfiltrar.setBackground(new java.awt.Color(52, 73, 94));
        btnfiltrar.setForeground(new java.awt.Color(255, 255, 255));
        btnfiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/loupe_78347.png"))); // NOI18N
        btnfiltrar.setText("Filtrar");
        btnfiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfiltrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtnombrecliente, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnbuscarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnfiltrar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(reportefecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtnombrecliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnbuscarcliente)
                        .addComponent(btnfiltrar)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reportefecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Connection connection = new conexion().conectar();
    
    private void btngenerarreporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngenerarreporteActionPerformed
        // TODO add your handling code here:
        if(ping == 1){
            Calendar cal;
            int d, m, a;
            cal = dcfecha1.getCalendar();
            d = cal.get(Calendar.DAY_OF_MONTH);
            m = cal.get(Calendar.MONTH);
            a = cal.get(Calendar.YEAR) - 1900;

            Map p = new HashMap();
            p.put("fechaconsulta", (new Date(a, m, d)));
            JasperReport report;
            JasperPrint print;

            try {
                report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                        + "/src/Reportes/Ventas.jrxml");
                print = JasperFillManager.fillReport(report, p, connection);

                JasperViewer view = new JasperViewer(print, false);
                view.setTitle("Reporte de ventas por fechas");
                view.setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(ping == 2){
            Calendar cal1,cal2;
            int d1,d2, m1,m2, a1,a2;
            cal1 = dcfecha1.getCalendar();
            cal2 = dcfecha2.getCalendar();
            d1 = cal1.get(Calendar.DAY_OF_MONTH);
            m1 = cal1.get(Calendar.MONTH);
            a1 = cal1.get(Calendar.YEAR) - 1900;

            d2 = cal2.get(Calendar.DAY_OF_MONTH);
            m2 = cal2.get(Calendar.MONTH);
            a2 = cal2.get(Calendar.YEAR) - 1900;
            
            Map p = new HashMap();
            p.put("fechaconsulta1", (new Date(a1, m1, d1)));
            p.put("fechaconsulta2", (new Date(a2, m2, d2)));
            JasperReport report;
            JasperPrint print;

            try {
                report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                        + "/src/Reportes/VentasFechas.jrxml");
                print = JasperFillManager.fillReport(report, p, connection);

                JasperViewer view = new JasperViewer(print, false);
                view.setTitle("Reporte de ventas por fechas");
                view.setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_btngenerarreporteActionPerformed

    private void cboeleccionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboeleccionItemStateChanged
        // TODO add your handling code here:
        String estado;
        int seleccionado = cboeleccion.getSelectedIndex();
        estado = (String) cboeleccion.getItemAt(seleccionado);
        if(estado.equals("Una fecha")){
            ping = 1;
            eleccion1();
            
        }
        if(estado.equals("Dos fechas")){
            ping = 2;
            eleccion2();
        }
    }//GEN-LAST:event_cboeleccionItemStateChanged

    private void txtidclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidclienteActionPerformed

    private void btnbuscarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarclienteActionPerformed
        // TODO add your handling code here:
        frmvistacliente.clavecliente = "reporte";
        frmvistacliente form = new frmvistacliente();
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_btnbuscarclienteActionPerformed

    private void btnfiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfiltrarActionPerformed
        // TODO add your handling code here:
        
        mostrar(txtidcliente.getText());
    }//GEN-LAST:event_btnfiltrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmreportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmreportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmreportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmreportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmreportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscarcliente;
    private javax.swing.JButton btnfiltrar;
    private javax.swing.JButton btngenerarreporte;
    private javax.swing.JComboBox<String> cboeleccion;
    private com.toedter.calendar.JDateChooser dcfecha1;
    private com.toedter.calendar.JDateChooser dcfecha2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel reportefecha;
    public static javax.swing.JTextField txtidcliente;
    public static javax.swing.JTextField txtnombrecliente;
    // End of variables declaration//GEN-END:variables

}