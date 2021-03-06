package com.divergentsl.cmsjspspringconvert.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtility {

	private EntityManagerUtility() {
		throw new AssertionError();
	}

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("CMSPersistenceUnitForHibernate");

	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
