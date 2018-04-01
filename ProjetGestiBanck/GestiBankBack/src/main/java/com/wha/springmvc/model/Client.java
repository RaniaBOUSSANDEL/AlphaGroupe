package com.wha.springmvc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("CL")
@Table(name = "client")
public class Client extends User {

	private int nbEnfants;
	private String situationMaritale;

	// ok
	@ManyToOne
	@JoinColumn(name = "conseiller_id") // le nom de la colonne cree dans la base de donnee
	private Conseiller conseiller = new Conseiller();

	//ok
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CompteBancaire> comptesBancaire = new ArrayList<CompteBancaire>();
	

	//ok
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DemandeChequier> demandesChequier = new ArrayList<DemandeChequier>() ;

	
	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public List<CompteBancaire> getComptesBancaire() {
		return comptesBancaire;
	}

	public void setComptesBancaire(List<CompteBancaire> comptesBancaire) {
		this.comptesBancaire = comptesBancaire;
	}

	public List<DemandeChequier> getDemandesChequier() {
		return demandesChequier;
	}

	public void setDemandesChequier(List<DemandeChequier> demandesChequier) {
		this.demandesChequier = demandesChequier;
	}

	public int getNbEnfants() {
		return nbEnfants;
	}

	public void setNbEnfants(int nbEnfants) {
		this.nbEnfants = nbEnfants;
	}

	public String getSituationMaritale() {
		return situationMaritale;
	}

	public void setSituationMaritale(String situationMaritale) {
		this.situationMaritale = situationMaritale;
	}

	// @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	// public List<CompteBancaire> getComptesBancaire() {
	// return comptesBancaire;
	// }

	public Client() {
		super();
	}

	public Client(String nom, String prenom, String adresse, String email, String numTel, String login,
			String motDePasse, int nbEnfants, String situationMaritale) {
		super(nom, prenom, adresse, email, numTel, login, motDePasse);
		this.nbEnfants = nbEnfants;
		this.situationMaritale = situationMaritale;

	}

	@Override
	public String toString() {
		return "Client [nbEnfants=" + nbEnfants + ", situationMaritale=" + situationMaritale + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + nbEnfants;
		result = prime * result + ((situationMaritale == null) ? 0 : situationMaritale.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (nbEnfants != other.nbEnfants)
			return false;
		if (situationMaritale == null) {
			if (other.situationMaritale != null)
				return false;
		} else if (!situationMaritale.equals(other.situationMaritale))
			return false;
		return true;
	}

}
