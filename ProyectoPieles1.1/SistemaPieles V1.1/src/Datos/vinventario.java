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
public class vinventario {
    private int idinventario;
    private int idempleado;
    private int idproducto;
    private String presentacion;
    private Date fecha;
    private Double cantidad;
    private String estado;

    public vinventario() {
    }

    public vinventario(int idinventario, int idempleado, int idproducto, String presentacion, Date fecha, Double cantidad, String estado) {
        this.idinventario = idinventario;
        this.idempleado = idempleado;
        this.idproducto = idproducto;
        this.presentacion = presentacion;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public int getIdinventario() {
        return idinventario;
    }

    public void setIdinventario(int idinventario) {
        this.idinventario = idinventario;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
