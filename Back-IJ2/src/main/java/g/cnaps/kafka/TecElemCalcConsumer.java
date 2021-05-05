package g.cnaps.kafka;

import org.springframework.stereotype.Component;

@Component
public class TecElemCalcConsumer {
	
	
	/*ObjectMapper om=new ObjectMapper();
	String resultat;
	String nom="TecElemCalc";
	
	@Autowired
	Producer producer;
	
	@Autowired
	TecElemCalcService service;
	
	
	
	@KafkaListener(topics="droitByIdDemandereq")
    public void droitParIdDemandereq(ConsumerRecord<?, ?> record){
		try {
			TecElemCalcMod droit=service.findByIdAcc(record.value().toString()).get(0);
			resultat=om.writeValueAsString(droit.getValeur());
			producer.send(record.key().toString(),"droitByIdDemanderes",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"droitByIdDemanderes",e.getMessage());
		}
    }
	
	@KafkaListener(topics="listeTecElemCalcreq")
    public void liste(ConsumerRecord<?, ?> record){
		try {
			List<TecElemCalcMod> liste=service.getAll(Integer.parseInt(record.value().toString()));
			resultat=om.writeValueAsString(liste);
			producer.send(record.key().toString(),"liste"+nom+"res",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"liste"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="findbyidTecElemCalcreq")
    public void findbyid(ConsumerRecord<?, ?> record){
		try {
			TecElemCalcMod acces=service.getById(record.value().toString());
			resultat=om.writeValueAsString(acces);
			producer.send(record.key().toString(),"findbyid"+nom+"res",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"findbyid"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="pageTecElemCalcreq")
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
	
	@KafkaListener(topics="ajoutTecElemCalcreq")
    public void ajout(ConsumerRecord<?, ?> record){
		try {
			service.save(om.readValue(record.value().toString(), TecElemCalcMod.class));
			producer.send(record.key().toString(),"ajout"+nom+"res","success");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"ajout"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="majTecElemCalcreq")
    public void maj(ConsumerRecord<?, ?> record){
		try {
			service.save(om.readValue(record.value().toString(), TecElemCalcMod.class));
			producer.send(record.key().toString(),"maj"+nom+"res","success");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"maj"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="supprTecElemCalcreq")
    public void suppr(ConsumerRecord<?, ?> record){
		try {
			service.delete(om.readValue(record.value().toString(), TecElemCalcMod.class));
			producer.send(record.key().toString(),"suppr"+nom+"res","succes");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"suppr"+nom+"res",e.getMessage());
		}
    }*/
}
