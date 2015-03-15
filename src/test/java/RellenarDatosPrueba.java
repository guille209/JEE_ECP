import java.util.ArrayList;
import java.util.List;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.VotoDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudios;

public class RellenarDatosPrueba {

	public static void main(String[] args) {

		DaoFactory.setFactory(new DaoJpaFactory());

		TemaDao temaDao = DaoFactory.getFactory().getTemaDao();
		VotoDao votoDao = DaoFactory.getFactory().getVotoDao();
		List<Tema> temasParaMeter = new ArrayList<Tema>();
		List<Voto> votos = new ArrayList<Voto>();
		String ip = "192.168.1.1";

		Tema tema1 = new Tema("Actualidad", "¿Pregunta de actualidad?");
		Tema tema2 = new Tema("Deportes", "¿Pregunta de Deportes?");
		Tema tema3 = new Tema("Ciencia", "¿Pregunta de Ciencia?");
		Tema tema4 = new Tema("Finanzas", "¿Pregunta de Finanzas?");
		
		temasParaMeter.add(tema1);
		temasParaMeter.add(tema2);
		temasParaMeter.add(tema3);
		temasParaMeter.add(tema4);

		votos.add(new Voto(new Integer(1), ip, NivelEstudios.MEDIO, tema1));
		votos.add(new Voto(new Integer(2), ip, NivelEstudios.ALTO, tema2));
		votos.add(new Voto(new Integer(5), ip, NivelEstudios.BAJO, tema1));
		votos.add(new Voto(new Integer(6), ip, NivelEstudios.MEDIO, tema1));
		votos.add(new Voto(new Integer(2), ip, NivelEstudios.BAJO, tema3));
		votos.add(new Voto(new Integer(2), ip, NivelEstudios.ALTO, tema4));
		votos.add(new Voto(new Integer(1), ip, NivelEstudios.MEDIO, tema3));
		votos.add(new Voto(new Integer(9), ip, NivelEstudios.BAJO, tema4));
		votos.add(new Voto(new Integer(8), ip, NivelEstudios.BAJO, tema4));

		for (Tema tema: temasParaMeter) {
			temaDao.create(tema);
		}
		for (Voto voto : votos) {
			votoDao.create(voto);
		}

	}

}
