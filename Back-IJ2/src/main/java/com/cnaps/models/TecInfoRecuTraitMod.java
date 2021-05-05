package com.cnaps.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(TecInfoRecuTraitModPK.class)
@Table(name = "tec_info_recu")
public class TecInfoRecuTraitMod{
	
	@Id
	@Column(name = "id_acc")
	private String id_acc;
	
	@Column(name = "valeur", length = 50, nullable = false )
	private String valeur;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_type_info",referencedColumnName="id_type_info")
	private RefAccInfoTypMod refAccInfoTypMod;
	
	
	public TecInfoRecuTraitMod() {
		super();
	}

	public String getId_acc() {
		return id_acc;
	}

	public void setId_acc(String id_acc) {
		this.id_acc = id_acc;
	}

	

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public RefAccInfoTypMod getRefAccInfoTypMod() {
		return refAccInfoTypMod;
	}

	public void setRefAccInfoTypMod(RefAccInfoTypMod refAccInfoTypMod) {
		this.refAccInfoTypMod = refAccInfoTypMod;
	}
	
	
	
	
}
