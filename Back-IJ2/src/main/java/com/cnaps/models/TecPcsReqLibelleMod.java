package com.cnaps.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "tec_pcs_req_libelle")
public class TecPcsReqLibelleMod {
	
	@Column(name = "id_tec_dmd",nullable = false )
	private String id_tec_dmd;
	
	
	@Column(name = "id_piece", nullable = false )
	private String id_piece;
	
	
	@Id
	@Column(name = "libelle", nullable = false )
	private String libelle;
	
	
	@Column(name = "abrev", length=1 )
	private String abrev;
	
	@Column(name = "use", length=1 )
	private String flaguse;

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

	public String getAbrev() {
		return abrev;
	}

	public void setAbrev(String abrev) {
		this.abrev = abrev;
	}

	public String getId_piece() {
		return id_piece;
	}

	public void setId_piece(String id_piece) {
		this.id_piece = id_piece;
	}

	public String getFlaguse() {
		return flaguse;
	}

	public void setFlaguse(String flaguse) {
		this.flaguse = flaguse;
	}

	
	
	
	

	

	
}
