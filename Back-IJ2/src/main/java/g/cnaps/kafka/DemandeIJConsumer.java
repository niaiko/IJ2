package g.cnaps.kafka;

import org.springframework.stereotype.Component;


@Component
public class DemandeIJConsumer {
	/*ObjectMapper om=new ObjectMapper();
	String resultat;
	String nom="demandeIJ";
	String historique;
	static int VALIDATION_SEM = 8;
	static int VALIDATION_PRG_SEM = 9;
	@Autowired
	Producer producer;
	
	@Autowired
	DemandeIJService service;
	
	@Autowired
	TecHistoEtatService StateHistory;
	
	@Autowired
	AccueilService services;
	
	@Autowired
	RefAccInfoTypService refAccInfoServices;
	
	
	
	private static final Logger LOG = LoggerFactory.getLogger(DemandeIJServiceImpl.class);
	
	
	@KafkaListener(topics="mettreAjourDmdEmplPFreq")
	public void updateEmpl(ConsumerRecord<?, ?> record) {
		try {
			AccueilMod acc = om.readValue(record.value().toString(),AccueilMod.class);
			services.updateEmpl(acc.getId_empl(), acc.getId_succursale(), acc.getId_acc());
			resultat = om.writeValueAsString(acc);
			producer.send(record.key().toString(),"mettreAjourDmdEmplPFres",resultat);
		}catch(Exception e) {
			e.printStackTrace();
			producer.send(record.key().toString(), "mettreAjourDmdEmplPFres", e.getMessage());
		}
	}
	
	@KafkaListener(topics="demandeIJreq")
	public void enregistrerDemandeIJ(ConsumerRecord<?, ?> record) {
		try {
			DemandeIJMod data = om.readValue(record.value().toString(),DemandeIJMod.class);
			String prestation = data.getAccueilMod().getId_tec_dmd();
			int etat =1;
			
			
			
			if(prestation.compareToIgnoreCase("430")==0) {
				etat = VALIDATION_SEM;
			}
			if(service.prolongationIJ2(data)) {
				etat = VALIDATION_SEM;
			}
			
			service.enregistrerDemande(data,etat);
			 /*historique demande 
			
			HistoriqueDemandeMod historiqueDemande = new HistoriqueDemandeMod();
			historiqueDemande.setDate_dmd(DateUtil.sqlDateNow());
			historiqueDemande.setId_demande(data.getAccueilMod().getId_acc());
			historiqueDemande.setMatricule_demandeur(data.getAccueilMod().getId_individu());
			historiqueDemande.setType_dmd(data.getAccueilMod().getId_tec_dmd());
			
			historique = om.writeValueAsString(historiqueDemande);
			producer.send(record.key().toString(),"savehistodmdReq",historique);
			
			String topicTraitement = "traitement"+data.getAccueilMod().getId_tec_dmd()+"req";
			if(prestation.compareToIgnoreCase("421")==0) {
//				CIEParam paramCIE = new CIEParam();
//				paramCIE.setEmployeur(data.getAccueilMod().getId_empl());
//				paramCIE.setItem("201802");
//				producer.send(record.key().toString(),"findSoldeByPeriodeIJReq",om.writeValueAsString(paramCIE));
				producer.send(record.key().toString(),"calculedroitIJreq",data.getAccueilMod().getId_acc());
			}
			if(prestation.compareToIgnoreCase("430")==0) {
				ParamRfaMod param = new ParamRfaMod();
				param.setId_acc(data.getAccueilMod().getId_acc());
				param.setSme(0);
				param.setValidationPF(false);
				resultat = om.writeValueAsString(data.getAccueilMod());
				//producer.send(record.key().toString(), "traitement430res", resultat);
				producer.send(record.key().toString(),topicTraitement,om.writeValueAsString(param));
			}
			else {
				producer.send(record.key().toString(),topicTraitement,data.getAccueilMod().getId_acc());
			}
		}catch(Exception e) {
			e.printStackTrace();
			producer.send(record.key().toString(), "demandeIJres", e.getMessage());
		}
	}
	
	public boolean peutFaireDemande(String id_individu,String id_tec_demande) {
		try {
			List<AccueilMod> verifDmd = services.getbyidIndiv(id_individu);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@KafkaListener(topics="detailDemandereq")
	public void detailDemandereq(ConsumerRecord<?, ?> record) {
		try {
			
			LOG.info(om.writeValueAsString(record.value().toString()));
			DemandeIJMod data = service.detailDemande(record.value().toString());
			producer.send(record.key().toString(),"detailDemanderes",om.writeValueAsString(data));
		}catch(Exception e) {
			e.printStackTrace();
			producer.send(record.key().toString(), "detailDemanderes", e.getMessage());
		}
	}
	
	/*@KafkaListener(topics="detailRfareq")
	public void detailRfareq(ConsumerRecord<?, ?> record) {
		try {
			ParamRfaMod param = om.readValue(record.value().toString(), ParamRfaMod.class);
			DemandeIJMod data = service.detailRfa(param);
			producer.send(record.key().toString(),"detailRfares",om.writeValueAsString(data));
		}catch(Exception e) {
			producer.send(record.key().toString(), "detailRfares", e.getMessage());
		}
	}
	

	@KafkaListener(topics="findSoldeByPeriodeIJRes")
	public void findSoldeByPeriodeRe(ConsumerRecord<?, ?> record) {
		try {
			CIEParam paramCIE = om.readValue(record.value().toString(), CIEParam.class);
			ParamEtatDoss param = new ParamEtatDoss();
			param.setEtat(1);
			param.setIdacc(paramCIE.getId_acc());
			if(paramCIE.getSolde()!=0) {
				
				param.setEtat(2);
			}
			producer.send(record.key().toString(),"changerEtatDemandereq",om.writeValueAsString(param));
		}catch(Exception e) {
			producer.send(record.key().toString(), "changerEtatDemanderes", e.getMessage());
		}
	}
	
	
	
	
	@KafkaListener(topics="referenceIJreq")
	public void referenceIJ(ConsumerRecord<?, ?> record) {
		try {
			ReferenceParam param = om.readValue(record.value().toString(),ReferenceParam.class);
			resultat=ReferenceUtil.getReferenceDemande(param.getPrestation(),services.seqDemande(),param.getDr());
			producer.send(record.key().toString(),"referenceIJres",om.writeValueAsString(resultat));
		}catch(Exception e) {
			producer.send(record.key().toString(), "referenceIJres", e.getMessage());
		}
	}
	
	
	@KafkaListener(topics="calculedroitIJreq")
	public void calculedroitIJres(ConsumerRecord<?, ?> record) {
		try {
			if(Double.parseDouble(record.value().toString())>=0){
				producer.send(record.key().toString(),"findSoldeByPeriodeReq",om.writeValueAsString(resultat));
			}
		}catch(Exception e) {
			producer.send(record.key().toString(), "calculedroitIJres", e.getMessage());
		}
	}
	
	
	
	@KafkaListener(topics="findSoldeByPeriodeRes")
	public void findSoldeByPeriodeRes(ConsumerRecord<?, ?> record) {
		try {
			TecEtatDossMod tecEtatDoss = new TecEtatDossMod();
			producer.send(record.key().toString(),"ajoutTecEtatDossreq",om.writeValueAsString(tecEtatDoss));
		}catch(Exception e) {
			producer.send(record.key().toString(), "calculedroitIJres", e.getMessage());
		}
	}*/
	
	
}
