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
public class Ventas extends Movimiento {
    
    private double descuento;

    public Ventas() {
    }

    public Ventas(String nombrePersona, int numeroFactura, String fechaFactura,int precio, int cantidad, ArrayList<PiezaAutomotriz> piezas) {
        super(nombrePersona, numeroFactura, fechaFactura, precio, cantidad, piezas);
        this.descuento = descuento;

    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Ventas{" +
        "nombrePersona='" + getNombrePersona () + '\'' +
        ", numeroFactura='" + getNumeroFactura () + '\'' +
        ", fechaFactura='" + getFechaFactura () + '\'' +
        ", precio=" + getPrecio () +
        ", cantidad=" + getCantidad () +
        ", piezas=" + getPiezas () +
        ", descuento=" + descuento +
        '}';
}
    
    // Usamos la anotación @Override para indicar que estamos sobrescribiendo el método de la clase padre
    @Override
    // Usamos la palabra clave final para los parámetros que no vamos a modificar dentro del método
    public double calcularPrecioFinal (boolean pagoInmediato) {

        double precio = getPrecio ();
        int cantidad = getCantidad ();
        double subtotal = precio * cantidad;
        
        if (pagoInmediato) {
            this.descuento = (float) 0.1;
        } 
        else {
            this.descuento = (float) 0.05;
        }
  
        double montoDescuento = subtotal * this.descuento;
        double precioFinal = subtotal - montoDescuento;
  
        // Usamos un formato numérico para mostrar el precio final con dos decimales
        System.out.printf ("El subtotal es: %.2f\n", subtotal);
        System.out.printf ("El monto del descuento es: %.2f\n", montoDescuento);
        System.out.printf ("El precio final es: %.2f\n", precioFinal);

        return precioFinal;
}
    
}