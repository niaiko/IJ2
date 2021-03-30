package com.cnaps.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "tec_info_req_libelle")
public class TecInfoReqLibelleMod {
	
	@Column(name = "id_tec_dmd",nullable = false )
	private String id_tec_dmd;
	
	
	@Column(name = "id_type_info", nullable = false )
	private int id_type_info;
	
	
	@Id
	@Column(name = "libelle", nullable = false )
	private String libelle;
	
	
	@Column(name = "type_champ", length=1 )
	private String type_champ;
	
	
	@Column(name = "use", length=1 )
	private String flaguse;

	public String getId_tec_dmd() {
		return id_tec_dmd;
	}

	public void setId_tec_dmd(String id_tec_dmd) {
		this.id_tec_dmd = id_tec_dmd;
	}

	public int getId_type_info() {
		return id_type_info;
	}

	public void setId_type_info(int id_type_info) {
		this.id_type_info = id_type_info;
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

	public String getFlaguse() {
		return flaguse;
	}

	public void setFlaguse(String flaguse) {
		this.flaguse = flaguse;
	}
	
	

	

	
}
