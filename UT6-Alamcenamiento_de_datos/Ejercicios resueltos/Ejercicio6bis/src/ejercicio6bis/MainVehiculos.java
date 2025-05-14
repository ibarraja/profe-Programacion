/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio6bis;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Javier
 */
public class MainVehiculos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("1. Crear BD");
            System.out.println("2. Añadir Vehiculo");
            System.out.println("3. Historico Alquileres");
            System.out.println("4. Salir del sistema");
            System.out.println("Elige una opcion");
            try {
               opcion = Integer.parseInt(sc.nextLine());  
            } catch (NumberFormatException ex){
                System.out.println(ex);
            }
            
            switch (opcion) {
                case 1:
                        try {
                            BDEmpresa_SQL.cargarDriver();
                            BDEmpresa_SQL.crearBD();
                            System.out.println("Se ha creado la Base de datos!");

                            BDEmpresa_SQL.crearTablas();
                            System.out.println("Tablas creadas correctamente!");

                            BDEmpresa_SQL.insertarDatosTablas();
                            System.out.println("Datos insertados correctamente!");

                        } catch (Exception ex) {
                            System.out.println("Error en el main: "+ ex);
                        }
                    break;
                case 2:
                    boolean opcion2 ;
                    String tipo_vehiculo;
                    do{
                        System.out.println("Turismo o Furgoneta");
                        tipo_vehiculo = sc.nextLine();
                        if(!tipo_vehiculo.equalsIgnoreCase("turismo") && !tipo_vehiculo.equalsIgnoreCase("furgoneta")){
                            System.out.println("Introduce furgo o turismo");
                            opcion2 = true;
                        }else {
                            opcion2 = false;
                        }
                    }while(opcion2);
                    System.out.println("Matricula:");
                    String matricula = sc.nextLine();
                    
                    System.out.println("Marca y modelo");
                    String marca_modelo = sc.nextLine();
                    
                    System.out.println("Km");
                    int km = Integer.parseInt(sc.nextLine());
                    
                    BDEmpresa_SQL.añadirVehiculo(matricula, marca_modelo, km, tipo_vehiculo);
                    
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    throw new AssertionError();
            }
            
        }while(opcion != 4);
        
        
        
        
        

    }
    
}
