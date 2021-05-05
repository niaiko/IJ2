package com.cnaps.models;

import java.util.ArrayList;
import java.util.List;

public class DemandeIJMod{
	
	
	private AccueilMod accueilMod;
	private List<TecInfoRecuMod> tecInfoRecuMod;
	private List<TecPcsRecMod> tecPcsRecMod;
	private List<RefEnfantNeMod> refEnfantNeMod;
	private OrdonnanceMod ordonnanceMod;
	//private List<TecHistoEtatMod> histoEtatDmd;
	private List<AccueilMod> histoEtatDmd;
	private List<TecMemoMod> listeMemo;
	private Double droit;
	private ModePaiementTiers modepaietiers;
	
	
	
	
	
	
	public ModePaiementTiers getModepaietiers() {
		return modepaietiers;
	}

	public void setModepaietiers(ModePaiementTiers modepaietiers) {
		this.modepaietiers = modepaietiers;
	}

	public Double getDroit() {
		return droit;
	}

	public void setDroit(Double droit) {
		this.droit = droit;
	}

	public List<TecMemoMod> getListeMemo() {
		return listeMemo;
	}

	public void setListeMemo(List<TecMemoMod> listeMemo) {
		if(this.listeMemo.size() != 0)
			this.listeMemo = new ArrayList<>();
		this.listeMemo = listeMemo;
	}

	public List<AccueilMod> getHistoEtatDmd() {
		return histoEtatDmd;
	}

	public void setHistoEtatDmd(List<AccueilMod> histoEtatDmd) {
		this.histoEtatDmd = histoEtatDmd;
	}

	public AccueilMod getAccueilMod() {
		return accueilMod;
	}
	
	public void setAccueilMod(AccueilMod accueilMod) {
		this.accueilMod = accueilMod;
	}

	public List<TecInfoRecuMod> getTecInfoRecuMod() {
		return tecInfoRecuMod;
	}

	public void setTecInfoRecuMod(List<TecInfoRecuMod> tecInfoRecuMod) {
		this.tecInfoRecuMod = tecInfoRecuMod;
	}

	public List<TecPcsRecMod> getTecPcsRecMod() {
		return tecPcsRecMod;
	}

	public void setTecPcsRecMod(List<TecPcsRecMod> tecPcsRecMod) {
		this.tecPcsRecMod = tecPcsRecMod;
	}

	public List<RefEnfantNeMod> getRefEnfantNeMod() {
		return refEnfantNeMod;
	}

	public void setRefEnfantNeMod(List<RefEnfantNeMod> refEnfantNeMod) {
		this.refEnfantNeMod = refEnfantNeMod;
	}

	public OrdonnanceMod getOrdonnanceMod() {
		return ordonnanceMod;
	}

	public void setOrdonnanceMod(OrdonnanceMod ordonnanceMod) {
		this.ordonnanceMod = ordonnanceMod;
	}

	public DemandeIJMod(AccueilMod accueilMod, List<TecInfoRecuMod> tecInfoRecuMod, List<TecPcsRecMod> tecPcsRecMod,
			List<RefEnfantNeMod> refEnfantNeMod, OrdonnanceMod ordonnanceMod, List<AccueilMod> histoEtatDmd,
			List<TecMemoMod> listeMemo) {
		super();
		this.accueilMod = accueilMod;
		this.tecInfoRecuMod = tecInfoRecuMod;
		this.tecPcsRecMod = tecPcsRecMod;
		this.refEnfantNeMod = refEnfantNeMod;
		this.ordonnanceMod = ordonnanceMod;
		this.histoEtatDmd = histoEtatDmd;
		this.listeMemo = listeMemo;
	}

	public DemandeIJMod() {
		super();
		this.listeMemo = new ArrayList<>();
		this.histoEtatDmd = new ArrayList<>();
		this.ordonnanceMod = new OrdonnanceMod();
		this.refEnfantNeMod	= new ArrayList<>();
		this.refEnfantNeMod = new ArrayList<>();
		this.tecPcsRecMod = new ArrayList<>();
		this.tecInfoRecuMod = new ArrayList<>();
		this.refEnfantNeMod = new ArrayList<>();
		this.droit = 0.0;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
