/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vempleado;
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
public class fempleado {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar (String buscar){
        DefaultTableModel modelo;
        String[] titulos = {
                 "ID",//0
                 "Nombre",//1
                 "Apellido",//2
                 "Completo",//3
                 "Telefono",//4
                 "Email",//5
                 "Direccion",//6
                 "Acceso",//7
                 "Login",//8
                 "Clave",//9
                 "Estado"};//10
        String [] registro = new String [11];
        
            totalregistros = 0;
            modelo = new DefaultTableModel(null, titulos);
            
            sSQL = "select p.idpersona, p.nombre, p.apellido,p.completo, p.telefono, p.email, p.direccion, "
                    + "e.acceso, e.login, e.password, e.estado from persona p inner join empleado e "
                    + "on p.idpersona = e.idpersona where nombre like '%"
                    + buscar + "%' order by idpersona desc";
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
    
    public boolean insertar (vempleado dts){
        sSQL = "insert into persona (nombre,apellido,completo,telefono,email,direccion)"
                + "values(?,?,?,?,?,?)";
        sSQL2 = "insert into empleado (idpersona,acceso,login,password,estado) "
                + "values ((select idpersona from persona order by idpersona desc limit 1),?,?,?,?)";
        
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellido());
            pst.setString(3, dts.getCompleto());
            pst.setString(4, dts.getTelefono());
            pst.setString(5, dts.getEmail());
            pst.setString(6, dts.getDireccion());
            
            pst2.setString(1, dts.getAcceso());
            pst2.setString(2, dts.getLogin());
            pst2.setString(3, dts.getPassword());
            pst2.setString(4, dts.getEstado());
            
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
    
    
    public boolean editar(vempleado dts){
        sSQL = "update persona set nombre = ?,apellido = ?,completo = ?,telefono = ?,email = ?,direccion = ? "
                + "where idpersona  = ?";
        
        sSQL2 = "update empleado set acceso = ?,login = ?,password = ?,estado = ? "
                + "where idpersona = ?";
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
            
            pst2.setString(1, dts.getAcceso());
            pst2.setString(2, dts.getLogin());
            pst2.setString(3, dts.getPassword());
            pst2.setString(4, dts.getEstado());
            pst2.setInt(5, dts.getIdpersona());
            
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
    
    public boolean eliminar(vempleado dts){
        sSQL = "delete from empleado where idpersona = ?";
        sSQL2 = "delete from persona where idpersona = ?";
        
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            
            pst.setInt(1, dts.getIdpersona());
            
            pst2.setInt(1, dts.getIdpersona());
            
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
            JOptionPane.showConfirmDialog(null,e);
            return false;
        }
    }
    
    
    public DefaultTableModel login(String login, String password){
        DefaultTableModel modelo;
        
        String [] titulos = {
                 "ID",
                 "Nombre",
                 "Apellido",
                 "Acceso",
                 "Login",
                 "Clave",
                 "Estado"};
        String [] registro = new String[7];
        
            totalregistros = 0;
            modelo = new DefaultTableModel(null, titulos);
            
            sSQL = "select p.idpersona, p.nombre, p.apellido,"
                    + "e.acceso,e.login,e.password,e.estado from persona p inner join empleado e "
                    + "on p.idpersona=e.idpersona where e.login='"
                    + login + "' and e.password='" + password + "' and e.estado= 'A'"; 
            try{
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sSQL);
                
                while(rs.next()){
                    registro[0] = rs.getString("idpersona");
                    registro[1] = rs.getString("nombre");
                    registro[2] = rs.getString("apellido");
                    registro[3] = rs.getString("acceso");
                    registro[4] = rs.getString("login");
                    registro[5] = rs.getString("password");
                    registro[6] = rs.getString("estado");
                    
                    totalregistros = totalregistros +1;
                    modelo.addRow(registro);
                }
                return modelo;
            }catch(Exception e){
                JOptionPane.showConfirmDialog(null, e);
                return null;
            }
    }
}