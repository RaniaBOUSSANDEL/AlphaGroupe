package com.wha.springmvc.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@DiscriminatorValue("CL")
@Table(name = "client")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Client extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -617070553473600148L;

	
	private int nbEnfants;
	
	
	private String situationMaritale;
	
	/**documents complementaires**/
	
//	String justificatifDomicile;
//	String justificatifSalaire;
//	String pieceIdentite;
	
	/**fin**/

	// ok
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "conseiller_id") // le nom de la colonne cree dans la base de donnee
	private Conseiller conseiller;

	//ok
	@JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private Collection<CompteBancaire> comptesBancaire;
	

	//ok
	@JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private Collection<DemandeChequier> demandesChequier;//a changer par demande

	
	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public Collection<CompteBancaire> getComptesBancaire() {
		return comptesBancaire;
	}

	public void setComptesBancaire(Collection<CompteBancaire> comptesBancaire) {
		this.comptesBancaire = comptesBancaire;
	}

	public Collection<DemandeChequier> getDemandesChequier() {
		return demandesChequier;
	}

	public void setDemandesChequier(Collection<DemandeChequier> demandesChequier) {
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
		return super.toString() + "Client [nbEnfants=" + nbEnfants + ", situationMaritale=" + situationMaritale + "]";
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
