package com.cnaps.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cnaps.models.RefRfaOrdMod;

public interface RefRfaOrdRepository extends JpaRepository<RefRfaOrdMod,Integer> {
	@Query("select u from RefRfaOrdMod u where u.id_acc = ?1")
	RefRfaOrdMod findByIdAccueil(String id_acc);
}
