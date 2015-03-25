package models.daos;

import java.util.Map;

import models.entities.Tema;
import models.entities.Voto;

public interface VotoDao extends GenericDao<Voto, Integer> {
	/**
	 * 
	 * @param tema
	 *            Devuelve para un tema el numero de votos como entero
	 * @return
	 */
	int getNumeroVotos(Tema tema);

	/**
	 * Devuelve una lista con 3 posiciones, una por cada nivel de estudios, en
	 * cada posicion un double con la valoracion media correspondiente. Si no
	 * hay en BD ningun voto de un nivel de estudios en su posicion se devuelve
	 * un -1
	 * 
	 * @return
	 */
	Map<String, Double> getValoracionMedia();

	/**
	 * 
	 * @param tema
	 *            Elimina los votos asociados a ese tema
	 * @return
	 */
	void eliminarVotos(Tema tema);
}
