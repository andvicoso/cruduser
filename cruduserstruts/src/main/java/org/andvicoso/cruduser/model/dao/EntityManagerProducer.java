package org.andvicoso.cruduser.model.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {
	private static EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("cruduser");

	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		return factory.createEntityManager();
	}

	public void finalize(@Disposes EntityManager manager) {
		manager.close();
	}
}