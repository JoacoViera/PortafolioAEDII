package UT6TA1;

import java.util.Arrays;


public class TClasificador {
    public static final int METODO_CLASIFICACION_INSERCION = 1;
    public static final int METODO_CLASIFICACION_SHELL = 2;
    public static final int METODO_CLASIFICACION_BURBUJA = 3;

    /**
     * Punto de entrada al clasificador
     * 
     * @param metodoClasificacion
     * @param orden
     * @param tamanioVector
     * @return Un vector del tam. solicitado, ordenado por el algoritmo solicitado
     */
    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion) {
            switch (metodoClasificacion) {
            case METODO_CLASIFICACION_INSERCION:
                    return ordenarPorInsercion(datosParaClasificar);
            case METODO_CLASIFICACION_SHELL:
                    return ordenarPorShell(datosParaClasificar);
            case METODO_CLASIFICACION_BURBUJA:
                    return ordenarPorBurbuja(datosParaClasificar);
            default:
                    System.err.println("Este codigo no deberia haberse ejecutado");
                    break;
            }
            return datosParaClasificar;
    }

    private void intercambiar(int[] vector, int pos1, int pos2) {
            int temp = vector[pos2];
            vector[pos2] = vector[pos1];
            vector[pos1] = temp;
    }


    /**
     * @param datosParaClasificar
     * @return
     */
    private int[] ordenarPorShell(int[] datosParaClasificar) {
        int j, inc;
        int[] incrementos = new int[] { 3221, 359, 51, 11, 3, 1 };
        for (int posIncrementoActual = 0; posIncrementoActual < incrementos.length; posIncrementoActual++) {
            inc = incrementos[posIncrementoActual];
            if (inc < (datosParaClasificar.length / 2)) {
                for (int i = inc; i < datosParaClasificar.length; i++) {
                    int aux = datosParaClasificar[i];
                    j = i - inc;
                    while (j >= 0 && aux<datosParaClasificar[j]) {
                        if (datosParaClasificar[j] > datosParaClasificar[j + inc]) {
                            intercambiar(datosParaClasificar, j, j + inc);
                            j = j--;
                        } 
                    }
                }
            }
        }
        return datosParaClasificar;
    }


    /**
     * @param datosParaClasificar
     * @return
     */
    protected int[] ordenarPorInsercion(int[] datosParaClasificar) {
            if (datosParaClasificar != null) {
                    for (int i = 2; i < datosParaClasificar.length; i++) {
                            int j = i - 1;
                            while ((j >= 0) && (datosParaClasificar[j+1] < datosParaClasificar[j])) {
                                    intercambiar(datosParaClasificar, j, j + 1);
                                    j--;
                            }
                    }
                    return datosParaClasificar;
            }
            return null;
    }

    private int[] ordenarPorBurbuja(int[] datosParaClasificar) {
            //datosParaClasificar = null;
            int n = datosParaClasificar.length - 1;
            for (int i = 0; i <= n; i++) {
                    for (int j = n; j >= (i + 1); j--) {
                            if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
                                    intercambiar(datosParaClasificar, j, j-1);
                            }
                    }
            }
            return datosParaClasificar;
    }

    public static void imprimirNombreMetodo(int valor){
        switch (valor) {
           case 1:
               System.out.println("------METODO DE INSERCION DIRECTA------");
               System.out.println("");
               break;
           case 2:
               System.out.println("------METODO DE SHELLSORT------");
               System.out.println("");
               break;
           case 3:
               System.out.println("------METODO DE BURBUJA------");
               System.out.println("");
               break;
           case 4:
               System.out.println("------METODO DE QUICKSORT------");
               System.out.println("");
               break;   
           default:
               System.err.println("Este codigo no deberia haberse ejecutado");
               break;
        }
    }



    public static void main(String args[]) {
        TClasificador clasif = new TClasificador();
        GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
        int[] vectorAleatorio = gdg.generarDatosAleatorios();
        int[] vectorAscendente = gdg.generarDatosAscendentes();
        int[] vectorDescendente = gdg.generarDatosDescendentes();

        int[] vectorAleatorio300 = Arrays.copyOfRange(vectorAleatorio, 0,299); 
        int[] vectorAscendente300 = Arrays.copyOfRange(vectorAscendente, 0,299);
        int[] vectorDescendente300 = Arrays.copyOfRange(vectorDescendente, 0,299);
        
        
        System.out.println("CLASIFICACION POR INSERCION DIRECTA");
        System.out.println("");
        System.out.println("Vector Aletorio:");
        for (int i = 0; i < vectorAleatorio.length; i++) {
                System.out.print(vectorAleatorio[i] + " ");
        }
        System.out.println("");
        System.out.println("Vector ordenado:");
        int[] resAleatorio = clasif.clasificar(vectorAleatorio.clone(),
                        METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resAleatorio.length; i++) {
                System.out.print(resAleatorio[i] + " ");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("Vector Ascendente:");
        for (int i = 0; i < vectorAscendente.length; i++) {
                System.out.print(vectorAscendente[i] + " ");
        }
        System.out.println("");
        System.out.println("Vector ordenado:");
        int[] resAscendente = clasif.clasificar(vectorAscendente.clone(),
                        METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resAscendente.length; i++) {
                System.out.print(resAscendente[i] + " ");
        }

        System.out.println("");
        System.out.println("");
        System.out.println("Vector Descendente:");
        for (int i = 0; i < vectorDescendente.length; i++) {
                System.out.print(vectorDescendente[i] + " ");
        }
        System.out.println("");
        System.out.println("Vector ordenado:");
        int[] resDescendente = clasif.clasificar(vectorDescendente.clone(),
                        METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resDescendente.length; i++) {
                System.out.print(resDescendente[i] + " ");
        }


        System.out.println("");
        System.out.println("-----------------------------------------------------");
        System.out.println("");

        System.out.println("CLASIFICACION POR SHELL");
        System.out.println("");
        System.out.println("Vector Aletorio:");
        for (int i = 0; i < vectorAleatorio.length; i++) {
                System.out.print(vectorAleatorio[i] + " ");
        }
        System.out.println("");
        System.out.println("Vector Ordenado:");
        int[] resAleatorio2 = clasif.clasificar(vectorAleatorio.clone(),
                        METODO_CLASIFICACION_SHELL);
        for (int i = 0; i < resAleatorio2.length; i++) {
                System.out.print(resAscendente[i] + " ");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("Vector Ascendente:");
        for (int i = 0; i < vectorAscendente.length; i++) {
                System.out.print(vectorAscendente[i] + " ");
        }
        System.out.println("");
        System.out.println("Vector ordenado:");
        int[] resAscendente2 = clasif.clasificar(vectorAscendente.clone(),
                        METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resAscendente2.length; i++) {
                System.out.print(resAscendente2[i] + " ");
        }

        System.out.println("");
        System.out.println("");
        System.out.println("Vector Descendente:");
        for (int i = 0; i < vectorDescendente.length; i++) {
                System.out.print(vectorDescendente[i] + " ");
        }
        System.out.println("");
        System.out.println("Vector ordenado:");
        int[] resDescendente2 = clasif.clasificar(vectorDescendente.clone(),
                        METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resDescendente2.length; i++) {
                System.out.print(resDescendente[i] + " ");
        }


        System.out.println("");
        System.out.println("-----------------------------------------------------");
        System.out.println("");

        System.out.println("CLASIFICACION POR BURBUJA");
        System.out.println("");
        System.out.println("Vector Aletorio:");
        for (int i = 0; i < vectorAleatorio.length; i++) {
                System.out.print(vectorAleatorio[i] + " ");
        }
        System.out.println("");
        System.out.println("Vector ordenado:");
        int[] resAleatorio3 = clasif.clasificar(vectorAleatorio.clone(),
                        METODO_CLASIFICACION_BURBUJA);
        for (int i = 0; i < resAleatorio3.length; i++) {
                System.out.print(resAleatorio3[i] + " ");
        }


        System.out.println("");
        System.out.println("");
        System.out.println("Vector Ascendente:");
        for (int i = 0; i < vectorAscendente.length; i++) {
                System.out.print(vectorAscendente[i] + " ");
        }
        System.out.println("");
        System.out.println("Vector ordenado:");
        int[] resAscendente3 = clasif.clasificar(vectorAscendente.clone(),
                        METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resAscendente3.length; i++) {
                System.out.print(resAscendente3[i] + " ");
        }

        System.out.println("");
        System.out.println("");
        System.out.println("Vector Descendente:");
        for (int i = 0; i < vectorDescendente.length; i++) {
                System.out.print(vectorDescendente[i] + " ");
        }
        System.out.println("");
        System.out.println("Vector ordenado:");
        int[] resDescendente3 = clasif.clasificar(vectorDescendente.clone(),
                        METODO_CLASIFICACION_INSERCION);
        for (int i = 0; i < resDescendente3.length; i++) {
                System.out.print(resDescendente3[i] + " ");
        }

        System.out.println("");
        System.out.println("-----------------------------------------------------");
        System.out.println("");
        
        
        
    }
}
