package com.wha.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.springmvc.dao.CompteBancDAO;
import com.wha.springmvc.dao.TransactionDao;
import com.wha.springmvc.model.CompteBancaire;
import com.wha.springmvc.model.Credit;
import com.wha.springmvc.model.Debit;
import com.wha.springmvc.model.Transaction;
@Service("transactionService")
@Transactional
public class TransactionServImpl implements TransactionService {

	@Autowired
	private TransactionDao daoT;
	@Autowired
	private CompteBancDAO daoCB;
	@Autowired
	private DebitService debitService;
	@Autowired
	private CreditService creditService;
	

	@Override
	public void save(Transaction transaction, long numero_Compte) {
		
		CompteBancaire cb1 = daoCB.findByNumeroCompte(numero_Compte);
		
		System.out.println(cb1.toString());
		
		if (cb1 != null ) {
			
			debitService.save(transaction, numero_Compte);
			creditService.save(transaction, transaction.getRibDest());
			transaction.setCompteB(cb1);
			daoT.save(transaction);
		}	
			
	}

	@Override
	public Transaction findTransactionByNumCompt(long numeroCompte) {
	
		return daoT.findTransactionByNumCompt(numeroCompte);
	}
	
	@Override
	public List<Transaction> findAllTransaction(){
		return daoT.findAllTransaction();
		
	}

}
