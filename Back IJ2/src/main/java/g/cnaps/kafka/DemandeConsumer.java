package g.cnaps.kafka;

import org.springframework.stereotype.Component;

@Component
public class DemandeConsumer {

	/*ObjectMapper om = new ObjectMapper();
	String resultat;
	String nom = "Demande";

	private static final Logger log = LoggerFactory.getLogger(DemandeConsumer.class);
	
	@Autowired
	Producer producer;

	@Autowired
	DemandeService service;
	

	@KafkaListener(topics = "listeDemandesreq")
	public void liste(ConsumerRecord<?, ?> record) {
		try {
			log.info(record.value().toString());
			List<DemandeMod> liste = service.getAll(Integer.parseInt(record.value().toString()));
			resultat = om.writeValueAsString(liste);
			log.info("liste : " +resultat);
			producer.send(record.key().toString(), "liste" + nom + "sres", resultat);
		} catch (Exception e) {
			producer.send(record.key().toString(), "liste" + nom + "sres", e.getMessage());
		}
	}
 
	
	@KafkaListener(topics = "finddemandeValideReq")
	public void findDemandeValide(ConsumerRecord<?, ?> record) {
		try {
			DemandeMod dem = om.readValue(record.value().toString(), DemandeMod.class);
			DemandeMod demande = service.FindDemandeByMatriculeAndPrestation(dem);
			resultat = om.writeValueAsString(demande);
			producer.send(record.key().toString(), "finddemandeValideRes", resultat);
		} catch (Exception e) {
			producer.send(record.key().toString(), "finddemandeValideRes", e.getMessage());
		}
	}
 
 
	
	@KafkaListener(topics = "nombrePageParEtatReq")
	public void nombreDePageParEtat(ConsumerRecord<?, ?> record) {
		try {
			ParamDemande param = om.readValue(record.value().toString(), ParamDemande.class);
			
			
			int page=service.nombreDePageParEtat(param.getType_etat(),param.getPrestation());
			resultat=om.writeValueAsString(page);
			producer.send(record.key().toString(),"nombrePageParEtatRes",resultat);
		} catch (Exception e) {
			producer.send(record.key().toString(), "nombrePageParEtatRes", e.getMessage());
		}
	}
	

	/*@KafkaListener(topics = "listeDemandereq")
	public void listeAvecEtat(ConsumerRecord<?, ?> record) {
		try {
			log.info(record.value().toString());
			ParamDemande param = om.readValue(record.value().toString(), ParamDemande.class);
			Page<DemandeMod> liste = service.listeAvecParam(param.getType_etat(),param.getPrestation(),param.getPagination());
			resultat = om.writeValueAsString(new PageResponse<>(liste.getContent(), liste.getTotalPages()));
			log.info("liste : "+resultat);
			producer.send(record.key().toString(), "listeDemanderes", resultat);
		} catch (Exception e) {
			e.printStackTrace();
			producer.send(record.key().toString(), "listeDemanderes", e.getMessage());
		}
	}
	
	@KafkaListener(topics = "listeDemandereq")
	public void listeAvecEtat(ConsumerRecord<?, ?> record) {
		try {
			log.info(record.value().toString());
			DemandeFiltre param = om.readValue(record.value().toString(), DemandeFiltre.class);
			Page<DemandeMod> liste = service.getByIdIndividuAndIdAccAndDateReceptionAndIdTecDmd(param);
			resultat = om.writeValueAsString(new PageResponse<>(liste.getContent(), liste.getTotalPages()));
			producer.send(record.key().toString(), "listeDemanderes", resultat);
		} catch (Exception e) {
			e.printStackTrace();
			producer.send(record.key().toString(), "listeDemanderes", e.getMessage());
		}
	}
	
	
	
	@KafkaListener(topics = "listeDemandeRecherchereq")
	public void listeAvecRecherche(ConsumerRecord<?, ?> record) {
		try {
			DemandeMod dem = new DemandeMod();
			dem.setEtat(1);
			dem.setReference("999909");
			List<DemandeMod> liste = service.advancedSearchDemande(dem);
			log.info("Valeur etat='{}'", liste.get(0).getEtat_libelle());
			resultat = om.writeValueAsString(liste);
			producer.send(record.key().toString(), "ajoutinfodemande", resultat);
		} catch (Exception e) {
			producer.send(record.key().toString(), "listeDemanderes", e.getMessage());
		}
	}

	@KafkaListener(topics = "findbyidDemandereq")
	public void findbyid(ConsumerRecord<?, ?> record) {
		try {
			DemandeMod acces = service.getById(record.value().toString());
			resultat = om.writeValueAsString(acces);
			producer.send(record.key().toString(), "findbyid" + nom + "res", resultat);
		} catch (Exception e) {
			producer.send(record.key().toString(), "findbyid" + nom + "res", e.getMessage());
		}
	}

	@KafkaListener(topics = "pageDemandereq")
	public void nombredepage(ConsumerRecord<?, ?> record) {
		try {
			int page = service.nombrepage();
			resultat = om.writeValueAsString(page);
			producer.send(record.key().toString(), "page" + nom + "res", resultat);
		} catch (Exception e) {
			producer.send(record.key().toString(), "page" + nom + "res", e.getMessage());
		}
	}

	@KafkaListener(topics = "ajoutDemandereq")
	public void ajout(ConsumerRecord<?, ?> record) {
		try {
			service.save(om.readValue(record.value().toString(), DemandeMod.class));
			producer.send(record.key().toString(), "ajout" + nom + "res", "success");
		} catch (Exception e) {
			producer.send(record.key().toString(), "ajout" + nom + "res", e.getMessage());
		}
	}

	@KafkaListener(topics = "majDemandereq")
	public void maj(ConsumerRecord<?, ?> record) {
		try {
			service.save(om.readValue(record.value().toString(), DemandeMod.class));
			producer.send(record.key().toString(), "maj" + nom + "res", "success");
		} catch (Exception e) {
			producer.send(record.key().toString(), "maj" + nom + "res", e.getMessage());
		}
	}

	@KafkaListener(topics = "supprDemandereq")
	public void suppr(ConsumerRecord<?, ?> record) {
		try {
			service.delete(om.readValue(record.value().toString(), DemandeMod.class));
			producer.send(record.key().toString(), "suppr" + nom + "res", "succes");
		} catch (Exception e) {
			producer.send(record.key().toString(), "suppr" + nom + "res", e.getMessage());
		}
	}
	
	@KafkaListener(topics = "listeDemandeParIndivreq")
	public void getListDemandeParIndiv(ConsumerRecord<?, ?> record) {
		try {
			log.info(record.value().toString());
			List<DemandeMod> liste = service.getByMatricule(record.value().toString());
			resultat = om.writeValueAsString(liste);
			producer.send(record.key().toString(), "liste" + nom + "ParIndivres", "succes");
		} catch (Exception e) {
			producer.send(record.key().toString(), "liste" + nom + "ParIndivres", e.getMessage());
		}
	}*/
}
