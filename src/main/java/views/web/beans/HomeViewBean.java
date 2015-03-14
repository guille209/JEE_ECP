package views.web.beans;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;
import models.utils.IdentificadorAutorizacion;

import org.apache.logging.log4j.LogManager;

import controllers.TemaController;

public class HomeViewBean {
    private String errorMsg;
    private IdentificadorAutorizacion identificadorAutorizacion;


    public HomeViewBean() {
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
//        if (this.tema.getNombre()!=""&&this.tema.getPregunta()!="") {
//        	temaController.aniadirTema(tema);
//            LogManager.getLogger(AniadirTemaViewBean.class).debug(
//                    "Se accede a la capa de negocio para registrar tema: " + tema);
//            return "home";
//        } else {
//        	this.errorMsg = "Debe rellenar todos los campos";
//            
//            return "aniadirTema";
//        }
    	return "";
    }

}

