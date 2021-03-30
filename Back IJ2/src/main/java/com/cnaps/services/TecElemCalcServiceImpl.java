package com.cnaps.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cnaps.models.TecElemCalcMod;
import com.cnaps.models.TecElemCalcPK;
import com.cnaps.repository.TecElemCalcRepository;


@Service
public class TecElemCalcServiceImpl implements  TecElemCalcService{

	public static int max=50;
	
	@Autowired
	private TecElemCalcRepository tecElemCalcRepository;

	@Override
	public void save(TecElemCalcMod entity) {
		tecElemCalcRepository.save(entity);
	}

	@Override
	public TecElemCalcMod getById(Serializable id) {
		return tecElemCalcRepository.findById((TecElemCalcPK)id).get();
	}

	@Override
	public List<TecElemCalcMod> getAll(int page) {
		Pageable pageable = PageRequest.of(page - 1, max);
		return (tecElemCalcRepository.findAll(pageable)).getContent();
	}

	@Override
	public void delete(TecElemCalcMod a) {
		tecElemCalcRepository.delete(a);
	}
	
	@Override
	public int nombrepage() {
		return (int)(tecElemCalcRepository.count()/max)+1;
	}

	@Override
	public List<TecElemCalcMod> findByIdAcc(String idacc) {
		return tecElemCalcRepository.findByIdAcc(idacc);
	}

	@Override
	public int seqElemCalc() {
		return tecElemCalcRepository.seqElemCalc();
	}

}
