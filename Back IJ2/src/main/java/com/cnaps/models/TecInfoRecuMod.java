package com.cnaps.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@IdClass(TecInfoRecuModPK.class)
@Table(name = "tec_info_recu")
public class TecInfoRecuMod{
	
	@Id
	@Column(name = "id_acc")
	private String idAcc;
	
	@Id
	@Column(name = "id_type_info")
	private Integer idTypeInfo;
	
	@Column(name = "valeur")
	private String valeur;
	
	@Transient
	private RefAccInfoTypMod refAccInfoTypMod;
	
	

	public RefAccInfoTypMod getRefAccInfoTypMod() {
		return refAccInfoTypMod;
	}

	public void setRefAccInfoTypMod(RefAccInfoTypMod refAccInfoTypMod) {
		this.refAccInfoTypMod = refAccInfoTypMod;
	}

	public TecInfoRecuMod(String id_acc,Integer id_type_info) {
		super();
		this.idAcc = id_acc;
		this.idTypeInfo = id_type_info;
	}
	
	public TecInfoRecuMod() {
		super();
	}

	

	public String getIdAcc() {
		return idAcc;
	}

	public void setIdAcc(String idAcc) {
		this.idAcc = idAcc;
	}

	public Integer getIdTypeInfo() {
		return idTypeInfo;
	}

	public void setIdTypeInfo(Integer idTypeInfo) {
		this.idTypeInfo = idTypeInfo;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
}
