package com.wha.springmvc.dao;

import java.util.Date;
import java.util.List;

import com.wha.springmvc.model.Transaction;

public interface TransactionDao {
	void save(Transaction  transaction);
	Transaction findTransactionByNumCompt (long  numeroCompte);
	Transaction findTById(int id);
	Transaction  findTByDateDeffet(Date date);
	List<Transaction> findAllTransaction();
}
