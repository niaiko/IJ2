package com.cnaps.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ref_enfant_ne")
public class RefEnfantNeMod{
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQ")
//    @SequenceGenerator(name = "ID_SEQ", sequenceName = "seq_id_ref_enfant_ne")
	@Column(name = "id_ref_enfant_ne",nullable = false )
	private int id_ref_enfant_ne;
	
	@Column(name = "id_acc", nullable = false )
	private String id_acc;
	
	
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_acc",referencedColumnName = "id_acc")
	@JsonIgnoreProperties("ref_enfant_ne")
	private AccueilMod acc;*/
	
	public String getId_acc() {
		return id_acc;
	}


	public void setId_acc(String id_acc) {
		this.id_acc = id_acc;
	}


	@Column(name = "matricule")
	private String matricule;
	
	


	/*public AccueilMod getAcc() {
		return acc;
	}


	public void setAcc(AccueilMod acc) {
		this.acc = acc;
	}*/


	public int getId_ref_enfant_ne() {
		return id_ref_enfant_ne;
	}


	public void setId_ref_enfant_ne(int id_ref_enfant_ne) {
		this.id_ref_enfant_ne = id_ref_enfant_ne;
	}


	/*public String getId_acc() {
		return id_acc;
	}


	public void setId_acc(String id_acc) {
		this.id_acc = id_acc;
	}*/


	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	
	
	
	
	
	
	
	
}
