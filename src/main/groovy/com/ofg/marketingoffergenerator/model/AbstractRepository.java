package com.ofg.marketingoffergenerator.model;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("unchecked")
abstract class AbstractRepository<T, ID extends Serializable> {

	@Autowired
	protected SessionFactory sessionFactory;

	private final Class<T> entityClass;

	public AbstractRepository(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public ID persist(T entity) {
        return (ID) session().save(entity);
	}

	protected Session session() {
		return sessionFactory.getCurrentSession();
	}

	public T get(ID id) {
        return (T) session().get(entityClass, id);
	}

	protected Criteria criteria() {
        return session().createCriteria(entityClass);
	}

	public List<T> list(Criteria criteria) {
		return criteria.list();
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}
}
