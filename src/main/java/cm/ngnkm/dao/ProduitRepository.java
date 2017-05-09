package cm.ngnkm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cm.ngnkm.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
