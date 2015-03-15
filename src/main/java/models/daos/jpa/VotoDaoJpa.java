package models.daos.jpa;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import models.daos.VotoDao;
import models.entities.Tema;
import models.entities.Voto;

public class VotoDaoJpa extends GenericDaoJpa<Voto, Integer> implements VotoDao {

	public VotoDaoJpa() {
		super(Voto.class);
	}

	@Override
	public int getNumeroVotos(Tema tema) {

		EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory()
				.createEntityManager();
		CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
		CriteriaQuery<Voto> query = criteria.createQuery(Voto.class);

		Root<Voto> root = query.from(Voto.class);

		query.select(root);

		Predicate p1 = criteria.equal(root.get("tema"), tema);
		query.where(p1);
		// Se realiza la query
		TypedQuery<Voto> typedQuery = entityManager.createQuery(query);
		typedQuery.setFirstResult(0); // El primero es 0
		typedQuery.setMaxResults(0); // Se realiza la query, se buscan todos
		List<Voto> result = typedQuery.getResultList();
		entityManager.close();
		return result.size();
	}

	@Override
	public Map<String, Double> getValoracionMedia() {

		Map<String, Double> votacionMediaPorEstudios = new HashMap<String, Double>();
		List<Voto> listaVotos = this.findAll();
		double numNEBajo = 0.0;
		double sumValBajo = 0.0;
		double numNEMedio = 0.0;
		double sumValMedio = 0.0;
		double numNEAlto = 0.0;
		double sumValAlto = 0.0;
		for (Voto voto : listaVotos) {
			switch (voto.getNivelEstudios()) {
			case BAJO:
				numNEBajo++;
				sumValBajo += voto.getValoracion();
				break;
			case MEDIO:
				numNEMedio++;
				sumValMedio += voto.getValoracion();
				break;
			case ALTO:
				numNEAlto++;
				sumValAlto += voto.getValoracion();
				break;
			}

		}	
		votacionMediaPorEstudios.put("ALTO", sumValBajo / numNEBajo);
		votacionMediaPorEstudios.put("MEDIO", sumValMedio / numNEMedio);
		votacionMediaPorEstudios.put("BAJO", sumValAlto / numNEAlto);

		return votacionMediaPorEstudios;
	}

	@Override
	public void eliminarVotos(Tema tema) {
		EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory()
				.createEntityManager();
		CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
		CriteriaQuery<Voto> query = criteria.createQuery(Voto.class);

		Root<Voto> root = query.from(Voto.class);

		query.select(root);

		Predicate p1 = criteria.equal(root.get("tema"), tema);
		query.where(p1);
		// Se realiza la query
		TypedQuery<Voto> typedQuery = entityManager.createQuery(query);
		typedQuery.setFirstResult(0); // El primero es 0
		typedQuery.setMaxResults(0); // Se realiza la query, se buscan todos
		List<Voto> result = typedQuery.getResultList();
		for (Voto voto : result) {
			entityManager.getTransaction().begin();
			entityManager.remove(voto);
			entityManager.getTransaction().commit();
		}
		entityManager.close();

	}
}
