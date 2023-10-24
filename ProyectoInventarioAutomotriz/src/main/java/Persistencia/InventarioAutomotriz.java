/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.PiezaAutomotriz;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harol
 */
public class InventarioAutomotriz implements IInventarioAutomotriz {
    private List<PiezaAutomotriz> ListaPiezaAutomotriz;
    
    public InventarioAutomotriz (){
        this.ListaPiezaAutomotriz = new ArrayList () ;
    }

    @Override
    public void agregarPiezaAutomotriz(PiezaAutomotriz p) {
        this.ListaPiezaAutomotriz.add(p);
    }

    @Override
    public ArrayList<PiezaAutomotriz> obtenerListaPiezaAutomotriz() {
        ArrayList<PiezaAutomotriz> lista = new ArrayList(this.ListaPiezaAutomotriz);
        return lista;
    }
    
    @Override
    public PiezaAutomotriz buscarPiezaAutomotriz(int id) {
        PiezaAutomotriz piezaBuscada = null;
        for(PiezaAutomotriz pieza: this.ListaPiezaAutomotriz){
            if(pieza.getId()==id){
                piezaBuscada = pieza;
                break;
            }
        
        }
        return piezaBuscada;
    }
    
    @Override
    public void eliminarPiezaAutomotriz(PiezaAutomotriz p) {
        this.ListaPiezaAutomotriz.remove(p);
    }
    
    public InventarioAutomotriz(List<PiezaAutomotriz> ListaPiezaAutomotriz) {
        this.ListaPiezaAutomotriz = ListaPiezaAutomotriz;
    }

    public List<PiezaAutomotriz> getListaPiezaAutomotriz() {
        return ListaPiezaAutomotriz;
    }

    public void setListaPiezaAutomotriz(List<PiezaAutomotriz> ListaPiezaAutomotriz) {
        this.ListaPiezaAutomotriz = ListaPiezaAutomotriz;
    }

    @Override
    public void actualizarPiezaAutomotriz(PiezaAutomotriz p){
        int indice = this.ListaPiezaAutomotriz.indexOf(p);
        this.ListaPiezaAutomotriz.set(indice, p);
    } 
    
    
}