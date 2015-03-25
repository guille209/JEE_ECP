package views.web.beans;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import models.entities.Tema;
import controllers.interfaces.EliminarTemaController;

@ManagedBean
@ViewScoped
public class EliminarTemaBean extends ViewBean {
	private int identificador;
	private String errorMsg;
	private List<Tema> listaTemas;
	private EliminarTemaController eliminarTemaController;
	private int idTemaEliminar;

	public int getIdTemaEliminar() {
		return idTemaEliminar;
	}

	public void setIdTemaEliminar(int idTemaEliminar) {
		this.idTemaEliminar = idTemaEliminar;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public List<Tema> getListaTemas() {
		return listaTemas;
	}

	public void setListaTemas(List<Tema> listaTemas) {
		this.listaTemas = listaTemas;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String processEliminarTema() {
		eliminarTemaController = this.getControllerFactory()
				.getEliminarTemaController();
		eliminarTemaController.removeTema(idTemaEliminar);
		return "home";
	}

	public String processIdentificar() {
		// TODO Auto-generated method stub
		eliminarTemaController = this.getControllerFactory()
				.getEliminarTemaController();
		if (eliminarTemaController.identificar(this.identificador)) {
			cargarTemas();
			return "eliminarTema";
		} else {
			this.errorMsg = "El identificador de autorización introducido no es corre	cto";
			return "home";
		}

	}

	@PostConstruct
	public void cargarTemas() {
		listaTemas = new ArrayList<Tema>();
		eliminarTemaController = this.getControllerFactory()
				.getEliminarTemaController();
		listaTemas = eliminarTemaController.getTemas();
	}

}
