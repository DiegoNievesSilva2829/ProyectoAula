/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Vista;

import Entidades.*;
import Logica.LogicaInventarioAutomotriz;
import Logica.LogicaListaMovimientos;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author harol
 */
public class Principal {
    private LogicaInventarioAutomotriz Inventario;
    private LogicaListaMovimientos movimiento;
    private List<Movimiento> Facturas;
    private Login Login;

    public Principal() {  
        this.Inventario = new LogicaInventarioAutomotriz();
        this.movimiento = new LogicaListaMovimientos();
        this.Facturas = new ArrayList<Movimiento>();
        this.Login = new Login("Admin", "12345"); // Cambiar por el usuario y contraseña deseados
    }
    
    public void iniciar() {
        System.out.println("--LOGIN--");
        System.out.println("Ingrese los datos que se le pedirán acontinuación");
       String usuario = Entrada.leerString("Usuario");
       String contraseña = Entrada.leerString("Contraseña");

       if (!Login.validarUsuario(usuario, contraseña)) {
           VistaConsola.mostrarError("Usuario o contraseña incorrectos");
           return;
       }

       while (true) {
           VistaConsola.mostrarMenuPrincipal();
           int opcion = Entrada.leerInt("Seleccione una opción");

           switch (opcion) {
               case 1:
                   manejarInventario();
                   break;
               case 2:
                   manejarFacturacion();
                   break;
               case 3:
                   return;
               default:
                   VistaConsola.mostrarError("Opción no válida");
           }
       }
   }
   
    private void manejarInventario() {
        while (true) {
            VistaConsola.mostrarMenuInventario();
            int opcion = Entrada.leerInt("Seleccione una opción");

            switch (opcion) {
                case 1:
                    agregarPiezaAutomotriz();
                    break;
                case 2:
                    buscarPiezaAutomotriz();
                    break;
                case 3:
                    eliminarPiezaAutomotriz();
                    break;
                case 4:
                    return;
                default:
                    VistaConsola.mostrarError("Opción no válida");
            }
        }
    }

    private void manejarFacturacion() {
        while (true) {
            VistaConsola.mostrarMenuFacturacion();
            int opcion = Entrada.leerInt("Seleccione una opción");

            switch (opcion) {
                case 1:
                    registrarVenta();
                    break;
                case 2:
                    registrarCompra();
                    break;
                case 3:
                    verFacturas();
                    break;
                case 4:
                    return;
                default:
                    VistaConsola.mostrarError("Opción no válida");
            }
        }
    }
    
    public void agregarPiezaAutomotriz() {
        int continuar;
        do {
            System.out.println("");
            System.out.println(" 1. AGREGAR PIEZA AUTOMOTRIZ ");
            System.out.println("-----------------------------");
            PiezaAutomotriz nuevaPieza;
            int id = Entrada.leerInt("ID de la pieza automotriz");
            String nombre = Entrada.leerString("Nombre de la pieza automotriz");
            int cantidad = Entrada.leerInt("Cantidad de piezas automotriz");
            int precio = Entrada.leerInt("Precio de la pieza automotriz");
            char tipoPieza = Entrada.leerChar("Tipo de pieza [E->Electrica][*->Mecanica]");

            switch (tipoPieza) {
                case 'E':
                    double resistencia = Entrada.leerDouble("Resistencia de la pieza automotriz: ");
                    double voltaje = Entrada.leerDouble("Voltaje de la pieza automotriz:");
                    nuevaPieza = new PiezasElectricas(resistencia, voltaje, id, nombre, cantidad, precio );
                    break;
                default:
                    String material = Entrada.leerString("Material de la pieza automotriz:");
                    String dimensiones = Entrada.leerString("Dimensiones de la pieza automotriz:");
                    int durabilidad = Entrada.leerInt("Durabilidad en años de la pieza automotriz:");
                    nuevaPieza = new PiezasMecanicas(cantidad, nombre, id, precio, material, dimensiones, durabilidad);
            }

        this.Inventario.agregarPiezaAutomotriz(nuevaPieza);
        System.out.println("Pieza registrada con exito");

        continuar = Entrada.leerInt("Desea registrar otra pieza [1->Si][Otro->No]");
    } while (continuar == 1);
        
    }
    
    public void buscarPiezaAutomotriz() {
    int continuar;
    do {
        System.out.println("");
        System.out.println("| ## 2. BUSQUEDA DE PIEZA AUTOMOTRIZ ## |");
        System.out.println("----------------------------------------");
        int id = Entrada.leerInt("ID de la pieza");
        
        PiezaAutomotriz piezaBuscada = this.Inventario.buscarPiezaAutomotriz(id);
        if(piezaBuscada == null){
            System.out.println("La pieza con el ID " + id + " no ha sido registrada \n ");
        }
        
        System.out.println(piezaBuscada);
        System.out.println("---------------------------------");
        System.out.println("");     
        continuar = Entrada.leerInt("Desea buscar otra pieza [1->Si][Otro->No]");
    } while (continuar == 1);
}
    
    public void eliminarPiezaAutomotriz() {
        int id = Entrada.leerInt("ID de la pieza");

        PiezaAutomotriz pieza = Inventario.buscarPiezaAutomotriz(id);
        if (pieza != null) {
            Inventario.eliminarPiezaAutomotriz(pieza);
            VistaConsola.mostrarMensaje(pieza.getNombre() + " ha sido eliminado del inventario.");
        } else {
            VistaConsola.mostrarError("La pieza no se encuentra en el inventario.");
        }
    }
    
