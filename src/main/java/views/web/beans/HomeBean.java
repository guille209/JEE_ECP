package views.web.beans;

import models.utils.IdentificadorAutorizacion;

public class HomeBean {
    private String errorMsg;
    private IdentificadorAutorizacion identificadorAutorizacion;


    public HomeBean() {
    }
    
    

    public IdentificadorAutorizacion getIdentificadorAutorizacion() {
		return identificadorAutorizacion;
	}



	public void setIdentificadorAutorizacion(
			IdentificadorAutorizacion identificadorAutorizacion) {
		this.identificadorAutorizacion = identificadorAutorizacion;
	}



	public String getErrorMsg() {
        return errorMsg;
    }


    public String process() {
    	//Codigo verificacion
        if (this.identificadorAutorizacion.esCorrecto()) {
            return "eliminarTema";
        } else {System.out.println("Incorrecto");
        	this.errorMsg = "El identificador de autorización introducido no es correcto";  
            return "home";
        }
    }

}

