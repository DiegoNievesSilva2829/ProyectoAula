/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author harol
 */
public abstract class Movimiento {
    
    protected String nombrePersona;
    protected int numeroFactura;
    protected String fechaFactura;
    protected int precio;
    protected int cantidad;
    protected ArrayList<PiezaAutomotriz> piezas;

    public Movimiento() {
    }

    public Movimiento(String nombrePersona, int numeroFactura, String fechaFactura, int precio, int cantidad, ArrayList<PiezaAutomotriz> piezas) {
        this.nombrePersona = nombrePersona;
        this.numeroFactura = numeroFactura;
        this.fechaFactura = fechaFactura;
        this.precio = precio;
        this.cantidad = cantidad;
        this.piezas = piezas;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public ArrayList<PiezaAutomotriz> getPiezas() {
        return piezas;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPiezas(ArrayList<PiezaAutomotriz> piezas) {
        this.piezas = piezas;
    }

    @Override
    public abstract String toString();
    
    public abstract double calcularPrecioFinal (boolean pagoInmediato);

      
}
