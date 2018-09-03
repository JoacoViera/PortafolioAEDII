/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2PD1;

/**
 *
 * @author joaqu
 */
public class TArbolGenerico<T> {
    
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";
    private TNodoArbolGenerico<T> raiz;
    
    public TArbolGenerico() {
        raiz = null;
    }
    
    public TArbolGenerico(TNodoArbolGenerico<T> raiz) {
        this.raiz = raiz;
    }
    
    public boolean esVacio() {
        return (raiz == null);
    }
    
    public boolean insertar(TNodoArbolGenerico<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }
    
    public TNodoArbolGenerico<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }
    

    public String preOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.preOrden();
        }
    }

    public String postOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.postOrden();
        }
    }
    
}
