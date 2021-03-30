package com.cnaps.services;

import java.util.List;

import com.cnaps.models.TecHistoEtatMod;

public interface TecHistoEtatService extends CRUDService<TecHistoEtatMod>{

	List<TecHistoEtatMod>findDemandeStatusByidacc(String idacc);
	
}
