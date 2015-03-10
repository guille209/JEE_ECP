package models.daos.jdbc;

import java.util.List;

import models.daos.TemaDao;
import models.entities.Tema;

public class TemaDaoJdbc extends GenericDaoJdbc<Tema, Integer> implements
		TemaDao {

	public TemaDaoJdbc() {
		super(Tema.class);
	}

}
