/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Entidades.PiezaAutomotriz;
import java.util.ArrayList;
/**
 *
 * @author harol
 */
public interface IInventarioAutomotriz {
    
    public void agregarPiezaAutomotriz(PiezaAutomotriz p);
    public ArrayList<PiezaAutomotriz> obtenerListaPiezaAutomotriz();
    public void eliminarPiezaAutomotriz(PiezaAutomotriz p);
    public PiezaAutomotriz buscarPiezaAutomotriz(int id);
    public void actualizarPiezaAutomotriz(PiezaAutomotriz p);

}
    

