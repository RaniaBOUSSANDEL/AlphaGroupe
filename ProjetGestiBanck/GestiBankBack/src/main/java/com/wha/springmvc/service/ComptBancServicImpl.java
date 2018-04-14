package com.wha.springmvc.service;



import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wha.springmvc.dao.ClientDao;
import com.wha.springmvc.dao.CompteBancDAO;
import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.CompteBancaire;
import com.wha.springmvc.model.Transaction;

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
			cl.getComptesBancaire().add(compteBancaire);
		}
		dao1.save(compteBancaire);
		
	}
	@Override
	public CompteBancaire findByNumeroCompte (long numeroCompte) {
		return dao1.findByNumeroCompte(numeroCompte);
	}
	
	@Override
	public List <Transaction > findTransactionsBynumCompte(long numCompte){
		CompteBancaire compteBancaire = dao1.findByNumeroCompte(numCompte);
		return compteBancaire.getTransactions();
		
	}
	@Override
	public List<CompteBancaire> findAllCompteBanc() {
		
		return dao1.findAllCompteBanc();
	}
	@Override
	public List<CompteBancaire> findAllCompteBancByIdCl(int idCl) {
		
		Client client = daoC.findById(idCl);
			return   client.getComptesBancaire();
	}

}
