package edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss;


import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;

public class Pilon extends EdificioProtoss {

	public final int ALTO_RADIO = 21;
	public final int ANCHO_RADIO = 25;

	private final int POBLACION = 5;
	private final int COSTO_MINERAL = 100;
	private final int COSTO_GAS = 0;
	
	private int radio;
	private ArrayList<EdificioProtoss> edificios;
	/* ver si el pilon tiene una referencia a los edificios o si el jugadores le pasa a todos los pilones 
	 * que tenga los edificios que tiene*/

    public Pilon(Ubicacion unaUbicacion, Jugador unJugador) {
    	super(new Tiempo(-5), new Vida(300), new Escudo(300), unaUbicacion, unJugador,"Pilon");
		this.ubicacion.setPerimetro(ALTO_RADIO, ANCHO_RADIO);
    	
    	unJugador.utilizar(COSTO_GAS, COSTO_MINERAL);

    	this.edificios = new ArrayList<>();
        this.radio = 3;
    }

	@Override
	public ArrayList<Unidad> devolverLarvas() {
		return new ArrayList<Unidad>();
	}

	@Override
	public int obtenerPoblacion() {
		return POBLACION;
	}
    
    @Override
    public void ejecutaOperable() {
    	this.energizarEdificios();
    }
    
    public void energizarEdificios() {
    	for(EdificioProtoss actual: this.edificios) {
    		if(this.ubicacion.distanciaCon(actual.ubicacion()) <= this.radio) {
    			actual.energizar();
    		}
    		
    	}
    }
	
	public boolean laUbicacionEstaEnElRangoDeConstruccion(Ubicacion unaUbicacion) {
		return (unaUbicacion.distanciaCon(this.ubicacion) <= this.radio);
	}

	@Override
	public boolean compararSuperficie(String otraSuperficie) {
		return (this.superficie.compararTipos(otraSuperficie));
	}

	@Override
	public void serRevelado() {
		// No hace nada.
	}
	
	public void agregarEdificio(EdificioProtoss unEdificio) {
		this.edificios.add(unEdificio);
	}
}