package com.wha.springmvc.dao;

import java.util.Date;
import java.util.List;

import com.wha.springmvc.model.Transaction;

public interface TransactionDao {
	Transaction findTById(int id);
	Transaction  findTByDateDeffet(Date date);
	void save(Transaction  transaction);
	
	List<Transaction> findAllTransaction();
}