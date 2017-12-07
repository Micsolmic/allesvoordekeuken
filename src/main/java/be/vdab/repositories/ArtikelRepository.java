package be.vdab.repositories;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import be.vdab.entities.Artikel;

// enkele imports ...
public class ArtikelRepository extends AbstractRepository {
public Optional<Artikel> read(long id) {
return Optional.ofNullable(getEntityManager().find(Artikel.class, id));
}
public void create(Artikel Artikel) {
getEntityManager().persist(Artikel);
}
public void delete(long id) {
read(id).ifPresent(artikel -> getEntityManager().remove(artikel));
}

public List<Artikel> zoekOpDeelnaam(String deelnaam){
	
	return getEntityManager()
		.createNamedQuery("Artikel.zoekOpDeelnaam", Artikel.class)
		.setParameter("zoals", "%" + deelnaam + "%")
		.getResultList();
	
	
}

public int prijsverhoging(BigDecimal percentage) {
	return
	getEntityManager()
	.createNamedQuery("Artikel.prijsverhoging")
	.setParameter("factor", percentage.multiply(BigDecimal.valueOf(0.01)))
	.executeUpdate();
	
	
}

public List<Artikel> zoekAlle(){
	
	List<Artikel> alleArtikels =  getEntityManager()
			.createNamedQuery("Artikel.zoekalle", Artikel.class)
			.getResultList();
	Collections.sort(alleArtikels, (artikel1,artikel2) -> artikel1.compareTo(artikel2));
	return alleArtikels;
}

}



