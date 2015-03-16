package views.web.jsf;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HomeJSFBean {
    private String name="Hola, desde Bean. OK!!!";

    public String getName() {
        return name;
    }
}
