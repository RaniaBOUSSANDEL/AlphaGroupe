package com.wha.springmvc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorColumn(name = "typeTransaction")
@DiscriminatorValue("T")
@Table(name = "Transaction")
public class Transaction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7385580973192776652L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private long montant;
	private Date dateDeffet;
	private String libelle;
	private long ribDest;
	

	// ok
	@JsonIgnore
	
	@ManyToOne
	@JoinColumn(name = "compteB_id") // le nom de la colonne cree dans la base de donnee
	private CompteBancaire compteB;

	public Transaction() {
		id = 0;
	}

	public Transaction(int id, long montant, Date dateDeffet, String libelle,long ribDest) {
		super();
		this.id = id;
		this.montant = montant;
		this.dateDeffet = dateDeffet;
		this.libelle = libelle;
		this.ribDest = ribDest;
		
	}
	
	

	public long getRibDest() {
		return ribDest;
	}

	public void setRibDest(long ribDest) {
		this.ribDest = ribDest;
	}

	public CompteBancaire getCompteB() {
		return compteB;
	}

	public void setCompteB(CompteBancaire compteB) {
		this.compteB = compteB;
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
				+ ", ribDest=" + ribDest + ", compteB=" + compteB + "]";
	}

	

}