package com.cnaps.models.param;

import java.sql.Date;

public class DemandeFiltre {
	private String matricule;
	private String reference;
	private String prestation;
	private Integer type_etat;
	private Date dateReception;
	private String nom;
	private String prenom;
	private int pagination;
	private int taille;

	public String getPrestation() {
		return prestation;
	}

	public void setPrestation(String prestation) {
		this.prestation = prestation;
	}

	public Integer getType_etat() {
		if (this.type_etat == null)
			this.type_etat = 0;
		return type_etat;
	}

	public void setType_etat(Integer type_etat) {
		this.type_etat = type_etat;
	}

	public int getPagination() {
		return pagination;
	}

	public void setPagination(int pagination) {
		this.pagination = pagination;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Date getDateReception() {
		return dateReception;
	}

	public void setDateReception(Date dateReception) {
		this.dateReception = dateReception;
	}

	public int getTaille() {
		if (this.taille == 0)
			this.taille = 10;
		return taille;
	}

	public void setTaille(int taille) {
		if (this.taille == 0)
			this.taille = 10;
		else
			this.taille = taille;
	}

	public DemandeFiltre() {
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
