package com.wha.springmvc.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("CO")
@Table(name = "conseiller")

public class Conseiller extends User {

	private int matricule;
	private Date dateDebutContrat;

	public Conseiller() {
		super();
		
	}

	public Conseiller(int id, String nom, String prenom, String adresse, String email, String numTel, String login,
			String motDePasse, int matricule, Date dateDebutContrat) {
		super(id, nom, prenom, adresse, email, numTel, login, motDePasse);
		this.matricule = matricule;
		this.dateDebutContrat = dateDebutContrat;
		
	}

	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	public Date getDateDebutContrat() {
		return dateDebutContrat;
	}

	public void setDateDebutContrat(Date dateDebutContrat) {
		this.dateDebutContrat = dateDebutContrat;
	}

	@Override
	public String toString() {
		return "Conseiller [matricule=" + matricule + ", dateDebutContrat=" + dateDebutContrat + "]";
	}

	
}
