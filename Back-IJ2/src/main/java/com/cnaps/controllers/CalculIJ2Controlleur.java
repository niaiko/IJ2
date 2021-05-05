package com.cnaps.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.cnaps.models.AccueilMod;
import com.cnaps.models.DecompteIJ2;
import com.cnaps.models.TecElemCalcMod;
import com.cnaps.models.TecInfoRecuTraitMod;
import com.cnaps.models.param.IJ2Param;
import com.cnaps.repository.TecElemCalcRepository;
import com.cnaps.services.AccueilService;
import com.cnaps.services.TecElemCalcService;
import com.cnaps.services.TecEtatDossService;
import com.cnaps.services.TecInfoRecuTraitService;
import com.cnaps.utils.CalculUtil;
import com.cnaps.utils.UtilTraitementDateIJ2;

@RestController
public class CalculIJ2Controlleur {
	ObjectMapper om=new ObjectMapper();
	String resultat;
	String nom="TecInfoRecu";
	CalculUtil calc = new CalculUtil();
	UtilTraitementDateIJ2 util=new UtilTraitementDateIJ2();
	public static String message="{\"message\":\"success\"}";
	static int NOMBRE_MOIS = 11;
	private static final Logger log = LoggerFactory.getLogger(CalculIJ2Controlleur.class);
	int code_IJ2 = 422;
	static int ATTENTE_PROLONGATION =  9;
	
	@Autowired
	TecInfoRecuTraitService service;
	
	@Autowired
	TecElemCalcRepository calcservice;
	
	@Autowired
	TecElemCalcService calcService;
	
	@Autowired
	TecEtatDossService tecEtatDossService;
	
	@Autowired
	AccueilService accueilService;
	
	
	/*@PostMapping("/decompteIJ2")
	public ResponseEntity<Object> decompteIJ2(@RequestBody String param) {
		try {
			log.info("decompte ij2 : "+param);
			DecompteIJ2 decompte = new DecompteIJ2();
			List<TecInfoRecuTraitMod> recu=service.findByIdAccueil(param);
			List<TecInfoRecuTraitMod> recuIj1 = service.findByIdAccueil(util.referenceIJ1(recu));
			AccueilMod etat = accueilService.getByIdAccIsAndLast(param);
			//List<TecEtatDossMod> etat = tecEtatDossService.findByIdAcc(param);
	
			recu = util.concatenerIJ(recuIj1, recu);
			int prenatal=util.prenatal(recu);
			int postnatal=util.postnatal(recu);
			int prolongation = util.prolongation(recu);
			int nb_jr_IJ1 = util.nombre_jour_IJ1(recu);
			int nb_jr_IJ2 = 0;
			if(etat.getEtat()==ATTENTE_PROLONGATION) 
				nb_jr_IJ2 = (prenatal + postnatal) - nb_jr_IJ1;
			else 
				nb_jr_IJ2 = (prenatal + postnatal + prolongation) - nb_jr_IJ1;
			
			double salaire=Double.parseDouble(util.getdate(recu, "SAL"));
			double demisalaire=util.demisalaire(salaire);
			double ij=nb_jr_IJ2*demisalaire;
			//long montant = CalculUtil.arrond(ij);
			long montant = calc.arrondPF(ij);
				
			decompte.setDAT(util.getdate(recu, "DAT"));
			decompte.setDAC(util.getdate(recu, "DNA"));
			decompte.setDRT(util.getdate(recu, "DRT"));
			decompte.setNbjourIJ1(util.nombre_jour_IJ1(recu));
			decompte.setPostnatale(postnatal*demisalaire);
			decompte.setPrenatale(prenatal*demisalaire);
			decompte.setIj1(montant);
			decompte.setSalaire(salaire);
			decompte.setDemisalaire(demisalaire);
			decompte.setNbjourpost(postnatal);
			decompte.setNbjourpre(prenatal);
			decompte.setNbprolongation(prolongation);
			decompte.setNbjourIJ1(nb_jr_IJ1);
			decompte.setNbjourIJ2(nb_jr_IJ2);
			Date dateDebPrenatal = util.convertStringToDateUtil(util.getdate(recu, "DAT"), "yyyy-MM-dd");
			decompte.setDate_debut_prenatale(util.convertDateToString(dateDebPrenatal));
			Date dateDebPostNatal = util.DatePlusJour(util.convertStringToDateUtil(util.getdate(recu, "DNA"), "yyyy-MM-dd"), 1);
			decompte.setDate_debut_postnatale(util.convertDateToString(dateDebPostNatal));
			Date dateFinPostNatal = util.DatePlusJour(dateDebPostNatal, postnatal-1);
			decompte.setDate_fin_postnatale(util.convertDateToString(dateFinPostNatal));
			Date dateDebutProlongation = util.DatePlusJour(dateFinPostNatal, 1);
			decompte.setDate_debut_prolongation(util.convertDateToString(dateDebutProlongation));
			Date dateFinProlongation = util.DatePlusJour(dateDebutProlongation, prolongation);
			decompte.setDate_fin_prolongation(util.convertDateToString(dateFinProlongation));
			return new ResponseEntity<>(decompte, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}*/
	
