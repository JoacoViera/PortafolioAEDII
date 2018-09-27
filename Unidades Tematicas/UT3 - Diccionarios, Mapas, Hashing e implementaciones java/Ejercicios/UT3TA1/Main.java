/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT3TA1;

/**
 *
 * @author jechague
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int compIns=0;
        int busquedaNoExitosa = 0;
        int busquedaExitosa = 0;
        //int compBus=0;
        // Crear una tabla de tipo THash e insertar las claves del archivo "claves_insertar.txt"
        
        // Buscar en la tabla creada anteriormente las claves indicadas en el archivo "claves_buscar.txt"
        
        ManejadorArchivosGenerico manejador = new ManejadorArchivosGenerico();
        String[] listaBuscar = manejador.leerArchivo("./src/UT3TA1/claves_buscar.txt");
        String[] listaInsertar = manejador.leerArchivo("./src/UT3TA1/claves_insertar.txt");
        String[] listaInsertarLetras = manejador.leerArchivo("./src/UT3TA1/listado-general-palabrasBuscar.txt");
        
        //double[] vector = {0.90};
        
        //for(int i = 0;i < vector.length;i++){
            THash hash = new THash((int) (listaInsertar.length), 0.90);
            for(String p : listaInsertar){
                compIns += hash.insertar(Integer.parseInt(p)); 
            }
            
            //System.out.println(hash.buscar(8266364));
            for(String q : listaBuscar){
                 if(hash.buscar(Integer.parseInt(q)) < 0){
                    busquedaNoExitosa+= hash.buscar(Integer.parseInt(q));
                }
                else
                {
                    busquedaExitosa+= hash.buscar(Integer.parseInt(q));  
                }   
            }
            System.out.println("CANT COMPARACIONES NO EXITOSAS: " + (-busquedaNoExitosa));
            System.out.println("CANT COMPARACIONES EXITOSAS: "+ busquedaExitosa);
            
            System.out.println("HASH CON LETRAS");
            //hash con letras
            THash hashLetras = new THash((int) (listaInsertarLetras.length), 0.90);
            for(String p : listaInsertarLetras){
                compIns += hashLetras.insertar(p); 
            }
            
            //for(String p : listaBuscar){
                System.out.println(hashLetras.buscar("jamoncillo")); 
           // }
            
        //}
    }
    
}
