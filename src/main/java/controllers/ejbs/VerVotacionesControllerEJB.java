package controllers.ejbs;

import java.util.HashMap;
import java.util.Map;

import controllers.interfaces.VerVotacionesController;
import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;
import models.entities.Tema;

public class VerVotacionesControllerEJB implements VerVotacionesController {

	private VotoDao votoDao;
	private TemaDao temaDao;

	public VerVotacionesControllerEJB() {
		votoDao = DaoFactory.getFactory().getVotoDao();
		temaDao = DaoFactory.getFactory().getTemaDao();

	}

	/* (non-Javadoc)
	 * @see controllers.ejbs.VerVotacionesController#getValoracionMedia()
	 */
	@Override
	public Map<String, Double> getValoracionMedia() {

		return votoDao.getValoracionMedia();
	}

	/* (non-Javadoc)
	 * @see controllers.ejbs.VerVotacionesController#getNumeroVotos()
	 */
	@Override
	public Map<String, Integer> getNumeroVotos() {
		Map<String, Integer> numeroVotosPorTema = new HashMap<String, Integer>();

		for (Tema tema : temaDao.findAll()) {
			numeroVotosPorTema.put(tema.getNombre(),
					votoDao.getNumeroVotos(tema));
		}
		return numeroVotosPorTema;
	}
}
