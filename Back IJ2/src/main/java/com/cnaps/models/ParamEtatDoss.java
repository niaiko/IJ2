package com.cnaps.models;

public class ParamEtatDoss {

	private int etat;
	private String idacc;
	private String observation;
	private String observationSem;
	private String userModif;
	
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public String getObservationSem() {
		return observationSem;
	}
	public void setObservationSem(String observationSem) {
		this.observationSem = observationSem;
	}
	public String getUserModif() {
		return userModif;
	}
	public void setUserModif(String userModif) {
		this.userModif = userModif;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public String getIdacc() {
		return idacc;
	}
	public void setIdacc(String idacc) {
		this.idacc = idacc;
	}
	
	
}
