/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author harol
 */
public class PiezasElectricas extends PiezaAutomotriz {
    
    private double resistencia;
    private double voltaje;


    public PiezasElectricas(double resistencia, double voltaje, int id, String nombre, int cantidad, int precio) {
        super(id, nombre, cantidad, precio);
        this.resistencia = resistencia;
        this.voltaje = voltaje;
    }

    public double getResistencia() {
        return resistencia;
    }

    public double getVoltaje() {
        return voltaje;
    }

    public void setResistencia(float resistencia) {
        this.resistencia = resistencia;
    }

    public void setVoltaje(float voltaje) {
        this.voltaje = voltaje;
    }

    @Override
    public String toString() {
        return "PiezasElectricas{" +
        "id=" + getId () +
        ", nombre='" + getNombre () + '\'' +
        ", precio=" + getPrecio () +
        ", cantidad=" + getCantidad () +
        ", resistencia=" + String.format ("%.2f", this.resistencia) +
        ", voltaje=" + String.format ("%.2f", this.voltaje) +
        '}';
}
    
   
}
