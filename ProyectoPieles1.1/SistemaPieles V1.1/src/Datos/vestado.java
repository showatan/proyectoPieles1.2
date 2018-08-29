/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;

/**
 *
 * @author SONY
 */
public class vestado {
    private int idestado;
    private int id;
    private Date fecha;
    private String concepto;
    private Double venta;
    private Double abono;
    private Double saldo;

    public vestado() {
    }

    public vestado(int idestado, int id, Date fecha, String concepto, Double venta, Double abono, Double saldo) {
        this.idestado = idestado;
        this.id = id;
        this.fecha = fecha;
        this.concepto = concepto;
        this.venta = venta;
        this.abono = abono;
        this.saldo = saldo;
    }

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Double getVenta() {
        return venta;
    }

    public void setVenta(Double venta) {
        this.venta = venta;
    }

    public Double getAbono() {
        return abono;
    }

    public void setAbono(Double abono) {
        this.abono = abono;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
