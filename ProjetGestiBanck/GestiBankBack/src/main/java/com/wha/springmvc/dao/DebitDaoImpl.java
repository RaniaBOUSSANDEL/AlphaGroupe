package com.wha.springmvc.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.wha.springmvc.model.Debit;

@Repository("debitDao")
public class DebitDaoImpl extends AbstractDao<Integer, Debit> implements DebitDao {

	@Override
	public Debit findDebitById(int id) {
		Debit debit = getByKey(id);
		return debit;
	}

	@Override
	public Debit findDebitByDateDeffet(Date date) {
		System.out.println("name=" + date);
		try {
			Debit debit  = (Debit) getEntityManager()
					.createQuery(
							"SELECT d FROM Debit d where d.dateDeffet LIKE :date")
					.setParameter("name", date).getSingleResult();
			return debit;
		} catch (NoResultException ex) {
			return null;
		}
	}

	@Override
	public void save(Debit debit) {
		persist(debit);

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Debit> findAllDebit() {
		//verif requete sql!!!!
				List<Debit> debits = (List<Debit>) getEntityManager().createQuery("SELECT d FROM Debit d ORDER BY d.nom ASC ").getResultList();
				return debits;
	}

}
