package com.cnaps.services;

import java.util.List;

import com.cnaps.models.TecInfoReqLibelleMod;

public interface TecInfoReqLibelleService extends CRUDService<TecInfoReqLibelleMod> {
	List<TecInfoReqLibelleMod> findInfoReqByIdDemande(String id);
}
