package com.wha.springmvc.dao;



import java.util.List;

import com.wha.springmvc.model.Conseiller;

public interface ConseillerDao {
	
	void save(Conseiller conseiller);
	Conseiller updateConseiller(Conseiller conseiller);
	
	Conseiller findById(int id);
	Conseiller findByName(String name);
	Conseiller findByMatricule(int matricule);
	List<Conseiller> findAllConseillers();
	
	void deleteConseillerById(int id);
	void deleteAllConseillers();
	
	

}
