package com.cnaps.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "tec_etat_doss")
public class TecEtatDossMod implements Serializable{
	
 
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQ")
//    @SequenceGenerator(name = "ID_SEQ", sequenceName = "seq_etat_doss")
	@Column(name = "id_etat", unique = false , nullable = false )
	private int id_etat;
	
	@NaturalId
	@Column(name = "id_acc")
	private String id_acc;
	
	@Column(name = "id_op")
	private String id_op;
	
	@Column(name = "id_type_etat")
	private int id_type_etat;
	
	@Column(name = "date_etat")
	private Date date_etat;
	
	@Column(name = "numero_dossier")
	private String numero_dossier;

	public int getId_etat() {
		return id_etat;
	}

	public void setId_etat(int id_etat) {
		this.id_etat = id_etat;
	}

	public String getId_acc() {
		return id_acc;
	}

	public void setId_acc(String id_acc) {
		this.id_acc = id_acc;
	}

	public String getId_op() {
		return id_op;
	}

	public void setId_op(String id_op) {
		this.id_op = id_op;
	}

	public int getId_type_etat() {
		return id_type_etat;
	}

	public void setId_type_etat(int id_type_etat) {
		this.id_type_etat = id_type_etat;
	}

	public Date getDate_etat() {
		return date_etat;
	}

	public void setDate_etat(Date date_etat) {
		this.date_etat = date_etat;
	}

	public String getNumero_dossier() {
		return numero_dossier;
	}

	public void setNumero_dossier(String numero_dossier) {
		this.numero_dossier = numero_dossier;
	}

	
	
	
	
}
