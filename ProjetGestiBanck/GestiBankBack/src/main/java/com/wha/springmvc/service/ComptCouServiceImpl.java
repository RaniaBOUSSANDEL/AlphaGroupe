package com.wha.springmvc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.springmvc.dao.ClientDao;
import com.wha.springmvc.dao.CompteCouDao;
import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.CompteCourant;
@Service("comptCouService")
@Transactional
public class ComptCouServiceImpl implements ComptCouService {

	@Autowired
	private CompteCouDao daocc;
	@Autowired
	private ClientDao daoCl;
	@Override
	public void save(CompteCourant compteCourant, int id_client) {
		Client cl = daoCl.findById(id_client);
		System.out.println(cl.toString());

		if (cl != null ) {
			compteCourant.setClient(cl);
			cl.getComptesBancaire().add(compteCourant);
		}
		daocc.save(compteCourant);
	}
	@Override
	public CompteCourant findByNumeroCompte(long numCompte) {
		return daocc.findByNumeroCompte(numCompte);
	}

}
