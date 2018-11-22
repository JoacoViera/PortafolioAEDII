package AlgoritmosDeClasificacion;
import java.util.Random;

public class GeneradorDatosGenericos {
    private static int TAMANIO_MAX = 300;
    
    public int[] generarDatosAleatorios() {
        Random rnd = new Random();
        int[] datosGenerados = new int[TAMANIO_MAX];
        boolean[] datosUtilizados = new boolean[TAMANIO_MAX];
        for (int i = 0; i < datosGenerados.length; i++) {
            int j = rnd.nextInt(TAMANIO_MAX);
            while(datosUtilizados[j]){
                j = (j + 1) % TAMANIO_MAX;
            }
            datosGenerados[j] = i;
            datosUtilizados[j] = true;
        }
        return datosGenerados;
    }

    public int[] generarDatosAscendentes() {
        int [] copiaAscendente = new int[TAMANIO_MAX];
        for (int i = 0; i < TAMANIO_MAX; i++) {
            copiaAscendente[i] = i;
        }
        return copiaAscendente;
    }

    public int[] generarDatosDescendentes() {
        int [] copiaDescendente = new int[TAMANIO_MAX];
        for (int i = 0; i < TAMANIO_MAX; i++) {
            copiaDescendente[i] = TAMANIO_MAX - i;
        }
        return copiaDescendente;
    }
    
    public int[] generarDatosAleatorios(int largo) {
        Random rnd = new Random();
        int[] datosGenerados = new int[largo];
        boolean[] datosUtilizados = new boolean[largo];
        for (int i = 0; i < datosGenerados.length; i++) {
            int j = rnd.nextInt(largo);
            while(datosUtilizados[j]){
                j = (j + 1) % largo;
            }
            datosGenerados[j] = i;
            datosUtilizados[j] = true;
        }
        return datosGenerados;
    }

    public int[] generarDatosAscendentes(int largo) {
        int [] copiaAscendente = new int[largo];
        for (int i = 0; i < largo; i++) {
            copiaAscendente[i] = i;
        }
        return copiaAscendente;
    }

    public int[] generarDatosDescendentes(int largo) {
        int [] copiaDescendente = new int[largo];
        for (int i = 0; i < largo; i++) {
            copiaDescendente[i] = largo - i;
        }
        return copiaDescendente;
    }
	
}
