package UT3TA6;


import java.util.LinkedList;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrieHashMap trie = new TArbolTrieHashMap();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("./src/UT3TA6/palabras.txt");
        for (String p : palabrasclave) {
                trie.insertar(p, 0);
        }
             
    }
}