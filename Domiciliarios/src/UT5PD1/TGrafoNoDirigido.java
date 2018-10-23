package UT5PD1;


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
//        Map<Comparable, TVertice> vertices = this.getVertices();
//        Collection<TVertice> verticesCollection = vertices.values();
//        LinkedList<TVertice> u = new LinkedList<>();
//        u.addAll(verticesCollection);
//        LinkedList<TVertice> v = new LinkedList<>();
//        LinkedList<TArista> t = this.getLasAristas();
//        v.add(u.removeFirst());
//        while(!u.equals(null)){
//            TArista arista = this.lasAristas.buscarMin(u, v);
//            t.add(arista);
//            u.remove(arista.getEtiquetaDestino());
//            v.add(this.buscarVertice(arista.getEtiquetaDestino()));         
//        }
//        return new TGrafoNoDirigido(v,t);
        Collection<Comparable> auxV = super.getVertices().keySet();
        LinkedList<Comparable> V = new LinkedList();
        V.addAll(auxV);
        auxV= null;
       
        LinkedList<Comparable> U = new LinkedList();
        Collection<TArista> T = new LinkedList();
        U.addFirst(V.removeFirst());
        while (!V.isEmpty()) {
            
            TArista a = this.lasAristas.buscarMin(U, V);      
            if (a != null) {
                T.add(a);
                U.addFirst(a.getEtiquetaDestino());
                V.remove(a.getEtiquetaDestino());
                
            }
        }
        
        TGrafoNoDirigido AAMin = new TGrafoNoDirigido(this.copiaVertices(),T);
        return AAMin;
    
        
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
