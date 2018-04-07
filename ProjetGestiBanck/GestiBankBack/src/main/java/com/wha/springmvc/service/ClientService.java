package com.wha.springmvc.service;

import java.util.List;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.Conseiller;
import com.wha.springmvc.model.Visiteur;

public interface ClientService {
	
	Client createClient(Visiteur visiteur, int id_cons);

	Client updateClient(Client client);
	
	Client findById(int id);
	Client findByName(String name);
	Conseiller findConseillerForThisClient(int idClient);
	List<Client> findAllClients();
	
	void deleteClientById(int id);
	void deleteAllClients();

	Client updateConseillerForThisClient(Client client, int id_cons);

	Client updateLoginMpClient(Client client, String login, String MotDePasse);
	
}
