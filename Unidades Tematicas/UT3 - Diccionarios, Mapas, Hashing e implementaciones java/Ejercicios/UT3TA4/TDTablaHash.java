/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3TA4;

import java.util.HashMap;
import java.util.Map;


public class TDTablaHash {
    
    private int tam_tabla;
    private int[] tabla;
    public double factorDeCarga;
    public boolean pasa = true;
    
    public TDTablaHash(int cantidadElementoInsertar, double factorCargaDeTabla) {
        factorDeCarga = factorCargaDeTabla;
        tam_tabla =(int) (cantidadElementoInsertar/factorCargaDeTabla);
        tam_tabla = getNumeroPrimoSiguiente(tam_tabla);
        tabla = new int[tam_tabla];
        factorDeCarga =  (double) cantidadElementoInsertar / tam_tabla;
    }
    
    public int getNumeroPrimoSiguiente(int resultado){
        int numero = resultado;
        boolean esPrimo = false;
        while (!esPrimo){
            esPrimo = esPrimo(numero);
            if (!esPrimo) {
                numero ++;
            }            
        }
        System.out.println("PRIMO: "+numero);
        return numero;    
    }
    
    public boolean esPrimo(int resultado){
        int numero = resultado;
        boolean esPrimo = true;
        int contador = 2;
        while ((esPrimo) && (contador!=numero)){
            if (numero % contador == 0){
                esPrimo = false;
            }
            contador++;
        }
        return esPrimo;
    }
    
    
    public int buscar(int unaClave){
        int j = funcionHashing(unaClave);
        int cantidadComparaciones = 0;
        boolean centinela = true;
        while(centinela){
            if(getTabla()[j] == 0){
               centinela = false;
               return -cantidadComparaciones -1;
            }
            else
                if(getTabla()[j]==unaClave){
                return cantidadComparaciones++;
            } 
            cantidadComparaciones++;
            j = j+(cantidadComparaciones*cantidadComparaciones);
            if(j>=tam_tabla)
            {
                j =  j%tam_tabla;
            }            
            if(cantidadComparaciones >= tam_tabla){
                centinela=false;
            }
        }
        return -cantidadComparaciones;
    }
    
    public int insertar(int unaClave){
        
        int j = funcionHashing(unaClave);
        int cantidadComparaciones = 0;
        boolean centinela = true;
        while(centinela){
            if (tabla[j] == 0){
                tabla[j]= unaClave;
                return cantidadComparaciones+1;
            }
            else{
                cantidadComparaciones++;
                j = j + (cantidadComparaciones*cantidadComparaciones);  
            }
            if(j>=tam_tabla){
                j =  j % tam_tabla;
            }          
            if(cantidadComparaciones >= tam_tabla){
                centinela = false;
                this.pasa = false;
            }
        }
        return -cantidadComparaciones;
    }
    
    public int funcionHashing(int unaClave){
        return Math.abs(unaClave % tam_tabla);
    }

    
    public int[] getTabla() {
        return tabla;
    }
    
    
    
}
