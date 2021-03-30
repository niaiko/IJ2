package com.cnaps.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "demande")
public class DemandeMod {
	
	@Id
	@Column(name = "reference", unique = true , nullable = false )
	private String reference;
	
	@Column(name = "date_reception")
	private Date date_reception;
	
	@Column(name = "matricule")
	private String matricule;
	
	@Transient
	private String nom_individu;
	
	@Column(name = "etat_libelle")
	private String etat_libelle;
	
	@Column(name = "nature")
	private String nature;
	
	@Column(name = "etat")
	private int etat;
	
	
	

	public DemandeMod() {
		super();
	}

	
	
	public DemandeMod(String reference, Date date_reception, String matricule, String nom_individu, String etat_demande,
			int etat,String nature) {
		super();
		this.reference = reference;
		this.date_reception = date_reception;
		this.matricule = matricule;
		this.nom_individu = nom_individu;
		this.etat_libelle = etat_demande;
		this.etat = etat;
		this.nature = nature;
	}



	public String getNature() {
		return nature;
	}



	public void setNature(String nature) {
		this.nature = nature;
	}



	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Date getDate_reception() {
		return date_reception;
	}

	public void setDate_reception(Date date_reception) {
		this.date_reception = date_reception;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom_individu() {
		return nom_individu;
	}

	public void setNom_individu(String nom_individu) {
		this.nom_individu = nom_individu;
	}

	

	public String getEtat_libelle() {
		return etat_libelle;
	}



	public void setEtat_libelle(String etat_libelle) {
		this.etat_libelle = etat_libelle;
	}



	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	

	
}
