package UT3TA6;


import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 */
public interface INodoTrie {

    void imprimir(String s);

    void insertar(String unaPalabra);
    public void predecir(String prefijo, LinkedList<String> palabras);
    
}
