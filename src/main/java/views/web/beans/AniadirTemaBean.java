package views.web.beans;

import javax.faces.bean.ManagedBean;
import models.entities.Tema;

import org.apache.logging.log4j.LogManager;

import controllers.ejbs.AniadirTemaController;

//Singleton o inyecccion
//Si hacemos inyeccion con jsp, con jsf debemos hacerlo igual
//Poniendo esta anotacion el dispatcher de jsf hace toda la inyeccion
@ManagedBean
public class AniadirTemaBean extends ViewBean {
	private String errorMsg;

	private Tema tema;
	private AniadirTemaController aniadirTemaController;

	public AniadirTemaBean() {
		tema = new Tema();
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
		aniadirTemaController = this.getControllerFactory()
				.getAniadirTemaController();
		if (this.tema.getNombre() == "" || this.tema.getPregunta() == "") {
			this.errorMsg = "Debe rellenar todos los campos";
			return "aniadirTema";

		} else {

			LogManager.getLogger(AniadirTemaBean.class).debug(
					"Se accede a la capa de negocio para registrar tema: "
							+ tema);
			aniadirTemaController.addTema(tema);
			return "home";
		}
	}

}
