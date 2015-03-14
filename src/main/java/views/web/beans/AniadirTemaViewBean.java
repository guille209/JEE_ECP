package views.web.beans;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;

import org.apache.logging.log4j.LogManager;

import controllers.TemaController;

public class AniadirTemaViewBean {
    private String errorMsg;

    private Tema tema;
    private TemaController temaController;

    public AniadirTemaViewBean() {
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
        if (this.tema.getNombre()!=""&&this.tema.getPregunta()!="") {
        	temaController.aniadirTema(tema);
            LogManager.getLogger(AniadirTemaViewBean.class).debug(
                    "Se accede a la capa de negocio para registrar tema: " + tema);
            return "home";
        } else {
        	this.errorMsg = "Debe rellenar todos los campos";
            
            return "aniadirTema";
        }
    }

}
