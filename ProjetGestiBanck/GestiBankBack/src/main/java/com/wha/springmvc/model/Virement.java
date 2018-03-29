package com.wha.springmvc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("V")
@Table(name="Virement")
public class Virement extends Transaction{
	public long rib;

	public Virement() {
		
	}

	public Virement(long rib) {
		super();
		this.rib = rib;
	}

	public long getRib() {
		return rib;
	}

	public void setRib(long rib) {
		this.rib = rib;
	}

	@Override
	public String toString() {
		return "Virement [rib=" + rib + "]";
	}
	
}
