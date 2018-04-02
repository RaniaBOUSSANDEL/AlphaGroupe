package com.wha.springmvc.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("AD")
@Table(name = "administrateur")
public class Administrateur extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1208987113225446191L;

	// ok
	@JsonIgnore
	@OneToMany(mappedBy = "administrateur", fetch = FetchType.LAZY, cascade= {CascadeType.ALL})
	private Collection<Conseiller> conseillers;

	//ok
	@JsonIgnore
	@OneToMany(mappedBy = "administrateur", fetch = FetchType.LAZY, cascade= {CascadeType.ALL})
	private Collection<DemandeOuvertureCompte> demandesOuvertureCompte;

	public Administrateur() {
		// TODO Auto-generated constructor stub
	}

	public Administrateur(String nom, String prenom, String adresse, String email, String numTel, String login,
			String motDePasse) {
		super(nom, prenom, adresse, email, numTel, login, motDePasse);
		// TODO Auto-generated constructor stub
	}

	public Collection<DemandeOuvertureCompte> getDemandesOuvertureCompte() {
		return demandesOuvertureCompte;
	}

	public void setDemandesOuvertureCompte(Collection<DemandeOuvertureCompte> demandesOuvertureCompte) {
		this.demandesOuvertureCompte = demandesOuvertureCompte;
	}

	public void setConseillers(Collection<Conseiller> conseillers) {
		this.conseillers = conseillers;
	}

	public Collection<Conseiller> getConseillers() {
		return conseillers;
	}
	

}
