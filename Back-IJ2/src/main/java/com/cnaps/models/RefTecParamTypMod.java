package com.cnaps.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ref_tec_param_typ")
public class RefTecParamTypMod{
	
	
	
	@Id
	@Column(name = "id_element", unique = true , nullable = false )
	private int id_element;
	
	@Column(name = "id_tec_dmd", length = 3, nullable = false )
	private String id_tec_dmd;
	
	@Column(name = "libelle", length=50, nullable = true)
	private String libelle;
	
	@Column(name = "type_champ", length = 20, nullable = false )
	private String type_champ;
	
	
	
	
	public RefTecParamTypMod(int id_element) {
		super();
		this.id_element = id_element;
	}
	
	public RefTecParamTypMod() {
		super();
	}

	public int getId_element() {
		return id_element;
	}

	public void setId_element(int id_element) {
		this.id_element = id_element;
	}

	public String getId_tec_dmd() {
		return id_tec_dmd;
	}

	public void setId_tec_dmd(String id_tec_dmd) {
		this.id_tec_dmd = id_tec_dmd;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getType_champ() {
		return type_champ;
	}

	public void setType_champ(String type_champ) {
		this.type_champ = type_champ;
	}

	
	
	
}
