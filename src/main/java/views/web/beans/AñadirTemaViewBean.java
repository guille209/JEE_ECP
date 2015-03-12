package views.web.beans;

import models.entities.Tema;

import org.apache.logging.log4j.LogManager;

public class A�adirTemaViewBean {
    private String errorMsg;

    private Tema tema;

    public A�adirTemaViewBean() {
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
        if (this.tema.getId() == 666 && !this.tema.getNombre().equals("Demonio")) {
            this.errorMsg = "Sólo se acepta el nombre 'Demonio'";
            return "votar";
        } else {
            LogManager.getLogger(A�adirTemaViewBean.class).debug(
                    "Se accede a la capa de negocio para registrar persona: " + tema);
            return "home";
        }
    }

}
