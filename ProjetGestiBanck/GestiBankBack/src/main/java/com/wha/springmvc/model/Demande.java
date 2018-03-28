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

	public Demande() {
		idDemande = 0;
		dateDemande = new Date();
	}

	public Demande(int idDemande, Date dateDemande) {
		super();
		this.idDemande = idDemande;
		this.dateDemande = dateDemande;
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

	@Override
	public String toString() {
		return "Demande [idDemande=" + idDemande + ", dateDemande=" + dateDemande + "]";
	}
	

}
