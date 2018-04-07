package com.wha.springmvc.dao;

<<<<<<< HEAD
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
=======
import java.util.Date;
import java.util.List;

import com.wha.springmvc.model.Transaction;

public interface TransactionDao {
	Transaction findTById(int id);
	Transaction  findTByDateDeffet(Date date);
	void save(Transaction  transaction);
	
	List<Transaction> findAllTransaction();
}
>>>>>>> branch 'master' of https://github.com/RaniaBOUSSANDEL/AlphaGroupe.git
