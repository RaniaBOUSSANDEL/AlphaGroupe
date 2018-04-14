package com.wha.springmvc.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.wha.springmvc.model.Credit;

@Repository("creditDao")
public class CreditDaoImpl extends AbstractDao<Integer, Credit> implements CreditDao {

	@Override
	public Credit findCreditById(int id) {
		Credit credit = getByKey(id); 
		return credit;
	}

	@Override
	public Credit findCreditByDateDeffet(Date date) {
		System.out.println("name=" + date);
		try {
			Credit credit  = (Credit) getEntityManager()
					.createQuery(
							"SELECT c FROM Credit c where c.dateDeffet LIKE :date")
					.setParameter("name", date).getSingleResult();
			return credit;
		} catch (NoResultException ex) {
			return null;
		}
	}

	@Override
	public void save(Credit credit) {
		persist (credit);

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Credit> findAllCredit() {
		
			//verif requete sql!!!!
					List<Credit> credits = (List<Credit>) getEntityManager().createQuery("SELECT c FROM Credit c ORDER BY c.id ASC ").getResultList();
					return credits;
		
	}

}
