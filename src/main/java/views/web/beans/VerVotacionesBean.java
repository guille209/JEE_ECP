package views.web.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;

import models.entities.Tema;
import controllers.TemaController;
import controllers.VotoController;
@ManagedBean
public class VerVotacionesBean {

	private VotoController votoController;

	private Map<String, Integer> numeroVotosPorTema;
	private Map<String,Double> votacionMediaPorEstudios;

	public VerVotacionesBean() {

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

	public String processverVotaciones() {
		votoController = new VotoController();
		numeroVotosPorTema = new HashMap<String,Integer>();
		votacionMediaPorEstudios = new HashMap<String,Double>();
		
		
		numeroVotosPorTema = votoController.getNumeroVotos();
		votacionMediaPorEstudios = votoController.getValoracionMedia();
		return "verVotaciones";
	}
}
