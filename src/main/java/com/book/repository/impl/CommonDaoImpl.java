package com.book.repository.impl;

import com.book.repository.CommonDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CommonDaoImpl implements CommonDao {

    private static final int DEFAULT_LOCK_TIMEOUT = 5 * 1000;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Session getSession() {
        if (entityManager != null && entityManager.getDelegate() != null) {
            return ((Session) entityManager.getDelegate());
        }
        return null;
    }

    @Override
    public <E> void create(E entity) {
        if (entity != null) {
            entityManager.persist(entity);
        }
    }

    @Override
    public <E> void create(Collection<E> entities) {
        if (entities != null && !entities.isEmpty()) {
            entityManager.persist(entities);
        }
    }

    @Override
    public <E> E read(Class<E> entity, Object id) {
        if (entity != null && id != null) {
            return entityManager.find(entity, id);
        }
        return null;
    }

    @Override
    public <E> E update(E entity) {
        if (entity != null) {
            return entityManager.merge(entity);
        }
        return null;
    }

    @Override
    public <E> void delete(E entity) {
        if (entity != null) {
            if (!entityManager.contains(entity)) {
                entity = entityManager.merge(entity);
            }
            entityManager.remove(entity);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <E> List<E> findAll(Class<E> entity) {
        return entityManager.createQuery(String.format("SELECT e FROM %s e", entity.getName()))
            .getResultList();
    }
}
