package com.wha.springmvc.dao;

import java.util.Collection;
import java.util.List;
import javax.persistence.NoResultException;
import com.wha.springmvc.model.Visiteur;

public class VisiteurDaoImpl extends AbstractDao<Integer, Visiteur> implements VisiteurDao {

	@Override
	public Visiteur findById(int id) {
		Visiteur visiteur=getByKey(id);
		return visiteur;
	}

	@Override
	public Visiteur findByName(String name) {
		System.out.println("name=" + name);
		try {
			Visiteur visiteur = (Visiteur) getEntityManager()
					.createQuery(
							"SELECT v FROM Visiteur v where v.nom LIKE :name")
					.setParameter("name", name).getSingleResult();
			return visiteur;
		} catch (NoResultException ex) {
			return null;
		}
	}

	@Override
	public void save(Visiteur visiteur) {
		persist(visiteur);

	}

	@Override
	public void deleteVisiteurById(int id) {
		Visiteur visiteur = getByKey(id);
		delete(visiteur);

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Visiteur> findAllVisiteurs() {
		List<Visiteur> visiteurs = (List<Visiteur>) getEntityManager().createQuery("SELECT v FROM Visiteur v ORDER BY v.nom ASC ").getResultList();
		return visiteurs;
		
	}

	@Override
	public void deleteAllVisiteurs() {
		// TODO Auto-generated method stub

	}
	
	public void deleteBySSO(String sso){
		Visiteur visiteur = (Visiteur) getEntityManager()
				.createQuery(
						"SELECT v FROM Visiteur v where v.ssoId LIKE :ssoId")
				.setParameter("ssoId", sso).getSingleResult();
		delete(visiteur);
	}
	
	protected void initializeCollection(Collection<?> collection){
		if(collection == null){
			return;
		}
		collection.iterator().hasNext();
	}

}
