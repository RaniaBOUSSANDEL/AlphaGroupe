package com.wha.springmvc.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.wha.springmvc.model.Transaction;

@Repository("transactionDao")
public class TransactionDaoImpl extends AbstractDao<Integer, Transaction> implements TransactionDao {

	@Override
	public Transaction findTById(int id) {
		Transaction transaction = getByKey(id);
		return transaction;
		
	}

	@Override
	public Transaction findTByDateDeffet(Date date) {
		System.out.println("name=" + date);
		try {
			Transaction transaction = (Transaction) getEntityManager()
					.createQuery(
							"SELECT t FROM Transaction t where t.dateDeffet LIKE :date")
					.setParameter("name", date).getSingleResult();
			return transaction;
		} catch (NoResultException ex) {
			return null;
		}
	}

	@Override
	public void save(Transaction transaction) {
		persist(transaction);

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> findAllTransaction() {
		//Liste des Transactions!!!!
		List<Transaction> transactions = (List<Transaction>) getEntityManager().createQuery("SELECT t FROM Transaction t ORDER BY t.id ASC ").getResultList();
		return transactions;
	}
	@Override
	public Transaction findTransactionByNumCompt(long numeroCompte) {
		System.out.println("name=" + numeroCompte);
		try {
			Transaction transaction = (Transaction) getEntityManager()
					.createQuery("SELECT t FROM Transaction t where t.numCompte LIKE :numeroCompte")
					.setParameter("numeroCompte", numeroCompte).getSingleResult();
			return transaction;
		} catch (NoResultException ex) {
			return null;
		}
	}

}
