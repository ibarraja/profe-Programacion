/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7;

import org.json.*;

/**
 *
 * @author Javier
 */
public abstract class Publicacion {
    protected String codigo;
    protected String titulo;
    protected String dni_autor;
    protected String nombre_autor;
    protected String pais_autor;
    
    public Publicacion(String cod, String tit, String dni) {
        this.codigo = cod;
        this.titulo = tit;
        this.dni_autor = dni;
        cargarDatosAutor();
    }
    
    private void cargarDatosAutor() {
        JSONObject datos_autor = BD_AutoresSQL.obtenerDatosAutor(this.dni_autor);
        
        this.nombre_autor = (String)datos_autor.opt("nombre");
        this.pais_autor = (String)datos_autor.opt("pais");
        
    }
    
    public String getCodigo(){
        return this.codigo;
    }
    
    public abstract void imprimir();
}
