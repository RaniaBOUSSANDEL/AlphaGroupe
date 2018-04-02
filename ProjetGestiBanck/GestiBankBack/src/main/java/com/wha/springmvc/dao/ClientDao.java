package com.wha.springmvc.dao;

import java.util.List;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.Conseiller;
import com.wha.springmvc.model.Visiteur;

public interface ClientDao {
	
	void save(Client cl);
	
	Client findById(int id);
	Client findByName(String name);
	Conseiller findConseillerByClient(int idClient);
	List<Client> findAllClients();
	
	void deleteClientById(int id);
	void deleteAllClients();
}
