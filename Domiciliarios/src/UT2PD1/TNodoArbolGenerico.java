/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2PD1;
import java.util.LinkedList;
/**
 *
 * @author joaqu
 */
public class TNodoArbolGenerico<T>{
    
    private Comparable etiqueta;
    private LinkedList<TNodoArbolGenerico> hijos;
    private TNodoArbolGenerico<T> padre;
    private T datos;
    
    public TNodoArbolGenerico(Comparable unaEtiqueta, T unosDatos, TNodoArbolGenerico unPadre) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
        padre = unPadre;
        hijos = new LinkedList<>();
    }
    
    public LinkedList<TNodoArbolGenerico> getHijos() {
        return hijos;
    }
    
    public void setHijos(LinkedList<TNodoArbolGenerico> nuevosHijos) {
        hijos = nuevosHijos;
    }
    
    public void agregarHijo(TNodoArbolGenerico hijo) {
        hijos.add(hijo);
    }    
    
    public Comparable getEtiqueta() {
        return etiqueta;
    }
    
    public T getDato() {
        return datos;
    }
    
    public String imprimir() {
        return (etiqueta.toString());
    }
    
    public boolean esPadre() {
        return !hijos.isEmpty();
    }
    
    public TNodoArbolGenerico getPadre() {
        return this.padre;
    }
    
    
    public boolean insertar(TNodoArbolGenerico unElemento) {
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(unElemento);
            } else {
                hijoIzq = unElemento;
                return true;
            }
        } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(unElemento);
            } else {
                hijoDer = unElemento;
                return true;
            }
        } else {
            // ya existe un elemento con la misma etiqueta.-
            return false;
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    public TNodoArbolGenerico buscar(Comparable unaEtiqueta) {

        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscar(unaEtiqueta);
        } else {
            return null;
        }
    }
    
    public String preOrden() {
        StringBuilder tempStr = new StringBuilder();
        tempStr.append(imprimir());
        if (hijos != null) {
            for (TNodoArbolGenerico hijo : hijos){
                hijo.preOrden();
                tempStr.append(TArbolGenerico.SEPARADOR_ELEMENTOS_IMPRESOS);
            }
        }
        return tempStr.toString();
    }
    
        public String postOrden() {
        StringBuilder tempStr = new StringBuilder();
        if (hijos != null) {
            for (TNodoArbolGenerico hijo : hijos){
                hijo.preOrden();
                tempStr.append(TArbolGenerico.SEPARADOR_ELEMENTOS_IMPRESOS);
            }
        }
        tempStr.append(imprimir());
        return tempStr.toString();
    }
}

