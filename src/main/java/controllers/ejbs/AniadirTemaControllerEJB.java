package controllers.ejbs;

import controllers.interfaces.AniadirTemaController;
import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.entities.Tema;

public class AniadirTemaControllerEJB implements AniadirTemaController {

	private TemaDao temaDao;

	public AniadirTemaControllerEJB() {
		temaDao = DaoFactory.getFactory().getTemaDao();

	}

	/* (non-Javadoc)
	 * @see controllers.ejbs.AniadirTema#addTema(models.entities.Tema)
	 */
	@Override
	public void addTema(Tema tema) {
		temaDao.create(tema);
	}
}
