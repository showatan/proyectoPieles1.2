/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vdetalleventa;
import Datos.vventa;
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
public class fventa {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Integer totalregistros;
    public Double totalmedida;
    public Double totalventa;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {
            "ID venta",//0
            "ID cliente",//1
            "Cliente",
            "ID empleado",
            "Empleado",
            "Fecha Venta",
            "Total Medida",
            "Total Venta",
            "Tipo Pago",
        };
                
        String [] registro = new String[9];
        
        totalventa = 0.00;
            modelo = new DefaultTableModel(null, titulos);
            
            sSQL = "select v.idventa, "
                    + "v.idcliente, (select completo from persona where idpersona = v.idcliente) as clientec, "
                    + "v.idempleado,(select completo from persona where idpersona = v.idempleado) as empleadoc,"
                    + "v.fechaventa,v.totalmedida,v.totalventa,v.tipopago "
                    + "from venta v order by v.idventa desc";
            try{
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sSQL);
                
                while(rs.next()){
                    registro[0] = rs.getString("idventa");
                    registro[1] = rs.getString("idcliente");
                    registro[2] = rs.getString("clientec");
                    registro[3] = rs.getString("idempleado");
                    registro[4] = rs.getString("empleadoc");
                    registro[5] = rs.getString("fechaventa");
                    registro[6] = rs.getString("totalmedida");
                    registro[7] = rs.getString("totalventa");
                    registro[8] = rs.getString("tipopago");
                    
                    totalventa = totalventa +(rs.getDouble("totalventa"));
                    modelo.addRow(registro);
                }
                return modelo;
            }catch(Exception e){
                JOptionPane.showConfirmDialog(null, e);
                return null;
            }
    }
    
    public DefaultTableModel mostrarinabono(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {
            "ID venta",//0
            "ID cliente",//1
            "Cliente",
            "ID empleado",//3
            "Empleado",//4
            "Fecha Venta",//x5
            "Total Medida (pie)",//6
            "Total Venta (Q)",//7
            "Tipo Pago",//8
        };
        
        String [] registro = new String[9];
        
        
        totalregistros = 0;
        totalmedida = 0.00;
        totalventa = 0.00;
        
            modelo = new DefaultTableModel(null, titulos);
            
            sSQL = "select v.idventa,v.idcliente, "
                    + "(select nombre from persona where idpersona = v.idcliente) as clienten, "
                    + "(select apellido from persona where idpersona = v.idcliente) as clineteap, "
                    + "v.idempleado,(select nombre from persona where idpersona = v.idempleado) as empleadon,"
                    + "(select apellido from persona where idpersona = v.idempleado) as empleadoap, "
                    + "v.fechaventa,v.totalmedida,v.totalventa,v.tipopago "
                    + "from venta v where v.idcliente like '"
                    + buscar +"' order by idventa desc";
            try{
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sSQL);
                
                while(rs.next()){
                    registro[0] = rs.getString("idventa");
                    registro[1] = rs.getString("idcliente");
                    registro[2] = rs.getString("clienten")+" "+rs.getString("clineteap");
                    registro[3] = rs.getString("idempleado");
                    registro[4] = rs.getString("empleadon")+" "+rs.getString("empleadoap");
                    registro[5] = rs.getString("fechaventa");
                    registro[6] = rs.getString("totalmedida");
                    registro[7] = rs.getString("totalventa");
                    registro[8] = rs.getString("tipopago");
                    
                    totalregistros = totalregistros+1;
                    totalmedida = totalmedida+(rs.getDouble("totalmedida"));
                    totalventa = totalventa+(rs.getDouble("totalventa"));
                    
                    modelo.addRow(registro);
                }
                return modelo;
            }catch(Exception e){
                JOptionPane.showConfirmDialog(null, e);
                return null;
            }
    }
        
    public boolean insertar(vventa dts){
        sSQL = "insert into venta(idcliente, idempleado,fechaventa,totalmedida,totalventa,tipopago) "
                + "values(?,?,?,?,?,?)";
        
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdcliente());
            pst.setInt(2, dts.getIdempleado());
            pst.setDate(3, dts.getFechaventa());
            pst.setDouble(4, dts.getTotalmedida());
            pst.setDouble(5,dts.getTotalventa());
            pst.setString(6, dts.getTipopago());
            
            int n = pst.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean editar(vventa dts){
        sSQL = "update venta set idcliente=?, idempleado=?,fechaventa=?,totalmedida=?,totalventa=?,tipopago=? "
                + "where idventa=?";
        
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdcliente());
            pst.setInt(2, dts.getIdempleado());
            pst.setDate(3, dts.getFechaventa());
            pst.setDouble(4, dts.getTotalmedida());
            pst.setDouble(5,dts.getTotalventa());
            pst.setString(6, dts.getTipopago());
            
            pst.setInt(7, dts.getIdventa());
            
            int n = pst.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null,e);
            return false;
        }
    }
    
    public boolean eliminar(vventa dts){
        sSQL = "delete from venta where idventa = ?";
        try{
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdventa());
            
            int n = pst.executeUpdate();
            
            if(n!=0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null,e);
            return false;
        }
    }
}
