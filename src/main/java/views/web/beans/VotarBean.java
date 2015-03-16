package views.web.beans;

import java.util.ArrayList;
import java.util.List;

import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudios;
import controllers.TemaController;
import controllers.VotoController;

public class VotarBean {

	private TemaController temaController;
	private VotoController votoController;
	private List<Tema> listaTemas;
	private List<NivelEstudios> listaNivelEstudios;
	private int valoracion;
	private NivelEstudios nivelEstudios;
	private String nombreTema;
	private String ip;

	public VotarBean() {

	}

	public List<Tema> getListaTemas() {
		return listaTemas;
	}

	public void setListaTemas(List<Tema> listaTemas) {
		this.listaTemas = listaTemas;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public NivelEstudios getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(NivelEstudios nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	public String getNombreTema() {
		return nombreTema;
	}

	public void setNombreTema(String nombreTema) {
		this.nombreTema = nombreTema;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public List<NivelEstudios> getListaNivelEstudios() {
		return listaNivelEstudios;
	}

	public void setListaNivelEstudios(List<NivelEstudios> listaNivelEstudios) {
		this.listaNivelEstudios = listaNivelEstudios;
	}

	public String processMostrarVotacion() {
		temaController = new TemaController();
		listaTemas = new ArrayList<Tema>();
		listaNivelEstudios = new ArrayList<NivelEstudios>();
		listaNivelEstudios.add(NivelEstudios.ALTO);
		listaNivelEstudios.add(NivelEstudios.MEDIO);
		listaNivelEstudios.add(NivelEstudios.BAJO);

		listaTemas = temaController.getTemas();
		return "votar";
	}

	public String processGuardarVoto() {
		// TODO Auto-generated method stub
		votoController = new VotoController();
		temaController = new TemaController();
		Tema tema = temaController.getTema(this.nombreTema);
		Voto voto = new Voto(valoracion, ip, nivelEstudios, tema);
		votoController.addVoto(voto);

		return "home";
	}
}
