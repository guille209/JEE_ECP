package models.daos.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;

import models.daos.VotoDao;
import models.entities.Tema;
import models.entities.Voto;
import models.utils.NivelEstudios;

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
	public List<Double> getValoracionMedia() {
		// TODO Auto-generated method stub
		List<Double> valoracionMedia = new ArrayList<Double>();
		List<Voto> listaVotos = this.findAll();
		int numNEBajo = 0;
		int sumValBajo = 0;
		int numNEMedio = 0;
		int sumValMedio = 0;
		int numNEAlto = 0;
		int sumValAlto = 0;

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
		if (numNEBajo != 0)
			valoracionMedia.add((double) (sumValBajo / numNEBajo));
		else
			valoracionMedia.add((double) -1);

		if (numNEMedio != 0)
			valoracionMedia.add((double) (sumValMedio / numNEMedio));
		else
			valoracionMedia.add((double) -1);

		if (numNEAlto != 0)
			valoracionMedia.add((double) (sumValAlto / numNEAlto));
		else
			valoracionMedia.add((double) -1);
		return valoracionMedia;
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
