package com.wha.springmvc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("AD")
@Table(name = "administrateur")
public class Administrateur extends User {


	public Administrateur() {
		// TODO Auto-generated constructor stub
	}

	public Administrateur(int id, String nom, String prenom, String adresse, String email, String numTel, String login,
			String motDePasse) {
		super(id, nom, prenom, adresse, email, numTel, login, motDePasse);
		// TODO Auto-generated constructor stub
	}
	

}
