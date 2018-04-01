package com.wha.springmvc.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("DOC")
@Table(name = "demandeOuvertureCompte")
public class DemandeOuvertureCompte extends Demande {
	
	/*l'id du client on la recupere automatiquement*/	
	/*int idClient;*/
	private String etatAffectation;
	private Date dateAffectation;
	public DemandeOuvertureCompte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DemandeOuvertureCompte(int idDemande, Date dateDemande, String etatDemande, String etatAffectation, Date dateAffectation) {
		super(idDemande, dateDemande, etatDemande);
		this.etatAffectation = etatAffectation;
		this.dateAffectation = dateAffectation;
	}
	public String getEtatAffectation() {
		return etatAffectation;
	}
	public void setEtatAffectation(String etatAffectation) {
		this.etatAffectation = etatAffectation;
	}
	public Date getDateAffectation() {
		return dateAffectation;
	}
	public void setDateAffectation(Date dateAffectation) {
		this.dateAffectation = dateAffectation;
	}
	@Override
	public String toString() {
		return "DemandeOuvertureCompte [etatAffectation=" + etatAffectation + ", dateAffectation=" + dateAffectation
				+ "]";
	}
	
	/* generer automatiquement avec la methode equal*/
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((dateAffectation == null) ? 0 : dateAffectation.hashCode());
//		result = prime * result + ((etatAffectation == null) ? 0 : etatAffectation.hashCode());
//		return result;
//	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DemandeOuvertureCompte other = (DemandeOuvertureCompte) obj;
		if (dateAffectation == null) {
			if (other.dateAffectation != null)
				return false;
		} else if (!dateAffectation.equals(other.dateAffectation))
			return false;
		if (etatAffectation == null) {
			if (other.etatAffectation != null)
				return false;
		} else if (!etatAffectation.equals(other.etatAffectation))
			return false;
		return true;
	}
	
	/*public int getIdClient() {
		return idClient;
	}*/
	/*public void setIdClient(int idClient) {
		this.idClient = idClient;
	}*/
	

	
}
