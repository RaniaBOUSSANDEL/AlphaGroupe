package com.wha.springmvc.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("DOC")
@Table(name = "demandeOuvertureCompte")
public class DemandeOuvertureCompte extends Demande {
	
	/*l'id du client on la recupere automatiquement*/	
	/*int idClient;*/
	private String etatAffectation;
	private Date dateAffectation;
	
	//ok
	@ManyToOne
	@JoinColumn(name = "administrateur_id")// le nom de la colonne cree dans la base de donnee
	private Administrateur administrateur;
	

	//ok
	@ManyToOne
	//@JoinColumn(name = "conseiller_id")// le nom de la colonne cree dans la base de donnee
	private Conseiller conseiller;
	
	
	public DemandeOuvertureCompte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DemandeOuvertureCompte(int idDemande, Date dateDemande, String etatDemande, String etatAffectation, Date dateAffectation) {
		super(idDemande, dateDemande, etatDemande);
		this.etatAffectation = etatAffectation;
		this.dateAffectation = dateAffectation;
	}
	
	public Administrateur getAdministrateur() {
		return administrateur;
	}
	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}
	public Conseiller getConseiller() {
		return conseiller;
	}
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
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
