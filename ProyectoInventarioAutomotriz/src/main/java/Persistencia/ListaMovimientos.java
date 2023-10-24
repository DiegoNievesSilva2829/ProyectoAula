/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Movimiento;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author harol
 */
public class ListaMovimientos implements IListasMovimientos {
    private List<Movimiento> listaMovimientos;
    
    public ListaMovimientos () {
        this.listaMovimientos = new ArrayList();
    } 
    
    @Override
    public void adicionarMovimiento(Movimiento p) {
        this.listaMovimientos.add(p);
    }

    @Override
    public ArrayList<Movimiento> obtenerMovimiento() {
        ArrayList<Movimiento> lista = new ArrayList(this.listaMovimientos);
        return lista;
    }

    @Override
    public Movimiento buscarMovimiento(int noMovimiento) {
        Movimiento MovimientoBuscado = null;
        for(Movimiento p: this.listaMovimientos){
            if(p.getNumeroFactura()==noMovimiento){
                MovimientoBuscado = p;
                break;
            }
        
        }
        return MovimientoBuscado;
    }  
    
    @Override
    public int getConsecutivo(){
       int consecutivo = 1;
       if(!this.listaMovimientos.isEmpty()){     
            Movimiento m = this.listaMovimientos.get(this.listaMovimientos.size()-1);
            consecutivo = m.getNumeroFactura()+1;
       
       }
       return consecutivo;
    }
}
