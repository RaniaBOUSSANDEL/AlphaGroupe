package com.wha.springmvc.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")

public class CompteCourant extends CompteBancaire implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7119528510155294986L;
	//ok
	//@ManyToOne
	//@JoinColumn(name = "client_id") // le nom de la colonne cree dans la base de donnee
	//private Client client;
		
	//ok
	//@JsonIgnore
	//@OneToMany(mappedBy = "compteB", fetch = FetchType.LAZY, cascade= {CascadeType.ALL})
	//private List<Transaction> transactions;
	
	public CompteCourant() {
	//Attention solde toujours positif
		super();
	}

	
	
	
}