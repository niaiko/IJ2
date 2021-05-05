package com.cnaps.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tec_memo")
public class TecMemoMod {
	
	@Id
	@Column(name = "id_memo")
	private String idMemo;
	
	@Column(name = "travailleur_matricule")
	private String travailleurMatricule;
	
	@Column(name = "observation")
	private String observation;
	
	@Column(name = "memo_date")
	private Date memoDate;
	
	@Column(name = "id_individu")
	private String idIndividu;

	public String getIdMemo() {
		return idMemo;
	}

	public void setIdMemo(String idMemo) {
		this.idMemo = idMemo;
	}

	public String getTravailleurMatricule() {
		return travailleurMatricule;
	}

	public void setTravailleurMatricule(String travailleurMatricule) {
		this.travailleurMatricule = travailleurMatricule;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Date getMemoDate() {
		return memoDate;
	}

	public void setMemoDate(Date memoDate) {
		this.memoDate = memoDate;
	}

	public String getIdIndividu() {
		return idIndividu;
	}

	public void setIdIndividu(String idIndividu) {
		this.idIndividu = idIndividu;
	}
	
}
