/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author harol
 */
public class Login {
    private String usuario;
    private String contraseña;

    public Login(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public boolean validarUsuario(String usuario, String contraseña) {
        return this.usuario.equals(usuario) && this.contraseña.equals(contraseña);
    }
}