package models.daos.jpa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudios;

import org.junit.Before;
import org.junit.Test;

public class TemaDaoTest {
	private TemaDaoJpa temaDao;
	private List<Tema> temasParaMeter = new ArrayList<Tema>();
	private String ip = "192.168.1.1";
	private List<Voto> votos;
	private Tema tema;

	@Before
	public void init() {
		temasParaMeter.clear();
		temaDao = new TemaDaoJpa();
		votos = new ArrayList<Voto>();
		votos.add(new Voto(new Integer(1), ip, NivelEstudios.MEDIO,tema));
		votos.add(new Voto(new Integer(2), ip, NivelEstudios.ALTO,tema));
		votos.add(new Voto(new Integer(3), ip, NivelEstudios.BAJO,tema));
		tema = new Tema("Actualidad", "¿Blablabla?");
		temasParaMeter.add(tema);
	}

	@Test
	public void testCreate() {
		votos.add(new Voto(new Integer(1), ip, NivelEstudios.MEDIO,tema));
		Tema tema2 = new Tema("Deportes", "¿Blobloblo?");
		Tema temaBD = temaDao.findById(tema2.getId());
		assertEquals(temaBD, tema2);
	}

	@Test
	public void testRead() {
		assertEquals(temaDao.read(tema.getId()), tema.getId());
	}

	@Test
	public void testUpdate() {
		String nuevaPregunta = "¿Nueva pregunta?";
		Tema temaBD = temaDao.read(tema.getId());
		temaBD.setPregunta(nuevaPregunta);
		temaDao.update(temaBD);
		Tema temaCambiado = temaDao.read(temaBD.getId());
		assertEquals(temaCambiado.getPregunta(), nuevaPregunta);
	}

	@Test
	public void testDeleteById() {
		temaDao.deleteById(tema.getId());
		assertNull(temaDao.read(tema.getId()));
	}

	@Test
	public void testFindAll() {
		List<Tema> listaTemas = temaDao.findAll();
		assertEquals(listaTemas, temasParaMeter);
		
	}

}
