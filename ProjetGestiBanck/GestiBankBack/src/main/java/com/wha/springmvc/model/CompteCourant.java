package com.wha.springmvc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")

public class CompteCourant extends CompteBancaire{
	
	public CompteCourant() {
		//Attention solde toujours positif
		super();
	}
	
}
