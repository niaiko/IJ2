package com.cnaps.models.param;

import java.sql.Date;

public class FiltreDmd {
	private String reference;
	private Date date;
	private String idIndividu;
	private int etat;
	private String dr;
	
	
	
	public String getDr() {
		return dr;
	}
	public void setDr(String dr) {
		this.dr = dr;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getIdIndividu() {
		if(this.idIndividu == null)
			return idIndividu = "";
		return idIndividu;
	}
	public void setIdIndividu(String idIndividu) {
		this.idIndividu = idIndividu;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	
}
