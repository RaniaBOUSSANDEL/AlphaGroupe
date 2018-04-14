package com.wha.springmvc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.springmvc.dao.CompteBancDAO;
import com.wha.springmvc.model.CompteBancaire;
import com.wha.springmvc.model.Transaction;
@Service("creditService")
@Transactional
public class CreditServiceImpl implements CreditService {


	@Autowired
	private CompteBancDAO daoC;

	@Override
	public void save(Transaction credit, long numeroCompte) {
		CompteBancaire cb = daoC.findByNumeroCompte(numeroCompte);
		if (cb != null) {
			float oldSolde = cb.getSolde();
			float newsolde = oldSolde + credit.getMontant();
			cb.setSolde(newsolde);
			cb.getTransactions().add(credit);
			//credit.setCompteB(cb);
			daoC.save(cb);
		}
		
	}

}
