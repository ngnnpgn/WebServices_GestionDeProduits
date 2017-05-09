package cm.ngnkm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cm.ngnkm.dao.ProduitRepository;
import cm.ngnkm.entities.Produit;

@SpringBootApplication
public class CataServiceApplication implements CommandLineRunner {

	@Autowired
	private ProduitRepository produitRepositoty;
	public static void main(String[] args){
		SpringApplication.run(CataServiceApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		produitRepositoty.save(new Produit("LX 564",900,23));
		produitRepositoty.save(new Produit("HT 54",100,8));
		produitRepositoty.save(new Produit("HP 1234",90,3));
		List<Produit> prods = produitRepositoty.findAll();
		prods.forEach(p->System.out.println(p.getDesignation()));
	}
}
