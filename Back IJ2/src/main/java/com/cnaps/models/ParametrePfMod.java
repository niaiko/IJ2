package com.cnaps.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parametre_pf")
public class ParametrePfMod{
	
	@Id
	@Column(name = "id_param",nullable = false )
	private int id_param;
	
	@Column(name = "libelle_param_pf", nullable = false )
	private String libelle_param_pf;
	
	
	@Column(name = "date_application")
	private Date date_application;
	
	@Column(name = "valeurs")
	private double valeurs;
	
	
	
	@Column(name = "id_ref_param_pf" )
	private int id_ref_param_pf;
	
	
	


	public int getId_param() {
		return id_param;
	}


	public void setId_param(int id_param) {
		this.id_param = id_param;
	}


	public String getLibelle_param_pf() {
		return libelle_param_pf;
	}


	public void setLibelle_param_pf(String libelle_param_pf) {
		this.libelle_param_pf = libelle_param_pf;
	}


	public Date getDate_application() {
		return date_application;
	}


	public void setDate_application(Date date_application) {
		this.date_application = date_application;
	}


	public double getValeurs() {
		return valeurs;
	}


	public void setValeurs(double valeurs) {
		this.valeurs = valeurs;
	}


	public int getId_ref_param_pf() {
		return id_ref_param_pf;
	}


	public void setId_ref_param_pf(int id_ref_param_pf) {
		this.id_ref_param_pf = id_ref_param_pf;
	}


	
	
	
	
	
	
}
