 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alan Itzep
 */
public class conexion {
    public String db = "bdpieles";
    public String url = "jdbc:mysql://192.168.1.18/"+db;//127.0.0.1
    public String user = "tecnopiel";
    public String pass = "tecnopiel123";
    public conexion(){
}
    public Connection conectar(){
        Connection link = null;
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url, this.user, this.pass);
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showConfirmDialog(null,e);
            
        }
        return link;
    }  
}