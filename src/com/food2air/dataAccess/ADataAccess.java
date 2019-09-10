package com.food2air.dataAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.food2air.dataAccess.exception.DataAccessException;

public abstract class ADataAccess<T> implements IDataAccess<T> {

	@PersistenceContext
	protected EntityManager em;

	private final Class<T> type;

	public ADataAccess(Class<T> clazz) {
		this.type = clazz;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public T create(T object) throws DataAccessException {
		if (em.contains(object))
			update(object);
		else
			em.persist(object);
		em.flush();
		return object;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public T update(T object) throws DataAccessException {
		em.merge(object);
		em.flush();
		return object;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(T object) throws DataAccessException {
		em.remove(em.merge(object));
		em.flush();
	}

	public T findById(long id) {
		return em.find(type, id);
	}

	public List<T> getAll() {
		return em.createQuery("SELECT s FROM " + type.getSimpleName() + " s  ORDER BY s.id DESC", type).getResultList();
	}

	public List<T> getAll(int from, int limit) {
		return em.createQuery("SELECT s FROM " + type.getSimpleName() + " s  ORDER BY s.id DESC", type)
				.setFirstResult(from).setMaxResults(limit).getResultList();
	}

}
