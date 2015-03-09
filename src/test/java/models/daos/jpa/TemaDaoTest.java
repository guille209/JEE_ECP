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
	private Tema tema1;

	@Before
	public void init() {
		temasParaMeter.clear();
		temaDao = new TemaDaoJpa();
		votos = new ArrayList<Voto>();
		votos.add(new Voto(new Integer(1), ip, NivelEstudios.MEDIO));
		votos.add(new Voto(new Integer(2), ip, NivelEstudios.ALTO));
		votos.add(new Voto(new Integer(3), ip, NivelEstudios.BAJO));
		tema1 = new Tema("Actualidad", "¿Blablabla?", votos);
		temasParaMeter.add(tema1);
	}

	@Test
	public void testCreate() {
		votos.add(new Voto(new Integer(1), ip, NivelEstudios.MEDIO));
		Tema tema2 = new Tema("Deportes", "¿Blobloblo?", votos);
		Tema temaBD = temaDao.findById(tema2.getId());
		assertEquals(temaBD, tema2);
	}

	@Test
	public void testRead() {
		assertEquals(temaDao.read(tema1.getId()), tema1.getId());
	}

	@Test
	public void testUpdate() {
		String nuevaPregunta = "¿Nueva pregunta?";
		Tema tema = temaDao.read(tema1.getId());
		tema.setPregunta(nuevaPregunta);
		temaDao.update(tema);
		Tema temaCambiado = temaDao.read(tema.getId());
		assertEquals(temaCambiado.getPregunta(), nuevaPregunta);
	}

	@Test
	public void testDeleteById() {
		temaDao.deleteById(tema1.getId());
		assertNull(temaDao.read(tema1.getId()));
	}

	@Test
	public void testFindAll() {
		List<Tema> listaTemas = temaDao.findAll();
		assertEquals(listaTemas, temasParaMeter);
		
	}

}
