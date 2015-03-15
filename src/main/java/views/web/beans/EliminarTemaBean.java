package views.web.beans;

import models.utils.IdentificadorAutorizacion;

public class EliminarTemaBean {

	private IdentificadorAutorizacion identificadorAutorizacion;
	private String errorMsg;

	public IdentificadorAutorizacion getIdentificadorAutorizacion() {
		return identificadorAutorizacion;
	}

	public void setIdentificadorAutorizacion(
			IdentificadorAutorizacion identificadorAutorizacion) {
		this.identificadorAutorizacion = identificadorAutorizacion;
	}

	public String processAutenticacion() {
		// Codigo verificacion
		if (this.identificadorAutorizacion.esCorrecto()) {
			return "eliminarTema";
		} else {
			System.out.println("Incorrecto");
			this.errorMsg = "El identificador de autorización introducido no es correcto";
			return "home";
		}
	}

}
