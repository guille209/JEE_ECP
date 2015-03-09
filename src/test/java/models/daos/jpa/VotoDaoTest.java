package models.daos.jpa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudios;

import org.junit.Before;
import org.junit.Test;

public class VotoDaoTest {
	private VotoDaoJpa votoDao;
	private List<Voto> votosParaMeter;
	private String ip = "192.168.1.1";
	private Voto voto1;
	private Tema tema;

	@Before
	public void init() {
		votosParaMeter = new ArrayList<Voto>();
		votoDao = new VotoDaoJpa();
		tema = new Tema("nombre","pregunta");
		voto1 = new Voto(new Integer(5), ip, NivelEstudios.ALTO,tema);
		votosParaMeter.add(voto1);
	}

	@Test
	public void testCreate() {
		Voto voto2 = new Voto(new Integer(6),ip, NivelEstudios.ALTO,tema);
		votoDao.create(voto2);
		Voto votoBD = votoDao.findById(voto2.getId());
		assertEquals(votoBD, voto2);
	}

	@Test
	public void testRead() {
		assertEquals(votoDao.read(voto1.getId()), voto1.getId());
	}

	@Test
	public void testUpdate() {
		int nuevaValoracion = 2;
		Voto voto = votoDao.read(voto1.getId());
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
