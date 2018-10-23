package UT4TA6;


import static java.lang.System.in;
import java.util.Collection;

public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/VERTICES.txt", "./src/ARISTAS2.txt",
                false, TGrafoDirigido.class);

        Object[] etiquetasarray = gd.getEtiquetasOrdenado();

   
        gd.desvisitarVertices();
                
   
/*        if (gd.tieneCiclo()) {
            System.out.println("tiene ciclos");
        } else {
            System.out.println("no tiene ciclos");
        }*/

        TCamino a = gd.caminoCritico("A", "D");
        System.out.println(a);
        //Mapgd.holgura("A", "F");
    }
}
