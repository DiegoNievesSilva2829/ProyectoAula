/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Entidades.*;
/**
 *
 * @author harol
 */
public class VistaConsola {
    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void mostrarError(String mensaje) {
        System.err.println(mensaje);
    }

    public static void mostrarMenuPrincipal() {
        borrarPantalla();
        mostrarMensaje("----Menú Principal----");
        mostrarMensaje("1. Inventario");
        mostrarMensaje("2. Facturación");
        mostrarMensaje("3. Salir");
    }

    public static void mostrarMenuInventario() {
        borrarPantalla();
        mostrarMensaje("---Menú Inventario---");
        mostrarMensaje("1. Agregar pieza");
        mostrarMensaje("2. Buscar pieza");
        mostrarMensaje("3. Eliminar pieza");
        mostrarMensaje("4. Regresar al menú principal");
    }

    public static void mostrarMenuFacturacion() {
        borrarPantalla();
        mostrarMensaje("---Menu Facturación---");
        mostrarMensaje("1. Registrar venta");
        mostrarMensaje("2. Registrar compra");
        mostrarMensaje("3. Ver facturas");
        mostrarMensaje("4. Regresar al menú principal");
    }

    public static void borrarPantalla() {
        for (int i = 0; i < 2; i++) {  
            System.out.println();
        }
    }
}