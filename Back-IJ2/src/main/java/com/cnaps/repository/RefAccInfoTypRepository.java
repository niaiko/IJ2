package com.cnaps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cnaps.models.RefAccInfoTypMod;

public interface RefAccInfoTypRepository extends JpaRepository<RefAccInfoTypMod,Integer>{
	RefAccInfoTypMod findByAbbrev(String abrev);
	
	
	@Query(value="select u from RefAccInfoTypMod u where u.id_type_info=?1")
	RefAccInfoTypMod findById_type_info(int id_type_info);
}
