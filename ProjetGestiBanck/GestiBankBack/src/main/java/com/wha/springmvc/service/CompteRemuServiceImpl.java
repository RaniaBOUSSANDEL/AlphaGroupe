package com.wha.springmvc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.springmvc.dao.ClientDao;
import com.wha.springmvc.dao.CompteRemuDao;
import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.CompteRemunerateur;
@Service("comptRemuService")
@Transactional
public class CompteRemuServiceImpl implements CompteRemuService {
	@Autowired 
	private CompteRemuDao daoCR;
	@Autowired
	private ClientDao daoCl;
	@Override
	public void save(CompteRemunerateur compteRemunerateur, int id_Cl) {
		Client cl = daoCl.findById(id_Cl);
		System.out.println(cl.toString());

		if (cl != null ) {
			compteRemunerateur.setClient(cl);
			cl.getComptesBancaire().add(compteRemunerateur);
		}
		daoCR.save(compteRemunerateur);

	}

	@Override
	public CompteRemunerateur findByNumeroCompte(long numeroCompte) {
		return daoCR.findByNumeroCompte(numeroCompte);
	}

}
