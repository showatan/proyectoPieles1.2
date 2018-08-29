/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SONY
 */
public class festado {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar (String buscar){
        DefaultTableModel modelo;
        String[] titulos = {
                 "ID",
                 "Documento",
                 "Fecha",
                 "Concepto",
                 "Venta",
                 "Abono",
                 "Saldo"};
        String [] registro = new String [7];
        
            totalregistros = 0;
            modelo = new DefaultTableModel(null, titulos);
            
            sSQL = "SELECT a.idabono, a.fechaabono, a.descripcion, a.abono ";
            try{
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sSQL);
                
                while(rs.next()){
                    registro[0] = rs.getString("idpersona");
                    registro[1] = rs.getString("nombre");
                    registro[2] = rs.getString("apellido");
                    registro[3] = rs.getString("completo");
                    registro[4] = rs.getString("telefono");
                    registro[5] = rs.getString("email");
                    registro[6] = rs.getString("direccion");
                    registro[7] = rs.getString("acceso");
                    registro[8] = rs.getString("login");
                    registro[9] = rs.getString("password");
                    registro[10] = rs.getString("estado");
                    
                    totalregistros = totalregistros + 1;
                    modelo.addRow(registro);
                }
                return modelo;
            }catch(Exception e){
                JOptionPane.showConfirmDialog(null, e);
                return null;
            }
    }
}
