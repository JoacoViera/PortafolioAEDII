package UT2PD6;

import UT2PD2.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TNodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private LinkedList<Integer> paginas = new LinkedList<Integer>();


    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
    }
    
    public LinkedList<Integer> getPaginas(){
        return paginas;
    }
    
    //insertar palabra
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';

            try{
                if (nodo.hijos[indice] == null) {
                    nodo.hijos[indice] = new TNodoTrie();
                }
            nodo = nodo.hijos[indice];
            }catch(Exception e) {
                System.err.println("No se pueden insertar palabras con caracteres que no sean letras");
            }
        }
        nodo.esPalabra = true;
    }
    
    
    //insertar palabra con numero de pagina
    public void insertar(String unaPalabra, LinkedList<Integer> paginasInsertar){        
        unaPalabra = unaPalabra.toLowerCase();
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c)-'a';
            try {
                if (nodo.hijos[indice] == null) {
                    nodo.hijos[indice] = new TNodoTrie();
                }
                nodo = nodo.hijos[indice];
            } catch (Exception e) {
                System.err.println("No se pueden insertar palabras con caracteres que no sean letras");
            }                        
        }
        nodo.esPalabra = true;
        for( int pagina: paginasInsertar){
             nodo.paginas.add(pagina);
        }
    }



    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {                           
                System.out.println(s);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }
    private void imprimirPaginas(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                String cadena = "";
                for (Integer numero : nodo.paginas) {
                    cadena += ", " + numero;
                }              
                System.out.println(s + cadena);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimirPaginas(s + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }


    public void imprimir() {
        imprimir("", this);
    }
    

    public void imprimirPaginas() {
        imprimirPaginas("", this);
    }

    
    public int buscar(String unaPalabra){
        TNodoTrie nodo = this;
        int comparaciones  = 0;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null){
		return 0;
            }
            else if(this.esPalabra && c == unaPalabra.length()){
		
                return comparaciones;
            }   
            else{
		nodo = nodo.hijos[indice];
		comparaciones++;
            }
        }
        for (int x : nodo.paginas) {
            System.out.print(" ");
            System.out.print(x);
        }
        System.out.println("");
        return comparaciones;
    }
    
    public TNodoTrie buscarNodo(String unaPalabra){
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null){
		return null;
            }
            else if(this.esPalabra && c == unaPalabra.length()){
                return this;
            }   
            else{
		nodo = nodo.hijos[indice];
            }
        }
        for (int x : nodo.paginas) {
            System.out.print(" ");
            System.out.print(x);
        }
        return this;
    }
}
