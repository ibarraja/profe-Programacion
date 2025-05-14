/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio6bis;

import java.sql.*;

/**
 *
 * @author Javier
 */
public class BDEmpresa_SQL {
    
    public static void cargarDriver(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver cargado correctamente");
        } catch (ClassNotFoundException ex){
            System.out.println("Error al cargar el driver: " + ex);
        }
    }
    
    public static Connection crearConexion(String endpoint){
        String url = endpoint;
        String user = "root";
        String password = "";
        Connection miConexion = null;
        
        try{
            miConexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion realizada correctamente");
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la base de datos: " + ex);
        }
        return miConexion;
    }
    
    public static void crearBD() {
        Connection miConexion = BDEmpresa_SQL.crearConexion("jdbc:mysql://localhost/");

        try {
            Statement consulta = miConexion.createStatement();
            consulta.executeUpdate("DROP DATABASE IF EXISTS alquilervehiculos;");
            consulta.executeUpdate("CREATE DATABASE alquilervehiculos CHARACTER SET utf8mb4;");
            consulta.close();
        } catch(SQLException ex) {
            System.out.println("Error al crear la BD: " + ex);
        } finally {
            try {
                if (miConexion != null){
                    miConexion.close();
                }
               
            } catch (SQLException ex){
                System.out.println("Error al cerrar la conexion: " + ex);
            }
        }
    }
    
    public static void crearTablas() {
        Connection miConexion = BDEmpresa_SQL.crearConexion("jdbc:mysql://localhost/alquilervehiculos");

        try {
            Statement consulta = miConexion.createStatement();
            consulta.executeUpdate("USE alquilervehiculos;");
            
            // Tabla vehiuclos
            consulta.executeUpdate("CREATE TABLE vehiculo("
                                        + "matricula varchar(50) NOT NULL,"
                                        + "marca_modelo varchar(50),"
                                        + "km int UNSIGNED DEFAULT 0,"
                                        + "alquilado boolean,"
                                        + "precioKilonetro DECIMAL(10,2),"
                                        + "precioDia DECIMAL(10,2),"
                                        + "tipoVehiculo varchar(50) NOT NULL,"
                                        + "PRIMARY KEY (matricula)"
                                    + ");");
            
            // Tabla alquiler
            consulta.executeUpdate("CREATE TABLE alquiler("
                                        + "id int UNSIGNED NOT NULL AUTO_INCREMENT,"
                                        + "matricula varchar(50) NOT NULL,"
                                        + "km_inicio int UNSIGNED NOT NULL,"
                                        + "km_fin int UNSIGNED NOT NULL,"
                                        + "fecha_inicio date,"
                                        + "fecha_fin date,"
                                        + "importe DECIMAL(10,2),"
                                        + "PRIMARY KEY (id),"
                                        + "CONSTRAINT matricula_vehiculo FOREIGN KEY(matricula) REFERENCES vehiculo(matricula)"
                                    + ");");
        } catch(SQLException ex) {
            System.out.println("Error al crear las tablas: " + ex);
        } finally {
            try{
                if (miConexion != null){
                    miConexion.close(); 
                }
            } catch (SQLException ex){
                System.out.println("Error al cerrar la conexion: " + ex);
            }
        } 
    }
    
    public static void insertarDatosTablas() {
        Connection miConexion = BDEmpresa_SQL.crearConexion("jdbc:mysql://localhost/alquilervehiculos");

        try {
            Statement consulta = miConexion.createStatement();
            consulta.executeUpdate("USE alquilervehiculos;");
            
            // INSERTS vehiuclos
            consulta.executeUpdate(
                "INSERT INTO vehiculo VALUES ('1111TTT', 'Volvo XC60',100,true,null,30,'turismo');"
            );
            consulta.executeUpdate(
                "INSERT INTO vehiculo VALUES ('2222TTT', 'Audi A4',0,false,null,30,'turismo');"
            );
            consulta.executeUpdate(
                "INSERT INTO vehiculo VALUES ('3333FFF', 'Citroen C16',250,false,0.5,null,'furgoneta');"
            );
            
            // INSERTS alquileres
            consulta.executeUpdate(
                "INSERT INTO alquiler VALUES (null,'1111TTT',0,100,'2023-01-01','2023-01-05',120);"
            );
            consulta.executeUpdate(
                "INSERT INTO alquiler VALUES (null,'3333FFF',0,250,'2023-01-01','2023-01-02',125);"
            );
            consulta.executeUpdate(
                "INSERT INTO alquiler VALUES (null,'1111TTT',100,0,'2023-05-19',null,0);"
            );
            
        } catch(SQLException ex) {
            System.out.println("Error al crear las tablas: " + ex);
        } finally {
            try{
                if(miConexion != null) {
                    miConexion.close();
                }
            } catch (SQLException ex){
                System.out.println("Error al cerrar la conexion: " + ex);
            }
        } 
    }
    
    public static void añadirVehiculo(String matricula, String marca_modelo, int km, String tipo){
        Connection miConexion = BDEmpresa_SQL.crearConexion("jdbc:mysql://localhost/alquilervehiculos");
        try{
            
            String insert = "INSERT INTO vehiculo VALUES (?,?,?,?,?,?,?)";
            PreparedStatement insertPreparada = miConexion.prepareStatement(insert);
            
            insertPreparada.setString(1, matricula);
            insertPreparada.setString(2, marca_modelo);
            insertPreparada.setInt(3, km);
            insertPreparada.setBoolean(4, false);
            
            if(tipo.equalsIgnoreCase("turismo")){
                insertPreparada.setString(5,null);
                insertPreparada.setDouble(6, 30.0);

            } else {
                insertPreparada.setDouble(5, 0.50);
                insertPreparada.setString(6, null);
            }
            insertPreparada.setString(7, tipo);
            insertPreparada.executeUpdate();
            
        } catch(SQLException ex) {
            System.out.println("Error al crear las tablas: " + ex);
        } finally {
            try{
                if(miConexion != null) {
                    miConexion.close();
                }
            } catch (SQLException ex){
                System.out.println("Error al cerrar la conexion: " + ex);
            }
        } 
    }
}

    