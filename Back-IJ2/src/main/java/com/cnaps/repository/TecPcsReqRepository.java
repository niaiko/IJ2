package com.cnaps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnaps.models.TecPcsReqMod;
import com.cnaps.models.TecPcsReqPK;

public interface TecPcsReqRepository extends JpaRepository<TecPcsReqMod,TecPcsReqPK> {
	
}
