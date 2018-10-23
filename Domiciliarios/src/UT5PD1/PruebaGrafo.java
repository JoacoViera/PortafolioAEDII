package UT5PD1;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class PruebaGrafo {

    public static void main(String[] args) {

        String[] aristas = ManejadorArchivosGenerico.leerArchivo("src/UT5PD1/aristasBEA.txt", false);
        String[] datos = null;
        Collection<TArista> aristasG = new LinkedList<>();
        for (String arista : aristas) {
            datos = arista.split(",");
            try {
            if (Character.isDigit(datos[2].charAt(0))) {
                
                    aristasG.add(new TArista(datos[0],datos[1],Double.parseDouble(datos[2])));
            } else{
                aristasG.add(new TArista(datos[0],datos[1],1));
            }
             } catch (NumberFormatException e) {
                 System.out.println("Dato invalido al insertar" + e);
                }
        }
        
        String[] vert = ManejadorArchivosGenerico.leerArchivo("src/UT5PD1/verticesBEA.txt", false);
        Collection<TVertice> verticesG = new LinkedList<>();
        for (String vertices : vert) {
            datos = vertices.split(",");
            verticesG.add(new TVertice(datos[0]));
            
        }
        
        TGrafoNoDirigido gnd = new TGrafoNoDirigido(verticesG,aristasG);
        TGrafoNoDirigido prim = gnd.Prim();
        
        for (Map.Entry<Comparable, TVertice> entry : prim.getVertices().entrySet()) {
            System.out.println("clave=" + entry.getKey());
            LinkedList<TAdyacencia> ady = entry.getValue().getAdyacentes();
            int cont = 0;
            for (TAdyacencia a: ady){

                cont += a.getCosto();
            }
            System.out.println(cont);
            cont = 0;
        }   

               
        Collection<TVertice> v = gnd.bea();
        for (TVertice vet : v) {
            System.out.println(vet.getEtiqueta());
        } 

        
       
    
    }
 
}