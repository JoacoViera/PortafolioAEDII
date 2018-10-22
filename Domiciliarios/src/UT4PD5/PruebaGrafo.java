package UT4PD5;


import UT4PD4.*;
import UT4PD3.*;
import UT4PD2.*;
import java.util.Collection;

public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/UT4PD4/aeropuertos.txt","./src/UT4PD4/conexiones.txt",
                false, TGrafoDirigido.class);
     

        TCaminos caminos = gd.todosLosCaminos("Montevideo", "Santos");
        caminos.imprimirCaminosConsola();

        
    }
    
    public static void existeVuelo(TGrafoDirigido gd, String origen, String destino){
        TCaminos caminos = gd.todosLosCaminos(origen, destino);
        if(!caminos.getCaminos().isEmpty()){
            System.out.println("ES POSIBLE volar de " + origen + " a " + destino);
        }
        else{
            System.out.println("NO ES POSIBLE volar de " + origen + " a " + destino);
        }
    }
}
