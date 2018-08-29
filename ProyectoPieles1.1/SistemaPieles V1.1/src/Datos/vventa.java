/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;

/**
 *
 * @author Alan Itzep
 */
public class vventa {
    private int idventa;
    private int idcliente;
    private int idempleado;
    private Date fechaventa;
    private Double totalmedida;
    private Double totalventa;
    private String tipopago;

    public vventa() {
    }

    public vventa(int idventa, int idcliente, int idempleado, Date fechaventa, Double totalmedida, Double totalventa, String tipopago) {
        this.idventa = idventa;
        this.idcliente = idcliente;
        this.idempleado = idempleado;
        this.fechaventa = fechaventa;
        this.totalmedida = totalmedida;
        this.totalventa = totalventa;
        this.tipopago = tipopago;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public Date getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(Date fechaventa) {
        this.fechaventa = fechaventa;
    }

    public Double getTotalmedida() {
        return totalmedida;
    }

    public void setTotalmedida(Double totalmedida) {
        this.totalmedida = totalmedida;
    }

    public Double getTotalventa() {
        return totalventa;
    }

    public void setTotalventa(Double totalventa) {
        this.totalventa = totalventa;
    }

    public String getTipopago() {
        return tipopago;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;
    }

    
}
