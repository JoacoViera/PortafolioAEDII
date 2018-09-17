package UT2PD6;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();
        HashMap<String, Integer> abc= new HashMap<String, Integer>();// 
     
        String b = "ccttgacttgc";
        
        //trie.insertar(b,0);
        for (int i = 0; i <= b.length(); i++) {
            //System.out.println(b.subSequence(i, b.length()));
            String aux = (String)b.subSequence(b.length()-i,b.length());
            
            System.out.println(aux + " numero "+ (b.length()-i));
            trie.insertar(aux, (b.length()-i));
            
        }
    
        trie.imprimir();
        String patron= "gac";
        LinkedList<Integer> ocurrenicas = trie.buscarOcurrencias(patron);
        String[] lineasArchivo = new String[ocurrenicas.size()];
        for (int i = 0; i < ocurrenicas.size(); i++) {
            String linea = "El patron buscado esta en ("+String.valueOf(ocurrenicas.get(i) + "," + (patron.length()+ocurrenicas.get(i)-1)+")");
            
            lineasArchivo[i]  = linea;
            System.out.println("La ocurrencia del patron " +patron+ " esta en "+  ocurrenicas.get(i));
        }
       // String nombreCompletoArchivo, String[] listaLineasArchivo)
        ManejadorArchivosGenerico.escribirArchivo("src/PD6/salida.txt", lineasArchivo);
        // crear el archivo "salida.txt", con los abonados (1 por linea) 
        // correspondientes al pais y area 
        // imprimir Nombre y teléfono, 
        // ordenados alfabeticamente por nombre
        
        //ManejadorArchivosGenerico.escribirArchivo("./src/salida.txt",.....);
        
    }
}