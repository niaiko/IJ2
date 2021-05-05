package com.cnaps.models;

public class DataAp {
	private String dateAp;
	private String matricule;

	public String getDateAp() {
		return dateAp;
	}

	public void setDateAp(String dateAp) {
		this.dateAp = dateAp;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public DataAp(String dateAp, String matricule) {
		super();
		this.dateAp = dateAp;
		this.matricule = matricule;
	}

	public DataAp() {
		super();
	}

}
