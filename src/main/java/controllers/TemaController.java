package controllers;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;

public class TemaController {

	private TemaDao temaDao;
	private VotoDao votoDao;

	public TemaController() {
		DaoFactory.setFactory(new DaoJpaFactory());
		temaDao = DaoFactory.getFactory().getTemaDao();
		votoDao = DaoFactory.getFactory().getVotoDao();
	}

	public void aniadirTema(Tema tema) {
		temaDao.create(tema);
	}

	public void eliminarTema(Tema tema) {
		//temaDao.remove(tema);
		votoDao.eliminarVotos(tema);

	}
}
