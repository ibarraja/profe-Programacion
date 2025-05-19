/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_1_bbdd;

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
      
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        
        //BD_World bdMundo=new BD_World();
        System.out.print("Conectando con base de datos WORLD......");
        if (BD_World.conectar()==null) 
            System.out.println("\033[31mERROR");
            
        else{
            System.out.println("\033[32mOK");
        
            boolean salir = false;
            int opcion; //Guardaremos la opcion del usuario
        
            
            while(!salir){
           
                System.out.println("\n\n\033[34m******** BBDD WORLD *******\033[30m");
                System.out.println("\033[34m***************************\033[30m");

                System.out.println("1. Habitantes de paises");
                System.out.println("2. Habitantes de ciudades");
                System.out.println("3. Paises con un minimo de X habitantes");
                System.out.println("4. Ciudades con un minimo de X habitantes");
                System.out.println("5. Habitantes de todas las ciudades");
                System.out.println("6. Salir");

                System.out.print("Elige una opcion >");
                opcion = Integer.parseInt(entrada.nextLine());

                switch(opcion){
                    case 1:
                         System.out.print("Nombre del pais:");
                         String nombrePais = entrada.nextLine();
                         BD_World.habitantesPais(nombrePais);
                         break;

                    case 2:
                         System.out.print("Nombre de la ciudad:");
                         String nombreCiudad = entrada.nextLine();
                         BD_World.habitantesCiudad(nombreCiudad);
                         break;

                    case 3:
                         System.out.print("Número min. de habitantes del pais:");
                         int habitantes = Integer.parseInt(entrada.nextLine());
                         BD_World.paisesMinHabitantes(habitantes);
                         break;

                    case 4:
                         System.out.print("Número min. de habitantes de la ciudad:");
                         int habitantes2 = Integer.parseInt(entrada.nextLine());
                         BD_World.ciudadesMinHabitantes(habitantes2);
                         break;

                    case 5:
                         System.out.print("Indica num filas a mostrar [0 para todas]: ");
                         int limite = Integer.parseInt(entrada.nextLine());
                         BD_World.mostrarHabitantesCiudad(limite);
                         break;     
                         
                    case 6:
                        salir=true;
                        BD_World.cerrarConexion();
                        break;

                     default:
                        System.out.println("Solo números entre 1 y 5");
                }
            
            } //fin menu
        
        } //fin else    
    }//fin main 
    
}
