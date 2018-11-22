/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmosDeClasificacion;

/**
 *
 * @author Joaquin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
               
        TClasificador clasif = new TClasificador();       
        GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
       
       
        int[] vectorAscendente;
        int[] vectorDescendente;
        int[] vectorAleatorio;
       
         
       
        for(int i = 0; i < 9; i++){  
           
            TClasificador.imprimirNombreMetodo(i+1);
            int cont = 1;
            while(cont<=3){                           
                switch (cont) {
                    case 1:
                        System.out.println("VECTOR DE 300 ELEMENTOS");
                        System.out.println("");
                        vectorAscendente = gdg.generarDatosAscendentes(300);
                        vectorDescendente = gdg.generarDatosDescendentes(300);
                        vectorAleatorio = gdg.generarDatosAleatorios(300);
                        break;
                    case 2:
                        System.out.println("VECTOR DE 3000 ELEMENTOS");
                        System.out.println("");
                        vectorAscendente = gdg.generarDatosAscendentes(3000);
                        vectorDescendente = gdg.generarDatosDescendentes(3000);
                        vectorAleatorio = gdg.generarDatosAleatorios(3000);
                        break;
                    default:
                        System.out.println("VECTOR DE 30000 ELEMENTOS");
                        System.out.println("");
                        vectorAscendente = gdg.generarDatosAscendentes(30000);
                        vectorDescendente = gdg.generarDatosDescendentes(30000);
                        vectorAleatorio = gdg.generarDatosAleatorios(30000);
                        break;
                 }
                     
               
                System.out.print("Vector Ascendente: ");
                int[] ascendente = vectorAscendente.clone();
                double[] r = clasif.tiempoMedioAlgoritmoBase(ascendente, i+1);
                System.out.println(r[0] + " nanosegundos | " + r[1] + " milisegundos.");
                //System.out.println(clasif.tiempoMedioAlgoritmoBase(ascendente, i+1, 100000000) + " nanosegundos.");

                System.out.print("Vector Descendente: ");
                int[] descendente = vectorDescendente.clone();
                double[] r2 = clasif.tiempoMedioAlgoritmoBase(descendente, i+1);
                System.out.println(r2[0] + " nanosegundos | " + r2[1] + " milisegundos.");
                //System.out.println(clasif.tiempoMedioAlgoritmoBase(descendente, i+1, 100000000) + " nanosegundos.");

                System.out.print("Vector Aleatorio: ");
                int[] aletorio = vectorAleatorio.clone();
                double[] r3 = clasif.tiempoMedioAlgoritmoBase(aletorio, i+1);
                System.out.println(r3[0] + " nanosegundos | " + r3[1] + " milisegundos.");
                //System.out.println(clasif.tiempoMedioAlgoritmoBase(aletorio, i+1, 100000000) + " nanosegundos.");
                System.out.println("");   
               
                cont++;

            }        
        } 
    }
}
