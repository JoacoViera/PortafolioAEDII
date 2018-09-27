/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3TA1;

/**
 *
 * @author JoaquinCubas
 */
public class THash implements IHash {
    private int tam_tabla;
    private int[] tabla;
    private String[] tablaLetras;
    public double factorDeCarga;
    

    public THash(int cantidadElementoInsertar, double factorCargaDeTabla) {
        factorDeCarga = factorCargaDeTabla;
        tam_tabla =(int) (cantidadElementoInsertar/factorCargaDeTabla);
        tabla = new int[tam_tabla];
        factorDeCarga =  (double) cantidadElementoInsertar / tam_tabla;
        tablaLetras = new String[tam_tabla];
        for(int i=0; i<tablaLetras.length; i++){
            tablaLetras[i]="";
        }
    }
    
    
    @Override
    public int buscar(int unaClave) {
        int j = funcionHashing(unaClave);
        int cantidadComparaciones = 0;
        boolean centinela = true;
        while(centinela){
            if((getTabla()[j] == 0)){
                centinela = false;
                return -cantidadComparaciones;
            }else{
                if(getTabla()[j]==unaClave){
                    return ++cantidadComparaciones;
                }
                cantidadComparaciones++;
                j++;
                
                j =  j%tam_tabla;
                
                if(cantidadComparaciones >= tam_tabla){
                    centinela=false;
                }
            }
        }
        return -cantidadComparaciones;
    }
    
    //buscar con letras
    public int buscar(String unaPalabra) {
        int j = funcionHashingLetras(unaPalabra);
        int cantidadComparaciones = 0;
        boolean centinela = true;
        while(centinela){
            if((getTablaLetras()[j].compareTo(""))==0){
                centinela = false;
                return -cantidadComparaciones;
            }else{
                if(getTablaLetras()[j].compareTo(unaPalabra)==0){
                    return ++cantidadComparaciones;
                }
                cantidadComparaciones++;
                j++;
                
                j =  j%tam_tabla;
                
                if(cantidadComparaciones >= tam_tabla){
                    centinela=false;
                }
            }
        }
        return -cantidadComparaciones;
    }

    @Override
    public int insertar(int unaClave) {
        int j = funcionHashing(unaClave);
        int cantComparaciones = 0;
        boolean centinela = true;
        while (tabla[(j + cantComparaciones) % tam_tabla] != 0 && centinela) {
            cantComparaciones++;
            if (cantComparaciones == tam_tabla) {
                centinela = false;
            }
        }
        if (centinela) {
            tabla[(j + cantComparaciones) % tam_tabla] = unaClave;
        }
        return cantComparaciones;
    }
    
    //insertar con letras
    public int insertar(String unaPalabra) {
        //System.out.println("INSERTANDO una PALABRA "+ unaPalabra);
        int j = funcionHashingLetras(unaPalabra);
        int cantComparaciones = 0;
        boolean centinela = true;
        while (tablaLetras[(j + cantComparaciones) % tam_tabla].compareTo("")!= 0 && centinela) {
            cantComparaciones++;
            if (cantComparaciones == tam_tabla) {
                centinela = false;
            }
        }
        if (centinela) {
            tablaLetras[(j + cantComparaciones) % tam_tabla] = unaPalabra;
        }
        return cantComparaciones;
    }

    @Override
    public int funcionHashing(int unaClave) {
        return Math.abs(unaClave % tam_tabla);
    }
    
    
    public int funcionHashingLetras(String unaPalabra) {
        int sum=0;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            sum+=indice;
        }
        return Math.abs(sum % tam_tabla);
    }
    
    public int[] getTabla() {
        return tabla;
    }
    
    public String[] getTablaLetras() {
        return tablaLetras;
    }
}
