package com.wha.springmvc.dao;

import java.util.Date;
import java.util.List;
import com.wha.springmvc.model.Credit;


public interface CreditDao {
	Credit findCreditById(int id);
	Credit findCreditByDateDeffet(Date date);
void save(Credit  credit);
	
	List<Credit> findAllCredit();
}
