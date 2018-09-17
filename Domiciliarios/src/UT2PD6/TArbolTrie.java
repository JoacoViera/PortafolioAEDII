package UT2PD6;


import java.util.Collection;
import java.util.LinkedList;

public class TArbolTrie {
    
    private TNodoTrie raiz;
    
  
    public void insertar(String UnaClave , int ocurrencia) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        
            raiz.insertar2(UnaClave, ocurrencia);
        
    }

    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }
    public LinkedList<Integer> buscarOcurrencias(String prefijo) {
    LinkedList<Integer> secuencia = null;
        if (raiz == null) {
            return secuencia;
        } else {
            
           
            secuencia = new LinkedList<>();
            TNodoTrie nodo = raiz.buscar_prefijo(prefijo);
            if(nodo!= null){
                 System.out.println("si hay coincidencias");
            nodo.buscarSecuencia(prefijo, secuencia, nodo);
               
            return secuencia;
            }
            System.out.println("No hay coencidencias");
            return null;
        }
    }
 
       
}
