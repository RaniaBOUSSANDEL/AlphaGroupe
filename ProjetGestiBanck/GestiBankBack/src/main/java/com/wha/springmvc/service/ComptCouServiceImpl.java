package com.wha.springmvc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.springmvc.dao.CompteCouDao;
import com.wha.springmvc.model.CompteCourant;
@Service("comptCouService")
@Transactional
public class ComptCouServiceImpl implements ComptCouService {

	@Autowired
	private CompteCouDao dao;
	@Override
	public void save(CompteCourant compteCourant) {
		dao.save(compteCourant);
	}
	@Override
	public CompteCourant findByNumeroCompte(long numCompte) {
		return dao.findByNumeroCompte(numCompte);
	}

}
