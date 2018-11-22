package UT2TA3;
import java.util.LinkedList;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("./src/UT2TA3/palabras.txt");
        for (String p : palabrasclave) {
                trie.insertar(p);
                //System.out.println(p);
        }
        //trie.imprimir();  
        LinkedList<String> resultado = trie.predecir("pro");
        for (String palabra : resultado){
            System.out.println(palabra);
        }
    }
}