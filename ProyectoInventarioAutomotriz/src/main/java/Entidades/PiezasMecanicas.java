/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author harol
 */
public class PiezasMecanicas extends PiezaAutomotriz {
    
    private String material;
    private String dimensiones;
    private int durabilidad;

    public PiezasMecanicas(int cantidad, String nombre, int id, int precio, String material, String dimensiones, int durabilidad) {
        super(id,nombre,cantidad,precio);

        this.dimensiones = dimensiones;
        this.durabilidad = durabilidad;
        this.material = material;
        
    }

 

    public String getMaterial() {
        return material;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public int getDurabilidad() {
        return durabilidad;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public void setDurabilidad(int durabilidad) {
        this.durabilidad = durabilidad;
    }

    @Override
    public String toString() {
        return "PiezasMecanicas{" +
        "id=" + getId () +
        ", nombre='" + getNombre () + '\'' +
        ", precio=" + getPrecio () +
        ", cantidad=" + getCantidad () +
        ", material='" + this.material + '\'' +
        ", dimensiones=" + this.dimensiones +
        ", durabilidad=" + this.durabilidad +
        '}';
    }
    


}
