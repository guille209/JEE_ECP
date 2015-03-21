package controllers.ejbs;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import controllers.interfaces.AniadirTemaController;
import controllers.interfaces.ControllerFactory;
import controllers.interfaces.EliminarTemaController;
import controllers.interfaces.VerVotacionesController;
import controllers.interfaces.VotarController;

@ManagedBean(name = "controllerFactory")
@ApplicationScoped
public class ControllerFactoryEJB implements ControllerFactory{

	private VotarController votarController;

	private VerVotacionesController verVotacionesController;

	private AniadirTemaController aniadirTemaController;

	private EliminarTemaController eliminarTemaController;

	public ControllerFactoryEJB() {

		this.votarController = new VotarControllerEJB();
		this.verVotacionesController = new VerVotacionesControllerEJB();
		this.aniadirTemaController = new AniadirTemaControllerEJB();
		this.eliminarTemaController = new EliminarTemaControllerEJB();
	}

	/* (non-Javadoc)
	 * @see controllers.ejbs.ControllerFactory#getVotarController()
	 */
	@Override
	public VotarController getVotarController() {
		return votarController;
	}

	/* (non-Javadoc)
	 * @see controllers.ejbs.ControllerFactory#setVotarController(controllers.ejbs.VotarController)
	 */
	@Override
	public void setVotarController(VotarController votarController) {
		this.votarController = votarController;
	}

	/* (non-Javadoc)
	 * @see controllers.ejbs.ControllerFactory#getVerVotacionesController()
	 */
	@Override
	public VerVotacionesController getVerVotacionesController() {
		return verVotacionesController;
	}

	/* (non-Javadoc)
	 * @see controllers.ejbs.ControllerFactory#setVerVotacionesController(controllers.ejbs.VerVotacionesController)
	 */
	@Override
	public void setVerVotacionesController(
			VerVotacionesController verVotacionesController) {
		this.verVotacionesController = verVotacionesController;
	}

	/* (non-Javadoc)
	 * @see controllers.ejbs.ControllerFactory#getAniadirTemaController()
	 */
	@Override
	public AniadirTemaController getAniadirTemaController() {
		return aniadirTemaController;
	}

	/* (non-Javadoc)
	 * @see controllers.ejbs.ControllerFactory#setAniadirTemaController(controllers.ejbs.AniadirTemaController)
	 */
	@Override
	public void setAniadirTemaController(
			AniadirTemaController aniadirTemaController) {
		this.aniadirTemaController = aniadirTemaController;
	}

	/* (non-Javadoc)
	 * @see controllers.ejbs.ControllerFactory#getEliminarTemaController()
	 */
	@Override
	public EliminarTemaController getEliminarTemaController() {
		return eliminarTemaController;
	}

	/* (non-Javadoc)
	 * @see controllers.ejbs.ControllerFactory#setEliminarTemaController(controllers.ejbs.EliminarTemaController)
	 */
	@Override
	public void setEliminarTemaController(
			EliminarTemaController eliminarTemaController) {
		this.eliminarTemaController = eliminarTemaController;
	}

}
