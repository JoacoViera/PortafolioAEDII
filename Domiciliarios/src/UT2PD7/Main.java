package UT2PD7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();

       // CARGAR EN EL TRIE LOS TELÉFONOS Y NOMBRES A PARTIR DEL ARCHIVO ABONADOS.TXT
        
       String[] archivo = ManejadorArchivosGenerico.leerArchivo("./src/UT2PD7/abonados.txt");
       for (String renglon : archivo) {    
            String[] linea = renglon.split(",");
            TAbonado nodo = new TAbonado(linea[1],linea[0]);
            trie.insertar(nodo);
        } 
       
        String codigoPais = "598" ; // utilizar el indicado en el archivo "codigos.txt"
        String codigoArea = "93" ;// utilizar el indicado en el archivo "codigos.txt"
        
        Collection<TAbonado> ab = trie.buscarTelefonos(codigoPais, codigoArea);
        
        //trie.imprimir();
        System.out.println("Cantidad de resultados: " + ab.size());
        System.out.println("");
        for(TAbonado a : ab){
            System.out.println(a.getNombre() + " " + a.getTelefono());
        }
        
        
        
        // crear el archivo "salida.txt", con los abonados (1 por linea) 
        // correspondientes al pais y area 
        // imprimir Nombre y teléfono, 
        // ordenados alfabeticamente por nombre
        
        //ManejadorArchivosGenerico.escribirArchivo("./src/salida.txt",.....);
        
    }
}