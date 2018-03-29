package com.wha.springmvc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("CR")
@Table(name="Compte Remunerateur")
public class CompteRemunerateur extends CompteBancaire  {
	private double tauxRemunerateur;
	private int seuilMinimum; // montant fixé par le conseiller
	private int dureeRemuneration;
	
	public CompteRemunerateur() {
		super();
	}

	

	public CompteRemunerateur(double tauxRemunerateur, int seuilMinimum, int dureeRemuneration) {
		super();
		this.tauxRemunerateur = 0.02;
		this.seuilMinimum = 0;
		this.dureeRemuneration =  0;
	}

	public int getDureeRemuneration() {
		return dureeRemuneration;
	}



	public void setDureeRemuneration(int dureeRemuneration) {
		this.dureeRemuneration = dureeRemuneration;
	}



	public double getTauxRemunerateur() {
		return tauxRemunerateur;
	}

	public void setTauxRemunerateur(double tauxRemunerateur) {
		this.tauxRemunerateur = tauxRemunerateur;
	}

	public int getSeuilMinimum() {
		return seuilMinimum;
	}

	public void setSeuilMinimum(int seuilMinimum) {
		this.seuilMinimum = seuilMinimum;
	}



	@Override
	public String toString() {
		return "CompteRemunerateur [tauxRemunerateur=" + tauxRemunerateur + ", seuilMinimum=" + seuilMinimum
				+ ", dureeRemuneration=" + dureeRemuneration + "]";
	}

	
	
}
