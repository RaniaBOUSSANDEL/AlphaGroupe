package com.wha.springmvc.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import com.wha.springmvc.model.CompteCourant;

@Repository("ccDao")
public class CompteCouDaoImp extends AbstractDao<Integer, CompteCourant> implements CompteCouDao {
	// Recherche compte bancaire par id
	@Override
	public CompteCourant findById(int id) {
		CompteCourant compteCourant= getByKey(id);
		return compteCourant;
	}

	// Recherche compte bancaire par date d'ouverture
		@Override
		public CompteCourant findByDateCreation(Date date) {
			System.out.println("name=" + date);
			try {
				CompteCourant compteCourant = (CompteCourant) getEntityManager()
						.createQuery(
								"SELECT c FROM CompteBanc c where c.dateCreation LIKE :date")
						.setParameter("name", date).getSingleResult();
				return compteCourant;
			} catch (NoResultException ex) {
				return null;
			}
		}
		// Recherche compte bancaire par numero de compte
		@Override
		public CompteCourant findByNumeroCompte(long numeroCompte) {
			System.out.println("name=" + numeroCompte);
			try {
				CompteCourant compteCourant = (CompteCourant) getEntityManager()
						.createQuery(
								"SELECT c FROM CompteBanc c where c.numCompte LIKE :numeroCompte")
						.setParameter("name", numeroCompte).getSingleResult();
				return compteCourant;
			} catch (NoResultException ex) {
				return null;
			}
		}

	@Override
	public void save(CompteCourant compteCourant) {
		persist(compteCourant);

	}

	@Override
	public void deleteCompteCouById(int id) {
		CompteCourant compteCourant = getByKey(id);
		delete(compteCourant);

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CompteCourant> findAllCompteCourant() {
		List<CompteCourant> compteCourant = (List<CompteCourant>) getEntityManager().createQuery("SELECT c FROM CompteCourant c ORDER BY c.nom ASC ").getResultList();
		return compteCourant;
	}

	@Override
	public void deleteAllCompteCourant() {
		// TODO Auto-generated method stub

	}

}