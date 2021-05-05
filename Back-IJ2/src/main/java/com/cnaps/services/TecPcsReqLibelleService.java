package com.cnaps.services;

import java.util.List;

import com.cnaps.models.TecPcsReqLibelleMod;

public interface TecPcsReqLibelleService extends CRUDService<TecPcsReqLibelleMod> {
	
	List<TecPcsReqLibelleMod> findPieceReqByIdDemande(String id);
	
	List<TecPcsReqLibelleMod> findPiecePension();
}
