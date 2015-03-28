package models.daos.jpa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudios;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TemaDaoTest {
	private TemaDao temaDao;
	private VotoDao votoDao;
	private List<Tema> temasParaMeter;
	private String ip = "192.168.1.1";
	private List<Voto> votos;
	private Tema tema;
	private Tema tema2;

	@BeforeClass
	public static void beforeClass() {

		DaoFactory.setFactory(new DaoJpaFactory());
		// DaoJpaFactory.dropAndCreateTables();
	}

	@Before
	public void init() {

		temaDao = DaoFactory.getFactory().getTemaDao();
		votoDao = DaoFactory.getFactory().getVotoDao();
		temasParaMeter = new ArrayList<Tema>();

		tema = new Tema("Actualidad", "¿Blablabla?");
		votos = new ArrayList<Voto>();
		votos.add(new Voto(new Integer(1), ip, NivelEstudios.MEDIO, tema));
		votos.add(new Voto(new Integer(2), ip, NivelEstudios.ALTO, tema));
		votos.add(new Voto(new Integer(3), ip, NivelEstudios.BAJO, tema));

		temaDao.create(tema);
		
		for(Voto voto:votos){
			votoDao.create(voto);
		}

		votos.clear();
		tema2 = new Tema("Deportes", "¿Blobloblo?");
		votos.add(new Voto(new Integer(8), ip, NivelEstudios.MEDIO, tema));
		votos.add(new Voto(new Integer(6), ip, NivelEstudios.ALTO, tema));
		votos.add(new Voto(new Integer(7), ip, NivelEstudios.BAJO, tema));

		temaDao.create(tema2);

		temasParaMeter.add(tema);
		temasParaMeter.add(tema2);
		
		
		for(Voto voto:votos){
			votoDao.create(voto);
		}
	}

	@After
	public void after() {
		votoDao.eliminarVotos(tema);
		votoDao.eliminarVotos(tema2);
		temaDao.deleteById(tema.getId());
		temaDao.deleteById(tema2.getId());
	}

	@Test
	public void testCreateAndRead() {
		assertEquals(tema, temaDao.read(tema.getId()));
	}

	@Test
	public void testUpdate() {
		String nuevaPregunta = "¿Nueva pregunta?";
		Tema temaBD = temaDao.read(tema.getId());
		temaBD.setPregunta(nuevaPregunta);
		temaDao.update(temaBD);
		assertEquals(temaDao.read(temaBD.getId()).getPregunta(), nuevaPregunta);
	}

	@Test
	public void testDeleteById() {
		System.out.println("Tema a borrar es "+tema);
		votoDao.eliminarVotos(tema);
		temaDao.deleteById(tema.getId());
		assertNull(temaDao.read(tema.getId()));
	}

	@Test
	public void testFindAll() {
		List<Tema> listaTemas = temaDao.findAll();
		assertEquals(listaTemas, temasParaMeter);

	}
}
