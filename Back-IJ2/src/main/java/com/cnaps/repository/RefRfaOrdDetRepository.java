package com.cnaps.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cnaps.models.RefRfaOrdDetMod;



public interface RefRfaOrdDetRepository extends JpaRepository<RefRfaOrdDetMod,Integer> {
	@Query("select u from RefRfaOrdDetMod u where u.id_ref_rfa_ord=?1")
	List<RefRfaOrdDetMod> findByIdOrdMere(int id_mere);
	
	@Query("select u from RefRfaOrdDetMod u where u.id_ref_rfa_ord=?1 and u.valide=?2")
	List<RefRfaOrdDetMod> findByIdOrdMere(int id_mere, boolean valide);
}
