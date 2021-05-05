package com.cnaps.models;

import java.sql.Date;

public class InfoDmdApIndividuMod {
	private String id_acc;
	private String id_tec_dmd;
	private Integer id_type_info;
	private String valeur;
	private String nom;
	private String prenoms;
	private Date date_naissance;
	private Integer etat;
	private String libelleEtat;

	public String getId_acc() {
		return id_acc;
	}

	public void setId_acc(String id_acc) {
		this.id_acc = id_acc;
	}

	public String getId_tec_dmd() {
		return id_tec_dmd;
	}

	public void setId_tec_dmd(String id_tec_dmd) {
		this.id_tec_dmd = id_tec_dmd;
	}

	public Integer getId_type_info() {
		return id_type_info;
	}

	public void setId_type_info(Integer id_type_info) {
		this.id_type_info = id_type_info;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
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

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public Integer getEtat() {
		return etat;
	}

	public void setEtat(Integer etat) {
		this.etat = etat;
	}

	public String getLibelleEtat() {
		return libelleEtat;
	}

	public void setLibelleEtat(String libelleEtat) {
		this.libelleEtat = libelleEtat;
	}

	public InfoDmdApIndividuMod() {
		super();
	}

	public InfoDmdApIndividuMod(String id_acc, String id_tec_dmd, Integer id_type_info, String valeur, String nom,
			String prenoms, Date date_naissance, Integer etat, String libelleEtat) {
		super();
		this.id_acc = id_acc;
		this.id_tec_dmd = id_tec_dmd;
		this.id_type_info = id_type_info;
		this.valeur = valeur;
		this.nom = nom;
		this.prenoms = prenoms;
		this.date_naissance = date_naissance;
		this.etat = etat;
		this.libelleEtat = libelleEtat;
	}

}
