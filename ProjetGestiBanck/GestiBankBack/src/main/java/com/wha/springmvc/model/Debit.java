package com.wha.springmvc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("D")
@Table(name="Debit")
public class  Debit extends Transaction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5310403493883638377L;

	public Debit() {
		super();
		
	}

}
