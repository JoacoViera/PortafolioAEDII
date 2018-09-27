package UT3TA6;



import java.util.HashMap;
import java.util.LinkedList;

public class TNodoTrieHashMap implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private final HashMap<Comparable, TNodoTrieHashMap> hijos;
    private int posicion = -1;

    public TNodoTrieHashMap() {
        hijos = new HashMap<>();
        posicion = -1;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            Comparable character = unaPalabra.charAt(c);
            if (!nodo.hijos.containsKey(character)) {
                nodo.hijos.put(character, new TNodoTrieHashMap());
            }
            nodo = nodo.hijos.get(character);
        }
    }

    
    public void insertar(String unaPalabra, int pos) {
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            Comparable character = unaPalabra.charAt(c);
            if (!nodo.hijos.containsKey(character)) {
                nodo.hijos.put(character, new TNodoTrieHashMap());
            }
            nodo = nodo.hijos.get(character);
        }
        nodo.posicion = pos;
    }

    @Override
    public void imprimir(String s) {
        if (this.posicion >= 0) {
            System.out.println(s + " posición: " + posicion);
        }
        for (Comparable caracter : this.hijos.keySet()) {
            TNodoTrieHashMap temp = this.hijos.get(caracter);
            if (temp != null) {
                temp.imprimir(s + caracter);
            }
        }
    }

    public int buscar(String s) {
        TNodoTrieHashMap nodo = this;
        int temp = 0;
        for (int c = 0; c < s.length(); c++) {
            Character character = s.charAt(c);
            temp++;
            if (nodo.hijos.get(character) == null) {
                return -temp;
            }
            nodo = nodo.hijos.get(character);
        }
        if (nodo.posicion >= 0) {
            return temp;
        }
        return -temp;
    }
    
     public TNodoTrieHashMap buscarNodoTrie(String s) {
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < s.length(); c++) {
            Character character = s.charAt(c);
            if (nodo.hijos.get(character) == null) {
                return null;
            }
            nodo = nodo.hijos.get(character);
        }
        return nodo;
    }
    
    public void predecir (String prefijo, LinkedList<String> palabras){
        TNodoTrieHashMap nodo = buscarNodoTrie(prefijo);
        System.out.println("-------");
        predecir(" ", prefijo, palabras, nodo);

    }
    
    private void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrieHashMap nodo){
        if(nodo != null){
            palabras.add(prefijo+s);
            for (int c = 0; c < s.length(); c++){
                Character character = s.charAt(c);
                if (nodo.hijos.get(character) != null){
                   predecir(s+character, prefijo, palabras, nodo.hijos.get(character));
                }
            }
        }
    }
  
}
