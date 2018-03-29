package com.wha.springmvc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("CD")
@Table(name="Compte avec Decouvert")
public class CompteAvecDecouv extends CompteBancaire  {
	private int montantDecouvert; // montant inferieur à 0.4 des operations de credit
	private int dureeDecouvert;
	private double tauxDebiteur;

	public CompteAvecDecouv() {
		super();
	}

	

	public CompteAvecDecouv(int montantDecouvert, int dureeDecouvert, double tauxDebiteur) {
		
		this.montantDecouvert = 0;
		this.dureeDecouvert =  0;
		this.tauxDebiteur = 0.18;
	}

	

	public double getTauxDebiteur() {
		return tauxDebiteur;
	}



	public void setTauxDebiteur(double tauxDebiteur) {
		this.tauxDebiteur = tauxDebiteur;
	}



	public int getMontantDecouvert() {
		return montantDecouvert;
	}

	public void setMontantDecouvert(int montantDecouvert) {
		this.montantDecouvert = montantDecouvert;
	}

	public int getDureeDecouvert() {
		return dureeDecouvert;
	}

	public void setDureeDecouvert(int dureeDecouvert) {
		this.dureeDecouvert = dureeDecouvert;
	}



	@Override
	public String toString() {
		return "CompteAvecDecouv [montantDecouvert=" + montantDecouvert + ", dureeDecouvert=" + dureeDecouvert
				+ ", tauxDebiteur=" + tauxDebiteur + "]";
	}

	
}
