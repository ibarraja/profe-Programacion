/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_2_bbdd;

import java.sql.*;
import java.time.LocalDate;

/**
 *
 * @author Javier
 */
public class BD_Agenda {
    private static final String URL = "jdbc:mysql://localhost/Agenda";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection conexion;
    
    public BD_Agenda(){
        //this.conectar();
        /*
        
        -- Eliminar si existe
        DROP DATABASE IF EXISTS Agenda;
        
        -- Crear la base de datos
        CREATE DATABASE Agenda;

        -- Usar la base de datos
        USE Agenda;

        -- Crear la tabla Contactos
        CREATE TABLE Contactos (
            id INT AUTO_INCREMENT PRIMARY KEY,
            nombre VARCHAR(50),
            apellidos VARCHAR(100),
            email VARCHAR(100),
            fecha_nacimiento DATE
        );

        -- Insertar los contactos del ejemplo
        INSERT INTO Contactos (nombre, apellidos, email, fecha_nacimiento) VALUES
        ('Mortadelo', 'Mortadelo', 'mortadelo@kk.com', STR_TO_DATE('01/01/1900', '%d/%m/%Y')),
        ('Filemon', 'Filemon', 'filemon@kk.com', STR_TO_DATE('05/01/1900', '%d/%m/%Y')),
        ('Juan', 'Perez Cano', 'juan@kk.com', STR_TO_DATE('08/11/1979', '%d/%m/%Y')),
        ('Celia', 'Perez Cano', 'celia@kk.com', STR_TO_DATE('21/01/1986', '%d/%m/%Y'));
 
        
        */
    }
    
    
    public static Connection conectar(){
        
        //***********************************************************
        //    CARGAMOS EL DRIVER
        //***********************************************************
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("Driver <org.mariadb.jdbc.Driver> cargado.");

        } catch (Exception ex) {
            System.out.println("Error, no se ha podido cargar MySQL JDBC Driver");
        }


        try {
            //***********************************************************
            //    NOS CONECTAMOS A LA BASE DE DATOS
            //***********************************************************

            conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return conexion;



        } catch (SQLException ex) {
            //System.out.println(ex.getMessage());
            return null;
        }
    }
    
    
    public static void cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void listar() {
        try {
            Statement stmnt = conexion.createStatement();


            ResultSet rs = stmnt.executeQuery("SELECT id, nombre, apellidos, email, DATE_FORMAT(fecha_nacimiento,'%d/%m/%Y') as FechaNac FROM contactos;");
            System.out.println("");
            System.out.println("");
            System.out.println("********************************** AGENDA **********************************");
            while(rs.next()) {

                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");
                String fechaNac = rs.getString("FechaNac");
                
                System.out.printf("%1d %-10s %-15s %-20s %10s\n",id, nombre, apellidos, email, fechaNac);
                
            }
            System.out.println("****************************************************************************");
            rs.close();
            stmnt.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al lanzar consultar listar: "+ex);
        }
    }
    
    public static void insertar(String nombre, String apellidos, String email, LocalDate fecha) {
        try {
            String sql = "INSERT INTO contactos VALUES (null, ?, ?, ?, ?)";
            
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ps.setString(1, nombre);
            ps.setString(2, apellidos);
            ps.setString(3, email);
            ps.setDate(4, java.sql.Date.valueOf(fecha));
           
            
            ps.executeUpdate();
            
            ps.close();
            
            System.out.println("Contacto insertado correctamente!");
            
        } catch (SQLException ex) {
            System.out.println("Error al hacer insert: "+ ex);
        }
    }
    
    public static void eliminar(int id) {
        try {
            String sql = "DELETE FROM contactos WHERE id = ?";
            
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
            System.out.println("Contacto eliminado correctamente!");
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al lanzar consulta eliminar: " + ex);
        }
    }
    
    public static void listarLetra(char l) {
        try {
            String sql = "SELECT id, nombre, apellidos, email, DATE_FORMAT(fecha_nacimiento, '%d/%m/%Y') as fechaNac " +
                         "FROM contactos WHERE nombre LIKE ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, String.valueOf(l) + "%");

            ResultSet rs = ps.executeQuery();

            System.out.println("*************** AGENDA ****************");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");
                String fechaNac = rs.getString("fechaNac");

                System.out.printf("%d  %-10s %-15s %-20s %-10s\n", id, nombre, apellidos, email, fechaNac);
            }

            System.out.println("****************************************");

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al lanzar consulta listar por letra: " + ex);
        }

    }
}
