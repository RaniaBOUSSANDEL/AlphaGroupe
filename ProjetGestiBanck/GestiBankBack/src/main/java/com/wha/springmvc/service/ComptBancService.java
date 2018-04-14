package com.wha.springmvc.service;

import java.util.List;

import com.wha.springmvc.model.CompteBancaire;
import com.wha.springmvc.model.Transaction;

public interface ComptBancService {
	//Creer Compte
	void save(CompteBancaire compteBancaire, int client_id);
	//Touver un compte à partir de son numero de compte
	CompteBancaire findByNumeroCompte(long numeroCompte);
	List <Transaction > findTransactionsBynumCompte(long numCompte);
	List<CompteBancaire> findAllCompteBanc();
	List<CompteBancaire> findAllCompteBancByIdCl(int idCl);
	

}
