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
        if (this.buscar(unElemento.getEtiqueta()) == null) {
            return false;
        } else{
            if (this.hijos.size() == 0){
                this.insertar(unElemento);
            }
            else{
                for (TNodoArbolGenerico hijo : hijos){
                    if (unElemento.getEtiqueta().compareTo(hijo.getEtiqueta()) == -1){
                        this.agregarHijo(unElemento);
                    }                   
                }
            }    
        }
        return false;
    }
    

    /**
     * @param unaEtiqueta
     * @return
     */
    public TNodoArbolGenerico buscar(Comparable unaEtiqueta) {
        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else{
            for (TNodoArbolGenerico hijo : hijos){
                TNodoArbolGenerico nodo = hijo.buscar(unaEtiqueta);
                if (nodo != null){
                    return nodo;
                }
            }
        }
        return null;
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

