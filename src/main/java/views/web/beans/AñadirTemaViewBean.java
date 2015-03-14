package views.web.beans;

import models.daos.DaoFactory;
import models.daos.TemaDao;
import models.daos.jpa.DaoJpaFactory;
import models.entities.Tema;

import org.apache.logging.log4j.LogManager;

public class AñadirTemaViewBean {
    private String errorMsg;

    private Tema tema;

    public AñadirTemaViewBean() {
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
        	DaoFactory.setFactory(new DaoJpaFactory());
        	TemaDao temaDao = DaoFactory.getFactory().getTemaDao(); 
        	temaDao.create(tema);
            LogManager.getLogger(AñadirTemaViewBean.class).debug(
                    "Se accede a la capa de negocio para registrar tema: " + tema);
            return "home";
        } else {
        	this.errorMsg = "Debe rellenar todos los campos";
            
            return "votar";
        }
    }

}
