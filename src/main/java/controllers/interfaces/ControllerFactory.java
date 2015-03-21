package controllers.interfaces;


public interface ControllerFactory {

	public abstract VotarController getVotarController();

	public abstract void setVotarController(VotarController votarController);

	public abstract VerVotacionesController getVerVotacionesController();

	public abstract void setVerVotacionesController(
			VerVotacionesController verVotacionesController);

	public abstract AniadirTemaController getAniadirTemaController();

	public abstract void setAniadirTemaController(
			AniadirTemaController aniadirTemaController);

	public abstract EliminarTemaController getEliminarTemaController();

	public abstract void setEliminarTemaController(
			EliminarTemaController eliminarTemaController);

}