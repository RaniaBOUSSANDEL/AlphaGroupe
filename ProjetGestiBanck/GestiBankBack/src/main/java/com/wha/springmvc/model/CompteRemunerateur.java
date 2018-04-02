


package com.wha.springmvc.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("CR")

public class CompteRemunerateur extends CompteBancaire implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4503469016582879890L;
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

