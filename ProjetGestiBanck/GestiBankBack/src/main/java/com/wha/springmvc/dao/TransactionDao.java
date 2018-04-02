package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.model.CompteBancaire;
import com.wha.springmvc.model.Transaction;

public interface TransactionDao {
	Transaction findById(int id);
	Transaction  findByTypeCompte(CompteBancaire cb);
	void save(Transaction  compteBancaire);
	void deleteCompteBancById(int id);
	List<CompteBancaire> findAllCompteBanc();
}