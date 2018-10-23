package UT5TA2;

import java.util.Collection;
import java.util.LinkedList;

public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoNoDirigido gd = (TGrafoNoDirigido) UtilGrafos.cargarGrafo("./src/UT5_TA2/verticesBEA.txt","./src/UT5_TA2/aristasBEA.txt",
                false, TGrafoNoDirigido.class);

        //Object[] etiquetasarray = gd.getEtiquetasOrdenado();

        /*
        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");
        Double[][] mfloyd = gd.floyd();
        UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Matriz luego de FLOYD");
        for (int i = 0; i < etiquetasarray.length; i++) {
            System.out.println("excentricidad de " + etiquetasarray[i] + " : " + gd.obtenerExcentricidad((Comparable) etiquetasarray[i]));
        }
        System.out.println();
        System.out.println("Centro del grafo: " + gd.centroDelGrafo());
       
        */
        //Collection recorrido = gd.bpf();
        // imprimir etiquetas del bpf de todo el grafo....
        //Collection recorrido_Asuncion = gd.bpf("Asuncion");
        // imprimir etiquetas del bpf desde Asunción....
        //System.out.println(recorrido);
        
        
        //TCaminos caminos = gd.todosLosCaminos("Montevideo", "Rio_de_Janeiro");
        //caminos.imprimirCaminosConsola();
        
        /*
        if (gd.tieneCiclo()) {
            System.out.println("EL GRAFO TIENE CICLO");
        } else {
            System.out.println("EL GRAFO NO TIENE CICLO");
        }
        */
//////        System.out.println("BEA: " + gd.bea());
        System.out.println("BEA con ORIGEN: " + gd.bea2("d"));
//////        
//////        String[] res = new String[1];
//////        res[0]=gd.bea2("Curitiba");
//////        ManejadorArchivosGenerico.escribirArchivo("src/salidaBea.txt", res);
        
//        LinkedList<TVertice> listita = new LinkedList<>();
//        for (TArista ar : gd.prim(listita)) {
//            System.out.println(ar);
//        }
//        System.out.println();
        
//        Comparable[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.vertices);
//        UtilGrafos.imprimirMatrizMejorado(matriz, gd.vertices, "Matriz");
        
        
//        System.out.println("=== PRIM ===");
//        LinkedList<TVertice> listita = new LinkedList<>();
//        listita.add(gd.vertices.get("Santos"));
//        for (TArista ar : gd.prim(listita)) {
//            System.out.println(ar);
//        }
        
//        System.out.println("=== PRIM 2 === ");
//        for (TArista ar : gd.prim2()) {
//            System.out.println(ar);
//        }
        
////        System.out.println("=== KRUSKAL === ");
////        System.out.println(gd.kruskal());

          
//        for (TVertice ver : gd.puntosArticulacion()) {
//            System.out.println(ver.getEtiqueta().toString());
//        }
        
//        for (TArista ar : gd.arcosClasificados()) {
//            System.out.println(ar.toString() + " " + ar.clasificacion);
//        }
//        System.out.println(gd.esConexo());
//        
//          Kevin Bacon
         // System.out.println(gd.numeroBacon("SB"));
          
          
//          Comparable[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.vertices);
//          UtilGrafos.imprimirMatrizMejorado(matriz, gd.vertices, "Matriz");
//          
    }
}
