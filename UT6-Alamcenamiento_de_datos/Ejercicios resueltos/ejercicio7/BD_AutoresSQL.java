/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7;

import java.sql.*;
import org.json.*;

/**
 *
 * @author Javier
 */
public class BD_AutoresSQL {
    public static void cargarDriverDB() {
        
        
        /**
         
        DROP DATABASE IF EXISTS autores;
        CREATE DATABASE autores;
        
        USE autores;

        CREATE TABLE autores (
            dni VARCHAR(10) PRIMARY KEY,
            nombre VARCHAR(50), 
            pais VARCHAR(50),
            edad INT
        );

        INSERT INTO autores (dni, nombre, pais, edad) VALUES
            ('23230001A','Juan Gomes Jurado','Spain', 38),
            ('48484200A','Juan Cuello Largo','Spain', 43),
            ('11542462F','Pablo Neruda','Chile', 81),
            ('23225483A','Javier Ibarra Muñoz','Peru', 30),
            ('47565134A','Stephen King','USA', 65);
        
        **/
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // System.out.println("Driver cargado correctamente");
        } catch (Exception ex) {
            System.out.println("Error: al cargar el driver: " + ex);
        }
    }
    
    
    public static Connection crearConexion(String endpoint) {
        String url = endpoint;
        String user = "root";
        String password = "";
        Connection miConexion = null;
        
        try {
            miConexion = DriverManager.getConnection(url,user, password);
            // System.out.println("Conexión realizada correctamente!");
        } catch (SQLException sqlEx) {
            System.out.println("Error al conectar a la base de datos: "+ sqlEx);
        }
        
        return miConexion;
    }
    
    public static JSONObject obtenerDatosAutor(String dni_autor) {
        JSONObject autor = new JSONObject();
        
        Connection conn = crearConexion("jdbc:mysql://localhost/autores");
        String sql = "SELECT nombre, pais FROM autores WHERE dni = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dni_autor);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                autor.put("nombre",rs.getString("nombre"));
                autor.put("pais",rs.getString("pais"));
            } else {
                autor.put("nombre","Desconocido");
                autor.put("pais","Desconocido");
                
                System.out.println("Error: Autor no encontrado para DNI: " + dni_autor);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener autor desde BBDD: " + ex.getMessage());
            autor.put("nombre","ERROR");
            autor.put("pais","ERROR");
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return autor;
    }
}
