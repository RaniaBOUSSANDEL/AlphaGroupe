package com.wha.springmvc.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.DemandeOuvertureCompte;
@Repository("demandeOCDao")
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

	@Override
	public DemandeOuvertureCompte findById(int id) {
		DemandeOuvertureCompte demandeDOC = getByKey(id);
		return demandeDOC;
	}
	
	@Override
	public List<DemandeOuvertureCompte> findByDateDemande(Date date) {
		
		return null;
	}

	@Override
	public List<DemandeOuvertureCompte> findByEtatDemande(String etatDemande) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(DemandeOuvertureCompte demande) {
		persist(demande);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<DemandeOuvertureCompte> findAllDemandeDemandeOuvertureCompte() {
		List<DemandeOuvertureCompte> demandesComptes = (List<DemandeOuvertureCompte>) getEntityManager()
				.createQuery("SELECT dc FROM DemandeOuvertureCompte dc ORDER BY dc.dateDemande ASC ").getResultList();

		return demandesComptes;
	}

}