package views.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudios;
import controllers.ejbs.TemaController;
import controllers.ejbs.VotoController;

@ManagedBean
@ViewScoped
public class VoteSubmitView extends ViewBean{

    private int themeId;

    private List<Tema> themes;

    private String question;

    private int[] votes;
    
	private List<NivelEstudios> listaNivelEstudios;

    private boolean disabledVote;
    
	private NivelEstudios nivelEstudios;

	private int voteValue;

	private TemaController temaController;

	private VotoController votoController;

    @PostConstruct
    public void update() {
        System.out.println("Se actualizan datos de la capa de negocio");
        temaController = this.getControllerFactory().getTemaController();
        themes = new ArrayList<Tema>();
        themes = temaController.getTemas();
        themeId = themes.get(0).getId();
        votes = new int[10];
        for (int i = 0; i < votes.length; i++) {
            votes[i] = i;
        }
		listaNivelEstudios = new ArrayList<NivelEstudios>();
		listaNivelEstudios.add(NivelEstudios.ALTO);
		listaNivelEstudios.add(NivelEstudios.MEDIO);
		listaNivelEstudios.add(NivelEstudios.BAJO);
		disabledVote = true;
        this.updateVote();
    }
    
    public NivelEstudios getNivelEstudios() {
  		return nivelEstudios;
  	}
    
    

    public void setNivelEstudios(NivelEstudios nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	private void updateVote() {
    	System.out.println("lista de temas es "+themes);
    	System.out.println("Cojo el de la posicion "+themeId);
    	temaController = this.getControllerFactory().getTemaController();
    	System.out.println("Controlador "+this.getControllerFactory().getTemaController());
    	System.out.println("Tema recuperado "+temaController.getTema(themeId));
    	question = temaController.getTema(themeId).getPregunta();
        voteValue = votes[0];
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    public String processThemeId() {
    	disabledVote = false;
        this.updateVote();
        return null;
    }
    

    public List<Tema> getThemes() {
		return themes;
	}
    
    

	public List<NivelEstudios> getListaNivelEstudios() {
		return listaNivelEstudios;
	}

	public void setListaNivelEstudios(List<NivelEstudios> listaNivelEstudios) {
		this.listaNivelEstudios = listaNivelEstudios;
	}

	public String processVote() {
        System.out.println("Se accede a la capa de negocio --->>> TemaId: " + themeId
                + "; voteValue: " + voteValue);
        votoController = this.getControllerFactory().getVotoController();
		temaController = this.getControllerFactory().getTemaController();
		Tema tema = temaController.getTema(themeId);
		Voto voto = new Voto(voteValue, this.getIp(),nivelEstudios , tema);
		voto.setTema(tema);
		votoController.addVoto(voto);
		return "home";
    }

    public int getVoteValue() {
        return voteValue;
    }

    public void setVoteValue(int voteValue) {
        this.voteValue = voteValue;
    }

    public int getThemeId() {
        return themeId;
    }



    public String getQuestion() {
        return question;
    }

    public int[] getVotes() {
        return votes;
    }

    public boolean isDisabledVote() {
        return disabledVote;
    }
    public String getIp(){
    	return ((HttpServletRequest) FacesContext.getCurrentInstance()
        .getExternalContext().getRequest()).getRemoteAddr();
    }
    
}
