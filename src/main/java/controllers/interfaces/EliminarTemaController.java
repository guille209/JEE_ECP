package controllers.interfaces;

import java.util.List;

import models.entities.Tema;

public interface EliminarTemaController {

	public abstract void removeTema(int idTema);

	public abstract boolean identificar(int identificador);

	public abstract List<Tema> getTemas();

	public abstract Tema getTema(String nombreTema);

	public abstract Tema getTema(Integer id);

}