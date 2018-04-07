package com.wha.springmvc.service;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.springmvc.dao.ClientDao;
import com.wha.springmvc.dao.CompteBancDAO;
import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.CompteBancaire;
import com.wha.springmvc.model.Conseiller;
@Service("compteBancService")
@Transactional
public class ComptBancServicImpl implements ComptBancService {

	@Autowired
	private CompteBancDAO dao1;
	@Autowired
	private ClientDao daoC;
	@Override
	public void save(CompteBancaire compteBancaire, int client_id) {
		
		
		Client cl = daoC.findById(client_id);
		System.out.println(cl.toString());

		if (cl != null ) {
			compteBancaire.setClient(cl);
		}
		dao1.save(compteBancaire);
		
	}
	@Override
	public CompteBancaire findByNumeroCompte (long numeroCompte) {
		return dao1.findByNumeroCompte(numeroCompte);
	}

}
