package g.cnaps.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RefRfaOrdConsumer {
	private static final Logger log = LoggerFactory.getLogger(RefRfaOrdConsumer.class);
	
	/*ObjectMapper om=new ObjectMapper();
	String resultat;
	String nom="RefRfaOrd";
	
	@Autowired
	Producer producer;
	
	@Autowired
	RefRfaOrdService service;
	
	@Autowired
	RefRfaOrdDetService refRfaOrdDetService;
	
	

	
	@KafkaListener(topics="ordonnanceByIdDemandereq")
    public void listeOrdonnanceByDemandereq(ConsumerRecord<?, ?> record){
		try {
			RefRfaOrdMod refRfaOrdMod=service.findByIdAccueil(record.value().toString());
			List<RefRfaOrdDetMod> refRfaOrdDetMod = refRfaOrdDetService.findByIdOrdMere(refRfaOrdMod.getId_ref_rfa_ord());
			OrdonnanceMod ordonnance = new OrdonnanceMod();
			ordonnance.setOrdFille(refRfaOrdDetMod);
			ordonnance.setOrdMere(refRfaOrdMod);
			resultat=om.writeValueAsString(ordonnance);
			producer.send(record.key().toString(),"ordonnanceByIdDemanderes",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"ordonnanceByIdDemanderes",e.getMessage());
		}
    }
	
	
	
	@KafkaListener(topics="listeRefRfaOrdreq")
    public void liste(ConsumerRecord<?, ?> record){
		try {
			List<RefRfaOrdMod> liste=service.getAll(Integer.parseInt(record.value().toString()));
			resultat=om.writeValueAsString(liste);
			producer.send(record.key().toString(),"liste"+nom+"res",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"liste"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="findbyidRefRfaOrdreq")
    public void findbyid(ConsumerRecord<?, ?> record){
		try {
			RefRfaOrdMod acces=service.getById(record.value().toString());
			resultat=om.writeValueAsString(acces);
			producer.send(record.key().toString(),"findbyid"+nom+"res",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"findbyid"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="pageRefRfaOrdreq")
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
	
	@KafkaListener(topics="ajoutRefRfaOrdreq")
    public void ajout(ConsumerRecord<?, ?> record){
		try {
			log.info(record.value().toString());
			service.save(om.readValue(record.value().toString(), RefRfaOrdMod.class));
			producer.send(record.key().toString(),"ajout"+nom+"res","success");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"ajout"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="supprRefRfaOrdreq")
    public void suppr(ConsumerRecord<?, ?> record){
		try {
			service.delete(om.readValue(record.value().toString(), RefRfaOrdMod.class));
			producer.send(record.key().toString(),"suppr"+nom+"res","success");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"suppr"+nom+"res",e.getMessage());
		}
    }*/
}
