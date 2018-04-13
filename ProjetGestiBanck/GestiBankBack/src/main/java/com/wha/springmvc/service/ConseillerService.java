package com.wha.springmvc.service;

import java.util.Collection;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.Conseiller;

public interface ConseillerService {

	Conseiller createConseiller(Conseiller conseiller, int id_admin);

	Conseiller updateConseiller(Conseiller conseiller);

	Conseiller updateLoginMpConseiller(Conseiller conseiller, String login, String motDePasse);

	Conseiller findById(int id);

	Conseiller findByName(String name);

	Collection<Conseiller> findAllConseillers();

	void deleteConseillerById(int id);

	Collection<Client> findListClientsForThisConseiller(int id);

}
