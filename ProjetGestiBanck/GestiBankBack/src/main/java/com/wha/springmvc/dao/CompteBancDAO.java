package com.wha.springmvc.dao;

import java.util.Date;
import java.util.List;

import com.wha.springmvc.model.CompteBancaire;


public interface CompteBancDAO {
	CompteBancaire findById(int id);
	CompteBancaire findCBByDateCreation(Date date);
	CompteBancaire findCBByNumeroCompte(long numeroCompte);
	void save(CompteBancaire compteBancaire);
	void deleteCompteBancById(int id);
	List<CompteBancaire> findAllCompteBanc();
}
