package ejercicio7;


import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Javier
 */
public class Editorial {
    private ArrayList<Publicacion> publicaciones;
    
    public Editorial() {
        this.publicaciones = new ArrayList<>();
    }
    
    public void agregarPublicacion(Publicacion pub) {
        publicaciones.add(pub);
    }
    
    public void imprimirPublicaciones(){
        for(Publicacion pub : publicaciones) {
            System.out.println(pub.toString());
        }
    }
    
    public ArrayList<Publicacion> getPublicaciones() {
        return publicaciones;
    }
    
    public void detallesPublicacion(String cod) {
        boolean cod_encontrado = false;
        for (Publicacion p : publicaciones) {
            if (p.codigo.equals(cod)){
                p.detallesPublicacion();
                cod_encontrado = true;
            }
        }
        if (!cod_encontrado) {
            System.out.println("Error: no existe el codigo "+ cod + " en esta editorial.");
        } 
    }
    
    public void prestarLibro(String cod) {
        boolean encontrado = false;
        for (Publicacion pub : publicaciones) {
            if (pub instanceof Libro && pub.getCodigo().equalsIgnoreCase(cod)) {
                encontrado = true;

                Libro libro = (Libro) pub;
                
                libro.prestar();
            }
        }
    }
}
