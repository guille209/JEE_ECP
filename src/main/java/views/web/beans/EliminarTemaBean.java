package views.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import controllers.ejbs.TemaController;
import models.entities.Tema;
import models.utils.IdentificadorAutorizacion;

@ManagedBean
public class EliminarTemaBean extends ViewBean{

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
	
	
	public String processEliminarTema(){
		temaController = new TemaController();
		System.out.println("A eliminar es "+nombreTemaEliminar);
		temaController.removeTema(nombreTemaEliminar);
		return "home";
	}

	public String processIdentificar() {
		// TODO Auto-generated method stub
		if (this.identificadorAutorizacion.esCorrecto()) {
			listaTemas = new ArrayList<Tema>();
			temaController = this.getControllerFactory().getTemaController();
			listaTemas = temaController.getTemas();
			return "eliminarTema";
		} else {
			this.errorMsg = "El identificador de autorización introducido no es correcto";
			return "home";
		}
		
	}

}
