package be.vdab.services;

import java.util.Optional;

import javax.persistence.EntityManager;

import be.vdab.entities.Artikel;
import be.vdab.filters.JPAFilter;
import be.vdab.repositories.ArtikelRepository;

public class ArtikelService extends AbstractService
{

	private static final long serialVersionUID = 1L;
	private final ArtikelRepository artRepo = new ArtikelRepository();
	
	
	public Optional<Artikel> leesArtikel(long id) {
			
			return artRepo.read(id);	
	}
	
	
	public void voegArtikelToe(Artikel artikel) {
		

		try {
			beginTransaction();
			artRepo.voegArtikelToe(artikel);			
	
		}catch(RuntimeException ex){
			rollback();
			throw ex;
		}
	
		
	}
	
	
	
}
