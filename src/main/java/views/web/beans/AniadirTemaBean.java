package views.web.beans;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;

import org.apache.logging.log4j.LogManager;

import controllers.TemaController;

public class AniadirTemaBean {
	private String errorMsg;

	private Tema tema;
	private TemaController temaController;

	public AniadirTemaBean() {
		temaController = new TemaController();
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public String process() {
		if (this.tema.getNombre() == "" || this.tema.getPregunta() == "") {
			this.errorMsg = "Debe rellenar todos los campos";
			return "aniadirTema";

		} else {

			LogManager.getLogger(AniadirTemaBean.class).debug(
					"Se accede a la capa de negocio para registrar tema: "
							+ tema);
			temaController.addTema(tema);
			return "home";
		}
	}

}
