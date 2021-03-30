package com.cnaps.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
//@IdClass(TecHistoEtatPK.class)
@Table(name = "tec_histo_etat")
public class TecHistoEtatMod {

	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQ")
//	@SequenceGenerator(name = "ID_SEQ", sequenceName = "seq_histo")
	@Column(name = "id_histo",nullable = false )
	private int idHisto;
	
	
	@Column(name = "id_acc",nullable = false )
	private String idacc;
	
    @Column(name = "type_etat",nullable = false )
	private int id_type_etat;
	
    
	@Column(name = "date")
	private Date dateetat;
    
    @Column(name = "observations")
	private String observations;
    
    @Column(name = "observations_sem")
	private String observationsSem;
    
    @Column(name = "user_modif")
	private String userModif;
    
    @Transient
    private String libelle;
    
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getIdHisto() {
		return idHisto;
	}

	public void setIdHisto(int idHisto) {
		this.idHisto = idHisto;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public String getObservationsSem() {
		return observationsSem;
	}

	public void setObservationsSem(String observationsSem) {
		this.observationsSem = observationsSem;
	}

	public String getUserModif() {
		return userModif;
	}

	public void setUserModif(String userModif) {
		this.userModif = userModif;
	}

	public String getIdacc() {
		return idacc;
	}

	public void setIdacc(String idacc) {
		this.idacc = idacc;
	}

	public int getId_type_etat() {
		return id_type_etat;
	}

	public void setId_type_etat(int id_type_etat) {
		this.id_type_etat = id_type_etat;
	}

	public Date getDateetat() {
		return dateetat;
	}

	public void setDateetat(Date dateetat) {
		this.dateetat = dateetat;
	}

	public TecHistoEtatMod(String idacc, int id_type_etat, Date dateetat) {
		super();
		this.idacc = idacc;
		this.id_type_etat = id_type_etat;
		this.dateetat = dateetat;
	}

	public TecHistoEtatMod() { 
	}


	
	
}
