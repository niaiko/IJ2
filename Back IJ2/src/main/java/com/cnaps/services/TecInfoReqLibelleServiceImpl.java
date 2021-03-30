package com.cnaps.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cnaps.models.TecInfoReqLibelleMod;

import com.cnaps.repository.TecInfoReqLibelleRepository;

@Service
public class TecInfoReqLibelleServiceImpl implements  TecInfoReqLibelleService{

	public static int max=50;
	
	@Autowired
	private TecInfoReqLibelleRepository tecInfoReqLibelleRepository;

	@Override
	public void save(TecInfoReqLibelleMod entity) {
		tecInfoReqLibelleRepository.save(entity);
	}

	@Override
	public TecInfoReqLibelleMod getById(Serializable id) {
		return tecInfoReqLibelleRepository.findById((String)id).get();
	}

	@Override
	public List<TecInfoReqLibelleMod> getAll(int page) {
		Pageable pageable = PageRequest.of(page - 1, max);
		return (tecInfoReqLibelleRepository.findAll(pageable).getContent());
	}
	

	@Override
	public void delete(TecInfoReqLibelleMod a) {
		tecInfoReqLibelleRepository.delete(a);
	}
	
	@Override
	public int nombrepage() {
		return (int)(tecInfoReqLibelleRepository.count()/max)+1;
	}

	@Override
	public List<TecInfoReqLibelleMod> findInfoReqByIdDemande(String id) {
		return tecInfoReqLibelleRepository.findInfoReqByIdDemande(id);
	}

}
