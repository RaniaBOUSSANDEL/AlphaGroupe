package com.wha.springmvc.service;

import java.util.List;

import com.wha.springmvc.model.Visiteur;

public interface VisiteurService {
	
	Visiteur createVisiteur(Visiteur visiteur);
	void deleteVisiteurById(int id);
	Visiteur findById(int id);
	Visiteur findByNom(String nom);
	Visiteur updateVisiteur(Visiteur visiteur);
	public Visiteur isVisiteurExist(Visiteur visiteur);
	List<Visiteur> findAllVisiteurs();
	

}