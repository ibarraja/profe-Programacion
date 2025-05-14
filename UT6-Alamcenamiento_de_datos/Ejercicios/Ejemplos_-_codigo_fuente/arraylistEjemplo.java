/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author jacuela
 */
public class arraylistEjemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        //Definimos array list llamado lista para almacenar nombres de personas
        ArrayList<String> lista=new ArrayList();
        
        //Añade los nombre "Juan","Celia","Pedro","Juan" y "Maria".
        lista.add("Juan");
        lista.add("Celia");
        lista.add("Pedro");
        lista.add("Juan");    //permite duplicados
        lista.add("Maria");
        
        //Devuelve el elemento que esta en la posición 2
        System.out.println("Elemento en la posicion 2:"+lista.get(2));
        
        //Indica el tamaño de la lista e imprímela con un for, un foreach y un iterador
        System.out.println("El tamaño de la lista es:"+lista.size());
        
        //Imprimimos lista con un for
        System.out.println("");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
      
        //Imprimimos lista con un iterador
        System.out.println("");
        Iterator it=lista.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
            //it.remove();     //puedo elimiar elemento mientras recorro
        }
        
        //Imprimimos lista con un forearch
        System.out.println("");
        for (String elemento:lista){
            System.out.println(elemento);
        }
        
        //Devolvemos el último elemento de la lista
        System.out.println("");
        System.out.println("Ultimo elemento:"+lista.get(lista.size()-1));
        
        //Añade el nombre "XXX" en la posición 2
        lista.add(2, "XXX");
        imprimir(lista);
        
        //Sustituye el elemento de la posición 2 por "Jero"
        lista.set(2, "Jero");
        imprimir(lista);

        //Comprueba si existe el nombre "Celia" en la lista.
        System.out.println("\nExiste <Celia>:"+lista.contains("Celia"));
        
        //Devuelve la posición de la primera ocurrencia de "Juan" en la lista.
        System.out.println("\nPosicion de <Juan>:"+lista.indexOf("Juan"));
        
        //Devuelve la posición de la primera ocurrencia de "Rodolfo" en la lista.
        System.out.println("\nPosicion de <Rodolfo>:"+lista.indexOf("Rodolfo"));
        
        //Devuelve la posición de la ultima ocurrencia de "Juan" en la lista.
        System.out.println("\nPosicion de <Juan>:"+lista.lastIndexOf("Juan"));
        
        //Elimina el elemento de la posición 4 de la lista
        lista.remove(4);
        
        //Eliminar la primera ocurrencia de "Jero" de la lista
        lista.remove("Jero");
        imprimir(lista);
        
        //Ordena la lista e imprímela
        Collections.sort(lista);
        imprimir(lista);
        
        //Crear un alias 
        ArrayList listaAlias=lista;
        
        //Creamos una copia o clon
        ArrayList listaCopia=new ArrayList(lista); 
        
        //Borrar el ultimo  usando el alias
        listaAlias.remove(listaAlias.size()-1);
        
        //Imprimimos lista y listaCopia
        System.out.print("\nLista:");imprimir(lista);
        System.out.print("\nListaCopia:");imprimir(listaCopia);
        
        //Borrar la lista "listaCopia"
        listaCopia.clear();
        System.out.print("\nListaCopia:");imprimir(listaCopia);
        
        
        
    }
    
    
    private static void imprimir(ArrayList<String> l){
        //Imprimimos lista con un forearch
        System.out.println("");
        for (String elemento:l){
            System.out.println(elemento);
        }
        
    }
    
    
    
    
}
