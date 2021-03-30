package com.cnaps.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "listedemande")
public class ListeDmdPf implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_acc")
	private String id_acc;

	@Column(name = "id_tec_dmd")
	private String id_tec_dmd;

	@Column(name = "date_dossier")
	private Date date_dossier;

	@Column(name = "id_individu")
	private String id_individu;

	@Column(name = "id_succursale")
	private String id_succursale;

	@Column(name = "id_empl")
	private String id_empl;

	@Column(name = "num_doss")
	private String num_doss;

	@Column(name = "date_insertion")
	private Date dateInsertion;

	@Column(name = "user_insert")
	private String user_insert;

	@Column(name = "user_modif")
	private String user_modif;

	@Column(name = "date_modif")
	private Date date_modif;

	@Column(name = "id_mode_paiement_tiers")
	private String id_mode_paiement_tiers;

	@Column(name = "type")
	private String type;

	@Column(name = "last")
	private Boolean last;

	@Column(name = "etat")
	private Integer etat;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenoms")
	private String prenoms;

	@Transient
	private String libelle_etat;

	@Transient
	private String idSexe;

	public ListeDmdPf() {
		super();
	}

	public String getId_acc() {
		return id_acc;
	}

	public void setId_acc(String id_acc) {
		this.id_acc = id_acc;
	}

	public String getId_tec_dmd() {
		return id_tec_dmd;
	}

	public void setId_tec_dmd(String id_tec_dmd) {
		this.id_tec_dmd = id_tec_dmd;
	}

	public Date getDate_dossier() {
		return date_dossier;
	}

	public void setDate_dossier(Date date_dossier) {
		this.date_dossier = date_dossier;
	}

	public String getId_individu() {
		return id_individu;
	}

	public void setId_individu(String id_individu) {
		this.id_individu = id_individu;
	}

	public String getId_succursale() {
		return id_succursale;
	}

	public void setId_succursale(String id_succursale) {
		this.id_succursale = id_succursale;
	}

	public String getId_empl() {
		return id_empl;
	}

	public void setId_empl(String id_empl) {
		this.id_empl = id_empl;
	}

	public String getNum_doss() {
		return num_doss;
	}

	public void setNum_doss(String num_doss) {
		this.num_doss = num_doss;
	}

	public Date getDateInsertion() {
		return dateInsertion;
	}

	public void setDateInsertion(Date dateInsertion) {
		this.dateInsertion = dateInsertion;
	}

	public String getUser_insert() {
		return user_insert;
	}

	public void setUser_insert(String user_insert) {
		this.user_insert = user_insert;
	}

	public String getUser_modif() {
		return user_modif;
	}

	public void setUser_modif(String user_modif) {
		this.user_modif = user_modif;
	}

	public Date getDate_modif() {
		return date_modif;
	}

	public void setDate_modif(Date date_modif) {
		this.date_modif = date_modif;
	}

	public String getId_mode_paiement_tiers() {
		return id_mode_paiement_tiers;
	}

	public void setId_mode_paiement_tiers(String id_mode_paiement_tiers) {
		this.id_mode_paiement_tiers = id_mode_paiement_tiers;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getLast() {
		return last;
	}

	public void setLast(Boolean last) {
		this.last = last;
	}

	public Integer getEtat() {
		return etat;
	}

	public void setEtat(Integer etat) {
		this.etat = etat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenoms() {
		return prenoms;
	}

	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getLibelle_etat() {
		return libelle_etat;
	}

	public void setLibelle_etat(String libelle_etat) {
		this.libelle_etat = libelle_etat;
	}

	public String getIdSexe() {
		return idSexe;
	}

	public void setIdSexe(String idSexe) {
		this.idSexe = idSexe;
	}

	@Override
	public String toString() {
		return "ListeDmdPf [id_acc=" + id_acc + ", id_tec_dmd=" + id_tec_dmd + ", date_dossier=" + date_dossier
				+ ", id_individu=" + id_individu + ", id_succursale=" + id_succursale + ", id_empl=" + id_empl
				+ ", num_doss=" + num_doss + ", dateInsertion=" + dateInsertion + ", user_insert=" + user_insert
				+ ", user_modif=" + user_modif + ", date_modif=" + date_modif + ", id_mode_paiement_tiers="
				+ id_mode_paiement_tiers + ", type=" + type + ", last=" + last + ", etat=" + etat + ", nom=" + nom
				+ ", prenoms=" + prenoms + "]";
	}

}
