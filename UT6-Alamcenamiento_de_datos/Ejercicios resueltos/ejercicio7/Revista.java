/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Javier
 */
public class Revista extends Publicacion {
    private TipoPeriocidad periocidad;
    private LocalDate fechaSalida;
    private ArrayList<LocalDate> numeros;
    
    public Revista(String cod, String tit, String dni, LocalDate fechaSalida) {
        super(cod, tit,dni);
        this.fechaSalida = fechaSalida;
        this.periocidad = TipoPeriocidad.MENSUAL; // Valor por defecto
        this.numeros = new ArrayList<>();
        this.numeros.add(fechaSalida); // Primer numero
    }
    
    @Override
    public void imprimir() {
        System.out.printf("REVISTA [%-5s] %-20s %2d ejemplares - %-10s%n", 
                     codigo, titulo, numeros.size(), periocidad); 
    }
    
    public void addNumero() {
        LocalDate ultima = numeros.get(numeros.size() - 1);
        LocalDate nueva = null;

        switch (periocidad) {
            case MENSUAL:
                nueva = ultima.plusMonths(1);
                break;
            case QUINCENAL:
                nueva = ultima.plusDays(15);
                break;
            case TRIMESTRAL:
                nueva = ultima.plusMonths(3);
                break;
        }

        
        numeros.add(nueva);
    }
    
    public int getTotalNumeros() {
        return numeros.size();
    }
    
    @Override
    public String toString() {
        return String.format("REVISTA [%-5s] %-20s %2d ejemplares - %-10s", 
                     codigo, titulo, numeros.size(), periocidad);
    }

     @Override
    public void detallesPublicacion() {}
}
