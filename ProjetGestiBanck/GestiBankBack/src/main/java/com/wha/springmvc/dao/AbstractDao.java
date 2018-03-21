package com.wha.springmvc.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractDao<PK extends Serializable, T> {

	private final Class<T> persistentClass;
	@PersistenceContext
	// spring mvc
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[1];
	}

	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

	protected T getByKey(PK key) {
		return (T) entityManager.find(persistentClass, key);
	}
	
	public void persist(T entity){
		entityManager.persist(entity);
	}
	public void update(T entity){
		entityManager.merge(entity);
	}
	public void delete(T entity){
		entityManager.remove(entity);
	}

}
