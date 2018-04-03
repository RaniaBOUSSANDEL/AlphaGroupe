package com.wha.springmvc.dao;

import java.util.Date;
import java.util.List;
import com.wha.springmvc.model.CompteRemunerateur;

public interface CompteRemuDao {
	CompteRemunerateur findById(int id);
	CompteRemunerateur findByDateCreation(Date date);
	CompteRemunerateur findByNumeroCompte(long numeroCompte);
	void save(CompteRemunerateur compteRemunerateur);
	void deleteCompteRemuById(int id);
	List<CompteRemunerateur> findByAllComptRemu();
	void deleteAllCompteRemu();
	
}