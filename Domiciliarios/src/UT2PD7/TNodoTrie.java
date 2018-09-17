/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2PD7;

import java.util.LinkedList;

/**
 *
 * @author joaqu
 */
public class TNodoTrie implements INodoTrie {
    
    
    private static final int CANT_CHR_ABECEDARIO = 10;
    //private static final int[] numeros = {0,1,2,3,4,5,6,7,8,9};
    private final TNodoTrie[] hijos;
    private boolean esPalabra;
    private TAbonado dato;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
        dato=null;
    }
    
    public TNodoTrie buscarPrefijo(String prefijo){
       TNodoTrie nodo = this;
       for (int c = 0; c < prefijo.length(); c++) {
           int indice = prefijo.charAt(c) - '0';
           if (nodo.hijos[indice] == null) {
               return null;
           }
           nodo = nodo.hijos[indice];
       }       
       return nodo; 
   }
    
    private void imprimir(String s, TNodoTrie nodo,LinkedList<TAbonado> abonados) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                //System.out.println(s + " " + nodo.dato.getNombre()); 
                abonados.add(nodo.dato);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    char letra = (char) ((c) + '0');
                    imprimir(s+letra, nodo.hijos[c], abonados);
                    
                }
            }
        }
    }
   
    public void imprimir(LinkedList<TAbonado> abonados) { 
        imprimir("", this, abonados);
    }
   

    public void predecir(String prefijo, LinkedList<String> palabras,TNodoTrie nodo) {
        if(nodo!= null){
            if (nodo.esPalabra){
                palabras.add(prefijo);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if(nodo.hijos[c] != null){
                    char letra = (char) ((c) + '0');
                    predecir(prefijo+letra, palabras,nodo.hijos[c]);
                }           
            }
        }       
    }
    @Override
    public void buscarTelefonos(String primerosDigitos, LinkedList<TAbonado> abonados) {  
        if (this != null) {
            if (this.esPalabra) {
                abonados.add(this.dato);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (this.hijos[c] != null) {
                    char letra = (char) ((c) + '0');
                    imprimir(primerosDigitos+letra, this.hijos[c], abonados);                   
                }
            }
        }
    }

    @Override
    public void insertar(TAbonado unAbonado) {  
        TNodoTrie nodo = this;
        for (int c = 0; c < unAbonado.getTelefono().length(); c++) {
            int indice = unAbonado.getTelefono().charAt(c) - '0';
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
        nodo.dato = unAbonado;
    }

}
