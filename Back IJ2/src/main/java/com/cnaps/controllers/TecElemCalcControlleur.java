package com.cnaps.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cnaps.models.TecElemCalcMod;
import com.cnaps.services.TecElemCalcService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class TecElemCalcControlleur {
	private static final Logger log = LoggerFactory.getLogger(TecElemCalcControlleur.class);
	ObjectMapper om=new ObjectMapper();
	String resultat;
	String nom="TecElemCalc";
		
	@Autowired
	TecElemCalcService service;
	
	@PostMapping("/droitByIdDemandePF")
	public ResponseEntity<Object> droitByIdDemandePF(@RequestBody String param) {
		try {
			log.info(param);
			List<TecElemCalcMod> droit = service.findByIdAcc(param);
			if(droit.size() != 0)
				return new ResponseEntity<>(droit.get(0), HttpStatus.OK);
			else
				return new ResponseEntity<>(new TecElemCalcMod(), HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
