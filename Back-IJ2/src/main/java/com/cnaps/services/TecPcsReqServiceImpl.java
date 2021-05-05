package com.cnaps.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cnaps.models.TecPcsReqMod;
import com.cnaps.models.TecPcsReqPK;
import com.cnaps.repository.TecPcsReqRepository;

@Service
public class TecPcsReqServiceImpl implements TecPcsReqService{

	public static int max=50;
	
	@Autowired
	private TecPcsReqRepository tecPcsReqRepository;

	@Override
	public void save(TecPcsReqMod entity) {
		tecPcsReqRepository.save(entity);
	}

	@Override
	public TecPcsReqMod getById(Serializable id) {
		return tecPcsReqRepository.findById((TecPcsReqPK)id).get();
	}

	@Override
	public List<TecPcsReqMod> getAll(int page) {
		Pageable pageable = PageRequest.of(page - 1, max);
		return (tecPcsReqRepository.findAll(pageable).getContent());
	}

	@Override
	public void delete(TecPcsReqMod a) {
		tecPcsReqRepository.delete(a);
	}
	
	@Override
	public int nombrepage() {
		return (int)(tecPcsReqRepository.count()/max)+1;
	}

}
