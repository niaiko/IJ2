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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cnaps.models.AccueilMod;
import com.cnaps.models.DataAp;
import com.cnaps.models.DemandeIJMod;
import com.cnaps.models.Individu;
import com.cnaps.models.IndividuAp;
import com.cnaps.models.InfoDmdAP;
import com.cnaps.models.InfoDmdApIndividuMod;
import com.cnaps.models.ListeDmdPf;
import com.cnaps.models.ParamDernierDmd;
import com.cnaps.models.ParamEtatDoss;
import com.cnaps.models.RefEtatTypMod;
import com.cnaps.models.TecInfoRecuMod;
import com.cnaps.models.param.DemandeFiltre;
import com.cnaps.models.param.HistoriqueDemandeMod;
import com.cnaps.models.param.ParamPfDmdAf;
import com.cnaps.models.param.PfDmdAfMod;
import com.cnaps.pagination.PageResponse;
import com.cnaps.repository.AccueilRepository;
import com.cnaps.repository.IndividuRepository;
import com.cnaps.repository.ListeDmdPfRepository;
import com.cnaps.services.AccueilService;
import com.cnaps.services.DemandeIJService;
import com.cnaps.services.RefAccInfoTypService;
import com.cnaps.services.RefEtatTypService;
import com.cnaps.services.TecHistoEtatService;
import com.cnaps.services.TecInfoRecuService;
import com.cnaps.utils.DateUtil;
import com.cnaps.utils.RequestApi;
//import mg.cnaps.utils.RequestApi;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class DemandeIJControlleur {
	private static final Logger log = LoggerFactory.getLogger(DemandeIJControlleur.class);
	ObjectMapper om = new ObjectMapper();
	String resultat;
	String nom = "demandeIJ";
	String historique;
	static int VALIDATION_SEM = 8;
	static int VALIDATION_PRG_SEM = 9;

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyy");

	@Autowired
	private RequestApi request;

	@Autowired
	DemandeIJService service;

	@Autowired
	TecHistoEtatService StateHistory;

	@Autowired
	AccueilService services;

	@Autowired
	RefAccInfoTypService refAccInfoServices;

	@Autowired
	TecInfoRecuService tecInfoRecuService;

	@Autowired
	RefEtatTypService refEtatTypService;

	@Autowired
	AccueilRepository aRepository;

	@Autowired
	IndividuRepository indivRepository;

	@Autowired
	ListeDmdPfRepository lRepository;

	@GetMapping(value = "/verifierAvantDmdAlsp/{id}")
	public ResponseEntity<Object> verifier(@PathVariable String id) {
		try {
			List<AccueilMod> list = aRepository.prendListidIndiv(id);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/ajouterDemandePF")
	public ResponseEntity<Object> demandeIJPF(@RequestBody DemandeIJMod data,
			@RequestHeader(value = "Authorization") String token) {
		try {
			log.info("filtre pf : " + om.writeValueAsString(data));
			String prestation = data.getAccueilMod().getId_tec_dmd();
			int etat = 1;

			if (prestation.compareToIgnoreCase("430") == 0) {
				etat = VALIDATION_SEM;
			}
			if (service.prolongationIJ2(data)) {
				etat = VALIDATION_SEM;
			}

			service.enregistrerDemande(data, etat, token);
			/* historique demande */

			HistoriqueDemandeMod historiqueDemande = new HistoriqueDemandeMod();
			historiqueDemande.setDate_dmd(DateUtil.sqlDateNow());
			historiqueDemande.setId_demande(data.getAccueilMod().getId_acc());
			historiqueDemande.setMatricule_demandeur(data.getAccueilMod().getId_individu());
			historiqueDemande.setType_dmd(data.getAccueilMod().getId_tec_dmd());

			request.sendPost("http://cnapsHistoGen:5140/savehistodmd", om.writeValueAsString(historiqueDemande), token);
			return new ResponseEntity<>(data.getAccueilMod(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	// MODIFIER

	@PostMapping("/prendListeDemandePF")
	public ResponseEntity<Object> prendListeDmdPF(@RequestBody DemandeFiltre param) {
		try {
			Pageable pageable = PageRequest.of(param.getPagination() - 1, param.getTaille());
			if (param.getPrestation() != null && (param.getNom() == null || param.getNom().equals(""))
					&& (param.getPrenom() == null || param.getPrenom().equals(""))
					&& (param.getMatricule() == null || param.getMatricule().equals(""))
					&& (param.getReference() == null || param.getReference().equals(""))) {
				Page<AccueilMod> liste = services.getByIdIndividuAndIdAccAndDateReceptionAndIdTecDmd(param);
				if (liste.getContent().size() != 0) {
					for (int i = 0; i < liste.getContent().size(); i++) {
						RefEtatTypMod etat = refEtatTypService.getByIdTypeEtat(liste.getContent().get(i).getEtat());
						Individu individu = indivRepository
								.findByIdIndividu(liste.getContent().get(i).getId_individu());
						if (etat != null && individu != null) {
							liste.getContent().get(i).setLibelle_etat(etat.getLibelle());
							liste.getContent().get(i).setNom(individu.getNom());
							liste.getContent().get(i).setPrenoms(individu.getPrenoms());
							liste.getContent().get(i).setIdSexe(individu.getIdSexe());
						}

					}
				}
				return new ResponseEntity<>(new PageResponse<>(liste.getContent(), liste.getTotalPages()),
						HttpStatus.OK);
			} else {
				Page<ListeDmdPf> liste = lRepository.findByIdIndividuAndIdAccAndDateReceptionAndIdTecDmd(param,
						pageable);
				if (liste.getContent().size() != 0) {
					for (int i = 0; i < liste.getContent().size(); i++) {
						RefEtatTypMod etat = refEtatTypService.getByIdTypeEtat(liste.getContent().get(i).getEtat());
						Individu individu = indivRepository
								.findByIdIndividu(liste.getContent().get(i).getId_individu());
						if (etat != null || individu != null)
							liste.getContent().get(i).setLibelle_etat(etat.getLibelle());
						liste.getContent().get(i).setNom(individu.getNom());
						liste.getContent().get(i).setPrenoms(individu.getPrenoms());
						liste.getContent().get(i).setIdSexe(individu.getIdSexe());
					}
				}
				return new ResponseEntity<>(new PageResponse<>(liste.getContent(), liste.getTotalPages()),
						HttpStatus.OK);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/prendDetailDemandePF")
	public ResponseEntity<Object> detailDemande(@RequestParam(name = "reference") String reference) {
		try {
			log.info(reference);
			return new ResponseEntity<>(service.detailDemande(reference), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/changerEtatDemandePF")
	public ResponseEntity<Object> changerEtatDemandePF(@RequestBody ParamEtatDoss param) {
		try {
			log.info(om.writeValueAsString(param));
			AccueilMod newAcc = new AccueilMod();
			String date = simpleDateFormat.format(new Date(Calendar.getInstance().getTime().getTime()));
			AccueilMod acc = services.getByIdAccIsAndLast(param.getIdacc());
			if (acc != null) {
				acc.setLast(false);
				services.save(acc);
				newAcc.setDate_dossier(acc.getDate_dossier());
				newAcc.setDate_modif(new Date(Calendar.getInstance().getTime().getTime()));
				newAcc.setDateInsertion(acc.getDateInsertion());
				newAcc.setEtat(param.getEtat());
				newAcc.setId_acc(acc.getId_acc());
				newAcc.setId_empl(acc.getId_empl());
				newAcc.setId_individu(acc.getId_individu());
				if (param.getObservation() != null)
					newAcc.setObservations(param.getObservation());
				if (param.getObservationSem() != null)
					newAcc.setObservationsSem(param.getObservationSem());
				if (acc.getId_succursale() != null)
					newAcc.setId_succursale(acc.getId_succursale());
				newAcc.setId_tec_dmd(acc.getId_tec_dmd());
				newAcc.setIdAccNew(date + services.seqDemande());
				newAcc.setLast(true);
				if (acc.getNum_doss() != null)
					newAcc.setNum_doss(acc.getNum_doss());
				newAcc.setUser_insert(acc.getUser_insert());
				newAcc.setUser_modif(param.getUserModif());
				services.save(newAcc);
				return new ResponseEntity<>(newAcc, HttpStatus.OK);
			} else
				return new ResponseEntity<>(newAcc, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/modifierMontantRFA")
	public ResponseEntity<Object> modifierMontantRFA(@RequestBody String param) {
		try {
			log.info(om.writeValueAsString(param));
			Map<String, Object> res = new HashMap<String, Object>();
			Map<String, Object> map = om.readValue(param, new TypeReference<Map<String, Object>>() {
			});
			AccueilMod acc = services.getByIdAccIsAndLast(map.get("idAcc").toString());
			if (acc.getEtat() == 3) {
				res.put("estEffectue", false);
				res.put("message", "Ce montant n'est plus modifiable");
			} else {
				TecInfoRecuMod recu = new TecInfoRecuMod();
				recu.setIdAcc(map.get("idAcc").toString());
				recu.setValeur(map.get("valeur").toString());
				recu.setIdTypeInfo(Integer.parseInt(map.get("idTypeInfo").toString()));
				tecInfoRecuService.save(recu);
				res.put("estEffectue", true);
			}
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/etatDossierPF")
	public ResponseEntity<Object> etatDossierPF(@RequestBody String param) {
		try {
			log.info(param);
			AccueilMod accueilMod = services.getByIdAccIsAndLast(param);
			return new ResponseEntity<>(accueilMod, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/validerDemandeAF")
	public ResponseEntity<Object> validerDemandeAF(@RequestBody ParamPfDmdAf param,
			@RequestHeader(value = "Authorization") String token) {
		try {
			log.info(om.writeValueAsString(param));
			AccueilMod newAcc = new AccueilMod();
			String date = simpleDateFormat.format(new Date(Calendar.getInstance().getTime().getTime()));
			AccueilMod acc = services.getByIdAccIsAndLast(param.getReference());
			if (acc != null) {
				acc.setUser_insert(acc.getUser_insert());
				acc.setUser_modif(param.getDafUserSaisie());
				acc.setDate_modif(new Date(Calendar.getInstance().getTime().getTime()));
				acc.setLast(false);
				services.save(acc);
				newAcc.setDate_dossier(acc.getDate_dossier());
				newAcc.setDate_modif(new Date(Calendar.getInstance().getTime().getTime()));
				newAcc.setDateInsertion(acc.getDateInsertion());
				newAcc.setEtat(3);
				newAcc.setId_mode_paiement_tiers(acc.getId_mode_paiement_tiers());
				newAcc.setId_acc(acc.getId_acc());
				newAcc.setType(acc.getType());
				newAcc.setId_empl(acc.getId_empl());
				newAcc.setId_individu(acc.getId_individu());
				if (acc.getId_succursale() != null)
					newAcc.setId_succursale(acc.getId_succursale());
				newAcc.setId_tec_dmd(acc.getId_tec_dmd());
				newAcc.setIdAccNew(date + services.seqDemande());
				newAcc.setLast(true);
				if (acc.getNum_doss() != null)
					newAcc.setNum_doss(acc.getNum_doss());
				newAcc.setUser_insert(acc.getUser_insert());
				newAcc.setUser_modif(param.getDafUserSaisie());
				services.save(newAcc);
				PfDmdAfMod pfDmdAf = new PfDmdAfMod();
				pfDmdAf.setAccueilValeur(acc);
				pfDmdAf.setCodeDr(acc.getId_acc().substring(acc.getId_acc().length() - 2, acc.getId_acc().length()));
				pfDmdAf.setDafUserSaisie(param.getDafUserSaisie());
				pfDmdAf.setListeEnfant(param.getListeEnfant());
				pfDmdAf.setSme(param.getSme());
				request.sendPost("http://cnapsPerBaf:3000/ajoutValidationDemandeAF", om.writeValueAsString(pfDmdAf),
						token.replace("Bearer ", ""));
				return new ResponseEntity<>(newAcc, HttpStatus.OK);
			} else
				return new ResponseEntity<>(newAcc, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(path = "/mettreAjourDmdEmplPF")
	public ResponseEntity<Object> updateEmpl(@RequestBody AccueilMod acc) {
		try {
			services.updateEmpl(acc.getId_empl(), acc.getId_succursale(), acc.getId_acc());
			resultat = om.writeValueAsString(acc);
			return new ResponseEntity<>(resultat, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * prendre derinier demande ap
	 */
	@GetMapping("/getDernierDmdAPByIndv")
	public ResponseEntity<Object> findLastdemandeAp(@RequestParam(name = "matricule") String matricule,
			@RequestHeader(value = "Authorization") String token) {
		try {

			InfoDmdApIndividuMod infoIndivAp = new InfoDmdApIndividuMod();

			if (!getDernierDmdAP(matricule).getValeur().equals(null)
					|| getDernierDmdAP(matricule).getValeur() != null) {
				InfoDmdAP infoAp = getDernierDmdAP(matricule);
				IndividuAp indivAp = new IndividuAp();
				DataAp dataAp = new DataAp(infoAp.getValeur(), matricule);
				System.out.println("InfoDmdAP if" + om.writeValueAsString(infoAp));
				indivAp = om.readValue(request.sendPost("http://cnapsdbIndiv:3001/getDernierEnfant",
						om.writeValueAsString(dataAp), token), IndividuAp.class);

				infoIndivAp = new InfoDmdApIndividuMod(infoAp.getId_acc(), infoAp.getId_tec_dmd(),
						infoAp.getId_type_info(), infoAp.getValeur(), indivAp.getNom(), indivAp.getPrenoms(),
						indivAp.getDate_naissance(), infoAp.getEtat(), infoAp.getLibelleEtat());

			}

			return new ResponseEntity<>(infoIndivAp, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
	}

	public InfoDmdAP getDernierDmdAP(String matricule) {
		try {

			InfoDmdAP infoAp = new InfoDmdAP();
			List<Object> list = aRepository.getDerinierDmdAP(matricule);
			System.out.println("list" + om.writeValueAsString(list));
			if (!list.isEmpty()) {
				for (int i = 0; i < list.size(); i++) {
					Object object = list.get(i);
					Object[] objects = (Object[]) object;
					infoAp.setId_acc((String) objects[0]);
					infoAp.setId_tec_dmd((String) objects[1]);
					infoAp.setId_type_info((Integer) objects[2]);
					infoAp.setValeur((String) objects[3]);
					infoAp.setEtat((Integer) objects[4]);
					infoAp.setLibelleEtat((String) objects[5]);
				}

			}
			return infoAp;
		} catch (Exception e) {
			e.getMessage();
			return null;
		}

	}

	@GetMapping(value = "/prendDernierDmdValider/{individu}")
	public ResponseEntity<Object> prendDernierDmdValider(@PathVariable String individu) {
		try {
			List<Object> liste = aRepository.findDernierDmdPf(individu);
			int size = liste.size();
			ParamDernierDmd dmd = new ParamDernierDmd();
			String dateDpa = null;
			String dateDpaApres = null;
			for (int i = 0; i < size; i++) {
				Object object = liste.get(i);
				Object[] objects = (Object[]) object;
				dmd.setIndividu((String) objects[0]);
				dmd.setEmployeur((String) objects[1]);
				dmd.setIdacc((String) objects[2]);
				dmd.setIdTecDmd((String) objects[3]);
				dmd.setDateInsertion((Date) objects[4]);
				dmd.setEtat((Integer) objects[5]);
				dmd.setNumDoss((String) objects[6]);
				dmd.setDateDossier((Date) objects[7]);
				dateDpa = aRepository.dateDpa(dmd.getIdacc());
				dmd.setDateDpa(dateDpa);

				dateDpaApres = dmd.getDateDpa();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date parsed = format.parse(dateDpaApres);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new java.util.Date());
				calendar.add(Calendar.MONTH, 8);
				parsed = calendar.getTime();
				dmd.setDateDpaApres(parsed);
				log.info("DPA " + parsed);
				java.util.Date date = new java.util.Date();
				if (date.after(dmd.getDateDpaApres())) {
					dmd.setFlagDateDpa(false);
				} else {
					dmd.setFlagDateDpa(true);
				}
			}
			return new ResponseEntity<>(dmd, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		}
	}
}
