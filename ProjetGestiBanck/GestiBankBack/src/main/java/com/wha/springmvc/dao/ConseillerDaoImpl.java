package com.wha.springmvc.dao;

import java.util.List;
import javax.persistence.NoResultException;
import org.springframework.stereotype.Repository;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.Conseiller;

@Repository("conseillerDao")
public class ConseillerDaoImpl extends AbstractDao<Integer, Conseiller> implements ConseillerDao {

	@Override
	public void save(Conseiller conseiller) {
		persist(conseiller);

	}

	@Override
	public Conseiller updateConseiller(Conseiller conseiller) {
		Conseiller cs = getByKey(conseiller.getId());
		update(cs);
		return cs;
	}

	@Override
	public Conseiller findById(int id) {
		Conseiller conseiller = getByKey(id);
		return conseiller;

	}

	@Override
	public Conseiller findByName(String name) {
		System.out.println("name=" + name);
		try {
			Conseiller conseiller = (Conseiller) getEntityManager()
					.createQuery("SELECT c FROM conseiller c where c.nom LIKE :name").setParameter("name", name)
					.getSingleResult();
			return conseiller;
		} catch (NoResultException ex) {
			return null;
		}
	}

	@Override
	public Conseiller findByMatricule(int matricule) {
		System.out.println("matricule=" + matricule);
		try {
			Conseiller conseiller = (Conseiller) getEntityManager()
					.createQuery("SELECT c FROM conseiller c where c.matricule LIKE :matricule")
					.setParameter("matricule", matricule).getSingleResult();
			return conseiller;
		} catch (NoResultException ex) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Conseiller> findAllConseillers() {
		List<Conseiller> conseillers = (List<Conseiller>) getEntityManager()
				.createQuery("SELECT c FROM conseiller c ORDER BY c.nom ASC ").getResultList();

		return conseillers;
	}

	@Override
	public void deleteConseillerById(int id) {
		Conseiller conseiller = getByKey(id);
		delete(conseiller);
	}

	@Override
	public void deleteAllConseillers() {
		// TODO Auto-generated method stub

	}

}
