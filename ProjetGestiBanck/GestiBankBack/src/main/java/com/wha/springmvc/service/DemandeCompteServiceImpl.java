package com.wha.springmvc.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.dao.DemandeDao;
import com.wha.springmvc.dao.DemandeOuvertureCompteDao;
import com.wha.springmvc.dao.UserDao;
import com.wha.springmvc.model.Administrateur;
import com.wha.springmvc.model.Conseiller;
import com.wha.springmvc.model.Demande;
import com.wha.springmvc.model.DemandeOuvertureCompte;
import com.wha.springmvc.model.User;



@Service("demandeCompteService")
@Transactional
public class DemandeCompteServiceImpl implements DemandeCompteService {
	
	@Autowired
	private DemandeOuvertureCompteDao daoDC;
	@Autowired
	private UserDao Udao;

	@Override
	public DemandeOuvertureCompte createDemandeCompte() {
		Date dateDemande = new Date();
		String etatDemande=null;
		boolean etatAffectation = false;
		Date dateAffectation = null;
		DemandeOuvertureCompte demandeCompte= new DemandeOuvertureCompte(dateDemande, etatDemande, etatAffectation, dateAffectation);
		User user=Udao.findById(1);
		Administrateur adm=(Administrateur) user;
		demandeCompte.setAdministrateur(adm);
		daoDC.save(demandeCompte);
		return demandeCompte;

	}
	@Override
	public DemandeOuvertureCompte affecterDemande(int id_demandeCompte, int id_cons) {
		DemandeOuvertureCompte dcompt=(DemandeOuvertureCompte) daoDC.findById(id_demandeCompte);
		User co=Udao.findById(id_cons);
		Conseiller coo=(Conseiller) co;
		Date date=new Date();
		dcompt.setConseiller(coo);
		dcompt.setDateAffectation(date);
		dcompt.setEtatAffectation(true);
		daoDC.save(dcompt);
		return dcompt;
	}

//	@Override
//	public void deleteDemandeById(int id) {
//		dao.deleteDemandeById(id);
//
//	}
//
	@Override
	public DemandeOuvertureCompte findById(int id) {
		return daoDC.findById(id);
	}
@Override
	public List<DemandeOuvertureCompte> findAllDemandes() {
		return daoDC.findAllDemandeDemandeOuvertureCompte();
	
	}

//	@Override
//	public List<Demande> findByEtatDemande(String etatDemande) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Demande> findByDateDemande(Date date) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void updateDemande(Demande demande) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public boolean isDemandeExist(Demande demande) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//

	

//	@Override
//	public List<DemandeOuvertureCompte> findByAffectation(String etatAffectation) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}