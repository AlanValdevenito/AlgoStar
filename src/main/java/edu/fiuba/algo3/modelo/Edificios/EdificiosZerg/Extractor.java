package edu.fiuba.algo3.modelo.Edificios.EdificiosZerg;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.Excepciones.CantidadMaximaDeZanganosEnExtractorException;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Recursos.Gas.RefineriaDeGas;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano;

import java.util.ArrayList;

public class Extractor extends EdificioZerg implements RefineriaDeGas {

	private final int POBLACION = 0;
	private final int COSTO_MINERAL = 100;
	private final int COSTO_GAS = 0;
	
	private int cantidadExtraible;
	private Recursos recursosJugador;
    private int cantidadMaximaDeZanganos;
    private Volcan volcan;
    private ArrayList<Zangano> zanganos;
    
    public Extractor(Volcan unVolcan, Recursos recursosJugador, Ubicacion unaUbicacion, Jugador unJugador){
    	super(new Tiempo(-6), new Vida(750), unaUbicacion, unJugador);
    	
    	recursosJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
    	
    	this.cantidadExtraible = 10;
    	this.recursosJugador = recursosJugador;
    	this.cantidadMaximaDeZanganos = 3;
    	this.volcan = unVolcan;
        this.zanganos = new ArrayList<Zangano>();

		unVolcan.construirRefineriaDeGas(this);
    }

	@Override
	public int obtenerPoblacion() {
		return POBLACION;
	}
    
    @Override
    public void ejecutaOperable() {
    	this.recursosJugador.guardar(this.extraerGasDe(this.volcan), 0);
    }
    
    public int contarZanganos() {
    	return (this.zanganos.size());
    }

    public void guardarZangano(Zangano unZangano) {
    	
    	if(this.contarZanganos() == this.cantidadMaximaDeZanganos) {
    		throw new CantidadMaximaDeZanganosEnExtractorException();
    	}
    	this.zanganos.add(unZangano);
    	
    }

    @Override
	public int extraerGasDe(Volcan unVolcan) {
		return (unVolcan.extraerGas(this.cantidadExtraible * this.contarZanganos()));
	}
	
	@Override
    public int obtenerGas() {
		return this.recursosJugador.obtenerGas();
    }

	@Override
	public boolean tieneRefineria() {
		return true;
	}

	@Override
	public boolean compararSuperficie(String unTipoDeSuperficie) {
		return this.superficie.compararTipos(unTipoDeSuperficie);
	}
}