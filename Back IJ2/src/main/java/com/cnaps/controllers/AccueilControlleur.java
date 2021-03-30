package com.cnaps.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.cnaps.models.AccueilMod;
import com.cnaps.models.ParamDemandes;
import com.cnaps.models.RefAccInfoTypMod;
import com.cnaps.models.ReferenceParam;
import com.cnaps.models.TecInfoRecuMod;
import com.cnaps.models.param.DemandeFiltre;
import com.cnaps.models.param.EtatParam;
import com.cnaps.pagination.PageResponse;
import com.cnaps.repository.AccueilRepository;
import com.cnaps.services.AccueilService;
import com.cnaps.services.DemandeService;
import com.cnaps.services.RefAccInfoTypService;
import com.cnaps.services.RefEtatTypService;
import com.cnaps.services.RefTecDmdService;
import com.cnaps.services.TecEtatDossService;
import com.cnaps.services.TecHistoEtatService;
import com.cnaps.services.TecInfoRecuService;
import com.cnaps.utils.ReferenceUtil;

@RestController
public class AccueilControlleur {
	
	ObjectMapper om = new ObjectMapper();
	String resultat;
	public static final Logger log = LoggerFactory.getLogger(AccueilControlleur.class);
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyy");
	Map<String,Object> resultats = new HashMap<String,Object>();
	
	@Autowired
	AccueilService service;
	
	@Autowired
	RefTecDmdService services;
	
	@Autowired
	TecEtatDossService etatDossService;
	
	@Autowired
	TecInfoRecuService tecInfoRecService;
	
	@Autowired
	RefEtatTypService etatService;
	
	@Autowired
	DemandeService dmdService;
	
	@Autowired
	TecHistoEtatService tecHistoEtatService;
	
	@Autowired
	RefAccInfoTypService refAccInfoTypService;
	
	@Autowired
	AccueilRepository repository;
	
	/*@PostMapping("/modifierEtatDmdTransfertEnfantPF")
	public ResponseEntity<Object> modifierEtatDmdTransfertEnfantPF(@RequestBody EtatParam param) {
		try {
			log.info(om.writeValueAsString(param));
			TecHistoEtatMod histo = new TecHistoEtatMod();
            AccueilMod acc = service.getByIdAcc(param.getIdAcc()).get(0);
            if(acc != null) {
            	acc.setUser_modif(param.getUserModif());
                acc.setDate_modif(DateUtil.sqlDateNow());
                service.save(acc);
                
                //TecEtatDossMod tecEtatDoss = etatDossService.getByIdAcc(param.getIdAcc());
                List<TecEtatDossMod> tecEtatDoss = etatDossService.findByIdAcc(param.getIdAcc());
                if(tecEtatDoss.size() != 0) {
                	tecEtatDoss.get(0).setId_type_etat(param.getIdTypeEtat());
                    etatDossService.save(tecEtatDoss.get(0));
                }
                histo.setDateetat(DateUtil.sqlDateNow());
                histo.setIdacc(param.getIdAcc());
                histo.setId_type_etat(param.getIdTypeEtat());
                if(param.getObservations().compareToIgnoreCase("") != 0 || param.getObservations() != null) {
                	histo.setObservations(param.getObservations());
                }
                histo.setUserModif(param.getUserModif());
                tecHistoEtatService.save(histo);
            }
            resultat = om.writeValueAsString(acc);
			return new ResponseEntity<>(histo, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}
	}*/
	
