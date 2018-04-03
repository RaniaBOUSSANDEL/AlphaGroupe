package com.wha.springmvc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("V")
@Table(name="Virement")
public class Virement extends Transaction{
	public long ribDest;

	public Virement() {
		
	}

	public Virement(long rib) {
		super();
		this.ribDest = rib;
	}

	public long getRibDest() {
		return ribDest;
	}

	public void setRibDest(long ribDest) {
		this.ribDest = ribDest;
	}

	@Override
	public String toString() {
		return "Virement [ribDest=" + ribDest + "]";
	}

	
	
}
