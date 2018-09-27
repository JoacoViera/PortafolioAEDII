/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3TA4;

/**
 *
 * @author JoaquinCubas
 */
public class UT3TA4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String RUTA_CLAVES_BUSCAR = "./src/ut3/ta4/claves_buscar.txt";
        String RUTA_CLAVES_INSERTAR = "./src/ut3/ta4/claves_insertar.txt";
        
        ManejadorArchivosGenerico manejador = new ManejadorArchivosGenerico();
        String[] listaBuscar = manejador.leerArchivo(RUTA_CLAVES_BUSCAR);
        String[] listaInsertar = manejador.leerArchivo(RUTA_CLAVES_INSERTAR);
        
        double busquedaNoExitosa = 0;
        double busquedaExitosa = 0;
        double cantidadDeComparacionesAlInsertarExitoso = 0;
        double cantidadDeComparacionesAlInsertarNoExitoso = 0;
        double cantidadInsercionesExitosas = 0;
        double cantidadInsercionesNoExitosas = 0;
        
        double[] vector = {0.50,0.55,0.60,0.65,0.70,0.75,0.80,0.85,0.90,0.91,0.92,0.93,0.94,0.95,0.96,0.97,0.98,0.99};

        
        for(int i = 0; i < vector.length; i++){
            
            TDTablaHash hash = new TDTablaHash((int) (listaInsertar.length), vector[i]);
            
            for(String p : listaInsertar){
                double comparaciones = hash.insertar(Integer.parseInt(p));
                
                if(comparaciones>0){
                    cantidadDeComparacionesAlInsertarExitoso+= comparaciones;
                    cantidadInsercionesExitosas++;
                }else{
                    cantidadDeComparacionesAlInsertarNoExitoso+= comparaciones;
                    cantidadInsercionesNoExitosas++;
                    
                }  
            }
            System.out.println("FACTOR DE CARGA: "+ vector[i]*100+"%");
            
            System.out.println("PROMEDIO INSERTAR EXITOSO: "+ cantidadDeComparacionesAlInsertarExitoso/cantidadInsercionesExitosas);
            System.out.println("PROMEDIO INSERTAR NO EXITOSO: "+ (-(cantidadDeComparacionesAlInsertarNoExitoso/cantidadInsercionesNoExitosas)));

            for(String q : listaBuscar){
                if(hash.buscar(Integer.parseInt(q)) < 0){
                    busquedaNoExitosa+= hash.buscar(Integer.parseInt(q));
                }
                else{
                    busquedaExitosa+= hash.buscar(Integer.parseInt(q));  
                }              
            }
            System.out.println("BUSQUEDAS EXITOSAS: "+ busquedaExitosa);
            System.out.println("BUSQUEDAS NO EXITOSAS: "+ (-busquedaNoExitosa));
            System.out.println("PROMEDIO DE BUSQUEDAS EXITOSAS: "+ busquedaExitosa/listaBuscar.length);
            System.out.println("PROMEDIO DE BUSQUEDAS NO EXITOSAS: "+ (-busquedaNoExitosa)/listaBuscar.length);
            System.out.println("   ");
            
            
        }  
    }
}
