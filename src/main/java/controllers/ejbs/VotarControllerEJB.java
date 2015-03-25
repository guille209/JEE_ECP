package controllers.ejbs;

import java.util.List;

import controllers.interfaces.VotarController;
import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;
import models.entities.Voto;

public class VotarControllerEJB implements VotarController {

	private VotoDao votoDao;
	private TemaDao temaDao;

	public VotarControllerEJB() {
		DaoFactory.setFactory(new DaoJpaFactory());
		votoDao = DaoFactory.getFactory().getVotoDao();
		temaDao = DaoFactory.getFactory().getTemaDao();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controllers.ejbs.VotarController#addVoto(models.entities.Voto)
	 */
	@Override
	public void addVoto(Voto voto) {
		// TODO Auto-generated method stub
		votoDao.create(voto);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controllers.ejbs.VotarController#getTemas()
	 */
	@Override
	public List<Tema> getTemas() {
		return temaDao.findAll();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controllers.ejbs.VotarController#getTema(java.lang.String)
	 */
	@Override
	public Tema getTema(String nombreTema) {
		return temaDao.getTema(nombreTema);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controllers.ejbs.VotarController#getTema(java.lang.Integer)
	 */
	@Override
	public Tema getTema(Integer id) {
		return temaDao.read(id);
	}

}
