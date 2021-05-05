package g.cnaps.kafka;

import org.springframework.stereotype.Component;

@Component
public class RefTecDmdConsumer {
	
	/*public static final Logger log = LoggerFactory.getLogger(RefTecDmdConsumer.class);
	ObjectMapper om=new ObjectMapper();
	String resultat;
	String nom="RefTecDmd";
	
	@Autowired
	Producer producer;
	
	@Autowired
	RefTecDmdService service;
	
	
	
	@KafkaListener(topics="listeRefTecDmdreq")
    public void liste(ConsumerRecord<?, ?> record){
		try {
			List<RefTecDmdMod> liste=service.getAll(Integer.parseInt(record.value().toString()));
			resultat=om.writeValueAsString(liste);
			producer.send(record.key().toString(),"liste"+nom+"res",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"liste"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="findbyidRefTecDmdreq")
    public void findbyid(ConsumerRecord<?, ?> record){
		try {
			RefTecDmdMod acces=service.getById(record.value().toString());
			resultat=om.writeValueAsString(acces);
			producer.send(record.key().toString(),"findbyid"+nom+"res",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"findbyid"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="pageRefTecDmdreq")
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
	
	@KafkaListener(topics="ajoutRefTecDmdreq")
    public void ajout(ConsumerRecord<?, ?> record){
		try {
			service.save(om.readValue(record.value().toString(), RefTecDmdMod.class));
			producer.send(record.key().toString(),"ajout"+nom+"res","success");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"ajout"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="majRefTecDmdreq")
    public void maj(ConsumerRecord<?, ?> record){
		try {
			service.save(om.readValue(record.value().toString(), RefTecDmdMod.class));
			producer.send(record.key().toString(),"maj"+nom+"res","success");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"maj"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="supprRefTecDmdreq")
    public void suppr(ConsumerRecord<?, ?> record){
		try {
			service.delete(om.readValue(record.value().toString(), RefTecDmdMod.class));
			producer.send(record.key().toString(),"suppr"+nom+"res","succes");
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"suppr"+nom+"res",e.getMessage());
		}
    }
	
	@KafkaListener(topics="prendPrestationPFreq")
    public void getPrestation(ConsumerRecord<?, ?> record){
		try {
			log.info(record.value().toString());
			String prest = new String();
			RefTecDmdMod prestation = service.getById_tec_dmd(record.value().toString());
			if(prestation != null) {
				prest = prestation.getLibelle();
			}
			resultat = om.writeValueAsString(prest);
			producer.send(record.key().toString(),"prendPrestationPFres",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"prendPrestationPFres",e.getMessage());
		}
    }*/
}
