package g.cnaps.kafka;

import org.springframework.stereotype.Component;

@Component
public class RefParamPfConsumer {
	
	
	/*ObjectMapper om=new ObjectMapper();
	String resultat;
	String nom="RefParamPf";
	
	@Autowired
	Producer producer;
	
	@Autowired
	RefParamPfService service;
	
	
	
	@KafkaListener(topics="listeRefParamPfreq")
    public void liste(ConsumerRecord<?, ?> record){
		try {
			List<RefParamPfMod> liste=service.getAll(Integer.parseInt(record.value().toString()));
			resultat=om.writeValueAsString(liste);
			producer.send(record.key().toString(),"liste"+nom+"res",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"liste"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="findbyidRefParamPfreq")
    public void findbyid(ConsumerRecord<?, ?> record){
		try {
			RefParamPfMod acces=service.getById(record.value().toString());
			resultat=om.writeValueAsString(acces);
			producer.send(record.key().toString(),"findbyid"+nom+"res",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"findbyid"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="pageRefParamPfreq")
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
	
	@KafkaListener(topics="ajoutRefParamPfreq")
    public void ajout(ConsumerRecord<?, ?> record){
		try {
			service.save(om.readValue(record.value().toString(), RefParamPfMod.class));
			producer.send(record.key().toString(),"ajout"+nom+"res","success");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"ajout"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="supprRefParamPfreq")
    public void suppr(ConsumerRecord<?, ?> record){
		try {
			service.delete(om.readValue(record.value().toString(), RefParamPfMod.class));
			producer.send(record.key().toString(),"suppr"+nom+"res","success");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"suppr"+nom+"res",e.getMessage());
		}
    }*/
}
