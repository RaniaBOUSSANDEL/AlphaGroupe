package com.wha.springmvc.service;

import com.wha.springmvc.model.CompteAvecDecouv;

public interface ComptDecouService {
	void save(CompteAvecDecouv compteDecouvert, int id_Cl, float revenu);
	CompteAvecDecouv findByNumeroCompte(long numeroCompte);
}
