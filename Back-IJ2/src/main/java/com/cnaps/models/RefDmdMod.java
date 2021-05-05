package com.cnaps.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ref_demande")
public class RefDmdMod {

	@Id
	@Column(name = "id_ref_dmd", unique = true , nullable = false )
	private String idrefdmd;
	
	@Column(name = "matr_demandeur")
	private String matrdemandeur;
	
	@Column(name = "nature" )
	private String nature;
	
	@Column(name = "matr_benef" )
	private String  matrbenef;
	

	@Column(name = "numdoss" )
	private String  numdoss;
	
	@Column(name = "idacc" )
	private String  idacc;


	public String getIdrefdmd() {
		return idrefdmd;
	}

	public void setIdrefdmd(String idrefdmd) {
		this.idrefdmd = idrefdmd;
	}

	public String getMatrdemandeur() {
		return matrdemandeur;
	}

	public void setMatrdemandeur(String matrdemandeur) {
		this.matrdemandeur = matrdemandeur;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getMatrbenef() {
		return matrbenef;
	}

	public void setMatrbenef(String matrbenef) {
		this.matrbenef = matrbenef;
	}

	public String getNumdoss() {
		return numdoss;
	}

	public void setNumdoss(String numdoss) {
		this.numdoss = numdoss;
	}

	public String getIdacc() {
		return idacc;
	}

	public void setIdacc(String idacc) {
		this.idacc = idacc;
	}

	public RefDmdMod(String idrefdmd, String matrdemandeur, String nature, String matrbenef, String numdoss,
			String idacc) {
		super();
		this.idrefdmd = idrefdmd;
		this.matrdemandeur = matrdemandeur;
		this.nature = nature;
		this.matrbenef = matrbenef;
		this.numdoss = numdoss;
		this.idacc = idacc;
	}
	
	 
	
}
