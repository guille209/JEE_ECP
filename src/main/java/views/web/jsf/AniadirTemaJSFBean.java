package views.web.jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class AniadirTemaJSFBean {
    private String name="Hola, desde Bean. OK!!!";

    public String getName() {
        return name;
    }
}
