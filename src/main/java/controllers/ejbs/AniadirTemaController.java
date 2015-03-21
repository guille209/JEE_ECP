package controllers.ejbs;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.entities.Tema;

public class AniadirTemaController {

	private TemaDao temaDao;

	public AniadirTemaController() {
		temaDao = DaoFactory.getFactory().getTemaDao();

	}

	public void addTema(Tema tema) {
		temaDao.create(tema);
	}
}
