package com.cnaps.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cnaps.models.RefEtatTypMod;
import com.cnaps.repository.RefEtatTypRepository;

@Service
public class RefEtatTypServiceImpl implements  RefEtatTypService{

public static int max=50;
	
	@Autowired
	private RefEtatTypRepository refEtatTypRepository;

	@Override
	public RefEtatTypMod getById(Serializable id) {
		return refEtatTypRepository.getOne((int) id);
	}

	@Override
	public List<RefEtatTypMod> getAll(int page) {
		Pageable pageable = PageRequest.of(page - 1, max);
		return (refEtatTypRepository.findAll(pageable).getContent());
	}

	@Override
	public void delete(RefEtatTypMod entity) {
		refEtatTypRepository.delete(entity);
		
	}

	@Override
	public int nombrepage() {
		return (int)(refEtatTypRepository.count()/max)+1;
	}

	@Override
	public void save(RefEtatTypMod acc) {
		refEtatTypRepository.save(acc);
	}

	@Override
	public RefEtatTypMod getByIdTypeEtat(Integer idTypeEtat) {
		return refEtatTypRepository.findByIdTypeEtat(idTypeEtat);
	}
}
