package be.vdab.repositories;

import javax.persistence.EntityManager;

import be.vdab.filters.JPAFilter;

public class AbstractRepository {

	
	public EntityManager getEntityManager() {
		
		return JPAFilter.getEntityManager();
		
	}
	
}