	@PostMapping("/modifierEtatDmdTransfertEnfantPF")
	public ResponseEntity<Object> modifierEtatDmdTransfertEnfantPF(@RequestBody EtatParam param) {
		try {
			log.info(om.writeValueAsString(param));
			AccueilMod newAcc = new AccueilMod();
			String date = simpleDateFormat.format(new Date(Calendar.getInstance().getTime().getTime()));
			AccueilMod acc = service.getByIdAccIsAndLast(param.getIdAcc());
			if(acc != null) {
				acc.setLast(false);
				service.save(acc);
				newAcc.setDate_dossier(acc.getDate_dossier());
				newAcc.setDate_modif(new Date(Calendar.getInstance().getTime().getTime()));
				newAcc.setDateInsertion(acc.getDateInsertion());
				newAcc.setEtat(param.getIdTypeEtat());
				newAcc.setId_acc(acc.getId_acc());
				newAcc.setId_empl(acc.getId_empl());
				newAcc.setId_individu(acc.getId_individu());
				if(acc.getId_succursale() != null)
					newAcc.setId_succursale(acc.getId_succursale());
				newAcc.setId_tec_dmd(acc.getId_tec_dmd());
				newAcc.setIdAccNew(date+service.seqDemande());
				newAcc.setLast(true);
				if(acc.getNum_doss() != null)
					newAcc.setNum_doss(acc.getNum_doss());
				if(param.getObservations() != null)
					newAcc.setObservations(param.getObservations());
				if(param.getObservationsSem() != null)
					newAcc.setObservationsSem(param.getObservationsSem());
				newAcc.setUser_insert(acc.getUser_insert());
				newAcc.setUser_modif(param.getUserModif());
				service.save(newAcc);
				return new ResponseEntity<>(newAcc, HttpStatus.OK);
			}else
				return new ResponseEntity<>(newAcc, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/*@PostMapping("/listeDmdTransfertEnfantPF")
	public ResponseEntity<Object> listeDmdTransfertEnfantPF(@RequestBody DemandeParam param) {
		try {
			log.info(om.writeValueAsString(param));
            List<DemandeMod> listeDemande = dmdService.getAllDmdEnfant(param);
            List<ParamDemandeEnfant> liste = new ArrayList<>();
            for(int i=0;i<listeDemande.size();i++) {
            	ParamDemandeEnfant dmd = new ParamDemandeEnfant();
        		AccueilMod acc = service.getByIdAcc(listeDemande.get(i).getReference()).get(0);
        		if(acc != null) {
        			AccueilEnfantMod accueil = new AccueilEnfantMod();
        			accueil.setIdAcc(acc.getId_acc());
        			accueil.setDateInsertion(acc.getDateInsertion());
        			accueil.setIdEmpl(acc.getId_empl());
        			accueil.setIdIndividu(acc.getId_individu());
        			accueil.setIdSuccursale(acc.getId_succursale());
        			accueil.setIdTecDmd(acc.getId_tec_dmd());
        			accueil.setNumDoss(acc.getNum_doss());
        			accueil.setUserInsert(acc.getUser_insert());
        			accueil.setUserModif(acc.getUser_modif());
        			dmd.setAccueil(accueil);
            		dmd.setEtat(listeDemande.get(i).getEtat());
            		liste.add(dmd);
        		}
        	}
			return new ResponseEntity<>(liste, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}*/
	
	@PostMapping("/listeDmdTransfertEnfantPF")
	public ResponseEntity<Object> prendListeDmdPF(@RequestBody DemandeFiltre param) {
		try {
			log.info("filtre pf : "+om.writeValueAsString(param));
			Page<AccueilMod> liste = service.getByIdIndividuAndIdAccAndDateReceptionAndIdTecDmd(param);
			return new ResponseEntity<>(new PageResponse<>(liste.getContent(), liste.getTotalPages()), HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/findbyidAccueil")
	public ResponseEntity<Object> findbyidAccueil(@RequestBody String param) {
		try {
			log.info(param);
			return new ResponseEntity<>(service.getByIdAccIsAndLast(param), HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PostMapping("/listeDemandeByIndivIJ")
	public ResponseEntity<Object> listeDemandeByIndivIJ(@RequestBody String param) {
		try {
			log.info(param);
			return new ResponseEntity<>(service.getByIdIndividuAndLast(param), HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * @description Selection par prestation demande et matricule individu pour avoir la référence
	 * @param ParamDemandes param
	 * @return ResponseEntity
	 */
	@PostMapping(path = "/referenceDemandeByPrestationAndIndividu")
	public ResponseEntity<Object> referenceDemandeByPrestationAndIndividu(@RequestBody ParamDemandes param) {
		try {
			log.info(om.writeValueAsString(param));
			AccueilMod accueil = new AccueilMod();
			List<AccueilMod> liste = repository.findByIdIndividuWithPrestation(param.getId_individu(), param.getPrestation());
			if(liste.size() != 0) 
				accueil = liste.get(0);
			return new ResponseEntity<>(accueil, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/prendReferencePF")
	public ResponseEntity<Object> prendReferencePF(@RequestBody ReferenceParam param) {
		try {
			log.info("reference pf : "+om.writeValueAsString(param));
			String reference = ReferenceUtil.getReferenceDemande(param.getPrestation(),service.seqAccNews(),param.getDr());
			resultats.put("reference", reference);
			return new ResponseEntity<>(resultats, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/prendInfoRecuParIdAccPF")
	public ResponseEntity<Object> prendInfoRecuParIdAccPF(@RequestParam(name="reference") String param) {
		try {
			log.info(param);
			List<TecInfoRecuMod> listeInfo = tecInfoRecService.findByIdAccueil(param);
			for(int i=0;i<listeInfo.size();i++) {
				RefAccInfoTypMod acc = refAccInfoTypService.getById_type_info(listeInfo.get(i).getIdTypeInfo());
				listeInfo.get(i).setRefAccInfoTypMod(acc);
			}
			return new ResponseEntity<>(listeInfo, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/prendInfoRecuParIdAccAndIdTypeInfoPF")
	public ResponseEntity<Object> prendInfoRecuParIdAccAndIdTypeInfoPF(@RequestParam(name="reference") String param,@RequestParam(name="idTypeInfo") String idTypeInfo) {
		try {
			log.info("io "+param+" "+idTypeInfo);
			return new ResponseEntity<>(tecInfoRecService.getByIdAccIsAndIdTypeInfoIs(param, Integer.parseInt(idTypeInfo)), HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/modifierInfoRecuParIdAccPF")
	public ResponseEntity<Object> modifierInfoRecuParIdAccPF(@RequestBody List<TecInfoRecuMod> liste) {
		try {
			log.info(om.writeValueAsString(liste));
			for(TecInfoRecuMod list : liste) {
				TecInfoRecuMod verifinfo = tecInfoRecService.getByIdAccIsAndIdTypeInfoIs(list.getIdAcc(), list.getIdTypeInfo());
				if(verifinfo != null) {
					verifinfo.setValeur(list.getValeur());
					tecInfoRecService.save(verifinfo);
				}
			}
			return new ResponseEntity<>(liste, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
