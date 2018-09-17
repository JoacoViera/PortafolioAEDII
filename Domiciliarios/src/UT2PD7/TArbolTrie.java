/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2PD7;

import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author joaqu
 */
public class TArbolTrie implements IArbolTrie {
    
    private TNodoTrie raiz;
    
    
      
    @Override
    public Collection<TAbonado> buscarTelefonos(String pais, String area) {
    LinkedList<TAbonado> telefonos = null;
        if (raiz == null) {
            return telefonos;
        } else {
            
            String prefijo = pais+area;
            telefonos = new LinkedList<>();
            TNodoTrie nodo = raiz.buscarPrefijo(prefijo);
            if(nodo!= null){
                 System.out.println("si hay coincidencias");
            nodo.buscarTelefonos(prefijo, telefonos);
               
            return telefonos;
            }
            System.out.println("No hay coencidencias");
            return null;
        }
    }
    @Override
    public void insertar(TAbonado unAbonado) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        
            raiz.insertar(unAbonado);
        
    }

    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }
}
