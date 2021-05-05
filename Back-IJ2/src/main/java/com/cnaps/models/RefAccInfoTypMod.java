package com.cnaps.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ref_acc_info_typ")
public class RefAccInfoTypMod{
	
	@Id
	@Column(name = "id_type_info")
	private int id_type_info;
	
	@Column(name = "libelle_info")
	private String libelle_info;
	
	@Column(name = "type_champ")
	private String type_champ;
	
	@Column(name = "abbrev")
	private String abbrev;

	public int getId_type_info() {
		return id_type_info;
	}
	public void setId_type_info(int id_type_info) {
		this.id_type_info = id_type_info;
	}
	public String getLibelle_info() {
		return libelle_info;
	}
	public void setLibelle_info(String libelle_info) {
		this.libelle_info = libelle_info;
	}
	public String getType_champ() {
		return type_champ;
	}
	public void setType_champ(String type_champ) {
		this.type_champ = type_champ;
	}
	public String getAbbrev() {
		return abbrev;
	}
	public void setAbbrev(String abbrev) {
		this.abbrev = abbrev;
	}
	
	
}
