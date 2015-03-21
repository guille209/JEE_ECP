package views.web.beans;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import controllers.ejbs.VerVotacionesController;

@ManagedBean
public class VerVotacionesBean extends ViewBean {

	private VerVotacionesController verVotacionesController;

	private Map<String, Integer> numeroVotosPorTema;
	private Map<String, Double> votacionMediaPorEstudios;

	public VerVotacionesBean() {
		// Llamar a update
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
		verVotacionesController = this.getControllerFactory()
				.getVerVotacionesController();
		numeroVotosPorTema = new HashMap<String, Integer>();
		votacionMediaPorEstudios = new HashMap<String, Double>();

		numeroVotosPorTema = verVotacionesController.getNumeroVotos();
		System.out.println("Getnumerodevotosdevuelve "
				+ verVotacionesController.getNumeroVotos());
		votacionMediaPorEstudios = verVotacionesController.getValoracionMedia();

	}
}
