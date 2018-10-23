
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class TVertice implements IVertice{

    private Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private Object datos;

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

    @Override
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
    public void bpf(Collection<TVertice> visitados) {
        this.setVisitado(true);
        visitados.add(this);        
        for(TAdyacencia adyacencia : adyacentes){
            if(!adyacencia.getDestino().getVisitado()){
                adyacencia.getDestino().bpf(visitados);
            }
        }
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        this.setVisitado(true);
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.setVisitado(true);
        for (TAdyacencia adyacente : adyacentes) {
            TVertice destino = adyacente.getDestino();
            if (!destino.visitado) {
                camino.agregarAdyacencia(adyacente);
                if (destino.tieneCiclo(camino)){
                   return true;
                }
            } else {
                if (camino.existeEtiqueta(destino.getEtiqueta())) {
                   return true;
                }
            }
        }
        return false;
    }

   public void bea(Collection<TVertice> visitados) {
        Queue<TVertice> c = new LinkedList();
        visitados.clear();
        visitados.add(this);
        this.setVisitado(true);
        c.add(this);
        TVertice x = null;
        while (!c.isEmpty()) {
            x = c.remove();
            for (TAdyacencia ady : x.adyacentes) {
                
                if (!ady.getDestino().getVisitado()) {
                    ady.getDestino().setVisitado(visitado);
                    c.add(ady.getDestino());
                    visitados.add(ady.getDestino());
                }
            }
        }
    }

    
    public String toString(){
        return this.etiqueta.toString();
    }
   

}
