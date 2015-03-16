package controllers;

import java.util.List;

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

	public void addTema(Tema tema) {
		temaDao.create(tema);
	}

	public void removeTema(String nombreTema) {
		Tema temaBorrar = temaDao.getTema(nombreTema);
		votoDao.eliminarVotos(temaBorrar);
		temaDao.deleteById(temaBorrar.getId());		

	}

	public List<Tema> getTemas() {
		return temaDao.findAll();
		
	}
	
	public Tema getTema(String nombreTema){
		return temaDao.getTema(nombreTema);
	}
}
