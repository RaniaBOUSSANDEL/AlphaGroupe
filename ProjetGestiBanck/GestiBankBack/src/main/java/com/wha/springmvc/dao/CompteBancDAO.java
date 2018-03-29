package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.model.CompteBancaire;


public interface CompteBancDAO {
	CompteBancaire findById(int id);
	CompteBancaire findByName(String name);
	void save(CompteBancaire compteBancaire);
	void deleteCompteBancById(int id);
	List<CompteBancaire> findAllCompteBanc();
	void deleteAllCompteBanc();

}
