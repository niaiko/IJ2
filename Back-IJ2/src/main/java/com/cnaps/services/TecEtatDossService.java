package com.cnaps.services;

import java.sql.Date;
import java.util.List;

import com.cnaps.models.TecEtatDossMod;

public interface TecEtatDossService extends CRUDService<TecEtatDossMod> {
	void updateEtatDemande(String idacc, int etat);
	List<TecEtatDossMod> findByIdAcc(String idacc);
	void updateNumOp(String numOp,Date date_etat,String idAcc);
	
	List<TecEtatDossMod> getAllWithOp();
	
	public void updateOp(List<String> idAcc,String numOp);
	
}
