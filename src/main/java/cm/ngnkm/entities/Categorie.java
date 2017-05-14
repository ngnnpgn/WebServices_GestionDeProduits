package cm.ngnkm.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Categorie implements Serializable{
	
	@Id @GeneratedValue
	private Long id;
	private String nomCategorie;
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categorie(String nomCategorie) {
		super();
		this.nomCategorie = nomCategorie;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	 
	
}
