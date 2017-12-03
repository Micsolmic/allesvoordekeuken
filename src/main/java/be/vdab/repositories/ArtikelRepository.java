package be.vdab.repositories;
import java.util.Optional;

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
}