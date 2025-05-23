/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7;

import org.json.JSONObject;

/**
 *
 * @author Javier
 */
public class Libro extends Publicacion{
    private int num_edicion;
    private boolean prestado;
    
    public Libro(String cod, String tit, String dni, int edicion) {
        super(cod, tit, dni);
        this.num_edicion = edicion;
        this.prestado = false;
    }
    
    @Override
    public void imprimir() {
        String estado = prestado ? "PRESTADO" : "DISPONIBLE";
        System.out.printf("LIBRO   [%-5s] %-20s %2dª edicion(%s)%n", 
                                codigo, titulo, num_edicion, estado);
    }
    
    public void prestar() {
        if (this.prestado == false) {
            this.prestado = true;
            System.out.println("Libro prestado!");
        } else {
            this.prestado = false;
            System.out.println("Libro devuelto!");
        }
    }
    
    public void devolver() {
        
    }
    
    @Override
    public String toString() {
        String estado = prestado ? "PRESTADO" : "DISPONIBLE";
        return String.format("LIBRO   [%-5s] %-20s %2dª edicion(%s)", 
                                codigo, titulo, num_edicion, estado);
    }
    
    @Override
    public void detallesPublicacion() {
        
        JSONObject datos_autor = BD_AutoresSQL.obtenerDatosAutor(this.dni_autor);
        
        this.nombre_autor = (String)datos_autor.opt("nombre");
        this.pais_autor = (String)datos_autor.opt("pais");
        
        
        System.out.println("DETALLES DEL LIBRO");
        System.out.println("=============================================================");
        System.out.println("Codigo > "+this.codigo);
        System.out.println("Titulo > "+this.titulo);
        System.out.println("Num Edicion > "+this.titulo);
        System.out.println("Nombre autor > "+this.nombre_autor);
        System.out.println("Pais autor > "+this.pais_autor);
        if (this.prestado) {
            System.out.println("ESTADO > PRESTADO");
        } else {
            System.out.println("ESTADO > DISPONIBLE");
        }
        
    }
}
