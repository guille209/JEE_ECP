package controllers.ejbs;

import java.util.List;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;
import models.entities.Voto;

public class VotarController {

	private VotoDao votoDao;
	private TemaDao temaDao;

	public VotarController() {
		DaoFactory.setFactory(new DaoJpaFactory());
		votoDao = DaoFactory.getFactory().getVotoDao();
		temaDao = DaoFactory.getFactory().getTemaDao();
	}

	public void addVoto(Voto voto) {
		// TODO Auto-generated method stub
		votoDao.create(voto);

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
