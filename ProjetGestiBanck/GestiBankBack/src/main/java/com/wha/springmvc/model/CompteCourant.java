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

	public CompteCourant() {
		//Attention solde toujours positif
		super();
	}
	
}