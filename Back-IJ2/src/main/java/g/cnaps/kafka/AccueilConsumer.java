package g.cnaps.kafka;

import org.springframework.stereotype.Component;

@Component
public class AccueilConsumer {

	/*ObjectMapper om = new ObjectMapper();
	String resultat;
	String nom = "Accueil";
	
	private static final Logger log = LoggerFactory.getLogger(DemandeConsumer.class);
	@Autowired
	Producer producer;
	
	@Autowired
	AccueilService service;
	
	@Autowired
	DemandeService services;
	
	@Autowired
	RefEnfantNeService refEnfantNeService;
	
	@Autowired
	TecHistoEtatService histoetat_service;
	
	@KafkaListener(topics = "listeAccueilreq")
	public void liste(ConsumerRecord<?, ?> record) {
		try {
			List<AccueilMod> liste = service.getAll(Integer.parseInt(record.value().toString()));
			resultat = om.writeValueAsString(liste);
			producer.send(record.key().toString(), "liste" + nom + "res", resultat);
		} catch (Exception e) {
			producer.send(record.key().toString(), "liste" + nom + "res", e.getMessage());
		}
	}
	
	
	
	@KafkaListener(topics = "listHistoEtatreq")
	public void listehistoEtat(ConsumerRecord<?, ?> record) {
		try {
			List<TecHistoEtatMod> liste = histoetat_service.findDemandeStatusByidacc(record.value().toString());
			resultat = om.writeValueAsString(liste);
			producer.send(record.key().toString(), "listHistoEtatres", resultat);
		} catch (Exception e) {
			producer.send(record.key().toString(), "listHistoEtatres", e.getMessage());
		}
	}


	
	@KafkaListener(topics = "referenceDemandeByPrestationAndIndividureq")
	public void accueilByPrestationAndIndividureq(ConsumerRecord<?, ?> record) {
		try {
			log.info(record.value().toString());
			ParamDemandes param = om.readValue(record.value().toString(), ParamDemandes.class);
			List<AccueilMod> liste = service.getbyidIndivAndPrestation(param.getId_individu(), param.getPrestation());
			if(liste.size()>0) {
				producer.send(record.key().toString(), "referenceDemandeByPrestationAndIndividures", om.writeValueAsString(liste.get(0)));
			}else {
				producer.send(record.key().toString(), "referenceDemandeByPrestationAndIndividures", "Il n y a pas de demande");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			producer.send(record.key().toString(), "referenceDemandeByPrestationAndIndividures", e.getMessage());
		}
	}
	
	@KafkaListener(topics = "controleIJreq")
	public void controleIJreq(ConsumerRecord<?, ?> record) {
		try {
			if(record.value().toString().length()!=0) {
//				List<AccueilMod> liste = service.getbyidIndiv(record.value().toString());
				List<AccueilMod> liste = service.getbyidIndivAndPrestation(record.value().toString(), "421");
				if(liste.size()!=0) {
					producer.send(record.key().toString(), "controleMoisIJreq",liste.get(0).getId_acc()); 
				}
				else {
					producer.send(record.key().toString(), "controleIJres", "{\"message\":\"true\"}");
				}
			}else {
				producer.send(record.key().toString(), "controleIJres", "{\"message\":\"false\"}");
			}
			
		} catch (Exception e) {
			producer.send(record.key().toString(), "controleIJres", e.getMessage());
		}
	}
	
	
	@KafkaListener(topics = "controlePFreq")
	public void controlePFreq(ConsumerRecord<?, ?> record) {
		try {
				ControlePFparamMod param = om.readValue(record.value().toString(), ControlePFparamMod.class);
				List<AccueilMod> liste = service.getbyidIndivAndPrestation(param.getId_individu(), param.getPrestation());
				if(liste.size()!=0) {
					if(param.getPrestation()=="411") {
						producer.send(record.key().toString(), "controlePFres","{\"message\":\"true\"}");
					}
					if(param.getPrestation()=="412") {
						producer.send(record.key().toString(), "controlePFres","{\"message\":\"true\"}");
					}
					if(param.getPrestation()=="413") {
						List<AccueilMod> liste412 = service.getbyidIndivAndPrestation(param.getId_individu(),"412");
						if(liste412.size()!=0) {
							producer.send(record.key().toString(), "controlePFres","{\"message\":\"true\"}"); 
						}else {
							producer.send(record.key().toString(), "controlePFres","{\"message\":\"false\"}"); 
						}
					}
					if(param.getPrestation()=="421") {
						producer.send(record.key().toString(), "controleMoisIJreq",liste.get(0).getId_acc()); 
					}
					if(param.getPrestation()=="422") {
						List<AccueilMod> liste421 = service.getbyidIndivAndPrestation(param.getId_individu(),"421");
						if(liste421.size()!=0) {
							producer.send(record.key().toString(), "controlePFres","{\"message\":\"true\"}"); 
						}else {
							producer.send(record.key().toString(), "controlePFres","{\"message\":\"false\"}"); 
						}
					}
					
				}
				else {
					producer.send(record.key().toString(), "controlePFres", "{\"message\":\"true\"}");
				}
		} catch (Exception e) {
			producer.send(record.key().toString(), "controlePFres", e.getMessage());
		}
	}

	@KafkaListener(topics = "findbyidAccueilreq")
	public void findbyid(ConsumerRecord<?, ?> record) {
		try {
			AccueilMod acces = service.getById(record.value().toString());
			resultat = om.writeValueAsString(acces);
			producer.send(record.key().toString(), "findbyidAccueilres", resultat);
		} catch (Exception e) {
			producer.send(record.key().toString(), "findbyidAccueilres", e.getMessage());
		}
	}

	@KafkaListener(topics = "pageAccueilreq")
	public void nombredepage(ConsumerRecord<?, ?> record) {
		try {
			int page = service.nombrepage();
			resultat = om.writeValueAsString(page);
			producer.send(record.key().toString(), "page" + nom + "res", resultat);
		} catch (Exception e) {
			producer.send(record.key().toString(), "page" + nom + "res", e.getMessage());
		}
	}

	@KafkaListener(topics = "ajoutAccueilreq")
	public void ajout(ConsumerRecord<?, ?> record) {
		try {
			log.info(record.value().toString());
			AccueilMod acc = om.readValue(record.value().toString(), AccueilMod.class);
			acc.setDateInsertion(DateUtil.sqlDateNow());
		    service.save(acc);
			producer.send(record.key().toString(), "ajout" + nom + "res", "success");
		} catch (Exception e) {
			producer.send(record.key().toString(), "ajout" + nom + "res", e.getMessage());
		}
	}

	@KafkaListener(topics = "majAccueilreq")
	public void maj(ConsumerRecord<?, ?> record) {
		try {
			
			service.save(om.readValue(record.value().toString(), AccueilMod.class));
			producer.send(record.key().toString(), "maj" + nom + "res", "success");
		} catch (Exception e) {
			producer.send(record.key().toString(), "maj" + nom + "res", e.getMessage());
		}
	}

	@KafkaListener(topics = "supprAccueilreq")
	public void suppr(ConsumerRecord<?, ?> record) {
		try {
			service.delete(om.readValue(record.value().toString(), AccueilMod.class));
			producer.send(record.key().toString(), "suppr" + nom + "res", "succes");
		} catch (Exception e) {
			producer.send(record.key().toString(), "suppr" + nom + "res", e.getMessage());
		}
	}
	@KafkaListener(topics = "listeDemandeByIndivReq")
	public void listedemandeAveByetat(ConsumerRecord<?, ?> record) {
		try {
//			 record.value().toString() 
			List<AccueilMod> liste = service.getbyidIndiv(record.value().toString());
			resultat = om.writeValueAsString(liste);
			producer.send(record.key().toString(), "listeDemandeByIndivRes", resultat);
		} catch (Exception e) {
			e.printStackTrace();
			producer.send(record.key().toString(), "listeDemandeByIndivRes", e.getMessage());
		}
	}
	
	/* liste demande RFA */
	
