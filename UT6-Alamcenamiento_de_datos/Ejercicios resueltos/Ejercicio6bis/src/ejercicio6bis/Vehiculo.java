/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio6bis;

import java.time.LocalDate;

/**
 *
 * @author Javier
 */
public abstract class Vehiculo {
    private String matricula;
    private String marca_modelo;
    protected int km;
    protected boolean alquilado;

    public Vehiculo(String matricula, String marca_modelo, int km) {
        this.matricula = matricula;
        this.marca_modelo = marca_modelo;
        this.km = km;
        this.alquilado = false;
    }
    
    public abstract void alquilar(LocalDate fecha_alquiler, int km);
    public abstract void devolver(LocalDate fecha_alquiler, int km);
    
//    public String toString(){
//        return String.format("%s", this.matricula)
//    }
    
}
