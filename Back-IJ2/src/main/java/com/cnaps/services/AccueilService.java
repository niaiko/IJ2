package com.cnaps.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cnaps.models.AccueilMod;
import com.cnaps.models.enfant.AccueilEnfantMod;
import com.cnaps.models.param.DemandeFiltre;

public interface AccueilService extends CRUDService<AccueilMod> {
	 long seqDemande();
	 long seqAccNews();
	 List<AccueilMod> listeAvecParam(int param);
	 List<AccueilMod> getbyidacc(String idacc);
	 List<AccueilMod> getbyidIndiv(String id_individu);
	 List<AccueilMod> getbyidIndivAndPrestation(String id_individu, String prestation);
	 List<AccueilMod> getByIdAcc(String idAcc);
	 void updateEmpl(String idEmpl,String id_succursale,String idAcc);
	 
	 AccueilMod saveEnfant(AccueilEnfantMod enfant);
	 
	 
	 List<AccueilMod> getByIdIndividuIsAndIdTecDmdIs(String idAcc,String idTecDmd);
	 
	 
	 Page<AccueilMod> getByIdIndividuAndIdAccAndDateReceptionAndIdTecDmd(DemandeFiltre dem);
	 
	 AccueilMod getByIdAccIsAndLast(String idAcc);
	 
	 List<AccueilMod> getByIdIndividuAndLast(String idIndividu);
	 
	 List<AccueilMod> getByidIndivuAndPrestation(String idIndividu,String prestation);
}
