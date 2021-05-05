package com.cnaps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnaps.models.TecInfoReqMod;
import com.cnaps.models.TecInfoReqPK;

public interface TecInfoReqRepository extends JpaRepository<TecInfoReqMod,TecInfoReqPK> {
	
}
