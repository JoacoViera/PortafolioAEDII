package UT5TA2;


import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {

    Map<Comparable, TVertice> vertices; 

    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }
    
    protected TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino.
     * En caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean inv�lidas, retorna falso.
     *
     */
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de eliminar un vertice en el grafo. En caso de no
     * existir el v�rtice, retorna falso. En caso de que la etiqueta sea
     * inv�lida, retorna false.
     *
     */
    public boolean eliminarVertice(Comparable nombreVertice) {
        if (nombreVertice != null) {
            getVertices().remove(nombreVertice);
            return getVertices().containsKey(nombreVertice);
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de una arista. Las
     * etiquetas pasadas por par�metro deben ser v�lidas.
     *
     * @return True si existe la adyacencia, false en caso contrario
     */
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    

    /**
     * Matodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea
     * valida, se deben cumplir los siguientes casos: 1) Las etiquetas pasadas
     * por parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    public boolean insertarArista(TArista arista) {
        if ((arista.getEtiquetaOrigen()!= null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }
 
    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse v�rtices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }
    @Override
 
 public boolean insertarVertice(TVertice vertice) {
     Comparable unaEtiqueta = vertice.getEtiqueta();
     if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

      
    
    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }
    
 

    /**
     * @return the vertices
     */
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Comparable centroDelGrafo() {
        Double menorExcentricidad = Double.MAX_VALUE;
        Comparable etiquetaMenorEx = null;
        
        for (Comparable etiqueta : getVertices().keySet()) {
            Double excentricidadVert = (Double) obtenerExcentricidad(etiqueta);
            if (menorExcentricidad.compareTo(excentricidadVert) > 0) {
                menorExcentricidad = excentricidadVert;
                etiquetaMenorEx = etiqueta;
            }
        }
        return etiquetaMenorEx;
    }

    @Override
    public Double[][] floyd() {
        Double[][] matrizFloyd = UtilGrafos.obtenerMatrizCostos(vertices);
        for (int k = 0; k < vertices.size(); k++) {
            for (int i = 0; i < vertices.size(); i++) {
                for (int j = 0; j < vertices.size(); j++) {
                    if  ((matrizFloyd[i][k] + matrizFloyd[k][j] < matrizFloyd[i][j]) && (matrizFloyd[i][j] != -1d)){
                        matrizFloyd[i][j] = matrizFloyd[i][k] + matrizFloyd[k][j];
                    }
                }   
            }
        }
        return matrizFloyd;
    }

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        Double resultado = 0d;
        Double matrizCaminosMinimos[][] = floyd();
        TVertice origen = getVertices().get(etiquetaVertice);
        
        int indiceOrigen = 0;
        for (Comparable contadorAuxiliar : getVertices().keySet()) {
            if (contadorAuxiliar == origen.getEtiqueta()) {
                break;
            }
            indiceOrigen++;
        }
        
        for (int x = 0; x < matrizCaminosMinimos.length; x++) {
            Double camino = matrizCaminosMinimos[x][indiceOrigen];
            if (camino == null) {
                camino = Double.MAX_VALUE;
            }
            if (x != indiceOrigen && resultado.compareTo(camino) < 0) {
                resultado = camino;
            }
        }
        return resultado;
    }

    @Override
    public boolean[][] warshall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Collection<Comparable> bpf(TVertice vertice) {
        Collection<Comparable> visitados = new LinkedList<Comparable>();
        vertice.bpf(visitados);
        return visitados;
    }

    @Override
    public Collection<Comparable> bpf(Comparable etiquetaOrigen) {
            Collection<Comparable> visitados = new LinkedList<Comparable>();
        this.buscarVertice(etiquetaOrigen).bpf(visitados);
        return visitados;
    }
    
    @Override
    public Collection<Comparable> bpf() {
        Collection<Comparable> visitados = new LinkedList<Comparable>();
        for (TVertice v : vertices.values()) {
            if(!v.getVisitado()){
                //visitados.add("*");
                v.bpf(visitados);
            }
        }
        return visitados;
    }
    
    @Override
    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TCaminos caminos = new TCaminos();
        TVertice origen = this.buscarVertice(etiquetaOrigen);
        if(origen != null){
            TCamino camino = new TCamino(origen);
            origen.todosLosCaminos(etiquetaDestino, camino, caminos);
            return caminos;
        }
        return null;
    }
   
    
    @Override
    public boolean tieneCiclo() {
        boolean resultado = false;
        if (vertices.isEmpty()) {
            System.out.println("El grafo está vacio");
        } else {
            for (TVertice vertV : vertices.values()) {
                if (!vertV.getVisitado()) {
                    TCamino camino = new TCamino(vertV);
                    resultado = vertV.tieneCiclo(camino);
                    //System.out.println(camino.imprimirEtiquetas());
                    
                    if(resultado){
                        return resultado;
                    }
                }
            }
        }
        
        return resultado;
    }
     public boolean esConexo(){
        TVertice a =this.vertices.values().iterator().next();
        Collection<Comparable> res=bpf(a.getEtiqueta());
        return res.containsAll(this.vertices.keySet());
    }
    
}
