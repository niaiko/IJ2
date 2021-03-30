package com.cnaps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnaps.models.TecPcsMod;

public interface TecPcsRepository extends JpaRepository<TecPcsMod,String> {
	
}
