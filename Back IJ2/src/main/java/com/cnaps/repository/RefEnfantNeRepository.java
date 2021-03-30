package com.cnaps.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cnaps.models.RefEnfantNeMod;



public interface RefEnfantNeRepository extends JpaRepository<RefEnfantNeMod,Integer> {
	@Query("select u from RefEnfantNeMod u where u.id_acc = ?1")
	List<RefEnfantNeMod> findByIdAccueil(String id_acc);
	
	@Query(value="select u from RefEnfantNeMod u where u.id_acc=?1 and u.matricule=?2")
	List<RefEnfantNeMod> findByIdAccIsAndMatriculeIs(String idAcc,String matricule);
}
