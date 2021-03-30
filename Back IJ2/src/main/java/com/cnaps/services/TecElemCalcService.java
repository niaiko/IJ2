package com.cnaps.services;

import java.util.List;

import com.cnaps.models.TecElemCalcMod;

public interface TecElemCalcService extends CRUDService<TecElemCalcMod> {
	List<TecElemCalcMod> findByIdAcc(String idacc);
	
	int seqElemCalc(); 
}
