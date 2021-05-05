package com.cnaps.models.param;

public class EtatParam {
	private int idTypeEtat;
	private String idAcc;
	private String observations;
	private String observationsSem;
	private String userModif;
	private Integer idEtat;
	
	
	public Integer getIdEtat() {
		return idEtat;
	}
	public void setIdEtat(Integer idEtat) {
		this.idEtat = idEtat;
	}
	public int getIdTypeEtat() {
		return idTypeEtat;
	}
	public void setIdTypeEtat(int idTypeEtat) {
		this.idTypeEtat = idTypeEtat;
	}
	public String getIdAcc() {
		return idAcc;
	}
	public void setIdAcc(String idAcc) {
		this.idAcc = idAcc;
	}
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	public String getObservationsSem() {
		return observationsSem;
	}
	public void setObservationsSem(String obervationsSem) {
		this.observationsSem = obervationsSem;
	}
	public String getUserModif() {
		return userModif;
	}
	public void setUserModif(String userModif) {
		this.userModif = userModif;
	}
	
	
}
