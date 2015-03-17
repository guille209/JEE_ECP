package views.web.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import models.entities.Tema;
import controllers.TemaController;
import controllers.VotoController;

@ManagedBean
public class VerVotacionesBean extends ViewBean {

	private VotoController votoController;

	private Map<String, Integer> numeroVotosPorTema;
	private Map<String, Double> votacionMediaPorEstudios;

	public VerVotacionesBean() {
		// Llamar a update
	}

	public VotoController getVotoController() {
		return votoController;
	}

	public void setVotoController(VotoController votoController) {
		this.votoController = votoController;
	}

	public Map<String, Integer> getNumeroVotosPorTema() {
		return numeroVotosPorTema;
	}

	public void setNumeroVotosPorTema(Map<String, Integer> numeroVotosPorTema) {
		this.numeroVotosPorTema = numeroVotosPorTema;
	}

	public Map<String, Double> getVotacionMediaPorEstudios() {
		return votacionMediaPorEstudios;
	}

	public void setVotacionMediaPorEstudios(
			Map<String, Double> votacionMediaPorEstudios) {
		this.votacionMediaPorEstudios = votacionMediaPorEstudios;
	}

	@PostConstruct
	public void update() {
		votoController = this.getControllerFactory().getVotoController();
		numeroVotosPorTema = new HashMap<String, Integer>();
		votacionMediaPorEstudios = new HashMap<String, Double>();

		numeroVotosPorTema = votoController.getNumeroVotos();
		System.out.println("Getnumerodevotosdevuelve "+votoController.getNumeroVotos());
		votacionMediaPorEstudios = votoController.getValoracionMedia();

	}
}
