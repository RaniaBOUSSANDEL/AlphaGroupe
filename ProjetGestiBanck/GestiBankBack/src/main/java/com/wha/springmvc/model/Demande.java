package com.wha.springmvc.model;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeDemande")
@DiscriminatorValue("D")
@Table(name = "demande")

public class Demande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDemande;
	private Date dateDemande;
	private String etatDemande; //indiquer si la demande est traité ou pas

	public Demande() {
		idDemande = 0;
		dateDemande = new Date();
		etatDemande = "";
	}

	public Demande(int idDemande, Date dateDemande, String etatDemande) {
		super();
		this.idDemande = idDemande;
		this.dateDemande = dateDemande;
		this.etatDemande = etatDemande;
	}

	public int getIdDemande() {
		return idDemande;
	}

	public void setIdDemande(int idDemande) {
		this.idDemande = idDemande;
	}

	public Date getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}
	

	public String getEtatDemande() {
		return etatDemande;
	}

	public void setEtatDemande(String etatDemande) {
		this.etatDemande = etatDemande;
	}

	@Override
	public String toString() {
		return "Demande [idDemande=" + idDemande + ", dateDemande=" + dateDemande + ", etatDemande=" + etatDemande
				+ "]";
	}

	/* generer automatiquement avec la methode equal*/
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((dateDemande == null) ? 0 : dateDemande.hashCode());
//		result = prime * result + ((etatDemande == null) ? 0 : etatDemande.hashCode());
//		result = prime * result + idDemande;
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
		Demande other = (Demande) obj;
		if (dateDemande == null) {
			if (other.dateDemande != null)
				return false;
		} else if (!dateDemande.equals(other.dateDemande))
			return false;
		if (etatDemande == null) {
			if (other.etatDemande != null)
				return false;
		} else if (!etatDemande.equals(other.etatDemande))
			return false;
		if (idDemande != other.idDemande)
			return false;
		return true;
	}

	
	

}
