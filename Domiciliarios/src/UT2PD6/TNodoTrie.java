package UT2PD6;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;


public class TNodoTrie{

    private static final int CANT_CHR_ABECEDARIO = 4;
    private HashMap<String, Integer> map= new HashMap<String, Integer>();;// 
    private TNodoTrie[] hijos;
    private boolean esPalabra;
    private int ocurrencia;
    //private TAbonado dato;
    
    
    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
        int ocurrencia = 0;
        map.put("a", 0);
        map.put("c", 1);
        map.put("g", 2);
        map.put("t", 3);
    }
    
    public String devolverChar(Integer valor) {
        Iterator it = this.map.keySet().iterator();
        while(it.hasNext()){
             String key = (String) it.next();
             if(valor == this.map.get(key)){
                 return key;
             }
             
             //System.out.println("Clave: " + key + " -> Valor: " + this.map.get(key));
         }
        return null;
    }

    
    public TNodoTrie buscar_prefijo(String prefijo){
        //prefijo = prefijo.toLowerCase();
       TNodoTrie nodo = this;
       for (int c = 0; c < prefijo.length(); c++) {
            String letra = String.valueOf(prefijo.charAt(c));
          //  System.out.println(map.get(letra));
            int indice = map.get(letra);
           if (nodo.hijos[indice] == null) {
               return null;
           }
           nodo = nodo.hijos[indice];
       }       
       return nodo; 
   }
    
    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                //System.out.println(nodo.dato.getNombre());
                System.out.println(s + " Ocurrencia en : "+ nodo.ocurrencia);
           
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    String letra = devolverChar(c);
                    //System.out.println(devolverChar(c));
                    //char letra = (char) ((c) + 'a');
                    imprimir(s+letra, nodo.hijos[c]);
                    
                }
            }
        }
    }
   
    public void imprimir() {
        
        imprimir("", this);
    }
   

    public void predecir(String prefijo, LinkedList<String> palabras,TNodoTrie nodo) {
        if(nodo!= null){
            if (nodo.esPalabra){
                palabras.add(prefijo);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if(nodo.hijos[c] != null){
                    String letra = devolverChar(c);
                    predecir(prefijo+letra, palabras,nodo.hijos[c]);
                }           
            }
        }       
    }
    
    public void buscarSecuencia(String prefijo, LinkedList<Integer> secuencia ,TNodoTrie nodo) {
             if (nodo != null) {
            if (nodo.esPalabra) {
                //System.out.println(nodo.dato.getNombre());
                System.out.println(prefijo + " Ocurrencia en  : "+ nodo.ocurrencia);
                secuencia.add(nodo.ocurrencia);
           
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    String letra = devolverChar(c);
                    buscarSecuencia(prefijo+letra,secuencia, nodo.hijos[c]);
                    
                }
            }
        }
    }
    
    
    

   
    public void insertar(String unaClave, int ocurrencia) {
      
        TNodoTrie nodo = this;
        for (int c = 0; c < unaClave.length(); c++) {
            int indice = unaClave.charAt(c) -'a';

            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
                
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
       nodo.ocurrencia += ocurrencia;
        
    }
    
    public void insertar2(String unaClave, int ocurrencia) {
      
        TNodoTrie nodo = this;
        for (int c = 0; c < unaClave.length(); c++) {
            //System.out.println(unaClave.charAt(c));
            String letra = String.valueOf(unaClave.charAt(c));
          //  System.out.println(map.get(letra));
            int indice = map.get(letra);
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
                
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
       nodo.ocurrencia += ocurrencia;
        
    }
}

