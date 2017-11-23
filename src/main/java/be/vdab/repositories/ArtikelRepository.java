package be.vdab.repositories;

import java.util.Optional;

import javax.persistence.EntityManager;

import be.vdab.entities.Artikel;
import be.vdab.filters.JPAFilter;

public class ArtikelRepository {

	
	
	
	public Optional<Artikel> read(int id){
		
		EntityManager em = JPAFilter.getEntityManager();
		
		try {
			
			Artikel art = em.find(Artikel.class, id);
			return Optional.ofNullable(art);
			
		}finally {em.close();}
		
		
		
	}
	
	
	
}
