package com.cnaps.services;



import java.util.List;

import org.springframework.data.domain.Page;

import com.cnaps.models.DemandeMod;
import com.cnaps.models.param.DemandeFiltre;
import com.cnaps.models.param.DemandeParam;

public interface DemandeService extends CRUDService<DemandeMod> {
	 Page<DemandeMod> listeAvecParam(int param,String prestation,int page);
	 
	  List<DemandeMod> advancedSearchDemande(DemandeMod dem);
	  List<DemandeMod> HistoDemandeById(DemandeMod dem);
	  
	 DemandeMod FindDemandeByMatriculeAndPrestation(DemandeMod dem);
	 
	 
	 int nombreDePageParEtat(int etat, String prestation);
	 
	 List<DemandeMod> getSearchAdvancedNoDate(DemandeMod dem,int page);
		
	List<DemandeMod> getSearchAdvanced(DemandeMod dem,int page);
		
	List<DemandeMod> getSearchAll(int page);
	
	List<DemandeMod> getByMatricule(String matricule);
	
	DemandeMod getByReference(String reference);
	
	List<DemandeMod> getAllDmd(DemandeParam dem,int page);
	
	Page<DemandeMod> getByIdIndividuAndIdAccAndDateReceptionAndIdTecDmd(DemandeFiltre dem);
	
	List<DemandeMod> getAllDmdEnfant(DemandeParam dem);
}
