package com.wha.springmvc.model;

import java.util.ArrayList;
import java.util.Date;
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
@DiscriminatorValue("CO")
@Table(name = "conseiller")
public class Conseiller extends User {

	
	private int matricule;
	private Date dateDebutContrat;
	
	//ok
	@OneToMany(mappedBy = "conseiller", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Client> clients = new ArrayList<Client>();
	
	//ok
	@ManyToOne
	@JoinColumn(name = "administrateur_id")// le nom de la colonne cree dans la base de donnee
	private Administrateur administrateur;
	
	//ok
	@OneToMany(mappedBy = "conseiller", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<DemandeChequier> demandesChequier;
	
	//ok
	@OneToMany(mappedBy = "conseiller", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<DemandeOuvertureCompte> demandesOuvertureCompte;

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

	public List<DemandeChequier> getDemandesChequier() {
		return demandesChequier;
	}

	public void setDemandesChequier(List<DemandeChequier> demandesChequier) {
		this.demandesChequier = demandesChequier;
	}

	public List<DemandeOuvertureCompte> getDemandesOuvertureCompte() {
		return demandesOuvertureCompte;
	}

	public void setDemandesOuvertureCompte(List<DemandeOuvertureCompte> demandesOuvertureCompte) {
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
	
	
	public List<Client> getClients() {
		return clients;
	}
	
//	public List<DemandeChequier> getDemandesChequier() {
//		return demandesChequier;
//	}

	
	public void setClients(List<Client> cls) {
		clients = cls;
	}

//	public List<DemandeOuvertureCompte> getDemandesOuvertureCompte() {
//		return demandesOuvertureCompte;
//	}
//
//	public void setDemandesOuvertureCompte(List<DemandeOuvertureCompte> demandesOuvertureCompte) {
//		this.demandesOuvertureCompte = demandesOuvertureCompte;
//	}

	@Override
	public String toString() {
		return "Conseiller [matricule=" + matricule + ", dateDebutContrat=" + dateDebutContrat + "]";
	}

	
}
