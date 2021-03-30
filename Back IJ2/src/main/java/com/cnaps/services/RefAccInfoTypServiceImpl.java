package com.cnaps.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cnaps.models.RefAccInfoTypMod;
import com.cnaps.repository.RefAccInfoTypRepository;

@Service
public class RefAccInfoTypServiceImpl implements  RefAccInfoTypService{

public static int max=50;
	
	private RefAccInfoTypRepository refAccInfoTypRepository;

	@Override
	public RefAccInfoTypMod getById(Serializable id) {
		return refAccInfoTypRepository.getOne((int) id);
	}

	@Override
	public List<RefAccInfoTypMod> getAll(int page) {
		Pageable pageable = PageRequest.of(page -1, max);
		return (refAccInfoTypRepository.findAll(pageable).getContent());
	}

	@Override
	public void delete(RefAccInfoTypMod entity) {
		refAccInfoTypRepository.delete(entity);
		
	}

	@Override
	public int nombrepage() {
		return (int)(refAccInfoTypRepository.count()/max)+1;
	}

	@Override
	public void save(RefAccInfoTypMod acc) {
		refAccInfoTypRepository.save(acc);
	}

	@Override
	public RefAccInfoTypMod getByAbbrev(String abrev) {
		return refAccInfoTypRepository.findByAbbrev(abrev);
	}

	@Override
	public RefAccInfoTypMod getById_type_info(int id_type_info) {
		// TODO Auto-generated method stub
		return refAccInfoTypRepository.findById_type_info(id_type_info);
	}
}
