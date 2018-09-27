package UT2TA3;

import java.util.LinkedList;


public class TArbolTrie implements IArbolTrie {

    private TNodoTrie raiz;

    @Override
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra);
    }

    @Override
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    @Override
    public int buscar(String palabra) {
        return -1;
    }

    @Override
    public LinkedList<String> predecir(String prefijo) {
        LinkedList<String> lst = new LinkedList<String>();
        if (raiz != null) {
            raiz.predecir(prefijo, lst);
        }
        return lst;
    }
    
    
}
