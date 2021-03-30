package com.cnaps.models.enfant;

import java.sql.Date;

public class AccueilEnfantMod{
	

	private String idAcc;
	private String idTecDmd;
	private Date dateDossier;
	private String idIndividu;
	private String idSuccursale;
	private String idEmpl;
	private String numDoss;
	private Date dateInsertion;
	private String userInsert;
	private String userModif;
	private Date dateModif;
	
	

	public Date getDateInsertion() {
		return dateInsertion;
	}

	public void setDateInsertion(Date dateInsertion) {
		this.dateInsertion = dateInsertion;
	}

	public String getUserInsert() {
		return userInsert;
	}

	public void setUserInsert(String userInsert) {
		this.userInsert = userInsert;
	}

	public String getUserModif() {
		return userModif;
	}

	public void setUserModif(String userModif) {
		this.userModif = userModif;
	}

	public Date getDateModif() {
		return dateModif;
	}

	public void setDateModif(Date dateModif) {
		this.dateModif = dateModif;
	}

	public String getIdAcc() {
		return idAcc;
	}

	public void setIdAcc(String idAcc) {
		this.idAcc = idAcc;
	}

	public String getIdTecDmd() {
		return idTecDmd;
	}

	public void setIdTecDmd(String idTecDmd) {
		this.idTecDmd = idTecDmd;
	}

	public Date getDateDossier() {
		return dateDossier;
	}

	public void setDateDossier(Date dateDossier) {
		this.dateDossier = dateDossier;
	}

	public String getIdIndividu() {
		return idIndividu;
	}

	public void setIdIndividu(String idIndividu) {
		this.idIndividu = idIndividu;
	}

	public String getIdSuccursale() {
		return idSuccursale;
	}

	public void setIdSuccursale(String idSuccursale) {
		this.idSuccursale = idSuccursale;
	}

	public String getIdEmpl() {
		return idEmpl;
	}

	public void setIdEmpl(String idEmpl) {
		this.idEmpl = idEmpl;
	}

	public String getNumDoss() {
		return numDoss;
	}

	public void setNumDoss(String numDoss) {
		this.numDoss = numDoss;
	}

	public AccueilEnfantMod(String idAcc, String idTecDmd, Date dateDossier, String idIndividu, String idSuccursale,
			String idEmpl, String numDoss, Date dateInsertion, String userInsert, String userModif, Date dateModif) {
		super();
		this.idAcc = idAcc;
		this.idTecDmd = idTecDmd;
		this.dateDossier = dateDossier;
		this.idIndividu = idIndividu;
		this.idSuccursale = idSuccursale;
		this.idEmpl = idEmpl;
		this.numDoss = numDoss;
		this.dateInsertion = dateInsertion;
		this.userInsert = userInsert;
		this.userModif = userModif;
		this.dateModif = dateModif;
	}

	public AccueilEnfantMod() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
