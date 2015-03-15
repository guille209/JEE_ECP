package controllers;

import java.util.HashMap;
import java.util.Map;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;
import models.entities.Voto;

public class VotoController {

	private VotoDao votoDao;
	private TemaDao temaDao;

	public VotoController() {
		DaoFactory.setFactory(new DaoJpaFactory());
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

	public void addVoto(Voto voto) {
		// TODO Auto-generated method stub
		votoDao.create(voto);
		
	}

}
