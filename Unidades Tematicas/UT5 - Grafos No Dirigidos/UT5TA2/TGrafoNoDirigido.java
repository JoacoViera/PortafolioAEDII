package UT5TA2;

import UT5TA2.TCamino;
import UT5TA2.TCaminos;
import UT5TA2.TVertice;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public class TGrafoNoDirigido extends TGrafoDirigido {

    private TAristas aristas = new TAristas();
    

    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> arista) {
        super(vertices, arista);
        aristas.setAristas(arista);
    } 

    public void cargarArista(Comparable etiquetaOrigen,
            Comparable etiquetaDestino, Double costo) {
        aristas.insertarAlFinal(new TArista(etiquetaOrigen, etiquetaDestino,
                costo));
        aristas.insertarAlFinal(new TArista(etiquetaDestino, etiquetaOrigen,
                costo)); // para que no falle la busqueda del min y destino
        insertarAdyacencia(etiquetaOrigen, etiquetaDestino, costo);
    }

    @SuppressWarnings("rawtypes")
    public boolean insertarAdyacencia(Comparable etiquetaOrigen,
            Comparable etiquetaDestino, Double costo) {
        TArista aristaOrigen = new TArista(etiquetaOrigen, etiquetaDestino, costo);
        TArista aristaDestino = new TArista(etiquetaDestino, etiquetaOrigen, costo);
        return (this.insertarArista(aristaOrigen) && this.insertarArista(aristaDestino));
    }
    
    public boolean insertarArista(TArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(),vertDestino)&& vertDestino.insertarAdyacencia(arista.getCosto(), vertOrigen);
            }
        }
        return false;
    }
    
    //BEA de donde pinte
    public String bea() {
        if (this.getVertices().isEmpty()) {
            return "El grafo está vacio";
        } else {
            for (TVertice vertV : this.getVertices().values()) {
                if (!vertV.getVisitado()) {
                   return  vertV.bea();
                }
            }
        }
      return "El grafo está vacio";
    }   
    
    
    //BEA 
    public String bea2(Comparable etiquetaOrigen) {
        this.desvisitarVertices();
        return vertices.get(etiquetaOrigen).bea();
    }
    
    public void desvisitarVertices() {
        for (TVertice vertice : this.vertices.values()) {
            vertice.setVisitado(false);
        }
    }
    
    
    //PRIM
    // Dada la estructura de datos actual extendida de grafos dirigidos, utilizo
    // la solución pensada en clase.
    public Collection<TArista> prim(Collection<TVertice> inicial) {
        Stack<TVertice> misVertices = new Stack<>();
        misVertices.addAll(inicial);
        LinkedList<TArista> lista = new LinkedList<TArista>();
        LinkedList<TArista> listaFinal = new LinkedList<>();
        TVertice ver;
        boolean salida = false;
        
        LinkedList<TVertice> todosVertices = new LinkedList<>();
        for (Iterator<TVertice> it = vertices.values().iterator(); it.hasNext();) {
            TVertice vert = it.next();
            todosVertices.add(vert);
        }
        while (!misVertices.containsAll(todosVertices)) {
            ver = misVertices.pop();
            misVertices.push(ver);
            for (TAdyacencia ady : ver.getAdyacentes())
                lista.add(new TArista(ver.getEtiqueta(), ady.getDestino().getEtiqueta(), ady.getCosto()));
            TArista cosito = (lista.getFirst());
            while (misVertices.contains(vertices.get(cosito.etiquetaDestino)) && !lista.isEmpty()) {
                lista.remove(cosito);
                try {
                    cosito = lista.getFirst();
                }
                catch (Exception e) {
                    salida = true;
                    break;
                }
            }
            if (salida)
                break;
            listaFinal.add(cosito);
            if (!lista.isEmpty()) {
            lista.remove(lista.getFirst()); }
            misVertices.push(vertices.get(cosito.getEtiquetaDestino()));
            
        }
        return listaFinal;
    }
    
    //otro prim
    public Collection<TArista> prim2(){
        LinkedList<TArista> t = new LinkedList<TArista>();
        Set<TVertice> u = new HashSet<TVertice>();
        Set<TVertice> v = new HashSet<TVertice>();
        for (Iterator<TVertice> it = vertices.values().iterator(); it.hasNext();) {
            TVertice vert = it.next();
            u.add(vert);
        }
        Iterator<TVertice> it2 = vertices.values().iterator();
        TVertice vert = it2.next();
        v.add(vert);
        u.remove(vert);
        while(!u.isEmpty()){
            TArista min = aristas.buscarMin(u, v);
            t.add(min);
            TVertice vert2 = vertices.get(min.getEtiquetaDestino());
            u.remove(vert2);
            v.add(vert2);
        }
        return t;
    }
    
    //KRUSCAL
    public Collection<TArista> kruskal(){
        SortedSet<TArista> lista = new TreeSet(listaAristas());
        LinkedList<TArista> miLista = new LinkedList<>();
        LinkedList<TVertice> todosVertices = new LinkedList<>();
        LinkedList<TVertice> misVertices = new LinkedList<>();
        
        for (Iterator<TVertice> it = vertices.values().iterator(); it.hasNext();) {
            TVertice vert = it.next();
            todosVertices.add(vert);
        }
        while (!misVertices.containsAll(todosVertices)) {
            try {
                TArista ar = lista.first();
                if (!misVertices.contains(vertices.get(ar.etiquetaDestino))) {
                    misVertices.add(vertices.get(ar.etiquetaDestino));
                    miLista.add(ar);
                }
                lista.remove(ar);
            } catch (Exception e) {
                //System.out.println(e);
                break;
            }
        }
        return miLista;
    }
    
    public LinkedList<TArista> listaAristas() {
        LinkedList<TArista> lista = new LinkedList<>();
        for (TVertice ver : vertices.values()) {
            for (TAdyacencia ady : ver.getAdyacentes())
                lista.add(new TArista(ver.getEtiqueta(), ady.getDestino().getEtiqueta(), ady.getCosto()));
        }
       return lista;
    }
    
    //CAMINO MAS CORTO 
