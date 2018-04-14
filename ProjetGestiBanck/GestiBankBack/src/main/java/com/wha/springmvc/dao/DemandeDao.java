package com.wha.springmvc.dao;

import java.util.Date;
import java.util.List;

import com.wha.springmvc.model.Demande;

public interface DemandeDao {
	
	Demande findById(int id);
	List<Demande>  findByDateDemande(Date date);
	List<Demande>  findByEtatDemande(String etatDemande);
	void save(Demande demande);
	void deleteDemandeById(int id);
	List<Demande> findAllDemandes();
	void deleteAllDemandes();

}