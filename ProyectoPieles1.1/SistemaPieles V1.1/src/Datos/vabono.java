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
public class vabono {
    private int idabono;
    private int idcliente;
    private String descripcion;
    private Date fechaabono;
    private Double abono;

    public vabono() {
    }

    public vabono(int idabono, int idcliente, String descripcion, Date fechaabono, Double abono) {
        this.idabono = idabono;
        this.idcliente = idcliente;
        this.descripcion = descripcion;
        this.fechaabono = fechaabono;
        this.abono = abono;
    }

    public int getIdabono() {
        return idabono;
    }

    public void setIdabono(int idabono) {
        this.idabono = idabono;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaabono() {
        return fechaabono;
    }

    public void setFechaabono(Date fechaabono) {
        this.fechaabono = fechaabono;
    }

    public Double getAbono() {
        return abono;
    }

    public void setAbono(Double abono) {
        this.abono = abono;
    }
    
    
}
