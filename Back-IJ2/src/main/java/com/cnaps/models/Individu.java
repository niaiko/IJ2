package com.cnaps.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "individu")
public class Individu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_individu")
	private String idIndividu;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenoms")
	private String prenoms;

	@Column(name = "cin")
	private String cin;

	@Column(name = "id_sexe")
	private String idSexe;

	public Individu() {
		super();
	}

	public String getIdIndividu() {
		return idIndividu;
	}

	public void setIdIndividu(String idIndividu) {
		this.idIndividu = idIndividu;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenoms() {
		return prenoms;
	}

	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getIdSexe() {
		return idSexe;
	}

	public void setIdSexe(String idSexe) {
		this.idSexe = idSexe;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
