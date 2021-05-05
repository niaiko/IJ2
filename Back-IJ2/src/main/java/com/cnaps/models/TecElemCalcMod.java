package com.cnaps.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@IdClass(TecElemCalcPK.class)
@Table(name = "tec_elem_calc")
public class TecElemCalcMod{
	
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQ")
//    @SequenceGenerator(name = "ID_SEQ", sequenceName = "seq_elem_calc")
	@Column(name = "id_element",nullable = false )
	private int id_element;
	
	@Id
	@Column(name = "id_acc", nullable = false )
	private String id_acc;
	
	
	@Column(name = "valeur", length = 20, nullable = false )
	private String valeur;
	
	
	public TecElemCalcMod(int id_element,String id_acc) {
		super();
		this.id_element = id_element;
		this.id_acc = id_acc;
	}
	
	public TecElemCalcMod() {
		super();
	}

	public int getId_element() {
		return id_element;
	}

	public void setId_element(int id_element) {
		this.id_element = id_element;
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

	
}
