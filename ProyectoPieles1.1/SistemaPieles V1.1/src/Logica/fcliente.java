/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vcliente;
//import static Presentacion.frmsaldoabono.cbocliente;
//import static Presentacion.frmsaldoabono.txtidcliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alan Itzep
 */
public class fcliente {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;
    
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {
            "ID",
            "Nombre",
            "Apellido",
            "Cliente",
            "Telefono",
            "Email",
            "Direccion",
            "Nit"   
        };
        
        String [] registro = new String[8];
        
            totalregistros = 0;
            modelo = new DefaultTableModel(null,titulos);
            
            sSQL = "select p.idpersona, p.nombre, p.apellido, p.completo, p.telefono, p.email, p.direccion,"
                    + "c.nit from persona p inner join cliente c "
                    + "on p.idpersona = c.idpersona where completo like '%"
                    + buscar +"%' order by idpersona desc";
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
                    registro[7] = rs.getString("nit");
                    
                    totalregistros = totalregistros +1;
                    modelo.addRow(registro);
                }
                return modelo;
            }catch(Exception e){
                JOptionPane.showConfirmDialog(null, e);
                return null;
            }
    }
    
//    public void cargarclientes(){
//        String registro;
//        sSQL = "select p.completo from persona p "
//                + "inner join cliente c on p.idpersona = c.idpersona ";
//        try{
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
//            
//            cbocliente.removeAllItems();
//            
//            while(rs.next()){
//                registro = rs.getString(1);
//                cbocliente.addItem(registro);
//            }
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
//    
//    public void cargaridclientes(String buscar){
//        String id;
//        sSQL = "select p.idpersona from persona p inner join cliente c on p.idpersona = c.idpersona where completo like '%" + buscar + "%'";
//        try {
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sSQL);
//
//            while (rs.next()) {
//                id = rs.getString(1);
//                txtidcliente.setText(id);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
//    
    public boolean insertar(vcliente dts){
        sSQL = "insert into persona (nombre, apellido,completo,telefono,email,direccion)"
                + " values(?,?,?,?,?,?)";
        
        sSQL2 = "insert into cliente (idpersona, nit) "
                + "values((select idpersona from persona order by idpersona desc limit 1), ?)";
        
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellido());
            pst.setString(3, dts.getCompleto());
            pst.setString(4, dts.getTelefono());
            pst.setString(5, dts.getEmail());
            pst.setString(6, dts.getDireccion());
            
            pst2.setString(1, dts.getNit());
            
            int n = pst.executeUpdate();
            
            if(n != 0 ){
                int n2 = pst2.executeUpdate();
                
                if(n2 != 0){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }       
    }
    
    public boolean editar(vcliente dts){
        sSQL = "update persona set nombre=?,apellido=?,completo=?,telefono=?,email=?,direccion=?"
                + "where idpersona=?";
        
        sSQL2 = "update cliente set nit=? "
                + "where idpersona=?";
        
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellido());
            pst.setString(3, dts.getCompleto());
            pst.setString(4, dts.getTelefono());
            pst.setString(5, dts.getEmail());
            pst.setString(6, dts.getDireccion());
            pst.setInt(7, dts.getIdpersona());
            
            pst2.setString(1, dts.getNit());
            pst2.setInt(2, dts.getIdpersona());
            
            int n = pst.executeUpdate();
            
            if(n != 0){
                int n2 = pst2.executeUpdate();
                
                if(n2 != 0){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean eliminar(vcliente dts){
        sSQL = "delete from cliente where idpersona=?";
        
        sSQL2 = "delete from persona where idpersona=?";
        
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            
            pst.setInt(1,dts.getIdpersona());
            
            pst2.setInt(1,dts.getIdpersona());
            
            int n = pst.executeUpdate();
            if(n != 0){
                int n2 = pst2.executeUpdate();
                
                if(n2 != 0){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
            
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}