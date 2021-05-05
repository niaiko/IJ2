package com.cnaps.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cnaps.models.RefTecDmdMod;
import com.cnaps.services.RefTecDmdService;
import com.cnaps.utils.RequestApi;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import g.cnaps.kafka.RefTecDmdConsumer;

@RestController
public class RefTecDmdControlleur {
	public static final Logger log = LoggerFactory.getLogger(RefTecDmdConsumer.class);
	ObjectMapper om=new ObjectMapper();
	String resultat;
	String nom="RefTecDmd";
	Map<String,Object> res = new HashMap<String,Object>();
	
	@Autowired
	RequestApi request;
	
	@Autowired
	RefTecDmdService service;
	
	
	@PostMapping("/prendPrestationPF")
	public ResponseEntity<Object> prendPrestationPF(@RequestBody String param) {
		try {
			log.info(param);
			String prest = new String();
			RefTecDmdMod prestation = service.getById_tec_dmd(param);
			if(prestation != null)
				prest = prestation.getLibelle();
			res.put("msg", prest);
			return new ResponseEntity<>(res, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PostMapping("/prendToutPrestationPF")
	public ResponseEntity<Object> prendToutPrestationPF(@RequestHeader(value = "Authorization") String token) {
		try {
			List<RefTecDmdMod> prestationPF = service.getAllPrestationPF("4");
			prestationPF.addAll(om.readValue(request.sendGet("http://cnapsDmdPEN:9874/prendSousPrestationPension",token), new TypeReference<List<RefTecDmdMod>>() {}));
			prestationPF.addAll(om.readValue(request.sendGet("http://cnapsDmdATMP:3000/prendSousPrestationAtmp", token), new TypeReference<List<RefTecDmdMod>>() {}));
			return new ResponseEntity<>(prestationPF, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
