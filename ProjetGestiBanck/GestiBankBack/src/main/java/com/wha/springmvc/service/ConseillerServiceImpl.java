package com.wha.springmvc.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.springmvc.dao.ConseillerDao;
import com.wha.springmvc.dao.UserDao;
import com.wha.springmvc.model.Administrateur;
import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.Conseiller;
import com.wha.springmvc.model.User;

@Service("conseillerService")
@Transactional
public class ConseillerServiceImpl implements ConseillerService {

	@Autowired
	private ConseillerDao dao;

	@Autowired
	private UserDao Udao;

	@Override
	public Conseiller createConseiller(Conseiller conseiller, int id_admin) {

		User ad = Udao.findById(id_admin);// a changer par administrateur
		Administrateur add = (Administrateur) ad;
		add.getConseillers().add(conseiller);// ajouter le conseiller a liste des conseillers de l'admin
		conseiller.setAdministrateur(add);// ajouter l'admin pour ce conseiller
		dao.save(conseiller);
		return conseiller;

	}

	// mise a jour des informations basiques, utilisé par le admin
	@Override
	public Conseiller updateConseiller(Conseiller conseiller) {

		Conseiller co = dao.findById(conseiller.getId());

		if (co != null) {
			co.setAdresse(conseiller.getAdresse());
			co.setEmail(conseiller.getEmail());
			co.setNom(conseiller.getNom());
			co.setNumTel(conseiller.getNumTel());
			co.setPrenom(conseiller.getPrenom());
		}
		dao.save(co);

		return co;
	}

	// mise a jour login et mot de passe d'un conseiller, utilisé par le admin
	@Override
	public Conseiller updateLoginMpConseiller(Conseiller conseiller, String login, String motDePasse) {

		Conseiller co = dao.findById(conseiller.getId());

		if (co != null) {
			co.setLogin(login);
			co.setMotDePasse(motDePasse);
		}
		dao.save(co);

		return co;
	}

	@Override
	public Conseiller findById(int id) {

		return dao.findById(id);
	}

	@Override
	public Conseiller findByName(String name) {

		return dao.findByName(name);
	}

	@Override
	public Collection<Conseiller> findAllConseillers() {
		return dao.findAllConseillers();
	}

	@Override
	public void deleteConseillerById(int id) {

		dao.deleteConseillerById(id);
	}

	@Override
	public Collection<Client> findListClientsForThisConseiller(int id) {
		Conseiller co = dao.findById(id);

		return co.getClients();
	}

}
