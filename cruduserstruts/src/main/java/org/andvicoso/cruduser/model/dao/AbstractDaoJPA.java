package org.andvicoso.cruduser.model.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public abstract class AbstractDaoJPA<O> implements AbstractDao<O> {
	@Inject
	protected EntityManager entityManager;
	private Class<O> type;

	protected AbstractDaoJPA() {
		// entityManager = new EntityManagerProducer().getEntityManager();
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<O>) pt.getActualTypeArguments()[0];
	}

	public void put(O obj) {
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
	}

	public void update(O obj) {
		entityManager.getTransaction().begin();
		entityManager.merge(obj);
		entityManager.getTransaction().commit();
	}

	public List<O> list() {
		String entityName = type.getSimpleName();
		String q = "Select o from " + entityName + " o";
		return createQuery(q).getResultList();
	}

	public O find(long id) {
		return entityManager.find(type, id);
	}

	public void remove(long id) {
		O u = find(id);
		entityManager.getTransaction().begin();
		entityManager.remove(u);
		entityManager.getTransaction().commit();
	}

	protected TypedQuery<O> createQuery(String q) {
		return entityManager.createQuery(q, type);
	}

}
