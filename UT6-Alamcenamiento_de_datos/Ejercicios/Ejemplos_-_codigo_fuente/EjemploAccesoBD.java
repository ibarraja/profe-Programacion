/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesobbdd;

import java.sql.*;



/**
 *
 * @author jacuela
 */

public class EjemploAccesoBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        //***********************************************************
        //    CARGAMOS EL DRIVER
        //***********************************************************
        try {
             Class.forName("org.mariadb.jdbc.Driver").newInstance();
             System.out.println("Driver <org.mariadb.jdbc.Driver> cargado.");
        } catch (Exception ex) {
            System.out.println("Error, no se ha podido cargar MariaDB JDBC Driver");
        }
        
      

//        try {
//             Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//             System.out.println("Driver <com.mysql.jdbc.Driver> cargado.");
//        } catch (Exception ex) {
//            System.out.println("Error, no se ha podido cargar el driver <com.mysql.jdbc.Driver>.");
//        }
//        

            
        try{
            
            //***********************************************************
            //    NOS CONECTAMOS A LA BASE DE DATOS PERSONAS
            //***********************************************************
        
            //String url = "jdbc:mysql://127.0.0.1/personas";  
            String url = "jdbc:mariadb://127.0.0.1/personas";
            String username = "root";
            String password = "";
            
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
         
            
            
            
            //***********************************************************
            //    HACEMOS UN INSERT
            //***********************************************************
            
            
//            statement.executeUpdate("INSERT INTO personas VALUES (NULL,'David','Costa',19)");
            
//            String unnombre="Martita";
//            String unapellido="Gris";
//            int unaedad=20;
//            
//            String sql=String.format("INSERT INTO personas VALUES (NULL,'%s','%s',%d)",unnombre,unapellido,unaedad);
//            statement.executeUpdate(sql);
//            
            //statement.executeUpdate("INSERT INTO personas VALUES (NULL,'"+unnombre+"','"+unapellido+"',"+unaedad+")");
            
            
//            String nombres[]={"Alfredo1","Alfredo2"};
//            String apellidos[]={"Perez","Olmos"};
//            String edades[]={"19","56"};
//            
//            //se insertan datos en la tabla
//            for (int i = 0; i < nombres.length; i++) {
//                statement.executeUpdate("INSERT INTO personas VALUES (NULL, '" + nombres[i] + "','" + apellidos[i] + "'," + edades[i] + ")");
//            }

           
            
            
            //***********************************************************
            //    HACEMOS UN SELECT
            //***********************************************************
        
            ResultSet rs = statement.executeQuery("SELECT * FROM personas");
            //ResultSet rs = statement.executeQuery("SELECT nombre,apellidos FROM personas");

            
            while (rs.next()) {

                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellidos");
                int edad  = rs.getInt("edad");

                System.out.printf("%d, %s %s, %d\n", id, nombre, apellido, edad);
            
            }

        
            rs.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
              System.out.println(ex);
        }
        
        
        
    }
    
}
