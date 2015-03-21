package controllers.interfaces;

import java.util.List;

import models.entities.Tema;
import models.entities.Voto;

public interface VotarController {

	public abstract void addVoto(Voto voto);

	public abstract List<Tema> getTemas();

	public abstract Tema getTema(String nombreTema);

	public abstract Tema getTema(Integer id);

}