
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {
protected TAristas lasAristas = new TAristas() ;
       /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
       super(vertices, aristas);     
      lasAristas.insertarAmbosSentidos(aristas);
       
    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }
    
    public TAristas getLasAristas() {
        return lasAristas;
    }
 

   

    @Override
    public TGrafoNoDirigido Prim() {
        Map<Comparable, TVertice> vertices = this.getVertices();
        Collection<TVertice> verticesCollection = vertices.values();
        LinkedList<TVertice> u = new LinkedList<>();
        u.addAll(verticesCollection);
        LinkedList<TVertice> v = new LinkedList<>();
        LinkedList<TArista> t = this.getLasAristas();
        v.add(u.removeFirst());
        while(!u.equals(null)){
            TArista arista = this.lasAristas.buscarMin(u, v);
            t.add(arista);
            u.remove(arista.getEtiquetaDestino());
            v.add(this.buscarVertice(arista.getEtiquetaDestino()));         
        }
        return new TGrafoNoDirigido(v,t);
        
    }
    
    public Collection<TArista> prim2(){
        LinkedList<TArista> t = new LinkedList<TArista>();
        LinkedList<Comparable> u = new LinkedList<Comparable>();
        LinkedList<Comparable> v = new LinkedList<Comparable>();
        for (Iterator<TVertice> it = this.getVertices().values().iterator(); it.hasNext();) {
            TVertice vert = it.next();
            u.add(vert.getEtiqueta());
        }
        Iterator<TVertice> it2 = this.getVertices().values().iterator();
        TVertice vert = it2.next();
        v.add(vert.getEtiqueta());
        u.remove(vert);
        while(!u.isEmpty()){
            TArista min = this.lasAristas.buscarMin(u, v);
            t.add(min);
            TVertice vert2 = this.getVertices().get(min.getEtiquetaDestino());
            u.remove(vert2.getEtiqueta());
            v.add(vert2.getEtiqueta());
        }
        return t;
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Collection<TArista> kruskal(){
        SortedSet<TArista> lista = new TreeSet(getLasAristas());
        LinkedList<TArista> miLista = new LinkedList<>();
        LinkedList<TVertice> todosVertices = new LinkedList<>();
        LinkedList<TVertice> misVertices = new LinkedList<>();
        
        for (Iterator<TVertice> it = this.getVertices().values().iterator(); it.hasNext();) {
            TVertice vert = it.next();
            todosVertices.add(vert);
        }
        while (!misVertices.containsAll(todosVertices)) {
            try {
                TArista ar = lista.first();
                if (!misVertices.contains(this.getVertices().get(ar.etiquetaDestino))) {
                    misVertices.add(this.getVertices().get(ar.etiquetaDestino));
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
    
    public int numeroBacon(String actor) {
        TCaminos caminos = todosLosCaminos(actor, "KevinBacon");
        int numB = 1000000;
        for(TCamino camino:caminos.getCaminos()){
            if(numB>camino.getOtrosVertices().size()){
                numB = camino.getOtrosVertices().size();
            }
        }
        return numB;   
    }
    //haces todos los caminos origen kavin bacon, y destino el actor que queres saber
}
