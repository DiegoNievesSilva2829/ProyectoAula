/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Entidades.PiezaAutomotriz;
import java.util.List;
import Persistencia.*;

public class LogicaInventarioAutomotriz {
    
    private IInventarioAutomotriz data;

    public LogicaInventarioAutomotriz() {
        this.data = new InventarioAutomotriz();
    }
    
    public void agregarPiezaAutomotriz(PiezaAutomotriz p){
       this.data.agregarPiezaAutomotriz(p);
    }
    
    public PiezaAutomotriz buscarPiezaAutomotriz(int id){
        return this.data.buscarPiezaAutomotriz(id);
    }
    
    public List<PiezaAutomotriz> obtenerListaPiezaAutomotriz(){
        return this.data.obtenerListaPiezaAutomotriz();
    }
    
    public void eliminarPiezaAutomotriz(PiezaAutomotriz p){
         this.data.eliminarPiezaAutomotriz(p);
    }
    
      public void actualizarPiezaAutomotriz(PiezaAutomotriz p){
       this.data.actualizarPiezaAutomotriz(p);
    } 
}
