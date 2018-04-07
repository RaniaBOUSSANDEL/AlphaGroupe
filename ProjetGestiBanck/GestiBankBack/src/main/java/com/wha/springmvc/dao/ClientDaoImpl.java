package com.wha.springmvc.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.Conseiller;
import com.wha.springmvc.model.User;
import com.wha.springmvc.model.Visiteur;

@Repository("clientDao")
public class ClientDaoImpl extends AbstractDao<Integer, Client> implements ClientDao {

//	@Override
//	public void save(Visiteur visiteur) {
//		// generation automatique de login et mp : a faire
//		String login = "login";
//		String motDePasse = "motDePasse";
//		Client client = new Client(visiteur.getNom(), visiteur.getPrenom(), visiteur.getAdresse(), visiteur.getEmail(),
//				visiteur.getNumTel(), login, motDePasse, visiteur.getNbEnfants(), visiteur.getSituationMaritale());
//		persist(client);
//	}
	
	@Override
	public void save(Client cl) {
		persist(cl);
		
	}


	@Override
	public Client findById(int id) {
		Client client = getByKey(id);
		return client;
	}

	@Override
	public Client findByName(String name) {
		System.out.println("name=" + name);
		try {
			Client client = (Client) getEntityManager().createQuery("SELECT c FROM Client c where c.nom LIKE :name")
					.setParameter("name", name).getSingleResult();
			return client;
		} catch (NoResultException ex) {
			return null;
		}
	}

	@Override
	public Conseiller findConseillerByClient(int idClient) {
		System.out.println("idClient=" + idClient);
		try {
			Client client = findById(idClient);
			return client.getConseiller();
		} catch (NoResultException ex) {
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findAllClients() {

		List<Client> clients = (List<Client>) getEntityManager()
				.createQuery("SELECT c FROM Client c ORDER BY c.nom ASC ").getResultList();

		return clients;
	}

	@Override
	public void deleteClientById(int id) {
		Client client = getByKey(id);
		delete(client);
	}

	@Override
	public void deleteAllClients() {
		// TODO Auto-generated method stub

	}


	

}
