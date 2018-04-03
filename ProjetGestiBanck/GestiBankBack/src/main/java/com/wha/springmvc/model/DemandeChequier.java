package com.wha.springmvc.model;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("DCh")
@Table(name = "demandeChequier")
public class DemandeChequier extends Demande implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3748437513591594504L;

	//ok
	@ManyToOne
	@JoinColumn(name = "conseiller_id")// le nom de la colonne cree dans la base de donnee
	private Conseiller conseiller;

	//ok
	@ManyToOne
	@JoinColumn(name = "client_id")// le nom de la colonne cree dans la base de donnee
	private Client client;

	public DemandeChequier() {
		// TODO Auto-generated constructor stub
	}

	public DemandeChequier(int idDemande, Date dateDemande, String etatDemande) {
		super(idDemande, dateDemande, etatDemande);
		// TODO Auto-generated constructor stub
	}

	
	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "DemandeChequier []";
	}
	
}
