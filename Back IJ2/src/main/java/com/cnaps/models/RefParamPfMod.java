package com.cnaps.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ref_param_pf")
public class RefParamPfMod{
	
	@Id
	@Column(name = "id_ref_param_pf",nullable = false )
	private int id_ref_param_pf;
	
	@Column(name = "libelle_ref_param_pf", nullable = false )
	private String libelle_ref_param_pf;

	public int getId_ref_param_pf() {
		return id_ref_param_pf;
	}

	public void setId_ref_param_pf(int id_ref_param_pf) {
		this.id_ref_param_pf = id_ref_param_pf;
	}

	public String getLibelle_ref_param_pf() {
		return libelle_ref_param_pf;
	}

	public void setLibelle_ref_param_pf(String libelle_ref_param_pf) {
		this.libelle_ref_param_pf = libelle_ref_param_pf;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
