package UT6_TA1;

/**
 *
 * @author Alvarito
 */
public class TClasificador {
        public static final int METODO_CLASIFICACION_INSERCION = 1;
        public static final int METODO_CLASIFICACION_SHELL = 2;
        public static final int METODO_CLASIFICACION_BURBUJA = 3;
        public static final int METODO_CLASIFICACION_QUICKSORT = 4;    
    
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
	private int[] ordenarPorShell(int[] datosParaClasificar) {
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
        

	private int[] ordenarPorBurbuja(int[] datosParaClasificar) {
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
                
     
        
 
	
	private int quicksort(int[] entrada, int izquierda, int derecha) {
		int i = izquierda;
		int j = derecha;
                int contador=0;

		int posicionPivote = encuentraPivote(izquierda,derecha,entrada); 
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
        
        private int encuentraPivote(int izquierda, int derecha, int[] entrada) {
            if(entrada[izquierda] > entrada[izquierda+1]){
                return izquierda;
            }else{
                return izquierda+1;     
            }
        }
        
        private int encuentraPivote2(int izquierda, int derecha, int[] entrada){
            int min = entrada[izquierda];
            int max = entrada[izquierda];
            for(int i = izquierda+1; i< entrada.length; i++){
                if(entrada[i]< min)
                    min=entrada[i];
                if(entrada[i]>max)
                    max=entrada[i];
            }
            return (max-min)/2;
        }
        
        private int encuentraPivote3(int izquierda, int derecha, int[] entrada){
            return (int) Math.floor((derecha-izquierda)/2);
        }
        
        
        private boolean estaOrdenado(int[] vector){
            boolean resultado = true;
            for (int i = 0; i <vector.length-1; i++){
                if(vector[i+1]<=vector[i])
                    return false;
            }
            return resultado;
        }
        
        public static void main(String args[]) {
            GeneradorDatosGenericos generador = new GeneradorDatosGenericos();
            TClasificador clasif = new TClasificador();
            
            int[] list1 = generador.generarDatosAleatorios();
            int[] list2 = generador.generarDatosAscendentes();
            int[] list3 = generador.generarDatosDescendentes();
            
            
//            int[] al1 = new int[10000];
//            int[] al2 = new int[10000];
//            int[] al3 = new int[10000];
//            int[] al4 = new int[10000];
//            for(int i = 0; i<10000; i++){
//                al1[i]= list1[i];
//                al2[i]= list1[i];
//                al3[i]= list1[i];
//                al4[i]= list1[i];
//            }

            
            System.out.println("===ALEATORIO===");
//            System.out.println("\tInsercion");
//            int [] res = calculoTiempo(clasif, 1, list1);
//            System.out.println("Esta ordenado: "+ clasif.estaOrdenado(res));
//            
//            System.out.println("\tShell");
//            calculoTiempo(clasif, 2, list1);
//        
//            System.out.println("\tBurbuja");
//            calculoTiempo(clasif, 3, list1);
            
            System.out.println("\tQuicksort");
            calculoTiempo(clasif, 4, list1);
            int [] res = clasif.ordenarPorQuickSort(list1);
            System.out.println("Esta ordenado: "+ clasif.estaOrdenado(res));
            
            int [] prof = new int[1];
            clasif.ordenarPorQuickSortConProfundiad(list1, prof);
            System.out.println("Profundidad: "+ prof[0]);
//            
//            
        
            
            System.out.println("===ASCENDENTE===");
//            System.out.println("\tInsercion");
//            calculoTiempo(clasif, 1, list2);
//            
//            System.out.println("\tShell");
//            calculoTiempo(clasif, 2, list2);
//        
//            System.out.println("\tBurbuja");
//            calculoTiempo(clasif, 3, list2);
            
            System.out.println("\tQuicksort");
            calculoTiempo(clasif, 4, list2);
            int [] res2 = clasif.ordenarPorQuickSort(list2);
            System.out.println("Esta ordenado: "+ clasif.estaOrdenado(res2));
            
            int [] prof2 = new int[1];
            clasif.ordenarPorQuickSortConProfundiad(list2, prof2);
            System.out.println("Profundidad: "+ prof2[0]);
//            
//           
            
            
            System.out.println("===DESCENDENTE===");
//            System.out.println("\tInsercion");
//            calculoTiempo(clasif, 1, list3);
//            
//            System.out.println("\tShell");
//            calculoTiempo(clasif, 2, list3);
//        
//            System.out.println("\tBurbuja");
//            calculoTiempo(clasif, 3, list3);
            
            System.out.println("\tQuicksort");
            calculoTiempo(clasif, 4, list3);
            int [] res3 = clasif.ordenarPorQuickSort(list3);
            System.out.println("Esta ordenado: "+ clasif.estaOrdenado(res3));
            
            int [] prof3 = new int[1];
            clasif.ordenarPorQuickSortConProfundiad(list3, prof3);
            System.out.println("Profundidad: "+ prof3[0]);
//            
//           
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

}
