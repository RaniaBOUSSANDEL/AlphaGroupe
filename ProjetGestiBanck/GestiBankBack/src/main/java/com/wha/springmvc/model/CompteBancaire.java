package com.wha.springmvc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typeCompte")
@DiscriminatorValue("CB")
@Table(name = "CompteBancaire")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class CompteBancaire implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5642039818092510654L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private long numCompte;
	private Date dateCreation;
	private int solde;
	
	//ok
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id") // le nom de la colonne cree dans la base de donnee
	private Client client;
	
	//ok
	@JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "compteB", fetch = FetchType.LAZY, cascade= {CascadeType.ALL})
	private Collection<Transaction> transactions;


	public CompteBancaire() {
		id = 0;
	}

	public CompteBancaire(int id, long numCompte, Date dateCreation, int solde) {

		this.id = id;
		this.numCompte = numCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	

	public Collection<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Collection<Transaction> transactions) {
		this.transactions = transactions;
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