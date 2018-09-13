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
    private int idcliente;
    private int idventa;
    private Double venta;
    private int idabono;
    private Double abono;
    private Double saldo;

    public vestado() {
    }

    public vestado(int idestado, int idcliente, int idventa, Double venta, int idabono, Double abono, Double saldo) {
        this.idestado = idestado;
        this.idcliente = idcliente;
        this.idventa = idventa;
        this.venta = venta;
        this.idabono = idabono;
        this.abono = abono;
        this.saldo = saldo;
    }

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public Double getVenta() {
        return venta;
    }

    public void setVenta(Double venta) {
        this.venta = venta;
    }

    public int getIdabono() {
        return idabono;
    }

    public void setIdabono(int idabono) {
        this.idabono = idabono;
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
