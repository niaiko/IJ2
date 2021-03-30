package com.cnaps.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cnaps.models.TecPcsMod;
import com.cnaps.repository.TecPcsRepository;

@Service
public class TecPcsServiceImpl implements  TecPcsService{

	public static int max=50;
	
	@Autowired
	private TecPcsRepository tecPcsRepository;

	@Override
	public void save(TecPcsMod entity) {
		tecPcsRepository.save(entity);
	}

	@Override
	public TecPcsMod getById(Serializable id) {
		return tecPcsRepository.findById((String)id).get();
	}

	@Override
	public List<TecPcsMod> getAll(int page) {
		Pageable pageable = PageRequest.of(page - 1, max);
		return (tecPcsRepository.findAll(pageable).getContent());
	}

	@Override
	public void delete(TecPcsMod a) {
		tecPcsRepository.delete(a);
	}
	
	@Override
	public int nombrepage() {
		return (int)(tecPcsRepository.count()/max)+1;
	}

}