    public void registrarVenta() {
    
    while (true) {
        int totalVentas = 0; // Variable para almacenar el total de ventas
        int totalCantidad= 0;
        System.out.println("");
        System.out.println(" 1. REGISTRO DE VENTA ");
        System.out.println("--------------------------------");
        ArrayList<PiezaAutomotriz> listaproductos = new ArrayList<PiezaAutomotriz>();
        int continuar1 = 1;
        do {
            
            int id = Entrada.leerInt("ID de la pieza a vender: ");
            PiezaAutomotriz pieza = Inventario.buscarPiezaAutomotriz(id);

            if( pieza == null) {
                VistaConsola.mostrarError("La pieza no existe en el inventario");
            }
            else {
                int cantidad = Entrada.leerInt("Cantidad de piezas:");
                if (cantidad > pieza.getCantidad()){
                VistaConsola.mostrarError("Error... No hay suficientes piezas");
                }else {
                    pieza.cantidadVenta= cantidad;
                    double precioVenta = cantidad * pieza.getPrecio();// Calcular el precio de venta
                    totalCantidad += cantidad;
                    totalVentas += precioVenta; // Actualizar el total de ventas
                    listaproductos.add(pieza);
                }
            }
            
            continuar1 = Entrada.leerInt("¿Desea agregar otra pieza? [1->Si][Otro->No]: ");
            
        } while (continuar1 == 1);
        

            String nombrePersona = Entrada.leerString("Nombre del comprador:");
            String fechaFactura = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
            Ventas movimiento = new Ventas(nombrePersona, this.movimiento.getConsecutivo(),fechaFactura,totalVentas, totalCantidad, listaproductos);
            this.movimiento.RegistrarListaMovimientos(movimiento); // Añadir el movimiento a la lista
            VistaConsola.mostrarMensaje("Venta registrada con éxito.");
            VistaConsola.mostrarMensaje("Precio de venta: " + totalVentas);
            
            for(PiezaAutomotriz piezaVendida : listaproductos){
                PiezaAutomotriz piezaActual = this.Inventario.buscarPiezaAutomotriz(piezaVendida.getId());
                
                int cantidadActual = piezaActual.getCantidad();
                int cantidadVendida = piezaVendida.cantidadVenta;
                
                piezaActual.setCantidad(cantidadActual - cantidadVendida);
                
                this.Inventario.actualizarPiezaAutomotriz(piezaActual);
            }
        

        int continuar = Entrada.leerInt("¿Desea agregar otra venta? [1->Si][Otro->No]: ");
        if (continuar != 1) {
            break; // Salir del bucle si no se desea agregar otra pieza
        }
        
    }

    }

    public void registrarCompra() {    
    while (true) {
        int totalVentas = 0; 
        int totalCantidad= 0; 
        System.out.println("");
        System.out.println(" 2. REGISTRO DE COMPRA ");
        System.out.println("--------------------------------");
        ArrayList<PiezaAutomotriz> listaproductos = new ArrayList<PiezaAutomotriz>();
        int continuar1 = 1;
        do {
            int id = Entrada.leerInt("ID de la pieza a comprar: ");
            PiezaAutomotriz pieza = Inventario.buscarPiezaAutomotriz(id);
            if( pieza == null) {
                VistaConsola.mostrarError("La pieza no existe en el inventario");
            }
            else {
                int cantidad = Entrada.leerInt("Cantidad de piezas:");
                if (cantidad > pieza.getCantidad()){
                VistaConsola.mostrarError("Error... No hay suficientes piezas");
                }else {
                    pieza.cantidadVenta= cantidad;
                    double precioVenta = cantidad * pieza.getPrecio();
                    totalCantidad += cantidad;
                    totalVentas += precioVenta;
                    listaproductos.add(pieza);
                }
            } 
            continuar1 = Entrada.leerInt("¿Desea agregar otra pieza? [1->Si][Otro->No]: ");
            
        } while (continuar1 == 1);
            String nombrePersona = Entrada.leerString("Nombre del vendedor:");
            String fechaFactura = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
            Ventas movimiento = new Ventas(nombrePersona, this.movimiento.getConsecutivo(),fechaFactura,totalVentas, totalCantidad, listaproductos);
            this.movimiento.RegistrarListaMovimientos(movimiento);
            VistaConsola.mostrarMensaje("Compra registrada con éxito.");
            VistaConsola.mostrarMensaje("Precio de compra: " + totalVentas);
            for(PiezaAutomotriz piezaVendida : listaproductos){
                PiezaAutomotriz piezaActual = this.Inventario.buscarPiezaAutomotriz(piezaVendida.getId());
                int cantidadActual = piezaActual.getCantidad();
                int cantidadVendida = piezaVendida.cantidadVenta;
                
                piezaActual.setCantidad(cantidadActual + cantidadVendida);
                
                this.Inventario.actualizarPiezaAutomotriz(piezaActual);
            }
        int continuar = Entrada.leerInt("¿Desea agregar otra compra? [1->Si][Otro->No]: ");
        if (continuar != 1) {
            break; 
        }
        
    }

    }
    
    
    public void verFacturas() {
        Facturas = this.movimiento.ConsultarListaMovimiento();
        for (Movimiento factura : Facturas) {
            VistaConsola.mostrarMensaje(factura.toString());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Principal principal = new Principal();
    principal.iniciar();
    }
    
}

