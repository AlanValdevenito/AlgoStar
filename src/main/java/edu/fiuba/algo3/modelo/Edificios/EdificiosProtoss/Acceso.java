package edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;

public class Acceso extends EdificioProtoss {

	private final int COSTO_MINERAL = 150;
	private final int COSTO_GAS = 0;
	
	private ArrayList<Unidad> zealots;
	private ArrayList<Unidad> dragones;

	public Acceso(Recursos recursosJugador, Ubicacion unaUbicacion) {
		super(new Tiempo(-8),new Vida(500), new Escudo(500), unaUbicacion);
		this.zealots = new ArrayList<Unidad>();
		this.dragones = new ArrayList<Unidad>();

		recursosJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
	}
	
    public Acceso(Recursos recursosJugador) {
		super(new Tiempo(-8),new Vida(500), new Escudo(500), new Ubicacion());
		this.zealots = new ArrayList<Unidad>();
		this.dragones = new ArrayList<Unidad>();
		
		recursosJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
	}

	@Override
	public void ejecutaOperable() {
		// TODO Auto-generated method stub
		
	}
	
	public void transportarZealot() {
		/* aca tiene que ir la verificacion de requisitos*/
		//this.zealots.add(new Unidad(new Zealot()));
	}
	
	public void transportarDragon() {
		/* aca tiene que ir la verificacion de requisitos*/
		//this.dragones.add(new Unidad(new Dragon()));
	}
	
	public ArrayList<Unidad> obtenerZealots(){
		return (this.zealots);
	}
	
	public ArrayList<Unidad> obtenerDragones(){
		return (this.dragones);
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
