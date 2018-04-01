package com.wha.springmvc.model;



import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("DCh")
@Table(name = "demandeChequier")
public class DemandeChequier extends Demande {

	public DemandeChequier() {
		// TODO Auto-generated constructor stub
	}

	public DemandeChequier(int idDemande, Date dateDemande, String etatDemande) {
		super(idDemande, dateDemande, etatDemande);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DemandeChequier []";
	}
	
}
