package g.cnaps.kafka;

import org.springframework.stereotype.Component;

@Component
public class RefEtatTypConsumer {
	
	
	/*ObjectMapper om=new ObjectMapper();
	String resultat;
	String nom="RefEtatTyp";
	
	@Autowired
	Producer producer;
	
	@Autowired
	RefEtatTypService service;
	
	
	
	@KafkaListener(topics="listeRefEtatTypreq")
    public void liste(ConsumerRecord<?, ?> record){
		try {
//			List<RefEtatTypMod> liste=service.getAll(Integer.parseInt(record.value().toString()));
			List<RefEtatTypMod> liste=service.getAll(1);
			resultat=om.writeValueAsString(liste);
			producer.send(record.key().toString(),"liste"+nom+"res",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"liste"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="findbyidRefEtatTypreq")
    public void findbyid(ConsumerRecord<?, ?> record){
		try {
			RefEtatTypMod acces=service.getById(record.value().toString());
			resultat=om.writeValueAsString(acces);
			producer.send(record.key().toString(),"findbyid"+nom+"res",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"findbyid"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="pageRefEtatTypreq")
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
	
	@KafkaListener(topics="ajoutRefEtatTypreq")
    public void ajout(ConsumerRecord<?, ?> record){
		try {
			service.save(om.readValue(record.value().toString(), RefEtatTypMod.class));
			producer.send(record.key().toString(),"ajout"+nom+"res","success");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"ajout"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="majRefEtatTypreq")
    public void maj(ConsumerRecord<?, ?> record){
		try {
			service.save(om.readValue(record.value().toString(), RefEtatTypMod.class));
			producer.send(record.key().toString(),"maj"+nom+"res","success");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"maj"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="supprRefEtatTypreq")
    public void suppr(ConsumerRecord<?, ?> record){
		try {
			service.delete(om.readValue(record.value().toString(), RefEtatTypMod.class));
			producer.send(record.key().toString(),"suppr"+nom+"res","succes");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"suppr"+nom+"res",e.getMessage());
		}
    }*/
}
