package com.cnaps.models.param;

import java.sql.Date;

public class HistoriqueDemandeMod {
	private String id_demande;
	private String matricule_demandeur;
	private Date date_dmd;
	private String type_dmd;
	
	
	public String getId_demande() {
		return id_demande;
	}
	public void setId_demande(String id_demande) {
		this.id_demande = id_demande;
	}
	public String getMatricule_demandeur() {
		return matricule_demandeur;
	}
	public void setMatricule_demandeur(String matricule_demandeur) {
		this.matricule_demandeur = matricule_demandeur;
	}
	public Date getDate_dmd() {
		return date_dmd;
	}
	public void setDate_dmd(Date date_dmd) {
		this.date_dmd = date_dmd;
	}
	public String getType_dmd() {
		return type_dmd;
	}
	public void setType_dmd(String type_dmd) {
		this.type_dmd = type_dmd;
	}
	
	
}
