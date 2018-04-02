package com.wha.springmvc.dao;

import java.util.List;
import com.wha.springmvc.model.CompteBancaire;
import com.wha.springmvc.model.Transaction;

public class TransactionDaoImp extends Transaction implements TransactionDao {

	@Override
	public Transaction findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction findByTypeCompte(CompteBancaire cb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Transaction compteBancaire) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCompteBancById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CompteBancaire> findAllCompteBanc() {
		// TODO Auto-generated method stub
		return null;
	}

}