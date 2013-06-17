package org.andvicoso.cruduser.model.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public abstract class AbstractDaoJPA<O> implements AbstractDao<O> {
	@PersistenceContext
	private EntityManager entityManager;
	private Class<O> type;

	protected AbstractDaoJPA() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<O>) pt.getActualTypeArguments()[0];
	}

	@Transactional
	public void create(O obj) {
		entityManager.persist(obj);
	}

	public List<O> list() {
		String entityName = type.getSimpleName();
		String q = "Select o from " + entityName + " o";
		return createQuery(q).getResultList();
	}

	public O find(long id) {
		return entityManager.find(type, id);
	}

	@Transactional
	public void remove(long id) {
		O u = find(id);
		entityManager.remove(u);
	}

	@Transactional
	public void update(O obj) {
		entityManager.merge(obj);
	}

	protected TypedQuery<O> createQuery(String q) {
		return entityManager.createQuery(q, type);
	}

}
