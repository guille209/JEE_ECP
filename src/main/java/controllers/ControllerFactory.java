package controllers;

public class ControllerFactory {

	private TemaController temaController;
	
	private VotoController votoController;
	
	public ControllerFactory(){
		
		this.temaController = new TemaController();
		this.votoController = new VotoController();
	}

	public TemaController getTemaController() {
		return temaController;
	}

	public void setTemaController(TemaController temaController) {
		this.temaController = temaController;
	}

	public VotoController getVotoController() {
		return votoController;
	}

	public void setVotoController(VotoController votoController) {
		this.votoController = votoController;
	}
	
	
}
