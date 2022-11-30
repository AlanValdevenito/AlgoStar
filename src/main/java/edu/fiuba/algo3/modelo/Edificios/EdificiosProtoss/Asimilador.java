package edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Recursos.Gas.RefineriaDeGas;

public class Asimilador extends EdificioProtoss implements RefineriaDeGas {

	private final int COSTO_MINERAL = 100;
	private final int COSTO_GAS = 0;
	
    private int cantidadExtraible;
    private Recursos recursosJugador;
    private Volcan volcan;
    
    public Asimilador(Volcan unVolcan, Recursos recursosJugador, Ubicacion unaUbicacion) {
    	super(new Tiempo(-6),new Vida(450),new Escudo(450), unaUbicacion);
    	
    	recursosJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
    	
    	this.cantidadExtraible = 20;
    	this.recursosJugador = recursosJugador;
    	this.volcan = unVolcan;
    	
    	unVolcan.construirRefineriaDeGas(this);
    }
    
    @Override
    public void ejecutaOperable() {
    	this.recursosJugador.guardar(this.extraerGasDe(this.volcan), 0);
    }
    
    @Override
	public int extraerGasDe(Volcan unVolcan) {
		return (unVolcan.extraerGas(this.cantidadExtraible));
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
	public void atacar(Atacable unAtacable) {
		// No hace nada
	}

	@Override
	public boolean compararSuperficie(String unTipoDeSuperficie) {
		return this.superficie.compararTipos(unTipoDeSuperficie);
	}
}
