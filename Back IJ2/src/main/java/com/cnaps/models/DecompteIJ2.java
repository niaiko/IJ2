package com.cnaps.models;

public class DecompteIJ2 {
	private String DAT;
	private String DAC;
	private String DRT;
	
	private double salaire;
	private double ij1;
	private double prenatale;
	private double postnatale;
	private double demisalaire;
	
	private String date_debut_prenatale;
	private String date_debut_postnatale;
	private String date_fin_postnatale;
	
	private String date_debut_prolongation;
	private String date_fin_prolongation;
	
	
	
	private int nbjourIJ1;
	private int nbjourIJ2;
	private int nbjourpre;
	private int nbjourpost;
	private int nbprolongation;
	public String getDAT() {
		return DAT;
	}
	public void setDAT(String dAT) {
		DAT = dAT;
	}
	public String getDAC() {
		return DAC;
	}
	public void setDAC(String dAC) {
		DAC = dAC;
	}
	public String getDRT() {
		return DRT;
	}
	public void setDRT(String dRT) {
		DRT = dRT;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	public double getIj1() {
		return ij1;
	}
	public void setIj1(double ij1) {
		this.ij1 = ij1;
	}
	public double getPrenatale() {
		return prenatale;
	}
	public void setPrenatale(double prenatale) {
		this.prenatale = prenatale;
	}
	public double getPostnatale() {
		return postnatale;
	}
	public void setPostnatale(double postnatale) {
		this.postnatale = postnatale;
	}
	public double getDemisalaire() {
		return demisalaire;
	}
	public void setDemisalaire(double demisalaire) {
		this.demisalaire = demisalaire;
	}
	public String getDate_debut_prenatale() {
		return date_debut_prenatale;
	}
	public void setDate_debut_prenatale(String date_debut_prenatale) {
		this.date_debut_prenatale = date_debut_prenatale;
	}
	public String getDate_debut_postnatale() {
		return date_debut_postnatale;
	}
	public void setDate_debut_postnatale(String date_debut_postnatale) {
		this.date_debut_postnatale = date_debut_postnatale;
	}
	public String getDate_fin_postnatale() {
		return date_fin_postnatale;
	}
	public void setDate_fin_postnatale(String date_fin_postnatale) {
		this.date_fin_postnatale = date_fin_postnatale;
	}
	public String getDate_debut_prolongation() {
		return date_debut_prolongation;
	}
	public void setDate_debut_prolongation(String date_debut_prolongation) {
		this.date_debut_prolongation = date_debut_prolongation;
	}
	public String getDate_fin_prolongation() {
		return date_fin_prolongation;
	}
	public void setDate_fin_prolongation(String date_fin_prolongation) {
		this.date_fin_prolongation = date_fin_prolongation;
	}
	public int getNbjourIJ1() {
		return nbjourIJ1;
	}
	public void setNbjourIJ1(int nbjourIJ1) {
		this.nbjourIJ1 = nbjourIJ1;
	}
	public int getNbjourIJ2() {
		return nbjourIJ2;
	}
	public void setNbjourIJ2(int nbjourIJ2) {
		this.nbjourIJ2 = nbjourIJ2;
	}
	public int getNbjourpre() {
		return nbjourpre;
	}
	public void setNbjourpre(int nbjourpre) {
		this.nbjourpre = nbjourpre;
	}
	public int getNbjourpost() {
		return nbjourpost;
	}
	public void setNbjourpost(int nbjourpost) {
		this.nbjourpost = nbjourpost;
	}
	public int getNbprolongation() {
		return nbprolongation;
	}
	public void setNbprolongation(int nbprolongation) {
		this.nbprolongation = nbprolongation;
	}
	
	
}
