package cm.ngnkm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cm.ngnkm.entities.Produit;

@RestController
public class ProduitRestService {

	@Autowired
	private ProduitRepository produitRepository;
	
	@RequestMapping(value="/produits", method=RequestMethod.GET )
	public Page<Produit> listProduit(
			@RequestParam(name="page", defaultValue="0")int page,
			@RequestParam(name="size", defaultValue="3")int size) {	
		return produitRepository.findAll(new PageRequest(page, size)); // liste de produit retourner en format JSON		
	}
	
	@RequestMapping(value="/chercherProduits", method=RequestMethod.GET )
	public Page<Produit> chercherProduit (String mc, 
			@RequestParam(name="page", defaultValue="0")int page,
			@RequestParam(name="size", defaultValue="7")int size) {	
		return produitRepository.chercherProduit("%"+mc+"%", new PageRequest(page, size)); // chercher un produit
	}
	
	@RequestMapping(value="/produits/{i}", method=RequestMethod.GET )
	public Produit getProduit( @PathVariable("i")Long id) {	
		return produitRepository.findOne(id); // get un produit d'id = ...		
	}
	
	@RequestMapping(value="/produits",method=RequestMethod.POST )
	public Produit save( @RequestBody  Produit p) {	
		return produitRepository.save(p); // enregistrer un nouveau produit	
	}
	
	@RequestMapping(value="/produits/{id}",method=RequestMethod.PUT )
	public Produit update( @RequestBody  Produit p, @PathVariable Long id) {	
		p.setId(id);
		return produitRepository.saveAndFlush(p); // modifier un produit		
	}
	
	@RequestMapping(value="/produits/{id}",method=RequestMethod.DELETE )
	public void delete( @PathVariable Long id) {	
		
		produitRepository.delete(id);
		// modifier un produit		
	}
}
