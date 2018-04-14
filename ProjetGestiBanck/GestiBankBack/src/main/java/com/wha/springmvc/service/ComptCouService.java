package com.wha.springmvc.service;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.CompteCourant;

public interface ComptCouService {
	void save(CompteCourant compteCourant, int id_client);
	CompteCourant findByNumeroCompte(long numCompte);
}
