/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2TA2;

/**
 *
 * @author JoaquinCubas
 */
public class Trie {
    public static void main (String [] args){
        ManejadorArchivosGenerico m = new ManejadorArchivosGenerico();
        TArbolTrie trie = new TArbolTrie();
        TArbolTrie trie1 = new TArbolTrie();
        
        String[] palabras  = m.leerArchivo("./src/UT2_TA2/palabras_pagina.txt");

        for (String palabra : palabras){
            String[] palabras1 = palabra.split(",");
            trie.insertar(palabras1[0], Integer.parseInt(palabras1[1].trim()));
            trie1.insertar(palabras1[0]);
        }
        trie1.imprimir();
        trie.imprimirPaginas();
        System.out.println("Comparaciones realizadas: " + trie.buscar("casa"));
    }
}
