package com.cnaps.services;

import java.util.List;

import com.cnaps.models.TecInfoRecuTraitMod;

public interface TecInfoRecuTraitService extends CRUDService<TecInfoRecuTraitMod> {
	List<TecInfoRecuTraitMod> findByIdAccueil(String id_acc);
}
