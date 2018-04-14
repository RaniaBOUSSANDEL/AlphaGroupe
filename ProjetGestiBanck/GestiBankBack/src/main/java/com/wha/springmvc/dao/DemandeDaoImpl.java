package com.wha.springmvc.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import com.wha.springmvc.model.Demande;

public class DemandeDaoImpl extends AbstractDao<Integer, Demande> implements DemandeDao {

	@Override
	public Demande findById(int id) {
		Demande demande = getByKey(id);
		return demande;

	}

	@Override
	public void save(Demande demande) {
		persist(demande);

	}

	@Override
	public void deleteDemandeById(int id) {
		Demande demande = getByKey(id);
		delete(demande);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Demande> findAllDemandes() {
		List<Demande> demandes = (List<Demande>) getEntityManager()
				.createQuery("SELECT d FROM Demande d ORDER BY d.dateDemande ASC ").getResultList();
		return demandes;

	}

	@Override
	public void deleteAllDemandes() {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	/* lister les demande par raport a leur date de creation*/
	public List<Demande> findByDateDemande(Date date) {
		System.out.println("Date=" + date);
		try {
			List<Demande> demandes = (List<Demande>) getEntityManager()
					.createQuery("SELECT d FROM Demande d where d.dateDemande LIKE :date ORDER BY d.dateDemande ASC ")
					.setParameter("date", date).getSingleResult();
			return demandes;
		} catch (NoResultException ex) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	/* lister les demande par raport a leur état*/
	public List<Demande> findByEtatDemande(String etat) {
		System.out.println("EtatDemande=" + etat);
		try {
			List<Demande> demandes = (List<Demande>) getEntityManager()
					.createQuery("SELECT d FROM Demande d where d.etatDemande LIKE :etat ORDER BY d.dateDemande ASC ")
					.setParameter("etat", etat).getSingleResult();
			return demandes;
		} catch (NoResultException ex) {
			return null;
		}
	}

}