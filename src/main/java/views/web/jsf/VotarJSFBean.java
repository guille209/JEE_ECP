package views.web.jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class VotarJSFBean {
    private String name="Hola, desde Bean. OK!!!";

    public String getName() {
        return name;
    }
}
