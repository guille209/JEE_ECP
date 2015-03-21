package controllers.interfaces;

import java.util.Map;

public interface VerVotacionesController {

	/**
	 * 
	 * @return un mapa formado por el nombre del tema y su numero de votos
	 *         asociado
	 */
	public abstract Map<String, Double> getValoracionMedia();

	public abstract Map<String, Integer> getNumeroVotos();

}