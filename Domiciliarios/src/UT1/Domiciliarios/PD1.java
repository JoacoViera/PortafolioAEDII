/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT1.Domiciliarios;

import java.util.Random;

/**
 *
 * @author joaqu
 */
public class PD1 {
    
    private static int TAMANIO_MAX = 30;
   
    public static Boolean busquedaBinaria(int[] claves, int buscado, int cont){
        if(claves.length == 0){
            return false;
        }
        if(claves.length == 1 && buscado == claves[0]){
            System.out.println("Valor: " + buscado + " encontrado, cantidad de comparaciones: " + cont);
            return true;
        }
        if( claves.length == 1 && buscado != claves[0]){
            return false;
        }
        if(buscado == claves[claves.length/2]){
            System.out.println("Valor: " + buscado + " encontrado, cantidad de comparaciones: " + cont);
            return true;
        }
        else if(buscado < claves[claves.length/2]){
            int[] izq = new int [claves.length/2];
            for(int i=0; i<(claves.length/2) ; i++){
                izq[i] = claves[i];
            }
            return busquedaBinaria(izq,buscado,cont +1);
        }
        else if(buscado > claves[claves.length/2]){
            int[] der = new int [claves.length/2];
            int e = 0;
            for(int i = (1+claves.length/2 ); i<claves.length; i++){
                der[e] = claves[i];
                e++;
            }
            return busquedaBinaria(der,buscado, cont +1);
        }
        return false;
    }
    
    public static Boolean busquedaLineal(int[] claves, int buscado){
        
        int cont = 0;
        if(claves.length == 0){
            return false;
        }
        for(int clave : claves){
            if(clave == buscado){
                System.out.println("Valor: " + buscado + " encontrado, cantidad de comparaciones: " + cont);
                return true;
            }
            cont++;
        }
        return false;
    }
    
    

    public static int[] generarDatosAscendentes() {
        
        int [] vectorAsc = new int[TAMANIO_MAX];
        for (int i = 0; i < TAMANIO_MAX; i++) {
            vectorAsc[i] = i*i;
        }
        return vectorAsc;
    }
    
    public static int[] generarDatosAscendentes(int largo) {
        int [] vectorAsc = new int[largo];
        for (int i = 0; i < largo; i++) {
            vectorAsc[i] = i*i;
        }
        return vectorAsc;
    }
    
    
    
    public static void main(String [ ] args){
        
        int[] vector = generarDatosAscendentes(TAMANIO_MAX);
//        for (int clave : vector){
//            System.out.println(clave);
//        }
        System.out.println(busquedaBinaria(vector, 100,0));
        System.out.println(busquedaLineal(vector, 100));
        
        
    }     
    
    
}
