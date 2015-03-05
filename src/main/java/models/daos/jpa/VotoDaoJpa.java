package models.daos.jpa;

import models.daos.VotoDao;
import models.entities.*;
public class VotoDaoJpa extends GenericDaoJpa<Voto, Integer> implements VotoDao {

	public VotoDaoJpa(){
		super(Voto.class);
	}
}
