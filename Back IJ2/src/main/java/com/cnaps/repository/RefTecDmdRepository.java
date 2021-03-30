package com.cnaps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cnaps.models.RefTecDmdMod;

public interface RefTecDmdRepository extends JpaRepository<RefTecDmdMod,String> {
	@Query(value="select u from RefTecDmdMod u where u.id_tec_dmd=?1")
	RefTecDmdMod findById_tec_dmd(String id_tec_dmd);
	
	
	@Query(value="select u from RefTecDmdMod u where u.id_tec_dmd like concat(?1,'%')")
	List<RefTecDmdMod> findAllPrestationPF(String prestation);
}
