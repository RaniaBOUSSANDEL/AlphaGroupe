package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.model.Visiteur;

public interface VisiteurDao {
	
	Visiteur findById(int id);
	Visiteur findByName(String name);
	void save(Visiteur visiteur );
	void deleteVisiteurById(int id);
	List<Visiteur> findAllVisiteurs();
	void deleteAllVisiteurs();

}