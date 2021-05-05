package com.cnaps.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cnaps.models.TecPcsReqLibelleMod;
import com.cnaps.services.TecPcsReqLibelleService;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.cnaps.models.ParamIJPcsReqMod;


@RestController
public class TecPcsReqLibelleControlleur {
	
	ObjectMapper om = new ObjectMapper();
	String resultat;
	String nom = "TecPcsReqLibelle";
	
	private static final Logger log = LoggerFactory.getLogger(TecPcsReqLibelleControlleur.class);

	@Autowired
	TecPcsReqLibelleService service;
	
	
	@PostMapping("/listeTecPcsReqIJ2PF")
	public ResponseEntity<Object> listeTecPcsReqIJ2PF(@RequestBody ParamIJPcsReqMod param) {
		try {
			log.info(om.writeValueAsString(param));
			List<TecPcsReqLibelleMod> a_retourner = new ArrayList<>();
			List<TecPcsReqLibelleMod> liste=service.findPieceReqByIdDemande(param.getIdtecdmd());
			if(param.getProlongation()!=0) {
				for(int i=0;i<liste.size();i++) {
					if(liste.get(i).getId_piece().compareTo("225")!=0)
						a_retourner.add(liste.get(i));
				 }
				return new ResponseEntity<>(a_retourner, HttpStatus.OK);
			}
			else
				return new ResponseEntity<>(liste, HttpStatus.OK);
			
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
