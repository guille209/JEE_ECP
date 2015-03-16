package views.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import controllers.TemaController;
import models.entities.Tema;
import models.utils.IdentificadorAutorizacion;

@ManagedBean
public class EliminarTemaBean {

	private IdentificadorAutorizacion identificadorAutorizacion;
	private String errorMsg;
	private List<Tema> listaTemas;
	private TemaController temaController;
	private String nombreTemaEliminar;

	public IdentificadorAutorizacion getIdentificadorAutorizacion() {
		return identificadorAutorizacion;
	}

	public void setIdentificadorAutorizacion(
			IdentificadorAutorizacion identificadorAutorizacion) {
		this.identificadorAutorizacion = identificadorAutorizacion;
	}
	
	

	public List<Tema> getListaTemas() {
		return listaTemas;
	}

	public void setListaTemas(List<Tema> listaTemas) {
		this.listaTemas = listaTemas;
	}

	public String getTemaEliminar() {
		return nombreTemaEliminar;
	}

	public void setTemaEliminar(String nombreTemaEliminar) {
		this.nombreTemaEliminar = nombreTemaEliminar;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String processAutenticacion() {
		// Codigo verificacion
		if (this.identificadorAutorizacion.esCorrecto()) {
			listaTemas = new ArrayList<Tema>();
			temaController = new TemaController();
			listaTemas = temaController.getTemas();
			return "eliminarTema";
		} else {
			this.errorMsg = "El identificador de autorización introducido no es correcto";
			return "home";
		}
	}
	
	public String processEliminarTema(){
		temaController = new TemaController();
		temaController.removeTema(nombreTemaEliminar);
		return "home";
	}

}
