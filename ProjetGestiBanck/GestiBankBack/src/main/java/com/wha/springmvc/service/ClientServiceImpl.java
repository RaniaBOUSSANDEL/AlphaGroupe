package com.wha.springmvc.service;

import java.util.Collection;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.springmvc.dao.ClientDao;
import com.wha.springmvc.dao.UserDao;
import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.CompteBancaire;
import com.wha.springmvc.model.Conseiller;
import com.wha.springmvc.model.User;
import com.wha.springmvc.model.Visiteur;

@Service("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDao dao;

	@Autowired
	private UserDao Udao;

	@Override
	public Client createClient(Visiteur visiteur, int id_cons) {
		String login = "login";
		String motDePasse = "motDePasse";
		Client client = new Client(visiteur.getNom(), visiteur.getPrenom(), visiteur.getAdresse(), visiteur.getEmail(),
				visiteur.getNumTel(), login, motDePasse, visiteur.getNbEnfants(), visiteur.getSituationMaritale());
		// Conseiller co = new Conseiller("nom", "prenom", "adresse", "email", "numTel",
		// login, motDePasse, 354, new Date());
		// co.setId(2);
		User co = Udao.findById(id_cons);// a changer par conseiller
		Conseiller coo = (Conseiller) co;
		coo.getClients().add(client);// ajouter le client a liste des client du conseiller
		client.setConseiller(coo);// ajouter le conseiller pour ce client
		dao.save(client);
		return client;

	}

	// mise a jour des informations basiques, utilisé par le conseiller
	@Override
	public Client updateClient(Client client) {

		Client cl = dao.findById(client.getId());

		if (cl != null) {
			cl.setAdresse(client.getAdresse());
			cl.setEmail(client.getEmail());
			cl.setNbEnfants(client.getNbEnfants());
			cl.setNom(client.getNom());
			cl.setNumTel(client.getNumTel());
			cl.setPrenom(client.getPrenom());
			cl.setSituationMaritale(client.getSituationMaritale());
		}
		dao.save(cl);

		return cl;
	}

	// mise a jour login et mot de passe d'un client, utilisé par le conseiller
	@Override
	public Client updateLoginMpClient(Client client, String login, String motDePasse) {

		Client cl = dao.findById(client.getId());

		if (cl != null) {
			cl.setLogin(login);
			cl.setMotDePasse(motDePasse);
		}
		dao.save(cl);

		return cl;
	}

	// mise a jour pour affecter ce client a un autre conseiller
	@Override
	public Client updateConseillerForThisClient(Client client, int id_cons) {
		Client cl = dao.findById(client.getId());
		User co = Udao.findById(id_cons);// a changer par conseiller
		Conseiller coo = (Conseiller) co;

		if (cl != null && coo != null) {
			cl.setConseiller(coo);
		}
		dao.save(cl);
		return cl;
	}

	@Override
	public Client findById(int id) {

		return dao.findById(id);
	}

	@Override
	public Client findByName(String name) {

		return dao.findByName(name);
	}

	@Override
	public Conseiller findConseillerForThisClient(int idClient) {

		return dao.findConseillerByClient(idClient);
	}

	@Override
	public Collection<CompteBancaire> findListComptesForThisClient(int id) {
		Client cl = dao.findById(id);
		
		return cl.getComptesBancaire();
	}

	@Override
	public Collection<Client> findAllClients() {
		return dao.findAllClients();
	}

	@Override
	public void deleteClientById(int id) {

		dao.deleteClientById(id);
	}

	@Override
	public void deleteAllClients() {
		// TODO Auto-generated method stub

	}

}