	/*@KafkaListener(topics = "prendListeDmdRFAreq")
    public void listeDmd(ConsumerRecord<?, ?> record) {
        try {
            log.info(record.value().toString());
            DemandeParam param = om.readValue(record.value().toString(), DemandeParam.class);
            List<ParamDemande> liste = new ArrayList<>();
            List<DemandeMod> listeDemande = services.getAllDmd(param, param.getPagination());
            for(int i=0;i<listeDemande.size();i++) {
            	ParamDemande dmd = new ParamDemande();
        		AccueilMod acc = service.getByIdAcc(listeDemande.get(i).getReference());
        		List<RefEnfantNeMod> listeEnfant = refEnfantNeService.findByIdAccueil(acc.getId_acc());
        		if(listeEnfant.size() != 0) {
        			dmd.setListeEnfant(listeEnfant);
        		}
        		dmd.setAccueil(acc);
        		dmd.setEtat(listeDemande.get(i).getEtat());
        		liste.add(dmd);
            }
            //DemandeMod filtre = new DemandeMod();
            /*if(param.getFiltre().getDate() == null && param.getFiltre().getEtat() == 0 && param.getFiltre().getIdIndividu().compareTo("") == 0 && param.getFiltre().getReference().compareTo("") == 0 && param.getFiltre().getDr().compareTo("") == 0) {
            	listeDemande = services.getSearchAll(param.getPagination());
            	for(int i=0;i<listeDemande.size();i++) {
            		ParamDemande dmd = new ParamDemande();
            		AccueilMod acc = service.getByIdAcc(listeDemande.get(i).getReference());
            		dmd.setAccueil(acc);
            		dmd.setEtat(listeDemande.get(i).getEtat());
            		liste.add(dmd);
            	}
            }else {
            	if(param.getFiltre().getReference().compareTo("") == 0 || param.getFiltre().getReference() == null) {
            		if(param.getFiltre().getDate() == null) {
            			filtre.setReference(param.getFiltre().getDr());
                		filtre.setEtat(param.getFiltre().getEtat());
                		filtre.setMatricule(param.getFiltre().getIdIndividu());
                		filtre.setReference(param.getFiltre().getReference());
                		listeDemande = services.getSearchAdvancedNoDate(filtre, param.getPagination());
                		for(int i=0;i<listeDemande.size();i++) {
                			ParamDemande dmd = new ParamDemande();
                    		AccueilMod acc = service.getByIdAcc(listeDemande.get(i).getReference());
                    		dmd.setAccueil(acc);
                    		dmd.setEtat(listeDemande.get(i).getEtat());
                    		liste.add(dmd);
                    	}
                	}else {
                		filtre.setReference(param.getFiltre().getDr());
                		filtre.setEtat(param.getFiltre().getEtat());
                		filtre.setDate_reception(param.getFiltre().getDate());
                		filtre.setMatricule(param.getFiltre().getIdIndividu());
                		filtre.setReference(param.getFiltre().getReference());
                		listeDemande = services.getSearchAdvanced(filtre, param.getPagination());
                		for(int i=0;i<listeDemande.size();i++) {
                			ParamDemande dmd = new ParamDemande();
                    		AccueilMod acc = service.getByIdAcc(listeDemande.get(i).getReference());
                    		dmd.setAccueil(acc);
                    		dmd.setEtat(listeDemande.get(i).getEtat());
                    		liste.add(dmd);
                    	}
                	}
            	}else {
            		ParamDemande dmd = new ParamDemande();
            		DemandeMod dmde = services.getByReference(param.getFiltre().getReference());
            		AccueilMod acc = service.getByIdAcc(dmde.getReference());
            		dmd.setAccueil(acc);
            		dmd.setEtat(dmde.getEtat());
            		liste.add(dmd);
            	}	
            }
            
            resultat = om.writeValueAsString(liste);
        	producer.send(record.key().toString(), "prendListeDmdRFAres", resultat);  
        } catch (Exception e) {
            	e.printStackTrace();
                producer.send(record.key().toString(), "prendListeDmdRFAres", e.getMessage());
        }
        
	}*/
	
}
