package com.cnaps.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cnaps.models.TecPcsReqLibelleMod;

import com.cnaps.repository.TecPcsReqLibelleRepository;

@Service
public class TecPcsReqLibelleServiceImpl implements  TecPcsReqLibelleService{

	public static int max=50;
	
	@Autowired
	private TecPcsReqLibelleRepository tecPcsReqLibelleRepository;

	@Override
	public void save(TecPcsReqLibelleMod entity) {
		tecPcsReqLibelleRepository.save(entity);
	}

	@Override
	public TecPcsReqLibelleMod getById(Serializable id) {
		return tecPcsReqLibelleRepository.findById((String)id).get();
	}

	@Override
	public List<TecPcsReqLibelleMod> getAll(int page) {
		Pageable pageable = PageRequest.of(page - 1, max);
		return (tecPcsReqLibelleRepository.findAll(pageable).getContent());
	}
	

	@Override
	public void delete(TecPcsReqLibelleMod a) {
		tecPcsReqLibelleRepository.delete(a);
	}
	
	@Override
	public int nombrepage() {
		return (int)(tecPcsReqLibelleRepository.count()/max)+1;
	}

	
	
	@Override
	public List<TecPcsReqLibelleMod> findPieceReqByIdDemande(String id) {
		
		return tecPcsReqLibelleRepository.findPieceReqByIdDemande(id);
	}

	@Override
	public List<TecPcsReqLibelleMod> findPiecePension() {
		return tecPcsReqLibelleRepository.findPiecePension();
	}

}
