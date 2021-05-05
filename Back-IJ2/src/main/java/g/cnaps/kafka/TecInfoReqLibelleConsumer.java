package g.cnaps.kafka;

import org.springframework.stereotype.Component;

@Component
public class TecInfoReqLibelleConsumer {
	/*ObjectMapper om=new ObjectMapper();
	String resultat;
	String nom="TecInfoReqLibelle";
	
	private static final Logger log = LoggerFactory.getLogger(TecInfoReqLibelleConsumer.class);
	
	
	@Autowired
	Producer producer;
	
	@Autowired
	TecInfoReqLibelleService service;
	
	
	
	@KafkaListener(topics="listeTecInfoReqLibellereq")
    public void liste(ConsumerRecord<?, ?> record){
		try {
			log.info(record.value().toString());
			List<TecInfoReqLibelleMod> liste=service.findInfoReqByIdDemande(record.value().toString());
			resultat=om.writeValueAsString(liste);
			producer.send(record.key().toString(),"liste"+nom+"res",resultat);
		}
		catch(Exception e) {
			producer.send(record.key().toString(),"liste"+nom+"res",e.getMessage());
		}
    }*/
	
	
}
