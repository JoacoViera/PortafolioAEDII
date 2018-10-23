package UT5PD2;


import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
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
    public Collection<TVertice> copiaVertices(){
        Collection<TVertice> vert = new LinkedList();
        for (TVertice value : this.getVertices().values()) {
            vert.add(value.copia());
        }
        return vert;
    }
   
    @Override
    public TGrafoNoDirigido Kruskal() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                    System.out.println(ar.getEtiquetaDestino() + " " + ar.getEtiquetaOrigen());
                }
                lista.remove(ar);
            } catch (Exception e) {
                //System.out.println(e);
                break;
            }
        }
        this.getVertices().values();
        return new TGrafoNoDirigido(misVertices,lista); 
    }
    
}
