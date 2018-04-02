package com.wha.springmvc.dao;

import java.util.Date;
import java.util.List;
import com.wha.springmvc.model.CompteCourant;

public interface CompteCouDao {
	CompteCourant findById(int id);
	CompteCourant findByDateCreation(Date date);
	CompteCourant findByNumeroCompte(long numeroCompte);
	void save(CompteCourant compteCourant);
	void deleteCompteCouById(int id);
	List<CompteCourant> findAllCompteCourant();
	void deleteAllCompteCourant();

}