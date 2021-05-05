package com.cnaps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cnaps.models.TecInfoRecuTraitMod;
import com.cnaps.models.TecInfoRecuTraitModPK;

public interface TecInfoRecuTraitRepository extends JpaRepository<TecInfoRecuTraitMod,TecInfoRecuTraitModPK> {
	@Query(value="select u from TecInfoRecuTraitMod u where u.id_acc=?1")
	List<TecInfoRecuTraitMod> findByIdAccueil(String id_acc);
	
}
