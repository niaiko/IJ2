package com.cnaps.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cnaps.models.ParametrePfMod;
import com.cnaps.repository.ParametrePfRepository;



@Service
public class ParametrePfServiceImpl implements  ParametrePfService{

	public static int max=50;
	
	@Autowired
	private ParametrePfRepository parametrePfRepository;

	@Override
	public void save(ParametrePfMod entity) {
		parametrePfRepository.save(entity);
	}

	@Override
	public ParametrePfMod getById(Serializable id) {
		return parametrePfRepository.findById((int)id).get();
	}

	@Override
	public List<ParametrePfMod> getAll(int page) {
		Pageable pageable = PageRequest.of(page -1, max);
		return (parametrePfRepository.findAll(pageable ).getContent());
	}

	@Override
	public void delete(ParametrePfMod a) {
		parametrePfRepository.delete(a);
	}
	
	@Override
	public int nombrepage() {
		return (int)(parametrePfRepository.count()/max)+1;
	}

	@Override
	public List<ParametrePfMod> getByParamPf(int param_pf) {
		Pageable pageable = PageRequest.of(0,max,Sort.Direction.DESC,"date_application");
		return parametrePfRepository.findByParamPf(param_pf, pageable);
	}

}
