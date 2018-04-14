package com.wha.springmvc.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.wha.springmvc.model.CompteRemunerateur;

@Repository("CRDao")
public class CompteRemuDaoImpl extends AbstractDao<Integer, CompteRemunerateur> implements CompteRemuDao {
	// Recherche compte bancaire par id
	@Override
	public CompteRemunerateur findById(int id) {
		CompteRemunerateur compteRemunerateur = getByKey(id);
		return compteRemunerateur;
	}

	// Recherche compte bancaire par date d'ouverture
		@Override
		public CompteRemunerateur findByDateCreation(Date date) {
			System.out.println("name=" + date);
			try {
				CompteRemunerateur compteRemunerateur = (CompteRemunerateur) getEntityManager()
						.createQuery(
								"SELECT c FROM CompteRemunerateur c where c.dateCreation LIKE :date")
						.setParameter("date", date).getSingleResult();
				return compteRemunerateur;
			} catch (NoResultException ex) {
				return null;
			}
		}
		// Recherche compte bancaire par numero de compte
		@Override
		public CompteRemunerateur findByNumeroCompte(long numeroCompte) {
			System.out.println("name=" + numeroCompte);
			try {
				CompteRemunerateur compteRemunerateur = (CompteRemunerateur) getEntityManager()
						.createQuery(
								"SELECT c FROM CompteRemunerateur c where c.numCompte LIKE :numeroCompte")
						.setParameter("numeroCompte", numeroCompte).getSingleResult();
				return compteRemunerateur;
			} catch (NoResultException ex) {
				return null;
			}
		}

	@Override
	public void save(CompteRemunerateur compteRemunerateur) {
		persist(compteRemunerateur);

	}

	@Override
	public void deleteCompteRemuById(int id) {
		CompteRemunerateur compteRemunerateur =getByKey(id);
		delete(compteRemunerateur);

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CompteRemunerateur> findByAllComptRemu() {
		List<CompteRemunerateur> compteRemunerateurs = (List<CompteRemunerateur>) getEntityManager().createQuery("SELECT c FROM CompteRemunerateur c ORDER BY c.nom ASC ").getResultList();
		return compteRemunerateurs;
	}

	@Override
	public void deleteAllCompteRemu() {
		// TODO Auto-generated method stub

	}

}