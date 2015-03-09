package models.daos.jpa;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import models.entities.Voto;
import models.utils.NivelEstudios;
import org.junit.Before;
import org.junit.Test;

public class VotoDaoTest {
	private VotoDaoJpa votoDao;
	private List<Voto> votosParaMeter = new ArrayList<Voto>();
	private String ip = "192.168.1.1";
	private Voto voto1;

	@Before
	public void init() {
		votosParaMeter.clear();
		votoDao = new VotoDaoJpa();
		voto1 = new Voto(new Integer(5), ip, NivelEstudios.ALTO);
		votosParaMeter.add(voto1);
	}

	@Test
	public void testCreate() {
		votosParaMeter.add(new Voto(new Integer(7), ip, NivelEstudios.ALTO));
		for (Voto voto : votosParaMeter)
			votoDao.create(voto);
		List<Voto> votos = votoDao.findByIp(ip);
		assertArrayEquals(votos.toArray(), votosParaMeter.toArray());
	}

	@Test
	public void testRead() {
		assertEquals(votoDao.read(1), voto1);
	}

	@Test
	public void testUpdate() {
		int nuevaValoracion = 2;
		Voto voto = votoDao.read(1);
		voto.setValoracion(nuevaValoracion);
		votoDao.update(voto);
		Voto votoCambiado = votoDao.read(1);
		assertEquals(new Integer(votoCambiado.getValoracion()), new Integer(
				nuevaValoracion));
	}

	@Test
	public void testDeleteById() {
		votoDao.deleteById(1);
		assertNull(votoDao.read(1));
	}

	@Test
	public void testFindAll() {
		List<Voto> listaVotos = votoDao.findAll();
		assertEquals(listaVotos, votosParaMeter);

	}

}
