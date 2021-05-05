package com.cnaps.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cnaps.models.RefEtatTypMod;
import com.cnaps.services.RefEtatTypService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class RefEtatTypControlleur {
	ObjectMapper om = new ObjectMapper();
	private static final Logger log = LoggerFactory.getLogger(RefEtatTypControlleur.class);
	String resultat;
	String nom = "RefEtatTyp";

	@Autowired
	RefEtatTypService service;

	@PostMapping("/listeRefEtatTypPF")
	public ResponseEntity<Object> listeRefEtatTypPF() {
		try {
			List<RefEtatTypMod> liste = service.getAll(1);
			List<RefEtatTypMod> listeFin = new ArrayList<>();
			for (int i = 0; i < liste.size(); i++) {
				if (liste.get(i).getId_type_etat() != 2 && liste.get(i).getId_type_etat() != 5
						&& liste.get(i).getId_type_etat() != 7 && liste.get(i).getId_type_etat() != 9) {
					System.out.println("listeFin"+ om.writeValueAsString(listeFin));
					listeFin.add(liste.get(i));
				}

			}

			return new ResponseEntity<>(listeFin, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
