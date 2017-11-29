package be.vdab.services;

import java.util.Optional;

import javax.persistence.EntityManager;

import be.vdab.entities.Artikel;
import be.vdab.filters.JPAFilter;
import be.vdab.repositories.ArtikelRepository;

public class ArtikelService {

	private static final long serialVersionUID = 1L;
	private final ArtikelRepository artRepo = new ArtikelRepository();
	
	
	public Optional<Artikel> leesArtikel(int id) {
		
		Optional<Artikel> gevondenArtikel;
		EntityManager em = JPAFilter.getEntityManager();
		try {
		
		gevondenArtikel=  artRepo.read(id, em);
		}
		finally {em.close();}
		return gevondenArtikel;
	}
	
	
	public void voegArtikelToe(Artikel artikel) {
		
		
		EntityManager em = JPAFilter.getEntityManager();
		
		try {
			em.getTransaction().begin();
			artRepo.voegArtikelToe(artikel, em);
			em.getTransaction().commit();
			
		}catch(RuntimeException ex) {
			em.getTransaction().rollback();
			throw ex;
			
		}finally {em.close();}
		
		
	}
	
	
	
}
