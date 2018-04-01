package com.wha.springmvc.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "visiteur")
public class Visiteur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private String numTel;
	private int nbEnfants;
	private String situationMaritale;
	
	//ok
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="demandeOuvertureCompte_id")
	private DemandeOuvertureCompte demandeOuvertureCompte ;
	
	public Visiteur() {
		id = 0;
	}
	
	public Visiteur(int id, String nom, String prenom, String adresse, String email, String numTel, int nbEnfants,
			String situationMaritale) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.numTel = numTel;
		this.nbEnfants = nbEnfants;
		this.situationMaritale = situationMaritale;
	}

	
	public DemandeOuvertureCompte getDemandeOuvertureCompte() {
		return demandeOuvertureCompte;
	}

	public void setDemandeOuvertureCompte(DemandeOuvertureCompte demandeOuvertureCompte) {
		this.demandeOuvertureCompte = demandeOuvertureCompte;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public int getNbEnfants() {
		return nbEnfants;
	}

	public void setNbEnfants(int nbEnfants) {
		this.nbEnfants = nbEnfants;
	}

	public String getSituationMaritale() {
		return situationMaritale;
	}

	public void setSituationMaritale(String situationMaritale) {
		this.situationMaritale = situationMaritale;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
//		result = prime * result + ((email == null) ? 0 : email.hashCode());
//		result = prime * result + id;
//		result = prime * result + nbEnfants;
//		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
//		result = prime * result + ((numTel == null) ? 0 : numTel.hashCode());
//		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
//		result = prime * result + ((situationMaritale == null) ? 0 : situationMaritale.hashCode());
//		return result;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visiteur other = (Visiteur) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (nbEnfants != other.nbEnfants)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (numTel == null) {
			if (other.numTel != null)
				return false;
		} else if (!numTel.equals(other.numTel))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (situationMaritale == null) {
			if (other.situationMaritale != null)
				return false;
		} else if (!situationMaritale.equals(other.situationMaritale))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Visiteur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", email="
				+ email + ", numTel=" + numTel + ", nbEnfants=" + nbEnfants + ", situationMaritale=" + situationMaritale
				+ "]";
	}

	
	

}
