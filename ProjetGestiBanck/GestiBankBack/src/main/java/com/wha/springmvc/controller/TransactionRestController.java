package com.wha.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.wha.springmvc.model.Transaction;
import com.wha.springmvc.service.TransactionService;

@RestController
public class TransactionRestController {
	@Autowired
	TransactionService transactionService;
	
//	@Autowired
//	DebitService debitService;
//	@Autowired
//	CreditService creditService;
	// -------------------Create a Transaction-------------------------------

		@RequestMapping(value = "/transaction/{numero_Compte}/", method = RequestMethod.POST)
		public ResponseEntity<Void> virement(@RequestBody Transaction transaction,
				UriComponentsBuilder ucBuilder, @PathVariable("numero_Compte") long numero_Compte) {
			System.out.println("Creating transaction " + transaction.getLibelle());

//			if (transactionServive.findTransactionByNumCompt(transaction.getCompteB().getNumCompte())!=null) {
//	            System.out.println("A compteBanc with Numero " + transaction.getCompteB().getNumCompte() + " already exist");
//	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//	        }
			transactionService.save(transaction, numero_Compte);
			 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/transaction/{num}").buildAndExpand(transaction.getCompteB().getNumCompte()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}  
		
		
		// -------------------Create a Debit------------------------------------------
		
//				@RequestMapping(value = "/transaction/debit/{numero_Compte}", method = RequestMethod.POST)
//				public ResponseEntity<Void> debitCompte(@RequestBody Debit debit,
//						UriComponentsBuilder ucBuilder, @PathVariable("numero_Compte") long numero_Compte) {
//					System.out.println("Creating transaction " + debit.getLibelle());
//
////					if (transactionServive.findTransactionByNumCompt(transaction.getCompteB().getNumCompte())!=null) {
////			            System.out.println("A compteBanc with Numero " + transaction.getCompteB().getNumCompte() + " already exist");
////			            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
////			        }
//					debitService.save(debit, numero_Compte);
//					 
//			        HttpHeaders headers = new HttpHeaders();
//			        headers.setLocation(ucBuilder.path("/transaction/debit/{numero_Compte}").buildAndExpand(debit.getLibelle()).toUri());
//			        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//				}  
//				
//				//-------------------Create a Credit-------------------------------------------
//				@RequestMapping(value = "/transaction/credit/{numeroCompte}", method = RequestMethod.POST)
//				public ResponseEntity<Void> creditCompte(@RequestBody Credit credit,
//						UriComponentsBuilder ucBuilder, @PathVariable("numeroCompte") long numeroCompte) {
//					System.out.println("Creating transaction " + credit.getLibelle());
//					creditService.save(credit, numeroCompte);
//					 HttpHeaders headers = new HttpHeaders();
//				     headers.setLocation(ucBuilder.path("/transaction/credit/{numeroCompte}").buildAndExpand(credit.getLibelle()).toUri());
//				     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//				} 
		
		// -------------------Retrieve All Transactions------------------------------------

		@RequestMapping(value = "/transactions/", method = RequestMethod.GET)
		public ResponseEntity<List<Transaction>> listAllTransactions() {
			List<Transaction> transactions = transactionService.findAllTransaction();
			for (Transaction transaction : transactions) {
				System.out.println(transaction);
			}
			if (transactions.isEmpty()) {
				return new ResponseEntity<List<Transaction>>(HttpStatus.NO_CONTENT);// You many decide to return
																				// HttpStatus.NOT_FOUND
			}
			return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
		}
		
}				



