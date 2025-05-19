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
}
