package models.daos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public static final Map<String,Double> VALORACION_MEDIA_ESPERADA = new HashMap<String,Double>();

	@BeforeClass
	public static void beforeClass() {

		DaoFactory.setFactory(new DaoJpaFactory());
		// DaoJpaFactory.dropAndCreateTables();
	}

	@Before
	public void before() {
		votoDao = DaoFactory.getFactory().getVotoDao();
		temaDao = DaoFactory.getFactory().getTemaDao();
		votosParaMeter = new ArrayList<Voto>();
		tema = new Tema("nombre", "pregunta");

		voto = new Voto(new Integer(5), ip, NivelEstudios.ALTO, tema);
		voto2 = new Voto(new Integer(2), ip, NivelEstudios.ALTO, tema);
		votosParaMeter.add(voto);
		votosParaMeter.add(voto2);	
		temaDao.create(tema);
		votoDao.create(voto);
		votoDao.create(voto2);
		
		VALORACION_MEDIA_ESPERADA.put(NivelEstudios.ALTO.toString(), 3.5);
		VALORACION_MEDIA_ESPERADA.put(NivelEstudios.MEDIO.toString(), Double.NaN);
		VALORACION_MEDIA_ESPERADA.put(NivelEstudios.BAJO.toString(), Double.NaN);
	
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
		System.out.println("Lista : "+votoDao.getValoracionMedia());
		System.out.println("Valoracion media esperada: "+VALORACION_MEDIA_ESPERADA);
		assertEquals(VALORACION_MEDIA_ESPERADA,votoDao.getValoracionMedia());
	}

	@Test
	public void testEliminarVotos(){
		votoDao.eliminarVotos(tema);
	}
}
