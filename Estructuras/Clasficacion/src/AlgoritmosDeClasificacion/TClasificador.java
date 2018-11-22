package AlgoritmosDeClasificacion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Alvarito
 */
public class TClasificador {
        public static final int METODO_CLASIFICACION_INSERCION = 1;
        public static final int METODO_CLASIFICACION_SHELL = 2;
        public static final int METODO_CLASIFICACION_BURBUJA = 3;
        public static final int METODO_CLASIFICACION_QUICKSORT = 4;
        public static final int METODO_CLASIFICACION_HEAPSORT = 5;
        public static final int METODO_CLASIFICACION_SELECCION = 6;
        public static final int METODO_CLASIFICACION_CUENTA = 7;
        public static final int METODO_CLASIFICACION_BINSORT = 8;
        public static final int METODO_CLASIFICACION_RADIX = 9;
        
        
    
	public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion, boolean cascara) {
		switch (metodoClasificacion) {
		case METODO_CLASIFICACION_INSERCION:
                    if (!cascara) {
                        return ordenarPorInsercion(datosParaClasificar);
                    } else {
                        return cascaraGeneral(datosParaClasificar);
                }
		case METODO_CLASIFICACION_SHELL:
                    if (!cascara) {
                        return ordenarPorShell(datosParaClasificar);
                    } else {
                        return cascaraGeneral(datosParaClasificar);
                    }
		case METODO_CLASIFICACION_BURBUJA:
                    if (!cascara) {
                        return ordenarPorBurbuja(datosParaClasificar);
                    } else {
                        return cascaraGeneral(datosParaClasificar);
                }
                case METODO_CLASIFICACION_QUICKSORT:
                    if(!cascara){
                        return ordenarPorQuickSort(datosParaClasificar);
                    } else{
                        return cascaraGeneral(datosParaClasificar);
                    }
                case METODO_CLASIFICACION_HEAPSORT:
                    if(!cascara){
                        return ordenarPorHeapSort(datosParaClasificar);
                    } else{
                        return cascaraGeneral(datosParaClasificar);
                    }
                case METODO_CLASIFICACION_SELECCION:
                    if(!cascara){
                        return ordenarPorSeleccion(datosParaClasificar);
                    } else{
                        return ordenarPorSeleccion(datosParaClasificar);
                    }
                case METODO_CLASIFICACION_CUENTA:
                    if(!cascara){
                        return ordenarPorCuenta(datosParaClasificar);
                    } else{
                        return ordenarPorCuenta(datosParaClasificar);
                    }
                case METODO_CLASIFICACION_BINSORT:
                    if(!cascara){
                        return ordenarPorBinsort(datosParaClasificar);
                    } else{
                        return ordenarPorBinsort(datosParaClasificar);
                    }
                 case METODO_CLASIFICACION_RADIX:
                    if(!cascara){
                        return ordenarPorBinsort(datosParaClasificar);
                    } else{
                        return ordenarPorBinsort(datosParaClasificar);
                    }
		default:
			System.err.println("Este codigo no deberia haberse ejecutado");
			break;
		}
		return datosParaClasificar;
	}
       public  double[] tiempoMedioAlgoritmoBase(int[] vectorOriginal, int metodo){           
        double[] resultado = new double[2];
        long t1 =0, t2 =0;
        t1 = System.nanoTime();
        long total = 0;
        int cantLlamadas = 0;
        while(total < 100000000){
            cantLlamadas++;
            int[] datosCopia = vectorOriginal.clone();
            clasificar(datosCopia,metodo,true);
            t2 = System.nanoTime();
            total = t2-t1;
        }
        long tiempoMedioCascara = total/cantLlamadas;

        t1 = System.nanoTime();         
        total = 0;
        cantLlamadas = 0;
        t2 = 0;
        while(total < 100000000){
            cantLlamadas++;
            int[] datosCopia = vectorOriginal.clone();
            clasificar(datosCopia,metodo,false);
            t2 = System.nanoTime();
            total = t2-t1;
        }
        long tiempoMedioAlgoritmoBase = total / cantLlamadas;

        long tiempoMedioAlgoritmo = tiempoMedioAlgoritmoBase - tiempoMedioCascara;
        resultado[0] = tiempoMedioAlgoritmo;
        resultado[1] = tiempoMedioAlgoritmo / 1000000.0;
        return resultado;
   }
        

	private void intercambiar(int[] vector, int pos1, int pos2) {
		int temp = vector[pos2];
		vector[pos2] = vector[pos1];
		vector[pos1] = temp;
	}
        
        private int[] cascaraGeneral(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            return datosParaClasificar;
            } else {
                return null;
            }
        }
        
        /**
	 * @param datosParaClasificar
	 * @return
	 */
	protected int[] ordenarPorShell(int[] datosParaClasificar) {
		int j, inc;
		int[] incrementos = new int[] { 3223, 358, 51, 10, 3, 1 };

		for (int posIncrementoActual = 1; posIncrementoActual < incrementos.length; posIncrementoActual++) {
			inc = incrementos[posIncrementoActual];
			if (inc < (datosParaClasificar.length / 2)) {
				for (int i = inc; i < datosParaClasificar.length; i++) {
					j = i - inc;
					while ((j >= 0) && (datosParaClasificar[j] > datosParaClasificar[j + inc])){
							intercambiar(datosParaClasificar, j, j +inc);
							j = j - inc;//habia un error aca,decia j--
						 
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
            //aca inicializaba en 2 a la variable i, 2do error encontrado
		if (datosParaClasificar != null) {
                    for (int i = 1; i < datosParaClasificar.length; i++) {
                        int j = i - 1;
                        while ((j >= 0) && (datosParaClasificar[j+1] < datosParaClasificar[j])) { //decia >, error 3
                            intercambiar(datosParaClasificar, j, j + 1);
                            j--;
                        }
                    }
                    return datosParaClasificar;
		}
		return null;
	}
        
        protected int[] ordenarPorSeleccion(int[] datosParaClasificar) {
        int n = datosParaClasificar.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = i;
            int claveMenor = datosParaClasificar[i];
            for (int j = i + 1; j < n; j++) {
                if (datosParaClasificar[j] < claveMenor) {
                    indiceMenor = j;
                    claveMenor = datosParaClasificar[j];
                }
            }
            intercambiar(datosParaClasificar, i, indiceMenor);
        }
        return datosParaClasificar;
        }

	protected int[] ordenarPorBurbuja(int[] datosParaClasificar) {
		//datosParaClasificar = null;
		int n = datosParaClasificar.length - 1;
		for (int i = 1; i <= n; i++){ //error 4, decia int i=0
                    for (int j = 1; j <= (n - (i - 1)); j++) {//error 5, decia int j = n
                        if (datosParaClasificar[j] < datosParaClasificar[j - 1]){
                            intercambiar(datosParaClasificar, j - 1, j);
                        }
                    }
		}
		return datosParaClasificar;
	}
        
        protected int[] ordenarPorQuickSort(int[] datosParaClasificar) {
            quicksort(datosParaClasificar, 0, datosParaClasificar.length - 1);
            return datosParaClasificar;
	}
        
        
        protected int[] ordenarPorQuickSortConProfundiad(int[] datosParaClasificar, int [] profundiad) {
            profundiad [0]= quicksort(datosParaClasificar, 0, datosParaClasificar.length - 1);
            return datosParaClasificar;
	}
                

	protected int quicksort(int[] entrada, int izquierda, int derecha) {
		int i = izquierda;
		int j = derecha;
                int contador=0;

		int posicionPivote = encuentraPivoteEnElMedio(izquierda,derecha,entrada); 
		//int posicionPivote=0;
		if (posicionPivote >= 0){            
                    int pivote = entrada[posicionPivote]; 
                    //int pivote = encuentraPivote2(izquierda,derecha,entrada); 
                    while (izquierda <= derecha) {
                        while ((entrada[izquierda] < pivote) && (izquierda < j)) {
                            izquierda++; 
                        }
                        while ((pivote < entrada[derecha]) && (derecha > i)) {
                            derecha--; 
                        }

                        if (izquierda <= derecha) {
                            intercambiar(entrada, izquierda, derecha); 
                            izquierda++;
                            derecha--;
                        }
                    }
                    contador++;
                    if (i < derecha)
                        contador+=quicksort(entrada, i, derecha);

                    if (izquierda < j)
                        contador+=quicksort(entrada, izquierda, j);
                                      
		}
                return contador;
	}
        
        private int encuentraPivote2(int izquierda, int derecha, int[] entrada) {
            if(entrada[izquierda] > entrada[izquierda+1]){
                return izquierda;
            }else{
                return izquierda+1;     
            }
        }
        
        private int encuentraPivoteEnElMedio(int izquierda, int derecha, int[] entrada) {
            int medio = ((derecha-izquierda)/2)+izquierda;
            if(entrada[medio] > entrada[medio+1]){
                return medio;
            }else{
                return medio+1;
            }
        }
        
        private int encuentraPivote(int izquierda, int derecha,int [] datos){
            if (izquierda == derecha){
                return -1;
            }
            if (datos[(izquierda + derecha) / 2] > datos[((izquierda + derecha)/2)+1]){
                return (izquierda + derecha)/2;
            }else{
                return ((izquierda + derecha)/2)+1;
            }
        }
        
        private int encuentraPivote3(int izquierda, int derecha, int[] entrada){
            return (int) Math.floor((derecha-izquierda)/2);
        }
        
        
        public static boolean estaOrdenado(int[] vector){
            boolean resultado = true;
            for (int i = 0; i < vector.length-1; i++){
                if(vector[i+1]< vector[i])
                    return false;
            }
            return resultado;
        }
        
        protected int[] ordenarPorHeapSort(int[] datosParaClasificar) {
            for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) { //Armo el heap inicial de n-1 div 2 hasta 0
                armaHeap(datosParaClasificar, i, datosParaClasificar.length - 1);
            }
            for (int i = datosParaClasificar.length - 1; i >= 1; i--) {
                intercambiar(datosParaClasificar,0,i);
                armaHeap(datosParaClasificar, 0, i-1);
            }
            return datosParaClasificar;
	}

	protected void armaHeap(int[] datosParaClasificar, int primero, int ultimo) {
            if (primero < ultimo){
                int r = primero;
                while(r <= ultimo / 2){
                    if (ultimo == 2*r){ //r tiene un hijo solo
                        if (datosParaClasificar[r] > datosParaClasificar[r*2]){
                            intercambiar(datosParaClasificar, r, 2 * r);
                            r = 2 ;
                        } else {
                            r = ultimo;
                        }
                    } else { //r tiene 2 hijos
                        int posicionIntercambio = 0;
                        if (datosParaClasificar[2*r] > datosParaClasificar[2*r + 1]){
                                posicionIntercambio = 2 * r;
                        } else {
                                posicionIntercambio = 2 * r + 1;
                        }
                        if (datosParaClasificar[r] < datosParaClasificar[posicionIntercambio]){
                                intercambiar(datosParaClasificar,r,posicionIntercambio);
                                r = posicionIntercambio;
                        } else {
                                r = ultimo;
                        }
                    }
                }			
            }
	}
        
        
        
        protected int[] ordenarPorCuenta(int datosParaClasificar[]){

            int[] aux = new int[datosParaClasificar.length];

            // Encuentro Minimo y Maximo
            int min = datosParaClasificar[0];
            int max = datosParaClasificar[0];
            for (int i = 1; i < datosParaClasificar.length; i++) {
                if (datosParaClasificar[i] < min) {
                    min = datosParaClasificar[i];
                } 
                if (datosParaClasificar[i] > max) {
                    max = datosParaClasificar[i];
                }
            }

            // Se crea el vector para contar la cantidad de cada elemento
            // Teniendo en cuenta el valor minimo y maximo para evitar recorridos innecesarios
            int[] cuenta = new int[max - min + 1];

            
            //Se pasa a ingresar en cada posicion cuantos valores hay de cada elemento del vector original
            for (int i = 0;  i < datosParaClasificar.length; i++) {
                cuenta[datosParaClasificar[i] - min]++;
            }
            

            // Se analiza hasta que posicion ira cada elemento
            cuenta[0]--;
            for (int i = 1; i < cuenta.length; i++) {
              cuenta[i] = cuenta[i] + cuenta[i-1];
            }
            
            
            for (int i = datosParaClasificar.length - 1; i >= 0; i--) {
                aux[cuenta[datosParaClasificar[i] - min]--] = datosParaClasificar[i];
            }

            return aux;
        }
        
        
        protected int[] ordenarPorBinsort(int datosParaClasificar[]){
            
            int maximo = datosParaClasificar[0];
            
            // Encuentro Maximo
            for (int i = 1; i < datosParaClasificar.length; i++) {
                if (datosParaClasificar[i] > maximo) {
                    maximo = datosParaClasificar[i];
                }
            }
        
            // Creo urnas
            List<Integer>[] urnas = new List[maximo];
            for (int i = 0; i < urnas.length; i++) {
                urnas[i] = new ArrayList<>();

            }
            
            for (int i = 0; i < datosParaClasificar.length; i++) {
                urnas[DMS(datosParaClasificar[i], maximo)].add(datosParaClasificar[i]);
            }

            for (int i = 0; i < maximo; i++) {

                Integer[] a = urnas[i].toArray(new Integer[urnas[i].size()]);
                int[] b = new int[a.length];
                for (int x = 0; x < a.length; x++) {
                    b[x] = a[x];
                }
                b = ordenarPorInsercion(b);

                urnas[i].clear();
                for (int x = 0; x < b.length; x++) {
                    urnas[i].add(b[x]);
                }
            }
            int contSalida = 0;
            for (int i = 0; i < maximo; i++) {
                for (Integer num : urnas[i]) {
                    datosParaClasificar[contSalida] = num;
                    contSalida++;
                }
            }
            return datosParaClasificar;

        }
        
        private static int DMS(int valor, int maximo) {
            if (valor == 0) {
                return 0;
            }
            valor = Math.abs(valor) / maximo;
            return (int) Math.floor(valor / Math.pow(10, Math.floor(Math.log10(maximo))));
        }
        
        protected int[] ordenarPorRadix(int datosParaClasificar[]){
            int largoVector = datosParaClasificar.length;
            int valorMenosSignificativo = datosParaClasificar[0];
            int exp = 1;
            
            
            int[] urnaResultado = new int[10];

            for (int i = 1; i < largoVector; i++)
                if (datosParaClasificar[i] > valorMenosSignificativo)
                    valorMenosSignificativo = datosParaClasificar[i];
            
            while (valorMenosSignificativo / exp > 0){              
                
                int[] urna = new int[10];

                for (int i = 0; i < largoVector; i++){
                    urna[(datosParaClasificar[i] / exp) % 10]++;
                }
                for (int i = 1; i < 10; i++){
                    urna[i] += urna[i - 1];
                }
                for (int i = largoVector - 1; i >= 0; i--){
                    urnaResultado[--urna[(datosParaClasificar[i] / exp) % 10]] = datosParaClasificar[i];
                }
                for (int i =0; i< largoVector; i++){
                    datosParaClasificar[i] = urnaResultado[i];  
                }
                exp *= 10;        
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
               case 5:
                   System.out.println("------METODO HEAPSORT------");
                   System.out.println("");
                   break;
               case 6:
                   System.out.println("------METODO SELECCION------");
                   System.out.println("");
                   break;
               case 7:
                   System.out.println("------METODO CUENTA------");
                   System.out.println("");
                   break; 
               case 8:
                   System.out.println("------METODO BINSORT------");
                   System.out.println("");
                   break; 
               case 9:
                   System.out.println("------METODO RADIX------");
                   System.out.println("");
                   break; 
               default:
                   System.err.println("Este codigo no deberia haberse ejecutado");
                   break;
            }
        }
        
        
        public static int [] calculoTiempo(TClasificador clasif, int tipo, int[] vector){
            long inicio = 0;
            long fin = 0;
            long total = 0;
            int cantLlamadas = 0;
            long tiempoMA = 0;
            long tiempoMC = 0;
            int [] res = null;
            int[] elVect = new int[300];
            
            
            inicio = System.nanoTime();
            total = 0;
            cantLlamadas = 0;
            
            //sin cascara
            while (total < 1000000000){ //asegura que lo medido tiene un 1% de presicion: 1segundo = 1000000000 nanoseg              
                cantLlamadas += 1;
                for(int i = 0; i<300; i++){
                    elVect[i]= vector[i];
                }
                res = clasif.clasificar(elVect, tipo, false);
                fin = System.nanoTime();
                total = fin - inicio;
            }
            tiempoMA = total/cantLlamadas;
            System.out.println(tiempoMA);
            
            //con cascara
            inicio = System.nanoTime();
            total = 0;
            cantLlamadas = 0;

            while (total < 1000000000) {                
                cantLlamadas += 1;
                for(int i = 0; i<300; i++){
                    elVect[i]= vector[i];
                }
                clasif.clasificar(elVect, tipo, true);
                fin = System.nanoTime();
                total = fin - inicio;
            }
            tiempoMC = total/cantLlamadas; //tiempo medio con cascara
            System.out.println(tiempoMC);
            System.out.println("\t\t" + (tiempoMA-tiempoMC));
            
            return res;
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

            int[] vectorAleatorio3000 = Arrays.copyOfRange(vectorAleatorio, 0,2999); 
            int[] vectorAscendente3000 = Arrays.copyOfRange(vectorAscendente, 0,2999);
            int[] vectorDescendente3000 = Arrays.copyOfRange(vectorDescendente, 0,2999);

            int[] vectorAleatorio30000 = Arrays.copyOfRange(vectorAleatorio, 0,29999); 
            int[] vectorAscendente30000 = Arrays.copyOfRange(vectorAscendente, 0,29999);
            int[] vectorDescendente30000 = Arrays.copyOfRange(vectorDescendente, 0,29999);

            long t1 =0, t2 =0;


            int[] vector = {2,4,6,8,5,16,1,23};
            
            int[] res = clasif.clasificar(vectorAleatorio3000.clone(),4,false);
            
            for(int i=0;i<res.length;i++){
                System.out.println(res[i]);
            }
            //System.out.println(clasif.estaOrdenado(res));

            
            
//            for (int i=1;i<7;i++){
//                t1 = 0;
//                t2 = 0;  
//
//                imprimirNombreMetodo(i);
//
//                System.out.println("Vector Aleatorio 300 elementos");
//                t1 = System.nanoTime();
//
//
//                int[] res1 = clasif.clasificar(vectorAleatorio300.clone(),i,false);
//                System.out.println("Esta ordenado: " + clasif.estaOrdenado(res1));
//
//                t2 = System.nanoTime();
//                System.out.println("Tiempo en nano segundos " + (t2-t1));
//                System.out.println("");
//
//                t1 = 0;
//                t2 = 0;
//
//                System.out.println("Vector Aleatorio 3000 elementos");
//                t1 = System.nanoTime();
//
//
//                int[] res11 = clasif.clasificar(vectorAleatorio3000.clone(),i,false);
//                System.out.println("Esta ordenado: " + clasif.estaOrdenado(res11));
//
//                t2 = System.nanoTime();
//                System.out.println("Tiempo en nano segundos " + (t2-t1));
//                System.out.println("");
//
//                t1 = 0;
//                t2 = 0;
//
//                System.out.println("Vector Aleatorio 30000 elementos");
//                t1 = System.nanoTime();
//
//
//                int[] res111 = clasif.clasificar(vectorAleatorio30000.clone(),i,false);
//                System.out.println("Esta ordenado: " + clasif.estaOrdenado(res111));
//
//                t2 = System.nanoTime();
//                System.out.println("Tiempo en nano segundos " + (t2-t1));
//                System.out.println("");
//
//                t1 = 0;
//                t2 = 0;
//
//                System.out.println("Vector Ascendente 300 elementos");
//                t1 = System.nanoTime();
//
//                int[] res2 = clasif.clasificar(vectorAscendente300.clone(),i,false);
//                System.out.println("Esta ordenado: " + clasif.estaOrdenado(res2));
//
//                t2 = System.nanoTime();
//
//                System.out.println("Tiempo en nano segundos " + (t2-t1));
//                System.out.println("");
//
//                t1 = 0;
//                t2 = 0;
//
//                System.out.println("Vector Ascendente 3000 elementos");
//                t1 = System.nanoTime();
//
//                int[] res22 = clasif.clasificar(vectorAscendente3000.clone(),i,false);
//                System.out.println("Esta ordenado: " + clasif.estaOrdenado(res22));
//
//                t2 = System.nanoTime();
//
//                System.out.println("Tiempo en nano segundos " + (t2-t1));
//                System.out.println("");
//
//                t1 = 0;
//                t2 = 0;
//
//                System.out.println("Vector Ascendente 30000 elementos");
//                t1 = System.nanoTime();
//
//                int[] res222 = clasif.clasificar(vectorAscendente30000.clone(),i,false);
//                System.out.println("Esta ordenado: " + clasif.estaOrdenado(res222));
//
//                t2 = System.nanoTime();
//
//                System.out.println("Tiempo en nano segundos " + (t2-t1));
//                System.out.println("");
//
//                t1 = 0;
//                t2 = 0;
//
//
//                System.out.println("Vector Descendente 300 elementos");
//                t1 = System.nanoTime();
//
//                int[] res3 = clasif.clasificar(vectorDescendente300.clone(),i,false);
//                System.out.println("Esta ordenado: " + clasif.estaOrdenado(res3));
//
//                t2 = System.nanoTime();
//                System.out.println("Tiempo en nano segundos " + (t2-t1));
//                System.out.println("");         
//
//
//                t1 = 0;
//                t2 = 0;
//
//                System.out.println("Vector Descendente 3000 elementos");
//                t1 = System.nanoTime();
//
//                int[] res33 = clasif.clasificar(vectorDescendente3000.clone(),i,false);
//                System.out.println("Esta ordenado: " + clasif.estaOrdenado(res33));
//
//                t2 = System.nanoTime();
//                System.out.println("Tiempo en nano segundos " + (t2-t1));
//                System.out.println("");         
//
//
//                t1 = 0;
//                t2 = 0;
//
//                System.out.println("Vector Descendente 300 elementos");
//                t1 = System.nanoTime();
//
//                int[] res333 = clasif.clasificar(vectorDescendente30000.clone(),i,false);
//                System.out.println("Esta ordenado: " + clasif.estaOrdenado(res333));
//
//                t2 = System.nanoTime();
//                System.out.println("Tiempo en nano segundos " + (t2-t1));
//                System.out.println("");         
//            }
       
        }


}
