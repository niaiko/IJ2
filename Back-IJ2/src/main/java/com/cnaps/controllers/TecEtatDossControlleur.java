package com.cnaps.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cnaps.services.AccueilService;
import com.cnaps.services.RefEnfantNeService;
import com.cnaps.services.TecElemCalcService;
import com.cnaps.services.TecEtatDossService;
import com.cnaps.services.TecHistoEtatService;
import com.cnaps.services.TecInfoRecuService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class TecEtatDossControlleur {
	ObjectMapper om=new ObjectMapper();
	String resultat;
	String historique;
	String nom="TecEtatDoss";
	
	private static final Logger log = LoggerFactory.getLogger(TecEtatDossControlleur.class);
	
	@Autowired
	TecEtatDossService service;
	
	@Autowired
	AccueilService accService;
	
	@Autowired
	TecHistoEtatService histoetat_service;
	
	@Autowired
	TecElemCalcService tecElemCalcService;
	
	@Autowired
	RefEnfantNeService refEnfantNeService;
	
	@Autowired
	TecInfoRecuService tecInfoRecuService;
	
	/*@PostMapping("/etatDossierPF")
	public ResponseEntity<Object> etatDossierPF(@RequestBody String param) {
		try {
			log.info(param);
			TecEtatDossMod etat = new TecEtatDossMod();
			List<TecEtatDossMod> etatDoss=service.findByIdAcc(param);
			if(etatDoss.size() != 0)
				etat = etatDoss.get(0);
			return new ResponseEntity<>(etat, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}*/
	
	/*@PostMapping("/changerEtatDemandePF")
	public ResponseEntity<Object> changerEtatDemandePF(@RequestBody ParamEtatDoss param) {
		try {
			log.info(om.writeValueAsString(param));
			TecEtatDossMod tecEtatDoss = service.findByIdAcc(param.getIdacc()).get(0);
			if(tecEtatDoss != null) {
				tecEtatDoss.setId_type_etat(param.getEtat());
				tecEtatDoss.setDate_etat(DateUtil.sqlDateNow());
				service.save(tecEtatDoss);
			}
			/*TecEtatDossMod newTecEtatDoss = new TecEtatDossMod();
			newTecEtatDoss.setDate_etat(DateUtil.sqlDateNow());
			newTecEtatDoss.setId_acc(param.getIdacc());
			newTecEtatDoss.setId_op(tecEtatDoss.getId_op());
			newTecEtatDoss.setId_type_etat(param.getEtat());
			newTecEtatDoss.setId_etat(tecEtatDoss.getId_etat());
			service.save(newTecEtatDoss);
			TecHistoEtatMod histo = new TecHistoEtatMod();
			histo.setId_type_etat(param.getEtat());
			histo.setDateetat(DateUtil.sqlDateNow());
			histo.setIdacc(param.getIdacc());
			histoetat_service.save(histo);
			return new ResponseEntity<>(tecEtatDoss, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}*/
	
	/*@PostMapping("/modifierEtatDmdPF")
	public ResponseEntity<Object> modifierEtatDmdPF(@RequestBody EtatParam param) {
		try {
			log.info(om.writeValueAsString(param));
			TecEtatDossMod tecEtatDoss = service.findByIdAcc(param.getIdAcc()).get(0);
			if(tecEtatDoss != null) {
				tecEtatDoss.setId_type_etat(param.getIdTypeEtat());
				tecEtatDoss.setDate_etat(DateUtil.sqlDateNow());
				service.save(tecEtatDoss);
			}
			/*TecEtatDossMod newTecEtatDoss = new TecEtatDossMod();
			newTecEtatDoss.setDate_etat(DateUtil.sqlDateNow());
			newTecEtatDoss.setId_acc(param.getIdAcc());
			newTecEtatDoss.setId_op(tecEtatDoss.getId_op());
			newTecEtatDoss.setId_type_etat(param.getIdTypeEtat());
			newTecEtatDoss.setId_etat(tecEtatDoss.getId_etat());
			service.save(newTecEtatDoss);
			TecHistoEtatMod histo = new TecHistoEtatMod();
			histo.setId_type_etat(param.getIdTypeEtat());
			histo.setDateetat(DateUtil.sqlDateNow());
			histo.setIdacc(param.getIdAcc());
			histo.setObservations(param.getObservations());
			histo.setObservationsSem(param.getObservationsSem());
			histo.setUserModif(param.getUserModif());
			histoetat_service.save(histo);
			//service.save(newTecEtatDoss);
			return new ResponseEntity<>(tecEtatDoss, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}*/
	
	
	/*@PostMapping("/modifierMontantRFA")
	public ResponseEntity<Object> modifierMontantRFA(@RequestBody String param) {
		try {
			log.info(om.writeValueAsString(param));
			Map<String,Object> res = new HashMap<String,Object>();
			Map<String, Object> map = om.readValue(param, new TypeReference<Map<String, Object>>(){});
			AccueilMod acc = accService
			List<TecEtatDossMod> etat = service.findByIdAcc(map.get("idAcc").toString());
			if(etat.get(0).getId_etat() == 3) {
				res.put("estEffectue", false);
				res.put("message", "Ce montant n'est plus modifiable");
			}else {
				TecInfoRecuMod recu = new TecInfoRecuMod();
				recu.setIdAcc(map.get("idAcc").toString());
				//recu.setId_recu(map.get("idRecu").toString());
				recu.setValeur(map.get("valeur").toString());
				//recu.setRefAccInfoTypMod(refAccInfoTypMod);
				recu.setIdTypeInfo(Integer.parseInt(map.get("idTypeInfo").toString()));
				tecInfoRecuService.save(recu);
				res.put("estEffectue", true);
			}
			return new ResponseEntity<>(res, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}*/
}
