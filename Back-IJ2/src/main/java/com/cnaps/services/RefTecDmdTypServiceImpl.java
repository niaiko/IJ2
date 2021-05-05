package com.cnaps.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cnaps.models.RefTecDmdTypMod;

import com.cnaps.repository.RefTecDmdTypRepository;

@Service
public class RefTecDmdTypServiceImpl implements  RefTecDmdTypService{

public static int max=50;
	
	@Autowired
	private RefTecDmdTypRepository refTecDmdTypRepository;

	@Override
	public RefTecDmdTypMod getById(Serializable id) {
		return refTecDmdTypRepository.findById((int)id).get();
	}

	@Override
	public List<RefTecDmdTypMod> getAll(int page) {
		Pageable pageable = PageRequest.of(page - 1, max);
		return (refTecDmdTypRepository.findAll(pageable).getContent());
	}

	@Override
	public void delete(RefTecDmdTypMod entity) {
		refTecDmdTypRepository.delete(entity);
		
	}

	@Override
	public int nombrepage() {
		return (int)(refTecDmdTypRepository.count()/max)+1;
	}

	@Override
	public void save(RefTecDmdTypMod acc) {
		refTecDmdTypRepository.save(acc);
	}
}
