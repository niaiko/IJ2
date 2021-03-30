package com.cnaps.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cnaps.models.RefTecParamTypMod;

import com.cnaps.repository.RefTecParamTypRepository;

@Service
public class RefTecParamTypServiceImpl implements  RefTecParamTypService{

public static int max=50;
	
	@Autowired
	private RefTecParamTypRepository refTecParamTypRepository;

	@Override
	public RefTecParamTypMod getById(Serializable id) {
		return refTecParamTypRepository.getOne((int) id);
	}

	@Override
	public List<RefTecParamTypMod> getAll(int page) {
		Pageable pageable = PageRequest.of(page - 1, max);
		return (refTecParamTypRepository.findAll(pageable).getContent());
	}

	@Override
	public void delete(RefTecParamTypMod entity) {
		refTecParamTypRepository.delete(entity);
		
	}

	@Override
	public int nombrepage() {
		return (int)(refTecParamTypRepository.count()/max)+1;
	}

	@Override
	public void save(RefTecParamTypMod acc) {
		refTecParamTypRepository.save(acc);
	}
}
