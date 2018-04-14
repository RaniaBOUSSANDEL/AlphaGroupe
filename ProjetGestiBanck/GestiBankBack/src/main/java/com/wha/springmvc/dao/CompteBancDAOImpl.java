package com.wha.springmvc.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import com.wha.springmvc.model.CompteBancaire;

@Repository("cbDao")
public class CompteBancDAOImpl extends AbstractDao<Integer, CompteBancaire> implements CompteBancDAO {
	// Recherche compte bancaire par id
	@Override
	public CompteBancaire findById(int id) {
		CompteBancaire compteBancaire = getByKey(id);
		return compteBancaire;
	}

	// Recherche compte bancaire par date d'ouverture
	@Override
	public CompteBancaire findByDateCreation(Date date) {
		System.out.println("name=" + date);
		try {
			CompteBancaire compteBancaire = (CompteBancaire) getEntityManager()
					.createQuery("SELECT c FROM CompteBancaire c where c.dateCreation LIKE :date")
					.setParameter("date", date).getSingleResult();
			return compteBancaire;
		} catch (NoResultException ex) {
			return null;
		}
	}

	// Recherche compte bancaire par numero de compte
	@Override
	public CompteBancaire findByNumeroCompte(long numeroCompte) {
		System.out.println("name=" + numeroCompte);
		try {
			CompteBancaire compteBancaire = (CompteBancaire) getEntityManager()
					.createQuery("SELECT c FROM CompteBancaire c where c.numCompte LIKE :numeroCompte")
					.setParameter("numeroCompte", numeroCompte).getSingleResult();
			return compteBancaire;
		} catch (NoResultException ex) {
			return null;
		}
	}

	@Override
	public void save(CompteBancaire compteBancaire) {
		
		persist(compteBancaire);

	}

	@Override
	public void deleteCompteBancById(int id) {
		CompteBancaire compteBancaire = getByKey(id);
		delete(compteBancaire);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CompteBancaire> findAllCompteBanc() {
		List<CompteBancaire> compteBancaire = (List<CompteBancaire>) getEntityManager()
				.createQuery("SELECT c FROM CompteBancaire c ORDER BY c.id ASC ").getResultList();
		return compteBancaire;
	}

	@Override
	public void deleteAllCompteBanc() {
		// TODO Auto-generated method stub

	}

}