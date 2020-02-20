package fr.gtm.dao;

import javax.persistence.EntityManager;

public abstract class AbstractDAO<E, ID> {
	private Class<E> entityClass;
	public AbstractDAO(Class<E> clazz) {
		entityClass = clazz;
	}
	protected abstract EntityManager getEntityManager();
	
	public E findById(ID id) {
		return getEntityManager().find(entityClass, id);
	}
	public void save(E e) {
		getEntityManager().persist(e);
	}
	public void update(E e) {
		getEntityManager().merge(e);
	}
	public E remove(ID id) {
		EntityManager em = getEntityManager();
		E entity = em.find(entityClass,  id);
		em.remove(entity);
		return entity;
	}
}