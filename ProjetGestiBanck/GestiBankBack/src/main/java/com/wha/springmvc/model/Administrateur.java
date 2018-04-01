package com.wha.springmvc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("AD")
@Table(name = "administrateur")
public class Administrateur extends User {

	// ok
	@OneToMany(mappedBy = "administrateur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Conseiller> conseillers;

	//ok
	@OneToMany(mappedBy = "administrateur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DemandeOuvertureCompte> demandesOuvertureCompte;

	public Administrateur() {
		// TODO Auto-generated constructor stub
	}

	public Administrateur(String nom, String prenom, String adresse, String email, String numTel, String login,
			String motDePasse) {
		super(nom, prenom, adresse, email, numTel, login, motDePasse);
		// TODO Auto-generated constructor stub
	}

	public List<DemandeOuvertureCompte> getDemandesOuvertureCompte() {
		return demandesOuvertureCompte;
	}

	public void setDemandesOuvertureCompte(List<DemandeOuvertureCompte> demandesOuvertureCompte) {
		this.demandesOuvertureCompte = demandesOuvertureCompte;
	}

	public void setConseillers(List<Conseiller> conseillers) {
		this.conseillers = conseillers;
	}

	public List<Conseiller> getConseillers() {
		return conseillers;
	}
	

}
