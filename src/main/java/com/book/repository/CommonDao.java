package com.book.repository;

import org.hibernate.Session;

import java.util.Collection;
import java.util.List;

public interface CommonDao {

    Session getSession();

    <E> void create(E entity);

    <E> void create(Collection<E> entities);

    <E> E read(Class<E> entity, Object id);

    <E> E update(E entity);

    <E> void delete(E entity);

    <E> List<E> findAll(Class<E> entity);
}
