package be.vdab.repositories;

import javax.persistence.EntityManager;

import be.vdab.filters.JPAFilter;

// enkele imports ...
abstract class AbstractRepository {
EntityManager getEntityManager() { 
return JPAFilter.getEntityManager(); 
}
}