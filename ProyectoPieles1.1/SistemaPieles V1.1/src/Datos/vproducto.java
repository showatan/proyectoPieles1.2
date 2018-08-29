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
public class vproducto {
    private int idproducto;
    private String nombre;
    private String descripcion;
    private Double precioventa;
    private Double preciocosto;

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(Double precioventa) {
        this.precioventa = precioventa;
    }

    public Double getPreciocosto() {
        return preciocosto;
    }

    public void setPreciocosto(Double preciocosto) {
        this.preciocosto = preciocosto;
    }

    public vproducto() {
    }

    public vproducto(int idproducto, String nombre, String descripcion, Double precioventa, Double preciocosto) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioventa = precioventa;
        this.preciocosto = preciocosto;
    }

    
}
