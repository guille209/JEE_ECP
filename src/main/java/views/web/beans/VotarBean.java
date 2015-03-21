package views.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudios;
import controllers.interfaces.VotarController;

@ManagedBean
public class VotarBean extends ViewBean {

	private VotarController votarController;
	private List<Tema> listaTemas;
	private List<NivelEstudios> listaNivelEstudios;
	private String nombreTema;
	private Voto voto;

	public VotarBean() {

	}

	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}

	public List<Tema> getListaTemas() {
		return listaTemas;
	}

	public void setListaTemas(List<Tema> listaTemas) {
		this.listaTemas = listaTemas;
	}

	public String getNombreTema() {
		return nombreTema;
	}

	public void setNombreTema(String nombreTema) {
		this.nombreTema = nombreTema;
	}

	public List<NivelEstudios> getListaNivelEstudios() {
		return listaNivelEstudios;
	}

	public void setListaNivelEstudios(List<NivelEstudios> listaNivelEstudios) {
		this.listaNivelEstudios = listaNivelEstudios;
	}

	@PostConstruct
	public void update() {
		votarController = this.getControllerFactory().getVotarController();
		listaTemas = new ArrayList<Tema>();
		listaNivelEstudios = new ArrayList<NivelEstudios>();
		listaNivelEstudios.add(NivelEstudios.ALTO);
		listaNivelEstudios.add(NivelEstudios.MEDIO);
		listaNivelEstudios.add(NivelEstudios.BAJO);

		listaTemas = votarController.getTemas();
	}

	public String processGuardarVoto() {
		System.out.println("Mostrar " + voto);
		votarController = this.getControllerFactory().getVotarController();
		Tema tema = votarController.getTema(this.nombreTema);
		voto.setTema(tema);
		votarController.addVoto(voto);
		return "home";
	}
}
