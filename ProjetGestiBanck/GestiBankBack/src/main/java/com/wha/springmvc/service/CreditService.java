package com.wha.springmvc.service;

import com.wha.springmvc.model.Transaction;

public interface CreditService {
	void save(Transaction credit, long numeroCompte);
}
