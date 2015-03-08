package models.daos.jpa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

import models.entities.Voto;
import models.utils.NivelEstudios;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.junit.Before;
import org.junit.Test;

public class VotoDaoTest {
	private VotoDaoJpa votoDao;

	@Before
	public void init() {
	votoDao = new VotoDaoJpa();
	}

	@Test
	public void testVotoDaoJpa() {
		
	}

	@Test
	public void testCreate() {
		String ip ="192.168.1.1";
		List<Voto>votosParaMeter= new ArrayList<Voto>();
		votosParaMeter.add(new Voto(new Integer(5),ip,NivelEstudios.ALTO));
		votosParaMeter.add(new Voto(new Integer(7),ip,NivelEstudios.ALTO));
		for(Voto voto:votosParaMeter)
			votoDao.create(voto);
		List<Voto>votos = votoDao.findByIp(ip);
		assertArrayEquals(votos.toArray(), votosParaMeter.toArray());		
	}

	@Test
	public void testRead() {
		
	}

	@Test
	public void testUpdate() {
		
		
	}

	@Test
	public void testDeleteById() {
		
	}

	@Test
	public void testFindAll() {
		
	}

}