	@PostMapping("/decompteIJ2")
	public ResponseEntity<Object> vaovaoDecompteIJ2(@RequestBody String param) {
		try {
			log.info("decompte ij2 : "+param);
			DecompteIJ2 decompte = new DecompteIJ2();
			List<TecInfoRecuTraitMod> recu=service.findByIdAccueil(param);
			List<TecInfoRecuTraitMod> recuIj1 = service.findByIdAccueil(util.referenceIJ1(recu));
			AccueilMod etat = accueilService.getByIdAccIsAndLast(param);
			//List<TecEtatDossMod> etat = tecEtatDossService.findByIdAcc(param);
	
			recu = util.concatenerIJ(recuIj1, recu);
			int prenatal=util.prenatal(recu);
			int postnatal=util.postnatal(recu);
			int prolongation = util.prolongation(recu);
			int nb_jr_IJ1 = util.nombre_jour_IJ1(recu);
			int nb_jr_IJ2 = 0;
			if(etat.getEtat()==ATTENTE_PROLONGATION) 
				nb_jr_IJ2 = (prenatal + postnatal) - nb_jr_IJ1;
			else 
				nb_jr_IJ2 = (prenatal + postnatal + prolongation) - nb_jr_IJ1;
			
			double salaire=Double.parseDouble(util.getdate(recu, "SAL"));
			double demisalaire=util.demisalaire(salaire);
			double ij=nb_jr_IJ2*demisalaire;
			//long montant = CalculUtil.arrond(ij);
			long montant = calc.arrondPF(ij);
				
			decompte.setDAT(util.getdate(recu, "DAT"));
			decompte.setDAC(util.getdate(recu, "DNA"));
			decompte.setDRT(util.getdate(recu, "DRT"));
			decompte.setNbjourIJ1(util.nombre_jour_IJ1(recu));
			decompte.setPostnatale(postnatal*demisalaire);
			decompte.setPrenatale(prenatal*demisalaire);
			decompte.setIj1(montant);
			decompte.setSalaire(salaire);
			decompte.setDemisalaire(demisalaire);
			decompte.setNbjourpost(postnatal);
			decompte.setNbjourpre(prenatal);
			decompte.setNbprolongation(prolongation);
			decompte.setNbjourIJ1(nb_jr_IJ1);
			decompte.setNbjourIJ2(nb_jr_IJ2);
			Date dateDebPrenatal = util.convertStringToDateUtil(util.getdate(recu, "DAT"), "yyyy-MM-dd");
			decompte.setDate_debut_prenatale(util.convertDateToString(dateDebPrenatal));
			Date dateDebPostNatal = util.DatePlusJour(util.convertStringToDateUtil(util.getdate(recu, "DNA"), "yyyy-MM-dd"), 1);
			decompte.setDate_debut_postnatale(util.convertDateToString(dateDebPostNatal));
			Date dateFinPostNatal = util.DatePlusJour(dateDebPostNatal, postnatal-1);
			decompte.setDate_fin_postnatale(util.convertDateToString(dateFinPostNatal));
			Date dateDebutProlongation = util.DatePlusJour(dateFinPostNatal, 1);
			decompte.setDate_debut_prolongation(util.convertDateToString(dateDebutProlongation));
			Date dateFinProlongation = util.DatePlusJour(dateDebutProlongation, prolongation);
			decompte.setDate_fin_prolongation(util.convertDateToString(dateFinProlongation));
			return new ResponseEntity<>(decompte, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	
	/*@PostMapping("/redressementIJ2")
	public ResponseEntity<Object> redressementIJ2(@RequestBody String param) {
		try {
			log.info("redressementIJ2 : "+param);
			Map<String,Object> map = om.readValue(param, new TypeReference<Map<String,Object>>() {});
			
			//List<TecInfoRecuMod> recu=service.getbyacc(map.get("idAcc").toString());
			List<TecInfoRecuTraitMod> recu=service.findByIdAccueil(map.get("idAccIj2").toString());
			//List<TecInfoRecuMod> recuIj1 = service.getbyacc(util.referenceIJ1(recu));
			List<TecInfoRecuTraitMod> recuIj1 = service.findByIdAccueil(map.get("idAccIj1").toString());
			//List<TecEtatDossMod> etat = tecEtatDossService.findByIdAcc(map.get("idAccIj2").toString());
			AccueilMod etat = accueilService.getByIdAccIsAndLast(map.get("idAccIj1").toString());
			recu = util.concatenerIJ(recuIj1, recu);
			int prenatal=util.prenatal(recu);
			int postnatal=util.postnatal(recu);
			int prolongation = util.prolongation(recu);
			int nb_jr_IJ1 = util.nombre_jour_IJ1(recu);
			int nb_jr_IJ2 = 0;
			if(etat.getEtat()==ATTENTE_PROLONGATION) {
				nb_jr_IJ2 = (prenatal + postnatal) - nb_jr_IJ1;
			}else {
				nb_jr_IJ2 = (prenatal + postnatal + prolongation) - nb_jr_IJ1;
			}
			//double salaire=Double.parseDouble(util.getdate(recu, "SAL"));
			double salaire=Double.parseDouble(map.get("salaire").toString());
			double demisalaire=util.demisalaire(salaire);
			double ij=nb_jr_IJ2*demisalaire;
			long montantIj = CalculUtil.arrond(ij);
			DecompteIJ2 decompte = new DecompteIJ2();	
			decompte.setDAT(util.getdate(recu, "DAT"));
			decompte.setDAC(util.getdate(recu, "DNA"));
			decompte.setDRT(util.getdate(recu, "DRT"));
			decompte.setNbjourIJ1(util.nombre_jour_IJ1(recu));
			decompte.setPostnatale(postnatal*demisalaire);
			decompte.setPrenatale(prenatal*demisalaire);
			
			List<TecElemCalcMod> droitIj1 = calcService.findByIdAcc(map.get("idAccIj1").toString());
			
			double total = (Double.parseDouble(map.get("droitIJ1").toString()) + ij);
			
			double oldDroitIJ1 = UtilTraitementDateIJ2.changeEnDouble(droitIj1.get(0).getValeur()); 
			long montantOldDroitIj1 = CalculUtil.arrond(oldDroitIJ1);
			double newDroit = total - montantOldDroitIj1;
			
			decompte.setIj1(newDroit);
			decompte.setSalaire(salaire);
			decompte.setDemisalaire(demisalaire);
			decompte.setNbjourpost(postnatal);
			decompte.setNbjourpre(prenatal);
			decompte.setNbprolongation(prolongation);
			decompte.setNbjourIJ1(nb_jr_IJ1);
			decompte.setNbjourIJ2(nb_jr_IJ2);
			Date dateDebPrenatal = util.convertStringToDateUtil(util.getdate(recu, "DAT"), "yyyy-MM-dd");
			decompte.setDate_debut_prenatale(util.convertDateToString(dateDebPrenatal));
			Date dateDebPostNatal = util.DatePlusJour(util.convertStringToDateUtil(util.getdate(recu, "DNA"), "yyyy-MM-dd"), 1);
			decompte.setDate_debut_postnatale(util.convertDateToString(dateDebPostNatal));
			Date dateFinPostNatal = util.DatePlusJour(dateDebPostNatal, postnatal-1);
			decompte.setDate_fin_postnatale(util.convertDateToString(dateFinPostNatal));
			Date dateDebutProlongation = util.DatePlusJour(dateFinPostNatal, 1);
			decompte.setDate_debut_prolongation(util.convertDateToString(dateDebutProlongation));
			Date dateFinProlongation = util.DatePlusJour(dateDebutProlongation, prolongation);
			decompte.setDate_fin_prolongation(util.convertDateToString(dateFinProlongation));
			IJ2Param donnee = new IJ2Param();
			donnee.setDecompte(decompte);
			donnee.setNewdroitIJ1(Double.parseDouble(map.get("droitIJ1").toString()));
			donnee.setNewdroitIJ2(montantIj);
			donnee.setOldDroitIJ1(montantOldDroitIj1);
			donnee.setDroitTotal(Double.parseDouble(map.get("droitIJ1").toString()) + montantIj);
			log.info("tesssssst "+om.writeValueAsString(donnee));
			return new ResponseEntity<>(donnee, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}*/
	
	
	@PostMapping("/redressementIJ2")
	public ResponseEntity<Object> redressementIJ2(@RequestBody String param) {
		try {
			log.info("decompte ij2 : "+param);
			Map<String,Object> map = om.readValue(param, new TypeReference<Map<String,Object>>() {});
			DecompteIJ2 decompte = new DecompteIJ2();
			List<TecInfoRecuTraitMod> recu=service.findByIdAccueil(map.get("idAccIj2").toString());
			List<TecInfoRecuTraitMod> recuIj1 = service.findByIdAccueil(util.referenceIJ1(recu));
			AccueilMod etat = accueilService.getByIdAccIsAndLast(map.get("idAccIj2").toString());
			//List<TecEtatDossMod> etat = tecEtatDossService.findByIdAcc(param);
	
			recu = util.concatenerIJ(recuIj1, recu);
			int prenatal=util.prenatal(recu);
			int postnatal=util.postnatal(recu);
			log.info("prenatal "+prenatal+" postnat "+postnatal);
			int prolongation = util.prolongation(recu);
			int nb_jr_IJ1 = util.nombre_jour_IJ1(recu);
			int nb_jr_IJ2 = 0;
			if(etat.getEtat()==ATTENTE_PROLONGATION) 
				nb_jr_IJ2 = (prenatal + postnatal) - nb_jr_IJ1;
			else 
				nb_jr_IJ2 = (prenatal + postnatal + prolongation) - nb_jr_IJ1;
			double salaire=Double.parseDouble(map.get("salaire").toString());
			double demisalaire=util.demisalaire(salaire);
			double ij=nb_jr_IJ2*demisalaire;
			//long montant = CalculUtil.arrond(ij);
			long montant = calc.arrondPF(ij);
				
			decompte.setDAT(util.getdate(recu, "DAT"));
			decompte.setDAC(util.getdate(recu, "DNA"));
			decompte.setDRT(util.getdate(recu, "DRT"));
			decompte.setNbjourIJ1(util.nombre_jour_IJ1(recu));
			decompte.setPostnatale(postnatal*demisalaire);
			decompte.setPrenatale(prenatal*demisalaire);
			decompte.setIj1(montant);
			decompte.setSalaire(salaire);
			decompte.setDemisalaire(demisalaire);
			decompte.setNbjourpost(postnatal);
			decompte.setNbjourpre(prenatal);
			decompte.setNbprolongation(prolongation);
			decompte.setNbjourIJ1(nb_jr_IJ1);
			decompte.setNbjourIJ2(nb_jr_IJ2);
			Date dateDebPrenatal = util.convertStringToDateUtil(util.getdate(recu, "DAT"), "yyyy-MM-dd");
			decompte.setDate_debut_prenatale(util.convertDateToString(dateDebPrenatal));
			Date dateDebPostNatal = util.DatePlusJour(util.convertStringToDateUtil(util.getdate(recu, "DNA"), "yyyy-MM-dd"), 1);
			decompte.setDate_debut_postnatale(util.convertDateToString(dateDebPostNatal));
			Date dateFinPostNatal = util.DatePlusJour(dateDebPostNatal, postnatal-1);
			decompte.setDate_fin_postnatale(util.convertDateToString(dateFinPostNatal));
			Date dateDebutProlongation = util.DatePlusJour(dateFinPostNatal, 1);
			decompte.setDate_debut_prolongation(util.convertDateToString(dateDebutProlongation));
			Date dateFinProlongation = util.DatePlusJour(dateDebutProlongation, prolongation);
			decompte.setDate_fin_prolongation(util.convertDateToString(dateFinProlongation));
			
			List<TecElemCalcMod> droitIj1 = calcService.findByIdAcc(map.get("idAccIj1").toString());
			
			double oldDroitIJ1 = UtilTraitementDateIJ2.changeEnDouble(droitIj1.get(0).getValeur()); 
			long montantOldDroitIj1 = calc.arrondPF(oldDroitIJ1);
			log.info("nb_jr_IJ2 "+nb_jr_IJ2);
			log.info("demisalaire "+ij);
			log.info("montant arrond"+montant);
			log.info("montantOldDroitIj1 "+montantOldDroitIj1);
			
			/*IJ2Param donnee = new IJ2Param();
			donnee.setDecompte(decompte);
			donnee.setNewdroitIJ1(calc.arrondPF(Double.parseDouble(map.get("droitIJ1").toString())));
			donnee.setNewdroitIJ2(montant);
			donnee.setOldDroitIJ1(montantOldDroitIj1);
			donnee.setDroitTotal(calc.arrondPF(Double.parseDouble(map.get("droitIJ1").toString())) + montant);*/
			
			IJ2Param donnee = new IJ2Param();
			donnee.setDecompte(decompte);
			donnee.setNewdroitIJ1(calc.arrondPF(demisalaire * prenatal));
			donnee.setNewdroitIJ2(calc.arrondPF(demisalaire * postnatal));
			donnee.setOldDroitIJ1(montantOldDroitIj1);
			donnee.setDroitTotal(donnee.getNewdroitIJ1() + donnee.getNewdroitIJ2());
			log.info("donnee "+om.writeValueAsString(donnee));
			return new ResponseEntity<>(donnee, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