//    public TCaminos camMasCorto(Comparable vOrigen,Comparable vDestino){
//        TGrafoNoDirigido grafo = this.Prim(); //aplico prim asi tengo el grafo con costos minimos.
//        TVertice origen=grafo.vertices.get(vOrigen);//encuentro el vertice de origren en el prim
//        TVertice destino=grafo.vertices.get(vOrigen);//encuentro el origen de destino en el prim
//        TCaminos camino=grafo.todosLosCaminos(vOrigen, vDestino);//aca tengo todos los caminos que tienen menor costo
//        Collection<TCamino> caminito= camino.getCaminos();
//        Double numero= Double.POSITIVE_INFINITY;
//        TCamino viejo= new TCamino();
//        LinkedList resultado = new LinkedList();
//        for(TCamino cam: caminito){
//            if(cam.getCostoTotal()<numero){
//                numero=cam.getCostoTotal();
//                resultado.add(cam);
//            }
//            //si el resultado contiene un numero costo total mayor al de ahora entonces elimino ese objeto
//            if(resultado.contains(cam.getCostoTotal()> numero)){
//                resultado.remove(cam);
//            } 
//        }
//         return camino;
//    }
    
    
    //PUNTOS DE ARTICULACION
      /**
     * Método para encontrar los puntos de articulación del grafo
     * @return Colección con los puntos de articulacion del grafo
     */
    public Collection<TVertice> puntosArticulacion () {
        LinkedList<TVertice> todosVertices = new LinkedList<>(vertices.values());
        LinkedList<TVertice> misVertices = new LinkedList<>();
        LinkedList<TVertice> aux = new LinkedList<>();
        LinkedList<TVertice> lista = new LinkedList<>();
        int [] contador = new int[1];
        TVertice vertice = todosVertices.getFirst();
        while (!misVertices.containsAll(todosVertices)) {
            contador[0] = 0;
            this.desvisitarVertices();
            aux.clear();
            aux.addAll(todosVertices);
            for (TVertice v : misVertices)
                aux.remove(v);
            vertice = aux.getFirst();
            lista.addAll(vertice.puntosArticulacion(contador));
            this.desvisitarVertices();
            vertice.bpfVertices(misVertices);
        }
        //System.out.println();
        return lista;
    }
    
    //CLASIFICACION DE ARCOS GND
    /**
     * Método para clasificar los arcos del grafo
     * @return Arcos clasificados en el orden del bpf del grafo
     */
    
    public Collection<TArista> arcosClasificados () {   
        LinkedList<TVertice> todosVertices = new LinkedList<>(vertices.values());
        LinkedList<TVertice> misVertices = new LinkedList<>();
        LinkedList<TVertice> aux = new LinkedList<>();
        LinkedList<TArista> lista = new LinkedList<>();
        int [] contador = new int[1];
        TVertice vertice = todosVertices.getFirst();
        while (!misVertices.containsAll(todosVertices)) {
            contador[0] = 0;
            this.desvisitarVertices();
            aux.clear();
            aux.addAll(todosVertices);
            for (TVertice v : misVertices)
                aux.remove(v);  
            vertice = aux.getFirst();
            lista.addAll(vertice.clasificacionArcosND(contador,misVertices));
        }
        //System.out.println();
        return lista;
    }
    
    
    //si un grafo es conezo
    public boolean esConexo(){
        TVertice a =this.vertices.values().iterator().next();
        Collection<Comparable> res=bpf(a.getEtiqueta());
        return res.containsAll(this.vertices.keySet());
    }
    
    
    
    
      
    
    public int numeroBacon(Comparable unaEtiqueta){
        int min =Integer.MAX_VALUE;
        
        TCaminos cami= this.todosLosCaminos("KB", unaEtiqueta);
        for(TCamino c : cami.getCaminos()){  
            System.out.println(cami.imprimirCaminos());
            int costoCam= c.obtenerVect();
            //System.out.println(cami.imprimirCaminos());
            if(costoCam<min){
                min=costoCam;
            } 
        }
        return min;
    }
    
    
}
