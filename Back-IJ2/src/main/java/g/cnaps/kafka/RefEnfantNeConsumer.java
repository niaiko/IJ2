package g.cnaps.kafka;

import org.springframework.stereotype.Component;

@Component
public class RefEnfantNeConsumer {
	
	
	/*ObjectMapper om=new ObjectMapper();
	String resultat;
	String nom="RefEnfantNe";
	
	@Autowired
	Producer producer;
	
	@Autowired
	RefEnfantNeService service;
	
	
	
	
	@KafkaListener(topics="listeEnfantByIdDemandereq")
    public void listeEnfantByIdDemandereq(ConsumerRecord<?, ?> record){
		try {
			List<RefEnfantNeMod> liste=service.findByIdAccueil(record.value().toString());
			resultat=om.writeValueAsString(liste);
			producer.send(record.key().toString(),"listeEnfantByIdDemanderes",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"listeEnfantByIdDemanderes",e.getMessage());
		}
    }
	
	
	@KafkaListener(topics="listeRefEnfantNereq")
    public void liste(ConsumerRecord<?, ?> record){
		try {
			List<RefEnfantNeMod> liste=service.getAll(Integer.parseInt(record.value().toString()));
			resultat=om.writeValueAsString(liste);
			producer.send(record.key().toString(),"liste"+nom+"res",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"liste"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="findbyidRefEnfantNereq")
    public void findbyid(ConsumerRecord<?, ?> record){
		try {
			RefEnfantNeMod acces=service.getById(record.value().toString());
			resultat=om.writeValueAsString(acces);
			producer.send(record.key().toString(),"findbyid"+nom+"res",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"findbyid"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="pageRefEnfantNereq")
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
	
	@KafkaListener(topics="ajoutRefEnfantNereq")
    public void ajout(ConsumerRecord<?, ?> record){
		try {
			service.save(om.readValue(record.value().toString(), RefEnfantNeMod.class));
			producer.send(record.key().toString(),"ajout"+nom+"res","success");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"ajout"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="supprParametrePfreq")
    public void suppr(ConsumerRecord<?, ?> record){
		try {
			service.delete(om.readValue(record.value().toString(), RefEnfantNeMod.class));
			producer.send(record.key().toString(),"suppr"+nom+"res","success");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"suppr"+nom+"res",e.getMessage());
		}
    }*/
}
