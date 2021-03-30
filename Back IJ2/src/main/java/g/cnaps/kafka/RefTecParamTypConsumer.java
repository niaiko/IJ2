package g.cnaps.kafka;

import org.springframework.stereotype.Component;

@Component
public class RefTecParamTypConsumer {
	
	
	/*ObjectMapper om=new ObjectMapper();
	String resultat;
	String nom="RefTecParamTyp";
	
	@Autowired
	Producer producer;
	
	@Autowired
	RefTecParamTypService service;
	
	
	
	@KafkaListener(topics="listeRefTecParamTypreq")
    public void liste(ConsumerRecord<?, ?> record){
		try {
			List<RefTecParamTypMod> liste=service.getAll(Integer.parseInt(record.value().toString()));
			resultat=om.writeValueAsString(liste);
			producer.send(record.key().toString(),"liste"+nom+"res",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"liste"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="findbyidRefTecParamTypreq")
    public void findbyid(ConsumerRecord<?, ?> record){
		try {
			RefTecParamTypMod acces=service.getById(record.value().toString());
			resultat=om.writeValueAsString(acces);
			producer.send(record.key().toString(),"findbyid"+nom+"res",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"findbyid"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="pageRefTecParamTypreq")
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
	
	@KafkaListener(topics="ajoutRefTecParamTypreq")
    public void ajout(ConsumerRecord<?, ?> record){
		try {
			service.save(om.readValue(record.value().toString(), RefTecParamTypMod.class));
			producer.send(record.key().toString(),"ajout"+nom+"res","success");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"ajout"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="majRefTecParamTypreq")
    public void maj(ConsumerRecord<?, ?> record){
		try {
			service.save(om.readValue(record.value().toString(), RefTecParamTypMod.class));
			producer.send(record.key().toString(),"maj"+nom+"res","success");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"maj"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="supprRefTecParamTypreq")
    public void suppr(ConsumerRecord<?, ?> record){
		try {
			service.delete(om.readValue(record.value().toString(), RefTecParamTypMod.class));
			producer.send(record.key().toString(),"suppr"+nom+"res","succes");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"suppr"+nom+"res",e.getMessage());
		}
    }*/
}
