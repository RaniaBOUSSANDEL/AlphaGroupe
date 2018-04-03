package com.wha.springmvc.dao;

import java.util.Date;
import java.util.List;

import com.wha.springmvc.model.Debit;


public interface DebitDao {
	Debit findDebitById(int id);
	Debit findDebitByDateDeffet(Date date);
void save(Debit  debit);
	
	List<Debit> findAllDebit();
}
