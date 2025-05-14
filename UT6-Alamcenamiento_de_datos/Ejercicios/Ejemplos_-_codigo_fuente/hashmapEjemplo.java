/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 *
 * @author jacuela
 */
public class hashmapEjemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        HashMap <Integer, String> mapa=new HashMap();
        
        HashMap <String, String> mapaCapitales=new HashMap();
        
        
        //Añadir elementos al mapa
        mapa.put(1, "Casillas");
        mapa.put(6, "Iniesta");
        mapa.put(5, "Puyol");
        mapa.put(7, "Villa");
        mapa.put(3, "Pique");
        
        //Añadir elementos al mapaCapitales
        mapaCapitales.put("España", "Madrid");
        mapaCapitales.put("Ecuador", "Quito");
        mapaCapitales.put("Marruecos", "Rabat");
        mapaCapitales.put("Australia", "Camberra");
        
        
        //Indica el número de elementos del mapa
        System.out.println("Elementos del mapa:"+mapa.size());   
        
        //Devuelve el nombre del dorsal 3 (dada una key, devolver value)
        System.out.println("El dorsal 3 es de:"+mapa.get(3));
      
        System.out.println("La capital de Australia es:"+mapaCapitales.get("Australia"));
      
        //Devolver el dorsal del jugador "Casillas" (dado un value, devolver su key)
        System.out.println("NO SE PUEDE HACER");    
        
        //Añade el jugador Ramos con dorsal 15
        mapa.put(15,"Ramos");
        
        //Añade el jugador DeGea con dorsal 1 (la llave1 ya existe)
        mapa.put(1,"DeGea");  //sustituimos el valor de la llave 1
        
        
        //Devolver una colección con todas las claves (dorsales) del mapa
        System.out.println("Lista de dorsales<claves>:"+mapa.keySet());
        
        //Devolver una colección con todos los valores (jugadores) del mapa
        System.out.println("Lista de jugadores<valores>:"+mapa.values());
        
        
        
        
        //Imprime el mapa con un iterador y un foreach
        System.out.println("");
        Iterator it=mapa.keySet().iterator();
        
        System.out.println("Imprimo con un iterador");
        while (it.hasNext()){
            Integer key=(Integer)it.next();
            System.out.println("Dorsal:"+key+" -->Jugador:"+mapa.get(key));
            
        }
        
        System.out.println("Imprimo con un foreach");
        for(Entry<Integer, String> elemento: mapa.entrySet()){
            Integer dorsal=elemento.getKey();
            String jugador=elemento.getValue();
            System.out.println("Dorsal:"+dorsal+" -->Jugador:"+jugador);
        }
        
        //Eliminar el dorsal 1
        System.out.println("Eliminamos el dorsal 1 de:"+mapa.remove(1));
        
        //Comprobar si existe el dorsal 1
        System.out.println("¿Existe el dorsal 1?:"+mapa.containsKey(1));
        
        //Comprobar si existe el jugador Ramos
        System.out.println("¿Existe el jugador <Ramos>:"+mapa.containsValue("Ramos"));
        
        
    }
    
}
