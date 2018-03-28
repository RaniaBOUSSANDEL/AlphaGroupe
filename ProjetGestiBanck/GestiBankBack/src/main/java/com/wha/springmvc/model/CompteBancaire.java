package com.wha.springmvc.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("CB")

public class CompteBancaire {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private long numCompte;
	private Date dateCreation;
	private int solde;
	public CompteBancaire() {
		id =0;
	}
	public CompteBancaire(int id, long numCompte, Date dateCreation, int solde) {
	
		this.id = id;
		this.numCompte = numCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getNumCompte() {
		return numCompte;
	}
	public void setNumCompte(long numCompte) {
		this.numCompte = numCompte;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public int getSolde() {
		return solde;
	}
	public void setSolde(int solde) {
		this.solde = solde;
	}
	@Override
	public String toString() {
		return "CompteBancaire [id=" + id + ", numCompte=" + numCompte + ", dateCreation=" + dateCreation + ", solde="
				+ solde + "]";
	}
	
}
