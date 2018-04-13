package com.wha.springmvc.service;

import java.util.Collection;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.CompteBancaire;
import com.wha.springmvc.model.Conseiller;
import com.wha.springmvc.model.Visiteur;

public interface ClientService {
	
	Client createClient(Visiteur visiteur, int id_cons);

	Client updateClient(Client client);
	
	Client findById(int id);
	Client findByName(String name);
	Conseiller findConseillerForThisClient(int idClient);
	Collection<Client> findAllClients();
	
	void deleteClientById(int id);
	void deleteAllClients();

	Client updateConseillerForThisClient(Client client, int id_cons);

	Client updateLoginMpClient(Client client, String login, String MotDePasse);

	Collection<CompteBancaire> findListComptesForThisClient(int id);
	
}
