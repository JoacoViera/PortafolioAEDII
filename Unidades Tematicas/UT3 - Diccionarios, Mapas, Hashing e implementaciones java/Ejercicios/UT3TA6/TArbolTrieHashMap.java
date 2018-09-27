package UT3TA6;



import java.util.LinkedList;


public class TArbolTrieHashMap implements IArbolTrie {

    private TNodoTrieHashMap raiz;

    @Override
    public void insertar(String palabra, int posicion) {
        if (raiz == null) {
            raiz = new TNodoTrieHashMap();
        }
        raiz.insertar(palabra, posicion);
    }


    @Override
    public int buscar(String palabra) {
        if (raiz != null) {
            return raiz.buscar(palabra);
        }
        return 0;
    }

    @Override
    public LinkedList<String> predecir(String prefijo){
        LinkedList<String> resultado = new LinkedList<>();
        if(raiz != null){
            raiz.predecir(prefijo, resultado);
        }
        return resultado;   
    }

    
    
    
}
