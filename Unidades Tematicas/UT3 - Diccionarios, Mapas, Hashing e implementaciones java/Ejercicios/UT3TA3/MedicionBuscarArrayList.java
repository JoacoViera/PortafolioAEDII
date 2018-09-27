package UT3TA3;
import java.util.ArrayList;

/**
 *
 * @author JoaquinCubas
 */
class MedicionBuscarArrayList extends Medible {

    private ArrayList arrayList;

    public MedicionBuscarArrayList(ArrayList linkedList) {
        this.arrayList = linkedList;
    }
    
    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for(int i = 0; i < repeticion; i++){
            for(String palabra : palabras){
                arrayList.contains(palabra);
            }
        }
    }

    @Override
    public Object getObjetoAMedirMemoria() {
        return this.arrayList;
    }
}
