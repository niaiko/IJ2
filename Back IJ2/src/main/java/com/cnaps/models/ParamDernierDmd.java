package com.cnaps.models;

import java.sql.Date;

public class ParamDernierDmd {

	private String individu;
	private String employeur;
	private String idacc;
	private String idTecDmd;
	private Date dateInsertion;
	private Integer etat;
	private String numDoss;
	private Date dateDossier;
	private String dateDpa;
	private java.util.Date dateDpaApres;
	private boolean flagDateDpa;

	public ParamDernierDmd() {
		super();
	}

	public String getIndividu() {
		return individu;
	}

	public void setIndividu(String individu) {
		this.individu = individu;
	}

	public String getEmployeur() {
		return employeur;
	}

	public void setEmployeur(String employeur) {
		this.employeur = employeur;
	}

	public String getIdacc() {
		return idacc;
	}

	public void setIdacc(String idacc) {
		this.idacc = idacc;
	}

	public String getIdTecDmd() {
		return idTecDmd;
	}

	public void setIdTecDmd(String idTecDmd) {
		this.idTecDmd = idTecDmd;
	}

	public Date getDateInsertion() {
		return dateInsertion;
	}

	public void setDateInsertion(Date dateInsertion) {
		this.dateInsertion = dateInsertion;
	}

	public Integer getEtat() {
		return etat;
	}

	public void setEtat(Integer etat) {
		this.etat = etat;
	}

	public String getNumDoss() {
		return numDoss;
	}

	public void setNumDoss(String numDoss) {
		this.numDoss = numDoss;
	}

	public Date getDateDossier() {
		return dateDossier;
	}

	public void setDateDossier(Date dateDossier) {
		this.dateDossier = dateDossier;
	}

	public String getDateDpa() {
		return dateDpa;
	}

	public void setDateDpa(String dateDpa) {
		this.dateDpa = dateDpa;
	}

	public java.util.Date getDateDpaApres() {
		return dateDpaApres;
	}

	public void setDateDpaApres(java.util.Date dateDpaApres) {
		this.dateDpaApres = dateDpaApres;
	}

	public boolean isFlagDateDpa() {
		return flagDateDpa;
	}

	public void setFlagDateDpa(boolean flagDateDpa) {
		this.flagDateDpa = flagDateDpa;
	}

}
