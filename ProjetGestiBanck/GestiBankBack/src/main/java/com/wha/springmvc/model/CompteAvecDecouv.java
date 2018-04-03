package com.wha.springmvc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("CD")

public class CompteAvecDecouv extends CompteBancaire  {
	private int montantDecouvert; // montant inferieur à 0.4 des operations de credit
	private int dureeDecouvert;
	private double tauxDebiteur;
	private int cummul;
	public CompteAvecDecouv() {
		super();
	}

	

	public CompteAvecDecouv(int montantDecouvert, int dureeDecouvert, double tauxDebiteur, int cummul) {
		
		this.montantDecouvert = 0;
		this.dureeDecouvert =  0;
		this.tauxDebiteur = 0.18;
		this.cummul = 0;
	}

	

	public int getCummul() {
		return cummul;
	}



	public void setCummul(int cummul) {
		this.cummul = cummul;
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
				+ ", tauxDebiteur=" + tauxDebiteur + ", cummul=" + cummul + "]";
	}


}
