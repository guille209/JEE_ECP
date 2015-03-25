package models.daos;

import models.entities.Tema;

public interface TemaDao extends GenericDao<Tema, Integer> {

	Tema getTema(String nombreTema);

	void removeByName(String nombreTema);
}
