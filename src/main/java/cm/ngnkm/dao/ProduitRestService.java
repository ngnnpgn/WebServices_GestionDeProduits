package cm.ngnkm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cm.ngnkm.entities.Produit;

@RestController
public class ProduitRestService {

	@Autowired
	private ProduitRepository produitRepository;
	
	@RequestMapping(value="/produits", method=RequestMethod.GET )
	public List<Produit> listProduit() {	
		return produitRepository.findAll(); // liste de produit retourner en format JSON		
	}
	
	@RequestMapping(value="/produits/{id}", method=RequestMethod.GET )
	public Produit getProduit( @PathVariable("id")Long id) {	
		return produitRepository.findOne(id); // liste de produit retourner en format JSON		
	}
	
	@RequestMapping(value="/produits/{id}", method=RequestMethod.POST )
	public Produit save( @PathVariable Produit p) {	
		return produitRepository.save(p); // liste de produit retourner en format JSON		
	}
}
