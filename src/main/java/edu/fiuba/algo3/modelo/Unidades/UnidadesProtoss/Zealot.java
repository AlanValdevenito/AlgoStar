package edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Atacante;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Revelable;
import edu.fiuba.algo3.modelo.Ataque;
import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Superficie;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.TipoDeUnidad;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Excepciones.AtacableFueraDeRangoError;

public class Zealot implements TipoDeUnidad, Atacante, Atacable, Revelable {

	public static final int SUMINISTRO_ZEALOT = 2;
	private final int POBLACION = 0;

	private Vida vida;
	private Escudo escudo;
	private Ubicacion ubicacion;
	private Superficie superficie;
	private ArrayList<Ataque> ataques;
	private boolean estaInvisible;
	private int cantidadDeBajas;

	public Zealot(Ubicacion unaUbicacion) {
		this.vida = new Vida(100);
		this.escudo = new Escudo(60);
		this.ubicacion = unaUbicacion;
		this.superficie = new Superficie("Tierra");
		this.ataques = new ArrayList<Ataque>() {{
			add(new Ataque(8, new Superficie("Tierra"), 1));
		}};
		this.estaInvisible = false;
		this.cantidadDeBajas = 3; //Falta implementar, deberia ser 0.
	}

	public Zealot() {
		this.vida = new Vida(100);
		this.escudo = new Escudo(60);
		this.ubicacion = new Ubicacion();
		this.superficie = new Superficie("Tierra");
		this.ataques = new ArrayList<Ataque>() {{
			add(new Ataque(8, new Superficie("Tierra"), 1));
		}};
		this.estaInvisible = false;
		this.cantidadDeBajas = 3; //Falta implementar, deberia ser 0.
	}

	@Override
	public int obtenerPoblacion() {
		return POBLACION;
	}

	@Override
	public void recibirAtaque(int unDanio) {
		if (estaInvisible == false) {
			if (unDanio > this.escudo.restante()) {
				int danioRestante = this.escudo.restante() - unDanio;
				this.vida.recibirDanioPor(danioRestante);
			}
			this.escudo.recibirDanioPor(unDanio);
		}
	}

	@Override
	public Superficie obtenerSuperficie() {
		return this.superficie;
	}

	@Override
	public void atacar(Atacable unAtacable) {

		for (Ataque ataque : ataques) {
			if(! (this.estaEnRangoDeAtaque(unAtacable, ataque))) {
				throw new AtacableFueraDeRangoError();
			}

			ataque.atacarA(unAtacable);
		}
	}

	@Override
	public void recuperarse() {
		this.escudo.recuperarse();
	}

	public boolean estaEnRangoDeAtaque(Atacable unAtacable, Ataque unAtaque) {
		return (this.ubicacion.distanciaCon(unAtacable.ubicacion()) <= unAtaque.rango());
	}

	public void hacerseInvisible() {
		if (cantidadDeBajas >= 3) {
			estaInvisible = true;
		}
	}

	@Override
	public void serRevelado() {
		estaInvisible = false;
	}

	@Override
	public Ubicacion ubicacion() {
		return (this.ubicacion);
	}

	public int vidaRestante() {
		return (this.vida.restante());
	}

	public int escudoRestante() {
		return (this.escudo.restante());
	}

	@Override
	public boolean compararSuperficie(String unTipoDeSuperficie) {
		return this.superficie.compararTipos(unTipoDeSuperficie);
	}

	@Override
	public void evolucionarAGuardian(Unidad unaUnidad) {
		// No hace nada ya que es un mensaje particular que entiende solo Mutalisco.
	}

	@Override
	public void evolucionarADevorador(Unidad unaUnidad) {
		// No hace nada ya que es un mensaje particular que entiende solo Mutalisco.
	}
}
