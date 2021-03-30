package com.cnaps.models;

import java.io.Serializable;
import java.sql.Date;

public class TecHistoEtatPK implements Serializable{
	private static final long serialVersionUID = 1L;
	private Date dateetat;
	private String idacc;
	 
	public Date getDateetat() {
		return dateetat;
	}

	public void setDateetat(Date dateetat) {
		this.dateetat = dateetat;
	}

	public String getIdacc() {
		return idacc;
	}

	public void setIdacc(String idacc) {
		this.idacc = idacc;
	}
	
	
	
}
