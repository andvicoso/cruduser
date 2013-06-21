package org.andvicoso.cruduser.model.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

public class GenericDaoJPA<O> implements GenericDao<O> {
	@PersistenceContext
	private EntityManager entityManager;
	private Class<O> type;
	private String list;

	protected GenericDaoJPA() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;

		type = (Class<O>) pt.getActualTypeArguments()[0];
		list = "SELECT o FROM " + type.getSimpleName() + " o";
	}

	@Transactional
	public void create(O obj) {
		entityManager.persist(obj);
	}

	public List<O> list() {
		return createQuery(list).getResultList();
	}

	public O find(long id) {
		return entityManager.find(type, id);
	}

	@Transactional
	public void remove(long id) {
		O obj = entityManager.getReference(type, id);
		if (obj != null) {
			entityManager.remove(obj);
		}
	}

	@Transactional
	public void update(O obj) {
		entityManager.merge(obj);
	}

	protected TypedQuery<O> createQuery(String q) {
		return entityManager.createQuery(q, type);
	}

}
