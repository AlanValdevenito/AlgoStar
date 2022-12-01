package edu.fiuba.algo3.modelo.Edificios.EdificiosZerg;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Hidralisco;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

public class Guarida extends EdificioZerg {

	private final int POBLACION = 0;
	private final int COSTO_MINERAL = 200;
	private final int COSTO_GAS = 100;
	
	private ArrayList<Unidad> larvas;
    private ArrayList<Unidad> hidraliscos;
    
	
    public Guarida(Recursos recursosJugador, Ubicacion unaUbicacion, Jugador unJugador){
        super(new Tiempo(-12), new Vida(1250), unaUbicacion, unJugador);
        
        recursosJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
        
        this.larvas = new ArrayList<Unidad>();
        this.hidraliscos = new ArrayList<Unidad>();
    }

	@Override
	public int obtenerPoblacion() {
		return POBLACION;
	}

	@Override
	public void ejecutaOperable() {
		this.crearHidraliscos();
	}
	
	public void crearHidraliscos() {
		/* el ciclo deberia tener algo como && this.cumpleConLosRequisitos(unosRequisitos)*/
		while(this.contarLarvas() != 0) {
			Unidad actual = larvas.get(0);
			actual.setComportamientoEstado(new Hidralisco());
			hidraliscos.add(actual);
			larvas.remove(0);
		}
	}
	
	public int contarLarvas() {
		return (this.larvas.size());
	}
    	
	public void recibirLarvas(ArrayList<Unidad> unasLarvas) {
		this.larvas.addAll(unasLarvas);
	}
	
	public ArrayList<Unidad> obtenerHidraliscos(){
		return (this.hidraliscos);
	}

	@Override
	public boolean compararSuperficie(String unTipoDeSuperficie) {
		return this.superficie.compararTipos(unTipoDeSuperficie);
	}
}