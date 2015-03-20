package views.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import controllers.ejbs.TemaController;
import models.entities.Tema;
import models.utils.IdentificadorAutorizacion;

@ManagedBean
@ViewScoped
public class EliminarTemaBean extends ViewBean{
	private int identificador;
	private IdentificadorAutorizacion identificadorAutorizacion;
	private String errorMsg;
	private List<Tema> listaTemas;
	private TemaController temaController;
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

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
	public String processEliminarTema(){
		temaController = this.getControllerFactory().getTemaController();
		System.out.println("A eliminar es "+idTemaEliminar);
		temaController.removeTema(idTemaEliminar);
		return "home";
	}

	public String processIdentificar() {
		// TODO Auto-generated method stub	
		temaController = this.getControllerFactory().getTemaController();
		if (temaController.identificar(this.identificador)) {
			cargarTemas();
			return "eliminarTema";
		} else {
			this.errorMsg = "El identificador de autorización introducido no es correcto";
			return "home";
		}
		
	}
	@PostConstruct
	public void cargarTemas(){
		listaTemas = new ArrayList<Tema>();
		temaController = this.getControllerFactory().getTemaController();
		listaTemas = temaController.getTemas();		
	}

}
