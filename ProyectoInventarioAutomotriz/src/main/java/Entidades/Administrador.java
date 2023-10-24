/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author harol
 */
public class Administrador extends Persona {
    
    private String usuario;
    private String contraseña;
    
    public Administrador(){
    }
    
    public Administrador(String usuario,String contraseña,String nombre,String identificacion){
        super(nombre,identificacion);
        this.usuario=usuario;
        this.contraseña=contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return String.format("Administrador{nombre='%s', identificacion='%s', usuario='%s', contraseña='%s'}", 
            getNombre(), getIdentificacion(), this.usuario, this.contraseña.replaceAll("\\.", "*"));
    }
    
    @Override
    public String Rol() {
         return "Administrador";
}
    
    
    
}








