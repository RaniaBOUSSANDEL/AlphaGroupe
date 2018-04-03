package com.wha.springmvc.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import com.wha.springmvc.model.CompteAvecDecouv;


public class CompteDecouvDaoImpl extends AbstractDao<Integer, CompteAvecDecouv> implements CompteDecouvertDao {
	// Recherche compte bancaire par id
	@Override
	public CompteAvecDecouv findById(int id) {
		CompteAvecDecouv compteDecouvert = getByKey(id);
		return compteDecouvert;
		
	}

	// Recherche compte bancaire par date d'ouverture
		@Override
		public CompteAvecDecouv findByDateCreation(Date date) {
			System.out.println("name=" + date);
			try {
				CompteAvecDecouv compteDecouvert = (CompteAvecDecouv) getEntityManager()
						.createQuery(
								"SELECT c FROM CompteBanc c where c.dateCreation LIKE :date")
						.setParameter("name", date).getSingleResult();
				return compteDecouvert;
			} catch (NoResultException ex) {
				return null;
			}
		}
		// Recherche compte bancaire par numero de compte
		@Override
		public CompteAvecDecouv findByNumeroCompte(long numeroCompte) {
			System.out.println("name=" + numeroCompte);
			try {
				CompteAvecDecouv compteDecouvert = (CompteAvecDecouv) getEntityManager()
						.createQuery(
								"SELECT c FROM CompteBanc c where c.numCompte LIKE :numeroCompte")
						.setParameter("name", numeroCompte).getSingleResult();
				return compteDecouvert;
			} catch (NoResultException ex) {
				return null;
			}
		}

	@Override
	public void save(CompteAvecDecouv compteAvecDecouv) {
		persist(compteAvecDecouv);

	}

	@Override
	public void deleteCompteDeById(int id) {
		CompteAvecDecouv compteAvecDecouv = getByKey(id);
		delete(compteAvecDecouv);

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CompteAvecDecouv> findAllCompteDecouvert() {
		List<CompteAvecDecouv> compteAvecDecouvs = (List<CompteAvecDecouv>) getEntityManager().createQuery("SELECT c FROM CompteAvecDecouv c ORDER BY c.nom ASC ").getResultList();
		return compteAvecDecouvs;
	}

	@Override
	public void deleteAllCompteDecouvert() {
		// TODO Auto-generated method stub

	}

}