package com.cnaps.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ref_tec_dmd_typ")
public class RefTecDmdTypMod{
	

	@Id
	@Column(name = "id_type_demande", unique = true , nullable = false )
	private String id_type_demande;
	
	@Column(name = "libelle_type_demande", length = 50, nullable = true )
	private String libelle_type_demande;
	
	
	
	
	public RefTecDmdTypMod(String id_type_demande) {
		super();
		this.id_type_demande = id_type_demande;
	}
	
	public RefTecDmdTypMod() {
		super();
	}

	public String getId_type_demande() {
		return id_type_demande;
	}

	public void setId_type_demande(String id_type_demande) {
		this.id_type_demande = id_type_demande;
	}

	public String getLibelle_type_demande() {
		return libelle_type_demande;
	}

	public void setLibelle_type_demande(String libelle_type_demande) {
		this.libelle_type_demande = libelle_type_demande;
	}
	
	

	
	
	
}
