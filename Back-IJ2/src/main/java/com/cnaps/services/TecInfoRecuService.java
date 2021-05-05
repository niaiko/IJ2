package com.cnaps.services;

import java.util.List;

import com.cnaps.models.TecInfoRecuMod;

public interface TecInfoRecuService extends CRUDService<TecInfoRecuMod> {
	List<TecInfoRecuMod> findByIdAccueil(String id_acc);
	
	void save(List<TecInfoRecuMod> tecInfoRecuList);
	
	long seqTecInfoRecu();
	
	TecInfoRecuMod getByIdAccIsAndIdTypeInfoIs(String idAcc,Integer idTypeInfo);
}
