package com.cnaps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cnaps.models.TecElemCalcMod;
import com.cnaps.models.TecElemCalcPK;

public interface TecElemCalcRepository extends JpaRepository<TecElemCalcMod,TecElemCalcPK> {
	@Query(value = "select nextval('\"RFM\".seq_elem_calc')", nativeQuery=true)
	int seqElemCalc();
	
	@Query(value="SELECT u from TecElemCalcMod u where u.id_acc=?1")
	List<TecElemCalcMod> findByIdAcc(String idacc);
	
}
