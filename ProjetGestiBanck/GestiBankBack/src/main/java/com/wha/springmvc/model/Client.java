package com.wha.springmvc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("CL")
@Table(name = "client")
public class Client extends User {
	
	private int nbEnfants;
	private String situationMaritale;
	
	

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

	public Client() {
		super();
	}

	public Client(int id, String nom, String prenom, String adresse, String email, String numTel, String login,
			String motDePasse, int nbEnfants, String situationMaritale) {
		super(id, nom, prenom, adresse, email, numTel, login, motDePasse);
		this.nbEnfants = nbEnfants;
		this.situationMaritale = situationMaritale;
		
	}

	@Override
	public String toString() {
		return "Client [nbEnfants=" + nbEnfants + ", situationMaritale=" + situationMaritale + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + nbEnfants;
		result = prime * result + ((situationMaritale == null) ? 0 : situationMaritale.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (nbEnfants != other.nbEnfants)
			return false;
		if (situationMaritale == null) {
			if (other.situationMaritale != null)
				return false;
		} else if (!situationMaritale.equals(other.situationMaritale))
			return false;
		return true;
	}
	

}
