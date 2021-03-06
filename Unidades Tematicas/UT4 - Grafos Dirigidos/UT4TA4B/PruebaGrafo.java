package UT4TA4B;


import java.util.Collection;

public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/UT4TA4/aeropuertos_1.txt","./src/UT4TA4/conexiones_1.txt",
                false, TGrafoDirigido.class);

        /*Object[] etiquetasarray = gd.getEtiquetasOrdenado();

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");
        Double[][] mfloyd = gd.floyd();
        UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Matriz luego de FLOYD");
        for (int i = 0; i < etiquetasarray.length; i++) {
            System.out.println("excentricidad de " + etiquetasarray[i] + " : " + gd.obtenerExcentricidad((Comparable) etiquetasarray[i]));
        }
        System.out.println();
        System.out.println("Centro del grafo: " + gd.centroDelGrafo());
        
        System.out.println("");
        System.out.println("BPF");
        Collection<TVertice> recorrido = gd.bpf();
        for(TVertice v : recorrido){
            System.out.println(v.getEtiqueta());
        }
        System.out.println("");
        System.out.println("BPF ORIGEN");
        Collection<TVertice> recorrido_Asuncion = gd.bpf("Asuncion");
        for(TVertice v: recorrido_Asuncion){
            System.out.println(v.getEtiqueta());
       }
       
       
       */
       //Collection<TVertice> myCosa = gd.bpf(gd.getVertices().get("Asuncion"));
       //System.out.println(myCosa);
       System.out.println(gd.bpf("Montevideo"));
       
       
    }
}
