package com.cnaps.models.param;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PfBafEnfantParam {
	private String nom;
	private String statut;
	private String matricule;
	private String datenaissance;
	private String prenom;
	private int age;
	private Date dateDebut;
	private String numCin;
	private String idEnfant;
	private String etatEmployeur;
	private Date enfDateDebut;
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getDatenaissance() {
		return datenaissance;
	}
	public void setDatenaissance(String datenaissance) {
		this.datenaissance = datenaissance;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getNumCin() {
		return numCin;
	}
	public void setNumCin(String numCin) {
		this.numCin = numCin;
	}
	public String getIdEnfant() {
		return idEnfant;
	}
	public void setIdEnfant(String idEnfant) {
		this.idEnfant = idEnfant;
	}
	public String getEtatEmployeur() {
		return etatEmployeur;
	}
	public void setEtatEmployeur(String etatEmployeur) {
		this.etatEmployeur = etatEmployeur;
	}
	public Date getEnfDateDebut() {
		return enfDateDebut;
	}
	public void setEnfDateDebut(Date enfDateDebut) {
		this.enfDateDebut = enfDateDebut;
	}
}
