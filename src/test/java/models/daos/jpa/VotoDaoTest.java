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

public class VotoDaoTest {
	private VotoDao votoDao;
	private TemaDao temaDao;
	private String ip = "192.168.1.1";
	private List<Voto> votosParaMeter;
	private Voto voto;
	private Voto voto2;

	private Tema tema;
	
	private static final int NUMERO_VOTOS_EN_TEMA = 2;
	public static final List<Double> VALORACION_MEDIA_ESPERADA = new ArrayList<Double>();

	@BeforeClass
	public static void beforeClass() {

		DaoFactory.setFactory(new DaoJpaFactory());
		// DaoJpaFactory.dropAndCreateTables();
		//Media para nivel estudios bajo
		VALORACION_MEDIA_ESPERADA.add(-1.0);
		//Media para nivel estudios bajo
		VALORACION_MEDIA_ESPERADA.add(-1.0);
		//Media para nivel estudios bajo
		VALORACION_MEDIA_ESPERADA.add(4.0);
	}

	@Before
	public void before() {
		votoDao = DaoFactory.getFactory().getVotoDao();
		temaDao = DaoFactory.getFactory().getTemaDao();
		votosParaMeter = new ArrayList<Voto>();
		tema = new Tema("nombre", "pregunta");

		voto = new Voto(new Integer(5), ip, NivelEstudios.ALTO, tema);
		voto2 = new Voto(new Integer(3), ip, NivelEstudios.ALTO, tema);
		votosParaMeter.add(voto);
		votosParaMeter.add(voto2);	
		temaDao.create(tema);
		votoDao.create(voto);
		votoDao.create(voto2);
	
	}

	@After
	public void after() {
		votoDao.deleteById(voto.getId());
		votoDao.deleteById(voto2.getId());
		temaDao.deleteById(tema.getId());
	}

	@Test
	public void testReadAndCreate() {
		Voto votoBD = votoDao.read(voto.getId());
		assertEquals(votoBD, voto);
	}

	@Test
	public void testUpdate() {
		int nuevaValoracion = 2;
		Voto votoBD = votoDao.read(voto.getId());
		votoBD.setValoracion(nuevaValoracion);
		votoDao.update(votoBD);
		Voto votoCambiado = votoDao.read(votoBD.getId());
		assertEquals(new Integer(votoCambiado.getValoracion()), new Integer(
				nuevaValoracion));
	}

	@Test
	public void testDeleteById() {
		votoDao.deleteById(voto.getId());
		assertNull(votoDao.read(voto.getId()));
	}

	@Test
	public void testFindAll() {
		List<Voto> listaVotos = votoDao.findAll();
		assertEquals(listaVotos, votosParaMeter);

	}
	
	@Test
	public void testGetNumeroVotos(){
		assertEquals(NUMERO_VOTOS_EN_TEMA,votoDao.getNumeroVotos(tema));
	}
	
	@Test
	public void testGetValoracionMedia(){
		List<Double> valoracionesMedias = votoDao.getValoracionMedia();
		System.out.println("Lista : "+valoracionesMedias);
		assertEquals(VALORACION_MEDIA_ESPERADA,votoDao.getValoracionMedia());
	}

	@Test
	public void testEliminarVotos(){
		votoDao.eliminarVotos(tema);
	}
}
