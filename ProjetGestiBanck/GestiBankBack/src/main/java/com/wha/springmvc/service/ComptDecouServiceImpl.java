package com.wha.springmvc.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.springmvc.dao.ClientDao;
import com.wha.springmvc.dao.CompteDecouvertDao;
import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.CompteAvecDecouv;
@Service("comptDecouService")
@Transactional
public class ComptDecouServiceImpl implements ComptDecouService {
	@Autowired 
	private CompteDecouvertDao daoCD;
	@Autowired
	private ClientDao daoCl;

	@Override
	public void save(CompteAvecDecouv compteDecouvert, int id_Cl, float revenu) {
		
		Client cl = daoCl.findById(id_Cl);
		System.out.println(cl.toString());
		
		if (revenu > 0.4*compteDecouvert.getMontantDecouvert()) {
			if (cl != null ) {
				compteDecouvert.setClient(cl);
				cl.getComptesBancaire().add(compteDecouvert);
			}
			
			daoCD.save(compteDecouvert);
		} else System.out.println("sorry, vos revenus ne vous permettent pas d'avoir un compte Decouvert chez AlphaBank");
		
		

	}

	@Override
	public CompteAvecDecouv findByNumeroCompte(long numeroCompte) {
		return daoCD.findByNumeroCompte(numeroCompte);
	}

}
