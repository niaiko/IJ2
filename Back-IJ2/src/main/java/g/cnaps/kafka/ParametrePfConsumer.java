	package g.cnaps.kafka;

import org.springframework.stereotype.Component;

@Component
public class ParametrePfConsumer {
	
	
	/*ObjectMapper om=new ObjectMapper();
	String resultat;
	String nom="ParametrePf";
	
	@Autowired
	Producer producer;
	
	@Autowired
	ParametrePfService service;
	
	
	
	
	
	@KafkaListener(topics="listeParametrePfreq")
    public void liste(ConsumerRecord<?, ?> record){
		try {
			List<ParametrePfMod> liste=service.getAll(Integer.parseInt(record.value().toString()));
			resultat=om.writeValueAsString(liste);
			producer.send(record.key().toString(),"liste"+nom+"res",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"liste"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="findbyidParametrePfreq")
    public void findbyid(ConsumerRecord<?, ?> record){
		try {
			ParametrePfMod acces=service.getById(record.value().toString());
			resultat=om.writeValueAsString(acces);
			producer.send(record.key().toString(),"findbyid"+nom+"res",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"findbyid"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="pageParametrePfreq")
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
	
	@KafkaListener(topics="ajoutParametrePfreq")
    public void ajout(ConsumerRecord<?, ?> record){
		try {
			service.save(om.readValue(record.value().toString(), ParametrePfMod.class));
			producer.send(record.key().toString(),"ajout"+nom+"res","success");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"ajout"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="supprParametrePfreq")
    public void suppr(ConsumerRecord<?, ?> record){
		try {
			service.delete(om.readValue(record.value().toString(), ParametrePfMod.class));
			producer.send(record.key().toString(),"suppr"+nom+"res","success");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"suppr"+nom+"res",e.getMessage());
		}
    }
	@KafkaListener(topics="dateTroisQuatreMoisReq")
    public void dateTroisQuatreMois(ConsumerRecord<?, ?> record){
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			java.sql.Date dpa = new java.sql.Date(dateFormat.parse(record.value().toString()).getTime());
			Map<String, Date> map = new HashMap<String, Date>();
			java.sql.Date[] date = DateUtil.getTroisQuatreMois(dpa);
	
			map.put("date3mois", date[0]);
			map.put("date4mois", date[1]);
			producer.send(record.key().toString(),"dateTroisQuatreMoisRes",om.writeValueAsString(map));
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"dateTroisQuatreMoisRes",e.getMessage());
		}
    }
	
	@KafkaListener(topics="nextFinMoisReq")
    public void dateNextFinMois(ConsumerRecord<?, ?> record){
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			java.sql.Date dpa = new java.sql.Date(dateFormat.parse(record.value().toString()).getTime());
			Map<String, Date> map = new HashMap<String, Date>();
			java.sql.Date date = DateUtil.getFinNextMois(dpa);
			map.put("nextFinMois", date);
			producer.send(record.key().toString(),"nextFinMoisRes",om.writeValueAsString(map));
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"nextFinMoisRes",e.getMessage());
		}
    }*/
}
