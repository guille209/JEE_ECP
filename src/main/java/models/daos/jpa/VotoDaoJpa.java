package models.daos.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;

import models.daos.VotoDao;
import models.entities.Voto;
public class VotoDaoJpa extends GenericDaoJpa<Voto, Integer> implements VotoDao {

	public VotoDaoJpa(){
		super(Voto.class);
	}
	
	public List<Voto> findByIp(String ip){
        EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<Voto> query = criteria.createQuery(Voto.class);

        Root<Voto> root = query.from(Voto.class);

        query.select(root); 

        Predicate p1 = criteria.equal(root.get("ip"),ip);
        query.where(p1);
        // Se realiza la query
        TypedQuery<Voto> typedQuery = entityManager.createQuery(query);
        typedQuery.setFirstResult(0); // El primero es 0
        typedQuery.setMaxResults(0); // Se realiza la query, se buscan todos
        List<Voto> result = typedQuery.getResultList();
        entityManager.close();
        return result;
	}
}
