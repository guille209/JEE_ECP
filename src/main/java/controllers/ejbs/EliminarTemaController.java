package controllers.ejbs;

import java.util.List;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;
import models.entities.Tema;

public class EliminarTemaController {

	private TemaDao temaDao;
	private VotoDao votoDao;

	public EliminarTemaController() {
		temaDao = DaoFactory.getFactory().getTemaDao();
		votoDao = DaoFactory.getFactory().getVotoDao();

	}

	public void removeTema(int idTema) {
		Tema temaBorrar = temaDao.read(idTema);
		votoDao.eliminarVotos(temaBorrar);
		temaDao.deleteById(temaBorrar.getId());

	}

	public boolean identificar(int identificador) {
		// TODO Auto-generated method stub
		return identificador == 666;
	}

	public List<Tema> getTemas() {
		return temaDao.findAll();

	}

	public Tema getTema(String nombreTema) {
		return temaDao.getTema(nombreTema);
	}

	public Tema getTema(Integer id) {
		return temaDao.read(id);
	}
}
