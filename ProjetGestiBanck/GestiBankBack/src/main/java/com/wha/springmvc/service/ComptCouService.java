package com.wha.springmvc.service;

import com.wha.springmvc.model.CompteCourant;

public interface ComptCouService {
	void save(CompteCourant compteCourant);
	CompteCourant findByNumeroCompte(long numCompte);
}
