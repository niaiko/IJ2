package com.cnaps.models.param;

import java.util.List;

public class ParamPfDmdAf {
	private String reference;
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
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getDafUserSaisie() {
		return dafUserSaisie;
	}
	public void setDafUserSaisie(String dafUserSaisie) {
		this.dafUserSaisie = dafUserSaisie;
	}
}
