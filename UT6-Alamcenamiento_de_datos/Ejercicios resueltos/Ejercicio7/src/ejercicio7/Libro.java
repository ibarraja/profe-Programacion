/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7;

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
            System.out.println("Error: No puedes prestar un libro que ya ha sido prestado.");
        }
    }
    
    public void devolver() {
        if (this.prestado == true) {
            this.prestado = false;
            System.out.println("Libro devuelto!");
        } else {
            System.out.println("Error: No puedes devolver un libro que no ha sido prestado.");
        }
    }
    
    @Override
    public String toString() {
        String estado = prestado ? "PRESTADO" : "DISPONIBLE";
        return String.format("LIBRO   [%-5s] %-20s %2dª edicion(%s)", 
                                codigo, titulo, num_edicion, estado);
    }
}
