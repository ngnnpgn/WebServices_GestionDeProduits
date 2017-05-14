package cm.ngnkm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import cm.ngnkm.entities.Categorie;

@RepositoryRestResource 
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
