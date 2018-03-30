package com.wha.springmvc.model;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@DiscriminatorColumn(name="typeTransaction")
@DiscriminatorValue("T")
@Table(name = "Transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private long montant;
	private Date dateDeffet;
	private String libelle;
	private double solde;
	public Transaction() {
		id=0;
	}
	
	public Transaction(int id, long montant, Date dateDeffet, String libelle, double solde) {
		super();
		this.id = id;
		this.montant = montant;
		this.dateDeffet = dateDeffet;
		this.libelle = libelle;
		this.solde = solde;
	}
	
	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getMontant() {
		return montant;
	}
	public void setMontant(long montant) {
		this.montant = montant;
	}
	public Date getDateDeffet() {
		return dateDeffet;
	}
	public void setDateDeffet(Date dateDeffet) {
		this.dateDeffet = dateDeffet;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", montant=" + montant + ", dateDeffet=" + dateDeffet + ", libelle=" + libelle
				+ ", solde=" + solde + "]";
	}
	
	

}
