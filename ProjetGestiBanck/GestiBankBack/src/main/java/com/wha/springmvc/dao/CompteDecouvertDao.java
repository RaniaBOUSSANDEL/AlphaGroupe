package com.wha.springmvc.dao;

import java.util.Date;
import java.util.List;
import com.wha.springmvc.model.CompteAvecDecouv;


public interface CompteDecouvertDao {
	CompteAvecDecouv findById(int id);
	CompteAvecDecouv findByDateCreation(Date date);
	CompteAvecDecouv findByNumeroCompte(long numeroCompte);
	void save(CompteAvecDecouv compteAvecDecouv);
	void deleteCompteDeById(int id);
	List<CompteAvecDecouv> findAllCompteDecouvert();
	void deleteAllCompteDecouvert();

}