package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.ValorInvalidoDeDanioError;
import edu.fiuba.algo3.modelo.Excepciones.ValorInvalidoParaVidaError;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Edificios.Edificio;

public class Vida {

    private int vidaMax;
    private int vidaRestante;

    public Vida(int unaVida) {
    	if(unaVida <= 0) {
    		throw new ValorInvalidoParaVidaError();
    	}
        this.vidaMax = unaVida;
        this.vidaRestante = unaVida;
    }

	public void recibirDanioPor(int unaCantidad) {
		if(unaCantidad < 0) {
			throw new ValorInvalidoDeDanioError();
		}
		if(this.vidaRestante >= unaCantidad) {
			this.vidaRestante -= unaCantidad;
		}
		else if(this.vidaRestante < unaCantidad){
			this.vidaRestante = 0;
		}
	}

	public void recibirDanioPor(int unaCantidad, Unidad unidadAtacante, Unidad unidadAtacada, Jugador unJugador) {
		if(unaCantidad < 0) {
			throw new ValorInvalidoDeDanioError();
		}
		if(this.vidaRestante > unaCantidad) {
			this.vidaRestante -= unaCantidad;
		}
		else if(this.vidaRestante <= unaCantidad){
			this.vidaRestante = 0;
			unJugador.eliminarUnidad(unidadAtacada);
			unidadAtacante.contarBaja();
		}
	}
    
    public void recibirDanioPor(int unaCantidad, Unidad unidadAtacante, Edificio edificioAtacado, Jugador unJugador) {
    	if(unaCantidad < 0) {
    		throw new ValorInvalidoDeDanioError();
    	}
    	if(this.vidaRestante > unaCantidad) {
    		this.vidaRestante -= unaCantidad;
    	}
    	else if(this.vidaRestante <= unaCantidad){
    		this.vidaRestante = 0;
			unJugador.eliminarEdificio(edificioAtacado);
    	}
    }
    
    public int restante() {
    	return this.vidaRestante;
    }
    
    public void recuperarse() {
    	if(this.vidaRestante + this.recuperacion() <= this.vidaMax) {
    		this.vidaRestante += this.recuperacion();
    	}
    	else if(this.vidaRestante + this.recuperacion() > this.vidaMax) {
    		this.vidaRestante = this.vidaMax;
    	}
    }
    
    private int recuperacion(){
    	return ((int)(this.vidaMax * 0.05));
    }
    
    

}