package g.cnaps.kafka;

import org.springframework.stereotype.Component;

@Component
public class RefRfaOrdDetConsumer {
	/*private static final Logger log = LoggerFactory.getLogger(RefRfaOrdDetConsumer.class);
	
	ObjectMapper om=new ObjectMapper();
	String resultat;
	String nom="RefRfaOrdDet";
	
	@Autowired
	Producer producer;
	
	@Autowired
	RefRfaOrdDetService service;
	
	
	
	@KafkaListener(topics="listeRefRfaOrdDetreq")
    public void liste(ConsumerRecord<?, ?> record){
		try {
			List<RefRfaOrdDetMod> liste=service.getAll(Integer.parseInt(record.value().toString()));
			resultat=om.writeValueAsString(liste);
			producer.send(record.key().toString(),"liste"+nom+"res",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"liste"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="findbyidRefRfaOrdDetreq")
    public void findbyid(ConsumerRecord<?, ?> record){
		try {
			RefRfaOrdDetMod acces=service.getById(record.value().toString());
			resultat=om.writeValueAsString(acces);
			producer.send(record.key().toString(),"findbyid"+nom+"res",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"findbyid"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="pageRefRfaOrdDetreq")
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
	
	
	
	@KafkaListener(topics="ajoutRefRfaOrdDetreq")
    public void ajout(ConsumerRecord<?, ?> record){
		try {
			log.info(record.value().toString());
			service.save(om.readValue(record.value().toString(), RefRfaOrdDetMod.class));
			producer.send(record.key().toString(),"ajout"+nom+"res","success");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"ajout"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="supprRefRfaOrdDetreq")
    public void suppr(ConsumerRecord<?, ?> record){
		try {
			service.delete(om.readValue(record.value().toString(), RefRfaOrdDetMod.class));
			producer.send(record.key().toString(),"suppr"+nom+"res","success");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"suppr"+nom+"res",e.getMessage());
		}
    }*/
}
