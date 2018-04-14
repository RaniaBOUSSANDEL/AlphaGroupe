package com.wha.springmvc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.springmvc.dao.CompteBancDAO;
import com.wha.springmvc.model.CompteAvecDecouv;
import com.wha.springmvc.model.CompteBancaire;
import com.wha.springmvc.model.CompteCourant;
import com.wha.springmvc.model.CompteRemunerateur;
import com.wha.springmvc.model.Transaction;

@Service("debitService")
@Transactional
public class DebitServImpl implements DebitService {


	@Autowired
	private CompteBancDAO daoCB;

	@Override
	public void save(Transaction debit, long numero_Compte) {

		CompteBancaire cb = daoCB.findByNumeroCompte(numero_Compte);
		System.out.println(cb.toString());

		if (cb != null) {
			float oldSolde = cb.getSolde();
			float newSolde = oldSolde - debit.getMontant();
			if (cb instanceof CompteCourant || cb instanceof CompteRemunerateur) {
				if (cb.getSolde() == 0 || newSolde< 0 ) {
					System.out.println("operation refusée");
				} else {
					cb.setSolde(newSolde);
					cb.getTransactions().add(debit);
					//debit.setCompteB(cb);
					daoCB.save(cb);
					
				}
			} else if (cb instanceof CompteAvecDecouv) {
				if (newSolde > ((CompteAvecDecouv) cb).getMontantDecouvert()) {
					System.out.println("operation refusée");
				} else {
					//mettre a jour cummule et dateDecouvert 
					cb.setSolde(newSolde);
					cb.getTransactions().add(debit);
					//debit.setCompteB(cb);
					daoCB.save(cb);
				}
			}
		}
		
	}
}
