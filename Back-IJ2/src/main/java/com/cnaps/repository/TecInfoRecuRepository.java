package com.cnaps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cnaps.models.TecInfoRecuMod;
import com.cnaps.models.TecInfoRecuModPK;

public interface TecInfoRecuRepository extends JpaRepository<TecInfoRecuMod,TecInfoRecuModPK> {
	@Query(value="select u from TecInfoRecuMod u where u.idAcc=?1")
	List<TecInfoRecuMod> findByIdAccueil(String id_acc);
	
	@Query(value = "select nextval('\"RFM\".seq_info_recu')", nativeQuery=true)
	long seqTecInfoRecu();
	
	TecInfoRecuMod findByIdAccIsAndIdTypeInfoIs(String idAcc,Integer idTypeInfo);
}
