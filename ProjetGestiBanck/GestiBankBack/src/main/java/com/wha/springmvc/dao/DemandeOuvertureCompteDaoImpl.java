package com.wha.springmvc.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import com.wha.springmvc.model.DemandeOuvertureCompte;

public class DemandeOuvertureCompteDaoImpl extends AbstractDao<Integer, DemandeOuvertureCompte> implements DemandeOuvertureCompteDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<DemandeOuvertureCompte> findByDateAffectation(Date date) {
		System.out.println("Date=" + date);
		try {
			List<DemandeOuvertureCompte> demandes = (List<DemandeOuvertureCompte>) 
					getEntityManager().createQuery
					("SELECT dc FROM DemandeOuvertureCompte dc where dc.dateAffectation LIKE :date ORDER BY dc.dateAffectation ASC ")
					.setParameter("date", date).getSingleResult();
			return demandes;
		} catch (NoResultException ex) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DemandeOuvertureCompte> findByEtatAffectation(String etatAffectation) {
		System.out.println("Etat=" + etatAffectation);
		try {
			List<DemandeOuvertureCompte> demandes = (List<DemandeOuvertureCompte>) 
					getEntityManager().createQuery
					("SELECT dc FROM DemandeOuvertureCompte dc where dc.etatAffectation LIKE :etat ORDER BY dc.dateAffectation ASC ")
					.setParameter("date", etatAffectation).getSingleResult();
			return demandes;
		} catch (NoResultException ex) {
			return null;
		}
	}

}
