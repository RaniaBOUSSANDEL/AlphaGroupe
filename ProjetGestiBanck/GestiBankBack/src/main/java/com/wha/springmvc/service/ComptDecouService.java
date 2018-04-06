package com.wha.springmvc.service;

import com.wha.springmvc.model.CompteAvecDecouv;

public interface ComptDecouService {
	void save(CompteAvecDecouv compteDecouvert);
	CompteAvecDecouv findByNumeroCompte(long numeroCompte);
}
