package com.cnaps.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "acc_new")
public class AccueilMod implements Serializable {
	
	private static final long serialVersionUID = 6737708890250299568L;

	@Id
	@Column(name = "id_acc_new", unique = true, nullable = false)
	private String idAccNew;

	@Column(name = "id_acc")
	private String id_acc;
	
	@Column(name = "id_alloc")
	private String id_allocataire;

	@Column(name = "id_tec_dmd")
	private String id_tec_dmd;

	@Column(name = "date_dossier")
	private Date date_dossier;
	
	@Column(name = "date_prescription")
	private Date date_prescription;

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

	@Column(name = "user_modif")
	private String user_modif;

	@Column(name = "date_modif")
	private Date date_modif;

	@Column(name = "user_insert")
	private String user_insert;

	@Column(name = "last")
	private Boolean last;

	@Column(name = "etat")
	private Integer etat;

	@Column(name = "observations")
	private String observations;

	@Column(name = "observations_sem")
	private String observationsSem;

	@Column(name = "type")
	private String type;

	@Column(name = "id_mode_paiement_tiers")
	private String id_mode_paiement_tiers;

	@Transient
	private String libelle_etat;

	@Transient
	private String nom;

	@Transient
	private String prenoms;

	@Transient
	private String idSexe;

	/*
	 * @OneToMany(mappedBy = "acc", fetch = FetchType.LAZY)
	 * 
	 * @JsonIgnoreProperties("acc") private List<RefEnfantNeMod> listeEnfant;
	 * 
	 * public List<RefEnfantNeMod> getListeEnfant() { return listeEnfant; } public
	 * void setListeEnfant(List<RefEnfantNeMod> listeEnfant) { this.listeEnfant =
	 * listeEnfant; }
	 */

	public AccueilMod(String idAccNew, String id_acc, String id_tec_dmd, Date date_dossier, String id_individu,
			String id_succursale, String id_empl, String num_doss, Date dateInsertion, String user_modif,
			Date date_modif, String user_insert, Boolean last, Integer etat, String observations,
			String observationsSem, String type, String id_mode_paiement_tiers, String libelle_etat, String nom,
			String prenoms, String idSexe) {
		super();
		this.idAccNew = idAccNew;
		this.id_acc = id_acc;
		this.id_tec_dmd = id_tec_dmd;
		this.date_dossier = date_dossier;
		this.id_individu = id_individu;
		this.id_succursale = id_succursale;
		this.id_empl = id_empl;
		this.num_doss = num_doss;
		this.dateInsertion = dateInsertion;
		this.user_modif = user_modif;
		this.date_modif = date_modif;
		this.user_insert = user_insert;
		this.last = last;
		this.etat = etat;
		this.observations = observations;
		this.observationsSem = observationsSem;
		this.type = type;
		this.id_mode_paiement_tiers = id_mode_paiement_tiers;
		this.libelle_etat = libelle_etat;
		this.nom = nom;
		this.prenoms = prenoms;
		this.idSexe = idSexe;
	}

	public String getLibelle_etat() {
		return libelle_etat;
	}

	public void setLibelle_etat(String libelle_etat) {
		this.libelle_etat = libelle_etat;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId_mode_paiement_tiers() {
		return id_mode_paiement_tiers;
	}

	public void setId_mode_paiement_tiers(String id_mode_paiement_tiers) {
		this.id_mode_paiement_tiers = id_mode_paiement_tiers;
	}

	public AccueilMod(String idAccNew, String id_acc, String id_allocataire, String id_tec_dmd, Date date_dossier, Date date_prescription, String id_individu,
			String id_succursale, String id_empl, String num_doss, Date dateInsertion, String user_modif,
			Date date_modif, String user_insert, Boolean last, Integer etat, String observations,
			String observationsSem) {
		super();
		this.idAccNew = idAccNew;
		this.id_acc = id_acc;
		this.id_allocataire = id_allocataire;
		this.id_tec_dmd = id_tec_dmd;
		this.date_dossier = date_dossier;
		this.date_prescription = date_prescription;
		this.id_individu = id_individu;
		this.id_succursale = id_succursale;
		this.id_empl = id_empl;
		this.num_doss = num_doss;
		this.dateInsertion = dateInsertion;
		this.user_modif = user_modif;
		this.date_modif = date_modif;
		this.user_insert = user_insert;
		this.last = last;
		this.etat = etat;
		this.observations = observations;
		this.observationsSem = observationsSem;
	}

	public AccueilMod() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getIdAccNew() {
		return idAccNew;
	}

	public void setIdAccNew(String idAccNew) {
		this.idAccNew = idAccNew;
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

	public String getUser_insert() {
		return user_insert;
	}

	public void setUser_insert(String user_insert) {
		this.user_insert = user_insert;
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

	public void setDateInsertion(Date dateinsertion) {
		this.dateInsertion = dateinsertion;
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

	public String getIdSexe() {
		return idSexe;
	}

	public void setIdSexe(String idSexe) {
		this.idSexe = idSexe;
	}

	public Date getDate_prescription() {
		return date_prescription;
	}

	public void setDate_prescription(Date date_prescription) {
		this.date_prescription = date_prescription;
	}

	public String getId_allocataire() {
		return id_allocataire;
	}

	public void setId_allocataire(String id_allocataire) {
		this.id_allocataire = id_allocataire;
	}
	
}
