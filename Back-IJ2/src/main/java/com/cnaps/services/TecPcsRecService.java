package com.cnaps.services;

import java.util.List;

import com.cnaps.models.TecPcsRecMod;;

public interface TecPcsRecService extends CRUDService<TecPcsRecMod> {
	void save(List<TecPcsRecMod> tecPcsRecuList);
	List<TecPcsRecMod> findByIdAccueil(String id_acc);
	
}
