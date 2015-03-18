package models.daos.jpa;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import models.daos.TemaDao;
import models.entities.Tema;
import models.entities.Voto;

public class TemaDaoJpa extends GenericDaoJpa<Tema, Integer> implements TemaDao {

	public TemaDaoJpa() {
		super(Tema.class);
	}

	@Override
	public Tema getTema(String nombreTema) {

		EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory()
				.createEntityManager();
		CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tema> query = criteria.createQuery(Tema.class);

		Root<Tema> root = query.from(Tema.class);

		query.select(root);

		Predicate p1 = criteria.equal(root.get("nombre"), nombreTema);
		query.where(p1);
		// Se realiza la query
		query.select(root).where(p1);
		System.out.println("Voy a buscar en la columna nombre: "+nombreTema);
		return entityManager.createQuery(query).getSingleResult();
	}

	@Override
	public void removeByName(String nombreTema) {
		// TODO Auto-generated method stub
		
		EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory()
				.createEntityManager();
		CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tema> query = criteria.createQuery(Tema.class);

		Root<Tema> root = query.from(Tema.class);

		query.select(root);

		Predicate p1 = criteria.equal(root.get("nombre"), nombreTema);
		query.where(p1);
		// Se realiza la query
		query.select(root).where(p1);
		entityManager.getTransaction().begin();
        entityManager.remove(entityManager.createQuery(query).getSingleResult());
        entityManager.getTransaction().commit();
		return ;
		
		
	}
}
