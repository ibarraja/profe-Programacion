/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio7;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Javier
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         // Cargar driver JDBC
        BD_AutoresSQL.cargarDriverDB();

        // Crear editorial
        Editorial editorial = new Editorial();

        // Crear libro y revista con DNIs válidos (ver tu BBDD)
        Libro l1 = new Libro("L-01", "Reina Roja", "23230001A", 3);
        Revista r1 = new Revista("R-01", "National Java", "47565134A", LocalDate.of(2024, 1, 1));

        // Añadir un nuevo número a la revista
        r1.addNumero();
        r1.addNumero();

        // Agregar publicaciones a la editorial
        editorial.agregarPublicacion(l1);
        editorial.agregarPublicacion(r1);

        // Imprimir todas las publicaciones
        System.out.println(" EJERCICIO 7 - PUBLICACIONES");
        System.out.println("=============================================================");
        editorial.imprimirPublicaciones();
        System.out.println("=============================================================");
        
        String opcion = "0";
        while(opcion != "7") {
            
            System.out.println("1. Add libro");
            System.out.println("2. Add revista");
            System.out.println("3. Prestar/devolver libro");
            System.out.println("4. Sacar nuevo numero de revista");
            System.out.println("5. Detalles de publicación");
            System.out.println("6. Mostrar publicaciones");
            System.out.println("7. Salir");

            System.out.print("Elige una opcion > ");
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextLine();
            String codigo = "";
            switch (opcion) {
                case "1":
                    editorial.agregarPublicacion(createLibro());
                    break;
                case "2":
                    editorial.agregarPublicacion(addRevista());
                    break;
                case "3":
                    boolean encontrado = false;
                    System.out.print("Dime el codigo del libro > ");
                    codigo = sc.nextLine();
                    
                    editorial.prestarLibro(codigo);
                    
                    break;
                case "4":
                    
                    break;
                case "5":
                    System.out.print("Introduce el codigo identificador de la publicacion >");
                    codigo = sc.nextLine();
                    System.out.println("=============================================================");
                    editorial.detallesPublicacion(codigo);
                    System.out.println("=============================================================");
                    break;

                case "6":
                    System.out.println("=============================================================");
                    editorial.imprimirPublicaciones();
                    System.out.println("=============================================================");
                    break;
                case "7":
                    System.out.println("Saliendo...");
                default:
                    throw new AssertionError();
            }
        }
        
    }
    
    
    public static Libro createLibro() {
        sc = new Scanner(System.in);
        System.out.println("Como se llama el nuevo libro?");
        String nombre_libro = sc.nextLine();
        System.out.println("Codigo del libro?");
        String codigo_libro = sc.nextLine();
        System.out.println("DNI autor?");
        String opcion_dni = sc.nextLine();

        String dni_autor = "";
        switch (opcion_dni) {
            case "1":
                dni_autor = "11542462F";
                break;
            case "2":
                dni_autor = "23225483A";
                break;
            case "3":
                dni_autor = "23230001A";
                break;
            case "4":
                dni_autor = "47565134A";
                break;
            case "5":
                dni_autor = "48484200A";
                break;
            default:
                System.out.println("Error: no has introducido un dni válido");
                
        }
        System.out.println("Numero de edicion?");
        int num = sc.nextInt();

        Libro l2 = new Libro(codigo_libro, nombre_libro, dni_autor, num);
        return l2;
        
    }
    
    
    public static Revista addRevista() {
        Revista r = new Revista("R-01", "DAW news", "48484200A", LocalDate.of(2024, 1, 1));
        
        r.addNumero();
        r.addNumero();
        r.addNumero();
        
        return r;
    }
}
