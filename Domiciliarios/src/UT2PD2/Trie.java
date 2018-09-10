/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2PD2;

import java.util.LinkedList;

/**
 *
 * @author JoaquinCubas
 */
public class Trie {
    public static void main (String [] args){
        
        TArbolTrie trie = new TArbolTrie();
        String[] palabras  = ManejadorArchivosGenerico.leerArchivo("./src/UT2PD2/palabras_pagina.txt");

        for (String p : palabras){
            String[] linea = p.split(",");
            
            String palabra = linea[0];
            LinkedList<Integer> listaPaginas = new LinkedList();
            
            for(Integer i = 1; i<linea.length;i++){
                Integer valor = Integer.parseInt(linea[i].trim());
                listaPaginas.add(valor);             
            }
            trie.insertar(palabra,listaPaginas);
        }
       
        trie.imprimir();
        trie.imprimirPaginas();
        System.out.println("Comparaciones realizadas: " + trie.buscar("casa"));
    }
}
