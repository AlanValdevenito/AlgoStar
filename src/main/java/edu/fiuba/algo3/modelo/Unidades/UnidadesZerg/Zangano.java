package edu.fiuba.algo3.modelo.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.Recursos.Minerales.Mineral;
import edu.fiuba.algo3.modelo.Recursos.Minerales.Minero;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Minerales.SinNodoMineral;
import edu.fiuba.algo3.modelo.Unidades.TipoDeUnidad;

public class Zangano implements TipoDeUnidad,Minero {

	private int cantidadRecolectableDeMineral;
    private int cantidadRecolectada;
    private Mineral nodo;
    
    public Zangano() {
        this.cantidadRecolectableDeMineral = 10;
        this.cantidadRecolectada = 0;
        this.nodo = new SinNodoMineral();
    }
    
    public void conNodo(NodoMineral unNodo) {
    	this.nodo = unNodo;
    }

	@Override
	public int recolectarMineralDe(Mineral unNodoMineral) {
		return (unNodoMineral.recolectarMineral(cantidadRecolectableDeMineral));
	}

	@Override
	public int obtenerMineral() {
		int recolectado = this.cantidadRecolectada;
		this.cantidadRecolectada = 0;
		return recolectado;
	}

	@Override
	public boolean tieneMinero() {
		// TODO Auto-generated method stub
		return true;
	}

}