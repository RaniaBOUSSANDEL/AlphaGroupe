package com.wha.springmvc.service;


import java.util.List;

import com.wha.springmvc.model.Transaction;

public interface TransactionService {
	//Creer une transaction
	void save(Transaction transaction, long Numero_Compte);
	//Touver une transaction à partir du son numero de compte
	Transaction findTransactionByNumCompt(long numeroCompte);
	List<Transaction> findAllTransaction();
}
