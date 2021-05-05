package com.cnaps.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cnaps.models.TecPcsRecMod;

import com.cnaps.repository.TecPcsRecRepository;


@Service
public class TecPcsRecServiceImpl implements TecPcsRecService{

	public static int max=50;
	
	@Autowired
	private TecPcsRecRepository tecPcsRecRepository;

	@Override
	public void save(TecPcsRecMod entity) {
		tecPcsRecRepository.save(entity);
	}

	@Override
	public TecPcsRecMod getById(Serializable id) {
		return tecPcsRecRepository.findById((String)id).get();
	}

	@Override
	public List<TecPcsRecMod> getAll(int page) {
		Pageable pageable = PageRequest.of(page - 1, max);
		return (tecPcsRecRepository.findAll(pageable).getContent());
	}

	@Override
	public void delete(TecPcsRecMod a) {
		tecPcsRecRepository.delete(a);
	}
	
	@Override
	public int nombrepage() {
		return (int)(tecPcsRecRepository.count()/max)+1;
	}

	@Override
	public void save(List<TecPcsRecMod> tecPcsRecuList) {
		
		tecPcsRecRepository.saveAll(tecPcsRecuList);
	}

	@Override
	public List<TecPcsRecMod> findByIdAccueil(String id_acc) {
		return tecPcsRecRepository.findByIdAccueil(id_acc);
	}

}
