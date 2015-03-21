package controllers.ejbs;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "controllerFactory")
@ApplicationScoped
public class ControllerFactory {

	private VotarController votarController;

	private VerVotacionesController verVotacionesController;

	private AniadirTemaController aniadirTemaController;

	private EliminarTemaController eliminarTemaController;

	public ControllerFactory() {

		this.votarController = new VotarController();
		this.verVotacionesController = new VerVotacionesController();
		this.aniadirTemaController = new AniadirTemaController();
		this.eliminarTemaController = new EliminarTemaController();
	}

	public VotarController getVotarController() {
		return votarController;
	}

	public void setVotarController(VotarController votarController) {
		this.votarController = votarController;
	}

	public VerVotacionesController getVerVotacionesController() {
		return verVotacionesController;
	}

	public void setVerVotacionesController(
			VerVotacionesController verVotacionesController) {
		this.verVotacionesController = verVotacionesController;
	}

	public AniadirTemaController getAniadirTemaController() {
		return aniadirTemaController;
	}

	public void setAniadirTemaController(
			AniadirTemaController aniadirTemaController) {
		this.aniadirTemaController = aniadirTemaController;
	}

	public EliminarTemaController getEliminarTemaController() {
		return eliminarTemaController;
	}

	public void setEliminarTemaController(
			EliminarTemaController eliminarTemaController) {
		this.eliminarTemaController = eliminarTemaController;
	}

}
