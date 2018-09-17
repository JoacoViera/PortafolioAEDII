/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2PD7;
import java.util.Collection;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author joaqu
 */
public class TArbolTrieTest {
    
    private TArbolTrie trie;
    
    @Before
    public void setUp() {
        trie = new TArbolTrie();
        TAbonado a1 = new TAbonado("FRANCISCO FERNANDEZ LOPEZ","05491155759");
        TAbonado a2 = new TAbonado("MIREN EDURNE ENRIQUE TRAORE","05491171685");
        TAbonado a3 = new TAbonado("OLVIDO RODAS BALBOA","05491173890");
        trie.insertar(a1);
        trie.insertar(a2);
        trie.insertar(a3);
        
    }
    
    @Test
    public void testPredecir() {
        System.out.println("predecir");
        String prefijo = "054";
        Collection<TAbonado> result = trie.buscarTelefonos("054", "91");
        assertEquals(3, result.size());
    }

    
}
