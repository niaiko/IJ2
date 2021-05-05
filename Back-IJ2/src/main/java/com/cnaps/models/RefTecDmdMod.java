package com.cnaps.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ref_tec_dmd")
public class RefTecDmdMod{
	@Id
	@Column(name = "id_tec_dmd", unique = true , nullable = false )
	private String id_tec_dmd;
	
	@Column(name = "id_type_demande", length = 3, nullable = false )
	private String id_type_demande;
	
	@Column(name = "libelle" , length = 50, nullable = true)
	private String libelle;

	public String getId_tec_dmd() {
		return id_tec_dmd;
	}

	public void setId_tec_dmd(String id_tec_dmd) {
		this.id_tec_dmd = id_tec_dmd;
	}

	public String getId_type_demande() {
		return id_type_demande;
	}

	public void setId_type_demande(String id_type_demande) {
		this.id_type_demande = id_type_demande;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
