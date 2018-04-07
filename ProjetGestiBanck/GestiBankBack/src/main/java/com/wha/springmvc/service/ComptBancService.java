package com.wha.springmvc.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.wha.springmvc.model.CompteBancaire;

public interface ComptBancService {
	//Creer Compte
	void save(CompteBancaire compteBancaire, int client_id);
	//Touver un compte à partir de son numero de compte
	CompteBancaire findByNumeroCompte(long numeroCompte);
	

}
