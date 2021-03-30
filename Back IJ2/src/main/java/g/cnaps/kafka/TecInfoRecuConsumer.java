package g.cnaps.kafka;

import org.springframework.stereotype.Component;

@Component
public class TecInfoRecuConsumer {
	/*ObjectMapper om=new ObjectMapper();
	String resultat;
	String nom="TecInfoRecu";
	
	private static final Logger log = LoggerFactory.getLogger(TecInfoRecuConsumer.class);
	
	@Autowired
	Producer producer;
	
	@Autowired
	TecInfoRecuService service;
	
	
	
	@KafkaListener(topics="listeTecInfoRecureq")
    public void liste(ConsumerRecord<?, ?> record){
		try {
			List<TecInfoRecuMod> liste=service.getAll(Integer.parseInt(record.value().toString()));
			resultat=om.writeValueAsString(liste);
			producer.send(record.key().toString(),"liste"+nom+"res",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"liste"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="findbyidTecInfoRecureq")
    public void findbyid(ConsumerRecord<?, ?> record){
		try {
			TecInfoRecuMod acces=service.getById(record.value().toString());
			resultat=om.writeValueAsString(acces);
			producer.send(record.key().toString(),"findbyid"+nom+"res",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"findbyid"+nom+"res",e.getMessage());
		}
    }
	
	
	@KafkaListener(topics="listeTecInfoRecuParDemandereq")
    public void findByIdAccueil(ConsumerRecord<?, ?> record){
		try {
			log.info(om.writeValueAsString(record.value().toString()));
			List<TecInfoRecuMod> liste=service.findByIdAccueil(record.value().toString());
			resultat=om.writeValueAsString(liste);
			producer.send(record.key().toString(),"listeTecInfoRecuParDemanderes",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"listeTecInfoRecuParDemanderes",e.getMessage());
		}
    }
	
	
	@KafkaListener(topics="pageTecInfoRecureq")
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
	
	@KafkaListener(topics="ajoutTecInfoRecureq")
    public void ajout(ConsumerRecord<?, ?> record){
		try {
			service.save(om.readValue(record.value().toString(), TecInfoRecuMod.class));
			producer.send(record.key().toString(),"ajout"+nom+"res","success");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"ajout"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="majTecInfoRecureq")
    public void maj(ConsumerRecord<?, ?> record){
		try {
			service.save(om.readValue(record.value().toString(), TecInfoRecuMod.class));
			producer.send(record.key().toString(),"maj"+nom+"res","success");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"maj"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="majTecInfoRecuListreq")
    public void majList(ConsumerRecord<?, ?> record){
		try {
			List<TecInfoRecuMod> listInfoRecu = om.readValue(record.value().toString(), new TypeReference<List<TecInfoRecuMod>>() {});
			service.save(listInfoRecu);
			log.info("Id demande @ maj '{}' : ",listInfoRecu.get(0).getId_acc());
			String prestation  = listInfoRecu.get(0).getId_acc().substring(0, 3);
			String topicTraitement = "traitement"+prestation+"req";
			
			if(prestation.compareToIgnoreCase("421")==0) {
				producer.send(record.key().toString(),"calculedroitIJreq",listInfoRecu.get(0).getId_acc());
			}
			if(prestation.compareToIgnoreCase("430")==0) {
				producer.send(record.key().toString(),"majTecInfoRecuListres","{\"message\":\"success\"}");
			}
			else {
				producer.send(record.key().toString(),topicTraitement,listInfoRecu.get(0).getId_acc());
			}
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"calculedroitIJres",e.getMessage());
		}
    }
	
	@KafkaListener(topics="supprTecInfoRecureq")
    public void suppr(ConsumerRecord<?, ?> record){
		try {
			service.delete(om.readValue(record.value().toString(), TecInfoRecuMod.class));
			producer.send(record.key().toString(),"suppr"+nom+"res","succes");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"suppr"+nom+"res",e.getMessage());
		}
    }*/
}
