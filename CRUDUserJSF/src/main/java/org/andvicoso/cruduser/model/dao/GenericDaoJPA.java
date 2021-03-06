package org.andvicoso.cruduser.model.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class GenericDaoJPA<O> implements GenericDao<O>, Serializable {
	private static final String PERSISTENCE_UNIT = "cruduser";
	private static EntityManagerFactory factory;
	protected EntityManager entityManager;
	private Class<O> type;
	private String list;

	protected GenericDaoJPA() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		}
		entityManager = factory.createEntityManager();

		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;

		type = (Class<O>) pt.getActualTypeArguments()[0];
		list = "SELECT o FROM " + type.getSimpleName() + " o";
	}

	public void create(O obj) {
		save(obj);
	}

	private void save(O obj) {
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
	}

	public List<O> list() {
		return createQuery(list).getResultList();
	}

	public O find(long id) {
		return entityManager.find(type, id);
	}

	public void remove(long id) {
		O u = entityManager.getReference(type, id);
		if (u != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(u);
			entityManager.getTransaction().commit();
		}
	}

	public void update(O obj) {
		entityManager.getTransaction().begin();
		entityManager.merge(obj);
		entityManager.getTransaction().commit();
	}

	protected TypedQuery<O> createQuery(String q) {
		return entityManager.createQuery(q, type);
	}

}
