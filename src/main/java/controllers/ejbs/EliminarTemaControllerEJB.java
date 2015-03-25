package controllers.ejbs;

import java.util.List;

import controllers.interfaces.EliminarTemaController;
import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;
import models.entities.Tema;

public class EliminarTemaControllerEJB implements EliminarTemaController {

	private TemaDao temaDao;
	private VotoDao votoDao;

	public EliminarTemaControllerEJB() {
		temaDao = DaoFactory.getFactory().getTemaDao();
		votoDao = DaoFactory.getFactory().getVotoDao();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controllers.ejbs.EliminarTemaController#removeTema(int)
	 */
	@Override
	public void removeTema(int idTema) {
		Tema temaBorrar = temaDao.read(idTema);
		votoDao.eliminarVotos(temaBorrar);
		temaDao.deleteById(temaBorrar.getId());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controllers.ejbs.EliminarTemaController#identificar(int)
	 */
	@Override
	public boolean identificar(int identificador) {
		// TODO Auto-generated method stub
		return identificador == 666;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controllers.ejbs.EliminarTemaController#getTemas()
	 */
	@Override
	public List<Tema> getTemas() {
		return temaDao.findAll();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controllers.ejbs.EliminarTemaController#getTema(java.lang.String)
	 */
	@Override
	public Tema getTema(String nombreTema) {
		return temaDao.getTema(nombreTema);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controllers.ejbs.EliminarTemaController#getTema(java.lang.Integer)
	 */
	@Override
	public Tema getTema(Integer id) {
		return temaDao.read(id);
	}
}
