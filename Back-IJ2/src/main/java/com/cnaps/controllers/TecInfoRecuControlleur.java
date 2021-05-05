package com.cnaps.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cnaps.models.TecInfoRecuMod;
import com.cnaps.services.TecInfoRecuService;
import com.fasterxml.jackson.databind.ObjectMapper;

import g.cnaps.kafka.TecInfoRecuConsumer;

@RestController
public class TecInfoRecuControlleur {
	ObjectMapper om = new ObjectMapper();
	String resultat;
	String nom = "TecInfoRecu";

	private static final Logger log = LoggerFactory.getLogger(TecInfoRecuConsumer.class);

	@Autowired
	TecInfoRecuService service;

	/*
	 * @PostMapping("/majTecInfoRecuListPF") public ResponseEntity<Object>
	 * majTecInfoRecuListPF(@RequestBody String param) { try { log.info(param);
	 * List<TecInfoRecuMod> listInfoRecu = om.readValue(param, new
	 * TypeReference<List<TecInfoRecuMod>>() {}); service.save(listInfoRecu); String
	 * prestation = listInfoRecu.get(0).getId_acc().substring(0, 3); String
	 * topicTraitement = "traitement"+prestation+"req";
	 * 
	 * if(prestation.compareToIgnoreCase("421")==0) {
	 * if(Double.parseDouble(listInfoRecu.get(0).getId_acc()) > 0) {
	 * 
	 * }
	 * //producer.send(record.key().toString(),"calculedroitIJreq",listInfoRecu.get(
	 * 0).getId_acc()); } if(prestation.compareToIgnoreCase("430")==0) {
	 * Map<String,String> map = new HashMap<String,String>(); map.put("message",
	 * "success"); return new ResponseEntity<>(map, HttpStatus.OK); } else {
	 * //producer.send(record.key().toString(),topicTraitement,listInfoRecu.get(0).
	 * getId_acc()); } return new ResponseEntity<>("", HttpStatus.OK); }catch
	 * (Exception e) { e.printStackTrace(); return new
	 * ResponseEntity<>(HttpStatus.BAD_REQUEST); } }
	 */

	@PostMapping("/saveGrossesseSansSuit")
	public ResponseEntity<Object> saveGrossesse(@RequestBody TecInfoRecuMod tec) {
		try {
			service.save(tec);
			return new ResponseEntity<>(tec, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
