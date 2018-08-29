/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author SONY
 */
public class Iconos implements Icon{
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y){
        Image image = new ImageIcon(getClass().getResource("/Files/print.png")).getImage();
        g.drawImage(image, x, y, c);
    }

    @Override
    public int getIconWidth() {
        return 65; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIconHeight() {
        return 65; //To change body of generated methods, choose Tools | Templates.
    }
    
}
