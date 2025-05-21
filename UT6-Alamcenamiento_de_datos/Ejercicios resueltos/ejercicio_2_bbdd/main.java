/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_2_bbdd;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Javier
 */
public class main {

    public static final String COLOR_ROJO = "\033[31m";
    public static final String COLOR_VERDE = "\033[32m";
    public static final String COLOR_NEGRO = "\033[30m";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        LocalDate unafechaLD;
        
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        
        System.out.println("Conectando con base de datos Agenda...");
        if (BD_Agenda.conectar() == null) {
            System.out.println(COLOR_ROJO+"ERROR: al conectar con la base de datos"+COLOR_NEGRO);
        } else {
            System.out.println(COLOR_VERDE+"Conexion OK"+COLOR_NEGRO);
            
            do {
                BD_Agenda.listar();
                
                System.out.println("1. Insertar Contacto.");
                System.out.println("2. Borrar Contacto.");
                System.out.println("3. Listar contactos por letra comienzo.");
                System.out.println("4. Listar contactos por mes.");
                System.out.println("5. Salir");
                
                System.out.print("");
                System.out.printf("\nOpcion > ");
                opcion = Integer.parseInt(sc.nextLine());
                
                switch (opcion) {
                    case 1:
                        System.out.printf("\nIntroduce el nombre > ");
                        String nombre = sc.nextLine();
                        
                        System.out.printf("Introduce los apellidos > ");
                        String apellidos = sc.nextLine();
                        
                        System.out.printf("Introduce el email > ");
                        String email = sc.nextLine();
                        
                        System.out.printf("Introduce la fecha de nacimiento: [dd/mm/yyyy] > ");
                        String fecha = sc.nextLine();
                        
                        unafechaLD = LocalDate.parse(fecha,dtf);
                        
                        BD_Agenda.insertar(nombre, apellidos, email, unafechaLD);
                        
                        
                        break;
                    case 2:
                        System.out.printf("\nIntroduce el 'id' del contacto que deseas eliminar > ");
                        int id = Integer.parseInt(sc.nextLine());
                        
                        BD_Agenda.eliminar(id);
                        break;
                    case 3:
                        System.out.printf("\nIntroduce letra: [A-Z] > ");
                        char letra = sc.nextLine().charAt(0);
                        BD_Agenda.listarLetra(letra);
                        
                        break;
                    case 4:
                        
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        throw new AssertionError();
                }
                
            } while (opcion != 5);
        }
        
        
        
        
    }
    
}
