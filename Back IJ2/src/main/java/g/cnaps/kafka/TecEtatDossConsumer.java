package g.cnaps.kafka;

import org.springframework.stereotype.Component;

@Component
public class TecEtatDossConsumer {
	/*ObjectMapper om=new ObjectMapper();
	String resultat;
	String historique;
	String nom="TecEtatDoss";
	
	private static final Logger log = LoggerFactory.getLogger(TecEtatDossConsumer.class);
	
	@Autowired
	Producer producer;
	
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
	
	@KafkaListener(topics="changerEtatDemandereq")
    public void updateEtatDoss(ConsumerRecord<?, ?> record){
		try {
			log.info(record.value().toString());
			ParamEtatDoss  param = om.readValue(record.value().toString(),ParamEtatDoss.class);	
			TecEtatDossMod tecEtatDoss = service.findByIdAcc(param.getIdacc()).get(0);
			TecEtatDossMod newTecEtatDoss = new TecEtatDossMod();
			newTecEtatDoss.setDate_etat(DateUtil.sqlDateNow());
			newTecEtatDoss.setId_acc(param.getIdacc());
			newTecEtatDoss.setId_op(tecEtatDoss.getId_op());
			newTecEtatDoss.setId_type_etat(param.getEtat());
			newTecEtatDoss.setId_etat(tecEtatDoss.getId_etat());
			TecHistoEtatMod histo = new TecHistoEtatMod();
			histo.setId_type_etat(param.getEtat());
			histo.setDateetat(DateUtil.sqlDateNow());
			histo.setIdacc(param.getIdacc());
			histoetat_service.save(histo);
			service.save(newTecEtatDoss); 
			/*if(param.getEtat() == 3) {
				AccueilMod accueil = accService.getByIdAcc(param.getIdacc());
				List<RefEnfantNeMod> listeEnfant = refEnfantNeService.findByIdAccueil(accueil.getId_acc());
				if(listeEnfant.size() != 0) {
					PfBafEnfantMod enfant = new PfBafEnfantMod();
					enfant.setAccueil(accueil);
					enfant.setEnfant(listeEnfant); 
					producer.send(record.key().toString(),"verificationDmdAFreq",om.writeValueAsString(enfant));		
				}
			}
			producer.send(record.key().toString(),"changerEtatDemanderes",om.writeValueAsString("success"));
		}
		catch(Exception e) {
			e.printStackTrace();
			producer.send(record.key().toString(),"changerEtatDemanderes",e.getMessage());
		}
    }
	

	@KafkaListener(topics="insertIdOPreq")
    public void insertIdOP(ConsumerRecord<?, ?> record){
		try {
			OPparamMod  param = om.readValue(record.value().toString(),OPparamMod.class);	
			TecEtatDossMod tecEtatDoss = service.findByIdAcc(param.getId_acc()).get(0);
			
			TecEtatDossMod newTecEtatDoss = new TecEtatDossMod();
			newTecEtatDoss.setDate_etat(DateUtil.sqlDateNow());
			newTecEtatDoss.setId_acc(param.getId_acc());
			newTecEtatDoss.setId_op(param.getId_op());
			newTecEtatDoss.setId_type_etat(tecEtatDoss.getId_type_etat());
			newTecEtatDoss.setId_etat(tecEtatDoss.getId_etat());
			
			histoetat_service.save(new TecHistoEtatMod(param.getId_acc(),tecEtatDoss.getId_etat() , DateUtil.sqlDateNow()));
			
			service.save(newTecEtatDoss); 
			producer.send(record.key().toString(),"insertIdOPres",om.writeValueAsString("success"));
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"insertIdOPres",e.getMessage());
		}
    }
	
	
	@KafkaListener(topics="etatDossierreq")
    public void etatDossier(ConsumerRecord<?, ?> record){
		try {
			log.info(record.value().toString());
			List<TecEtatDossMod> etatDoss=service.findByIdAcc(record.value().toString());
			TecEtatDossMod etat = new TecEtatDossMod();
			if(etatDoss.size() == 0) {
				etat = new TecEtatDossMod();
			}else {
				etat = etatDoss.get(0);
			}
			resultat=om.writeValueAsString(etat);
			producer.send(record.key().toString(),"etatDossierres",resultat);
		}
		catch(Exception e) {
			e.printStackTrace();
			producer.send(record.key().toString(),"etatDossierres",e.getMessage());
		}
    }
	
	@KafkaListener(topics="listeTecEtatDossreq")
    public void liste(ConsumerRecord<?, ?> record){
		try {
			List<TecEtatDossMod> liste=service.getAll(Integer.parseInt(record.value().toString()));
			resultat=om.writeValueAsString(liste);
			producer.send(record.key().toString(),"liste"+nom+"res",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"liste"+nom+"res",e.getMessage());
		}
    }
	
	
	
	
	@KafkaListener(topics="findbyidTecEtatDossreq")
    public void findbyid(ConsumerRecord<?, ?> record){
		try {
			TecEtatDossMod acces=service.getById(record.value().toString());
			resultat=om.writeValueAsString(acces);
			producer.send(record.key().toString(),"findbyid"+nom+"res",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"findbyid"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="pageTecEtatDossreq")
    public void nombredepage(ConsumerRecord<?, ?> record){
		try {
			int page=service.nombrepage();
			resultat=om.writeValueAsString(page);
			producer.send(record.key().toString(),"page"+nom+"res",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"page"+nom+"res",e.getMessage());
		}	
    }
	
	@KafkaListener(topics="ajoutTecEtatDossreq")
    public void ajout(ConsumerRecord<?, ?> record){
		try {
			service.save(om.readValue(record.value().toString(), TecEtatDossMod.class));
			producer.send(record.key().toString(),"ajout"+nom+"res","success");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"ajout"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="majTecEtatDossreq")
    public void maj(ConsumerRecord<?, ?> record){
		try {
			service.save(om.readValue(record.value().toString(), TecEtatDossMod.class));
			producer.send(record.key().toString(),"maj"+nom+"res","success");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"maj"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="supprTecEtatDossreq")
    public void suppr(ConsumerRecord<?, ?> record){
		try {
			service.delete(om.readValue(record.value().toString(), TecEtatDossMod.class));
			producer.send(record.key().toString(),"suppr"+nom+"res","succes");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"suppr"+nom+"res",e.getMessage());
		}
    }
	
	
	@KafkaListener(topics="insertionOpDmdGroupe430req")
    public void insertOp(ConsumerRecord<?, ?> record){
		try {
			log.info(record.value().toString());
			OpMod param = om.readValue(record.value().toString(), OpMod.class);
			service.updateOp(param.getListeIdAcc(), param.getNumOP());
			resultat = "{\"message\":\"succes\"}";
			producer.send(record.key().toString(),"insertionOpDmdGroupe430res",resultat);
		}
		catch(Exception e) {
			e.printStackTrace();
			producer.send(record.key().toString(),"insertionOpDmdGroupe430res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="prendOpParReferencereq")
    public void getOpParIdAcc(ConsumerRecord<?, ?> record){
		try {
			log.info(record.value().toString());
			List<TecEtatDossMod> op = service.findByIdAcc(record.value().toString());
			if(op.get(0).getId_op() == null) {
				op = new ArrayList<>();
				resultat = om.writeValueAsString(op);
			}else {
				resultat = om.writeValueAsString(op); 
			}
			producer.send(record.key().toString(),"prendOpParReferenceres","succes");
		}
		catch(Exception e) {
			e.printStackTrace();
			producer.send(record.key().toString(),"prendOpParReferenceres",e.getMessage());
		}
    }
	
	/*@KafkaListener(topics="prendOpGroupereq")
    public void getOpGroup(ConsumerRecord<?, ?> record){
		try {
			List<TecEtatDossMod> liste = service.getAllWithOp();
			List<OpMod> newList = new ArrayList<>();
			boolean vrai = false;
			if(liste.size() == 0) {
				newList = new ArrayList<>();
			}else {
				for(int i=0;i<liste.size();i++) {
					vrai=false;
					for(int j=0;j<newList.size();i++) {
						if(liste.get(i).getId_op().compareTo(newList.get(j).getNumOP()) == 0) {
							vrai = true;
							break;
						}
					}if(!vrai) {
							
					}
				}
			}
			producer.send(record.key().toString(),"prendOpGrouperes","succes");
		}
		catch(Exception e) {
			e.printStackTrace();
			producer.send(record.key().toString(),"prendOpGrouperes",e.getMessage());
		}
    }
	
	@KafkaListener(topics="modifierMontantRFAreq")
    public void updateRefTecRecuRFA(ConsumerRecord<?, ?> record){
		try {
			log.info(record.value().toString());
			Map<String, Object> map = om.readValue(record.value().toString(), new TypeReference<Map<String, Object>>(){});
			List<TecEtatDossMod> etat = service.findByIdAcc(map.get("idAcc").toString());
			if(etat.get(0).getId_etat() == 3) {
				producer.send(record.key().toString(), "modifierMontantRFAres", "{\"estEffectue\":false, \"message\":\"Ce montant n'est plus modifiable\"}");
			}else {
				TecInfoRecuMod recu = new TecInfoRecuMod();
				recu.setId_acc(map.get("idAcc").toString());
				recu.setId_recu(map.get("idRecu").toString());
				recu.setValeur(map.get("valeur").toString());
				recu.setId_type_info(Integer.parseInt(map.get("idTypeInfo").toString()));
				tecInfoRecuService.save(recu);
				producer.send(record.key().toString(),"modifierMontantRFAres","{\"estEffectue\":true}");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			producer.send(record.key().toString(),"modifierMontantRFAres",e.getMessage());
		}
    }
	
	@KafkaListener(topics="modifierEtatDmdPFreq")
    public void updateEtatRFA(ConsumerRecord<?, ?> record){
		try {
			log.info(record.value().toString());
			EtatParam  param = om.readValue(record.value().toString(),EtatParam.class);	
			TecEtatDossMod tecEtatDoss = service.findByIdAcc(param.getIdAcc()).get(0);
			TecEtatDossMod newTecEtatDoss = new TecEtatDossMod();
			newTecEtatDoss.setDate_etat(DateUtil.sqlDateNow());
			newTecEtatDoss.setId_acc(param.getIdAcc());
			newTecEtatDoss.setId_op(tecEtatDoss.getId_op());
			newTecEtatDoss.setId_type_etat(param.getIdTypeEtat());
			newTecEtatDoss.setId_etat(tecEtatDoss.getId_etat());
			TecHistoEtatMod histo = new TecHistoEtatMod();
			histo.setId_type_etat(param.getIdTypeEtat());
			histo.setDateetat(DateUtil.sqlDateNow());
			histo.setIdacc(param.getIdAcc());
			histo.setObservations(param.getObservations());
			histo.setObservationsSem(param.getObservationsSem());
			histo.setUserModif(param.getUserModif());
			histoetat_service.save(histo);
			service.save(newTecEtatDoss);
			resultat = om.writeValueAsString(histo);
			producer.send(record.key().toString(),"modifierEtatDmdPFres",resultat);
		}
		catch(Exception e) {
			e.printStackTrace();
			producer.send(record.key().toString(),"modifierEtatDmdPFres",e.getMessage());
		}
    }*/
}
