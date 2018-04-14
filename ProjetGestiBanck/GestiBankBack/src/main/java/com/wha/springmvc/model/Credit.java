package com.wha.springmvc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("C")
@Table(name="Credit")
public class Credit extends Transaction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4383008988645101308L;

	public Credit() {
		super();
	}

}
