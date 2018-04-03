package com.wha.springmvc.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("CO")
@Table(name = "conseiller")
public class Conseiller extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6577359248268916137L;

	
	private int matricule;

	
	private Date dateDebutContrat;

	// ok
	@ManyToOne
	@JoinColumn(name = "administrateur_id") // le nom de la colonne cree dans la base de donnee
	private Administrateur administrateur;

	// ok
	@JsonIgnore
	@OneToMany(mappedBy = "conseiller", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private Collection<Client> clients;

	// ok
	@JsonIgnore
	@OneToMany(mappedBy = "conseiller", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private Collection<DemandeChequier> demandesChequier;

	// ok
	@JsonIgnore
	@OneToMany(mappedBy = "conseiller", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private Collection<DemandeOuvertureCompte> demandesOuvertureCompte;

	public Conseiller() {
		super();

	}

	public Conseiller(String nom, String prenom, String adresse, String email, String numTel, String login,
			String motDePasse, int matricule, Date dateDebutContrat) {
		super(nom, prenom, adresse, email, numTel, login, motDePasse);
		this.matricule = matricule;
		this.dateDebutContrat = dateDebutContrat;

	}

	public Administrateur getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}

	public Collection<DemandeChequier> getDemandesChequier() {
		return demandesChequier;
	}

	public void setDemandesChequier(Collection<DemandeChequier> demandesChequier) {
		this.demandesChequier = demandesChequier;
	}

	public Collection<DemandeOuvertureCompte> getDemandesOuvertureCompte() {
		return demandesOuvertureCompte;
	}

	public void setDemandesOuvertureCompte(Collection<DemandeOuvertureCompte> demandesOuvertureCompte) {
		this.demandesOuvertureCompte = demandesOuvertureCompte;
	}

	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	public Date getDateDebutContrat() {
		return dateDebutContrat;
	}

	public void setDateDebutContrat(Date dateDebutContrat) {
		this.dateDebutContrat = dateDebutContrat;
	}

	public Collection<Client> getClients() {
		return clients;
	}

	 
	public void setClients(Collection<Client> cls) {
		clients = cls;
	}

	 

	@Override
	public String toString() {
		return "Conseiller [matricule=" + matricule + ", dateDebutContrat=" + dateDebutContrat + "]";
	}

}
