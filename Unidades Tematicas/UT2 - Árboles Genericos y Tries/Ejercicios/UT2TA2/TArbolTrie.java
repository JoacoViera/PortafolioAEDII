package UT2TA2;

import java.util.LinkedList;
//import uy.edu.ucu.aed.ties.TNodoTrie;

public class TArbolTrie {

    private TNodoTrie raiz;

    public void insertar(String palabra, Integer numPagina) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra, numPagina);
    }
    
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra);
    }

    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }
    

    public void imprimirPaginas() {
        if (raiz != null) {
            raiz.imprimirPaginas();
        }
    }
  
    public int buscar(String palabra) {
         if(raiz !=null){
           return raiz.buscar(palabra);
        } 
         else{
             return 0;
         }
    }
}
