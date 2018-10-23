
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;


public class PruebaGrafo {

    public static void main(String[] args) {
//        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/aeropuertos.txt","./src/conexiones.txt",
//                false, TGrafoDirigido.class);
        

//        Object[] etiquetasarray = gd.getEtiquetasOrdenado();
//
//        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
//        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");
//
//        Double[][] mfloyd = gd.floyd();
//        UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Matriz luego de FLOYD");
//        
//        System.out.println("Centro del grafo: " + gd.centroDelGrafo());
//             
//     
//        existeVuelo(gd,"Montevideo","Curitiba");
//        existeVuelo(gd,"Porto_Alegre","Santos");
//        
//        
//        TVertice verticeMontevideo = gd.buscarVertice("Montevideo");
//        System.out.println(verticeMontevideo);
//        System.out.println(gd.bpf());
//        gd.desvisitarVertices();
//        System.out.println(gd.bpf("Montevideo"));
//        gd.desvisitarVertices();
//        System.out.println(gd.bpf(verticeMontevideo));
//        
//        TCaminos caminos = gd.todosLosCaminos("Montevideo", "Santos");
//        caminos.imprimirCaminosConsola();
        

        String[] aristas = ManejadorArchivosGenerico.leerArchivo("src/aristasBEA.txt", false);
        String[] datos = null;
        Collection<TArista> aristasG = new LinkedList<>();
        for (String arista : aristas) {
            datos = arista.split(",");
            if (Character.isDigit(datos[2].charAt(0))) {               
                aristasG.add(new TArista(datos[0],datos[1],Double.parseDouble(datos[2])));
            } else{
                aristasG.add(new TArista(datos[0],datos[1],1));
            }

        }

        String[] vert = ManejadorArchivosGenerico.leerArchivo("src/verticesBEA.txt", false);
        Collection<TVertice> verticesG = new LinkedList<>();
        for (String vertices : vert) {
            datos = vertices.split(",");
            verticesG.add(new TVertice(datos[0]));
            
        }
        
        TGrafoNoDirigido gnd = new TGrafoNoDirigido(verticesG,aristasG);

            
        Collection<TVertice> v = gnd.bea();
        for (TVertice vet : v) {
            System.out.println(vet.getEtiqueta());
        } 

        

        
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
