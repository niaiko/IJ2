package com.cnaps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cnaps.models.RefEtatTypMod;

public interface RefEtatTypRepository extends JpaRepository<RefEtatTypMod,Integer>{
	@Query(value="select u from RefEtatTypMod u where u.id_type_etat=?1")
	RefEtatTypMod findByIdTypeEtat(Integer idTypeEtat);
}
