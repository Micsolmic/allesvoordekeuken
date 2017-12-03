package be.vdab.repositories;

import java.util.Optional;

import javax.persistence.EntityManager;

import be.vdab.entities.Artikel;
import be.vdab.filters.JPAFilter;

public class ArtikelRepository extends AbstractRepository {

	
	
	
	public Optional<Artikel> read(long id){
		
			Artikel art = getEntityManager().find(Artikel.class, id);
			return Optional.ofNullable(art);		
	}
	
	public void voegArtikelToe(Artikel artikel) {
		
		
		getEntityManager().persist(artikel);
		
		
	}
	
	
	
}
