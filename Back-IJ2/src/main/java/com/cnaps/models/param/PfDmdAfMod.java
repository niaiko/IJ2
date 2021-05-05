package com.cnaps.models.param;

import java.util.List;

import com.cnaps.models.AccueilMod;

public class PfDmdAfMod {
	private AccueilMod accueilValeur;
	private String codeDr;
	private String dafUserSaisie;
	private Double sme;
	private List<PfBafEnfantParam> listeEnfant;  
	
	
	public Double getSme() {
		return sme;
	}
	public void setSme(Double sme) {
		this.sme = sme;
	}
	public List<PfBafEnfantParam> getListeEnfant() {
		return listeEnfant;
	}
	public void setListeEnfant(List<PfBafEnfantParam> listeEnfant) {
		this.listeEnfant = listeEnfant;
	}
		
	public String getDafUserSaisie() {
		return dafUserSaisie;
	}
	public void setDafUserSaisie(String dafUserSaisie) {
		this.dafUserSaisie = dafUserSaisie;
	}
	public AccueilMod getAccueilValeur() {
		return accueilValeur;
	}
	public void setAccueilValeur(AccueilMod accueilValeur) {
		this.accueilValeur = accueilValeur;
	}
	public String getCodeDr() {
		return codeDr;
	}
	public void setCodeDr(String codeDr) {
		this.codeDr = codeDr;
	}
	
	
}
