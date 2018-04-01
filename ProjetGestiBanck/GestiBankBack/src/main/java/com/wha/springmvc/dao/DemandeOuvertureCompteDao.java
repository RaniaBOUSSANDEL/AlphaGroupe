package com.wha.springmvc.dao;

import java.util.Date;
import java.util.List;

import com.wha.springmvc.model.DemandeOuvertureCompte;

public interface DemandeOuvertureCompteDao {
	List<DemandeOuvertureCompte>  findByDateAffectation(Date date);
	List<DemandeOuvertureCompte>  findByEtatAffectation(String etatAffectation);

}
