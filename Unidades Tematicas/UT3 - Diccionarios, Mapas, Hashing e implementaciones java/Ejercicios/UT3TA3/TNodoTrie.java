package UT3TA3;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TNodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private List<Integer> paginas = new LinkedList<Integer>();


    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
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
    public void insertar(String unaPalabra, Integer pagina){        
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
        if (!nodo.paginas.contains(pagina)){ 
            nodo.paginas.add(pagina);
        }        
    }

            /*if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }*/


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
                String s1 = "";
                for (int i = 0; i < nodo.paginas.size(); i++) {
                    s1 += ", " + nodo.paginas.get(i);
                }              
                System.out.println(s + s1);
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
        System.out.print(unaPalabra);
        for (int x : nodo.paginas) {
            System.out.print(" ");
            System.out.print(x);
        }
        System.out.println("");
        return comparaciones;
    }
}
