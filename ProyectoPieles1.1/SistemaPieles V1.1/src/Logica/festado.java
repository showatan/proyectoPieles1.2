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
                 "ID Cliente",
                 "Cliente",
                 "ID Venta",
                 "Venta",
                 "ID Abono",
                 "Abono",
                 "Saldo"};
        String [] registro = new String [8];
        
            totalregistros = 0;
            modelo = new DefaultTableModel(null, titulos);
            
            sSQL = "SELECT e.idestado,(select idpersona from cliente) as idcliente, "
                    + "(SELECT completo FROM persona INNER JOIN cliente WHERE persona.idpersona = cliente.idpersona) as completo, "
                    + "e.idventa, e.venta, e.idabono,"
                    + "e.abono,e.saldo from estado e order by e.idestado desc";
            try{
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sSQL);
                
                while(rs.next()){
                    registro[0] = rs.getString("idestado");
                    registro[1] = rs.getString("idcliente");
                    registro[2] = rs.getString("completo");
                    registro[3] = rs.getString("idventa");
                    registro[4] = rs.getString("venta");
                    registro[5] = rs.getString("idabono");
                    registro[6] = rs.getString("abono");
                    registro[7] = rs.getString("saldo");
//                    registro[8] = rs.getString("login");
//                    registro[9] = rs.getString("password");
//                    registro[10] = rs.getString("estado");
                    
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
