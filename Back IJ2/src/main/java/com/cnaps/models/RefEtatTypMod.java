package com.cnaps.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ref_etat_typ")
public class RefEtatTypMod{
	

	@Id
	@Column(name = "id_type_etat", unique = true , nullable = false )
	private int id_type_etat;
	
	@Column(name = "libelle", length = 50, nullable = false )
	private String libelle;
	
	

	public RefEtatTypMod(int id_type_etat) {
		super();
		this.id_type_etat = id_type_etat;
	}
	
	public RefEtatTypMod() {
		super();
	}

	public int getId_type_etat() {
		return id_type_etat;
	}

	public void setId_type_etat(int id_type_etat) {
		this.id_type_etat = id_type_etat;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	
	
	
	
	
}
