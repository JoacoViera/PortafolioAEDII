package UT5TA2;


import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class TVertice implements IVertice{

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private Object datos;
    
    //para punto de articulacion
    private int bp;
    private int bajo;
    
    //para calsificacion de arcos
    private int inicio;
    private int fin;

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
    }

    @Override
    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    @Override
    public boolean getVisitado() {
        return this.visitado;
    }

    @Override
    public TAdyacencia buscarAdyacencia(TVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }


    public Double obtenerCostoAdyacencia(TVertice verticeDestino) {
        TAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, TVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        TAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public TVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }

    

    @Override
    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    @Override
    public Object getDatos() {
        return datos; 
    }

    @Override
    public void bpf(Collection<Comparable> visitados) {
        visitado = true;
        visitados.add(this.etiqueta);
        for (int i = 0; i < adyacentes.size(); i++) {
            if(!adyacentes.get(i).getDestino().getVisitado()){
                adyacentes.get(i).getDestino().bpf(visitados);
            }
        }
    }
    
    @Override
    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        this.setVisitado(true);
        //caminoPrevio.getOtrosVertices().add(this.getEtiqueta());
       // System.out.println(this.getEtiqueta());
        for(TAdyacencia ady: this.getAdyacentes())
        {
            TVertice destino = ady.getDestino();
            if(!destino.getVisitado()){
                if(destino.getEtiqueta().compareTo(etVertDest)==0)
                {
                    TCamino cami = caminoPrevio.copiar();
                    cami.agregarAdyacencia(ady);
                    todosLosCaminos.getCaminos().add(cami);
                }
                else
                {
                    caminoPrevio.agregarAdyacencia(ady);
                    destino.todosLosCaminos(etVertDest, caminoPrevio, todosLosCaminos);
                    caminoPrevio.eliminarAdyacencia(ady);   
                }   
            }
        }
        this.setVisitado(false);
        return todosLosCaminos;
    }
    
    @Override
    public boolean tieneCiclo(TCamino camino) {
        this.setVisitado(true);
        boolean resultado = false;
        for(TAdyacencia ady : this.getAdyacentes())
        {
            if(ady.getDestino().getVisitado()){
                if(camino.existe(ady.getDestino().getEtiqueta())){
                    camino.getOtrosVertices().add(ady.getDestino().getEtiqueta());
                    return true;
                }
                
            }
            else{
                camino.agregarAdyacencia(ady);
                resultado = ady.getDestino().tieneCiclo(camino);
                if(resultado){
                    return resultado;
                }
            }
        }
        return resultado;
    }

    public String bea ( ){
        String tempStr ="";
        Queue<TVertice> cola = new LinkedList<>();
        this.setVisitado(true);
        cola.add(this);
        tempStr += this.getEtiqueta();
        while (!cola.isEmpty()) {            
            TVertice v = cola.poll();
            for (TAdyacencia i : v.adyacentes) {               
                if (! i.getDestino().getVisitado()){
                    i.getDestino().setVisitado(true);
                    cola.add(i.getDestino());
                    tempStr+="->"+i.getDestino().getEtiqueta();
                }
            }            
        }
        return tempStr;     
    }
    
    //bpf vertices para punto de articulacion
     public void bpfVertices(Collection<TVertice> visitados) {
        setVisitado(true);
        visitados.add(this);
        for (TAdyacencia adyacente : adyacentes) {
            TVertice vertAdy = adyacente.getDestino();
            if (!vertAdy.getVisitado()) {
                vertAdy.bpfVertices(visitados);
            }
        }
    }
     
    /**
     * Método para determinar en el componente del vértice cuales son los puntos
     * de articulación
     *
     * @param contador Contador para determinar el número bp del vértice
     * @return Lista con los puntos de articulación de los vértices en el bpf
     * desde este vértice
     */
    public Collection<TVertice> puntosArticulacion(int[] contador) {
        this.setVisitado(true);
        this.bp = contador[0];
        contador[0]++;
        LinkedList<TVertice> lista = new LinkedList<>();
        TVertice destino = null;
        int aux = this.bp;
        int aux2 = 0;
        int hijos = 0;

        for (TAdyacencia ady : this.getAdyacentes()) {
            destino = ady.getDestino();
            if (!destino.getVisitado()) {
                lista.addAll(destino.puntosArticulacion(contador));
                aux2 = Integer.max(aux2, destino.bajo);
                aux = Integer.min(aux, destino.bajo);
                hijos++;
            } else {
                if (destino.bp != (this.bp - 1)) {
                    aux = Integer.min(aux, destino.bp);
                }
            }
        }
        this.bajo = aux;
        //System.out.println("CONTROL " + this.getEtiqueta().toString() + " " + Integer.toString(bp) + " " + Integer.toString(bajo) + " " + Integer.toString(hijos));
        if (((aux2 >= this.bp) && (this.bp != 0)) || ((this.bp == 0) && (hijos > 1))) {
            lista.add(this);
        }
        return lista;
    }
    
    //clasificacion arcos gnd
     public Collection<TArista> clasificacionArcosND(int[] contador, LinkedList<TVertice> vertices) {
        this.setVisitado(true);
        this.inicio = contador[0];
        contador[0]++;
        LinkedList<TArista> lista = new LinkedList<>();
        TVertice vertAdy = null;
        vertices.add(this);
        
        for (TAdyacencia adyacente : this.getAdyacentes()) {
            vertAdy = adyacente.getDestino();
            if (!vertAdy.getVisitado()) {
                lista.addAll(vertAdy.clasificacionArcosND(contador, vertices));
                lista.add(new TArista(this.getEtiqueta(), vertAdy.getEtiqueta(), adyacente.getCosto(), "Arco de arbol"));
            } else {
                if (vertAdy.inicio != (this.inicio - 1)) {
                    lista.add(new TArista(this.getEtiqueta(), vertAdy.getEtiqueta(), adyacente.getCosto(), "Arco de retroceso"));
                }
            }
        }

        return lista;
    }


}
