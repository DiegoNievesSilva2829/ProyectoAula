/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Entidades.Movimiento;
import java.util.ArrayList;

/**
 *
 * @author harol
 */
public interface IListasMovimientos {
    
    public void adicionarMovimiento(Movimiento p);
    public ArrayList<Movimiento> obtenerMovimiento();
    public Movimiento buscarMovimiento(int noMovimiento);
    public int getConsecutivo();
    
}
