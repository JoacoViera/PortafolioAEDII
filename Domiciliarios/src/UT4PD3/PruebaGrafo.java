package UT4PD3;


import UT4PD2.*;
import java.util.Collection;

public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/UT4PD3/aeropuertos.txt","./src/UT4PD3/conexiones.txt",
                false, TGrafoDirigido.class);

        Object[] etiquetasarray = gd.getEtiquetasOrdenado();

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");

        Double[][] mfloyd = gd.floyd();
        UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Matriz luego de FLOYD");
        
        System.out.println("Centro del grafo: " + gd.centroDelGrafo());
        //EJ 1
        //  1 - B
        //  2 - A
        //  3 - Se instalan en San Pablo
        
        
        
        
        existeVuelo(gd,"Montevideo","Curitiba");
        existeVuelo(gd,"Porto_Alegre","Santos");
        
        
        TVertice verticeMontevideo = gd.buscarVertice("Montevideo");
        System.out.println(verticeMontevideo);
        System.out.println(gd.bpf());
        gd.desvisitarVertices();
        System.out.println(gd.bpf("Montevideo"));
        gd.desvisitarVertices();
        System.out.println(gd.bpf(verticeMontevideo));
        
        TCaminos caminos = gd.todosLosCaminos("Montevideo", "Santos");
        caminos.imprimirCaminosConsola();

        
    }
    
    public static void existeVuelo(TGrafoDirigido gd, String origen, String destino){
        TCaminos caminos = gd.todosLosCaminos(origen, destino);
        if(!caminos.getCaminos().isEmpty()){
            System.out.println("ES POSIBLE volar de " + origen + " a " + destino);
        }
        else{
            System.out.println("NO ES POSIBLE volar de " + origen + " a " + destino);
        }
    }
}
