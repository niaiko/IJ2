package com.cnaps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cnaps.models.TecPcsReqLibelleMod;


public interface TecPcsReqLibelleRepository extends JpaRepository<TecPcsReqLibelleMod,String> {
	@Query("select tec from TecPcsReqLibelleMod tec where tec.id_tec_dmd=?1 and tec.flaguse='O' ")
	List<TecPcsReqLibelleMod> findPieceReqByIdDemande(String id);
	
	@Query("select tec from TecPcsReqLibelleMod tec where tec.id_tec_dmd like '3%' or tec.id_tec_dmd like '%4' and tec.flaguse='O' ")
	List<TecPcsReqLibelleMod> findPiecePension();
}
