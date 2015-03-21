package controllers.ejbs;

import java.util.HashMap;
import java.util.Map;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;
import models.entities.Tema;

public class VerVotacionesController {

	private VotoDao votoDao;
	private TemaDao temaDao;

	public VerVotacionesController() {
		votoDao = DaoFactory.getFactory().getVotoDao();
		temaDao = DaoFactory.getFactory().getTemaDao();

	}

	/**
	 * 
	 * @return un mapa formado por el nombre del tema y su numero de votos
	 *         asociado
	 */
	public Map<String, Double> getValoracionMedia() {

		return votoDao.getValoracionMedia();
	}

	public Map<String, Integer> getNumeroVotos() {
		Map<String, Integer> numeroVotosPorTema = new HashMap<String, Integer>();

		for (Tema tema : temaDao.findAll()) {
			numeroVotosPorTema.put(tema.getNombre(),
					votoDao.getNumeroVotos(tema));
		}
		return numeroVotosPorTema;
	}
}
