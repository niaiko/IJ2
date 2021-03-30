package g.cnaps.kafka;

import org.springframework.stereotype.Component;

@Component
public class TecPcsReqLibelleConsumer {
	/*ObjectMapper om = new ObjectMapper();
	String resultat;
	String nom = "TecPcsReqLibelle";
	
	private static final Logger LOG = LoggerFactory.getLogger(DemandeConsumer.class);
	
	@Autowired
	Producer producer;

	@Autowired
	TecPcsReqLibelleService service;

	@KafkaListener(topics = "listeTecPcsReqLibellereq")
	public void liste(ConsumerRecord<?, ?> record) {
		try {
			List<TecPcsReqLibelleMod> liste = service.findPieceReqByIdDemande(record.value().toString());
			resultat = om.writeValueAsString(liste);
			producer.send(record.key().toString(), "liste" + nom + "res", resultat);
		} catch (Exception e) {
			producer.send(record.key().toString(), "liste" + nom + "res", e.getMessage());
		}
	}

	@KafkaListener(topics="listeTecPcsReqIJ2req")
    public void listeTecPcsReqIJ2(ConsumerRecord<?, ?> record){
		try {
			ParamIJPcsReqMod param = om.readValue(record.value().toString(), ParamIJPcsReqMod.class);
		
			List<TecPcsReqLibelleMod> liste=service.findPieceReqByIdDemande(param.getIdtecdmd());
			LOG.info(om.writeValueAsString(liste));
			List<TecPcsReqLibelleMod> a_retourner = new ArrayList<>();
			if(param.getProlongation()!=0)
			{
			for(int i=0;i<liste.size();i++)
			{
				 if(liste.get(i).getId_piece().compareTo("225")!=0)
					{
					 a_retourner.add(liste.get(i));
					}
			 }
			resultat=om.writeValueAsString(a_retourner);
			}
			else
			{
				resultat=om.writeValueAsString(liste);
			}
			
			producer.send(record.key().toString(),"listeTecPcsReqIJ2res",resultat);
		   }
		catch(

	Exception e)
	{
			e.printStackTrace();
		producer.send(record.key().toString(), "liste" + nom + "res", e.getMessage());
	}
	}

	@KafkaListener(topics = "listeTecPcsRefLibellePenreq")
	public void listePiecePension(ConsumerRecord<?, ?> record) {
		try {
			List<TecPcsReqLibelleMod> liste = service.findPiecePension();
			resultat = om.writeValueAsString(liste);
			producer.send(record.key().toString(), "listeTecPcsRefLibellePenres", resultat);
		} catch (Exception e) {
			producer.send(record.key().toString(), "listeTecPcsRefLibellePenres", e.getMessage());
		}
	}*/

}
