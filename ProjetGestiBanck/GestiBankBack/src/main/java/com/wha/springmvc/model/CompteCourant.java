package com.wha.springmvc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@DiscriminatorValue("CC")
@Table(name="Compte Courant")
public class CompteCourant extends CompteBancaire{
	
	public CompteCourant() {
		//Attention solde toujours positif
		super();
	}
	
}
