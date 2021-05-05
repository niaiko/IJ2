package com.cnaps.models.param;

import java.util.List;

import com.cnaps.models.AccueilMod;

public class PfBafEnfantMod {
	private AccueilMod accueil;
	private List<String> enfant;
	
	
	public List<String> getEnfant() {
		return enfant;
	}
	public void setEnfant(List<String> enfant) {
		this.enfant = enfant;
	}
	public AccueilMod getAccueil() {
		return accueil;
	}
	public void setAccueil(AccueilMod accueil) {
		this.accueil = accueil;
	}
	
	
}
