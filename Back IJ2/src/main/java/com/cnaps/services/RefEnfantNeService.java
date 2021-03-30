package com.cnaps.services;

import java.util.List;

import com.cnaps.models.RefEnfantNeMod;


public interface RefEnfantNeService extends CRUDService<RefEnfantNeMod> {
	void save(List<RefEnfantNeMod> listRefEnfantNeMod);
	List<RefEnfantNeMod> findByIdAccueil(String id_acc);
	
	List<RefEnfantNeMod> getByIdAccIsAndMatriculeIs(String idAcc,String matricule);
}
