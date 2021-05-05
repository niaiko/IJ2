package com.cnaps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cnaps.models.TecInfoReqLibelleMod;


public interface TecInfoReqLibelleRepository extends JpaRepository<TecInfoReqLibelleMod,String> {
	@Query("select tec from TecInfoReqLibelleMod tec where tec.id_tec_dmd=?1 and tec.flaguse='O' ")
	List<TecInfoReqLibelleMod> findInfoReqByIdDemande(String id);
}
