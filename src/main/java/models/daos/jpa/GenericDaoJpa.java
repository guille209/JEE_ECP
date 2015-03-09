package models.daos.jpa;

import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.*;

import org.apache.logging.log4j.LogManager;

import models.daos.GenericDao;
import models.entities.Voto;

public class GenericDaoJpa<T, ID> implements GenericDao<T, ID> {
    private Class<T> persistentClass;

    public GenericDaoJpa(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    @Override
    public void create(T entity) {
        EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            LogManager.getLogger(GenericDaoJpa.class).debug("create: " + entity);
        } catch (Exception e) {
            LogManager.getLogger(GenericDaoJpa.class).error("create: " + e);
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public T read(ID id) {
        EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
        T entity = entityManager.find(persistentClass, id);
        entityManager.close();
        return entity;
    }

    // Cuando en una relación de colección se elimina un miembro de la
    // colección, se debe borrar de la tabla explicitamente
    @Override
    public void update(T entity) {
        EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
            LogManager.getLogger(GenericDaoJpa.class).debug("update: " + entity);
        } catch (Exception e) {
            LogManager.getLogger(GenericDaoJpa.class).error("update: " + e);
            if (entityManager.getTransaction().isActive())
                entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void deleteById(ID id) {
        EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
        T entity = entityManager.find(persistentClass, id);
        if (entity != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.remove(entity);
                entityManager.getTransaction().commit();
                LogManager.getLogger(GenericDaoJpa.class).debug("delete: " + entity);
            } catch (Exception e) {
                LogManager.getLogger(GenericDaoJpa.class).error("delete: " + e);
                if (entityManager.getTransaction().isActive())
                    entityManager.getTransaction().rollback();
            } finally {
                entityManager.close();
            }
        }
    }

    @Override
    public List<T> findAll() {
        EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
        // Se crea un criterio de consulta
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.persistentClass);

        // Se establece la clausula FROM
        Root<T> root = criteriaQuery.from(this.persistentClass);

        // Se establece la clausula SELECT
        criteriaQuery.select(root); // criteriaQuery.multiselect(root.get(atr))

        // No existen predicados

        // Se realiza la query
        TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(0); // El primero es 0
        typedQuery.setMaxResults(0); // Se realiza la query, se buscan todos
        List<T> result = typedQuery.getResultList();
        entityManager.close();
        return result;
    }
    
    public T findById(ID id){
    	EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = criteria.createQuery(this.persistentClass);

        Root<T> root = query.from(this.persistentClass);

        query.select(root); 

        Predicate p1 = criteria.equal(root.get("id"),id);
        query.where(p1);
        // Se realiza la query
        TypedQuery<T> typedQuery = entityManager.createQuery(query);
        typedQuery.setFirstResult(0); // El primero es 0
        typedQuery.setMaxResults(0); // Se realiza la query, se buscan todos
        List<T> result = typedQuery.getResultList();
        entityManager.close();
        return result.get(0);
    }

}
