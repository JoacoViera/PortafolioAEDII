package UT5TA2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class TAristas {

    private final static String SEPARADOR_ELEMENTOS_IMPRESOS = "-";
    private Collection<TArista> aristas = new LinkedList <TArista>(); 
    
    
    
    /**
     * Busca dentro de la lista de aristas una arista que conecte a 
     * etOrigen con etDestino
     * @param etOrigen
     * @param etDestino
     * @return 
     */
    public TArista buscar(Comparable etOrigen, Comparable etDestino) {
        Collection<TArista> ari =  this.aristas;
        for(TArista actual : ari)
        {
            if(actual.getEtiquetaOrigen().equals(etOrigen) && actual.getEtiquetaDestino().equals(etDestino))
            {
                return actual;
            }   
        }
        return null;
    }

    /**
     * Busca la arista de menor costo que conecte a cualquier nodo de
     * VerticesU con cualquier otro de VerticesV y cuyo costo sea el minimo
     * @param VerticesU - Lista de vertices U
     * @param VerticesV - Lista de vertices V
     * @return 
     */
    public TArista buscarMin(Collection<TVertice> VerticesU, Collection<TVertice> VerticesV) {
        //TODO: ---------COMPLETAR ALGORITMO--------
        // para todo u en Vertices U
        // para todo v en Vertices V
        // tA =buscar (u, v)
        // si tA <> null y tA.costo < costoMin entonces
        // tAMin = tA y costoMin = tA.costo
        // fin para todo v
        // fin para todo u
        // devolver tAMin
        //------------ SOLUCIÓN -------------
        TArista tempArista = null;
        TArista tAMin = null;
        Double costoMin = Double.POSITIVE_INFINITY;        
        for(TVertice u : VerticesU){
            for(TVertice v : VerticesV){
                tempArista = this.buscar(u.getEtiqueta(),v.getEtiqueta());
                if(tempArista != null && tempArista.getCosto() < costoMin){
                    tAMin = tempArista;
                    costoMin = tempArista.getCosto();
                }
            }
        }
        return tAMin;       
    }

    public String imprimirEtiquetas() {
         Collection<TArista> ari =  this.aristas;
        if (ari.isEmpty()) {
            return null;
        }
        StringBuilder salida = new StringBuilder();
        for(TArista arista: ari)
        {
            String str = arista.etiquetaOrigen + SEPARADOR_ELEMENTOS_IMPRESOS +arista.etiquetaDestino +SEPARADOR_ELEMENTOS_IMPRESOS + arista.costo;
            salida.append(str);
        }
        //TODO: Completar codigo que imprime todas las aristas de la lista en el siguiente formato:
        //ORIGEN - DESTINO - COSTO
        return salida.toString();
    }

    /**
     * Inserta la arista al final de la coleccion de aristas
     * @param tArista 
     */
    public void insertarAlFinal(TArista tArista) {
        Collection<TArista> ari = this.aristas;
        ari.add(tArista);
    }

    

    /**
     * @param aristas the aristas to set
     */
    public void setAristas(Collection<TArista> aristas) {
        this.aristas = aristas;
    }

}
