package com.wha.springmvc.service;

import com.wha.springmvc.model.Transaction;

public interface DebitService {

	void save(Transaction debit, long numero_Compte);

}
