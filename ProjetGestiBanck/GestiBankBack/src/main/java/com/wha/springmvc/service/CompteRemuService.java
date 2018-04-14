package com.wha.springmvc.service;

import com.wha.springmvc.model.CompteRemunerateur;

public interface CompteRemuService {
	void save(CompteRemunerateur  compteRemunerateur, int id_Cl);
	CompteRemunerateur findByNumeroCompte(long numeroCompte);

}
