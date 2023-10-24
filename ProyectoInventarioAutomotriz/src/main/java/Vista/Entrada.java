/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author harol
 */
public class Entrada {
    private static Scanner scanner = new Scanner(System.in);

    public static String leerString(String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.next();
    }

    public static int leerInt(String mensaje) {
        System.out.print(mensaje + ": ");
        int valor = scanner.nextInt();
        scanner.nextLine();  
        return valor;
    }

    public static double leerDouble(String mensaje) {
        System.out.print(mensaje + ": ");
        double valor = scanner.nextDouble();
        scanner.nextLine();  
        return valor;
    }

    public static char leerChar(String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.next().toUpperCase().charAt(0);
    }
    
    public static LocalDate leerFecha(String mensaje){
        System.out.printf("> %-20s:\n", mensaje);
        
        int anio = leerInt("Año(aaaa)");
        int mes = leerInt("Mes(1-12)");
        int dia = leerInt("Dia(1-31)");
        
        return LocalDate.of(anio, mes, dia);
    }
}
    