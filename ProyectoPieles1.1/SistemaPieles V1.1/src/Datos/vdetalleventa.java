/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Alan Itzep
 */
public class vdetalleventa {
    private int iddetalleventa;
    private int idventa;
    private int idproducto;
    private Double medida;
    private Double subtotal;

    public vdetalleventa() {
    }

    public vdetalleventa(int iddetalleventa, int idventa, int idproducto, Double medida, Double subtotal) {
        this.iddetalleventa = iddetalleventa;
        this.idventa = idventa;
        this.idproducto = idproducto;
        this.medida = medida;
        this.subtotal = subtotal;
    }

    public int getIddetalleventa() {
        return iddetalleventa;
    }

    public void setIddetalleventa(int iddetalleventa) {
        this.iddetalleventa = iddetalleventa;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public Double getMedida() {
        return medida;
    }

    public void setMedida(Double medida) {
        this.medida = medida;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    
}
